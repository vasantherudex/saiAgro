package com.sai.agro.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sai.agro.model.MaterialReceivedEntryProduct;

@Repository("materialReceivedEntryProductDao")
public class MaterialReceivedEntryProductDaoImpl implements MaterialReceivedEntryProductDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addMaterialReceivedEntryProduct(MaterialReceivedEntryProduct materialReceivedEntryProduct) {
		sessionFactory.getCurrentSession().saveOrUpdate(materialReceivedEntryProduct);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MaterialReceivedEntryProduct> listMaterialReceivedEntryProducts() {
		return (List<MaterialReceivedEntryProduct>) sessionFactory.getCurrentSession().createCriteria(MaterialReceivedEntryProduct.class).list();
	}

	@Override
	public MaterialReceivedEntryProduct getMaterialReceivedEntryProduct(int material_received_entry_product_id) {
		return (MaterialReceivedEntryProduct) sessionFactory.getCurrentSession().get(MaterialReceivedEntryProduct.class, material_received_entry_product_id);
	}

	@Override
	public void deleteMaterialReceivedEntryProduct(int material_received_entry_product_id) {
		sessionFactory.getCurrentSession().createQuery("delete from MaterialReceivedEntryProduct where material_received_entry_product_id = "+material_received_entry_product_id).executeUpdate();
	}

}
