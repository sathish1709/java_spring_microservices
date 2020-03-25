package com.spring.cloud.limitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spring.cloud.limitService.bean.limitConfiguration;

@RestController
@EnableDiscoveryClient
public class LimitsConfigurationController {
	
	@Autowired
	private Configuration configuration;
	
	@GetMapping("/limits")
	@HystrixCommand(fallbackMethod = "retrieveConfiguration")
	public limitConfiguration retrieveLimitsFromConfiguration() {
		return new limitConfiguration(configuration.getMinimum(), configuration.getMaximum());
		
	}

	@GetMapping("/fault-tolerance")
	@HystrixCommand(fallbackMethod = "fallBackRetrieveConfiguration")
	public limitConfiguration retrieveConfiguration() {
		throw new RuntimeException("not availabe");
		
	}
	
	public limitConfiguration fallBackRetrieveConfiguration() {
		return new limitConfiguration(9,900);
		
	}
}
