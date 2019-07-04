package br.com.guedesdesouza.dne.listener;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemProcessListener;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@StepScope
public class LoggerProcessorListener<I, O> implements ItemProcessListener<I, O> {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggerProcessorListener.class);
	
	private StopWatch stopWatch;
	
	@Override
	public void beforeProcess(I item) {
	    this.stopWatch = new StopWatch();
	    this.stopWatch.start();

		LOGGER.debug("Iniciando processamento de \"{}\" para o item [{}]", item.getClass().getName(), item);
	}

	@Override
	public void afterProcess(I item, O result) {

		LOGGER.debug("Processamento do item \"{}\" realizado com sucesso em {} segundos", item.getClass().getName(), stopWatch());
		LOGGER.debug("Resultado [{}]", result);
	}

	@Override
	public void onProcessError(I item, Exception e) {

		LOGGER.error("Erro ao processar {} - [{}], duração {} segundos", item.getClass().getName(), e.getMessage(), stopWatch());
	}

	private Long stopWatch() {
        this.stopWatch.stop();
        long duration = stopWatch.getLastTaskTimeMillis();
        return TimeUnit.MILLISECONDS.toSeconds(duration);        
    }
}