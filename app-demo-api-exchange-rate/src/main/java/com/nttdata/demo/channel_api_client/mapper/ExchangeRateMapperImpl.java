package com.nttdata.demo.channel_api_client.mapper;

import com.nttdata.demo.channel_api_client.entity.ExchangeRate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ExchangeRateMapperImpl implements ExchangeRateMapper{

    @Override
    public Flux<ExchangeRate> getAllExchangeRate() {

        ExchangeRate exchange1 = new ExchangeRate("USD", 3.72);
        ExchangeRate exchange2 = new ExchangeRate("EUR", 4.12);

        return Flux.just(exchange1, exchange2);
    }
}
