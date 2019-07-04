package br.com.guedesdesouza.dne.listener;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.stereotype.Component;

@Component
public class LoggerWriterListener<T> implements ItemWriteListener<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerWriterListener.class);

    @Override
    public void beforeWrite(List<? extends T> items) {

        LOGGER.debug("Preparando a escrita de {} itens do tipo {}", items.size(), items.getClass().getTypeName());
    }

    @Override
    public void afterWrite(List<? extends T> items) {
        
        LOGGER.debug("Término da escrita dos items. {} {}'s", items.size(), items.getClass().getTypeName());
    }

    @Override
    public void onWriteError(Exception exception, List<? extends T> items) {

        LOGGER.error("Erro ao escrever os items {}", exception.getMessage());
        exception.printStackTrace();
    }
}