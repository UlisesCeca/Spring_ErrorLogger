package com.ulises.errorsloggerserver.rest.dto;

import lombok.Builder;
import lombok.Data;

@Builder @Data
public class ResponseOKDTO {
    private final String message;
}
