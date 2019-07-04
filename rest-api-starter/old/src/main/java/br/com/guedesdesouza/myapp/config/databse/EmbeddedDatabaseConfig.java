package br.com.guedesdesouza.myapp.config.databse;

import br.com.guedesdesouza.myapp.infra.annotation.TestEnvironment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

/**
 * Created by rodrigo.souza on 26/08/2016.
 */
@TestEnvironment
@Configuration
public class EmbeddedDatabaseConfig implements DatabaseConfig {

    @Bean
    @Override
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitName("integration");
        factoryBean.setDataSource(dataSource());
        return factoryBean;
    }

    @Bean
    @Override
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
    }

}
