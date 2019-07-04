package br.com.guedesdesouza.dne.config.job;

import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseJobConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	public StepBuilderFactory getStepBuilderFactory() {
		return stepBuilderFactory;
	}

	public JobBuilderFactory getJobBuilderFactory() {
		return jobBuilderFactory;
	}
}