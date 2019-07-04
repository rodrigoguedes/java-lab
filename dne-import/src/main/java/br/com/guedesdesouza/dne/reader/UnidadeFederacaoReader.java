package br.com.guedesdesouza.dne.reader;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//https://github.com/AnthonyGuerreiro/pt-post-code/

@Component
public class UnidadeFederacaoReader extends BaseFlatFileItemReader<UnidadeFederacaoReader> {

	public UnidadeFederacaoReader(@Value("${dne.path}") String path) {
		super(UnidadeFederacaoReader.class, 
				new String[]{"sigla,siglaAlternativa,portugues,ingles,abreviatura"},  
				path + "UF.TXT");
	}

}
