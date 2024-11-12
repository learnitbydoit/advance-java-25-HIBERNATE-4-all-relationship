package vn.edu.eiu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import vn.edu.eiu.controllers.HibernateController;
import vn.edu.eiu.model.Student;

public class DAO_Student implements DAO_Interface<Student> {

	@Override
	public List<Student> selectAll() {
		List<Student> lst = new ArrayList<Student>();
		try {
			SessionFactory sef = HibernateController.getSessionFactory();
			if(sef != null) {
				//1. Tạo sesssion
				Session ses = sef.openSession();
				
				//2. Mở một transaction
				Transaction trs = ses.beginTransaction();
				
				//3. Thực thi câu lệnh
				String hql = "from Student"; //lược bỏ select
				Query que = ses.createQuery(hql);
				lst = que.getResultList();
								
				//4. Xác nhận
				trs.commit();
				
				//Đóng phiên
				ses.close();
			}
			else {
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lst;
	}

	@Override
	public Student selectById(Student t) {
		Student res = new Student();
		try {
			SessionFactory sef = HibernateController.getSessionFactory();
			if(sef != null) {
				//1. Tạo sesssion
				Session ses = sef.openSession();
				
				//2. Mở một transaction
				Transaction trs = ses.beginTransaction();
				
				//3. Thực thi câu lệnh
				//String hql = "from Student where id =" +t.getId(); //Cách 1
				String hql = "from Student s where s.id = :id"; //Cách 2
				/**
				 * Lưu ý: ngôn ngữ HQL truy vấn thông qua đối tượng trên model và
				 * có phân biệt chữ hoa/thường. Ví dụ: trong câu truy vấn bên trên,  
				 * "Student" là class trong model chứ ko phải tên bảng trong database.
				 */
				Query qur = ses.createQuery(hql);
				qur.setParameter("id", t.getStudentId());
				res =  (Student) qur.getSingleResult();
				
				//4. Xác nhận
				trs.commit();
				
				//5.Đóng phiên
				ses.close();
			}
			else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public boolean insert(Student t) {
		try {
			SessionFactory sef = HibernateController.getSessionFactory();
			if(sef != null) {
				//1. Tạo sesssion
				Session ses = sef.openSession();
				
				//2. Mở một transaction
				Transaction trs = ses.beginTransaction();
				
				//3. Không cần viết câu lệnh insert into
				ses.save(t); //chỉ thêm vào database, trùng khóa chính sẽ bảo lỗi
				//ses.saveOrUpdate(t); //lưu hoặc cập nhật khi trùng khóa chính
				
				//4. Xác nhận
				trs.commit();
				
				//5.Đóng phiên
				ses.close();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Student t) {
		try {
			SessionFactory sef = HibernateController.getSessionFactory();
			if(sef != null) {
				//1. Tạo sesssion
				Session ses = sef.openSession();
				
				//2. Mở một transaction
				Transaction trs = ses.beginTransaction();
				
				//3. Không cần viết câu lệnh update
				ses.saveOrUpdate(t); //Cập nhật, nếu chưa có thì lưu mới
				
				//4. Xác nhận
				trs.commit();
				
				//5.Đóng phiên
				ses.close();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Student t) {
		try {
			SessionFactory sef = HibernateController.getSessionFactory();
			if(sef != null) {
				//1. Tạo sesssion
				Session ses = sef.openSession();
				
				//2. Mở một transaction
				Transaction trs = ses.beginTransaction();
				
				//3. Không cần viết câu lệnh delete
				ses.delete(t);
				//4. Xác nhận
				trs.commit();
				
				//5.Đóng phiên
				ses.close();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	//Có thể viết một hàm để thực thi một trong 2 câu lệnh insert/update
	public boolean insertOrUpdate(Student t) {
		try {
			SessionFactory sef = HibernateController.getSessionFactory();
			if(sef != null) {
				//1. Tạo sesssion
				Session ses = sef.openSession();
				
				//2. Mở một transaction
				Transaction trs = ses.beginTransaction();
				
				//3. Không cần viết câu lệnh insert into
				//ses.save(t); //chỉ thêm vào database, trùng khóa chính sẽ bảo lỗi
				ses.saveOrUpdate(t); //lưu hoặc cập nhật khi trùng khóa chính
				//4. Xác nhận
				trs.commit();
				
				//5.Đóng phiên
				ses.close();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
