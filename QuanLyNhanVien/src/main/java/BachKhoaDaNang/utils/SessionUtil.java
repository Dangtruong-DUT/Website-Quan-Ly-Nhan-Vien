package BachKhoaDaNang.utils;

import javax.servlet.http.HttpServletRequest;

// singleton with java
public class SessionUtil {
	
	private static SessionUtil intance= null;
	
	public static SessionUtil getInstance () {
		if (intance==null) {
			intance = new SessionUtil();
		}
		return intance;
	}
	// set key value into session
	public void putValue(HttpServletRequest Request, String Key,Object value) {
		Request.getSession().setAttribute(Key, value);
	}
	// set key value from session
	public Object getValue(HttpServletRequest Request, String Key) {
		return Request.getSession().getAttribute(Key);
	}
	// remove key,value in session
	public void removeValue(HttpServletRequest Request,String Key) {
		Request.getSession().removeAttribute(Key);
	}
}
