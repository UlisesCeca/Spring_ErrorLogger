package com.example.ulises.errorloggerserver.rest.dto;

import com.example.ulises.errorloggerserver.services.entities.App;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class ErrorLogDTO {
    @NotNull(message = "application must not be null")
    private App app;
    @NotNull(message = "trace must not be null")
    private String trace;
    @NotNull(message = "causedByUser must not be null")
    private String causedByUser;
    @NotNull(message = "date must not be null")
    private Date datetime;
}
