<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="cate" items="${categories}">
		<a href="products?cate=${cate.getId()}">${cate.getNamevn()} </a> |
</c:forEach>
	<hr>
	<c:forEach var="p" items="${products }">
		<ul>
			<li>${p.getName()}</li>
			<li><img src="./resources/images/products/${p.getImage()} "></li>
			<li>
				<div style="float: left">$${p.getUnitPrice()}</div>
				<div style="float: right">
					<img src="images/icons/Basket.png"> <img
						src="images/icons/Letter.png"> <img
						src="images/icons/Favourites.png">
				</div>
			</li>
		</ul>
	</c:forEach>
</body>
</html>