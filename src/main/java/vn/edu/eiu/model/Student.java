package vn.edu.eiu.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * Các loại anotation của Hibernate (lưu ý dùng lớp javax.persistence.*)
 * @Entity: Thông báo lớp đối tượng sẽ được ánh xạ xuống database;
 * @Table: Thiết lập các thuộc tính của một bảng;
 * @Inheritance: Thiết lập kế thừa 
 * @Id:  Xác định thuộc tính khóa chính của bảng
 * @Column: Thiết lập tính chất cho cột của bảng
 * @Transient: Bỏ qua thuộc tính không muốn ánh xạ xuống Database
 * @JoinColumn: Thiết lập thuộc tính là khóa ngoại
 * @OneToMany: quan hệt 1-n
 * @ManyToOne: quan hệ n-1
 * @ManyToMany: quan hệ n-n
 */

@Entity
@Table(name = "tbl_student")
public class Student {
	@Id //Đặt ở thuộc tính muốn là khóa chính của bảng.
	@GeneratedValue //Thiết lập khóa tự động tăng giá trị.
	private Integer studentId;
	private String firstName;
	private String lastName;
	
	@ManyToOne
	@JoinColumn(name="schoolId")
	private School school;
	
	private Date dateOfBirth;
	private boolean gender;	
	
	@OneToOne (cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User user;

	@ManyToMany(cascade =CascadeType.ALL)
	@JoinTable(name = "EnrollCourse",
	joinColumns = {@JoinColumn(name = "studentId")},
	inverseJoinColumns = {@JoinColumn(name = "subjectId")})
	private List<Subject> enrolledSubjects = new ArrayList<Subject>();
	
	
	
	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Subject> getEnrolledSubjects() {
		return enrolledSubjects;
	}

	public void setEnrolledSubjects(List<Subject> enrolledSubjects) {
		this.enrolledSubjects = enrolledSubjects;
	}
	
	//Bổ sung phương thức add môn học
	public void addSubject(Subject sub) {
		this.enrolledSubjects.add(sub);
	}

	public Student() {

	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param school
	 * @param dateOfBirth
	 * @param gender
	 * @param user
	 * @param enrolledSubjects
	 */
	public Student(String firstName, String lastName, School school, Date dateOfBirth, boolean gender, User user) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.school = school;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.user = user;
	}

	
}
