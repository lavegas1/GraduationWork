<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="dao.*" %>
<%

	String uid = request.getParameter("id");
	out.print((new UserDAO()).get(uid));


%>