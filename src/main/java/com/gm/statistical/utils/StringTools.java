package com.gm.statistical.utils;

import org.apache.commons.lang.StringUtils;

public class StringTools {

	/**
	 * 如果字符串为空则返回""
	 * @return
	 */
	public static String checkEmpty(String str){
		return str == null ? "" : str;
	}

	/**
	 * 数字转换校验是否为空
	 * @param str
	 * @return 为空返回0，否则返回原串
	 */
	public static String checkNumber(String str){
		return StringUtils.isEmpty(str) ? "0" : str;
	}

	/**
	 * 获取当前时间戳
	 * @param s s:秒;other:毫秒
	 * @return
	 */
	public static String getTimeStamp(String s){
		if("s".equals(s)){
			return String.valueOf(System.currentTimeMillis() / 1000);
		} else {
			return String.valueOf(System.currentTimeMillis());
		}
	}
}
