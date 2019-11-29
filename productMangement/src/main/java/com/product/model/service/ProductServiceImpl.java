package com.product.model.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.model.ProductDao;
import com.product.model.dao.entites.Product;
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
private ProductDao dao;
	
@Autowired
public ProductServiceImpl(ProductDao dao) {
		
		this.dao = dao;
	}

	@Override
	public List<Product> getAllDetails() {
		// TODO Auto-generated method stub
		return (List<Product>) dao.findAll();
	}

	@Override
	public Optional<Product> findbyId(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public Optional<Product> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
		
	}

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		
	
		return dao.save(product);
	}

	@Override
public Product updateProduct(Product product, int id) {
		// TODO Auto-generated method stub
		Product productToBeUpdate=dao.findById(id).orElseThrow(ProductNotFoundException::new);
		productToBeUpdate.setPrice(product.getPrice());
		
		return dao.save(productToBeUpdate);
	}

}
