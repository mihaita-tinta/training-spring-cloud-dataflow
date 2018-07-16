package com.mih.logsink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.app.log.sink.LogSinkConfiguration;

@SpringBootApplication
@EnableBinding(LogSinkConfiguration.class)
public class LogSinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogSinkApplication.class, args);
	}
}
