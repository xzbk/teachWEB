<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>

  <frameset rows="127,*,11" frameborder="no" border="0" framespacing="0">
		 <frame src="<%=path %>/astu/top.jsp" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" />
		 <frame src="<%=path %>/astu/center.jsp" name="mainFrame" id="mainFrame" scrolling="no"/>
		 <frame src="<%=path %>/astu/down.jsp" name="bottomFrame" scrolling="no" noresize="noresize" id="bottomFrame" />
  </frameset>
</html>
