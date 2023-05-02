package schoolManagement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import schoolManagement.dto.management;
import schoolManagement.dto.students;
import schoolManagement.dto.teachers;

@WebServlet("/validation")
public class validateManagement  extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String e=req.getParameter("email");
		String p=req.getParameter("pass");
		String choice=req.getParameter("selectOne");
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Akshay");
		EntityManager em1=emf.createEntityManager();
		EntityTransaction et=em1.getTransaction();
		
		if(choice.equals("TEACHER LOGIN")) {
			
			Query q=em1.createQuery("select a from teachers a");
			
			List<teachers> valid=q.getResultList();
			
			for(teachers m1 : valid) {
				
				String email=m1.getsEmail();
				String pass=m1.getsPass();
				
				if(e.equals(email)&& p.equals(pass)) {
					
					HttpSession hs=req.getSession();
					hs.setAttribute("teacher", m1);
					
					RequestDispatcher rd=req.getRequestDispatcher("teacherHomepage.html");
					rd.forward(req, resp);
				}
			}
			PrintWriter pw=resp.getWriter();
			pw.write("INVALID CREDENTIALS");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
			
		}
		else if(choice.equals("STUDENT LOGIN")){
			
			Query q=em1.createQuery("select a from students a");
			
			List<students> valid=q.getResultList();
			
			for(students m1 : valid) {
				
				String email=m1.getsEmail();
				String pass=m1.getsPass();
				
				if(e.equals(email)&& p.equals(pass)) {
					RequestDispatcher rd=req.getRequestDispatcher("welcome.html");
					rd.forward(req, resp);
				}
			}
			
			PrintWriter pw=resp.getWriter();
			pw.write("INVALID CREDENTIALS");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
			
			
		}
		else if(choice.equals("MANAGEMENT LOGIN")){
			
			Query q=em1.createQuery("select a from management a");
			
			List<management> valid=q.getResultList();
			
			for(management m1 : valid) {
				
				String email=m1.getEmail();
				String pass=m1.getPassword();
				
				if(e.equals(email)&& p.equals(pass)) {
					RequestDispatcher rd=req.getRequestDispatcher("manageHomepgae.html");
					rd.forward(req, resp);
				}
			}
			
			PrintWriter pw=resp.getWriter();
			pw.write("INVALID CREDENTIALS");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
		
			
		}
		
		
	}

}