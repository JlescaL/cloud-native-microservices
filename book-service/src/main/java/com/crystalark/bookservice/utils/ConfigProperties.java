/*
 * Copyright (c) 2019 MasterCard. All rights reserved.
 */

package com.crystalark.bookservice.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("book-service")
public class ConfigProperties {
    private String env;
    private String userServiceUrl;
    private String bookServiceAPIKEY;

    public String getReviewServiceUrl() {
        return userServiceUrl;
    }

    public void setReviewServiceUrl(String reviewServiceUrl) {
        this.userServiceUrl = reviewServiceUrl;
    }

    public ConfigProperties() {
    }

    public String getBookServiceAPIKEY() {
        return bookServiceAPIKEY;
    }

    public void setBookServiceAPIKEY(String bookServiceAPIKEY) {
        this.bookServiceAPIKEY = bookServiceAPIKEY;
    }

    public String getEnv() {
        return this.env;
    }

    public void setEnv(String env) {
        this.env = env;
    }
}
