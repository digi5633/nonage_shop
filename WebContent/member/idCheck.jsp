<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>아이디 중복 체크</title>
		<link href="css/subpage.css" rel="stylesheet">
		<!-- <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
		<script type="text/javascript">
		$(function() {
			$('#chkid').on("click", function() {
				 if (confirm("중복 체크 하시겠습니까?") == true) {	// 확인
					 open_win("IdCheck.do?id=");
			    } else {	// 취소
			    	return;
			    }
				 
			});
			
			$('#idok').on("click", function() {
				opener.formm.id.value="${id}"
				opener.formm.reid.value="${id}"
				self.close();
			});
			
		});
		
		function open_win(url, name) {
			window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=230");
		} 
		</script>-->
		<style type="text/css">
			body {
				background-color: #B96DB5;
				font-family: Verdana;
			}
			
			#wrap {
				margin: 0 20px;
			}
			
			h1 {
				font-family: "Times New Roman", Times, serif;
				font-size: 45px;
				color: #CCC;
				font-weight: normal;
			}
			
			input[type=button], input[type=submit] {
				float: right;
			}
		</style>
		<script type="text/javascript">
			function idok() {
				opener.formm.id.value="${id}";
				opener.formm.reid.value="${id}";
				self.close();
			}
		</script>
	</head>
	
	<body>
		<div id="wrap">
		<h1>ID 중복확인</h1>
		<form action="IdCheck.do" method="post" name="formm" style="margin-right: 0">
			User ID <input id="id" type="text" name="id" value="">
					<input id="chkid" type="submit" value="검색" class="submit"><br>
		<div style="margin-top: 20px">
			<c:if test="${message == 1}">
				<script type="text/javascript">
					opener.document.formm.id.value = "";
				</script>
				${id}는 이미 사용중인 ID입니다.
			</c:if>
			<c:if test="${message == 0}">
				${id}는 사용 가능한 ID입니다.
				<input type="button" value="사용" class="cancel" onclick="idok()">
			</c:if>
		</div>
		</form>
		</div>
	</body>
</html>