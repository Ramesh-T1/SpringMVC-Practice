<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<nav role="navigation" class="navbar navbar-default">
<div class="">
<a href="http://wwww.in28minutes.com" class="navbar-brand">in28Minutes</a></div>
<div class="navbar-collapse">
<ul class="nav navbar-nav">
<li><a href='<%=request.getContextPath()%>/list-todos?name=<%=request.getParameter("username")%>'>Todos</a></li></ul>
</div></nav>
</nav>
</body>
</html>