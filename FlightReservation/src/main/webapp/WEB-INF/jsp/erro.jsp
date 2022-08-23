<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="signIn">
<label>UserName</label>
<input type="text" name=userName><br>
<label>Password</label>
<input type="text" name=passWord>
<br>
<a>Password or UserName is wrong</a>
<br>
<input type="submit" name="Login" value="Login">
</form>
<br>
<form action="Register">
<input type="submit" name="Register" value="Register">
</form>
<form action="RegisterWithGoogle">
<input type="submit" name="Register" value="RegisterWithGoogle">
</form>
</body>
</html>