package com.ulises.errorsloggerserver;

import com.ulises.errorsloggerserver.rest.endpoints.ErrorLogEndpoint;
import com.ulises.errorsloggerserver.rest.exceptionsmappers.InternalServerErrorMapper;
import com.ulises.errorsloggerserver.rest.exceptionsmappers.NoErrorsFoundsForAppExceptionMapper;
import com.ulises.errorsloggerserver.rest.exceptionsmappers.NotFoundMapper;
import org.glassfish.jersey.server.ResourceConfig;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ErrorLoggerServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErrorLoggerServerApplication.class, args);
	}


	@Bean
	public ResourceConfig jerseyConfig() {
		final ResourceConfig resourceConfig = new ResourceConfig();
		resourceConfig.register(ErrorLogEndpoint.class);
		resourceConfig.register(NoErrorsFoundsForAppExceptionMapper.class);
		resourceConfig.register(InternalServerErrorMapper.class);
		resourceConfig.register(NotFoundMapper.class);
		return resourceConfig;
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
