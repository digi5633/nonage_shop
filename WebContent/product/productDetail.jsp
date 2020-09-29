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
	<h1> Item </h1>
		<div id="itemdetail" >
		<form method="post" name="formm">
			<fieldset>
				<legend> Item detail Info </legend>
				<a href="ProductDetail.do?pseq=${getProduct.pseq}">
					<span style="float: left;">
						<img src="product_images/${getProduct.image}" />
					</span>
					<h2> ${getProduct.name} </h2>
				</a>
				<label> 가 격 : </label>
				<p> ${getProduct.price2} 원</p>
				<label> 수 량 : </label>
				<input type="text" name="quantity" size="2" value="1"><br>
				<input type="hidden" name="pseq" value="${getProduct.pseq}"><br>
			</fieldset>
			<div class="clear"></div>
			<div id="buttons">
				<input type="button" value="장바구니에 담기" class="submit" onclick="go_cart()">
				<input type="button" value="즉시 구매" class="submit" onclick="location.href='MyPage.do'">
				<input type="reset" value="취소" class="cancel">
			</div>
		</form>
		</div>
	</article>
	</body>
</html>

<%@ include file="../footer.jsp" %>