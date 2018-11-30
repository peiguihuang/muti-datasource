package com.infun.bi.client.message;


import com.infun.bi.client.AbstactHystrixClient;
import com.infun.bi.common.ResultMap;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("HystrixMessageClient")
public class HystrixMessageClient extends AbstactHystrixClient implements IMessageClient {

	@Autowired
	private IMessageClient supplierClient;

	private Logger logger = LoggerFactory.getLogger(IMessageClient.class);

	public Map<String, Object> fallbackStr(Map<String, Object> json, Throwable e) {
		logger.error("FAILED SERVICE CALL!" + e.getMessage(), e);
		String fallback = ("FAILED SERVICE CALL! - supply FALLING BACK");
		return new ResultMap().failure().errmsg(fallback).map();
	}
	public Map<String, Object> fallbackStr(String json, Throwable e) {
		logger.error("FAILED SERVICE CALL!" + e.getMessage(), e);
		String fallback = ("FAILED SERVICE CALL! - supply FALLING BACK");
		return new ResultMap().failure().errmsg(fallback).map();
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallbackStr", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT) })
	public Map<String, Object> sendMobileMsg(Map<String, Object> json) {
		logger.info("=========>>>"+json);
		return supplierClient.sendMobileMsg(json);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallbackStr", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
	public Map<String, Object> iscode(String json) {
		return supplierClient.iscode(json);
	}

}
