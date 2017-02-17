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
@Table(name="product_opening_stock_entry")
public class ProductOpeningStock {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer product_opening_stock_id;
	@Column
	private String product_code;
	@Column
	private String product_name;
	@Column
	private String batch_no;
	@Column
	@Type(type="date")
	private Date mfg_date;
	@Column
	@Type(type="date")
	private Date exp_date;
	@Column
	private Integer opening_qty;
	@Column
	private Float opening_rate;
	public Integer getProduct_opening_stock_id() {
		return product_opening_stock_id;
	}
	public void setProduct_opening_stock_id(Integer product_opening_stock_id) {
		this.product_opening_stock_id = product_opening_stock_id;
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
	public String getBatch_no() {
		return batch_no;
	}
	public void setBatch_no(String batch_no) {
		this.batch_no = batch_no;
	}
	public Date getMfg_date() {
		return mfg_date;
	}
	public void setMfg_date(Date mfg_date) {
		this.mfg_date = mfg_date;
	}
	public Date getExp_date() {
		return exp_date;
	}
	public void setExp_date(Date exp_date) {
		this.exp_date = exp_date;
	}
	public Integer getOpening_qty() {
		return opening_qty;
	}
	public void setOpening_qty(Integer opening_qty) {
		this.opening_qty = opening_qty;
	}
	public Float getOpening_rate() {
		return opening_rate;
	}
	public void setOpening_rate(Float opening_rate) {
		this.opening_rate = opening_rate;
	}

}
