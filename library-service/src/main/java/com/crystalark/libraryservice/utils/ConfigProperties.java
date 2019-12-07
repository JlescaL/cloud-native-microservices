package com.crystalark.libraryservice.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("library-service")
public class ConfigProperties {
    private String env;
    private String bookServiceAPIKEY;

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
