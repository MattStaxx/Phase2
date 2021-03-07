<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Add</title>
	</head>
	
	<body>
		<form action="prods" method="post">
			 <label for="name">ID:</label>
			 <input type="number" id="id" name="id"><br><br>
			 
			 <label for="name">Name:</label>
			 <input type="text" id="name" name="name"><br><br>
			 
			 <label for="color">Color:</label>
			 <input type="text" id="color" name="color"><br><br>
			 
			 <label for="price">Price:</label>
			 <input type="number" id="price" name="price"><br><br>
			 
			 <input type="submit" value="Submit">
		</form>
			 <a href="index.jsp">Back to Add Products Page</a>
	</body>
</html>