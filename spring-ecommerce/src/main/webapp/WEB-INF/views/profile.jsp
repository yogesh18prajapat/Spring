<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.card {
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	max-width: 300px;
	margin: auto;
	/* text-align: center; */
	font-family: arial;
}

.title {
	color: grey;
	font-size: 18px;
}

button {
	border: none;
	outline: 0;
	display: inline-block;
	padding: 8px;
	color: white;
	background-color: #000;
	text-align: center;
	cursor: pointer;
	width: 100%;
	font-size: 18px;
}

button:hover, a:hover {
	opacity: 0.9;
	color: cornsilk;
}

.align_center {
	text-align: center
}

.ans {
	margin: 0%;
}

.details {
	text-align: left;
	margin-left: 20px;
}
      ul {
        list-style-type: none;
        margin: 0;
        padding: 0;
        overflow: hidden;
        background-color: rgb(117, 112, 112);
        position: fixed;
        top: 0;
        width: 100%;
      }

      li {
        float: left;
      }

      li a {
        display: block;
        color: rgb(252, 240, 240);
        text-align: center;
        padding: 14px 25px;
        text-decoration: none;
      }

      li a:hover:not(.active) {
        background-color: rgb(92, 88, 88);
      }

      .active {
        background-color: rgb(241, 196, 137);
        color: rgb(80, 27, 27);
      }
	  .buttons{
	
      
        display: flex;
        flex-direction: row; 
          
          
	  }
      .buttons a{
          width: 200px;
      }

      .btn {
        width: 75px;
	    	padding: 5px 0px;
        background-color: rgb(255, 140, 46);
        font-size: 13px;
        font-weight: bolder;
      }
</style>
</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Progma", "no-cache");
response.setHeader("Expires", "0");
%>

    <ul class='navigation'>
        <li><a href="${pageContext.request.contextPath}/home">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/profile_page">Profile</a></li>
        <li><a href="${pageContext.request.contextPath}/show_cart">Cart</a></li>
        <li><a href="${pageContext.request.contextPath}/show_orders">Orders</a></li>
        <li style="float:right"><a class="active" href="${pageContext.request.contextPath}/logout">Logout</a></li>
      </ul>

	<h2 class="align_center">User Profile</h2>

	<div class="card">
		<img
			src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSTR3zZjipG0-Lf-MtJcieX_ASoCDA_6JfGxA&usqp=CAU"
			alt="John" style="width: 100%; height: 250px">
		<h1 class="align_center">${user.getUsername()}</h1>
		<div class="details">
			<p class="title">name: ${user.getName()}</p>

			<p class="title">Email :${user.getEmail()}</p>

			<p class="title">contact: ${user.getPhone_no()}</p>
		</div>
		<div class="buttons">
			<a href="${pageContext.request.contextPath}/logout"><button>Logout</button></a>
			<a href="${pageContext.request.contextPath}/update/${user.getId()}"><button>Edit</button></a>
        </div>
	</div>
	

</body>
</html>