package com.sai.agro.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sai.agro.model.ProductOpeningStock;

@Repository("productOpeningStockDao")
public class ProductOpeningStockDaoImpl implements ProductOpeningStockDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addProductOpeningStock(ProductOpeningStock productOpeningStock) {
		sessionFactory.getCurrentSession().saveOrUpdate(productOpeningStock);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductOpeningStock> listProductOpeningStocks() {
		return (List<ProductOpeningStock>) sessionFactory.getCurrentSession().createCriteria(ProductOpeningStock.class).list();
	}

	@Override
	public ProductOpeningStock getProductOpeningStock(int product_opening_stock_id) {
		return (ProductOpeningStock) sessionFactory.getCurrentSession().get(ProductOpeningStock.class, product_opening_stock_id);
	}

	@Override
	public void deleteProductOpeningStock(int product_opening_stock_id) {
		sessionFactory.getCurrentSession().createQuery("delete from ProductOpeningStock where product_opening_stock_id ="+product_opening_stock_id).executeUpdate();
	}

}
