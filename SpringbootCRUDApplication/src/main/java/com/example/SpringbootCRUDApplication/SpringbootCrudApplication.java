package com.example.SpringbootCRUDApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableDiscoveryClient   //enable when expose microservices
public class SpringbootCrudApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(SpringbootCrudApplication.class);

    @Autowired
    public Environment environment;

    @Override
    public void run(String... args) throws Exception {
        logger.info("\n----Begin logging SpringbootCrudApplication ----");

        logger.info("----System Properties from VM Arguments----");
        logger.info("server.port: " + System.getProperty("server.port"));
        logger.info("----Program Arguments----");
        for (String arg : args) {
            logger.info(arg);
        }

        if (environment != null) {
            getActiveProfiles();
            logger.info("----Environment Properties----");
            logger.info("server.port: " + environment.getProperty("server.port"));
            logger.info("com.example.environment: " + environment.getProperty("nl.amis.environment"));
            logger.info("spring.datasource.url: " + environment.getProperty("spring.datasource.url"));
            logger.info("spring.datasource.username: " + environment.getProperty("spring.datasource.username"));
            logger.info("spring.datasource.password: " + environment.getProperty("spring.datasource.password"));
            logger.info("spring.jpa.database-platform: " + environment.getProperty("spring.jpa.database-platform"));
            logger.info("spring.jpa.hibernate.ddl-auto: " + environment.getProperty("spring.jpa.hibernate.ddl-auto"));
        }

        logger.info("----End logging SpringbootCrudApplication ----");
    }

    private void getActiveProfiles() {
        for (final String profileName : environment.getActiveProfiles()) {
            logger.info("Currently active profile - " + profileName);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCrudApplication.class, args);
    }


    @Autowired        // NO LONGER auto-created by Spring Cloud (see below)
    //@LoadBalanced     // Explicitly request the load-balanced template
    // with Ribbon built-in
    protected RestTemplate restTemplate;

    protected String serviceUrl;

    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}