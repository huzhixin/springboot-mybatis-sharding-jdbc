package com.cto001.qnzsopen.service;

/**
 * Created by huzhixin on 2017/6/28.
 */
import com.cto001.qnzsopen.entity.Order;
import com.cto001.qnzsopen.repository.OrderRepository;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class OrderService {
    @Resource
    private OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public void select() {
        System.out.println(orderRepository.selectAll());
    }

    public void clear() {
        orderRepository.deleteAll();
    }

    public void fooService() {
        Order criteria = new Order();
        criteria.setOrderId(1);
        criteria.setUserId(10);
        criteria.setStatus("INSERT");
        orderRepository.insert(criteria);
        System.out.println(criteria.getOrderId());
        criteria.setUserId(11);
        criteria.setStatus("INSERT2");
        orderRepository.insert(criteria);
        System.out.println(criteria.getOrderId());
        //orderRepository.update(Lists.newArrayList(10, 11));
    }

    public void fooServiceWithFailure() {
        fooService();
        throw new IllegalArgumentException("failed");
    }
}
