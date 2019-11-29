package com.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages={"com.product"})//entityscan is used if dis in another pack
@EntityScan(basePackages={"com.product.model.dao.entites"})
public class ProductAppApplication{

public ProductAppApplication() {
	// TODO Auto-generated constructor stub
}
	public static void main(String[] args) {
		SpringApplication.run(ProductAppApplication.class, args);//configuration of dispatcer servlet
	}
}

