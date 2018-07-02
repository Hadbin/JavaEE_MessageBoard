package utils;

import javax.servlet.http.Cookie;

public class CookiesUtils {
	public static Cookie getCookieByName(String name, Cookie[] cookies) {
		if (cookies != null) {
			for (Cookie c : cookies) {
				// 通过名称获取cookie
				if (name.equals(c.getName())) {
					return c;
				}
			}
		}
		// 若没找到，返回null
		return null;
	}
}
