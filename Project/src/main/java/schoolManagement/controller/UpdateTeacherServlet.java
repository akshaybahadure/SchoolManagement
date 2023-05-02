package schoolManagement.controller;
import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import schoolManagement.dto.teachers;

@WebServlet("/updateTeacherServlet")
public class UpdateTeacherServlet  extends HttpServlet{
	
	

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			HttpSession hs=req.getSession();
			teachers t=(teachers)hs.getAttribute("teachers");
			
			int i=t.gettId();
			
			String name=req.getParameter("name");
			String subect=req.getParameter("sub");
			String a=req.getParameter("age");
			String email=req.getParameter("email");
			String pass=req.getParameter("pass");
			
			int age=Integer.parseInt(a);
			
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("Akshay");
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			
			teachers t1=em.find(teachers.class, i);
			t1.settId(i);
			t1.settName(name);
			t1.setSubject(subect);
			t1.setAge(age);
			t1.setsEmail(email);
			t1.setsPass(pass);
			
			et.begin();
			em.merge(t1);
			et.commit();
			
			RequestDispatcher rd=req.getRequestDispatcher("") ;
		}
		
	}