package com.crystalark.bookservice.Exceptions;

public final class BookNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BookNotFoundException(String message) {
        super(message);
    }
}