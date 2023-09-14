<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>vd CAPTCHA </title>
</head>
<body>

	<center>
		<h3>Vd CAPTCHA </h3>
	<img src="simpleCaptcha.jpg" />
	<form action="testServlet" method="post">
	<input type="text" name="answer" /><br>
	<input type="submit" value="Submit"></form>
	</center>
	

		       
		
</body>

</html>
