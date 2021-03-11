<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login</title>
	</head>
	<body>
		<form action="login" method="post">
			 
			 <label for="n">Name:</label>
			 <input type="text" id="name" name="name"><br><br>
			 
			 <label for="p">Password:</label>
			 <input type="text" id="password" name="password"><br><br>
			 
			 <input type="submit" value="Login">
		</form>
	 	<a href="index.jsp">Back to Main Page</a>
	</body>
</html>