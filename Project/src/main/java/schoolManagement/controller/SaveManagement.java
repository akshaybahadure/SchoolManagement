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

  import schoolManagement.dto.management;

    @WebServlet("/addManagement")
    public class SaveManagement extends HttpServlet{
	
	

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String i=req.getParameter("id");
			String em=req.getParameter("email");
			String pass=req.getParameter("pass");
			System.out.println(i);
			
			int id=Integer.parseInt(i);
			
			management m=new management();
			m.setId(id);
			m.setEmail(em);
			m.setPassword(pass);
			
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("Akshay");
			EntityManager em1=emf.createEntityManager();
			EntityTransaction et=em1.getTransaction();
			
			et.begin();
			em1.persist(m);
			et.commit();
			
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.forward(req, resp);
			
		}
	}
