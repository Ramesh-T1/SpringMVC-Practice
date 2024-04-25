<%@ page import="java.util.List" %>
<%@ page import="demo.planner.Todo" %>
<%@ include file="commons/navigation.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List todos</title>
<link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body> 
<%=request.getAttribute("username") %> Your todo's are
<br/>
<div class="container">
<table class="table table-stripped">
<thead>
<tr>
<th>Description</th>
<th>Date</th>
<th>Completed</th>
</tr>
</thead>
<tbody>
<%List<Todo> g=(List<Todo>)request.getAttribute("to-dos"); 
for(Todo x:g)
{%>
<tr>
<td><%=x.getDesc()%></td>
<td><fmt:formatDate pattern="dd-MM-yyyy" value="<%=x.getTargetDate()%>"/></td>
<td><%=x.isDone()%></td>
<td><a href="<%=request.getContextPath()%>/delete-todo?id=<%=x.getId()%>" class="btn btn-danger">Delete</a></td>
<td><a href="<%=request.getContextPath()%>/update-todo?id=<%=x.getId()%>" class="btn btn-success">Update</a>
</tr>
</tbody>
<%}%>
</table>
</div>
<div>
<a href="<%=request.getContextPath()%>/add-todo" class="btn btn-success">Add</a>
</div>
<script src="webjars/jquery/3.7.1/jquery.min.js"></script>
<script src="webjars/bootstrp/5.3.3/js/bootstrap.min.js"></script>
</body>
</html>