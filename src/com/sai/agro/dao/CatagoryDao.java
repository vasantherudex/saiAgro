package com.sai.agro.dao;

import java.util.List;

import com.sai.agro.model.Catagory;

public interface CatagoryDao {
	public void addCatagory(Catagory catagory);
	public List<Catagory> listCatagory();
	public Catagory getCatagory(int catagory_id);
	public void deleteCatagory(int catagory_id);
}
