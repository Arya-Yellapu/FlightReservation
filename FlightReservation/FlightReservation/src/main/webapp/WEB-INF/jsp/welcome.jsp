<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="selectTrip">
<label>One-Way</label>
<input type="radio" name="Trip" value="oneWay">
<label>Round Trip</label>
<input type="radio" name="Trip" value="roundTrip">
<br>
<label>Source</label>
<input type="text" name="source">
<br>
<label>Destination</label>
<input type="text" name="destination">
<br>
<label>TravelDate</label>
<input type="text" name="traveldate">
<br>
<label>ReturnDate</label>
<input type="text" name="returndate">
<br>
<label>NoOfPassengers</label>
<input type="text" name="seats">
<br>
<input type ="hidden" name="userName" value="${username}">
<input type ="hidden" name="passWord" value="${password}">
<input type="submit" value="getAvailableFlights">
</form>
</body>
</html>