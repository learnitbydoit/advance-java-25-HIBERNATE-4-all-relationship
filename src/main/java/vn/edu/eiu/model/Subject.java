package vn.edu.eiu.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_Subject")
public class Subject {
	@Id // primary key
	private String subjectId;
	private String subjectName;
	private Integer credit;

	@ManyToMany(mappedBy = "enrolledSubjects")
	private List<Student> enroledStudents = new ArrayList<Student>();// nếu không new sẽ không add được
	
	// constructor

	// Bắt buộc để dùng Hibernate
	public Subject() {
		super();
	}
	
	/**
	 * @param subjectId
	 * @param subjectName
	 * @param credit
	 * @param enroledStudents
	 */
	public Subject(String subjectId, String subjectName, Integer credit) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.credit = credit;
	}

	// Getter - setter
	public String getSubjectId() {
		return subjectId;
	}


	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}


	public String getSubjectName() {
		return subjectName;
	}


	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}


	public Integer getCredit() {
		return credit;
	}


	public void setCredit(Integer credit) {
		this.credit = credit;
	}


	public List<Student> getEnroledStudents() {
		return enroledStudents;
	}


	public void setEnroledStudents(List<Student> enroledStudents) {
		this.enroledStudents = enroledStudents;
	}
	
	//Bổ sung phương thức add sinh viên
	public void addStudent(Student std) {
		this.enroledStudents.add(std);
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectName=" + subjectName + ", credit=" + credit
				+ ", enroledStudents=" + enroledStudents + "]";
	}

}
