package br.com.guedesdesouza.dne.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.core.io.ClassPathResource;

import br.com.guedesdesouza.dne.mapper.DefaultLineMapper;

public class BaseFlatFileItemReader<T> extends FlatFileItemReader<T> {

    public BaseFlatFileItemReader(Class<T> klass, String[] fields, String classPathResource) {
        setResource(new ClassPathResource(classPathResource));
        setLineMapper(new DefaultLineMapper<T>(klass, fields, "@"));
    }
	
}
