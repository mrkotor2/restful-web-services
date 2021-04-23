package com.training.rest.webservices.restfulwebservices.helloWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    private final MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    //  alternative
//  @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    @GetMapping("/hello-world-internationalized")
    public String helloWorldInternationalized(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return messageSource.getMessage("hello.world.message", null, LocaleContextHolder.getLocale());
    }

    @GetMapping("/hello-world-bean/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}
