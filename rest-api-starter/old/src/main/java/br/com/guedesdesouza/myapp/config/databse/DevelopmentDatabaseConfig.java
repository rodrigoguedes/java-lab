package br.com.guedesdesouza.myapp.config.databse;

import br.com.guedesdesouza.myapp.infra.annotation.DevelopmentEnvironment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

/**
 * Created by rodrigo.souza on 26/08/2016.
 */
@DevelopmentEnvironment
@Configuration
public class DevelopmentDatabaseConfig implements DatabaseConfig {

    @Bean
    @Override
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        // factoryBean.setPersistenceUnitName("mysql");
        //factoryBean.setPersistenceUnitName("postgresql");
        factoryBean.setDataSource(dataSource());
        return factoryBean;
    }

    @Bean
    @Override
    public DataSource dataSource() {

        return null;

/*
        BasicDataSource dataSource = new BasicDataSource();
        // dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setDriverClassName("org.postgresql.Driver");
        // dataSource.setUrl("jdbc:mysql://localhost/happinessapp");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/eebee_prod2");
        // dataSource.setUsername("root");
        dataSource.setUsername("rodrigo");
        dataSource.setPassword("");
        dataSource.setTestOnBorrow(true);
        dataSource.setTestOnReturn(true);
        dataSource.setTestWhileIdle(true);
        dataSource.setTimeBetweenEvictionRunsMillis(1800000);
        dataSource.setNumTestsPerEvictionRun(3);
        dataSource.setMinEvictableIdleTimeMillis(1800000);
        dataSource.setInitialSize(4);
        dataSource.setMaxActive(20);
        dataSource.setMaxIdle(20);

        return dataSource;
        */
    }

}
