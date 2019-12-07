/*
 * Copyright (c) 2019 MasterCard. All rights reserved.
 */

package com.crystalark.userservice.Exceptions;

public final class UserNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UserNotFoundException(String message) {
        super(message);
    }
}