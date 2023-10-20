package com.Grupo6.Lab1.respositories;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sql2o.Sql2o;

@Configuration
public class DatabaseContext {

    @Value("jdbc:postgresql://localhost:5432/tbd2")
    private String dbUrl;

    @Value("postgres")
    private String dbUser;

<<<<<<< HEAD
    @Value("psw123")
=======
    @Value("64959")
>>>>>>> main
    private String dbPass;

    @Bean
    public Sql2o sql2o() {
        return new Sql2o(dbUrl, dbUser, dbPass);
    }
}