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
			<h2> Cart List </h2>
			<form name="formm" method="post">
			<c:choose>
			<c:when test= "${getCart.size() == 0}">
				<h3 style="color: red; text-align: center;"> 장바구니가 비었습니다. </h3> 
			</c:when>
			<c:otherwise>
			<table id="cartList">
				<tr>
					<th>상품명</th>
					<th>수 량</th>
					<th>가 격</th>
					<th>주문일</th>
					<th>삭 제</th>    
				</tr>
			<c:forEach items="${getCart}"  var="getCart">
				<tr>      
					<td>
						<a href="ProductDetail.do?pseq=${getCart.pseq}">
							<h3> ${getCart.pname} </h3>
						</a>    
					</td>
					<td>${getCart.quantity}</td>
					<td>
						<fmt:formatNumber value="${getCart.price2*getCart.quantity}" type="currency"/> 
					</td>
					<td> <fmt:formatDate value="${getCart.indate}" type="date"/></td>      
					<td> <input type="checkbox" name="cseq" value= "${getCart.cseq}"> 
					</td>
				</tr>
			</c:forEach>
				<tr>        
					<th colspan="2"> 총 액 </th>
					<th colspan="2"> 
					<fmt:formatNumber value="${totalPrice}" type="currency"/><br>
					</th> 
					<th><a href="#" onclick="go_cart_delete()"><h3>삭제하기</h3></a></th>                       
				</tr> 
			</table> 
			</c:otherwise>  
			</c:choose>  
				<div class="clear"></div>
				<div id="buttons" style="float: right">
					<input type="button" value="쇼핑 계속하기" class="cancel" onclick="location.href='ProductList.do'">    
					<c:if test= "${getCart.size() != 0}">
						<input type="button" value="주문하기"  class="submit" onclick="go_order_insert()">
					</c:if>
				</div>
			</form>
		</article>
	</body>
</html>

<%@ include file="../footer.jsp" %>