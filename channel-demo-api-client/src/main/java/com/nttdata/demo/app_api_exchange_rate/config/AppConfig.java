package com.nttdata.demo.app_api_exchange_rate.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {

    @Value("${config.base.endpoint}")
    private String url;

    @Bean
    public WebClient registerWebClient() {
        return WebClient.create(url);
    }
}
