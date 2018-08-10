package com.example.ulises.errorloggerserver.rest.endpoints;

import com.example.ulises.errorloggerserver.constants.Constants;
import com.example.ulises.errorloggerserver.rest.dto.ErrorLogDTO;
import com.example.ulises.errorloggerserver.rest.dto.ResponseOKDTO;
import com.example.ulises.errorloggerserver.services.entities.App;
import com.example.ulises.errorloggerserver.services.entities.ErrorLog;
import com.example.ulises.errorloggerserver.services.ErrorLogService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Path("/error")
public class ErrorLogEndpoint {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ErrorLogService errorLogService;

    @POST
    @Path("/new")
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello(@Valid @NotNull(message = Constants.REQUEST_ERROR_NULL_BODY) final ErrorLogDTO errorLogDTO) {
        this.errorLogService.insert(this.modelMapper.map(errorLogDTO, ErrorLog.class));
        return Response.ok(ResponseOKDTO.builder().message(Constants.RESPONSE_OK_ERROR_SAVED).build()).build();
    }

    @GET
    @Path("/getFrom/{appName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello(@PathParam("appName") final String app) {
        List<ErrorLogDTO> errors = this.errorLogService.getErrorByApp(App.builder().name(app).build())
                .stream().map(error -> this.modelMapper.map(error, ErrorLogDTO.class))
                .collect(Collectors.toList());
        return Response.ok(errors).build();
    }

}
