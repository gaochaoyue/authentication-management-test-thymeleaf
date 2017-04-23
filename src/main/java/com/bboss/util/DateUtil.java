package com.bboss.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {

	public static String formatDate(Date date, String format) {
		String result = "";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		if (date != null) {
			result = sdf.format(date);
		}
		return result;
	}

	public static Date formatString(String str, String format) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.parse(str);
	}

	/**
	 * 获取连续[interval+1]个月的年月
	 * 
	 * @param interval
	 *            间隔
	 * @return 月份字符串数组 eg:201601,201602,201603
	 */
	public static String[] getMonth(int interval) {
		String[] months = new String[interval + 1];
		for (int i = interval; i >= 0; i--) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.add(calendar.MONTH, -i);

			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH) + 1;

			StringBuffer bf = new StringBuffer();
			bf.append(year);
			if (month < 10) {
				bf.append("0");
			}
			bf.append(month);

			months[i] = bf.toString();
		}
		return months;
	}

	/**
	 * 日期格式转换
	 * 
	 * @param srcDate
	 *            要转换的日期 字符串格式
	 * @param srcFormat
	 *            日期原始格式
	 * @param newFormat
	 *            要转换的日期格式
	 * @return
	 */
	public static String dateForamt(String srcDate, String srcFormat, String newFormat) {
		Date date = null;
		String newDate = null;
		try {
			date = new SimpleDateFormat(srcFormat).parse(srcDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (date != null) {
			newDate = new SimpleDateFormat(newFormat).format(date);
		}
		return newDate;
	}

	/**
	 * 获取当前时间的前一天
	 * 
	 * @param dateFormat
	 * @return 返回前一天日期字符串
	 */
	public static String getPreDay(String dateFormat) {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		date = calendar.getTime();
		SimpleDateFormat sf = new SimpleDateFormat(dateFormat);
		String dateStr = sf.format(date).toString();
		return dateStr;
	}

	/**
	 * 获取指定日期的1号日期字符串
	 * 
	 * @param date
	 * @param dateFormat
	 * @return
	 */

	public static String getMonthFirstDay(String dateStr, String dateFormat) {
		Date date = null;
		try {
			date = new SimpleDateFormat(dateFormat).parse(dateStr);

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			calendar.set(Calendar.HOUR, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);

			Date newDate = calendar.getTime();
			SimpleDateFormat sf = new SimpleDateFormat(dateFormat);
			return sf.format(newDate).toString();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 获取指定月份的1号日期字符串
	 * 
	 * @param date
	 * @param dateFormat
	 * @return
	 */

	public static String getMonthFirstDayByMonth(String dateStr) {
		Date date = null;
		dateStr = dateStr + "-01";
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			calendar.set(Calendar.HOUR, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);

			Date newDate = calendar.getTime();
			SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
			return sf.format(newDate).toString();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 验证链接是否在5分钟内
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean judgmentDate(Date date1, String date2) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			Date end = format.parse(date2);
			long cha = date1.getTime() - end.getTime();
			long chaAbs = Math.abs(cha);
			/*
			 * if(cha<0){ return false; }
			 */
			double result = chaAbs * 1.0 / (1000 * 60);
			if (result <= 5) {
				return true;
			} else {
				return false;
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 获取指定月的最后一天
	 * 
	 * @param dateStr
	 *            日期字符串
	 * @param df
	 *            日期字符串日期格式
	 * @return
	 */
	public static String getMonthLastDay(String dateStr, String df) {
		SimpleDateFormat format = new SimpleDateFormat(df);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = format.parse(dateStr);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
			return sdf.format(calendar.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 日期属性x：年
	// 日期属性y：月
	// 日期属性z：日
	// 获取月末时间
	public static String thisMonthEnd() {

		String strMonth = null;
		String day = null;
		boolean leap = false;
		Calendar localTime = Calendar.getInstance();
		int year = localTime.get(Calendar.YEAR);
		int month = localTime.get(Calendar.MONTH) + 1;
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			day = "31";
		}
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			day = "30";
		}
		if (month == 2) {
			leap = leapYear(year);
			if (leap) {
				day = "29";
			} else {
				day = "28";
			}
		}
		strMonth = month >= 10 ? String.valueOf(month) : ("0" + month);
		return year + strMonth + day;
	}

	// 获取指定时间的月末
	public static String thisMonthEndByMonth(String monthstr) throws ParseException {

		String strMonth = null;
		String day = null;
		boolean leap = false;
		Calendar localTime = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
		// 指定一个日期
		Date date = dateFormat.parse(monthstr);
		localTime.setTime(date);
		int year = localTime.get(Calendar.YEAR);
		int month = localTime.get(Calendar.MONTH) + 1;
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			day = "31";
		}
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			day = "30";
		}
		if (month == 2) {
			leap = leapYear(year);
			if (leap) {
				day = "29";
			} else {
				day = "28";
			}
		}
		strMonth = month >= 10 ? String.valueOf(month) : ("0" + month);
		return year + strMonth + day;
	}

	// 得到当前月份月初
	public static String thisMonth() {
		Calendar localTime = Calendar.getInstance();
		String strMonth = null;
		int year = localTime.get(Calendar.YEAR);
		int month = localTime.get(Calendar.MONTH) + 1;
		strMonth = month >= 10 ? String.valueOf(month) : ("0" + month);
		return year + strMonth + "01";
	}

	// 得到当前月份月初
	public static String preMonth() {
		Calendar localTime = Calendar.getInstance();
		String strMonth = null;
		int year = localTime.get(Calendar.YEAR);
		int month = localTime.get(Calendar.MONTH);
		strMonth = month >= 10 ? String.valueOf(month) : ("0" + month);
		return year + strMonth + "01";
	}

	// 功能：判断输入年份是否为闰年
	public static boolean leapYear(int year) {
		boolean leap;
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0)
					leap = true;
				else
					leap = false;
			} else
				leap = true;
		} else
			leap = false;
		return leap;
	}

	// 获取当前时间
	public static String[] getDate(int interval) {
		String[] date = new String[interval + 1];
		for (int i = interval; i >= 0; i--) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.add(calendar.MONTH, -i);

			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH) + 1;
			int day = calendar.get(Calendar.DAY_OF_MONTH);
			StringBuffer bf = new StringBuffer();
			bf.append(year);
			if (month < 10) {
				bf.append("0");
			}
			bf.append(month);
			if (day < 10) {
				bf.append("0");
			}
			bf.append(day);

			date[i] = bf.toString();
		}
		return date;
	}

	// 获取当前时间的前一天
	public static String getNextDay() {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		date = calendar.getTime();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		String dateStr = sf.format(date).toString();
		return dateStr;
	}

	// 获取时间区间内所有的时间(yyyyMMdd)
	public static List<String> findDates(String startTime, String endTime) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

		Date dBegin = null;
		Date dEnd = null;
		try {
			dBegin = format.parse(startTime);
			dEnd = format.parse(endTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List date = new ArrayList();
		// lDate.add(dBegin);
		Calendar calBegin = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		calBegin.setTime(dBegin);
		Calendar calEnd = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		calEnd.setTime(dEnd);
		// 测试此日期是否在指定日期之后
		while (dEnd.after(calBegin.getTime())) {
			date.add(format.format(calBegin.getTime()));
			calBegin.add(Calendar.DAY_OF_MONTH, 1);

		}
		date.add(endTime);
		return date;
	}
	
	
	/*public static void main(String[] args) {
		System.out.println(DateUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
	}*/

}
