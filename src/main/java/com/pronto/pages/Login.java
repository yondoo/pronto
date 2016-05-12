package com.pronto.pages;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.RequestGlobals;
import org.apache.tapestry5.services.Response;
import org.slf4j.Logger;
import org.tynamo.security.internal.services.LoginContextService;
import org.tynamo.security.services.SecurityService;

import com.pronto.aso.LoginState;
import com.pronto.dao.CoreDAO;
import com.pronto.entities.account.Account;

@Import(

stylesheet = { "context:css/font-family.css", "context:css/font-family-opensans.css",
		"context:css/font-awesome.min.css", "context:css/simple-line-icons.min.css", "context:css/uniform.default.css",
		"context:css/bootstrap-switch.min.css", "context:js/select2/css/select2.min.css",
		"context:js/select2/css/select2-bootstrap.min.css", "context:css/components-md.min.css",
		"context:css/plugins-md.min.css", "context:css/login.css", "context:css/custom.min.css" }, library = {
				"context:js/bootstrap/js/bootstrap.min.js", "context:js/js.cookie.min.js",
				"context:js/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js",
				"context:js/bootstrap-switch/js/bootstrap-switch.min.js", "context:js/moment.min.js",
				"context:js/jquery-validation/js/jquery.validate.min.js",
				"context:js/jquery-validation/js/additional-methods.min.js",
				"context:js/select2/js/select2.full.min.js", "context:js/backstretch/jquery.backstretch.min.js",
				"context:js/app.min.js", "context:js/login.js" })
public class Login {

	@SessionState
	private LoginState loginState;

	@Inject
	private Logger logger;

	@Inject
	private AlertManager alertManager;

	@Inject
	private CoreDAO dao;

	@Inject
	private SecurityService securityService;

	@Inject
	private RequestGlobals requestGlobals;

	@Inject
	private Response response;

	@Inject
	private LoginContextService pageService;

	@Property
	private String password;

	@Property
	private String username;

	@Property
	@Persist(PersistenceConstants.FLASH)
	private String message, normal;

	void setupRender() {
		Account user = dao.getUser("pronto");
		if (user == null) {
			user = new Account();
			user.setUsername("pronto");
			user.setPassword("123");
			dao.saveOrUpdateObject(user);
		}
	}

	public Object onActionFromTynamoLoginForm() {
		try {
			Subject currentUser = securityService.getSubject();
			if (currentUser == null) {
				throw new IllegalStateException("Subject can`t be null");
			}
			UsernamePasswordToken token = new UsernamePasswordToken(this.username, this.password);
			currentUser.login(token);
			Account account = dao.getUser(username);
			loginState.setAccount(account);
			SavedRequest savedRequest = WebUtils.getAndClearSavedRequest(requestGlobals.getHTTPServletRequest());
			if (savedRequest != null && savedRequest.getMethod().equalsIgnoreCase("GET")) {
				System.err.println("requestUrl:" + savedRequest.getRequestUrl());
				response.sendRedirect(savedRequest.getRequestUrl());
				return null;
			} else {
				System.err.println("success");
				return pageService.getSuccessURL();
			}
		} catch (Exception e) {
			System.err.println("success!");
			alertManager.error("Wrong username or password!");
			return pageService.getLoginURL();
		}

	}
}
