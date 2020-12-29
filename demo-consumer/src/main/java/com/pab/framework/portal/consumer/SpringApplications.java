package com.pab.framework.portal.consumer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
public class SpringApplications extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringApplications.class);
        //springApplication.addListeners(new ApplicationStartup());
        springApplication.run(args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringApplications.class);
    }
}