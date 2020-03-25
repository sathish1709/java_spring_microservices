package com.spring.cloud.currencyexchangeservice;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeServiceController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRepository exchangeValueRepository;
	

	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchangeValue returnCurrencyValue(@PathVariable String from, @PathVariable String to ) {
	
		//CurrencyExchangeValue currencyExchangeValue = new CurrencyExchangeValue( from, to, 1000L, BigDecimal.valueOf(65));

		CurrencyExchangeValue currencyExchangeValue =  exchangeValueRepository.findByFromAndTo(from, to);
		
		logger.info("{}",currencyExchangeValue);
		
		currencyExchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return currencyExchangeValue;
		
	}
	

}
