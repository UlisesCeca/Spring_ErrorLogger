package com.example.ulises.errorloggerserver.rest.exceptionsmappers;

import com.example.ulises.errorloggerserver.rest.dto.ErrorDTO;
import com.example.ulises.errorloggerserver.services.exceptions.NoErrorsFoundsForAppException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import static com.example.ulises.errorloggerserver.constants.Constants.RESPONSE_ERROR_NO_ERRORS_FOUND;

public class NoErrorsFoundsForAppExceptionMapper implements ExceptionMapper<NoErrorsFoundsForAppException> {
    @Override
    public Response toResponse(NoErrorsFoundsForAppException e) {
        final ErrorDTO errorDTO = ErrorDTO.builder()
                .message(RESPONSE_ERROR_NO_ERRORS_FOUND)
                .build();
        return Response.status(Response.Status.NOT_FOUND).entity(errorDTO).build();
    }
}