package com.ulises.errorsloggerserver.rest.exceptionsmappers;

import com.ulises.errorsloggerserver.rest.dto.ErrorDTO;
import com.ulises.errorsloggerserver.constants.Constants;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class InternalServerErrorMapper implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception e) {
        final ErrorDTO errorDTO = ErrorDTO.builder()
                .message(Constants.REQUEST_ERROR_INTERNAL_SERVER_ERROR)
                .build();
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(errorDTO)
                .build();
    }
}