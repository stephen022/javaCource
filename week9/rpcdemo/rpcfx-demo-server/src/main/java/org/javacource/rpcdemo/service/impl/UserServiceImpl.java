package org.javacource.rpcdemo.service.impl;

import org.javacource.rpcdemo.model.User;
import org.javacource.rpcdemo.service.UserService;

/**
 *
 */
public class UserServiceImpl implements UserService {

    @Override
    public User findById(Integer id) {
        return new User(id, "RPC");
    }
}
