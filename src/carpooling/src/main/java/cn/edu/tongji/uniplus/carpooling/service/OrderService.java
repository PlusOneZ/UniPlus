package cn.edu.tongji.uniplus.carpooling.service;

import cn.edu.tongji.uniplus.carpooling.model.OrderGroupEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @author tangshuo
 * @version 1.0.0
 * @ClassName OrderService.java
 * @Description TODO
 * @createTime 2021年12月29日 17:37:00
 */
@Service
public interface OrderService {

    boolean createOrder(String orderName, Long ownerId, Integer price) throws IOException;

    boolean invite2Order(String orderId, Long memberId) throws IOException;

    boolean quiteOrder(String orderId) throws IOException;

    List<OrderGroupEntity> getOrders(String destination);
}
