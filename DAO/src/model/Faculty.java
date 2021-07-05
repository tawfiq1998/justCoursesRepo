package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the faculty database table.
 * 
 */
@Entity
@NamedQuery(name="Faculty.findAll", query="SELECT f FROM Faculty f")
public class Faculty implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="FACULT_NAME")
	private String facultName;

	//bi-directional many-to-one association to Department
	@OneToMany(mappedBy="faculty")
	private List<Department> departments;

	public Faculty() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFacultName() {
		return this.facultName;
	}

	public void setFacultName(String facultName) {
		this.facultName = facultName;
	}

	public List<Department> getDepartments() {
		return this.departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public Department addDepartment(Department department) {
		getDepartments().add(department);
		department.setFaculty(this);

		return department;
	}

	public Department removeDepartment(Department department) {
		getDepartments().remove(department);
		department.setFaculty(null);

		return department;
	}

}