package com.nttdata.demo.channel_api_client.service;

import com.nttdata.demo.channel_api_client.entity.ExchangeRate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ExchangeRateService {


    public Flux<ExchangeRate> getAllExchangeRate();
    public Mono<ExchangeRate> findExchangeRateByType(String type);


}
