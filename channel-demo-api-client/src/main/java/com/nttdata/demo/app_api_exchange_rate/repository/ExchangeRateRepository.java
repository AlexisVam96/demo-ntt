package com.nttdata.demo.app_api_exchange_rate.repository;

import com.nttdata.demo.app_api_exchange_rate.entity.ExchangeRate;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ExchangeRateRepository {

    public Flux<ExchangeRate> getAllExchangeRate();
    public Mono<ExchangeRate> findExchangeRateByType(String type);
    public Mono<ResponseEntity> showExchangeRateByType(String type);


}
