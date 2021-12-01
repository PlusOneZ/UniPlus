package cn.edu.tongji.uniplus.user.service.exception;

/**
 * UserAlreadyExists
 *
 * @author 卓正一
 * @since 2021/11/23 8:48 PM
 */
public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException() {
        super("User already exists!");
    }
}
