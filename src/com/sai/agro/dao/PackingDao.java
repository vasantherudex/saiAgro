package com.sai.agro.dao;

import java.util.List;

import com.sai.agro.model.Packing;

public interface PackingDao {
	public void addPacking(Packing packing);
	public List<Packing> listPacking();
    public Packing getPacking(int packing_id);
    public void deletePacking(int packing_id);
}
