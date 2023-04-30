<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="org.apache.log4j.*" %>
<html>
  <head><title>注册信息</title></head>
  <body>
  <%
	//Log4j
	Logger onelogger=Logger.getLogger("onelogger");
	String path = getServletContext().getRealPath("WEB-INF/log4j.properties");
	PropertyConfigurator.configure(path);
%>

<%
	onelogger.info(request.getParameter("uname")+",注册成功!");
%>
     恭喜<%=request.getParameter("uname") %>,注册成功！
  </body>
</html>