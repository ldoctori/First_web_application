package edu.school21.cinema.config;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.cinema.repositoties.UsersRepository;
import edu.school21.cinema.repositoties.UsersRepositoryImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


import java.io.IOException;


@Configuration
@ComponentScan("edu.school21.cinema")
@PropertySource("classpath:../application.properties")
public class ApplicationConfig {

    private DataSourceProperties dataSourceProperties;
    private UsersRepository usersRepository = new UsersRepositoryImpl();

    @Bean
    public HikariDataSource getHDS() throws IOException {

        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(dataSourceProperties.getUrl());
        ds.setUsername(dataSourceProperties.getUsername());
        ds.setPassword(dataSourceProperties.getPassword());
        ds.setDriverClassName(dataSourceProperties.getDriverClassName());

        return ds;
    }

    @Bean
    public UsersRepository getUsersRepository() {
        return this.usersRepository;
    }

    @Value("${jsp.path.signUp}")
    private String signUpJstPath;

    @Bean
    public String getSignUpJstPath() {
        return signUpJstPath;
    }

}
