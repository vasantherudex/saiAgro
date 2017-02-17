package com.sai.agro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sai.agro.dao.ProductOpeningStockDao;
import com.sai.agro.model.ProductOpeningStock;

@Service("productOpeningStockService")
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class ProductOpeningStockServiceImpl implements ProductOpeningStockService {

	@Autowired
	private ProductOpeningStockDao productOpeningStockDao;
	
	@Override
	public void addProductOpeningStock(ProductOpeningStock productOpeningStock) {
		productOpeningStockDao.addProductOpeningStock(productOpeningStock);
	}

	@Override
	public List<ProductOpeningStock> listProductOpeningStocks() {
		return productOpeningStockDao.listProductOpeningStocks();
	}

	@Override
	public ProductOpeningStock getProductOpeningStock(int product_opening_stock_id) {
		return productOpeningStockDao.getProductOpeningStock(product_opening_stock_id);
	}

	@Override
	public void deleteProductOpeningStock(int product_opening_stock_id) {
		productOpeningStockDao.deleteProductOpeningStock(product_opening_stock_id);
	}

}
