/*
 * Copyright (c) 2019 MasterCard. All rights reserved.
 */

package com.crystalark.userservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final Contact AUTHOR_CONTACT = new Contact("Ajay Kumar Rabidas",
            "https://bitbucket.org/crystalark/KumaarJai", "ajay_rabidas@epam.com");
    public static final HashSet<String> PRODUCES_CONSUMES = new HashSet<String>(Arrays.asList("application/json"));

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiMetaData()).produces(PRODUCES_CONSUMES)
                .consumes(PRODUCES_CONSUMES);
    }

    private ApiInfo apiMetaData() {
        ApiInfo apiInfo;
        apiInfo = new ApiInfo("User Service",
                "User service is one of multiple microservices in EPAM JPOP program. It provides CRUD features for a User",
                "1.0", "urn:tos", AUTHOR_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>());
        return apiInfo;
    }
}
