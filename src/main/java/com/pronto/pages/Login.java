package com.pronto.pages;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Import;
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

@Import(

		stylesheet = { "context:css/font-family.css", "context:css/font-family-opensans.css",
				"context:css/font-awesome.min.css", "context:css/simple-line-icons.min.css",
				"context:css/uniform.default.css", "context:css/bootstrap-switch.min.css",
				"context:js/select2/css/select2.min.css", "context:js/select2/css/select2-bootstrap.min.css",
				"context:css/components-md.min.css", "context:css/plugins-md.min.css", "context:css/login.css",
				"context:css/custom.min.css" }, library = { "context:js/bootstrap/js/bootstrap.min.js",
						"context:js/js.cookie.min.js",
						"context:js/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js",
						"context:js/bootstrap-switch/js/bootstrap-switch.min.js", "context:js/moment.min.js",
						"context:js/jquery-validation/js/jquery.validate.min.js",
						"context:js/jquery-validation/js/additional-methods.min.js",
						"context:js/select2/js/select2.full.min.js", "context:js/backstretch/jquery.backstretch.min.js",
						"context:js/app.min.js", "context:js/login.js" })
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
		try {
			Subject currentUser = securityService.getSubject();
			if (currentUser == null) {
				throw new IllegalStateException("Subject can`t be null");
			}
			SavedRequest savedRequest = WebUtils.getAndClearSavedRequest(requestGlobals.getHTTPServletRequest());
			if (savedRequest != null && savedRequest.getMethod().equalsIgnoreCase("GET")) {
				response.sendRedirect(savedRequest.getRequestUrl());
				return null;
			} else {
				System.err.println("success");
				return pageService.getSuccessURL();
			}
		} catch (IOException e) {
			System.err.println("success!");
			return pageService.getSuccessURL();
		}

	}
}
