/*
 * Copyright (c) 2019 MasterCard. All rights reserved.
 */

package com.crystalark.bookservice.DAO;

import com.crystalark.bookservice.models.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookDao extends CrudRepository<Book, Long> {
    Optional<List<Book>> findByCategory(String category);

    Optional<List<Book>> findByBookName(String name);

    Optional<Book> findByBookNameAndCategory(String bookName, String cat);

    @Transactional
    @Query("select u.mrp from Book u where u.bookName = :bookName and u.category = :category")
    double findPriceOfBookByBookNameAndCategory(@Param("bookName") String bookName, @Param("category") String category);
}
