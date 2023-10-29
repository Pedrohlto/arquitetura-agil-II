package com.minhaempresa.meuecommerce.appvenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppVendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppVendaApplication.class, args);
	}

}
