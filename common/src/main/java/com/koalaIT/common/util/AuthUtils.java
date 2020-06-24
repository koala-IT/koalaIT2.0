package com.koalaIT.common.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AuthUtils {
	protected final Log logger = LogFactory.getLog(AuthUtils.class);
	/**
	 * 取得当前登录的用户Id
	 * 
	 * @return
	 */
	public static String getLoginName() {
		return null;
	}

	public String formatterMobile(String mobile) {
		try {
			return mobile.substring(0,3) + "****" + mobile.substring(7, mobile.length());
		}catch (Exception e){
			logger.error(e);
			logger.error("手机格式化错误！");
			return mobile;
		}

	}
}
