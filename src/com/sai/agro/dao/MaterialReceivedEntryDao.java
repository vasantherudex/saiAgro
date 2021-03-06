package com.sai.agro.dao;

import java.util.List;

import com.sai.agro.model.MaterialReceivedEntry;

public interface MaterialReceivedEntryDao {
	public void addMaterialReceivedEntry(MaterialReceivedEntry materialReceivedEntry);
	public List<MaterialReceivedEntry> listMaterialReceivedEntry();
	public MaterialReceivedEntry getMaterialReceivedEntry(int material_received_entry_id);
	public void deleteMaterialReceivedEntry(int material_received_entry_id);
}
