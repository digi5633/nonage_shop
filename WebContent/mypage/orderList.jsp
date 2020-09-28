<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="sub_img.html"%>
<%@ include file="sub_menu.jsp" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>주문 리스트</title>
	</head>
	
	<body>
		<article>
		<h2> Order List </h2>
		<form name="formm" method="post">
		<table id="cartList">
			<tr>
				<th>상품명</th>
				<th>수량</th>
				<th>가격</th>
				<th>주문일</th>
				<th>진행상태</th>
			</tr>
		<c:forEach items="${orderList}" var="orderList">
			<tr>
				<td>
					<a href="OrderDetail.do?pseq=${orderList.pseq}">
						<h3> ${orderList.pname} </h3>
					</a>
				</td>
				<td> ${orderList.quantity} </td>
				<td> <fmt:formatNumber value="${orderList.price2 * orderList.quantity}" type="currency"/> </td>
				<td> <fmt:formatDate value="${orderList.indate}" type="date"/> </td>
				<td> 처리 진행 중 </td>
			</tr>
		</c:forEach>
			<tr>
				<th colspan="2"> 총 액 </th>
				<th colspan="2"> <fmt:formatNumber value="${totalPrice}" type="currency"/><br></th>
				<th> 주문 처리가 완료되었습니다. </th>
			</tr>
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