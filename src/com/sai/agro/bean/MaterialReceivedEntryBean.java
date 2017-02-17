package com.sai.agro.bean;

import java.util.Date;

public class MaterialReceivedEntryBean {

	private Integer material_received_entry_id;
	private String voucher_no;
	private Date transaction_date;
	private String supplier_code;
	private String supplier_name;
	private String dc_no;
	private Date dc_date;
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
	
	
}
