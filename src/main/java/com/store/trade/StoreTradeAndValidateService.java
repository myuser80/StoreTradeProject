package com.store.trade;

import org.springframework.boot.SpringApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableScheduling
public class StoreTradeAndValidateService {

	public static void main(String[] args) {
		SpringApplication.run(StoreTradeAndValidateService.class, args);
	}

}
