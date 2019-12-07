package com.crystalark.libraryservice.service;

import com.crystalark.domain.BookBaseDTO;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@FeignClient(value = "api-gateway", contextId = "book-service")
@RibbonClient("book-service")
public interface BookClient {

    @GetMapping({ "book-service/env" })
    public ResponseEntity<String> getEnvironment();

    @GetMapping({ "book-service/books" })
    public ResponseEntity<Object> getAllBooks();

    @PostMapping("book-service/books")
    public ResponseEntity<Object> addBookToLibrary(@Valid @RequestBody BookBaseDTO book);

    @GetMapping(value = "book-service/books/{id}")
    public ResponseEntity<Object> getBooksById(@PathVariable long id);

    @PutMapping("book-service/books/{id}")
    public ResponseEntity<Object> updateBook(@Valid @RequestBody BookBaseDTO book, @PathVariable("id") long id);
}