package com.example.ulises.errorloggerserver.services.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "ErrorsLogServer")
@Data
public class ErrorLog {
    private int applicationID;
    private String applicationName;
    private String trace;
    private String causedByUser;
    private Date datetime;
}
