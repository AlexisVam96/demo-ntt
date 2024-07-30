package com.nttdata.demo.app_api_exchange_rate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ExchangeRate {

    private Integer id;

    private String type;

    private Double valor;

    private LocalDateTime create_at;
}
