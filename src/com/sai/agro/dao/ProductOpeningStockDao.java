package com.sai.agro.dao;

import java.util.List;

import com.sai.agro.model.ProductOpeningStock;

public interface ProductOpeningStockDao {

	public void addProductOpeningStock(ProductOpeningStock productOpeningStock);
	public List<ProductOpeningStock> listProductOpeningStocks();
	public ProductOpeningStock getProductOpeningStock(int product_opening_stock_id);
	public void deleteProductOpeningStock(int product_opening_stock_id);
}
