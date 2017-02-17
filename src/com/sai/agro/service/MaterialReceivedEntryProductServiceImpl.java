package com.sai.agro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sai.agro.dao.MaterialReceivedEntryProductDao;
import com.sai.agro.model.MaterialReceivedEntryProduct;

@Service("materialReceivedEntryProductService")
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class MaterialReceivedEntryProductServiceImpl implements MaterialReceivedEntryProductService {

	@Autowired
	private MaterialReceivedEntryProductDao materialReceivedEntryProductDao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void addMaterialReceivedEntryProduct(MaterialReceivedEntryProduct materialReceivedEntryProduct) {
		materialReceivedEntryProductDao.addMaterialReceivedEntryProduct(materialReceivedEntryProduct);
	}

	@Override
	public List<MaterialReceivedEntryProduct> listMaterialReceivedEntryProducts() {
		return materialReceivedEntryProductDao.listMaterialReceivedEntryProducts();
	}

	@Override
	public MaterialReceivedEntryProduct getMaterialReceivedEntryProduct(int material_received_entry_product_id) {
		return materialReceivedEntryProductDao.getMaterialReceivedEntryProduct(material_received_entry_product_id);
	}

	@Override
	public void deleteMaterialReceivedEntryProduct(int material_received_entry_product_id) {
		materialReceivedEntryProductDao.deleteMaterialReceivedEntryProduct(material_received_entry_product_id);
	}

}
