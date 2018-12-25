package com.coderbd.onlinebanking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

//@EnableWebMvc
//@Configuration
//@EnableJpaRepositories
public class MvcConfig extends WebMvcConfigurationSupport {
//    @Bean
//    public ViewResolver getViewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/views/");
//        resolver.setSuffix(".xhtml");
//        return resolver;
//    }
    @Bean
    public UrlBasedViewResolver urlBasedViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/views/");
        resolver.setSuffix(".xhtml");
        resolver.setCache(false);
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


}