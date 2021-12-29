package cn.edu.tongji.uniplus.good_information.service.exception;

/**
 * GoodsNotExistException
 *
 * @author 卓正一
 * @since 2021/12/29 10:33 PM
 */
public class GoodsNotExistException extends RuntimeException{
    public GoodsNotExistException() {
        super("No such goods in stock");
    }
}
