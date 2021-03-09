<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Add</title>
	</head>
	<!-- jsp page for prompting user for data entry and sending those inputs to the servlet, also included a link back to index page(Home) -->
	<body style="background-color:#EFF5FB;">
		<h2 style="text-align:center">Add a Pet</h2>
			<form style="text-align:center" action="prods" method="post">
				 
				 <label for="name">Name:</label>
				 <input type="text" id="name" placeholder="Name Required" name="name" required><br><br>
				 
				 <label for="color">Color:</label>
				 <input type="text" id="color" placeholder="Color Required" name="color" required><br><br>
				 
				 <label for="price">Price:</label>
				 <input type="number" step="any" id="price" placeholder="Price required" name="price" required><br><br>
				 
				 <input type="submit" value="Submit">
			</form>
		<p style="text-align:center"><a href="index.jsp">Back to Home Page</a></p>
	</body>
</html>