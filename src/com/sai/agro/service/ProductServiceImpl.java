package com.sai.agro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sai.agro.dao.ProductDao;
import com.sai.agro.model.Product;
@Service("productService")
@Transactional(propagation = Propagation.SUPPORTS,readOnly=true)
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=false)
	public void addProduct(Product product) {
		productDao.addProduct(product);
	}

	@Override
	public List<Product> listProducts() {
		return productDao.listProducts();
	}

	@Override
	public Product getProduct(int product_id) {
		return productDao.getProduct(product_id);
	}

	@Override
	public void deleteProduct(int product_id) {
         productDao.deleteProduct(product_id);		
	}

	@Override
	public List<Product> listProducts(String product_code) {
		return productDao.listProducts(product_code);
	}

}
