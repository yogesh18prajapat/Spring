<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@page
	import="com.springapp.entity.UserCart, java.util.*"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CART PAGE 2</title>
<style>
* {
	margin: 0%;
}

.footer {
	background-color: darksalmon;
	/* display: flex; */
	color: rgb(16, 61, 16);
	text-shadow: 1px 1px 1px rgb(103, 146, 103);
}

.footer>div {
	float: right;
	font-size: 15px;
	margin: 10px;
}

.footer .content {
	text-align: center;
	margin: 0%;
	border: 1px solid white;
	padding-top: 20px;
	padding-bottom: 20px;
	width: 25%;
	background-color: rgb(255, 106, 130);
	box-shadow: 0px 1px 10px 1px black;
	margin-bottom: 70px;
}

.header {
	background-image:
		url('https://media.istockphoto.com/vectors/abstract-triangle-pattern-banner-design-vector-id1158980300?k=20&m=1158980300&s=612x612&w=0&h=1tY82ObO8T8-ucCe0XyjTRsGU0Du51UO5aMnGVe43qw=');
	text-align: center;
	font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
	font-weight: bolder;
	/* background-color: aquamarine; */
	font-size: 50px;
	margin-bottom: 20px;
	padding: 28px;
	margin-top: 0%;
}

#c {
	color: rgb(255, 72, 0);
}

#a {
	color: rgb(255, 110, 0);
}

#r {
	color: rgb(255, 160, 0);
}

#t {
	color: rgb(255, 180, 0);
}

.flex-container, .button {
	display: flex;
	background-color: rgb(226, 248, 226);
	border-bottom: 2px solid black;
	margin-bottom: 1px;
	justify-content: center;
}

.flex-container>div, .button>a {
	font-size: 15px;
	margin: 0px;
}

img {
	padding-left: 40px;
	width: 40px;
	height: 55px;
}

.content {
	align-self: center;
}

.left {
	width: fit-content;
}

.middle {
	text-align: left;
}

.button {
	border: 1px solid rgb(22, 114, 22);
	border-radius: 20px;
	padding: 3px 30px;
	width: 30px;
}

.button>a, .button>span {
	margin: 3px 10px;
}

.checkout {
	background-image:
		url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTKq3X6RPkPQvsKJSSdSj1CO2OTVvf_Sbe7uolao_b-lDobpJEJQVlPaXCC8k4zOCwKeiI&usqp=CAU');
	position: fixed;
	bottom: 0%;
	width: 100%;
	background-color: blanchedalmond;
	font-size: 25px;
	padding: 15px;
	text-align: center;
	margin-bottom: 10px;
}

.checkout>a {
	text-decoration: none;
	color: rgb(248, 225, 225);
}

.quantity_btn {
	text-decoration: none;
	color: rgb(22, 160, 22);
	font-weight: 1000;
}

ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
	position: fixed;
	top: 0;
	width: 100%;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover:not(.active) {
	background-color: #111;
}

.active {
	background-color: #04AA6D;
}
</style>
</head>

<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Progma", "no-cache");
response.setHeader("Expires", "0");
%>

<%

	List<UserCart> userProducts = (List<UserCart>)request.getAttribute("products");
	double total_price = 0;
	int total_quantity= 0;
	for (UserCart uc : userProducts) {
		total_price += uc.getPrice();
		total_quantity += uc.getQuantity();
	}
	request.setAttribute("total_price", total_price);
	request.setAttribute("total_quantity", total_quantity);
%>

	<div class='container'>
    <ul class='navigation'>
        <li><a href="${pageContext.request.contextPath}/home">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/profile_page">Profile</a></li>
        <li><a href="${pageContext.request.contextPath}/show_cart">Cart</a></li>
        <li><a href="${pageContext.request.contextPath}/show_orders">Orders</a></li>
        <li style="float:right"><a class="active" href="${pageContext.request.contextPath}/logout">Logout</a></li>
      </ul>

		<div style='margin-top: 35px'>
			<div class='header'>
				<span id='c'>C<span> <span id='a'>A<span>
						</span id='r'>R
					</span>
				</span id='t'>T
				</span>
			</div>

			<c:forEach items="${products}" var="product">

				<div class='flex-container'>
					<div class='image' style='flex-grow: 1'>
						<img src="${product.getImg()}" alt="shirt">
					</div>
					<div class='content left' style='flex-grow: 5'>${product.getName()}</div>
					<div class='content middle' style='flex-grow: 2'>${product.getPrice() * product.getQuantity()}</div>
					<div class='content rigth' style='flex-grow: 1'>
						<div class='button'>
						<a href='${pageContext.request.contextPath}/update_in_cart/${product.getProductId()}/${product.getSection()}/false'
							class='quantity_btn'>-</a> 
							<span id='quantity'>${product.getQuantity()}</span>
						<a href='${pageContext.request.contextPath}/update_in_cart/${product.getProductId()}/${product.getSection()}/true'
							class='quantity_btn'>+</a>
						</div>
					</div>

				</div>

			</c:forEach>


			<div class='footer'>
				<div class='content' style='flex-grow: 2'>TOTAL PRICE:
					${total_price}</div>
				<div class='content c2' style='flex-grow: 2'>TOTAL QUANTITY:
					${total_quantity}</div>
			</div>

			<div class='checkout'>
				<a href='${pageContext.request.contextPath}/do_payment'> CHECKOUT</a>
			</div>

		</div>
	</div>
</body>

</html>










