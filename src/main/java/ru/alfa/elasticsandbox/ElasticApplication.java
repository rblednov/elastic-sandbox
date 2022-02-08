package ru.alfa.elasticsandbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class ElasticApplication {
    public static void main(String[] args) {
        SpringApplication.run(ElasticApplication.class, args);
    }
}
