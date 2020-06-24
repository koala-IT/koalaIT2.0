package com.koalaIT.common.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;

public class CookieUtils {
	final static Pattern IP_PATTERN = Pattern.compile("^(?:[0-9]{1,3}\\.){3}[0-9]{1,3}$");

	public static String getDomainName(HttpServletRequest request) {
		String domainName = request.getServerName();
		try {
			URL url = new URL(request.getRequestURL().toString());
			domainName = url.getHost();
			if (IP_PATTERN.matcher(domainName).matches()) {
				// ip地址不做处理
			} else {
				String[] part = domainName.split("\\.");
				if (part.length > 2) {
					StringBuffer sb = new StringBuffer();
					for (int i = 1; i < part.length; i++) {
						sb.append(".");
						sb.append(part[i]);
					}
					domainName = sb.toString();
				}
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		domainName.toLowerCase();
		if (domainName.equals("localhost")) {
			domainName = null;// for chrome browser;
		}
		return domainName;
	}

	/**
	 * Returns the specified cookie, or <tt>null</tt> if the cookie does not
	 * exist. Note: because of the way that cookies are implemented it's
	 * possible for multiple cookies with the same name to exist (but with
	 * different domain values). This method will return the first cookie that
	 * has a name match.
	 * 
	 * @param request
	 *            the servlet request.
	 * @param name
	 *            the name of the cookie.
	 * @return the Cookie object if it exists, otherwise <tt>null</tt>.
	 */
	public static Cookie getCookie(HttpServletRequest request, String name) {
		Cookie cookies[] = request.getCookies();
		// Return null if there are no cookies or the name is invalid.
		if (cookies == null || name == null || name.length() == 0) {
			return null;
		}
		// Otherwise, we do a linear scan for the cookie.
		Cookie cookie = null;
		for (int i = 0; i < cookies.length; i++) {
			// If the current cookie name matches the one we're looking for,
			// we've
			// found a matching cookie.
			if (cookies[i].getName().equals(name)) {
				cookie = cookies[i];
				// The best matching cookie will be the one that has the correct
				// domain name. If we've found the cookie with the correct
				// domain name,
				// return it. Otherwise, we'll keep looking for a better match.
				String domainName = getDomainName(request);
				String cookieDomain = cookie.getDomain();
				if (domainName != null && domainName.equals(cookieDomain)) {
					break;
				}
			}
		}
		return cookie;
	}

	/**
	 * Deletes the specified cookie.
	 * 
	 * @param request
	 *            the servlet request.
	 * @param response
	 *            the servlet response.
	 */
	public static void deleteCookie(HttpServletRequest request, HttpServletResponse response, String cookieName) {
		if (cookieName != null) {
			// Invalidate the cookie
			String path = request.getContextPath() == null ? "/" : request.getContextPath();
			if ("".equals(path)) {
				path = "/";
			}
			Cookie cookie = new Cookie(cookieName,"");
			cookie.setPath(path);
			cookie.setMaxAge(0);
			String domainName = getDomainName(request);
			if (domainName != null) {
				cookie.setDomain(getDomainName(request));
			}
			response.addCookie(cookie);
		}
	}

	/**
	 * Stores a value in a cookie. By default this cookie will persist for 30
	 * days.
	 * 
	 * @see #setCookie(HttpServletRequest, HttpServletResponse,String,String,int)
	 * @param request
	 *            the servlet request.
	 * @param response
	 *            the servlet response.
	 * @param name
	 *            a name to identify the cookie.
	 * @param value
	 *            the value to store in the cookie.
	 */
	public static void setCookie(HttpServletRequest request, HttpServletResponse response, String name, String value) {
		// Save the cookie value for 1 month
		setCookie(request, response, name, value, 60 * 60 * 24 * 30);
	}

	/**
	 * Stores a value in a cookie. This cookie will persist for the amount
	 * specified in the <tt>saveTime</tt> parameter.
	 * 
	 * @see #setCookie(HttpServletRequest, HttpServletResponse,String,String)
	 * @param request
	 *            the servlet request.
	 * @param response
	 *            the servlet response.
	 * @param name
	 *            a name to identify the cookie.
	 * @param value
	 *            the value to store in the cookie.
	 * @param maxAge
	 *            the time (in seconds) this cookie should live.
	 */
	public static void setCookie(HttpServletRequest request, HttpServletResponse response, String name, String value, int maxAge) {
		// Check to make sure the new value is not null (appservers like Tomcat
		// 4 blow up if the value is null).
		if (value == null) {
			value = "";
		}
		String path = request.getContextPath() == null ? "/" : request.getContextPath();
		if ("".equals(path)) {
			path = "/";
		}
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(maxAge);
		cookie.setPath(path);
		String domainName = getDomainName(request);
		if (domainName != null) {
			cookie.setDomain(getDomainName(request));
		}
		response.addCookie(cookie);
	}
}
