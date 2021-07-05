/**
 * this class to use some checkes
 * 
 *  by Tawfiq Toubeh
 *  
 *  last update 3\2
 * */
package com.taw.assets;

public class Checker {
	public static final String isEmpty(String x, String erorrMessage) {// return error mess if empty
		return x.isEmpty() ? erorrMessage : "";
	}

	public static final String checkLength(String x, int requierdLength, String erorrMessage) {// return error mess if
																								// string lenght less
																								// than req length
		return x.length() >= requierdLength ? "" : erorrMessage;
	}
}
