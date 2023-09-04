<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="dao.*" %>
<%
	String frids = request.getParameter("frids");
	String maxNo = request.getParameter("maxNo");
	out.print((new FeedDAO()).getGroup(frids,maxNo));


%>