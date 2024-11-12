package vn.edu.eiu.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table (name = "tbl_school")
public class School {
	@Id
	@Column(length = 10)
	private String schoolId;
	
	private String nameOfSchool;
	private String  deanOfSchool;
	
	//ánh xạ tương ứng thuộc tính school của Student
	@OneToMany(mappedBy = "school")
	private List<Student> students;
	
	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	public String getNameOfSchool() {
		return nameOfSchool;
	}
	public void setNameOfSchool(String nameOfSchool) {
		this.nameOfSchool = nameOfSchool;
	}
	public String getDeanOfSchool() {
		return deanOfSchool;
	}
	public void setDeanOfSchool(String deanOfSchool) {
		this.deanOfSchool = deanOfSchool;
	}
	/**
	 * 
	 */
	public School() {
		
	}
	/**
	 * @param school_id
	 * @param nameOfSchool
	 * @param deanOfSchool
	 */
	public School(String schoolId, String nameOfSchool, String deanOfSchool) {
		this.schoolId = schoolId;
		this.nameOfSchool = nameOfSchool;
		this.deanOfSchool = deanOfSchool;
	}
	/**
	 * @param nameOfSchool
	 * @param deanOfSchool
	 */
	
	
}
