<%@ page contentType="text/html;" pageEncoding="utf-8" %>
<%@ page import="dao.UserDAO" %>

<%
	request.setCharacterEncoding("utf-8");
	
	String uid = request.getParameter("id");
	String upw = request.getParameter("pw");
	
	UserDAO dao = new UserDAO();
	int code = dao.login(uid, upw);
	if(code ==1){
		out.print("NE");
	}else if(code ==2){
		out.print("PE");
	}else{
		session.setAttribute("id",uid);
		out.print("OK");
		//response.sendRedirect("main.jsp");
	}
	
	
	
	
	
%>