package com.cto001.qnzsopen.entity;

/**
 * Created by huzhixin on 2017/6/28.
 */
public class Order {
    private Integer orderId;

    private Integer userId;

    private String status;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(final Integer orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(final Integer userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("order_id: %s, user_id: %s, status: %s", orderId, userId, status);
    }
}
