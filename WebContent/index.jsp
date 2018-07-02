<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
<title>CcMessageBoard</title>
</head>
<!--4部分-->
	<frameset border="0px" rows="15%,5%,80%">
			<!--第1部分-->
			<frame  src="login.jsp" />	
			<!--第2部分-->
			<frame  id="second_id" src="user.jsp" name="userframe" />
			
			<!--第3部分-->
			<frameset cols="65%,35%">
				<frame src="content.jsp" name="contentframe"/>
				<frame src="function.jsp" name="functionframe"  />
			</frameset>
			<!-- 第4部分 <frame src="under.jsp"/> -->
		

	</frameset>
</html>