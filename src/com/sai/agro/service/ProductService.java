package com.sai.agro.service;

import java.util.List;

import com.sai.agro.model.Product;

public interface ProductService {
	public void addProduct(Product product);
	public List<Product> listProducts();
	public List<Product> listProducts(String product_code);
	public Product getProduct(int product_id);
	public void deleteProduct(int product_id);
}
