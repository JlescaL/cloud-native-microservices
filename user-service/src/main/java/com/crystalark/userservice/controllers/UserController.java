/*
 * Copyright (c) 2019 MasterCard. All rights reserved.
 */

package com.crystalark.userservice.controllers;

import com.crystalark.userservice.DTO.UserDTO;
import com.crystalark.userservice.service.UserService;
import com.crystalark.userservice.utils.ConfigProperties;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/userApi")
public final class UserController {

    private final ConfigProperties prop;
    private final UserService service;

    @Autowired
    public UserController(ConfigProperties config, UserService service) {
        this.prop = config;
        this.service = service;
    }

    @ApiOperation(value = "Get user-service instance environment details", response = String.class)
    @GetMapping({ "/env" })
    public ResponseEntity<String> getEnvironment() {
        return new ResponseEntity<>(this.prop.getEnv(), HttpStatus.OK);
    }

    @ApiOperation(value = "View a list of available users", response = UserDTO[].class)
    @GetMapping({ "/users" })
    public ResponseEntity<Object> getAllUsers() {
        return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
    }

    @ApiOperation(value = "Add a new user", response = UserDTO.class)
    @ApiResponses(value = { @ApiResponse(code = 201, message = "user successfully added"),
            @ApiResponse(code = 400, message = "Bad request: Rejected invalid User creation. Please check the User details you entered"), })
    @PostMapping("/users")
    public ResponseEntity<Object> addUserToLibrary(@Valid @RequestBody UserDTO user) {
        UserDTO savedUser = service.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @ApiOperation(value = "View details of a user", response = UserDTO.class)
    @GetMapping(value = "/users/{id}")
    public ResponseEntity<Object> getUsersById(@PathVariable long id) {
        UserDTO user = service.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @ApiOperation(value = "Update a user", response = UserDTO.class)
    @ApiResponses(value = { @ApiResponse(code = 201, message = "user successfully added"),
            @ApiResponse(code = 400, message = "Bad request: Rejected invalid User creation. Please check the User details you entered"), })
    @PutMapping("/users/{id}")
    public ResponseEntity<Object> updateUser(@Valid @RequestBody UserDTO user, @PathVariable("id") long id) {
        UserDTO updatedUser = service.updateUser(user, id);
        return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
    }

    public String getHomePage() {
        return "/api/env";
    }
}