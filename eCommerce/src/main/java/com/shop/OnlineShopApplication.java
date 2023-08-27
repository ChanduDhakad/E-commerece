package com.shop;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineShopApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(OnlineShopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Application is up and running....");
	}
}
