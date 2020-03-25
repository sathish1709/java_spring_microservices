package com.spring.cloud.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<CurrencyExchangeValue, Long>{
	
	CurrencyExchangeValue findByFromAndTo(String from, String to);

}
