package br.com.pedro.springcurse.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("Restful api with java 20 and Spring Boot 3")
                        .version("v1")
                        .description("api rest full")
                        .termsOfService("wwww.phx.com")
                        .license(new License().name("Apache 2.0").url("wwww.phx.com")));
    }
}
