<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="sub_img.html"%>
<%@ include file="sub_menu.html" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	
	<body>
		<article>
		<h2> Item </h2>
		<c:forEach items="${kindList}" var="kindList">
			<div id="item">
				<a href="ProductDetail.do?pseq=${kindList.pseq}">
					<img src="product_images/${kindList.image}"/>
					<h3> ${kindList.name} </h3>
					<p> ${kindList.price2} </p>
				</a>
			</div>
		</c:forEach>
		<div class="clear"></div>
		</article>
	</body>
</html>
<%@ include file="../footer.jsp" %>