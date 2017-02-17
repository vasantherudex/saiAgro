package com.sai.agro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer product_id;
	@Column
	private String product_code;
	@Column
	private String product_name;
	@Column
	private Integer packing_id;
	@Column
	private Integer catagory_id;
	@Column
	private int technical_id;
	@Column
	private String company_code;
	@Column
	private Integer quantity_on_hand;
	@Column
	private Float purchase_rate;
	@Column
	private Float sale_rate;
	@Column
	private Float mrp;
	@Column
	private Integer vat;
	
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
	public Integer getPacking_id() {
		return packing_id;
	}
	public void setPacking_id(Integer packing_id) {
		this.packing_id = packing_id;
	}
	public Integer getCatagory_id() {
		return catagory_id;
	}
	public void setCatagory_id(Integer catagory_id) {
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
	public void setCompany_code(String string) {
		this.company_code = string;
	}
	public Integer getQuantity_on_hand() {
		return quantity_on_hand;
	}
	public void setQuantity_on_hand(Integer quantity_on_hand) {
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
	public Integer getVat() {
		return vat;
	}
	public void setVat(Integer vat) {
		this.vat = vat;
	}
	
}
