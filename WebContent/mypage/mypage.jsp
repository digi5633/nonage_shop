<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="sub_img.html"%>
<%@ include file="sub_menu.jsp" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>마이 페이지</title>
	</head>
	
	<body>
		<article>
		<h2> My Page(${title}) </h2>
		<form name="formm" method="post">
		<table id="cartList">
			<tr>
				<th>주문일자</th>
				<th>주문번호</th>
				<th>상품명</th>
				<th>결제 금액</th>
				<th>주문 상세</th>
			</tr>
			<c:forEach items="${orderList}" var="orderList">
				<tr>
					<td> <fmt:formatDate value="${orderList.indate}" type="date"/></td>
					<td> ${orderList.oseq} </td>
					<td> ${orderList.pname} </td>
					<td> <fmt:formatNumber value="${orderList.price2}" type="currency"/> </td>
					<td> <a href="OrderDetail.do?oseq=${orderList.oseq}"> 조회 </a></td>
				</tr>
			</c:forEach>
		</table>
		<div class="clear"></div>
			<div id="buttons" style="float: right">
				<input type="button" value="쇼핑 계속하기" class="cancel" onclick="location.href='ProductList.do'">
			</div>
		</form>
		</article>
	</body>
</html>

<%@ include file="../footer.jsp" %>