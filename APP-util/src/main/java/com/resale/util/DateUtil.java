package com.resale.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DateUtil {
	/**
	 * 
	 * Description: 最近一周内【当前时间到七天前】
	 *
	 * @param date
	 * @return
	 * @Author xingym
	 * @Create Date: 2015年7月20日 下午5:25:05
	 */
	public static String getLastWeek(Date date) {
		int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(date));
		int month = Integer.parseInt(new SimpleDateFormat("MM").format(date));
		int day = Integer.parseInt(new SimpleDateFormat("dd").format(date)) - 6;
		if (day < 1) {
			month -= 1;
			if (month == 0) {
				year -= 1;
				month = 12;
			}
			if (month == 4 || month == 6 || month == 9 || month == 11) {
				day = 30 + day;
			} else if (month == 1 || month == 3 || month == 5 || month == 7
					|| month == 8 || month == 10 || month == 12) {
				day = 31 + day;
			} else if (month == 2) {
				if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
					day = 29 + day;
				else
					day = 28 + day;
			}
		}
		String y = year + "";
		String m = "";
		String d = "";
		if (month < 10)
			m = "0" + month;
		else
			m = month + "";
		if (day < 10)
			d = "0" + day;
		else
			d = day + "";

		return y + "-" + m + "-" + d;
	}
	
	
	/**
	 * 
	 * Description: 近一个月
	 *
	 * @param date
	 * @return
	 * @Author xingym
	 * @Create Date: 2015年7月20日 下午5:59:50
	 */
	public static String getLastMonth(Date date){
		int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(date));
		int month = Integer.parseInt(new SimpleDateFormat("MM").format(date))-1;
		int day = Integer.parseInt(new SimpleDateFormat("dd").format(date));
		if (day < 1) {
			month -= 1;
			if (month == 0) {
				year -= 1;
				month = 12;
			}
			if (month == 4 || month == 6 || month == 9 || month == 11) {
				day = 30 + day;
			} else if (month == 1 || month == 3 || month == 5 || month == 7
					|| month == 8 || month == 10 || month == 12) {
				day = 31 + day;
			} else if (month == 2) {
				if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
					day = 29 + day;
				else
					day = 28 + day;
			}
		}
		
		if(month<1){
			year -= 1;
			month +=12;
		}
		if((month == 4 || month == 6 || month == 9 || month == 11)&&day==31){
			day = 30;
		}
		if(month == 2&&day>=28){
			if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
				day = 29;
			else
				day = 28;
		}
		
		String y = year + "";
		String m = "";
		String d = "";
		if (month < 10)
			m = "0" + month;
		else
			m = month + "";
		if (day < 10)
			d = "0" + day;
		else
			d = day + "";

		return y + "-" + m + "-" + d;
	}
	/**
	 * 
	 * Description: 近三个月
	 *
	 * @param date
	 * @return
	 * @Author xingym
	 * @Create Date: 2015年7月20日 下午5:59:33
	 */
	public static String getLastQuarter(Date date){
		int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(date));
		int month = Integer.parseInt(new SimpleDateFormat("MM").format(date))-3;
		int day = Integer.parseInt(new SimpleDateFormat("dd").format(date));
		if (day < 1) {
			month -= 1;
			if (month == 0) {
				year -= 1;
				month = 12;
			}
			if (month == 4 || month == 6 || month == 9 || month == 11) {
				day = 30 + day;
			} else if (month == 1 || month == 3 || month == 5 || month == 7
					|| month == 8 || month == 10 || month == 12) {
				day = 31 + day;
			} else if (month == 2) {
				if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
					day = 29 + day;
				else
					day = 28 + day;
			}
		}
		
		if(month<1){
			year -= 1;
			month +=12;
		}
		if((month == 4 || month == 6 || month == 9 || month == 11)&&day==31){
			day = 30;
		}
		if(month == 2&&day>=28){
			if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
				day = 29;
			else
				day = 28;
		}
		
		String y = year + "";
		String m = "";
		String d = "";
		if (month < 10)
			m = "0" + month;
		else
			m = month + "";
		if (day < 10)
			d = "0" + day;
		else
			d = day + "";
		
		

		return y + "-" + m + "-" + d;
	}
	


	/**
	 * 得到指定月份的 第一天和最后一天
	 * @param str
	 * @Author tiegw
	 * @return
	 */
	public static Map<String,Object> getMonthFirstDayAndLastDay(String str){
		Map<String,Object> map = new HashMap<String,Object>();
		Calendar calendar=new GregorianCalendar();
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat mf=new SimpleDateFormat("yyyy-MM");
			Date date;
			date = mf.parse(str);
			calendar.setTime(date);
			calendar.add(calendar.DATE, 0);//因为格式化时默认了DATE为本月第一天所以此处为0
			//得到当前月的第一天
			String firstDay = sdf.format(calendar.getTime());
			calendar.roll(calendar.DATE, -1);//api解释roll()：向指定日历字段添加指定（有符号的）时间量，不更改更大的字段
			//得到当前月的最后一天
			String lastDay = sdf.format(calendar.getTime());
			map.put("firstDay", firstDay);
			map.put("lastDay", lastDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 得到指定月份的 上月的 第一天
	 * @param str
	 * @Author tiegw
	 * @return
	 */
	public static String getFirstDayOfLastMonth(String str){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		String firstDay = null ;
		try {
			date = format.parse(str);
			Calendar calendar=new GregorianCalendar();
			 calendar.setTime(date);
			 calendar.add(Calendar.MONTH, -1);
			    firstDay = format.format(calendar.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		  return firstDay;
	}
	
	/**
	 * 得到指定日期的 前一天 yyyy-M-d
	 * @param str
	 * @Author tiegw
	 * @return
	 */
	public static String getYesterdayBythisDay(Date date){
		SimpleDateFormat f = new SimpleDateFormat("yyyy-M-d");
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, -1);// 昨天 - 1天

		String yesterday = f.format(c.getTime());
		return yesterday;
	}
	/**
	 * 得到指定日期的 前一天 yyyy-MM-dd
	 * @param str
	 * @return
	 */
	public static String getYesterdayBythisDayT(Date date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, -1);// 昨天 - 1天

		String yesterday = format.format(c.getTime());
		return yesterday;
	}
	
	/**
	 * 得到指定日期的年 月 
	 * @param str
	 * @Author tiegw
	 * @return
	 */
	public static Map<String,Integer> getYearAndMonthday(String str){
		try {
			SimpleDateFormat f = new SimpleDateFormat("yyyy-M-d");
	        Date date = f.parse(str);
			Map<String,Integer> map = new HashMap<String,Integer>();
			Calendar now = Calendar.getInstance();
	        now.setTime(date);
	        int year = now.get(Calendar.YEAR);
	        int month = now.get(Calendar.MONTH) + 1; // 0-based!
	        int day = now.get(Calendar.DAY_OF_MONTH);
	        map.put("year", year);
	        map.put("month", month);
	        map.put("day", day);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 得到指定年的第一天 
	 * @param str
	 * @Author tiegw
	 * @return
	 */
	public static Map<String,String> getFirstAndEndDayOfYear(int year){
		Map<String,String> map = new HashMap<String,String>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		Date currYearFirst = calendar.getTime();
		
		calendar.roll(Calendar.DAY_OF_YEAR, -1);
		Date currYearEnd = calendar.getTime();
		map.put("firstDayOfYear", format.format(currYearFirst));
		map.put("endDayOfYear", format.format(currYearEnd));
		return map;
	}
	/**
	 * 
	 * @param str '2017-10-23'
	 * @Author tiegw
	 * @return 201710 ,201711
	 */
	public static  String getMonth(String date){
		 try {
			 DateFormat df = new SimpleDateFormat("yyyy-MM");
			 DateFormat dfs = new SimpleDateFormat("yyyyMM");
			 Date d1 = df.parse(date);
			 Calendar  g = Calendar.getInstance();
			 g.setTime(d1);
			 g.add(Calendar.MONTH,1);
			 String result=null;
			int day = Integer.valueOf(date.split("-")[2]);
			String month = date.split("-")[0]+date.split("-")[1];
			String nextMonth = dfs.format(g.getTime());
			if((day>=4)&&(day <=26)){
				result = month+","+nextMonth;
			}else{
				if((day>=1) && (day<=3)){
					result = month;
				}else{
					 result = nextMonth;
				}
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		 
	}
	
	/**
	 * 
	* @Description: 
	* @param @param 201709
	* @param @return    
	* @return int
	* @throws
	 */
	public static int getMonthByDate(String str){
		try {
			SimpleDateFormat simple = new SimpleDateFormat("yyyyMM");
			Date date = simple.parse(str);
			Calendar now = Calendar.getInstance();
			now.setTime(date);
			int month=now.get(Calendar.MONTH)+1;
			return month;
		} catch (Exception e) {
			return 0;
		}
		
	}
	
	public  static String getLastMonthAndLastMonthDay(String date){
		try {
			String str="";
			 DateFormat df = new SimpleDateFormat("yyyy-MM");
			 DateFormat dfs = new SimpleDateFormat("yyyyMM");
			 Date d1 = df.parse(date);
			 Calendar  g = Calendar.getInstance();
			 g.setTime(d1);
			 g.add(Calendar.MONTH,-1);
			 String recordDate = df.format(g.getTime())+"-26";
			 String month = dfs.format( g.getTime());
			 str = recordDate+","+month;
			 return str;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
