package com.pronto.pages.account;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.alerts.Duration;
import org.apache.tapestry5.alerts.Severity;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.pronto.aso.LoginState;
import com.pronto.dao.CoreDAO;
import com.pronto.entities.account.Account;

public class AccountEdit {
	@SessionState
	private LoginState loginState;

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
		if (account == null) {
			account = loginState.getAccount();
		}
	}

	Object onSubmit() {
		dao.saveOrUpdateObject(account);
		alertManager.alert(Duration.TRANSIENT, Severity.SUCCESS, "Your account information updated successfully.");
		return AccountEdit.class;
	}
}
