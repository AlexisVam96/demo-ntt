package com.nttdata.demo.app_api_exchange_rate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExchangeRate {

    private String type;

    private Double value;
}
