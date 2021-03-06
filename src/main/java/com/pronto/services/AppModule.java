package com.pronto.services;

import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.hibernate.HibernateConfigurer;
import org.apache.tapestry5.hibernate.HibernateEntityPackageManager;
import org.apache.tapestry5.hibernate.HibernateTransactionAdvisor;
import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.MethodAdviceReceiver;
import org.apache.tapestry5.ioc.OrderedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Advise;
import org.apache.tapestry5.ioc.annotations.Contribute;
import org.apache.tapestry5.ioc.annotations.InjectService;
import org.apache.tapestry5.ioc.services.ApplicationDefaults;
import org.apache.tapestry5.ioc.services.SymbolProvider;
import org.tynamo.security.SecuritySymbols;
import org.tynamo.security.services.SecurityFilterChainFactory;
import org.tynamo.security.services.impl.SecurityFilterChain;

import com.pronto.dao.CoreDAO;
import com.pronto.dao.CustomHibernateConfigurer;
import com.pronto.dao.hibernate.CoreDAOHibernate;
import com.pronto.dao.hibernate.UserRealm;

public class AppModule {
	public static void bind(ServiceBinder binder) {
		binder.bind(CoreDAO.class, CoreDAOHibernate.class);
		binder.bind(AuthorizingRealm.class, UserRealm.class).withId(UserRealm.class.getSimpleName());
		binder.bind(EmailService.class);
	}

	public static void contributeFactoryDefaults(MappedConfiguration<String, Object> configuration) {
		configuration.override(SymbolConstants.APPLICATION_VERSION, "1.0");
		configuration.override(SymbolConstants.PRODUCTION_MODE, false);
	}

	public static void contributeApplicationDefaults(MappedConfiguration<String, Object> configuration) {
		configuration.add(SecuritySymbols.LOGIN_URL, "/login");
		configuration.add(SecuritySymbols.SUCCESS_URL, "/index");
		configuration.add(SecuritySymbols.UNAUTHORIZED_URL, "/login");
		configuration.add(SymbolConstants.SUPPORTED_LOCALES, "eng");
		configuration.add(SymbolConstants.HMAC_PASSPHRASE, "pronto");
		configuration.add(SymbolConstants.ENABLE_PAGELOADING_MASK, false);
	}

	public static void contributeSecurityConfiguration(Configuration<SecurityFilterChain> configuration,
			SecurityFilterChainFactory factory) {
		configuration.add(factory.createChain("/assets/**").add(factory.anon()).build());
		configuration.add(factory.createChain("/modules**/**").add(factory.anon()).build());
		configuration.add(factory.createChain("/login").add(factory.anon()).build());
		configuration.add(factory.createChain("/login**").add(factory.anon()).build());
		configuration.add(factory.createChain("/images/**").add(factory.anon()).build());
		configuration.add(factory.createChain("/**").add(factory.authc()).build());
	}

	@Contribute(SymbolProvider.class)
	@ApplicationDefaults
	public static void setupEnvironment(MappedConfiguration<String, Object> configuration) {
		configuration.add(SymbolConstants.JAVASCRIPT_INFRASTRUCTURE_PROVIDER, "jquery");
	}

	@Contribute(HibernateEntityPackageManager.class)
	public static void addPackagesToScan(Configuration<String> configuration) {
		configuration.add("com.pronto.entities");
	}

	public void contributeHibernateSessionSource(OrderedConfiguration<HibernateConfigurer> configuration) {
		configuration.addInstance("HibernateConfigurer", CustomHibernateConfigurer.class);
	}

	@Contribute(WebSecurityManager.class)
	public static void addRealms(Configuration<Realm> configuration,
			@InjectService("UserRealm") AuthorizingRealm userRealm) {
		configuration.add(userRealm);
	}

	@Advise(serviceInterface = CoreDAO.class)
	public static void adviseTransactionally(HibernateTransactionAdvisor advisor, MethodAdviceReceiver receiver) {
		advisor.addTransactionCommitAdvice(receiver);
	}
}
