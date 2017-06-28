package com.cto001.qnzsopen.repository;

/**
 * Created by huzhixin on 2017/6/28.
 */
import java.util.List;
import com.cto001.qnzsopen.entity.Order;

public interface OrderRepository {
    void insert(Order model);

    int update(List<Integer> userIds);

    int deleteAll();

    List<Order> selectAll();
}
