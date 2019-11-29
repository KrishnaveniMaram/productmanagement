package com.product.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.product.model.dao.entites.Product;
@Repository
public interface ProductDao extends CrudRepository<Product, Integer> {
	
	public Optional<Product> findById(int id);

}
