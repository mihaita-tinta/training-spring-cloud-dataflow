package com.mih.restsource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.app.http.source.HttpSourceConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(HttpSourceConfiguration.class)
public class RestSourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestSourceApplication.class, args);
	}
}
