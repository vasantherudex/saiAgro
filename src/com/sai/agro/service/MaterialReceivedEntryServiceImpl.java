package com.sai.agro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sai.agro.dao.MaterialReceivedEntryDao;
import com.sai.agro.model.MaterialReceivedEntry;

@Service("materialReceivedEntryService")
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class MaterialReceivedEntryServiceImpl implements MaterialReceivedEntryService {

	@Autowired
	private MaterialReceivedEntryDao materialReceivedEntryDao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void addMaterialReceivedEntry(MaterialReceivedEntry materialReceivedEntry) {
		materialReceivedEntryDao.addMaterialReceivedEntry(materialReceivedEntry);
	}

	@Override
	public List<MaterialReceivedEntry> listMaterialReceivedEntry() {
		return materialReceivedEntryDao.listMaterialReceivedEntry();
	}

	@Override
	public MaterialReceivedEntry getMaterialReceivedEntry(int material_received_entry_id) {
		return materialReceivedEntryDao.getMaterialReceivedEntry(material_received_entry_id);
	}

	@Override
	public void deleteMaterialReceivedEntry(int material_received_entry_id) {
		materialReceivedEntryDao.deleteMaterialReceivedEntry(material_received_entry_id);
	}

}
