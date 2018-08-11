package com.ulises.errorsloggerserver.rest.exceptionsmappers;

import com.ulises.errorsloggerserver.rest.dto.ErrorDTO;
import com.ulises.errorsloggerserver.services.exceptions.NoErrorsFoundsForAppException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import static com.ulises.errorsloggerserver.constants.Constants.RESPONSE_ERROR_NO_ERRORS_FOUND;

public class NoErrorsFoundsForAppExceptionMapper implements ExceptionMapper<NoErrorsFoundsForAppException> {
    @Override
    public Response toResponse(NoErrorsFoundsForAppException e) {
        final ErrorDTO errorDTO = ErrorDTO.builder()
                .message(RESPONSE_ERROR_NO_ERRORS_FOUND)
                .build();
        return Response.status(Response.Status.NOT_FOUND).entity(errorDTO).build();
    }
}