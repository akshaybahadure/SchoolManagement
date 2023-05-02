package schoolManagement.controller;

import java.io.IOException;
import java.io.PrintWriter;

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

import schoolManagement.dto.students;
import schoolManagement.dto.teachers;

@WebServlet("/addTeacher")
public class addTeacher  extends HttpServlet{

	

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String i=req.getParameter("id");
			String name=req.getParameter("tname");
			String a=req.getParameter("age");
			String subject=req.getParameter("subject");
			String email=req.getParameter("email");
			String pass=req.getParameter("pass");
			
			int id=Integer.parseInt(i);
			int age=Integer.parseInt(a);
			
			teachers t=new teachers();
			t.settId(id);
			t.settName(name);
			t.setSubject(subject);
			t.setAge(age);
			t.setsEmail(email);
			t.setsPass(pass);
			
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("Akshay");
			EntityManager em1=emf.createEntityManager();
			EntityTransaction et=em1.getTransaction();
			
			et.begin();
			em1.persist(t);
			et.commit();
			
			PrintWriter pw=resp.getWriter();
			pw.write("TEACHER PROFILE ADDED!!");
			RequestDispatcher rd=req.getRequestDispatcher("managehomepgae.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
		}

}