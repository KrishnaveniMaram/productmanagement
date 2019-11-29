package com.product.model.dao.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="product_deatils")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;
private String name;
private double price;
private int stockQty;
private String VendorName;
@Size(min=5,max=20,message="minimun characters could be 5 please enter again")
private String supplierAddress;
private  String reviews;
private String productType;

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

public int getStockQty() {
	return stockQty;
}

public void setStockQty(int stockQty) {
	this.stockQty = stockQty;
}

public String getVendorName() {
	return VendorName;
}

public void setVendorName(String vendorName) {
	VendorName = vendorName;
}

public String getSupplierName() {
	return supplierAddress;
}

public void setSupplierName(String supplierAddress) {
	this.supplierAddress = supplierAddress;
}

public String getReviews() {
	return reviews;
}

public void setReviews(String reviews) {
	this.reviews = reviews;
}

public String getProductType() {
	return productType;
}

public void setProductType(String productType) {
	this.productType = productType;
}

public Product(Integer id, String name, double price, int stockQty, String vendorName, String supplierAddress,
		String reviews, String productType) {
	super();
	this.id = id;
	this.name = name;
	this.price = price;
	this.stockQty = stockQty;
	VendorName = vendorName;
	this.supplierAddress = supplierAddress;
	this.reviews = reviews;
	this.productType = productType;
}

public Product(String name, double price, int stockQty, String vendorName, String supplierAddress, String reviews,
		String productType) {
	super();
	this.name = name;
	this.price = price;
	this.stockQty = stockQty;
	VendorName = vendorName;
	this.supplierAddress = supplierAddress;
	this.reviews = reviews;
	this.productType = productType;
}

public Product() {
	
}
@Override
public String toString() {
	return "product [id=" + id + ", name=" + name + ", price=" + price + ", stockQty=" + stockQty + ", VendorName="
			+ VendorName + ", supplierName=" + supplierAddress + ", reviews=" + reviews + ", productType=" + productType
			+ "]";
}

	
	
	
}
