package com.pronto.pages;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.alerts.Duration;
import org.apache.tapestry5.alerts.Severity;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Context;
import org.apache.tapestry5.services.RequestGlobals;
import org.apache.tapestry5.services.Response;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.tynamo.security.internal.services.LoginContextService;
import org.tynamo.security.services.SecurityService;

import com.pronto.aso.LoginState;
import com.pronto.dao.CoreDAO;
import com.pronto.entities.account.Account;

public class Login {
	@Inject
	private Logger logger;

	@Inject
	private AlertManager alertManager;

	@SessionState
	private LoginState loginState;

	@Inject
	private CoreDAO dao;

	@Property
	private String email;

	@Property
	private String password;

	@Inject
	private SecurityService securityService;

	@Inject
	private RequestGlobals requestGlobals;

	@Inject
	private HttpServletRequest http;

	@Inject
	private Response response;

	@Inject
	private LoginContextService pageService;

	@Property
	private String username;

	@Inject
	private Messages messages;

	@Inject
	private Session session;

	@Property
	@Persist(PersistenceConstants.FLASH)
	private String message, normal;

	@Property
	@Persist
	private Account account;

	@Inject
	private Context context;

	public Object onActionFromTynamoLoginForm() {
		Subject currentUser = securityService.getSubject();
		if (currentUser == null) {
			throw new IllegalStateException("Буруу утга байна.");
		}
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		try {
			currentUser.login(token);
			account = dao.getUser(username);
			loginState.setAccount(account);

		} catch (UnknownAccountException e) {
			message = messages.get("unknownAccount");
			return null;
		} catch (IncorrectCredentialsException e) {
			message = messages.get("wrongUsernameOrPassword");
			return null;
		} catch (LockedAccountException e) {
			message = messages.get("lockedAccount");
			return null;
		} catch (AuthenticationException e) {
			message = messages.get("wrongUsernameOrPassword");
			return null;
		}
		SavedRequest savedRequest = WebUtils.getAndClearSavedRequest(requestGlobals.getHTTPServletRequest());
		try {
			if (savedRequest != null && savedRequest.getMethod().equalsIgnoreCase("GET")) {
				response.sendRedirect(savedRequest.getRequestUrl());
				return null;
			} else {
				alertManager.alert(Duration.SINGLE, Severity.SUCCESS, "Тавтай морилно уу!");
				return pageService.getSuccessURL();
			}
		} catch (IOException e) {
			return pageService.getSuccessURL();
		}
	}
}
