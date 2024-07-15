package com.api.blog.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI configOpenApi() {
        return new OpenAPI().info(
                new Info().description("Definição de Apis para o Blog")
                        .version("1.0.0")
                        .title("BLOG Restfull API")
        );
    }
}
