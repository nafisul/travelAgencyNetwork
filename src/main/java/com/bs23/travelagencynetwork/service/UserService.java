package com.bs23.travelagencynetwork.service;

import com.bs23.travelagencynetwork.entity.User;

public interface UserService {
    void save(User user);
    User findByEmail(String email);
}
