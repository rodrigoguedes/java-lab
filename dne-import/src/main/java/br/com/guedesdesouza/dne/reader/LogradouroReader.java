package br.com.guedesdesouza.dne.reader;

import java.io.IOException;

import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.stereotype.Component;

import br.com.guedesdesouza.dne.domain.LogradouroDne;

@Component
public class LogradouroReader extends MultiResourceItemReader<LogradouroDne> {

	public LogradouroReader() throws IOException {

//        PathMatchingResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
//        this.setResources(resourceResolver.getResources( "classpath:input/arquivo_pais_dne.txt" ) );

		/*
    	Resource[] resources = new Resource[] {resourceLoader.getResource("file:/tmp/import/products-*") };
    	this.setResources(resources);
    	
    	FlatFileItemReader fileReader = new FlatFileItemReader();
    	fileReader.setLinesToSkip(1);
    	
    	DefaultLineMapper lineMapper = new DefaultLineMapper();
    	
    	DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
    	tokenizer.setNames(new String[] { "ID", "NAME", "DESCRIPTION", "PRICE" });
    	
    	FieldSetMapper fieldSetMapper = new PassThroughFieldSetMapper();
    	
    	lineMapper.setLineTokenizer(tokenizer);
    	lineMapper.setFieldSetMapper(fieldSetMapper);
    	
    	fileReader.setLineMapper(lineMapper);
    	
    	this.setDelegate(fileReader);
    	*/
		
	}
	
}
