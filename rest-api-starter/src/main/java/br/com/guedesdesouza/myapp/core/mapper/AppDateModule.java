package br.com.guedesdesouza.myapp.core.mapper;

import java.time.LocalDateTime;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;

import br.com.guedesdesouza.myapp.core.mapper.deserializer.LocalDateTimeDeserializer;
import br.com.guedesdesouza.myapp.core.mapper.serializer.LocalDateTimeSerializer;

public class AppDateModule extends SimpleModule {

	private static final long serialVersionUID = 1L;

	private static final String MODULE_NAME = "AppDateModule";

	public AppDateModule() {
		super(MODULE_NAME, Version.unknownVersion());

		addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
		addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
	}
	
}
