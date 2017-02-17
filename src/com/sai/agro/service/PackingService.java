package com.sai.agro.service;

import java.util.List;

import com.sai.agro.model.Packing;

public interface PackingService {
	public void addPacking(Packing packing);
	public List<Packing> listPacking();
    public Packing getPacking(int packing_id);
    public void deletePacking(int packing_id);
}
