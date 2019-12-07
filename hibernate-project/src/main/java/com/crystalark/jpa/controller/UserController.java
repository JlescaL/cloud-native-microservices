/*
 * Copyright (c) 2019 MasterCard. All rights reserved.
 */

package com.crystalark.jpa.controller;

import com.crystalark.jpa.Model.User;
import com.crystalark.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class UserController {

    @Autowired
    UserService service;

    @PostMapping(path = "/user")
    public User addUser(@RequestParam User user){
        return service.saveUser(user);
    }
}