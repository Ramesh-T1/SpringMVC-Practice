<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page import="java.util.List" %>
<%@ include file="commons/navigation.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add a Todo</title>
<link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
<h1>Add a Todo</h1>
<form:form method="post" modelAttribute="todo" commandName="todo" >
<fieldset class="form-group">
<form:hidden path="id"/>
<form:label path="desc">Description</form:label>
<form:input path="desc" type="text" required="required" class="form-control"/>
<form:errors path="desc" cssClass="text-warning"/>
<form:label path="targetDate">Target Date</form:label>
<form:input path="targetDate" type="date" class="form-control" required="required"/>
<form:errors path="targetDate" cssClass="text-warning"/>
<input type="submit" class="btn btn-sucess" value="Submit"/>
</fieldset>
</form:form>
</div>
<script src="webjars/jquery/3.7.1/jquery.min.js"></script>
<script src="webjars/bootstrp/5.3.3/js/bootstrap.min.js"></script>
</body>
</html>