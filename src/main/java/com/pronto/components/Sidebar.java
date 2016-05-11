package com.pronto.components;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;
import org.tynamo.security.services.SecurityService;

public class Sidebar {

	@Inject
	private JavaScriptSupport jsSupp;

	@Inject
	private SecurityService securityService;

	@Property
	private String imagePath;

	@Property
	@Inject
	@Symbol(SymbolConstants.CONTEXT_PATH)
	private String context;

	@Parameter
	private String moduleName;

	@Inject
	private Messages messages;

	public String getHeaderText() {
		if (moduleName == null)
			return "";
		if (moduleName.equals("admin"))
			return messages.get("modAdmin");
		else if (moduleName.equals("archive"))
			return messages.get("modArchive");
		else if (moduleName.equals("verify"))
			return messages.get("modVerify");
		else if (moduleName.equals("digital"))
			return messages.get("modDigit");
		return "";
	}
}
