package br.com.guedesdesouza.dne.mapper;

import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;

public class DefaultBeanWrapperFieldSetMapper<T> extends BeanWrapperFieldSetMapper<T> {

	public DefaultBeanWrapperFieldSetMapper(Class<T> klass) {
		setTargetType(klass);
	}
}