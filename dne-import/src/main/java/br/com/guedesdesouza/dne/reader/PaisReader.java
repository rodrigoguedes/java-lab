package br.com.guedesdesouza.dne.reader;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.guedesdesouza.dne.domain.PaisDne;

@Component
public class PaisReader extends BaseFlatFileItemReader<PaisDne> {
	
	public PaisReader(@Value("${dne.path}") String path) {
		
		super(PaisDne.class, 
				new String[]{"sigla,siglaAlternativa,portugues,ingles,abreviatura"},  
				path + "ECT_PAIS.TXT");
		
		//setResource(new ClassPathResource(path + "ECT_PAIS.TXT"));
//		FixedLengthTokenizer fixedLengthTokenizer = new FixedLengthTokenizer();
		//setLineMapper();
		
//		setResource(new FileSystemResource( path + "ECT_PAIS.TXT"));
		//setLineMapper(new PaisDneMapper());
		//setLineMapper(new DefaultLineMapper<>());
		
//		BeanWrapperFieldSetMapper beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper();
//		beanWrapperFieldSetMapper.setTargetType(PaisDne.class);
		
		
	}
	
}
