<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Help Page</title>
</head>
<body>
<h1>Welcome to help Page</h1>
<%-- <%
	String name = (String)request.getAttribute("name");
	Integer age = (Integer)request.getAttribute("age");
	Date date = (Date)request.getAttribute("date");
%>
	<h1><%=name %></h1>
	<h1><%=age %></h1>
	<h1><%=date %></h1> --%>
	
<h1>name: ${name}</h1>	
<h1>age: ${age}</h1>	
<h1>date: ${date}</h1>	
<hr>
	<c:forEach items="${numbers}" var="num">
		<h3>${num}</h3>
	</c:forEach>
	
	
	
	
</body>
</html>