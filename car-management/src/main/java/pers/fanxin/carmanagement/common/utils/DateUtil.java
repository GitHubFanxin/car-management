package pers.fanxin.carmanagement.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	public static Date strToDate(String strDate){
		try {
			return sdf.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String dateToString(Date date){
		return sdf.format(date);
	}
	
	public static Date getDateEnd(Date strDate){
		Date end = null;
		end = new Date(strDate.getTime()+3600000*24);
		return end;
	}
	
	public static Date getPerDate(Date date, int num){
		Date per = null;
		long x= (long)3600000*24*num;
		per = new Date(date.getTime()-x);
		return per;
	}
	
	public static Date getLaterDate(Date date, int num){
		Date later = null;
		long x= (long)3600000*24*num;
		later = new Date(date.getTime()+x);
		return later;
	}
	
	public static Date getCurDate(){
		String strDate = sdf.format(new Date());
		Date date = null;
		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
