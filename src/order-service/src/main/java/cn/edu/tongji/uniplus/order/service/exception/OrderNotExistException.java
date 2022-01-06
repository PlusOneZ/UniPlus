package cn.edu.tongji.uniplus.order.service.exception;

/**
 * OrderNotExistException
 *
 * @author 卓正一
 * @since 2021/12/30 2:55 PM
 */
public class OrderNotExistException extends RuntimeException{
    public OrderNotExistException() {
        super("Order not exists");
    }
}
