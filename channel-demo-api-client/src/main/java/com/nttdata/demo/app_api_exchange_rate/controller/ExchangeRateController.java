package com.nttdata.demo.app_api_exchange_rate.controller;

import com.nttdata.demo.app_api_exchange_rate.entity.ExchangeRate;
import com.nttdata.demo.app_api_exchange_rate.repository.ExchangeRateRepository;
import com.nttdata.demo.app_api_exchange_rate.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/channel/demo/api/client")
public class ExchangeRateController {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @GetMapping
    public Mono<ResponseEntity<Flux<ExchangeRate>>> getAll(){
        return exchangeRateService.getAllExchangeRate();
    }

    @GetMapping("/{type}")
    public Mono<ResponseEntity<Map<String,Object>>> findByType(@PathVariable String type){
        return exchangeRateService.findExchangeRateByType(type);
    }

}
