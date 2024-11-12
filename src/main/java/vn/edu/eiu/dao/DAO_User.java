package vn.edu.eiu.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import vn.edu.eiu.controllers.HibernateController;

import vn.edu.eiu.model.User;

public class DAO_User implements DAO_Interface<User>{

	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User selectById(User t) {
		User foundUser = new User();
		try {
			SessionFactory sef = HibernateController.getSessionFactory();
			if(sef != null) {
				//1. Tạo sesssion
				Session ses = sef.openSession();
				
				//2. Mở một transaction
				Transaction trs = ses.beginTransaction();
				
				//3. Thực thi câu lệnh
				
				String hql = "from User u where u.username = :id";
				/**
				 * Lưu ý: ngôn ngữ HQL truy vấn thông qua đối tượng trên model và
				 * có phân biệt chữ hoa/thường. Ví dụ: trong câu truy vấn bên trên,  
				 * "User" là class trong model chứ ko phải tên bảng trong database.
				 */
				Query qur = ses.createQuery(hql);
				qur.setParameter("id", t.getUsername());
				foundUser =  (User) qur.getSingleResult();
				
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
		return foundUser;
	}

	@Override
	public boolean insert(User t) {
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
	public boolean update(User t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User t) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
