package com.nttdata.demo.app_api_exchange_rate.service;

import com.nttdata.demo.app_api_exchange_rate.entity.ExchangeRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;

@Service
public class ExchangeRateServiceImpl implements  ExchangeRateService{

    @Autowired
    private WebClient client;

    @Override
    public Flux<ExchangeRate> getAllExchangeRate() {

        return client.get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(ExchangeRate.class);
    }

    @Override
    public Mono<ExchangeRate> findExchangeRateByType(String type) {
        return client.get()
                .uri("/{type}", Collections.singletonMap("type", type))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(ExchangeRate.class);
    }

    @Override
    public Mono<ResponseEntity> showExchangeRateByType(String type) {
        return client.get()
                .uri("/show/{type}", Collections.singletonMap("type", type))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(ResponseEntity.class);
    }

}
