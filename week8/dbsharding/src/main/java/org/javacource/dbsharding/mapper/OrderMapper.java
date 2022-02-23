package org.javacource.dbsharding.mapper;

import org.javacource.dbsharding.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface OrderMapper {

    void insertOne(Order order);
    void insertList(List<Order> orders);
    void delete(Long id);
    void update(Order order);
    List<Order> query(Map<String, Object> condition);
}
