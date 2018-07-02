<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>注册</title>

<link rel="stylesheet" type="text/css" href="css/login.css" />


<style>
a {
	text-decoration: none;
}

body {
	background-color: gainsboro;
}
</style>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/checkForm.js"></script>
</head>
<body>
	<div id="login_frame">

		<p id="image_logo">
			<img src="/img/logo.jpg">
		</p>

		<form method="post" >

			<p>
				<label class="label_input">用户名</label><input type="text"
					id="username" name="username" class="text_field" />
			</p>
			<p>
				<label class="label_input">密码</label><input type="password"
					id="password1" name="password" class="text_field" />
			</p>
			<p>
				<label class="label_input">确认密码</label><input type="password"
					id="password2" class="text_field" />
			</p>
			<div id="login_control">
				<input type="button" id="btn_login" value="注册" onclick="checkFormRegister()" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" id="btn_login" value="取消" />
			</div>
		</form>
	</div>
</body>
</html>
