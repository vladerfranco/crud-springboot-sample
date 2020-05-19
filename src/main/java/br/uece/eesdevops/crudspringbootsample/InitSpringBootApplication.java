package br.uece.eesdevops.crudspringbootsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class InitSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(InitSpringBootApplication.class, args);
    }
}
