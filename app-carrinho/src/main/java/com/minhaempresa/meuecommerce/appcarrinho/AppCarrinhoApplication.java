package com.minhaempresa.meuecommerce.appcarrinho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AppCarrinhoApplication {
	public static void main(String[] args) {
		SpringApplication.run(AppCarrinhoApplication.class, args);
	}

}
