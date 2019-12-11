package com.gm.statistical;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableDiscoveryClient
@EnableFeignClients
@EnableAsync
@SpringBootApplication(scanBasePackages = {"com.gm.core.base.aop", "com.gm.statistical"})
public class StatisticalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StatisticalServiceApplication.class, args);
	}

}
