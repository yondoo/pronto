package com.pronto.pages;

import java.util.HashMap;
import java.util.Map;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.ajax.AjaxResponseRenderer;
import org.slf4j.Logger;

import com.pronto.services.EmailService;
import com.pronto.util.Constants;

/**
 * Start page of application pronto.
 */
public class Index {
	@Inject
	private Logger logger;

	@Inject
	private AjaxResponseRenderer ajaxResponseRenderer;

	@Inject
	private AlertManager alertManager;

	@Inject
	private Messages messages;

	@Inject
	private ComponentResources componentResources;

	@Inject
	private EmailService emailService;

	@Log
	void onSendEmail() {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("url", componentResources.createEventLink(Constants.VIEW_EMAIL).toAbsoluteURI());
		data.put("user", "Dude");
		String html = emailService.getTemplate("test.ftl", data);
		if (emailService.sendEmail("tuguldur.js@gmail.com", "Pronto Test", html)) {
			alertManager.info("Email has been sent successfully.");
		}
	}

	@OnEvent(value = Constants.VIEW_EMAIL)
	void onViewEmail() {
		System.out.println(Constants.VIEW_EMAIL);
	}
}
