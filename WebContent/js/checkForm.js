function checkFormLogin() {
	// 获取用户名及其内容
	var usernameObj = document.getElementById("username");
	var username = usernameObj.value;
	// 判断value是否为空 若为空不能提交表单,
	if (username == null || username == "") {
		alert("用户名不能为空");
		return false;
	}
	// 获取密码及其内容
	// 1.获取密码元素
	var pwdObj = document.getElementById("password");

	// 2.获取密码的值
	var password = pwdObj.value;

	// 3.判断
	if (password == null || password == "") {
		alert("密码不能为空");
		return false;
	}

	//var autologin = document.getElementById("autologin").checked //自动登录
	//alert(autologin);
	$.ajax({
		type : "POST",
		url : "http://localhost:8080/MessageBoard/Login",
		data : {
			'username' : username,
			'password' : password
			//'autologin':autologin
		},
		error : function(response) {
			alert("登录失败");
			window.location.reload();

		},
		success : function(response) {
			//alert("登录成功");
			
			toModify(response);
		},
		dataType : "json"
	});

	return true;
}
function toModify(response) {
	var shell;
	var login = document.getElementById("login");
	login.innerHTML = "<font size="+4+">欢迎登录^_^" +'&nbsp&nbsp&nbsp;'+'<input id="logout" class="btn btn-default" name="logout" value="注销" type="button" onclick="logout()"/>'+
	'<br />'+response.logMsg+'</font>';
/*	+'<br /> <a href="${pageContext.request.contextPath}/GetAllMsg?currPage=1&page=look" target="contentframe" style="background-color: black; color: white; font-size: 18px; width: 100px; height: 30px">查看留言</a>&nbsp;&nbsp;'+
	'<c:if test="${USER.shell==2}">'+
		'<a href="function_publish.jsp" target="functionframe" style="background-color: black; color: white; font-size: 18px; width: 100px; height: 30px">添加留言</a>&nbsp;&nbsp;'+
	'</c:if> '+
	'<c:if test="${USER.shell==1}">'+
	'<a href="function_publish.jsp" target="functionframe" style="background-color: black; color: white; font-size: 18px; width: 100px; height: 30px">添加留言</a>&nbsp;&nbsp;'+
	'<a href="${pageContext.request.contextPath}/GetAllMsg?currPage=1&page=edit" target="contentframe" style="background-color: black; color: white; font-size: 18px; width: 100px; height: 30px">修改留言</a>&nbsp;&nbsp;'+
	'</c:if> ';*/
	
	
	//alert(response.shell);
	if (response.shell == 1)// 管理员权限为1
	{
		document.getElementById("admin").click();
	} else if (response.shell == 2)// 普通用户权限为2
	{
		document.getElementById("user").click();
	}
	
	

}
//退出登录
function logout(){
	$.ajax({
		type : "GET",
		url : "http://localhost:8080/MessageBoard/Logout",
		error : function() {
			alert("退出失败");
		},
		success : function() {
			alert("退出成功");
			document.getElementById("refresh").click();
			document.getElementById("refresh_2").click();
			window.location.reload();
		},
	});
}

//注册
function checkFormRegister() {

	// 获取用户名及其内容
	var usernameObj = document.getElementById("username");
	var username = usernameObj.value;
	// 判断value是否为空 若为空不能提交表单,
	if (username == null || username == "") {
		alert("用户名不能为空");
		return false;
	}

	// 获取密码及其内容
	// 1.获取密码元素
	var pwdObj1 = document.getElementById("password1");

	// 2.获取密码的值
	var pwdValue1 = pwdObj1.value;

	// 3.判断
	if (pwdValue1 == null || pwdValue1 == "") {
		alert("密码不能为空");
		return false;
	}
	// 获取确认密码及其内容
	var pwdObj2 = document.getElementById("password2");

	// 4.获取确认密码的值
	var pwdValue2 = pwdObj2.value;

	// 3.判断
	if (pwdValue2 == null || pwdValue2 == "") {
		alert("确认密码不能为空");
		return false;
	}
	if (pwdValue1 != pwdValue2) {
		alert("密码和确认密码不一致");
		return false;
	}

	$.ajax({
		type : "POST",
		url : "http://localhost:8080/MessageBoard/Register",
		data : {
			'username' : username,
			'password' : pwdValue1
		},
		error : function(response) {
			alert(response.result);
			window.location.reload();
		},
		success : function(response) {
			alert(response.result);
			if(response.result=="注册成功")
				window.location.href='http://localhost:8080/MessageBoard/index.jsp';
		},
		dataType : "json"
	});
	return true;
}
