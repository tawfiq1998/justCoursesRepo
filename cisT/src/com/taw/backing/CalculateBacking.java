/**
 * this class to oporate calculater page
 * 
 *  by Tawfiq Toubeh
 *  
 *  last update 2\2
 * */
package com.taw.backing;

import java.io.IOException;
import java.util.*;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.taw.assets.Commons;

public class CalculateBacking extends Commons<Object> {

	private List<Integer> houersNun; // this array to hold number of houers for each cours
	private List<Float> grades;// this array to hold the grade for each cours
	int sum; // to hold the avarage
	private int numberOfC;// to insert numbeer of coursses
	private boolean showPanelGrid;// to render houers and graids pannel

	/** CalculateBacking constructer */
	public CalculateBacking() {
		super(CalculateBacking.class);
		showPanelGrid = false;
		houersNun = new ArrayList<Integer>();
		grades = new ArrayList<Float>();
		sum = 0;
	}

	/**this method to change number of courses*/
	public void changeNumOfCourses() {
		showPanelGrid = numberOfC > 0;
		houersNun = new ArrayList<Integer>(Collections.nCopies(numberOfC, null));
		grades = new ArrayList<Float>(Collections.nCopies(numberOfC, null));

	}
//	void cinvertStringToInt() {
//		for (String stringValue : houersNun) {
//			try {
//				// Convert String to Integer, and store it into integer array list.
//				dd1.add(Double.parseDouble(stringValue));
//			} catch (NumberFormatException nfe) {
//				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("insert the numbers correctly"));
//			}
//		}
//		for (String stringValue : grades) {
//			try {
//				// Convert String to Integer, and store it into integer array list.
//				dd2.add(Double.parseDouble(stringValue));
//			} catch (NumberFormatException nfe) {
//				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("insert the numbers correctly"));
//			}
//		}
//	}

	/**
	 * this method to calculate the final grade
	 */
	public void calc() {
		System.out.println(houersNun);
		commonLoger.info("calc method starts");
//		cinvertStringToInt();
		if (houersNun.size() != grades.size()) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("insert the numbers correctly"));
			return;
		}
		double noh = 0;
		for (int i = 0; i < houersNun.size(); i++) {
			if (houersNun.get(i) == null || grades.get(i) == null)
				continue;
			sum += houersNun.get(i) * grades.get(i);
			noh += houersNun.get(i);
		}

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("your gpa is " + Math.round(sum / noh * 100.0) / 100.0));
		sum = 0;
		noh = 0;
	}

	/**
	 * this method to navigate to homepage
	 */
	public void goToHome() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
	}

	public List<Integer> getHouersNun() {
		return houersNun;
	}

	public void setHouersNun(List<Integer> houersNun) {
		this.houersNun = houersNun;
	}

	public List<Float> getGrades() {
		return grades;
	}

	public void setGrades(List<Float> grades) {
		this.grades = grades;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getNumberOfC() {
		return numberOfC;
	}

	public void setNumberOfC(int numberOfC) {
		this.numberOfC = numberOfC;
	}

	public boolean isShowPanelGrid() {
		return showPanelGrid;
	}

	public void setShowPanelGrid(boolean showPanelGrid) {
		this.showPanelGrid = showPanelGrid;
	}
}
