package br.com.guedesdesouza.dne.config.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import br.com.guedesdesouza.dne.domain.PaisDne;
import br.com.guedesdesouza.dne.listener.LoggerProcessorListener;
import br.com.guedesdesouza.dne.listener.LoggerReadListener;
import br.com.guedesdesouza.dne.listener.LoggerWriterListener;
import br.com.guedesdesouza.dne.listener.StopWatchJobExecutionListener;
import br.com.guedesdesouza.dne.processor.PaisProcessor;
import br.com.guedesdesouza.dne.reader.PaisReader;
import br.com.guedesdesouza.dne.writer.PaisWriter;
import br.com.guedesdesouza.external.Pais;

public class PaisJobConfig extends BaseJobConfig {

    private static final String JOB_PAIS = "jobPais";
    private static final String STEP_PAIS = "stepPais";  
	
    @Bean(name = JOB_PAIS)
	public Job jobDms(
			@Qualifier(STEP_PAIS) Step step, 
			StopWatchJobExecutionListener listener) {

        return getJobBuilderFactory()
                .get(JOB_PAIS)
                .start(step)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .build();
    }
    
    @Bean(name = STEP_PAIS)
    public Step stepDms(PaisReader reader, PaisProcessor processor, PaisWriter writer,
            LoggerReadListener<PaisDne> readerListener,
            LoggerProcessorListener<PaisDne, Pais> processorListener,
            LoggerWriterListener<Pais> writterListener) {

        return getStepBuilderFactory()
                .get(STEP_PAIS)
                .<PaisDne, Pais>chunk(100)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .listener(readerListener)
                .listener(processorListener)
                .listener(writterListener)
                .faultTolerant()
                //.skipPolicy(new ProcessorExceptionSkipPolicy())
                .build();
    }
	
}
