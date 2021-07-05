package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the department database table.
 * 
 */
@Entity
@NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d")
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	// bi-directional many-to-one association to Faculty
	@ManyToOne
	@JoinColumn(name = "ID", insertable = false, updatable = false)
	private Faculty faculty;

	@Column(name = "FACULTY_ID")
	@JoinColumn(name = "ID", insertable = false, updatable = false)
	private int faculty_ID;

	public Department() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Faculty getFaculty() {
		return this.faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public int getFaculty_ID() {
		return faculty_ID;
	}

	public void setFaculty_ID(int faculty_ID) {
		this.faculty_ID = faculty_ID;
	}
}