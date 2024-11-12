package vn.edu.eiu.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import vn.edu.eiu.dao.DAO_User;
import vn.edu.eiu.model.User;

/**
 * Servlet implementation class ServletController
 */
@WebServlet("/login")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String url ="/index.jsp";
		DAO_User daou = new DAO_User();
		//Truy vấn
		User user = new User(username, password, 0);
		String foundUser = daou.selectById(user).getUsername();

		if(foundUser != null && daou.selectById(user).getPassword().equals(password)) {
			//Mở servlet session
			HttpSession session = request.getSession();
			
			//Lưu trữ Username trong Session
			session.setAttribute("username", foundUser);
			request.setAttribute("password",password);
			url="/successful.jsp";
		}
		else
		{
			url="/unsuccessful.jsp";
		}
		
		//request.setAttribute("password", password);
		RequestDispatcher rD = request.getServletContext().getRequestDispatcher(url);
		rD.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
