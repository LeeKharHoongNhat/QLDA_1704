package com.ffse1704.common;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	
	public static String formatDate(Date date) {
		return new SimpleDateFormat("dd-MM-yyyy").format(date);
	}
	
	public static String formatMoney(Long money) {
		 NumberFormat numberFormat = new DecimalFormat("#,### đ");
			return numberFormat.format(money);


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
