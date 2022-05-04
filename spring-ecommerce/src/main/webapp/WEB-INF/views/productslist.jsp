<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <jsp:include page="page_title.jsp"></jsp:include>
    <style type="text/css">
      * {
        padding: 0;
        margin: 0%;
      }

      .cards_container {
        padding-left: 40px;
        margin-top: 30px;
      }

      .card {
        float: left;
        margin: 27px;
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
        box-sizing: border-box;
        transition: 0.3s;
        width: 15%;
        border-radius: 15px;
      }

      .container {
        padding: 2px 16px;
        background-color: darkseagreen;
      }

      .container a {
        color: black;
        text-decoration: none;
        text-align: center;
      }

      .card img {
        width: 100%;
        height: 200px;
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
		  padding-left: 5px;
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

		<script type="text/javascript">
      	${alert}
      </script>
      
    <ul class='navigation'>
        <li><a href="${pageContext.request.contextPath}/home">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/profile_page">Profile</a></li>
        <li><a href="${pageContext.request.contextPath}/show_cart">Cart</a></li>
        <li><a href="${pageContext.request.contextPath}/show_orders">Orders</a></li>
        <li style="float:right"><a class="active" href="${pageContext.request.contextPath}/logout">Logout</a></li>
      </ul>

    <div class="cards_container">
      <c:forEach items="${products}" var="product">
      <c:set var="link" value="${pageContext.request.contextPath}/product_description/${product.getId()}"></c:set>
      <div class="card">
        <a href="${link}"
          ><img src="${product.getImg()}" alt="name" style="width: 100%"
        /></a>
        <div class="container">
          <a href="${link}">
            <h4><b>${product.getName()}</b></h4>
            <p><b>${product.getPrice()}</b></p>
          </a>
          <div class="buttons">
            <a href="${pageContext.request.contextPath}/add_to_cart/${product.getId()}/${product.getSection()}"><button class="btn">Add to cart</button></a>
            <a href="${pageContext.request.contextPath}/buy_product/${product.getId()}"><button class="btn">buy now</button></a>
          </div>
        </div>
      </div>
     
      </c:forEach>
      
      
    </div>
  </body>
</html>
