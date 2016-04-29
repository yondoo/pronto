package com.pronto.dao;

import org.apache.tapestry5.hibernate.HibernateConfigurer;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.ImprovedNamingStrategy;

public class CustomHibernateConfigurer implements HibernateConfigurer {
	public void configure(Configuration configuration) {
		configuration.setNamingStrategy(ImprovedNamingStrategy.INSTANCE);
	}
}
