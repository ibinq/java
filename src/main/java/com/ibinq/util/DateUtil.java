package com.ibinq.util;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * 创建者:
 * 日期:2013年5月1日<br/>
 * 描述:日期类操作工具类<br/>
 */
public class DateUtil {
	/**
	 * 将日期字符类型的转化为long类型的日期
	 * 
	 * @param str
	 * @param format
	 * @return
	 */
	public static String getNowDate(String strFormat){
		SimpleDateFormat dateFormat = new SimpleDateFormat(strFormat);
		return dateFormat.format(new Date());
	}
	public static Timestamp getSqlDate(String format) {
		Timestamp ts = new Timestamp(System.currentTimeMillis());  
	    String tsStr = getNowDate(format);
	    try {  
	        ts = Timestamp.valueOf(tsStr);  
	        
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    }
	    return ts;
	}
	public static long stringToLong(String str, String format) {
		String stringDate = str == null ? "" : str;
		if(stringDate.equals(""))
			return 0l;
		if(stringDate.length()==4)
			stringDate=stringDate+"-01-01";
		if (format == null || format.equals("")) {
			format = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date d = null;
		long lt = 0;
		try {
			
			d = sdf.parse(stringDate);
			lt = d.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return lt;
	}
	/**
	 * 将日期字符类型的转化为date类型的日期
	 * 
	 * @param str
	 * @param format
	 * @return
	 */
	public static Date stringToDate_(String str, String format) {
		String stringDate = str == null ? "" : str;
		if (format == null || format.equals("")) {
			format = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date d = null;
		try {
			d = sdf.parse(stringDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}

	/**
	 * 将long类型的日期转化为指定的日期格式字符串
	 * 
	 * @param str
	 * @param formate
	 * @return
	 */
	public static String longToDateString(Long str, String formate) {
		if (formate == null || formate.equals("")) {
			formate = "yyyy-MM-dd HH:mm:ss";
		}
		String tstr = "";
		if (str != null && str != 0) {
			SimpleDateFormat myFormat = new SimpleDateFormat(formate);
			tstr = myFormat.format(new Timestamp(str));
		}
		return tstr;
	}

	/**
	 * 得到格式化的日期
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getFormatDate(Date date, String format) {
		String dateStr = "";
		SimpleDateFormat dayFm = new SimpleDateFormat(format);
		dateStr = dayFm.format(date);
		return dateStr;
	}

	/**
	 * 格式化当前时间
	 * 
	 * @param ymd
	 * @return
	 */
	public static String formatDateTime(String ymd) {
		SimpleDateFormat isNow = new SimpleDateFormat(ymd);
		String now = isNow.format(new Date());
		return now;
	}

	/**
	 * 格式化当前时间
	 * 
	 * @param ymd
	 * @param datetime
	 * @return
	 */
	public static String formatDateTime(String ymd, String datetime) {
		SimpleDateFormat isNow = new SimpleDateFormat(ymd);
		String now = "";
		try {
			now = isNow.format(longToDateString(System.currentTimeMillis(), "yyyy-MM-dd"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 比较当前月份和指定月份 如果当前月份在指定月份之后返回true否则返回flase
	 * 
	 * @param str
	 * @return
	 */
	public static boolean monthCompare(String str) {
		boolean bea = false;
		SimpleDateFormat sdf_m = new SimpleDateFormat("yyyy-MM");
		String isMonth = sdf_m.format(new Date());
		Date date1;
		Date date0;
		try {
			date1 = sdf_m.parse(str);
			date0 = sdf_m.parse(isMonth);
			if (date0.after(date1) || date0.equals(date1)) {
				bea = true;
			}
		} catch (ParseException e) {
			bea = false;
		}
		return bea;
	}

	/**
	 * 比较月份month1和月份month2 如果月份month1在月份month2之后返回true否则返回flase
	 * 
	 * @param str
	 * @return
	 */
	public static boolean monthCompare(String month1, String month2) {
		boolean bea = false;
		SimpleDateFormat sdf_m = new SimpleDateFormat("yyyy-MM");
		Date date1;
		Date date0;
		try {
			date1 = sdf_m.parse(month1);
			date0 = sdf_m.parse(month2);
			if (date0.after(date1) || date0.equals(date1)) {
				bea = true;
			}
		} catch (ParseException e) {
			bea = false;
		}
		return bea;
	}

	/**
	 * 比较当前年份和指定年份 如果当前年份在指定年份之后返回true否则返回flase
	 * 
	 * @param str
	 * @return
	 */
	public static boolean yearCompare(String str) {
		boolean bea = false;
		SimpleDateFormat sdf_m = new SimpleDateFormat("yyyy");
		String isMonth = sdf_m.format(new Date());
		Date date1;
		Date date0;
		try {
			date1 = sdf_m.parse(str);
			date0 = sdf_m.parse(isMonth);
			if (date0.after(date1) || date0.equals(date1)) {
				bea = true;
			}
		} catch (ParseException e) {
			bea = false;
		}
		return bea;
	}

	/**
	 * 比较年份yeaar1和年份year2 如果当前年份year1在年份year2之后返回true否则返回flase
	 * 
	 * @param str
	 * @return
	 */
	public static boolean yearCompare(String year1, String year2) {
		boolean bea = false;
		SimpleDateFormat sdf_m = new SimpleDateFormat("yyyy");
		Date date1;
		Date date0;
		try {
			date1 = sdf_m.parse(year1);
			date0 = sdf_m.parse(year2);
			// if(date0.equals(date1)){
			// System.out.println("11111111111111111");
			// }else {
			// System.out.println("22222222222222222");
			// }
			if (date0.after(date1) || date0.equals(date1)) {
				bea = true;
			}
		} catch (ParseException e) {
			bea = false;
		}
		return bea;
	}

	/**
	 * 比较当前日期和指定日期 return boolean 如果当前日期在指定日期之后返回true否则返回flase
	 * 
	 * @param str
	 * @return
	 */
	public static boolean dayCompare(String str) {
		boolean bea = false;
		SimpleDateFormat sdf_d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String isDate = sdf_d.format(new Date());
		Date date1;
		Date date0;
		try {
			date1 = sdf_d.parse(str);
			date0 = sdf_d.parse(isDate);
			if (date0.after(date1) || date0.equals(date1)) {
				bea = true;
			}
		} catch (ParseException e) {
			bea = false;
		}
		return bea;
	}

	/**
	 * 比较指定两日期如果str1晚于str2则return true;
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean dayCompare(String str1, String str2, String formate) {
		boolean bea = false;
		SimpleDateFormat sdf_d = new SimpleDateFormat(formate);
		Date date0 = null;
		Date date1 = null;
		try {
			date0 = sdf_d.parse(str1);
			date1 = sdf_d.parse(str2);
			if (date0.before(date1) || date0.equals(date1)) {//
				bea = true;
			}
		} catch (ParseException e) {
			bea = false;
		}
		return bea;
	}

	/**
	 * 设置间隔数后返回时间
	 * 
	 * @param type
	 *            间隔类型 秒或者天
	 * @param 间隔数字
	 *            比如1秒或者一天
	 * @return
	 */
	public static String dateAdd(String type, int i) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = formatDateTime("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance(); // 当时的日期和时间
		
		if (type.equals("s")) {
			int s = c.get(Calendar.SECOND);
			s = s + i;
			c.set(Calendar.SECOND, s);
			str = df.format(c.getTime());
		} else if (type.equals("d")) {
			int d = c.get(Calendar.DAY_OF_MONTH); // 取出“日”数
			d = d + i;
			c.set(Calendar.DAY_OF_MONTH, d); // 将“日”数设置回去
			str = df.format(c.getTime());
		}
		return str;
	}

	// 用来全局控制 上一周，本周，下一周的周数变化
	private static int weeks = 0;
	private static int MaxDate;// 一月最大天数
	private static int MaxYear;// 一年最大天数

//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		DateUtil tt = new DateUtil();
//		// System.out.println("获取当天日期:" + tt.getNowTime("yyyy-MM-dd"));
//		// System.out.println("获取本周一日期:" + tt.getMondayOFWeek());
//		// System.out.println("获取本周日的日期~:" + tt.getCurrentWeekday());
//		// System.out.println("获取上周一日期:" + tt.getPreviousWeekday());
//		// System.out.println("获取上周日日期:" + tt.getPreviousWeekSunday());
//		// System.out.println("获取下周一日期:" + tt.getNextMonday());
//		// System.out.println("获取下周日日期:" + tt.getNextSunday());
//		// System.out.println("获得相应周的周六的日期:" + tt.getSaturday());
//		// System.out.println("获取本月第一天日期:" + tt.getFirstDayOfMonth());
//		System.out.println("获取本月最后一天日期:" + tt.getDefaultDay());
//		// System.out.println("获取上月第一天日期:" + tt.getPreviousMonthFirst());
//		// System.out.println("获取上月最后一天的日期:" + tt.getPreviousMonthEnd());
//		// System.out.println("获取下月第一天日期:" + tt.getNextMonthFirst());
//		// System.out.println("获取下月最后一天日期:" + tt.getNextMonthEnd());
//		// System.out.println("获取本年的第一天日期:" + tt.getCurrentYearFirst());
//		// System.out.println("获取本年最后一天日期:" + tt.getCurrentYearEnd());
//		// System.out.println("获取去年的第一天日期:" + tt.getPreviousYearFirst());
//		// System.out.println("获取去年的最后一天日期:" + tt.getPreviousYearEnd());
//		// System.out.println("获取明年第一天日期:" + tt.getNextYearFirst());
//		// System.out.println("获取明年最后一天日期:" + tt.getNextYearEnd());
//		// System.out.println("获取本季度第一天到最后一天:" + tt.getThisSeasonTime(11));
//		// System.out.println("获取两个日期之间间隔天数2008-12-1~2008-9.29:" +
//		// DateUtil.getTwoDay("2008-12-1", "2008-9-29"));
//		//
//		// System.out.println("获取本周的第一天:" + tt.getFirstDayOfWeek());
//		// System.out.println("获取本周的最后一天:" + tt.getLastDayOfWeek());
//		// System.out.println(stringToLong(getFormatDate(new
//		// Date(),"yyyy-MM-dd"), "yyyy-MM-dd"));
//		// System.out.println("sss==="
//		// + String.valueOf(System.currentTimeMillis()));
//		// String str = formatDateTime("yyyy-MM-dd
//		// hh:mm:ss",String.valueOf(System.currentTimeMillis()));
//		// System.out.println("str---===" + str);
//		//
//
//		// Long s = stringToLong(String.valueOf(System.currentTimeMillis()),
//		// "yyyy-MM-dd hh:mm:ss");
//		// System.out.println("s-=====" + s);
//
//	}

	/**
	 * 获取本周的第一天
	 * 
	 * @return
	 */
	public static String getFirstDayOfWeek() {
		Calendar now = Calendar.getInstance();
		int noOfweek = now.get(Calendar.DAY_OF_WEEK);
		now.set(Calendar.DATE, now.get(Calendar.DATE) - noOfweek + 1);
		String date = DateUtil.getFormatDate(now.getTime(), "yyyy-MM-dd");
		return date;
	}

	/**
	 * 获取本周的最后一天
	 * 
	 * @return
	 */
	public static String getLastDayOfWeek() {
		Calendar now = Calendar.getInstance();
		int noOfweek = now.get(Calendar.DAY_OF_WEEK);
		now.set(Calendar.DATE, now.get(Calendar.DATE) + (7 - noOfweek));
		String date = DateUtil.getFormatDate(now.getTime(), "yyyy-MM-dd");
		return date;
	}

	/**
	 * 得到二个日期间的间隔天数
	 */
	public static String getTwoDay(String sj1, String sj2) {
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		long day = 0;
		try {
			Date date = myFormatter.parse(sj1);
			Date mydate = myFormatter.parse(sj2);
			day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		} catch (Exception e) {
			return "";
		}
		return day + "";
	}

	/**
	 * 根据一个日期，返回是星期几的字符串
	 * 
	 * @param sdate
	 * @return
	 */
	public static String getWeek(String sdate) {
		// 再转换为时间
		Date date = DateUtil.strToDate(sdate);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		// int hour=c.get(Calendar.DAY_OF_WEEK);
		// hour中存的就是星期几了，其范围 1~7
		// 1=星期日 7=星期六，其他类推
		return new SimpleDateFormat("EEEE").format(c.getTime());
	}

	/**
	 * 将短时间格式字符串转换为时间 yyyy-MM-dd
	 * 
	 * @param strDate
	 * @return
	 */
	public static Date strToDate(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	/**
	 * 两个时间之间的天数
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getDays(String date1, String date2) {
		if (date1 == null || date1.equals(""))
			return 0;
		if (date2 == null || date2.equals(""))
			return 0;
		// 转换为标准时间
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		Date mydate = null;
		try {
			date = myFormatter.parse(date1);
			mydate = myFormatter.parse(date2);
		} catch (Exception e) {
		}
		long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		return day;
	}
	public static int getDaysByLong(long date1, long date2) {
		int day = Integer.parseInt(((date2-date1) / (24 * 60 * 60 * 1000))+"");
		return day;
	}

	// 计算当月最后一天,返回字符串
	public static String getDefaultDay() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		lastDate.add(Calendar.MONTH, 1);// 加一个月，变为下月的1号
		lastDate.add(Calendar.DATE, -1);// 减去一天，变为当月最后一天

		str = sdf.format(lastDate.getTime());
		return str;
	}

	// 上月第一天
	public static String getPreviousMonthFirst() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		lastDate.add(Calendar.MONTH, -1);// 减一个月，变为下月的1号
		// lastDate.add(Calendar.DATE,-1);//减去一天，变为当月最后一天

		str = sdf.format(lastDate.getTime());
		return str;
	}

	// 获取当月第一天
	public static String getFirstDayOfMonth() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		str = sdf.format(lastDate.getTime());
		return str;
	}

	// 获得本周星期日的日期
	public static String getCurrentWeekday() {
		weeks = 0;
		int mondayPlus = getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(Calendar.DATE, mondayPlus + 6);
		Date monday = currentDate.getTime();

		DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);
		return preMonday;
	}

	// 获取当天时间
	public static String getNowTime(String dateformat) {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(dateformat);// 可以方便地修改日期格式
		String hehe = dateFormat.format(now);
		return hehe;
	}

	// 获得当前日期与本周日相差的天数
	private static int getMondayPlus() {
		Calendar cd = Calendar.getInstance();
		// 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
		int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1
		if (dayOfWeek == 1) {
			return 0;
		} else {
			return 1 - dayOfWeek;
		}
	}

	// 获得本周一的日期
	public static String getMondayOFWeek() {
		weeks = 0;
		int mondayPlus = getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(Calendar.DATE, mondayPlus);
		Date monday = currentDate.getTime();

		DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);
		return preMonday;
	}

	// 获得相应周的周六的日期
	public static String getSaturday() {
		int mondayPlus = getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(Calendar.DATE, mondayPlus + 7 * weeks + 6);
		Date monday = currentDate.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);
		return preMonday;
	}

	// 获得上周星期日的日期
	public static String getPreviousWeekSunday() {
		weeks = 0;
		weeks--;
		int mondayPlus = getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(Calendar.DATE, mondayPlus + weeks);
		Date monday = currentDate.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);
		return preMonday;
	}

	// 获得上周星期一的日期
	public static String getPreviousWeekday() {
		weeks--;
		int mondayPlus = getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(Calendar.DATE, mondayPlus + 7 * weeks);
		Date monday = currentDate.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);
		return preMonday;
	}

	// 获得下周星期一的日期
	public static String getNextMonday() {
		weeks++;
		int mondayPlus = getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(Calendar.DATE, mondayPlus + 7);
		Date monday = currentDate.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);
		return preMonday;

	}

	// 获得下周星期日的日期
	public static String getNextSunday() {

		int mondayPlus = getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(Calendar.DATE, mondayPlus + 7 + 6);
		Date monday = currentDate.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);
		return preMonday;
	}

	private static int getMonthPlus() {
		Calendar cd = Calendar.getInstance();
		int monthOfNumber = cd.get(Calendar.DAY_OF_MONTH);
		cd.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		cd.roll(Calendar.DATE, -1);// 日期回滚一天，也就是最后一天
		MaxDate = cd.get(Calendar.DATE);
		if (monthOfNumber == 1) {
			return -MaxDate;
		} else {
			return 1 - monthOfNumber;
		}
	}

	// 获得上月最后一天的日期
	public static String getPreviousMonthEnd() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.MONTH, -1);// 减一个月
		lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		lastDate.roll(Calendar.DATE, -1);// 日期回滚一天，也就是本月最后一天
		str = sdf.format(lastDate.getTime());
		return str;
	}

	// 获得下个月第一天的日期
	public static String getNextMonthFirst() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.MONTH, 1);// 减一个月
		lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		str = sdf.format(lastDate.getTime());
		return str;
	}

	// 获得下个月最后一天的日期
	public static String getNextMonthEnd() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.MONTH, 1);// 加一个月
		lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		lastDate.roll(Calendar.DATE, -1);// 日期回滚一天，也就是本月最后一天
		str = sdf.format(lastDate.getTime());
		return str;
	}

	// 获得明年最后一天的日期
	public static String getNextYearEnd() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.YEAR, 1);// 加一个年
		lastDate.set(Calendar.DAY_OF_YEAR, 1);
		lastDate.roll(Calendar.DAY_OF_YEAR, -1);
		str = sdf.format(lastDate.getTime());
		return str;
	}

	// 获得明年第一天的日期
	public static String getNextYearFirst() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.YEAR, 1);// 加一个年
		lastDate.set(Calendar.DAY_OF_YEAR, 1);
		str = sdf.format(lastDate.getTime());
		return str;

	}

	// 获得本年有多少天
	public static int getMaxYear() {
		Calendar cd = Calendar.getInstance();
		cd.set(Calendar.DAY_OF_YEAR, 1);// 把日期设为当年第一天
		cd.roll(Calendar.DAY_OF_YEAR, -1);// 把日期回滚一天。
		int MaxYear = cd.get(Calendar.DAY_OF_YEAR);
		return MaxYear;
	}

	private static int getYearPlus() {
		Calendar cd = Calendar.getInstance();
		int yearOfNumber = cd.get(Calendar.DAY_OF_YEAR);// 获得当天是一年中的第几天
		cd.set(Calendar.DAY_OF_YEAR, 1);// 把日期设为当年第一天
		cd.roll(Calendar.DAY_OF_YEAR, -1);// 把日期回滚一天。
		int MaxYear = cd.get(Calendar.DAY_OF_YEAR);
		if (yearOfNumber == 1) {
			return -MaxYear;
		} else {
			return 1 - yearOfNumber;
		}
	}

	// 获得本年第一天的日期
	public static String getCurrentYearFirst() {
		int yearPlus = getYearPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(Calendar.DATE, yearPlus);
		Date yearDay = currentDate.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String preYearDay = df.format(yearDay);
		return preYearDay;
	}

	// 获得本年最后一天的日期 *
	public static String getCurrentYearEnd() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");// 可以方便地修改日期格式
		String years = dateFormat.format(date);
		return years + "-12-31";
	}

	// 获得上年第一天的日期 *
	public static String getPreviousYearFirst() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");// 可以方便地修改日期格式
		String years = dateFormat.format(date);
		int years_value = Integer.parseInt(years);
		years_value--;
		return years_value + "-1-1";
	}

	// 获得上年最后一天的日期
	public static String getPreviousYearEnd() {
		weeks--;
		int yearPlus = getYearPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(Calendar.DATE, yearPlus + MaxYear * weeks + (MaxYear - 1));
		Date yearDay = currentDate.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String preYearDay = df.format(yearDay);
		getThisSeasonTime(11);
		return preYearDay;
	}

	// 获得本季度
	public static String getThisSeasonTime(int month) {
		int array[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
		int season = 1;
		if (month >= 1 && month <= 3) {
			season = 1;
		}
		if (month >= 4 && month <= 6) {
			season = 2;
		}
		if (month >= 7 && month <= 9) {
			season = 3;
		}
		if (month >= 10 && month <= 12) {
			season = 4;
		}
		int start_month = array[season - 1][0];
		int end_month = array[season - 1][2];

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");// 可以方便地修改日期格式
		String years = dateFormat.format(date);
		int years_value = Integer.parseInt(years);

		int start_days = 1;// years+"-"+String.valueOf(start_month)+"-1";//getLastDayOfMonth(years_value,start_month);
		int end_days = getLastDayOfMonth(years_value, end_month);
		String seasonDate = years_value + "-" + start_month + "-" + start_days + ";" + years_value + "-" + end_month + "-" + end_days;
		return seasonDate;

	}

	/**
	 * 获取某年某月的最后一天
	 * 
	 * @param year
	 *            年
	 * @param month
	 *            月
	 * @return 最后一天
	 */
	private static int getLastDayOfMonth(int year, int month) {
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			return 31;
		}
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			return 30;
		}
		if (month == 2) {
			if (isLeapYear(year)) {
				return 29;
			} else {
				return 28;
			}
		}
		return 0;
	}

	/**
	 * add by xu 根据时间变量返回时间字符串
	 * 
	 * @return 返回时间字符串
	 * @param pattern
	 *            时间字符串样式
	 * @param date
	 *            时间变量
	 */
	public static String dateToString(Date date, String pattern) {
		if (date == null) {
			return null;
		}
		try {
			SimpleDateFormat sfDate = new SimpleDateFormat(pattern);
			sfDate.setLenient(false);
			return sfDate.format(date);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 将long类型的日期转化为指定的日期格式字符串 格式 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param str
	 * @return
	 */
	public static String longToDateString(Long str) {
		String tstr = "";
		if (str != null && str != 0) {
			SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			tstr = myFormat.format(new Timestamp(str));
		}
		return tstr;
	}
	/**
	 * 将long类型的日期转化为指定的日期格式字符串 格式 yyyy-MM-dd
	 * 
	 * @param str
	 * @return
	 */
	public static String longToDateString_(Long str) {
		String tstr = "";
		if (str != null && str != 0) {
			SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
			tstr = myFormat.format(new Timestamp(str));
		}
		return tstr;
	}
	public static String longToDateStringMin(Long str) {
		String tstr = "";
		if (str != null && str != 0) {
			SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			tstr = myFormat.format(new Timestamp(str));
		}
		return tstr;
	}
	/**
	 * 得到当前时候的Long型的毫秒数
	 * 
	 * @return
	 */
	public static Long getCurrentLongTime() {
		return System.currentTimeMillis();
	}

	/**
	 * 是否闰年
	 * 
	 * @param year
	 *            年
	 * @return
	 */
	public static boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}

	public static Date stringToDateTime(String dateString) {

		return stringToDate(dateString, "yyyy-MM-dd HH:mm:ss");
	}

	public static Date stringToDate(String dateText, String format) {

		if (dateText == null || "".equals(dateText.trim())) {

			return null;
		}

		DateFormat df = null;

		try {

			if (format == null) {
				df = new SimpleDateFormat();
			} else {
				df = new SimpleDateFormat(format);
			}
			return df.parse(dateText);
		} catch (Exception e) {
			// e.printStackTrace();
			//System.out.println("日期格式化出错");
			return null;
		}
	}

	public static Date getCurrentDateTime() {
		Calendar calendar = Calendar.getInstance();
		return calendar.getTime();
	}

	/**
	 * 返回当前日期字符 格式：yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String getCurrentDateStr() {
		return dateToString(getCurrentDateTime(), "yyyy-MM-dd");
	}

	/**
	 * 返回当前日期字符 格式：yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String getCurrentDateTimeStr() {
		return dateToString(getCurrentDateTime(), "yyyy-MM-dd HH:mm:ss:ssss");
	}

	/**
	 * 
	 * @author 作者 xuxiangpan
	 * @version 创建时间：2012-11-3 下午5:20:56
	 * @param dateTime
	 * @return
	 */
	public static Date get000000DateTime(String date) {
		return stringToDate(date + " 00:00:00", "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 
	 * @author 作者 xuxiangpan
	 * @version 创建时间：2012-11-3 下午5:20:56
	 * @param dateTime
	 * @return
	 */
	public static Date get235959DateTime(String date) {
		return stringToDate(date + " 23:59:59", "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到系统当天的 23：59：59
	 * 
	 * @author 作者 
	 * @version 创建时间：2012-11-12 下午7:16:53
	 * @return
	 */
	public static Date getCurrent235959DateTime() {

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();

	}

	/**
	 * 得到日期和毫秒连接的字符串
	 * 
	 * @author 作者 
	 * @version 创建时间：2012-11-8 上午11:40:21
	 * @return
	 */
	public static String getCurrentNoBoundaryDateTime() {
		return DateUtil.getCurrentDateStr().replace("-", "") + Calendar.getInstance().getTimeInMillis();

	}

	/**
	 * 
	 * @author 作者 xuxiangpan
	 * @version 创建时间：2012-11-14 上午10:15:51
	 * @return
	 */
	public static Date getCurrentYearFirstDay000000() {

		Calendar calendar = Calendar.getInstance();

		calendar.set(Calendar.DAY_OF_YEAR, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();

	}

	/**
	 * 
	 * @author 作者 xuxiangpan
	 * @version 创建时间：2012-11-14 上午10:15:48
	 * @return
	 */
	public static Date getCurrentYearLastDay235959() {

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.DAY_OF_YEAR, calendar.getActualMaximum(Calendar.DAY_OF_YEAR));
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();

	}

	/**
	 * 
	 * @author 作者 xuxiangpan
	 * @version 创建时间：2012-11-14 上午10:15:45
	 * @param year
	 * @return
	 */
	public static Date getCurrentYearFirstDay000000(Integer year) {

		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.DAY_OF_YEAR, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();

	}

	/**
	 * 
	 * @author 作者 xuxiangpan
	 * @version 创建时间：2012-11-14 上午10:15:42
	 * @param year
	 * @return
	 */
	public static Date getCurrentYearLastDay235959(Integer year) {

		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.DAY_OF_YEAR, calendar.getActualMaximum(Calendar.DAY_OF_YEAR));
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();

	}

	/**
	 * 
	 * @author 作者 xuxiangpan
	 * @version 创建时间：2012-11-14 下午3:59:31
	 * @param dateStr
	 *            格式 "yyyy-MM-dd"
	 * @return
	 */
	public static Date getMonthFirstDay(String dateStr) {
		Date date = stringToDate(dateStr, "yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	/**
	 * add by xu
	 * 
	 * @author 作者 xuxiangpan
	 * @version 创建时间：2012-12-19 下午3:15:33
	 * @return
	 */
	public static Date getPreviousMonthFirstDay() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	/**
	 * add by xu
	 * 
	 * @author 作者 xuxiangpan
	 * @version 创建时间：2012-12-19 下午3:15:33
	 * @return
	 */
	public static Date getPreviousMonthLastDay() {

		Calendar calendar = Calendar.getInstance();

		calendar.add(Calendar.MONTH, -1);
		int actualMaximum = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, actualMaximum);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();

	}

	/**
	 * 
	 * @author 作者 xuxiangpan
	 * @version 创建时间：2012-11-14 下午4:06:45
	 * @param dateStr
	 * @return
	 */
	public static Date getMonthLastDay(String dateStr) {

		Date date = stringToDate(dateStr, "yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();

	}
	
	public static Date getCurrentDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}
	

public static void main(String[] args) {
	//int a = 5;
	//int b = 40;
	
	//BigDecimal c = new BigDecimal(((float)a)/((float)b)*100); 
	//float f1 = c.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue(); 
//	System.out.println(f1);
//Date date = new Date();
//date.setMonth(date.getMonth()+12);1371225600000
//System.out.println((DateUtil.stringToLong(DateUtil.getCurrentDateTimeStr(),null)));
//System.out.println(date.toLocaleString());13712256000001378461901634
	//System.out.println(longToDateString_(Long.parseLong(1378461901+"")*100 ));

//	String[] s= {"1405322469654","1405322760826","1405471941341","1405322496544","1405471880404","1405471897326","1405495534701","1405496333998","1405496392701","1405496446263","1405496496607","1405496662529","1406254373548","1406254434048"};
//	for(String i:s)
//	{
//		System.out.println(DateUtil.longToDateString(Long.parseLong(i),"yyyy-MM-dd HH:mm:ss"));
//	}
//System.out.println(new String("2014-11-27 12:12:12").substring(4, 16));
//System.out.println(longToDateString(1404982851341l));
	//System.out.println(System.currentTimeMillis()+"----"+30*24*3600*1000+";;;;"+(System.currentTimeMillis()-(30*24*3600*1000l)));

//System.out.println(DateUtil.stringToLong("2015-07-18", "yyyy-MM-dd"));
//System.out.println(DateUtil.stringToLong("2015-07-31", "yyyy-MM-dd"));

System.out.println(DateUtil.stringToLong("2016-01-01", "yyyy-MM-dd"));
System.out.println(DateUtil.longToDateString_(1492767182523L));
//String userName  = "330106193604161213";
//System.out.println(userName.substring(userName.length()-6));
//System.out.println(DateUtil.dayAdd("2015-01-01", 2));
}

//获得类似微博显示的时间格式
// createtime:传入的时间格式必须类似于2012-8-21 17:53:20这样的格式  
// format : 大于24小时显示的时间格式， 空值默认是 yyyy-MM-dd
public static String getInterval(String createtime, String format) {
    String interval = null;  
    if(createtime==null||createtime.equals(""))
    {
    	createtime=DateUtil.longToDateString(DateUtil.getCurrentLongTime());
    }
    //System.out.println("createtime="+createtime);
    SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
    ParsePosition pos = new ParsePosition(0);  
    Date d1 = sd.parse(createtime, pos);  
      
    //用现在距离1970年的时间间隔new Date().getTime()减去以前的时间距离1970年的时间间隔d1.getTime()得出的就是以前的时间与现在时间的时间间隔  
    Long time = new Date().getTime() - d1.getTime();// 得出的时间间隔是毫秒  
      
    if(time/1000 < 10 && time/1000 >= 0) {  
    //如果时间间隔小于10秒则显示“刚刚”time/10得出的时间间隔的单位是秒  
        interval ="刚刚";  
          
    } else if(time/3600000 < 24 && time/3600000 >= 0) {  
    //如果时间间隔小于24小时则显示多少小时前  
        int h = (int) (time/3600000);//得出的时间间隔的单位是小时  
        interval = h + "小时前";  
          
    } else if(time/60000 < 60 && time/60000 > 0) {  
    //如果时间间隔小于60分钟则显示多少分钟前  
        int m = (int) ((time%3600000)/60000);//得出的时间间隔的单位是分钟  
        interval = m + "分钟前";  
          
    } else if(time/1000 < 60 && time/1000 > 0) {  
    //如果时间间隔小于60秒则显示多少秒前  
        int se = (int) ((time%60000)/1000);  
        interval = se + "秒前";  
          
    }else {  
        //大于24小时，则根据format值显示时间，默认 yyyy-MM-dd
    	if (format.equals("")) {
    		format = "yyyy-MM-dd";
    	}
        SimpleDateFormat sdf = new SimpleDateFormat(format);  

        ParsePosition pos2 = new ParsePosition(0);  
        Date d2 = sdf.parse(createtime, pos2);  

        interval = sdf.format(d2);  
    }  
    //System.out.println("result="+interval);
    return interval;  
}
	
	public static Date longToDate(long time) {
		
		
		Timestamp ts = new Timestamp(time);  
        Date date = new Date();  
        try {  
            date = ts;  
           // System.out.println(date+"%%%");  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return date;

	}
	
	public static String timestampToString(Timestamp timestamp, String format) {
		
		
		 
        String tsStr = "";  
        DateFormat sdf = new SimpleDateFormat(format);  
        try {  
            //方法一  
            tsStr = sdf.format(timestamp);  
            //System.out.println(tsStr);  
            //方法二  
           // tsStr = ts.toString();  
           // System.out.println(tsStr);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
        return tsStr;
	}
	
	public static Long timestampToLong(Timestamp timestamp, String format) {
		
		
		 
        String tsStr = "";
        long result = 0L;
        DateFormat sdf = new SimpleDateFormat(format);  
        try {  
           
            tsStr = sdf.format(timestamp);
            result= stringToLong(tsStr, format);
            
            
        } catch (Exception e) {  
            e.printStackTrace();  
        }
        
        return result;
       
	}
	
	public static int getAgeByBirthday(Date birthday) {
		Calendar cal = Calendar.getInstance();

		if (cal.before(birthday)) {
			throw new IllegalArgumentException(
					"The birthDay is before Now.It's unbelievable!");
		}

		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

		cal.setTime(birthday);
		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

		int age = yearNow - yearBirth;

		if (monthNow <= monthBirth) {
			if (monthNow == monthBirth) {
				// monthNow==monthBirth 
				if (dayOfMonthNow < dayOfMonthBirth) {
					age--;
				}
			} else {
				// monthNow>monthBirth 
				age--;
			}
		}
		return age;
	}
	
	/*
	 * 
	 */
	public static String getSomeMonthOfLastDay(String yearMonth, String format) {
		
		Calendar rightNow = Calendar.getInstance();
		SimpleDateFormat simpleDate = new SimpleDateFormat(format); //如果写成年月日的形式的话，要写小d，如："yyyy/MM/dd"
		try {
		rightNow.setTime(simpleDate.parse(yearMonth)); //要计算你想要的月份，改变这里即可
		} catch (ParseException e) {
		e.printStackTrace();
		}
		Integer days = rightNow.getActualMaximum(Calendar.DAY_OF_MONTH);
		if ( days<10) {
			return "0"+days;
		}
		else {
			return days.toString();
		}
	}
	/**
	 * 
	 * @author 作者 xuxiangpan
	 * @version 创建时间：2012-11-14 下午4:06:45
	 * @param dateStr
	 * @return
	 */
	public static Long getLongTimeMonthLastDay(String dateStr) {

		Date date = stringToDate(dateStr, "yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTimeInMillis();

	}	
	/**
	 * 获取日期的月份 格式yyyy-MM-dd
	 */
	public static String getMonthOfDateStr(String dateStr) {
		if(dateStr != null && !dateStr.equals(""))
		{
			String[] arrays = dateStr.split("-");
			return arrays[1];
		}
		else
		{
			return "";
		}
		
	}	
	/**
	 * 获取日期的号 格式yyyy-MM-dd
	 */
	public static String getDayOfDateStr(String dateStr) {
		if(dateStr != null && !dateStr.equals(""))
		{
			String[] arrays = dateStr.split("-");
			return arrays[2];
		}
		else
		{
			return "";
		}
		
	}
	
	/**
	 * 某个日期的前几天或后几天
	 * 
	 * @param date
	 *            时间字符串
	 * @param 间隔数字
	 *            -1前一天  1后一天
	 * @return
	 */
	public static String dayAdd(String date, int i) {
		String str = formatDateTime("yyyy-MM-dd");
		try{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		Date  dt=df.parse(date);
		Calendar c = Calendar.getInstance(); // 当时的日期和时间
		c.setTime(dt);
		
			int d = c.get(Calendar.DAY_OF_MONTH); // 取出“日”数
			d = d + i;
			c.set(Calendar.DAY_OF_MONTH, d); // 将“日”数设置回去
			str = df.format(c.getTime());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
}
