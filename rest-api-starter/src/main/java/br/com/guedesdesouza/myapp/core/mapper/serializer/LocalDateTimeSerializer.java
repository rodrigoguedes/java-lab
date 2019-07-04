package br.com.guedesdesouza.myapp.core.mapper.serializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import br.com.guedesdesouza.myapp.core.mapper.AppObjectMapper;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.com.guedesdesouza.myapp.core.mapper.AppObjectMapper;

public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime>{

	@Override
	public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {

		//final SimpleDateFormat formatter = new SimpleDateFormat(AppObjectMapper.DATE_TIME_FORMAT);

		if(Objects.nonNull(value)) {
			gen.writeString(DateTimeFormatter.ofPattern(AppObjectMapper.DATE_TIME_FORMAT).format(value));
			//gen.writeString(formatter.format(value));
		}
	}
	
	@Override
	public Class<LocalDateTime> handledType() {
		return LocalDateTime.class;
	}
	
}
