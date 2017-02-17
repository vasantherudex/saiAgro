package com.sai.agro.dao;

import java.util.List;

import com.sai.agro.model.Product;


public interface ProductDao {
	public void addProduct(Product product);
	public List<Product> listProducts();
	public List<Product> listProducts(String product_code);
	public Product getProduct(int product_id);
	public void deleteProduct(int product_id);	
}
