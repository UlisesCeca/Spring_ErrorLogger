package com.example.ulises.errorloggerserver.rest.exceptionsmappers;

import com.example.ulises.errorloggerserver.rest.dto.ErrorDTO;
import com.example.ulises.errorloggerserver.services.exceptions.InsertException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class InsertExceptionMapper implements ExceptionMapper<InsertException> {
    private final String INSERT_ERROR = "Error saving error into logs DB.";

    @Override
    public Response toResponse(InsertException e) {
        final ErrorDTO errorDTO = ErrorDTO.builder().
                error(INSERT_ERROR).
                build();
        return Response.status(Response.Status.BAD_REQUEST).entity(errorDTO).build();
    }
}
