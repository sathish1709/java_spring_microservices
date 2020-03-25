package com.spring.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-exchange-service", url="localhost:8000")
//@FeignClient(name="currency-exchange-service")
//take to naming server and get the instance
@FeignClient(name="netflix-zuul-api-gateway-server")
// for load balancing
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	
	
	//@GetMapping("currency-exchange/from/{from}/to/{to}")
	@GetMapping("currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean returnCurrencyValue(@PathVariable String from, @PathVariable String to ) ;
	

}
