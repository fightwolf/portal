package com.pab.framework.portal.config;

import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author wang.ke * @date 2017年10月25日
 */
public class ApplicationStartup implements ApplicationListener<ApplicationPreparedEvent> {
    private String LOTUS_ENV_KEY = "Lotus-Env";

    @Override
    public void onApplicationEvent(ApplicationPreparedEvent applicationPreparedEvent) {
        System.setProperty("APP_ENV", getEnv());
    }

    private String getEnv() {
        return "dev";
    }
}