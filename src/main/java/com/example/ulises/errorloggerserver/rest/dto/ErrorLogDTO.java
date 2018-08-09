package com.example.ulises.errorloggerserver.rest.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class ErrorLogDTO {
    @NotNull(message = "application id must not be null")
    private int applicationID;
    @NotNull(message = "application must not be null")
    private String applicationName;
    @NotNull(message = "trace must not be null")
    private String trace;
    @NotNull(message = "causedByUser must not be null")
    private String causedByUser;
    @NotNull(message = "date must not be null")
    private Date datetime;
}
