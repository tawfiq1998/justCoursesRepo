/**
 * this class to hold common value sherd in deff class
 * 
 * by tawfiq toubeh
 * */
package com.taw.assets;

import java.util.logging.Logger;

public abstract class Commons<T> {
	public final Logger commonLoger;

	@SuppressWarnings("hiding")
	public <T> Commons(Class<T> class1) {
		commonLoger = Logger.getLogger(class1.getClass().getName());
	}


}
