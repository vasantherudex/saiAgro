package com.sai.agro.bean;

public class MaterialReceivedEntryProductBean {
	private String material_received_entry_product_id;
	private String product_id;
	private String quantity;
	private String rate;
	private String batch;
	private String mfgdate;
	private String expdate;
	
	public String getMaterial_received_entry_product_id() {
		return material_received_entry_product_id;
	}
	public void setMaterial_received_entry_product_id(String material_received_entry_product_id) {
		this.material_received_entry_product_id = material_received_entry_product_id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public String getMfgdate() {
		return mfgdate;
	}
	public void setMfgdate(String mfgdate) {
		this.mfgdate = mfgdate;
	}
	public String getExpdate() {
		return expdate;
	}
	public void setExpdate(String expdate) {
		this.expdate = expdate;
	}
	
}
