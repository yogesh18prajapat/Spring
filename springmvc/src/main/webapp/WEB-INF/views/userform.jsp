<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page isELIgnored="false" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Form</title>
<style type="text/css">
#heading, #desc{
text-align: center;
font-size: 45px;
}
</style>
</head>
<body>

<h1 id="heading">${heading}</h1>
<h1 id="desc">${description}</h1>
<hr>
<form action="processform" method="POST">
<h1>
 Name: <input type="text" name="username" /> <br>
 password: <input type="password" name="userpassword" /> <br>
 Email: <input type="email" name="useremail" /> <br>
  <input type="submit" value="Submit">
  
  </h1>

</form>
</body>
</html>