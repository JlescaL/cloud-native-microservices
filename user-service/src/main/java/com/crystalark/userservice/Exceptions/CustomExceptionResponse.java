/*
 * Copyright (c) 2019 MasterCard. All rights reserved.
 */

package com.crystalark.userservice.Exceptions;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel(description = "Custom Exception model for Book-service")
@Data
public class CustomExceptionResponse {

    @ApiModelProperty(dataType = "Date", notes = "Timestamp of exception")
    private Date timestamp;

    @ApiModelProperty(dataType = "String", notes = "Customized exception message")
    private String message;

    @ApiModelProperty(dataType = "String", notes = "Detailed exception message")
    private String details;

    public CustomExceptionResponse(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
}
