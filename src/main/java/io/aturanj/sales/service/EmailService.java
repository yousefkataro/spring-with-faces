package io.aturanj.sales.service;

import org.apache.commons.mail.EmailException;

import java.util.List;

public interface EmailService {
	public void sendEmail(List<String> to, List<String> cc, String subject, String content) throws EmailException;

}
