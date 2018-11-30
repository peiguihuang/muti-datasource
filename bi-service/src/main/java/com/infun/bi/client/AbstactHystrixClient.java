package com.infun.bi.client;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@DefaultProperties(commandProperties = {
		@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
		@HystrixProperty(name = "execution.timeout.enabled", value = "true"),
		@HystrixProperty(name = "execution.isolation.thread.interruptOnTimeout",value="true") }, threadPoolProperties = {
				@HystrixProperty(name="maxQueueSize", value=""+Integer.MAX_VALUE),
				@HystrixProperty(name="queueSizeRejectionThreshold", value=""+Integer.MAX_VALUE) })
public abstract class AbstactHystrixClient {

}
