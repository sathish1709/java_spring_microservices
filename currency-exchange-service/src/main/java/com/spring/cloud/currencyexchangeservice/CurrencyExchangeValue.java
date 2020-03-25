package com.spring.cloud.currencyexchangeservice;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CurrencyExchangeValue {
	
	@Column(name="currency_from")
	private String from;
	
	@Column(name="currency_to")
	private String to;
	
	@Id
	private Long id;
	
	@Column(name="conversion_value")
	private BigDecimal conversionMulitple;
	private int port;
	
	

	public CurrencyExchangeValue() {
	
	}


	public CurrencyExchangeValue(String from, String to, Long id, BigDecimal conversionMulitple) {
		super();
		this.from = from;
		this.to = to;
		this.id = id;
		this.conversionMulitple = conversionMulitple;
	}


	public String getFrom() {
		return from;
	}


	public void setFrom(String from) {
		this.from = from;
	}


	public String getTo() {
		return to;
	}


	public void setTo(String to) {
		this.to = to;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getPort() {
		return port;
	}


	public void setPort(int port) {
		this.port = port;
	}

	public BigDecimal getConversionMulitple() {
		return conversionMulitple;
	}


	public void setConversionMulitple(BigDecimal conversionMulitple) {
		this.conversionMulitple = conversionMulitple;
	}


}
