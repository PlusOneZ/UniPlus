package cn.edu.tongji.uniplus.good_information.service;

import org.springframework.stereotype.Service;

@Service
public interface PlaceOrderService {

    Boolean tryPlaceOrder(Long userId, Long goodId, int amount);

    Boolean checkGoodStock(Long goodId, int amount);

    void resumeStock(Long goodId, int amount);
}
