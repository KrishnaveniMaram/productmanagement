package com.product.model.dao.entites;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.product.model.service.ProductService;
@Component
public class Datainit  implements CommandLineRunner{

	@Autowired
	private ProductService service;
	private Logger logger=LoggerFactory.getLogger(Datainit.class);
	@Override
	public void run(String... args) throws Exception {
	service.addProduct(new Product(1,"Dosa", 50.0, 2, "Udupi", "nameofsub", "good", "Break_Fast"));
	service.addProduct(new Product(2,"Rice", 80.0, 1, "babi", "nameofCust", "good", "Lunch"));
	service.addProduct(new Product(3,"roti", 80.0, 1, "babi", "nameofDeliver", "good", "dinner"));
	logger.info("--------added defaultly");	
	}
}
