package br.com.guedesdesouza.myapp.mapper;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class AppObjectMapper extends ObjectMapper {

	public static final String DATE_TIME_FORMAT = "yyyy/MM/dd HH:mm:ss";
	
	private static final long serialVersionUID = 1L;
	
    public AppObjectMapper() {

        setSerializationInclusion(Include.NON_EMPTY);
        setVisibilityChecker(this.getSerializationConfig().getDefaultVisibilityChecker()
        					 	 .withFieldVisibility(Visibility.ANY)
        					 	 .withGetterVisibility(Visibility.NONE)
        					 	 .withSetterVisibility(Visibility.NONE)
        					 	 .withIsGetterVisibility(Visibility.NONE)
        					 	 .withCreatorVisibility(Visibility.NONE));

        configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, Boolean.TRUE);
        configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, Boolean.TRUE);
        configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        registerModule(new AppDateModule());
    }

}
