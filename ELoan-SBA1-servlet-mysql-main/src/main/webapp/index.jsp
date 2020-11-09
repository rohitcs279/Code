<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>eLoan system</title>
</head>
<body>
	<!-- write the html code to read user credentials and send it to validateservlet
	    to validate and user servlet's registernewuser method if create new user
	    account is selected
	-->
<form action ="validate" methods = "post">

Enter usernname <input type = "text" name ="uname">
Enter password <input type = "password" name ="pswd">
<input type ="submit" value ="login">

</form>
</body>
</html>