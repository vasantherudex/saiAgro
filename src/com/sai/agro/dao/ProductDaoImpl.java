package com.sai.agro.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sai.agro.model.Product;

@Repository("productDao")
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addProduct(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> listProducts() {
		return (List<Product>) sessionFactory.getCurrentSession().createCriteria(Product.class).list();
	}

	@Override
	public Product getProduct(int product_id) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, product_id);
	}

	@Override
	public void deleteProduct(int product_id) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Product WHERE product_id = "+product_id).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> listProducts(String product_code) {
		return (List<Product>) sessionFactory.getCurrentSession().createCriteria(Product.class).add(Restrictions.ilike("product_code",product_code,MatchMode.ANYWHERE)).list();
	}

}
