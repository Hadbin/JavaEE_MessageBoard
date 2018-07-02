<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">

<script>
//修改留言
function EditMsg() {
	if (!confirm("确认要修改？")) {   
        window.event.returnValue = false;   
    } 
	
	var reply=document.getElementById("reply").value;
	//alert(reply);
	//alert(${bean.id})
	  $.ajax({
		type : "POST",
		url : "${pageContext.request.contextPath}/EditById?id=${bean.id}",
		data : {
			'reply' : reply
		},
		error : function() {
			alert("回复失败");
		},
		success : function(response) {
			alert(response.msg);
			//alert(result.msg);
			document.getElementById("new_Message").click();
			document.getElementById("look_Message").click();
			
		},
		dataType : "json"
	});
	return ;
	
	//刷新左边修改页面的内容
	//document.getElementById("new_Message").click();
}

</script>
</head>
<body style="background-color: #EBEDF0">

	<%-- <form class="form-inline" action="${pageContext.request.contextPath }/EditById?id=${bean.id}" target="functionframe" method="post"> --%>
			主题:<p>${bean.theme }</p>
			作者:<p>${bean.writer }</p>
			日期:<p>${bean.date }</p>
			内容:<p>${bean.content }</p>
			回复:<br />
			<textarea id="reply" cols="45" rows="5" name="reply">${bean.reply }</textarea>
		<br />
		<div align="center">
			<button class="btn btn-default" onclick="EditMsg()">回复</button>
				&nbsp;&nbsp;
			<button class="btn btn-default" type="reset" >取消</button>
		</div>
	<!-- </form> -->
		<!-- 发布成功后，左边显示最新留言，右边显示查看留言 -->
		<a href="${pageContext.request.contextPath}/GetAllMsg?currPage=1&page=edit"
		style="display: none" target="contentframe" id="new_Message">getMessage</a>
		
		<a href="${pageContext.request.contextPath }/GetMsgById?id=${bean.id}&page=look"
		style="display: none" target="functionframe" id="look_Message">lookMessage</a>
		
		<!-- response.sendRedirect(request.getContextPath()+"/GetMsgById?id="+msg.getId()+"&page=look"); -->
</body>
</html>