package org.javacource.rpcdemo.service;

import org.javacource.rpcdemo.model.Order;

/**
 *
 */
public interface OrderService {

    /**
     * find by id
     * @param id id
     * @return order
     */
    Order findById(Integer id);

    /**
     * return exception
     * @return exception
     */
    Order findError();
}
