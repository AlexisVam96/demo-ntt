package com.nttdata.demo.app_api_exchange_rate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ChannelDemoApiClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChannelDemoApiClientApplication.class, args);
	}

}
