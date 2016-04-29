package com.pronto.dao;

import org.apache.tapestry5.hibernate.annotations.CommitAfter;

import com.pronto.entities.account.Account;

public interface CoreDAO {

	@CommitAfter
	public void saveOrUpdateObject(Object obj);

	public Account getUser(String username);
}