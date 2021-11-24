package cn.edu.tongji.uniplus.user.controller.handler;

import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * GlobalExceptionHandler
 * 通过 SaResult 来拦截这个服务所有的异常，TODO：有针对的放开约束。
 *
 * @author 卓正一
 * @since 2021/11/24 4:45 PM
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    // 全局异常拦截
    @ExceptionHandler
    public SaResult handlerException(Exception e) {
        e.printStackTrace();
        return SaResult.error(e.getMessage());
    }
}
