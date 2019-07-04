package br.com.guedesdesouza.myapp.mapper.deserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import br.com.guedesdesouza.myapp.mapper.AppObjectMapper;

public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LocalDateTimeDeserializer.class); 

	@Override
	public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {

		final String stringDate = p.readValueAs(String.class).trim();

		try {
			
			return LocalDateTime.parse(stringDate, DateTimeFormatter.ofPattern(AppObjectMapper.DATE_TIME_FORMAT));
		} catch (DateTimeParseException ex) {
			LOGGER.warn("Erro ao fazer parse de data hora vindo do JSON. {}", ex.getMessage());
			return null;
		}
	}
	
	@Override
	public Class<?> handledType() {
		return LocalDateTime.class;
	}
	
}
