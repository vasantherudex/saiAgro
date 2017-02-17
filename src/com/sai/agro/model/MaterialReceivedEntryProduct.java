package com.sai.agro.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="material_received_entry_product")
public class MaterialReceivedEntryProduct {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer material_received_entry_product_id;
	@Column
	private int product_id;
	@Column
	private Long quantity;
	@Column
	private Float rate;
	@Column
	private String batch;
	@Column
	@Type(type="date")
	private Date mfgdate;
	@Column
	@Type(type="date")
	private Date expdate;
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public Date getExpdate() {
		return expdate;
	}
	public void setExpdate(Date expdate) {
		this.expdate = expdate;
	}
	public Integer getMaterial_received_entry_product_id() {
		return material_received_entry_product_id;
	}
	public void setMaterial_received_entry_product_id(Integer material_received_entry_product_id) {
		this.material_received_entry_product_id = material_received_entry_product_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Float getRate() {
		return rate;
	}
	public void setRate(Float rate) {
		this.rate = rate;
	}
	public Date getMfgdate() {
		return mfgdate;
	}
	public void setMfgdate(Date mfgdate) {
		this.mfgdate = mfgdate;
	}
	
}
