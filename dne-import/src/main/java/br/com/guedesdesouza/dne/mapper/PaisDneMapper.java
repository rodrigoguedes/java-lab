package br.com.guedesdesouza.dne.mapper;

import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;

import br.com.guedesdesouza.dne.domain.PaisDne;

public class PaisDneMapper extends DefaultLineMapper<PaisDne> {
	
	public PaisDneMapper() {
		
		DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
		delimitedLineTokenizer.setDelimiter("@");
		delimitedLineTokenizer.setNames(new String[]{"sigla,siglaAlternativa,portugues,ingles,abreviatura"});
		
		setLineTokenizer(delimitedLineTokenizer);
	}

}
