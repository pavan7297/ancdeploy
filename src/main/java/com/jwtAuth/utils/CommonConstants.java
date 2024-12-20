package com.jwtAuth.utils;

import java.util.regex.Pattern;

public interface CommonConstants {
	public static final String DATABASE_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
	public static final String DATA_NOT_AVIALABLE = "NA";
	public static final Integer DATA_NOT_AVIALABLE_INT = 0;
	public static final String DEFAULT_TEANTID = "TEANTID";
	public static final String DB_STRING_NULL_FORMAT = "¥";
	public static final Integer LOGIN_INTO_MODULE = 1;
	public static final String[] CLASSPATH_RESOURCE_LOCATIONS = { "classpath:/META-INF/resources/",
			"classpath:/resources/", "classpath:/static/", "classpath:/public/" };

	public static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

	public static final String phonenumber = "^((\\(\\d{3}\\))|\\d{3})[- ]?\\d{3}[- ]?\\d{4}$";

	public static final String NOTALLOWSPECIAL = "^((?=[A-Za-z0-9,./-@ ])(?![_\\\\-]).)*$";

	public static final String adhar = "^[2-9]{1}[0-9]{3}[0-9]{4}[0-9]{4}$";

	// public static final String NOTALLOWSPECIAL =
	// "^(?=[a-zA-Z0-9~@#$^*()_+=[\]{}|\\,.?: -]*$)(?!.*[<>'"/;`%])";

	public static final String EMAILID = "^(.+)@(.+)$";

	public static final String ALLOWONLYNUMBERS = "[0-9]+";

	public static final Pattern EMAIL = Pattern.compile(EMAILID);

	public static final Pattern AADHAR = Pattern.compile(adhar);

	public static final Pattern NUMBERS = Pattern.compile(ALLOWONLYNUMBERS);

	public static final Pattern SPECIALPATTERN = Pattern.compile(NOTALLOWSPECIAL);

	public static final Pattern PHONENUMBERMATCH = Pattern.compile(phonenumber);

	public static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

}
