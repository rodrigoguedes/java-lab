package br.com.guedesdesouza.myapp.config.databse;

import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

/**
 * Created by rodrigo.souza on 26/08/2016.
 */
public interface DatabaseConfig {

    public LocalContainerEntityManagerFactoryBean entityManagerFactory();

    public DataSource dataSource();

}
