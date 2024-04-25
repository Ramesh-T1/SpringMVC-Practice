<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title> 
</head>
<body>
Welcome <%=request.getParameter("username") %>
Now you can <a href='<%=request.getContextPath()%>/list-todos?name=<%=request.getParameter("username")%>'>manage your todos</a>
</body>
</html>