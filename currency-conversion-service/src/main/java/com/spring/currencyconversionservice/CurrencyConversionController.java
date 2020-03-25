package com.spring.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean returnCurrencyValue(@PathVariable String from, @PathVariable String to , @PathVariable BigDecimal quantity) {
		
		//Feign - Problem 1: invoking other micro services easily
		// add the uriVariables
		Map<String , String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		// to invoke an external service using rest template
		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().
				getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, uriVariables );
		//getting the body and adding it in bean
		CurrencyConversionBean response  = responseEntity.getBody();
		return new CurrencyConversionBean(from, to ,response.getId(), response.getConversionMulitple(),quantity, quantity.multiply(response.getConversionMulitple()),response.getPort());
	}

	
	@GetMapping("/currency-exchange-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean returnCurrencyValueUsingFeign(@PathVariable String from, @PathVariable String to , @PathVariable BigDecimal quantity) {
		
		//Feign - Problem 1: invoking other micro services easily
		CurrencyConversionBean response  = proxy.returnCurrencyValue(from, to);
		logger.info("{}", response);
		return new CurrencyConversionBean(from, to ,response.getId(), response.getConversionMulitple(),quantity, quantity.multiply(response.getConversionMulitple()),response.getPort());
	}
}
