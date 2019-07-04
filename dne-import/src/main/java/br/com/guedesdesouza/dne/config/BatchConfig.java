package br.com.guedesdesouza.dne.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import br.com.guedesdesouza.dne.config.job.PaisJobConfig;

@Configuration
@Import({
	PaisJobConfig.class,
//	UnidadeFederacaoJobConfig.class,
//	LocalidadeJobConfig.class,
//	TipoLogradouroJobConfig.class,
//	LogradouroJobConfig.class
})
public class BatchConfig {

}
