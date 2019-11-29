package com.product.model.service;

import java.util.List;
import java.util.Optional;

import com.product.model.dao.entites.Product;

public interface ProductService {
	
	public List<Product> getAllDetails();
	public Optional<Product> findbyId(int id);
	public Optional<Product> findByName(String name);
	public void deleteProduct(int id);
	public Product addProduct(Product product);
	public Product updateProduct(Product product,int id);
	
	
	
	
	
	
	
	
	
	/*public List<book> getAllBooks();
	public Optional<book> findById(int id);
	public Optional<book> findByTitle(String title);
	public Optional<book> findByIsbn(String isbn);


	public void deleteBook(int id);
	public book addBook(book book);
	public book updateBook(book book,int id);
*/
}
