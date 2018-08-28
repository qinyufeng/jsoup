package com.qyf.serviceImpl.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
	public static void main(String[] args) {
		//boolean result=isNumber("qyf");
		//boolean result=isLetter("Q");
		//boolean result=isChinese("覃玉凤");
		boolean result=notInNumber("w");
		System.out.println(result);
	}
	/*
	  * 匹配数字(0-9)
	  */
	private static boolean isNumber(String str) {
		Pattern pattern=Pattern.compile("\\d");//0-9  \d等价于[0-9],如Pattern.compile("[0-9]")
		Matcher matcher=pattern.matcher(str);
		if(matcher.find()) {
			return true;
		}
		return false;
	}
	/*
	 * 匹配不在指定范围内的任意字符(0-9)
	 */
	private static boolean notInNumber(String str) {
		Pattern pattern=Pattern.compile("[^0-9]");//可以匹配任何不在“0到9范围内的任意字符。
		Matcher matcher=pattern.matcher(str);
		if(matcher.find()) {
			return true;
		}
		return false;
	}
	/*
	 * 匹配字母(a-z)
	 */
	private static boolean isLetter(String str) {
		Pattern pattern=Pattern.compile("[a-z]");//a,b,c,...,z；匹配小写：[a-z]  匹配大写：[A-Z]
		Matcher matcher=pattern.matcher(str);
		if(matcher.find()) return true;
		return false;
	}
	/*
	 * 匹配不在指定范围内的任意字符(不在a-z)
	 */
	private static boolean notInLetter(String str) {
		Pattern pattern=Pattern.compile("[^a-z]");//“[^a-z]”可以匹配任何不在“a”到“z”范围内的任意字符。
		Matcher matcher=pattern.matcher(str);
		if(matcher.find()) return true;
		return false;
	}
	/*
	 * 匹配文字
	 */
	private static boolean isChinese(String str) {
		Pattern pattern=Pattern.compile("^覃玉凤$");// ^字符串的开始位置，$字符串的结束位置
		Matcher matcher=pattern.matcher(str);
		if(matcher.find()) return true;
		return false;
	}

	private static String complexRegex() {
		
		return null;
	}
}
