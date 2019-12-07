package com.crystalark.bookservice.controllers;

import com.crystalark.bookservice.DTO.BookDTO;
import com.crystalark.bookservice.service.BookService;
import com.crystalark.bookservice.utils.ConfigProperties;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/bookApi")
public final class BookController {

    private final ConfigProperties prop;
    private final BookService service;

    @Autowired
    public BookController(ConfigProperties config, BookService service) {
        this.prop = config;
        this.service = service;
    }

    @ApiOperation(value = "Get book-service instance environment details", response = String.class)
    @GetMapping({ "/env" })
    public ResponseEntity<String> getEnvironment() {

        return new ResponseEntity<>(this.prop.getEnv(), HttpStatus.OK);
    }

    @ApiOperation(value = "View a list of available books", response = BookDTO[].class)
    @GetMapping({ "/books" })
    public ResponseEntity<Object> getAllBooks() {
        return new ResponseEntity<>(service.getAllBooks(), HttpStatus.OK);
    }

    @ApiOperation(value = "Add a new book", response = BookDTO.class)
    @ApiResponses(value = { @ApiResponse(code = 201, message = "book successfully " + "added"),
            @ApiResponse(code = 400, message = "Bad request: Rejected invalid Book creation. Please check the Book details you entered"), })
    @PostMapping("/books")
    public ResponseEntity<Object> addBookToLibrary(@Valid @RequestBody BookDTO book) {
        BookDTO savedBook = service.saveBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @ApiOperation(value = "View details of a book", response = BookDTO.class)
    @GetMapping(value = "/books/{id}")
    public ResponseEntity<Object> getBooksById(@PathVariable long id) {
        BookDTO book = service.getBookById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @ApiOperation(value = "Update a book", response = BookDTO.class)
    @ApiResponses(value = { @ApiResponse(code = 201, message = "book successfully added"),
            @ApiResponse(code = 400, message = "Bad request: Rejected invalid Book creation. Please check the Book details you entered"), })
    @PutMapping("/books/{id}")
    public ResponseEntity<Object> updateBook(@Valid @RequestBody BookDTO book, @PathVariable("id") long id) {
        BookDTO updatedBook = service.updateBook(book, id);
        return new ResponseEntity<>(updatedBook, HttpStatus.CREATED);
    }

    public String getHomePage() {
        return "/api/env";
    }
}