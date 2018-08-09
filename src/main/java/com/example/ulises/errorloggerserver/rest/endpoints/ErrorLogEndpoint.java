package com.example.ulises.errorloggerserver.rest.endpoints;

import com.example.ulises.errorloggerserver.rest.dto.ErrorLogDTO;
import com.example.ulises.errorloggerserver.services.entities.ErrorLog;
import com.example.ulises.errorloggerserver.services.ErrorLogService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/error")
public class ErrorLogEndpoint {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ErrorLogService userService;

    @POST
    @Path("/new")
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello(@Valid @NotNull(message = "testDTO must not be null") final ErrorLogDTO errorLogDTO) {
        this.userService.insert(this.modelMapper.map(errorLogDTO, ErrorLog.class));
        return Response.noContent().build();
    }

}
