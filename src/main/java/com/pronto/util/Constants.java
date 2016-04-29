package com.pronto.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Constants {

	/**
	 * Authentication Constants
	 * 
	 **/
	public static final String BUNDLE_KEY = "ApplicationResources";

	public static final String FILE_SEP = System.getProperty("file.separator");

	public static final String USER_HOME = System.getProperty("user.home")
			+ FILE_SEP;

	public static final String CONFIG = "appConfig";

	public static final String PREFERRED_LOCALE_KEY = "org.apache.struts2.action.LOCALE";

	public static final String USER_KEY = "userForm";

	public static final String USER_LIST = "userList";

	public static final String REGISTERED = "registered";

	public static final String ADMIN_ROLE = "ROLE_ADMIN";

	public static final String USER_ROLE = "ROLE_USER";

	public static final String USER_ROLES = "userRoles";

	public static final String AVAILABLE_ROLES = "availableRoles";

	public static final String CSS_THEME = "csstheme";

	public static final String ENC_ALGORITHM = "SHA";

	public static final String NUMBER_FORMAT = "#,##0";

	public static final String PERCENT_FORMAT = "0.00%";

	public static final String CURRENCY_FORMAT = "[$$-409]#,##0;[RED]-[$$-409]#,##0";

	public static final String FILE_PATH_DOCUMENT = "/documents/";

	public static final int PASSWORD_RANDOM_LENGTH_MIN = 7;

	public static final int PASSWORD_RANDOM_LENGTH_MAX = 9;

	/**
	 * Date Format Constants
	 * 
	 **/

	public static final String DATE_FORMAT = "yyyy-MM-dd";

	public static final String DATE_FORMAT_CODE = "yyyyMMdd";

	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd H:mm:ss";

	public static final String DATE_TIME_MIN_FORMAT = "yyyy/MM/dd H:mm";

	public static final String ORACLE_DATE_FORMAT = "yyyy-MM-dd";

	public static final String YEAR_FORMAT = "yyyy";

	public static final String MONTH_FORMAT = "MM";

	public static final String DAY_FORMAT = "dd";

	public static DateFormat formatter() {
		return new SimpleDateFormat(ORACLE_DATE_FORMAT);
	}

	public static Calendar now = Calendar.getInstance();

	public static int CURRENT_YEAR = now.get(Calendar.YEAR);

	public static int CURRENT_MONTH = now.get(Calendar.MONTH) + 1;

	public static int CURRENT_DAY = now.get(Calendar.DAY_OF_MONTH);

	public static int CURRENT_HOUR = now.get(Calendar.HOUR_OF_DAY);

	public static int CURRENT_MINUTE = now.get(Calendar.MINUTE);

	public static int CURRENT_SECOND = now.get(Calendar.SECOND);

	public static int CURRENT_MILLIS = now.get(Calendar.MILLISECOND);

	/**
	 * FilType Constants
	 * 
	 **/
	public static String[] FILE_TYPE = { "jpg", "png", "tif" };
	
	/**
	 * Event names
	 */
	public static final String VIEW_EMAIL = "viewEmail";
	public static final String CLICK_EMAIL = "clickEmail";
}
