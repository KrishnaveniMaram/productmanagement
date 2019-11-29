package com.product.web.controller;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.dao.entites.Product;
import com.product.model.service.ProductNotFoundException;
import com.product.model.service.ProductService;

@RestController //conatin controler+response body
@RequestMapping(path="/api")
public class ProductRestController {
	
	private ProductService service;
    @Autowired
	public ProductRestController(ProductService service) {
		this.service = service;
	}
    @GetMapping(path="/product",produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> ShowAllDetails(){
    	return new ResponseEntity<List<Product>>(service.getAllDetails(),HttpStatus.OK);
    }
    
    @GetMapping(path="product/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity< Resource<Product>> getProductById(@PathVariable(name="id")int id){
    	Product product=service.findbyId(id).orElseThrow(ProductNotFoundException::new);
    	Resource<Product>resource=new Resource<Product>(product);
    	ControllerLinkBuilder builder=linkTo(methodOn(this.getClass()).ShowAllDetails());
    	resource.add(builder.withRel("products"));
    	return new ResponseEntity<Resource<Product>>(resource,HttpStatus.OK);
    }
   /* @GetMapping(path="product/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<product> getProductById(@PathVariable(name="id")int id){
    	product product=service.findbyId(id).orElseThrow(ProductNotFoundException::new);
    	return new ResponseEntity<product>(product,HttpStatus.OK);
    }*/
   
    
   
    @DeleteMapping(path="/product/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteProduct(@PathVariable(name="id") int id){
    	service.deleteProduct(id);
    	return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
    
	@PostMapping(path="/product",consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product){
    	Product product2=service.addProduct(product);
    	return new ResponseEntity<Product>(product2,HttpStatus.CREATED);
    }
    
    @PutMapping(path="/product/{id}",consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)//json to java
    public ResponseEntity<Product> updateProduct( @Valid @RequestBody Product product,
    		@PathVariable(name="id") int id){
    	Product product2=service.updateProduct(product, id);
    	return new ResponseEntity<Product>(product2,HttpStatus.CREATED);
    }
    
}
