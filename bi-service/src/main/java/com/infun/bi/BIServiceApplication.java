package com.infun.bi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableCaching
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@EnableAsync
@ComponentScan(basePackages="com.infun")
public class BIServiceApplication {

	public static void main(String[] args) {
		System.setProperty("java.net.preferIPv4Stack","true");
		SpringApplication.run(BIServiceApplication.class, args);
	}
}
