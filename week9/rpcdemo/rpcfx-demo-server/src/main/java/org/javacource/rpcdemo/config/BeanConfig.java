package org.javacource.rpcdemo.config;

import org.javacource.rpcdemo.service.OrderService;
import org.javacource.rpcdemo.service.UserService;
import org.javacource.rpcdemo.service.impl.OrderServiceImpl;
import org.javacource.rpcdemo.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置接口的实现类
 *
 *
 */
@Configuration
public class BeanConfig {

    @Bean("org.javacource.rpcdemo.service.UserService")
    public UserService userService() {
        return new UserServiceImpl();
    }

    @Bean("org.javacource.rpcdemo.service.OrderService")
    public OrderService orderService() {
        return new OrderServiceImpl();
    }
}
