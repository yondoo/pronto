package com.pronto.pages.message;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.alerts.Duration;
import org.apache.tapestry5.alerts.Severity;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.pronto.dao.CoreDAO;
import com.pronto.entities.account.Account;

public class MessageBroadcast {
	@Inject
	private CoreDAO dao;

	@Property
	@Persist
	private Account account;

	@Inject
	private AlertManager alertManager;

	@Inject
	private Messages messages;

	void beginRender() {
		if (account == null)
			account = new Account();
	}

	Object onSubmit() {
		if (account.getId() == null)
			account.setPassword("123");
		dao.saveOrUpdateObject(account);
		alertManager.alert(Duration.TRANSIENT, Severity.SUCCESS, "sent email");
		return MessageBroadcast.class;
	}
}
