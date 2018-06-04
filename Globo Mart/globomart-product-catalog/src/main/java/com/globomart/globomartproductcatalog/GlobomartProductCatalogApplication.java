package com.globomart.globomartproductcatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableEurekaClient
@EnableJpaRepositories
@SpringBootApplication
public class GlobomartProductCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlobomartProductCatalogApplication.class, args);
	}

}
