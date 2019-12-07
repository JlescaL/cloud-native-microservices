/*
 * Copyright (c) 2019 MasterCard. All rights reserved.
 */

package com.crystalark.userservice.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private String address;
    private String contact;
    private String role;
}