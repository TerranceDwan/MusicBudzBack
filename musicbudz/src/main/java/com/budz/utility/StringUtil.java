package com.budz.utility;

public final class StringUtil {
	private StringUtil() {}
	
	public static boolean isBlank(String input) {
		if(input == null) {
			return true;
		}
		if(input.trim().length() > 0) {
			return false;
		} else {
			return true;
		}
		
	}
}
