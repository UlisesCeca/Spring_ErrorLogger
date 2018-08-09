package com.example.ulises.errorloggerserver.rest.dto;

import lombok.Builder;
import lombok.Data;

@Builder @Data
public class ErrorDTO {
    private String error;
}
