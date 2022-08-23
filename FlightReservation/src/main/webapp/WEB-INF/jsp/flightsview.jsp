<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Flights</title>
</head>
<body>
<c:forEach items="${list}" var="flight" varStatus="status">
<tr>
<td>${flight.flightno}</td>
<td>${flight.source}</td>
<td>${flight.destination}</td>
<td>${flight.traveldate}</td>
<td>${flight.name}</td>
<td>${flight.priceperperson}</td>
<td><a href="<c:url value='http://localhost:8080/users/getSeatsAvailable?flightno=${list[status.index].flightno}&seats=${count}&userName=${username}&passWord=${password}'/>">Select flight</a></td>
</tr>
</c:forEach>
<br>
<form action="getAvailableFlights">
<input type ="hidden" name="userName" value="${username}">
<input type ="hidden" name="passWord" value="${password}">
<a href="http://localhost:8080/users/signIn?userName=${username}&passWord=${password}&Login=Login">Home</a>
</form>
</body>
</html>