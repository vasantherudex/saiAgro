package com.sai.agro.bean;

public class ProductBean {

	private Integer product_id;
	private String product_code;
	private String product_name;
	private int packing_id;
	private int catagory_id;
	private int technical_id;
	private String company_code;
	private int quantity_on_hand;
	private Float purchase_rate;
	private Float sale_rate;
	private Float mrp;
	private int vat;
	
	
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getPacking_id() {
		return packing_id;
	}
	public void setPacking_id(int packing_id) {
		this.packing_id = packing_id;
	}
	public int getCatagory_id() {
		return catagory_id;
	}
	public void setCatagory_id(int catagory_id) {
		this.catagory_id = catagory_id;
	}
	public int getTechnical_id() {
		return technical_id;
	}
	public void setTechnical_id(int technical_id) {
		this.technical_id = technical_id;
	}
	public String getCompany_code() {
		return company_code;
	}
	public void setCompany_code(String company_code) {
		this.company_code = company_code;
	}
	public int getQuantity_on_hand() {
		return quantity_on_hand;
	}
	public void setQuantity_on_hand(int quantity_on_hand) {
		this.quantity_on_hand = quantity_on_hand;
	}
	public Float getPurchase_rate() {
		return purchase_rate;
	}
	public void setPurchase_rate(Float purchase_rate) {
		this.purchase_rate = purchase_rate;
	}
	public Float getSale_rate() {
		return sale_rate;
	}
	public void setSale_rate(Float sale_rate) {
		this.sale_rate = sale_rate;
	}
	public Float getMrp() {
		return mrp;
	}
	public void setMrp(Float mrp) {
		this.mrp = mrp;
	}
	public int getVat() {
		return vat;
	}
	public void setVat(int vat) {
		this.vat = vat;
	}
}
