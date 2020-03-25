package com.spring.netflixeurekanamingserver;



import javax.servlet.http.HttpServletRequest;

import org.apache.http.protocol.RequestContent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//should this filter be executed or not
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	
	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		//logging any api request that go through this API gateway
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("The request -> {} request uri -> {}", request, request.getRequestURI());
		
		
		return null;
	}

	// should the filter execute before or after the request or only error filter
	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	//priority order for zullFilter order
	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
