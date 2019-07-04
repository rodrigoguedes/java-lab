package br.com.guedesdesouza.dne.listener;

import static java.util.Objects.nonNull;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * {@link ItemReadListener} genérico, que apenas loga os dados de cada passo da leitura dos dados
 *
 * @author eduardogardin
 * 
 */
@Component
@StepScope
public class LoggerReadListener<T> implements ItemReadListener<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerReadListener.class);

    private StopWatch stopWatch;

    @Override
    public void beforeRead() {
        this.stopWatch = new StopWatch();
        this.stopWatch.start();

        LOGGER.debug("Iniciando a leitura do(a) {}", getClass().getTypeParameters()[0].getClass().getSimpleName());
    }

    @Override
    public void afterRead(T item) {
        
        LOGGER.debug("O {} foi lido com sucesso em {} mins", item.getClass().getSimpleName(), item, stopWatch());
    }

    @Override
    public void onReadError(Exception ex) {

        if(nonNull(ex) && nonNull(ex.getMessage())) {
            LOGGER.error("Erro de leitura: {} em {} segundos", ex.getMessage(), stopWatch());
        }
    }

    private Long stopWatch() {
        this.stopWatch.stop();
        long duration = stopWatch.getLastTaskTimeMillis();
        return TimeUnit.MILLISECONDS.toSeconds(duration);
    }
}