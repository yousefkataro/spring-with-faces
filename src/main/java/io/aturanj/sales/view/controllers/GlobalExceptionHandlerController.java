package io.aturanj.sales.view.controllers;


import io.aturanj.sales.service.EmailService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.Arrays;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandlerController{

	@Value("${admin.emailaccount}")
	private String adminEmailAccount;

	@Autowired
	private EmailService emailService;

	@ExceptionHandler({ SQLException.class, DataAccessException.class })
	public void databaseError(HttpServletRequest req, Exception exception) throws EmailException {
		log.error("Database Error: " + exception.getMessage());
		emailService.sendEmail( Arrays.asList(adminEmailAccount), null, "Data Base Error", getExceptionTrace(exception));
	}

    @ExceptionHandler(value = Exception.class)
	public void handleError(HttpServletRequest req, Exception exception) throws EmailException {
		log.error("Generic Error: " + exception.getMessage());
		emailService.sendEmail( Arrays.asList(adminEmailAccount), null, "Generic Error", getExceptionTrace(exception));
	}

    @ExceptionHandler(value = EmailException.class)
	public void handleEmailError(HttpServletRequest req, Exception exception) throws EmailException {
    	log.error("Email Error: " + exception.getMessage());
    	emailService.sendEmail( Arrays.asList(adminEmailAccount), null, "Email Error", getExceptionTrace(exception));
	}

    private String getExceptionTrace(Exception e){
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		return sw.toString();
    }



}
