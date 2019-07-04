package br.com.guedesdesouza.dne.listener;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
public class StopWatchJobExecutionListener implements JobExecutionListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(StopWatchJobExecutionListener.class);

    private StopWatch stopWatch;
    
    @Override
    public void beforeJob(JobExecution jobExecution) {
        this.stopWatch = new StopWatch();
        this.stopWatch.start();
    }

    @Override
    public void afterJob(JobExecution jobExecution) {

        this.stopWatch.stop();

        long duration = stopWatch.getLastTaskTimeMillis();
        
        final String jobName = jobExecution.getJobInstance().getJobName();
        
        LOGGER.info("Job {} finalizado em {} min. com status {}", jobName, TimeUnit.MILLISECONDS.toMinutes(duration), jobExecution.getStatus().toString());
        
        if ("FAILED".equals(jobExecution.getStatus().toString())){
        	LOGGER.error(jobExecution.getExitStatus().getExitDescription());
        }
        
    }
}