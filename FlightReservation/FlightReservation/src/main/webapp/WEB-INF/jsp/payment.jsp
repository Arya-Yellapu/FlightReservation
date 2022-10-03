<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a>The Total Amount would be ${total}</a>
<br>
<form action="PaymentDetails">
<input type="hidden" name="cost" value="${total}">
<input type="hidden" name="Seats" value="${seats}">
<input type="hidden" name="flightno" value="${flightNo}">
<input type ="hidden" name="userName" value="${username}">
<input type ="hidden" name="passWord" value="${password}">
<label>Card Number</label>
<input type="text" name="cardNumber">
<br>
<label>CVV</label>
<input type="text" name="cvv">
<br>
<label>Expiry Month</label>
<input type="text" name="expiryMonth">
<br>
<label>Expiry Year</label>
<input type="text" name="expiryYear">
<br>
<label>Name of the Card Holder</label>
<input type="text" name="cardHolderName">
<br>
<input type="submit" value="Make Payment">
</form>
</body>
</html>