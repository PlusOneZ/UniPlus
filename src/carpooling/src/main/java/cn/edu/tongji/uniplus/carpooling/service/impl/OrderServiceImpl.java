package cn.edu.tongji.uniplus.carpooling.service.impl;

import cn.edu.tongji.uniplus.carpooling.model.OrderGroupEntity;
import cn.edu.tongji.uniplus.carpooling.model.OrderMemberEntity;
import cn.edu.tongji.uniplus.carpooling.repository.OrderGroupRepository;
import cn.edu.tongji.uniplus.carpooling.repository.OrderMemberRepository;
import cn.edu.tongji.uniplus.carpooling.model.OrderEntity;
import cn.edu.tongji.uniplus.carpooling.service.OrderService;
import cn.edu.tongji.uniplus.carpooling.util.RequestUtil;
import com.github.yitter.idgen.YitIdHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * @author tangshuo
 * @version 1.0.0
 * @ClassName OrderServiceImpl.java
 * @Description TODO
 * @createTime 2021年12月29日 21:33:00
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderGroupRepository orderRepository;

    @Resource
    OrderMemberRepository orderMemberRepository;

    @Resource
    RequestUtil requestUtil;

    @Override
    public boolean createOrder(String orderName,Long ownerId,Integer price) throws IOException {
        String msg = "欢迎加入" + orderName;
        String orderId = requestUtil.creatOrderGroup(orderName,ownerId.toString(),msg);
        if(!Objects.equals(orderId, "failed")){
            OrderGroupEntity orderEntity = new OrderGroupEntity();
            orderEntity.setOrderId(orderId);
            orderEntity.setOwnerId(ownerId);
            orderEntity.setMsg(msg);
            orderEntity.setOrderName(orderName);
            orderEntity.setPrice(price);
            orderRepository.save(orderEntity);
            return true;
        }
        return false;
    }

    @Override
    public boolean invite2Order(String orderId,Long memberId) throws IOException {
        OrderGroupEntity orderEntity = orderRepository.findOrderEntityByOrderId(orderId);
        if(requestUtil.invite2Group(orderId,orderEntity.getOwnerId().toString(),orderEntity.getMsg(),memberId.toString())){
            OrderMemberEntity orderMemberEntity = new OrderMemberEntity();
            orderMemberEntity.setOrderId(orderId);
            orderMemberEntity.setMemberId(memberId);
            orderMemberEntity.setId(YitIdHelper.nextId());
            orderMemberRepository.save(orderMemberEntity);
            return true;
        }
        return false;
    }

    @Override
    public boolean quiteOrder(String orderId) throws IOException {
        OrderGroupEntity orderEntity = orderRepository.findOrderEntityByOrderId(orderId);
        if(requestUtil.dismissGroup(orderId,orderEntity.getOwnerId().toString())){
            List<OrderMemberEntity> orderMemberEntityList = orderMemberRepository.findOrderMemberEntitiesByOrderId(orderId);
            orderMemberRepository.deleteAll(orderMemberEntityList);
            return true;
        }
        return false;
    }
}
