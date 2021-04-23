package com.training.rest.webservices.restfulwebservices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final Contact DEFAULT_CONTACT = new Contact(
            "Alexander K", "http://www.MyApp.com", "mr**@gmail.com");

//    @Deprecated
//    public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
//            "API Title",
//            "Api Description", "1.0",
//            "urn:tos",
//            DEFAULT_CONTACT, "Apache 2.0",
//            "http://www.apache.org/licenses/LICENSE-2.0");
    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES =
            new HashSet<String>(Arrays.asList("application/json", "application/xml"));

    //Swagger 2
    //All the paths
    //All the api
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API Title")
                .description("Api Description")
                .version("1.0")
                .termsOfServiceUrl("urn:tos")
                .contact(DEFAULT_CONTACT)
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }
//    @Deprecated
//    @Primary
//    @Bean
//    public LinkDiscoverers discoverers() {
//        List<LinkDiscoverer> plugins = new ArrayList<>();
//        plugins.add(new CollectionJsonLinkDiscoverer());
//        return new LinkDiscoverers(SimplePluginRegistry.create(plugins));
//    }
}
