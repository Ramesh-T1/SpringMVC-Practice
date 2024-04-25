<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
<fieldset>
<h1 align="center">Login</h1>
<div>
<form action="<%=request.getContextPath()%>/login" method="post">
<br/>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbspEnter Name : <input type="text" name="username" />
<br/><br/>
Enter Password : <input type="password" name="password"/>
<br/><br/>
<input type="submit" value="Login"/>
</form>
</div> 
</fieldset>
</body>
</html>