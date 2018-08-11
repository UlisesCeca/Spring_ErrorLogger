package com.example.ulises.errorloggerserver.rest.dto;

import lombok.Builder;
import lombok.Data;

@Builder @Data
public class ResponseOKDTO {
    private final String message;
}
