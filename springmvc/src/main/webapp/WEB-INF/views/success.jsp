<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success Page</title>
<style type="text/css">
.heading, #desc{
text-align: center;
font-size: 45px;
}
</style>
</head>
<body>

<h3 class="heading">Success Page</h3>
<h3 class="heading">${heading}</h3>
<h3 id="desc">${description}</h3>
<hr>
<h4>Name:${user.username}</h4>
<h4>Password:${user.userpassword}</h4>
<h4>Email:${user.useremail}</h4>

</body>
</html>