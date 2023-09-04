<%@ page contentType="text/html;" pageEncoding="utf-8" %>
<%@ page import="dao.UserDAO" %>
<%@ page import="util.FileUtil" %>
<%@ page import="dao.*" %>

<%


String imgstr = "";

imgstr = "<img src ='images/" + "test" + "' width=240>";
String str = application.getRealPath(imgstr);
out.print(imgstr);
%>