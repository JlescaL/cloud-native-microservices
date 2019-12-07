package com.crystalark.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LibraryEurekaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryEurekaServiceApplication.class, args);
    }

}
