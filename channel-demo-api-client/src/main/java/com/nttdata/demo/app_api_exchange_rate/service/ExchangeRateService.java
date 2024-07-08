package com.nttdata.demo.app_api_exchange_rate.service;

import com.nttdata.demo.app_api_exchange_rate.entity.ExchangeRate;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

public interface ExchangeRateService {

    public Mono<ResponseEntity<Flux<ExchangeRate>>> getAllExchangeRate();
    public Mono<ResponseEntity<Map<String,Object>>> findExchangeRateByType(String type);
}
