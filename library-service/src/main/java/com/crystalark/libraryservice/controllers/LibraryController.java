package com.crystalark.libraryservice.controllers;

import com.crystalark.domain.BookBaseDTO;
import com.crystalark.domain.UserBaseDTO;
import com.crystalark.libraryservice.service.BookClient;
import com.crystalark.libraryservice.service.LibraryService;
import com.crystalark.libraryservice.service.UserClient;
import com.crystalark.libraryservice.utils.ConfigProperties;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/v1/libApi")
@RestController
public final class LibraryController {

    private ConfigProperties prop;
    private BookClient bookProxy;
    private UserClient userProxy;

    @Autowired
    public LibraryController(ConfigProperties config, BookClient b, UserClient u) {
        this.prop = config;
        this.bookProxy = b;
        this.userProxy = u;
    }

    @ApiOperation(value = "Get library-service instance environment details", response = String.class)
    @GetMapping({"/env"})
    public ResponseEntity<String> getEnvironment() {
        return new ResponseEntity<>(this.prop.getEnv(), HttpStatus.OK);
    }

    @ApiOperation(value = "View a list of available users", response = UserBaseDTO[].class)
    @GetMapping({"/users"})
    public ResponseEntity<Object> getAllUsers() {
        return new ResponseEntity<>(userProxy.getAllUsers(), HttpStatus.OK);
    }

    @ApiOperation(value = "View a list of available books", response = BookBaseDTO[].class)
    @GetMapping({"/books"})
    public ResponseEntity<Object> getAllBooks() {
        return new ResponseEntity<>(bookProxy.getAllBooks(), HttpStatus.OK);
    }
}