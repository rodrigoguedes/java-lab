package br.com.guedesdesouza.myapp.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.guedesdesouza.myapp.mapper.AppObjectMapper;

@Configuration
public class AppWebConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ObjectMapper appObjectMapper(){
		return new AppObjectMapper();
	}
	
	public MappingJackson2HttpMessageConverter jsonHttpMessageConverter(ObjectMapper objectMapper) {

		final MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
		messageConverter.setObjectMapper(objectMapper);

		return messageConverter;
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

		converters.add(jsonHttpMessageConverter(new AppObjectMapper()));
	}
	
}
