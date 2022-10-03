<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Please select the type of Trip</title>
</head>
<body>
<a>Please Select the Type of Trip</a>
<form action="selectedTripisBlank">
<label>One-Way</label>
<input type="radio" name="Trip" value="oneWay">
<label>Round Trip</label>
<input type="radio" name="Trip" value="roundTrip">
<br>
<input type ="hidden" name="userName" value="${username}">
<input type ="hidden" name="passWord" value="${password}">
<input type="submit" value="getFlights">
</form>
</body>
</html>