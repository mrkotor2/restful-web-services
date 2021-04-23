package com.training.rest.webservices.restfulwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class RestfulWebServicesApplication {
    public static void main(String[] args) {
        Locale defaultLocale = Locale.getDefault();
        System.out.println(defaultLocale);
        Locale.setDefault(Locale.US);
        SpringApplication.run(RestfulWebServicesApplication.class, args);
    }

    @Bean
    public LocaleResolver localeResolver() {
        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
        localeResolver.setDefaultLocale(Locale.US);
        return localeResolver;
    }

//    @Bean(name = "messageSource")
//    public ResourceBundleMessageSource messageSource(){
//        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//        messageSource.setDefaultEncoding("UTF-8");
//        messageSource.setBasename("messages");
//        return messageSource;
//    }

}
