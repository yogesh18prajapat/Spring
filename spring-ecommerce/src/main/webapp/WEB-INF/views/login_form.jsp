<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include  page="page_title.jsp"/>
<style>
* {
	padding: 0;
	margin: 0;
}

.container {
	height: 100vh;
	display: flex;
	justify-content: right;
	background-image:
		url("https://us.123rf.com/450wm/albund/albund1609/albund160900081/62701301-a-3d-render-of-a-wooden-door-on-a-face-brick-building-covered-by-a-closed-shutter-with-private-inves.jpg?ver=6");
		background-repeat: no-repeat;
		background-size: cover;
}

.form_container {
	/* background-color: rgb(213, 255, 255); */
	/* border: 1px solid whitesmoke; */
	color: antiquewhite;
	padding: 50px;
	width: fit-content;
	align-content: center;
	height: fit-content;
	/* background-image: linear-gradient(to right,
            rgb(31, 80, 165),rgb(45, 97, 192)); */
}

#forgot, #forgot a {
	text-align: center;
	text-decoration: none;
	color: aliceblue;
}

input {
	margin: 10px;
}

#login {
	padding: 2px 50px;
	background-image: linear-gradient(to right, rgb(213, 208, 247),
		rgb(151, 137, 211));
}

#new_user {
	padding: 2px 5px;
	background-image: linear-gradient(to right, rgb(213, 208, 247),
		rgb(151, 137, 211));
}

input {
	padding: 2px;
}

label {
	color: antiquewhite;
}
</style>
</head>
<body>

	<div class="container">
		<div class="form_container">
			<form action="login" method="POST" autocomplete="off">
				<lable for="user_name">Username:</lable>
				<input type="text" name="username" id="user_name" required><br>
				<lable for="user_password">Password:</lable>
				<input type="password" name="password" id="user_password"
					required><br>
				<button type="submit" id="login">login</button>
				<button id="new_user">
					<a href="new_user"
						style="text-decoration: none; color: rgb(15, 1, 1)">new user</a>
				</button>
				<p id="forgot">
					<a href="recoverpassword">forgot Password</a>
				</p>
			</form>
		</div>
	</div>
<script type="text/javascript">
${invalid}
</script>

</body>
</html>