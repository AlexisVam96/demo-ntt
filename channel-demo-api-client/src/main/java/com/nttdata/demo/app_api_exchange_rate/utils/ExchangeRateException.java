package com.nttdata.demo.app_api_exchange_rate.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExchangeRateException extends Exception{

    private Integer status;
    private String message;
    private String code;
}
