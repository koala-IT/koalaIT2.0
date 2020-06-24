package com.koalaIT.common.util;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.util.HtmlUtils;
import org.springframework.web.util.JavaScriptUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtils {

	public static String getUUID() {
		String uuid = UUID.randomUUID().toString();
		return uuid.substring(0, 8) + uuid.substring(9, 13) + uuid.substring(14, 18)
				+ uuid.substring(19, 23) + uuid.substring(24);
	}

	public static final String ORDER_SN_PREFIX = "O-";// 上传订单编号前缀

	public static final String GOODS_SN_PREFIX = "P-";// 上传商品编号前缀
	/**
	 * 随机获取字符串
	 * 
	 * @param length
	 *            随机字符串长度
	 * 
	 * @return 随机字符串
	 */
	public static String getRandomString(int length) {
		if (length <= 0) {
			return "";
		}
		char[] randomChar = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'q', 'w', 'e', 'r',
				't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z',
				'x', 'c', 'v', 'b', 'n', 'm' };
		Random random = new Random();
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < length; i++) {
			stringBuffer.append(randomChar[Math.abs(random.nextInt()) % randomChar.length]);
		}
		return stringBuffer.toString();
	}

	public static String getRealPath(String pathString) {
		if (StringUtils.isEmpty(pathString))
			return null;
		StringBuffer localStringBuffer1 = new StringBuffer();
		Matcher uuidMatcher = Pattern.compile("\\{uuid\\}").matcher(pathString);
		while (uuidMatcher.find())
			uuidMatcher.appendReplacement(localStringBuffer1, getUUID());
		uuidMatcher.appendTail(localStringBuffer1);
		StringBuffer localStringBuffer2 = new StringBuffer();
		Matcher dateMatcher = Pattern.compile("\\{date(\\(\\w+\\))?\\}").matcher(
				localStringBuffer1.toString());
		while (dateMatcher.find()) {
			String str1 = "yyyyMM";
			Matcher weekMatcher = Pattern.compile("\\(\\w+\\)").matcher(dateMatcher.group());
			if (weekMatcher.find()) {
				String str2 = weekMatcher.group();
				str1 = str2.substring(1, str2.length() - 1);
			}
			dateMatcher.appendReplacement(localStringBuffer2,
					new SimpleDateFormat(str1).format(new Date()));
		}
		dateMatcher.appendTail(localStringBuffer2);
		return localStringBuffer2.toString();
	}

	public static String escapeXSS(String in) {
		if (StringUtils.isNotBlank(in)) {
			in = JavaScriptUtils.javaScriptEscape(in);
			in = HtmlUtils.htmlEscape(in);
			return in;
		} else {
			return in;
		}
	}
	
	public static String escapeJavaScript(String in) {
		if (StringUtils.isNotBlank(in)) {
			in = JavaScriptUtils.javaScriptEscape(in);
			return in;
		} else {
			return in;
		}
	}

	public static String escapeSql(String in) {
		if (StringUtils.isNotBlank(in)) {
			in = StringEscapeUtils.escapeSql(in);
			return in;
		} else {
			return in;
		}
	}

	public static String getCompanyIdentity(int companyIdentityInt){
	  	return 	String.format("%09d", companyIdentityInt);

	}

	//生成AllowanceSn
	public static String getAllowanceSn(Integer num){
		StringBuffer allowanceSn = new StringBuffer();
		allowanceSn.append(DateUtil.strByDate(new Date(),"yyyyMMdd"));
		allowanceSn.append("27");
		allowanceSn.append(getStrngByInt(8,num));
		return allowanceSn.toString();
	}

	public static String getStrngByInt(int length ,int number){
		return String.format("%0" + length + "d", number);
	}

}
