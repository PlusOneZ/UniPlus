package cn.edu.tongji.uniplus.user.service.impl;

import cn.edu.tongji.uniplus.user.model.UserEntity;
import cn.edu.tongji.uniplus.user.model.UserResidentInformationEntity;
import cn.edu.tongji.uniplus.user.payload.IdVerificationResult;
import cn.edu.tongji.uniplus.user.payload.UserForQueue;
import cn.edu.tongji.uniplus.user.repository.UserRepository;
import cn.edu.tongji.uniplus.user.repository.UserResidentInformationRepository;
import cn.edu.tongji.uniplus.user.service.IdVerificationService;
import cn.edu.tongji.uniplus.user.service.SignupService;
import cn.edu.tongji.uniplus.user.service.exception.DataFormatException;
import cn.edu.tongji.uniplus.user.service.exception.UserAlreadyExistsException;
import cn.edu.tongji.uniplus.user.service.exception.UserNotExistException;
import com.github.yitter.idgen.YitIdHelper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * SignupServiceImpl
 *
 * @author 卓正一
 * @since 2021/12/1 4:30 PM
 */
@Service
public class SignupServiceImpl implements SignupService {

    @Resource
    UserRepository userRepository;

    @Resource
    RabbitTemplate rabbitTemplate;

    @Resource
    UserResidentInformationRepository userResidentInformationRepository;

    @Resource
    IdVerificationService idVerificationService;

    private static final int CN_PHONE_LENGTH = 11;

    @Override
    public Boolean checkPhoneAvailable(String phone) {
        return userRepository.findByUserPhone(phone).isEmpty();
    }

    @Override
    public void changeUserPassword(String phone, String newPassword) {
        Optional<UserEntity> userEntityOptional = userRepository.findByUserPhone(phone);
        if (userEntityOptional.isPresent()) {
            UserEntity user = userEntityOptional.get();
            user.setUserPassword(DigestUtils.md5DigestAsHex(newPassword.getBytes()));
            userRepository.save(user);
        } else {
            throw new UserNotExistException();
        }
    }

    @Override
    public void changeUserPassword(Long userId, String newPassword) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(userId);
        if (userEntityOptional.isPresent()) {
            UserEntity user = userEntityOptional.get();
            user.setUserPassword(DigestUtils.md5DigestAsHex(newPassword.getBytes()));
            userRepository.save(user);
        } else {
            throw new UserNotExistException();
        }
    }

    @Override
    public IdVerificationResult idVerification(String base64img) {
        IdVerificationResult result = idVerificationService.verifyIdImage(base64img);

        // check if duplicated
        if (!result.getTrueID().isEmpty()) {
            Optional<UserResidentInformationEntity> info = userResidentInformationRepository.findByResidentId(result.getTrueID());
            if (info.isPresent()) {
                result.setVerifyResult(2);
            }
        }
        return result;
    }

    @Override
    public Long userSignup(Integer phoneCode, String phone, String password, String username, String token) {
        return userSignup(phoneCode, phone, password, username, null, token);
    }

    @Override
    public Long userSignup(Integer phoneCode, String phone, String password, String username, @Nullable Integer gender, String token) {
        if (!checkPhoneAvailable(phone)) {
            // 已经有这个用户了
            throw new UserAlreadyExistsException();
        }

        if (phone.length() != 11) {
            throw new DataFormatException();
        } else {
            try {
                Long.parseLong(phone);
            } catch (NumberFormatException e) {
                throw new DataFormatException();
            }
        }

        UserEntity user = new UserEntity();

        user.setUserId(YitIdHelper.nextId());
        user.setUserPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        user.setUserNickName(username);
        user.setUserPhone(phone);
        user.setUserPhoneCode(phoneCode);
        user.setUserToken(token);
        if (gender != null)
            user.setUserGender(gender);

        UserForQueue forQueue = new UserForQueue(user.getUserId(), user.getUserNickName());
        userRepository.save(user);

        rabbitTemplate.convertAndSend("UserDirectExchange", "UserDirectRouting", forQueue.toMap());

        return user.getUserId();
    }

    @Override
    public void setUserGender(Long userId, Integer gender) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(userId);
        if (userEntityOptional.isPresent()) {
            UserEntity user = userEntityOptional.get();
            user.setUserGender(gender);
            userRepository.save(user);
        } else {
            throw new UserNotExistException();
        }
    }

    @Override
    public Boolean isPhoneValid(String phone) {
        if (phone.length() != CN_PHONE_LENGTH) {
            return false;
        }
        return phone.charAt(0) == '1' ||
                (phone.charAt(1) == '3'
                        && phone.charAt(1) == '5'
                        && phone.charAt(1) == '7'
                        && phone.charAt(1) == '9');
    }
}
