package com.spring.currencyconversionservice;

import java.math.BigDecimal;


public class CurrencyConversionBean {


	private String from;
	private String to;
	private Long id;
	private BigDecimal conversionMulitple;
	private  BigDecimal quantity;
	private BigDecimal totalAmount;
	private int port;
	
	
	public CurrencyConversionBean() {
		super();
	}
	public CurrencyConversionBean(String from, String to, Long id, BigDecimal conversionMulitple, BigDecimal quantity, BigDecimal totalAmount,
			int port) {
		super();
		this.from = from;
		this.to = to;
		this.id = id;
		this.conversionMulitple = conversionMulitple;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
		this.port = port;
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
	public BigDecimal getConversionMulitple() {
		return conversionMulitple;
	}
	public void setConversionMulitple(BigDecimal conversionMulitple) {
		this.conversionMulitple = conversionMulitple;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	
}
