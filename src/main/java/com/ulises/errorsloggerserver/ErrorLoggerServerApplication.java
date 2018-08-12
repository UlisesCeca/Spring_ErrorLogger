package com.ulises.errorsloggerserver;

import com.ulises.errorsloggerserver.rest.endpoints.ErrorLogEndpoint;
import com.ulises.errorsloggerserver.rest.exceptionsmappers.InternalServerErrorMapper;
import com.ulises.errorsloggerserver.rest.exceptionsmappers.NoErrorsFoundsForAppExceptionMapper;
import com.ulises.errorsloggerserver.rest.exceptionsmappers.NotFoundMapper;
import org.glassfish.jersey.server.ResourceConfig;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

@SpringBootApplication
public class ErrorLoggerServerApplication {

	public static void main(String[] args) {
		if(loginAppServer(args[0], args[1]))
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


	private static boolean loginAppServer(final String user, final String password) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		URL url;
		HttpURLConnection con;
		try {
			url = new URL("http://localhost:8680/ulises/apperver/app/getAll");
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Authorization", "a");
			con.getInputStream();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
