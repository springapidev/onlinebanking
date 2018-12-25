package com.coderbd.onlinebanking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.faces.webapp.FacesServlet;

@SpringBootApplication
@ComponentScan(basePackages = "com.coderbd.onlinebanking.*")
public class OnlinebankingApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(OnlinebankingApplication.class, args);
    }
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        FacesServlet servlet = new FacesServlet();
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(servlet, "*.jsf");

        return servletRegistrationBean;
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(OnlinebankingApplication.class);
    }

}

