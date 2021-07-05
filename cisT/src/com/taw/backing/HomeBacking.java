/**
 * this class to oporate home page
 * 
 *  by Tawfiq Toubeh
 *  
 *  last update 2\2
 * */
package com.taw.backing;

import java.io.IOException;
import java.util.*;

import javax.faces.context.FacesContext;

import com.taw.assets.Commons;
import com.taw.service.HomeService;

public class HomeBacking extends Commons<Object> {
	private Map<String, Integer> faculty; // to load flcultes
	private Map<String, Integer> department; // to load depts

	private boolean enableDept = true; // to enable-disable dept box
	private boolean renderTable = false; // to enable-disable table

	private int selectdFaculty; // to hold choosen faculty
	private int selectedDepartment; // to hold choosen dept

	private HomeService homeService; // to use Homeservice

	/** constructer */
	public HomeBacking() {
		super(HomeBacking.class);
		faculty = new HashMap<String, Integer>();
		department = new HashMap<String, Integer>();
		homeService = new HomeService();
		loadCons();
	}

	/**
	 * this method to load boxes in home page at first run
	 */
	public void loadCons() {
		commonLoger.info("start loadcons method");
		faculty = homeService.getAllFaculy();
	}

	/** this method to load department when choose faculty */
	public void onChooseFaculty() {
		commonLoger.info("start onChooseFaculty method");
		if (selectdFaculty != 0) { // if no faculty choosen hide the table
			department = homeService.getSelectedDepartments(selectdFaculty);
			if (!department.isEmpty()) { // check if there is departmen in this faculty
				enableDept = false;
			}
		} else {
			enableDept = true;
			department = null;
			selectedDepartment = 0;
			renderTable = false;
		}
	}

	/** this method to load dept data when dept choose */
	public void onChooseDept() {
		commonLoger.info("start onChooseDept method");
		if (selectedDepartment != 0) { // if no faculty chossen dont rendet the table
			department = homeService.getSelectedDepartments(selectdFaculty);
			if (!department.isEmpty()) { // if this depatment contain data change render to true
				renderTable = true;
			}
		} else
			renderTable = false;

	}

	/** navigate to calender */
	public void goToCalender() throws IOException {
		commonLoger.info("start goToCalender method");
		FacesContext.getCurrentInstance().getExternalContext().redirect("calculater.xhtml");
	}

	public Map<String, Integer> getFaculty() {
		return faculty;
	}

	public void setFaculty(Map<String, Integer> faculty) {
		this.faculty = faculty;
	}

	public Map<String, Integer> getDepartment() {
		return department;
	}

	public void setDepartment(Map<String, Integer> department) {
		this.department = department;
	}

	public int getSelectdFaculty() {
		return selectdFaculty;
	}

	public void setSelectdFaculty(int selectdFaculty) {
		this.selectdFaculty = selectdFaculty;
	}

	public boolean isEnableDept() {
		return enableDept;
	}

	public void setEnableDept(boolean enableDept) {
		this.enableDept = enableDept;
	}

	public int getSelectedDepartment() {
		return selectedDepartment;
	}

	public void setSelectedDepartment(int selectedDepartment) {
		this.selectedDepartment = selectedDepartment;
	}


	public boolean isRenderTable() {
		return renderTable;
	}

	public void setRenderTable(boolean renderTable) {
		this.renderTable = renderTable;
	}


}
