package com.liemily.web.config;

import org.apache.shiro.web.env.EnvironmentLoaderListener;
import org.apache.shiro.web.servlet.ShiroFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

/**
 * Created by Emily Li on 20/07/2017.
 */
@Configuration
public class ShiroConfig {

    @Bean
    EnvironmentLoaderListener environmentLoaderListener() {
        return new EnvironmentLoaderListener();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(shiroFilter());
        filterRegistration.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
        return filterRegistration;
    }

    @Bean
    ShiroFilter shiroFilter() {
        return new ShiroFilter();
    }
}
