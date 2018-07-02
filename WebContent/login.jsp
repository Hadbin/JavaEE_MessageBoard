<%@ page language="java" import="java.util.*,domain.User"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<title>登录</title>
<style>
a {
	text-decoration: none;
}
</style>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/checkForm.js"></script>
<script type="text/javascript">
	//页面加载时就执行
	$(function(){
		document.getElementById("new_Message").click();
	})
</script>
<!-- 自动登录 -->
<script type="text/javascript">
		$(function(){
			$("#username").val("${USER.username}");
			$("#password").val("${USER.password}");
			if($("#password").val()!="" || $("#username").val()!=""){
				$("#login").click(checkFormLogin());
			}
		})
</script>

</head>
<body style="background-color: #EBEDF0">
	<div align="right" id="login">
		<div align="right" class="form-inline">
			<div class="form-group">
				<input id="username" class="form-control" name="username" type="text" placeholder="用户名"> 
			</div>
			<div class="form-group">
				<input id="password" class="form-control" name="password" type="password" placeholder="密码"> 
			</div>
		<button id="login" class="btn btn-default" onclick="checkFormLogin()" >登录</button>
			<!-- <input type="checkbox" id="autologin" name="autologin"
			value="autologin">自动登录 -->
		<!-- 验证码登录？ -->
		<!-- 注册页面是从新窗口打开的 -->
		<button onclick="window.open('register.jsp')" class="btn btn-default">注册</button>
		&nbsp;
		</div>
	</div>
	<!-- 页面加载后，会点击此连接，显示留言板的首页内容-->
	<a
		href="${pageContext.request.contextPath}/GetAllMsg?currPage=1&page=look"
		style="display: none" target="contentframe" id="new_Message">getMessage</a>
	<!-- 登录时依据用户权限，展现不同的页面-->
	<a href="user_publish.jsp" style="display: none" id="user"
		target="userframe">user </a>
	<a href="user_update.jsp" style="display: none" id="admin"
		target="userframe">admin</a>
		
	<!-- 退出时，刷新页面 -->
	<a href="user.jsp" style="display: none" id="refresh"
		target="userframe">refresh </a>
	<a href="function.jsp" style="display: none" id="refresh_2"
		target=functionframe>refresh_2 </a>

</body>
</html>