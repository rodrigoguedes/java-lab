	package br.com.guedesdesouza.dne;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableBatchProcessing
@EnableConfigurationProperties
public class DneApplication {

	public static void main(String[] args) {
		SpringApplication.run(DneApplication.class, args);
	}
}
