/**
 * this class to handel the data 
 * 
 * by Tawfiq toubeh 4/10/2020
 * */
package com.taw.service;

import java.util.*;
import java.util.stream.Collectors;

import com.taw.assets.Commons;

import bean.HomeBean;
import model.*;

public class HomeService extends Commons<Object> {
	
	public HomeService() {
		super(HomeService.class);
	}

	private HomeBean bean = new HomeBean();

	/** this method to convert the dept from lest to map */
	public Map<String, Integer> getSelectedDepartments(int selected) {
		commonLoger.info("start getSelectedDepartments method");

		List<Department> list = bean.getSelectedDepartments(selected);

		return list.stream().collect(Collectors.toMap(x -> x.getName(), x -> x.getId()));
	}

	/** this method to convert the faculty from lest to map */
	public Map<String, Integer> getAllFaculy() {
		commonLoger.info("start getAllFaculy method");

		List<Faculty> list = bean.getAllFaculy();

		return list.stream().collect(Collectors.toMap(x -> x.getFacultName(), x -> x.getId()));

	}

}