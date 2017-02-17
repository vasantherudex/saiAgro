package com.sai.agro.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sai.agro.model.MaterialReceivedEntry;

@Repository("materialReceivedEntryDao")
public class MaterialReceivedEntryDaoImpl implements MaterialReceivedEntryDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addMaterialReceivedEntry(MaterialReceivedEntry materialReceivedEntry) {
		sessionFactory.getCurrentSession().saveOrUpdate(materialReceivedEntry);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MaterialReceivedEntry> listMaterialReceivedEntry() {
		return (List<MaterialReceivedEntry>) sessionFactory.getCurrentSession().createCriteria(MaterialReceivedEntry.class).list();
	}

	@Override
	public MaterialReceivedEntry getMaterialReceivedEntry(int material_received_entry_id) {
		return (MaterialReceivedEntry) sessionFactory.getCurrentSession().get(MaterialReceivedEntry.class, material_received_entry_id);
	}

	@Override
	public void deleteMaterialReceivedEntry(int material_received_entry_id) {
		sessionFactory.getCurrentSession().createQuery("delete from MaterialReceivedEntry where material_received_entry_id = "+material_received_entry_id).executeUpdate();
	}

}
