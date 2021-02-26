package com.company.yedam.common;

import java.util.Date;
import java.text.SimpleDateFormat;

public class DateUtil {
	// 1.String -> Date
	public static java.sql.Date toDate(String date) {
		Date result = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			result = dateFormat.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return (java.sql.Date) result;
	}
	// 2.Date -> String
	public static String toStr(Date date) {
		String result = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		result = dateFormat.format(date);
		
		return result;
	}
	
	public static String toStr(Date date, String format) {
		String result = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		result = dateFormat.format(date);
		
		return result;
	}
	
	public static String toDay(Date date) {
		String result = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("오늘은 이 달의 F번째 E요일");
		result = dateFormat.format(date);
		
		return result;
	}
	
	public static String toYDay(Date date) {
		String result = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("오늘은 올 해의 w번째 주 D번째 날 이 달의 W번째 주 d번째 날 E요일");
		result = dateFormat.format(date);
		
		return result;
	}
	
}
