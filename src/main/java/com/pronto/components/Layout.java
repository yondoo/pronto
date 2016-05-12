package com.pronto.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.apache.tapestry5.services.Request;

import com.pronto.pages.Login;

@Import(

		stylesheet = { "context:css/font-family.css", /* "context:css/font-family-opensans.css", */
				"context:css/font-awesome.min.css", "context:css/simple-line-icons.min.css",
				"context:css/uniform.default.css", "context:css/bootstrap-switch.min.css",
				"context:css/daterangepicker.min.css", "context:css/morris.css", "context:css/fullcalendar.min.css",
				"context:css/jqvmap.css", "context:css/components-md.min.css", "context:css/plugins-md.min.css",
				"context:css/layout.css", "context:css/custom.min.css" }, library = { "context:js/jquery.min.js",
						"context:js/bootstrap/js/bootstrap.min.js", "context:js/js.cookie.min.js",
						"context:js/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js",
						"context:js/jquery-slimscroll/jquery.slimscroll.min.js", "context:js/jquery.blockui.min.js",
						"context:js/uniform/jquery.uniform.min.js",
						"context:js/bootstrap-switch/js/bootstrap-switch.min.js", "context:js/moment.min.js",
						"context:js/bootstrap-daterangepicker/daterangepicker.min.js",
						"context:js/morris/morris.min.js", "context:js/morris/raphael-min.js",
						"context:js/counterup/jquery.waypoints.min.js", "context:js/counterup/jquery.counterup.min.js",
						"context:js/amcharts/amcharts/amcharts.js", "context:js/amcharts/amcharts/serial.js",
						"context:js/amcharts/amcharts/pie.js", "context:js/amcharts/amcharts/radar.js",
						"context:js/amcharts/amcharts/themes/light.js",
						"context:js/amcharts/amcharts/themes/patterns.js",
						"context:js/amcharts/amcharts/themes/chalk.js", "context:js/amcharts/ammap/ammap.js",
						"context:js/amcharts/ammap/maps/js/worldLow.js", "context:js/amcharts/amstockcharts/amstock.js",
						"context:js/fullcalendar/fullcalendar.min.js", "context:js/flot/jquery.flot.min.js",
						"context:js/flot/jquery.flot.resize.min.js", "context:js/flot/jquery.flot.categories.min.js",
						"context:js/jquery-easypiechart/jquery.easypiechart.min.js",
						"context:js/jquery.sparkline.min.js", "context:js/app.min.js", "context:js/dashboard.min.js",
						"context:js/layout.min.js",
						"context:js/quick-sidebar.min.js" }, module = { "bootstrap/collapse" })

public class Layout {
	@Inject
	private ComponentResources resources;
	
	@Inject
	private Request request;

	/**
	 * The page title, for the <title> element and the
	 * <h1>element.
	 */
	@Property
	@Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
	private String title;

	@Property
	private String pageName;

	@Property
	@Inject
	@Symbol(SymbolConstants.APPLICATION_VERSION)
	private String appVersion;

	public String getClassForPageName() {
		return resources.getPageName().equalsIgnoreCase(pageName) ? "active" : null;
	}

	public String[] getPageNames() {
		return new String[] { "AccountEdit", "Contact" };
	}

	Object onSignout() {
		request.getSession(false).invalidate();
		return Login.class;
	}
}
