package com.zhanhong.wcs.tools;

import java.util.Calendar;

/**
 * 字符串工具类
 * @author Arvin_Li
 *
 */
public class StringUtil {
	private StringUtil(){}
	
	/**
	 * 判断字符串是否为空
	 * @param str 字符串
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(null!=str&&!"".equals(str)){
			return true;
		}
		return false;
	}
	
	/**
	 * 随机获取密码
	 * @return
	 */
	public static String getRandomPwd(){
		String pwd=System.currentTimeMillis()+"";//获取时间戳
		return pwd.substring(pwd.length()-6);
	}
	
	/**
	 * 获取流水号
	 * @return
	 * 
	 */
	public static String getSearialNumber(){
		Calendar calendar=Calendar.getInstance();
		int year=calendar.get(Calendar.YEAR);
		int month=calendar.get(Calendar.MONTH)+1;
		int day=calendar.get(Calendar.DATE);
		return year+""+(month<10?("0"+month):month)+""+(day<10?("0"+day):day)+""+calendar.getTimeInMillis();
	}
	public static void main(String[] args) {
		System.out.println(getSearialNumber());
	}
}
