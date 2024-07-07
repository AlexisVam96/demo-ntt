package com.nttdata.demo.channel_api_client.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExchangeRate {

    private String type;

    private Double value;
}
