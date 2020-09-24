<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="nonage_shop.ds.JndiDS"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>데이터베이스 연결 테스트</title>
		<link href="css/shopping.css" rel="stylesheet">  
	</head>
	
	<body>
		<c:set var="con" value="${JndiDS.getConnection()}"/>
		<c:out value="${con}"/>
		<br><br>
		<div id="logo" style="font-size: 18px;">
	      <a href="ProductList.do" style="">
	        <img src="images/logo.gif" width="600" height="400" alt="nonageshop"><br>
	      	Nonage Shop으로 이동
	      </a>
    	</div>
	</body>
</html>