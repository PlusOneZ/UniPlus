package cn.edu.tongji.uniplus.user.service.exception;

/**
 * AliyunSmsCodeException
 *
 * @author 卓正一
 * @since 2021/12/6 9:01 PM
 */
public class ThirdPartyRequestException extends RuntimeException {
    public ThirdPartyRequestException() {
        super("External API error.");
    }
}
