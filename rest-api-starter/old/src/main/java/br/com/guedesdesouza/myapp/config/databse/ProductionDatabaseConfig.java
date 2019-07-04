package br.com.guedesdesouza.myapp.config.databse;

import br.com.guedesdesouza.myapp.infra.annotation.ProductionEnvironment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by rodrigo.souza on 26/08/2016.
 */
@ProductionEnvironment
@Configuration
public class ProductionDatabaseConfig implements DatabaseConfig {

    @Bean
    @Override
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitName("postgresql");
        factoryBean.setDataSource(dataSource());
        return factoryBean;
    }

    @Bean
    @Override
    public DataSource dataSource() {
        try{
            URI dbUri = new URI(System.getenv("DATABASE_URL"));

            String username = dbUri.getUserInfo().split(":")[0];
            String password = dbUri.getUserInfo().split(":")[1];
            //String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + "/" + dbUri.getPath();
            String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();

//            BasicDataSource dataSource = new BasicDataSource();
//            dataSource.setDriverClassName("org.postgresql.Driver");
//            dataSource.setUrl(dbUrl);
//            dataSource.setUsername(username);
//            dataSource.setPassword(password);
//            dataSource.setTestOnBorrow(true);
//            dataSource.setTestOnReturn(true);
//            dataSource.setTestWhileIdle(true);
//            dataSource.setTimeBetweenEvictionRunsMillis(1800000);
//            dataSource.setNumTestsPerEvictionRun(3);
//            dataSource.setMinEvictableIdleTimeMillis(1800000);
//            return dataSource;
            return null;
        }catch(URISyntaxException e){
            e.printStackTrace();
        }
        return null;
    }

}
