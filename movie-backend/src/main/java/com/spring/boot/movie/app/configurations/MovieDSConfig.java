package com.spring.boot.movie.app.configurations;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {"com.spring.boot.movie.app.repositories"},
        entityManagerFactoryRef = "movieDSFactory",
        transactionManagerRef = "movieDSTransactionManager"
)
public class MovieDSConfig {

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSourceProperties movieDSProperties(){return new DataSourceProperties();}

    @Primary
    @Bean
    public DataSource movieDS(@Qualifier("movieDSProperties") DataSourceProperties movieDSProperties){
        return movieDSProperties.initializeDataSourceBuilder().build();
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean movieDSFactory(@Qualifier("movieDS") DataSource movieDS,
                                                                 EntityManagerFactoryBuilder builder){
        return builder.dataSource(movieDS).packages("com.spring.boot.movie.app.model").build();
    }

    @Primary
    @Bean
    public PlatformTransactionManager movieDSTransactionManager(@Qualifier("movieDSFactory")
                                                                        EntityManagerFactory movieDSFactory){
        return new JpaTransactionManager(movieDSFactory);
    }
}
