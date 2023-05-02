<%@page import="schoolManagement.dto.teachers"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		HttpSession hs=request.getSession();
		teachers t = (teachers)hs.getAttribute("teacher");
		int i=t.gettId();
		String name=t.gettName();
		String subject=t.getSubject();
		int age=t.getAge();
		String email=t.getsEmail();
		String pass=t.getsPass();
	%>
	
	<pre>
	
	
	
	
	</pre>
	<center>
	
		<form action="updateTeacherServlet" method="post">
		
			<h2>UPDATE TEACHER DETAILS</h2><br>	
			
			<h4>TEACHER ID: <%=i %></h4>
			<input type="text" placeholder="<%=name%>" name="name"><br><br>
			<input type="text" placeholder="<%=subject%>" name="sub"><br><br>
			<input type="number" placeholder="<%=age%>" name="age"><br><br>
			<input type="text" placeholder="<%=email%>" name="email"><br><br>
			<input type="text" placeholder="<%=pass%>" name="pass"><br><br>
			
			<input type="submit">
		</form>
	
	</center>
</body>
</html>