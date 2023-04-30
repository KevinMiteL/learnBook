<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="org.apache.log4j.*" %>
<html>
  <head><title>主界面</title></head>
  <body>
    <%
	//Log4j
	Logger onelogger=Logger.getLogger("onelogger");
	String path = getServletContext().getRealPath("WEB-INF/log4j.properties");
	PropertyConfigurator.configure(path);
%>

 ${uname} 登录成功！
 
 <% onelogger.info(request.getAttribute("uname")+",登录成功!"); %>
  </body>
</html>