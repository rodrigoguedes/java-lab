package br.com.guedesdesouza.dne.listener;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class LoggerExecutionListener implements JobExecutionListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerExecutionListener.class);

    @Override
    public void beforeJob(JobExecution jobExecution) {

        LOGGER.info("Iniciando job {}", jobExecution.getJobConfigurationName());
    }

    @Override
    public void afterJob(JobExecution jobExecution) {

        final Date createTime = jobExecution.getCreateTime();
        final Date endTime = jobExecution.getEndTime();

        LOGGER.info("Job {} iniciado {} e finalizado {} com status {}", createTime, endTime, jobExecution.getStatus().toString());
    }
}