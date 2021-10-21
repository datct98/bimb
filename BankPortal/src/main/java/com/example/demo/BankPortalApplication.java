package com.example.demo;

import com.example.demo.security.RESTAuthenticationTokenProcessingFilter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(ignoreResourceNotFound = true, value = "file:application.properties")
public class BankPortalApplication extends SpringBootServletInitializer implements CommandLineRunner {

    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new RESTAuthenticationTokenProcessingFilter());

        registrationBean.addUrlPatterns("/api/admin/maintain");

        registrationBean.addUrlPatterns("/api/v1/update-firebase-token");
        registrationBean.addUrlPatterns("/api/v1/set-secure-code");

        registrationBean.addUrlPatterns("/api/v1/forget-secure-code");
        return registrationBean;
    }

    public static void main(String[] args) {
        SpringApplication.run(BankPortalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
