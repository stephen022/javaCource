package org.javacource.rpcdemo.service;

import org.javacource.rpcdemo.model.User;

/**
 *
 */
public interface UserService {

    /**
     * find by id
     * @param id id
     * @return user
     */
    User findById(Integer id);
}
