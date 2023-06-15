package com.tutorial.bikestores;

import com.tutorial.bikestores.production.product.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BikestoresApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BikestoresApplication.class, args);

	}

}
