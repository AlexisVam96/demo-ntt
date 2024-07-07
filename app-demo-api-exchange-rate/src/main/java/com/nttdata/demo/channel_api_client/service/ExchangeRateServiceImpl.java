package com.nttdata.demo.channel_api_client.service;

import com.nttdata.demo.channel_api_client.entity.ExchangeRate;
import com.nttdata.demo.channel_api_client.mapper.ExchangeRateMapper;
import com.nttdata.demo.channel_api_client.utils.ExchangeRateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ExchangeRateServiceImpl implements  ExchangeRateService{

    @Autowired
    private ExchangeRateMapper exchangeRateMapper;

    @Override
    public Flux<ExchangeRate> getAllExchangeRate() {
        return exchangeRateMapper.getAllExchangeRate();
    }

    @Override
    public Mono<ExchangeRate> findExchangeRateByType(String type) {
        return exchangeRateMapper.getAllExchangeRate()
                .filter(exchange -> exchange.getType().equals(type))
                .next();
    }

}
