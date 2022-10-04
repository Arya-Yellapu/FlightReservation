<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="proceedToPayment">
<input type ="hidden" name="userName" value="${username}">
<input type ="hidden" name="passWord" value="${password}">
<input type="hidden" name="flightno" value="${flightNo}">
<input type="hidden" name="trip" value="${Trip}">
<input type="hidden" name="seats" value="${count}">
<c:forEach items="${seatsList}" var="seats">
<input type="checkbox" name="selectedseats" value="${seats.seatno}">
<c:out value="${seats.seatno}"></c:out>
</c:forEach>
<input type="submit" value="Proceed to Payment">
</form>
</body>
</html>