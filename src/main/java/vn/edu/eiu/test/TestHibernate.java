package vn.edu.eiu.test;

import java.sql.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import vn.edu.eiu.controllers.HibernateController;
import vn.edu.eiu.model.School;
import vn.edu.eiu.model.Student;
import vn.edu.eiu.model.Subject;
import vn.edu.eiu.model.User;

public class TestHibernate {

	public static void main(String[] args) {
		SessionFactory sef = HibernateController.getSessionFactory();
		if(sef != null) {
			//1. Tạo sesssion
			Session ses = sef.openSession();
			
			//2. Mở một transaction
			Transaction trs = ses.beginTransaction();
			
			School sch1 = new School("CIT", "Computer and Information Technology", null);
			School sch2 = new School("BBS", "Becamex Business School", null);

			User user1 = new User("std01", "std@1", 1);
			User user2 = new User("std02", "std@2", 1);
			User user3 = new User("std03", "std@3", 1);
			User user4 = new User("std04", "std@4", 1);
			
			Subject sub1 = new Subject("CSE 456", "Advanced Java Programing",4);
			
			Student st1 = new Student("Nguyen Van", "Minh", sch1, new Date(2001, 5, 19), true, user1);
			Student st2 = new Student("Tran Trung", "Nam", sch1, new Date(2002, 10, 1), true, user2);
			Student st3 = new Student("Le Thien", "Nga", sch1, new Date(2000, 3, 16), true,user3);
			Student st4 = new Student("Trinh My", "Tien", sch2, new Date(2000, 12, 1), false,user4);
			
			//sub1.addStudent(st1);
			st1.addSubject(sub1);
			
			ses.saveOrUpdate(sch1);
			ses.saveOrUpdate(sch2);
			
			ses.saveOrUpdate(st1);
			ses.saveOrUpdate(st2);
			ses.saveOrUpdate(st3);
			ses.saveOrUpdate(st4);
			
			ses.saveOrUpdate(user1);
			ses.saveOrUpdate(user2);
			ses.saveOrUpdate(user3);
			ses.saveOrUpdate(user4);

			//4. Xác nhận
			trs.commit();
			
			//5.Đóng phiên
			ses.close();
		}
	}

}
