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
@Table(name="material_received_entry")
public class MaterialReceivedEntry {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer material_received_entry_id;
	@Column(name="vrno")
	private String voucher_no;
	@Column(name="trdate")
	@Type(type="date")
	private Date transaction_date;
	@Column(name="acctId")
	private String supplier_code;
	@Column
	private String supplier_name;
	@Column(name="dcno")
	private String dc_no;
	@Column(name="dcdate")
	@Type(type="date")
	private Date dc_date;
	
	public String getDc_no() {
		return dc_no;
	}
	public void setDc_no(String dc_no) {
		this.dc_no = dc_no;
	}
	public Date getDc_date() {
		return dc_date;
	}
	public void setDc_date(Date dc_date) {
		this.dc_date = dc_date;
	}
	public Integer getMaterial_received_entry_id() {
		return material_received_entry_id;
	}
	public void setMaterial_received_entry_id(Integer material_received_entry_id) {
		this.material_received_entry_id = material_received_entry_id;
	}
	public String getVoucher_no() {
		return voucher_no;
	}
	public void setVoucher_no(String voucher_no) {
		this.voucher_no = voucher_no;
	}
	
	public Date getTransaction_date() {
		return transaction_date;
	}
	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}
	public String getSupplier_code() {
		return supplier_code;
	}
	public void setSupplier_code(String supplier_code) {
		this.supplier_code = supplier_code;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	
}
