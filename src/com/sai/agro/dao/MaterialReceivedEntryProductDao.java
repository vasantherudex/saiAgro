package com.sai.agro.dao;

import java.util.List;

import com.sai.agro.model.MaterialReceivedEntryProduct;

public interface MaterialReceivedEntryProductDao {
	public void addMaterialReceivedEntryProduct(MaterialReceivedEntryProduct materialReceivedEntryProduct);
	public List<MaterialReceivedEntryProduct> listMaterialReceivedEntryProducts();
	public MaterialReceivedEntryProduct getMaterialReceivedEntryProduct(int material_received_entry_product_id);
	public void deleteMaterialReceivedEntryProduct(int material_received_entry_product_id);
}

