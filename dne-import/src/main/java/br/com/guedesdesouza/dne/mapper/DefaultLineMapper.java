package br.com.guedesdesouza.dne.mapper;

public class DefaultLineMapper<T> extends org.springframework.batch.item.file.mapping.DefaultLineMapper<T> {

	public DefaultLineMapper(Class<T> klass, String[] fields, String delimiter) {
        setLineTokenizer(new DefaultDelimitedLineTokenizer(fields, delimiter));
        setFieldSetMapper(new DefaultBeanWrapperFieldSetMapper<T>(klass));
    }

}
