<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>   
<%@ include file="sub_img.html"%> 
<%@ include file="sub_menu.html" %> 

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원 가입</title>
		<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
		<script type="text/javascript">
		$(function() {
			$('#add').on("click", function() {
	
				if ($('#id').val() == "") {
					alert("아이디를 입력하여 주세요.");
					return;
				} else if ($('#id').val() != $('#reid').val()) {
					alert("중복확인을 클릭하여 주세요.");
					return;
				} else if ($('#pwd').val() == "") {
					alert("비밀번호를 입력해 주세요.");
					return;
				} else if ($('#pwd').val() != $('#pwdCheck').val()) {
					alert("비밀번호가 일치하지 않습니다.");
					return;
				} else if ($('#name').val() == "") {
					alert("이름을 입력해 주세요.");
					return;
				} else if ($('#email').val() == "") {
					alert("이메일을 입력해 주세요.");
					return;
				} else {
					var addMember = {
						id:$('#id').val(),
						pwd:$('#pwd').val(),
						name:$('#name').val(),
						email:$('#email').val(),
						zipNum:$('#zipNum').val(),
						address:($('#addr1').val() + " " + $('#addr2').val()),
						phone:$('#phone').val()
					};
					
					$.ajax({
						type : "post",
						url : "Join.do",
						cache : false,
						data : JSON.stringify(addMember),
						complete : function(data) {
							alert("가입 되었습니다.");
							window.location.href="Login.do";
						}
						
					});
					
				}
				
			});
			
			$('#reset').on("click", function() {
                $('#id').val(""),
				$('#pwd').val(""),
                $('#pwdCheck').val(""),
                $('#name').val(""),
                $('#email').val(""),
                $('#zipNum').val(""),
                $('#addr1').val(""),
                $('#addr2').val(""),
                $('#phone').val("")
			});
			
			/* $('#chkid').on("click", function() {
				$('#id').focus()
				 if (confirm("중복 체크 하시겠습니까?") == true) {	// 확인
					 open_win("IdCheck.do?id=${id}");
			    } else {	// 취소
			    	return;
			    }
				 
			}); */
	
		});
		
		/* function open_win(url, name) {
			window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=230");
		} */
		
		</script>
	</head>
	
	<body>
		<article>
	    <h2>Join Us</h2>
	    <form id="join" action="MemberJoin.do" method="post" name="formm">
	      <fieldset>
	        <legend>Basic Info</legend>
	        <label>User ID</label>
	        	<input id="id" type="text" name="id" size="12"  >
	        	<input id="reid" type="hidden" name="reid">
	        	<input id="chkid" type="button" value="중복 체크" class="dup" onclick="idcheck()"><br>
	        <label>Password</label> 
	        	<input id="pwd" type="password" name="pwd"><br> 
	        <label>Retype Password</label> 
	       		<input id="pwdCheck" type="password" name="pwdCheck"><br> 
	        <label>Name</label>
	        	<input id="name" type="text" name="name"><br> 
	        <label>E-Mail</label>
	        	<input id="email" type="text" name="email"><br>
	      </fieldset>
	      <fieldset>
	        <legend>Optional</legend>
	        <label>Zip Code</label> 
	        	<input id="zipNum" type="text" name="zipNum" size="10" >      
	        	<input type="button" value="주소 찾기" class="dup" onclick="post_zip()"><br>
	        <label id="">Address</label> 
	        	<input id="addr1" type="text" name="addr1" size="40">
	        	<input id="addr2" type="text" name="addr2" size="20"> <br>
	        <label>Phone Number</label> 
	        	<input id="phone" type="text" name="phone"><br>
	      </fieldset>
	      <div class="clear"></div>
	      <div id="buttons">
	        <input id="add" type="button" value="회원가입" class="submit"> 
	        <input id="reset" type="reset" value="취소" class="cancel">
	      </div>
	    </form>
	  </article>
	</body>
</html>

<%@ include file="../footer.jsp" %>