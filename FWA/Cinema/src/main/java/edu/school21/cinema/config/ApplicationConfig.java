package edu.school21.cinema.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.cinema.repositoties.UsersRepository;
import edu.school21.cinema.repositoties.UsersRepositoryImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan("edu.school21.cinema")
@PropertySource("classpath:../application.properties")
public class ApplicationConfig {



    @Value("${datasource.url}")
    private String url;
    @Value("${datasource.user}")
    private String user;
    @Value("${datasource.password}")
    private String password;
    @Value("${datasource.driver-class-name}")
    private String driver;

    @Bean
    public HikariDataSource getHDS() {

        HikariConfig hikariConfig = new HikariConfig();
       hikariConfig.setJdbcUrl(this.url);
       hikariConfig.setUsername(this.user);
        hikariConfig.setPassword(this.password);
        hikariConfig.setDriverClassName(this.driver);

        return new HikariDataSource(hikariConfig);
    }

    @Bean
    public UsersRepository getUsersRepository() {
        return new UsersRepositoryImpl();
    }

    @Value("${jsp.path.signUp}")
    private String signUpJstPath;
    @Value("${jsp.path.mainPage}")
    private  String mainPageJspPath;
    @Value("${jsp.path.signInErr}")
    private  String signInErrJspPath;

    @Bean
    public String getSignUpJstPath() {
        return signUpJstPath;
    }
    @Bean
    public String getMainPagePath() { return mainPageJspPath; }
    @Bean
    public String getSignInErrPath() {return signInErrJspPath;}

}
