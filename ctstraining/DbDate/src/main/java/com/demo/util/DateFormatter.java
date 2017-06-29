package com.demo.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateFormatter {

	
	public static java.sql.Date formatDate(String date) throws ParseException{
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date myDate = formatter.parse(date);
		java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
		
//		db.insert_date(sqlDate);
		return sqlDate;
	}
}
