package com.sai.agro.service;

import java.util.List;

import com.sai.agro.model.Email;

public interface EmailService {
	public void addEmail(Email email);
	public List<Email> listEmail();
	public Email getEmail(int email_id);
	public void deleteEmail(int email_id);
}
