package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.solr.SolrAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.util.Properties;

@SpringBootApplication
@EnableJpaRepositories
@EnableAutoConfiguration( exclude = {SolrAutoConfiguration.class, CassandraAutoConfiguration.class })

public class DemoApplication {

    public static void main(String[] args) {
        // you can choose to not star ttomcat by using NONE
        Properties props = new Properties();
        props.put("spring.config.location", "classpath:jpa.conf.yml, classpath:application.yml");
        /*new SpringApplicationBuilder().web(WebApplicationType.SERVLET)
                .properties(props)
                .build()
                .run(args); */
        //simple way to run spring boot app
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("Hello World");
    }

}
