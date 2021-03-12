<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login</title>
	</head>
	<style>
		body {
		  background-image: url('lockAndKeyboard.jpg');
		  background-repeat: no-repeat;
		  background-attachment: fixed;
		  background-size: 100% 100%;
		}
		</style>
	<body>
		<div>
			<h2 style="text-align:center;color:white">User Login</h2><br>
				<form style="text-align:center" action="login" method="post">
					 
					 <label style="color:white" for="name">Name:</label>
					 <input type="text" id="name" placeholder="Name Required" name="name" required><br><br>
					 
					 <label style="color:white" for="password">Password:</label>
					 <input type="password" id="password" placeholder="Password Required" name="password" required><br><br>
					 
					 <input type="submit" value="Login">
				</form><br>
			<p style="text-align:center"><a href="index.jsp">Back to Main Page</a></p>
		</div>
	</body>
</html>