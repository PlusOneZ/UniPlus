package
        cn.edu.tongji.uniplus.payment.controller;


import cn.edu.tongji.uniplus.payment.dto.OrderPaymentInfo;
import cn.edu.tongji.uniplus.payment.service.PaymentService;
import com.alipay.api.AlipayApiException;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * The controller contains payment APIs...
 *
 * @author : loey
 * @className : PaymentController
 * @since : 2021-11-24 18:21
 **/
@RestController
@RequestMapping("api/v1")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(value = "payment", method = RequestMethod.POST)
    public String alipayForOrder(@RequestBody OrderPaymentInfo orderPaymentInfo) throws AlipayApiException {

        AlipayTradePagePayResponse response = paymentService.payForOrderService(orderPaymentInfo);
        if (response.isSuccess()) {
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
        return response.getBody();
    }

    @RequestMapping(value = "refund", method = RequestMethod.POST)
    public String refundOrder(@RequestBody OrderPaymentInfo orderPaymentInfo) throws AlipayApiException {

        AlipayTradeRefundResponse response = paymentService.refundForOrderService(orderPaymentInfo);

        if (response.isSuccess()) {
            System.out.println("退款成功");
        } else {
            System.out.println("退款失败");
        }
        return response.getBody();
    }

    @RequestMapping(value = "payment/notify",method = RequestMethod.POST)
    public ResponseEntity<String> notifyOrder(HttpServletRequest httpServletRequest) throws AlipayApiException {

        System.out.println("收到了回调内容!");

        Map<String, String[]> requestParams = httpServletRequest.getParameterMap();
        String result = paymentService.orderNotify(requestParams);
        // 验签通过
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}