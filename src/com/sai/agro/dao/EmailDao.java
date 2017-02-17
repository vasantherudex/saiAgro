package com.sai.agro.dao;

import java.util.List;

import com.sai.agro.model.Email;

public interface EmailDao {
	public void addEmail(Email email);
	public List<Email> listEmail();
	public Email getEmail(int email_id);
	public void deleteEmail(int email_id);
}
