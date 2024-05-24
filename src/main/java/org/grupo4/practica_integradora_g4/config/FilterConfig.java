package org.grupo4.practica_integradora_g4.config;

import org.grupo4.practica_integradora_g4.filter.PageVisitCounterFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<PageVisitCounterFilter> loggingFilter(){
        FilterRegistrationBean<PageVisitCounterFilter> registrationBean
                = new FilterRegistrationBean<>();

        registrationBean.setFilter(new PageVisitCounterFilter());
        registrationBean.addUrlPatterns("/*");

        return registrationBean;
    }
}
