package br.com.guedesdesouza.dne.mapper;

import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;

public class DefaultDelimitedLineTokenizer extends DelimitedLineTokenizer {

	public DefaultDelimitedLineTokenizer(String[] names, String delimiter) {
		setNames(names);
		setDelimiter(delimiter);
	}

}
