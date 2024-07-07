package com.nttdata.demo.channel_api_client.controller;

import com.nttdata.demo.channel_api_client.entity.ExchangeRate;
import com.nttdata.demo.channel_api_client.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/app/demo/api/exchange-rate")
public class ExchangeRateController {

    @Autowired
    ExchangeRateService exchangeRateService;

    @GetMapping
    public Mono<ResponseEntity<Flux<ExchangeRate>>> getAll() {
        return  Mono.just(ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(exchangeRateService.getAllExchangeRate()));

    }

    @GetMapping("/{type}")
    public Mono<ResponseEntity<ExchangeRate>> findByType(@PathVariable String type){
        return exchangeRateService.findExchangeRateByType(type)
                .map(p -> ResponseEntity.ok().body(p))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
