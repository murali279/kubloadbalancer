package com.in28minutes.microservices.currencyconversionservice.resource;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange", url = "${CURRENCY_EXCHANGE_SERVICE_HOST:http://localhost}:8000")//KUB_HARD_CODED: Works
//@FeignClient(name = "currency-exchange", url = "${KEY_CURRENCY_EXCHANGE_SERVICE_HOST:XXX}:${KEY_CURRENCY_EXCHANGE_SERVICE_PORT:7777}") //KEY_CURRENCY_EXCHANGE_SERVICE_HOST in config map works
public interface CurrencyExchangeServiceProxy {
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from,
			@PathVariable("to") String to);
}