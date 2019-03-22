package com.ffse1704.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	public static String formatDate(Date date) {
		return new SimpleDateFormat("dd-MM-yyyy").format(date);
	}
	public static String formatDateTime(Date date) {
		return new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date);
	}

	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
