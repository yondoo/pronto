package com.pronto.aso;

import java.io.Serializable;

import org.apache.tapestry5.annotations.Persist;
import org.hibernate.Session;

import com.pronto.entities.account.Account;

public class LoginState implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Session session;
	@Persist
	private Account account;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
