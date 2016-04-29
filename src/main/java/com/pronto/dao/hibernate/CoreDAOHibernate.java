package com.pronto.dao.hibernate;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.pronto.dao.CoreDAO;
import com.pronto.entities.account.Account;

public class CoreDAOHibernate implements CoreDAO {

	@Inject
	private Session session;

	public CoreDAOHibernate(Session session) {
		this.session = session;
	}

	@Override
	public void saveOrUpdateObject(Object obj) {
		session.saveOrUpdate(obj);
	}

	public Account getUser(String username) {
		Criteria criteria = session.createCriteria(Account.class);
		criteria.add(Restrictions.eq("username", username));
		return (Account) criteria.uniqueResult();
	}

}