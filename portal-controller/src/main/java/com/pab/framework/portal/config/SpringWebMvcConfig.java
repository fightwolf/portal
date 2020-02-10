package com.pab.framework.portal.config;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.servlet.ServletContext;

/**
 * @author wang.ke * @date 2017年10月25日
 */
@Configuration
@EnableWebMvc
@ServletComponentScan("com.pab.framework.portal")
public class SpringWebMvcConfig extends WebMvcConfigurerAdapter {
    /*  *
    * * undertow web容器注册
    * * @return     */
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver factory = new InternalResourceViewResolver();
        factory.setPrefix("/WEB-INF/views/");
        factory.setSuffix(".jsp");
        return factory;
    }

    @Bean
    public FreeMarkerConfigurer viewResolver(ServletContext servletContext) {
        FreeMarkerConfigurer fm;
        fm = new FreeMarkerConfigurer();
        fm.setTemplateLoaderPath("classpath:templates/views/");
        fm.setDefaultEncoding("UTF-8");
        return fm;
    }

    /**
     * 忽略url大小写
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        AntPathMatcher matcher = new AntPathMatcher();
        matcher.setCaseSensitive(false);
        configurer.setPathMatcher(matcher);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/static/");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:templates/static/");
    }
}