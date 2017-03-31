/*
 * Utils.java Jan 12, 2008
 * 
 * Copyright 2009 Uralian, LLC. All rights reserved.
 */
package com.cgi.crm.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * A collection of various utility methods.
 * 
 * @author Vlad Orzhekhovskiy
 */
public class Utils {

	private static Logger log = Logger.getLogger(Utils.class);

	private final static ThreadLocal<SimpleDateFormat> sdf = new ThreadLocal<SimpleDateFormat>() {
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("MM-dd-yyyy");
		}
	};

	public static Date convertStringToDate(String strDate) {
		Date date = null;
		try {
			if (strDate != null && strDate.trim().length() > 0) {
				date = sdf.get().parse(strDate);
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error at convertStringToDate() in Utils : " + e.getMessage(), e);
		}
		return date;
	}

	public static String convertDateToString(Date date) {
		String strDate = null;
		try {
			if (date != null) {
				strDate = sdf.get().format(date);
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error at convertDateToString() in Utils : " + e.getMessage(), e);
		}
		return strDate;
	}
	
	public static String getStringValueOfObj(Object obj) {
		String strValue = "";
		if (obj != null) {
			strValue = obj.toString();
		}
		return strValue;
	}

	public static Integer getIntegerValueOfObj(Object obj) {
		Integer intValue = 0;
		if (obj != null) {
			if (obj instanceof BigInteger) {
				intValue = ((BigInteger) obj).intValue();
			} else {
				intValue = (Integer) obj;
			}

		}
		return intValue;
	}

	public static Integer getIntegerValueOfBigDecimalObj(Object obj) {
		Integer intValue = 0;
		if (obj != null) {
			if (obj instanceof BigDecimal) {
				intValue = ((BigDecimal) obj).intValue();
			} else if (obj instanceof BigInteger) {
				intValue = ((BigInteger) obj).intValue();
			} else {
				intValue = (Integer) obj;
			}

		}
		return intValue;
	}
	
	public static Double getPercentageInDouble(Integer a,Integer b) {
		Double resultValue = 0d;
		if (a != null && b !=null) {
			resultValue = (Double.valueOf(a)/Double.valueOf(b))*100;

		}
		return resultValue;
	}

	public static Integer getIntegerValueOfDoubleObj(Object obj) {
		Integer intValue = 0;
		if (obj != null) {
			if (obj instanceof Double) {
				intValue = ((Double) obj).intValue();
			} else {
				intValue = (Integer) obj;
			}

		}
		return intValue;
	}

	public static Double getTwoDecimalDoubleFromObj(Object obj) {
		Double dblValue = 0d;
		if (obj != null) {
			if(obj instanceof String){
				if(((String)obj).trim().length()>0){
				obj = Double.parseDouble((String)obj);
				}
			}
			if (obj instanceof Double) {
				dblValue = ((Double) obj);
				dblValue = Math.round(dblValue * 100.0) / 100.0;
			}else if(obj instanceof Integer){
				dblValue= Double.valueOf((Integer)obj);
			}

		}
		return dblValue;
	}


}