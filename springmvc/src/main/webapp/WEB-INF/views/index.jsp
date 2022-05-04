<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Welcome to JSP</h1>
	<%
	String name = (String) request.getAttribute("name");
	Integer age = (Integer) request.getAttribute("age");
	List<String> friends = (List<String>) request.getAttribute("friends");
	%>

	<h1>
		Name:
		<%=name%></h1>
	<br>
	<h1>
		Age:
		<%=age%></h1>
	<br>

	<%
	for (String x : friends) {
	%>
	<h3><%=x%></h3>
	<%
	}
	%>
</body>
</html>