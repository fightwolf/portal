package com.pab.framework.portal;

import com.pab.framework.portal.config.ApplicationStartup;
import com.pab.framework.portal.config.SpringWebMvcConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author wang.ke * @date 2017年10月25日
 */
@SpringBootApplication
@Import(SpringWebMvcConfig.class)
@ImportResource("classpath:applicationContext.xml")
public class SpringApplications extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringApplications.class);
        springApplication.addListeners(new ApplicationStartup());
        springApplication.run(args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringApplications.class);
    }
}