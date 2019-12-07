package com.crystalark.jpa.service;

import com.crystalark.jpa.Model.User;
import com.crystalark.jpa.dao.UserRepository;
import org.springframework.stereotype.Service;

@Service
public final class UserService {

    private UserRepository dao;
    UserService(UserRepository dao){
        this.dao = dao;
    }

    public User saveUser(User user){
        return dao.save(user);
    }
}