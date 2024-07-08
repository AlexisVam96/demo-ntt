package com.nttdata.demo.app_api_exchange_rate.service;

import com.nttdata.demo.app_api_exchange_rate.entity.ExchangeRate;
import com.nttdata.demo.app_api_exchange_rate.repository.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService{

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    @Override
    public Mono<ResponseEntity<Flux<ExchangeRate>>> getAllExchangeRate() {
        return Mono.just(ResponseEntity.ok()
                .body(exchangeRateRepository.getAllExchangeRate()));
    }

    @Override
    public Mono<ResponseEntity<Map<String, Object>>> findExchangeRateByType(String type) {
        Map<String, Object> body = new HashMap<>();

        return exchangeRateRepository.findExchangeRateByType(type)
                .map(exchangeRate -> {
                    body.put("exchangeRate", exchangeRate);
                    return ResponseEntity.ok().body(body);
                })
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()))
                .onErrorResume(error -> {
                    WebClientResponseException errorResponse = (WebClientResponseException) error;
                    if(errorResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
                        body.put("error", errorResponse.getMessage());
                        body.put("message", "No existe el tipo de cambio: ".concat(type));
                        body.put("timestamp", new Date());
                        body.put("status", errorResponse.getStatusCode().value());
                        return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body(body));
                    }
                    return Mono.error(errorResponse);
                });
    }
}
