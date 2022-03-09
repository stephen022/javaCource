package org.javacource.rpcdemo.service.impl;

import org.javacource.rpcdemo.exception.CustomException;
import org.javacource.rpcdemo.model.Order;
import org.javacource.rpcdemo.service.OrderService;

/**
 *
 */
public class OrderServiceImpl implements OrderService {

    @Override
    public Order findById(Integer id) {
        return new Order(1, "RPC", 1);
    }

    @Override
    public Order findError() {
        throw new CustomException("Custom exception");
    }
}
