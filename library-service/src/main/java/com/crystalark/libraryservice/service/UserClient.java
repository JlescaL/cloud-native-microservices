package com.crystalark.libraryservice.service;

import com.crystalark.domain.UserBaseDTO;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@FeignClient("api-gateway")
@RibbonClient("user-service")
public interface UserClient {

    @GetMapping({ "user-service/env" })
    public ResponseEntity<String> getEnvironment();

    @GetMapping({ "user-service/users" })
    public ResponseEntity<Object> getAllUsers();

    @PostMapping("user-service/users")
    public ResponseEntity<Object> addUserToLibrary(@Valid @RequestBody UserBaseDTO user);

    @GetMapping(value = "user-service/users/{id}")
    public ResponseEntity<Object> getUsersById(@PathVariable long id);

    @PutMapping("user-service/users/{id}")
    public ResponseEntity<Object> updateUser(@Valid @RequestBody UserBaseDTO user, @PathVariable("id") long id);
}