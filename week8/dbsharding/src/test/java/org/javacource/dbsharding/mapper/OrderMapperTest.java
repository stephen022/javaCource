package org.javacource.dbsharding.mapper;

import com.zaxxer.hikari.HikariDataSource;
import org.javacource.dbsharding.entity.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@MapperScan("org.javacource.dbsharding.mapper")
public class OrderMapperTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test @Transactional
    public void test() throws SQLException {

        orderMapper.insertOne(new Order(1L, 1L));
        orderMapper.insertOne(new Order(2L, 2L));

        Map<String, Object> condition = new HashMap<>(1);
        condition.put("id", 1L);

        List<Order> orderQuery = orderMapper.query(condition);
        assert orderQuery.size() == 1;
        for (Order order: orderQuery) {
            System.out.println(order.toString());
        }

        condition = new HashMap<>(1);
        condition.put("userId", 1L);
        orderQuery = orderMapper.query(condition);
        assert orderQuery.size() == 1;
        for (Order order: orderQuery) {
            System.out.println(order.toString());
        }

        condition = new HashMap<>(2);
        condition.put("id", 2L);
        condition.put("userId", 2L);
        orderQuery = orderMapper.query(condition);
        assert orderQuery.size() == 1;
        for (Order order: orderQuery) {
            System.out.println(order.toString());
        }
    }
}
