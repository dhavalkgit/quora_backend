package com.example.quora.configration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ForwardedHeaderFilter;

import static org.springframework.security.config.web.server.SecurityWebFiltersOrder.AUTHORIZATION;


@Configuration
@OpenAPIDefinition(info = @Info(title = "Theta Spring Boot", description = "Theta Framework in Spring Boot", version = "v1", license = @License(name = "Flexidev", url = "https://www.flexidev.co")))
public class SwaggerConfiguration {
    // Access local: http://localhost:8080/swagger-ui/index.html
    @Bean
    public OpenAPI customOpenAPI() {
       return new OpenAPI()
               .info(new io.swagger.v3.oas.models.info.Info().title("Api title").version("Api version"));
    }

    @Bean
    GroupedOpenApi publicApi(){
        return GroupedOpenApi.builder()
                .group("public-apis")
                .pathsToMatch("/**")
                .build();
    }
}
