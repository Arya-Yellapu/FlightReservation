<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seats cannot be Empty</title>
</head>
<body>
<a href="http://localhost:8080/users/getSeatsAvailable?flightno=${flightNo}&seats=${count}&userName=${username}&passWord=${password}&trip=${Trip}">Seats cannot be Empty</a>
</body>
</html>