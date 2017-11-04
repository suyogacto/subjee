package com.suyoga.subjee.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class SubjeeUtil {
	
	protected static ResourceBundle resource;
	
	static Locale locale = Locale.ENGLISH;
	static {
		resource = ResourceBundle.getBundle(
				"com.suyoga.subjee.util.SubjeeResource", locale);
		}
	
	
	public static String subjeeErrMsg(String key) {

		String msg = resource.getString(key);
		return msg;
	}

}
