package org.grupo4.practica_integradora_g4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class PracticaIntegradoraG4Application extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run(PracticaIntegradoraG4Application.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.sources(PracticaIntegradoraG4Application.class);
    }

    @Bean
    public WebMvcConfigurer vueConfigurer() {
        return new WebMvcConfigurer() {

            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {

                registry.addResourceHandler("/tienda_vue/")
                        .addResourceLocations("file:./src/main/resources/static/tienda_vue/");
            }
        };
    }
}
