 package schoolManagement.controller;
 import java.io.IOException;
	import java.io.PrintWriter;
	import java.util.ArrayList;
	import java.util.List;

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
	import schoolManagement.dto.students;

	@WebServlet("/addStudent")
public class addStudent extends HttpServlet {
		@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String i=req.getParameter("id");
			String name=req.getParameter("sname");
			String dob=req.getParameter("dob");
			String c=req.getParameter("cno");
			String email=req.getParameter("email");
			String pass=req.getParameter("pass");
			
			int id=Integer.parseInt(i);
			long cno=Long.parseLong(c);
			
			students s=new students();
			s.setsId(id);
			s.setsName(name);
			s.setsEmail(email);
			s.setsPass(pass);
			s.setCno(cno);
			s.setDOB(dob);
			
			List <students> stud=new ArrayList();
			stud.add(s);
		
			
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("Akshay");
			EntityManager em1=emf.createEntityManager();
			EntityTransaction et=em1.getTransaction();
			
			
			management m=em1.find(management.class, 1);
			
			m.setStudents(stud);
			
			et.begin();
			em1.persist(s);
			em1.merge(m);
			et.commit();
			
			PrintWriter pw=resp.getWriter();
			pw.write("STUDENT PROFILE ADDED!!");
			RequestDispatcher rd=req.getRequestDispatcher("managehomepgae.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
			
			
		}
	}
