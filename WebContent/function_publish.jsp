<%@ page language="java" 
	import="domain.User"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script>
		window.onload=function showtime(){
			var now=new Date();
			var year=now.getFullYear();
			var month=now.getMonth()+1;
				if(month<10){
					month="0"+month;
				}
			var day=now.getDate();
			if(day<10){
				day="0"+day;
			}
			
			var h=now.getHours(); 
			if(h<10){
				h="0"+h;
			}
			var m=now.getMinutes(); 
			if(m<10){
				m="0"+m;
			}
			var s=now.getSeconds(); 
			if(s<10){
				s="0"+s;
			}
			time=year+'-'+month+'-'+day+" "+h+":"+m+":"+s;
			var div1=document.getElementById('date');
			div1.innerHTML=time;
		}	
		function publish(){//如果内容或主题为空，提示请输入内容和主题
			var theme=document.getElementById("theme").value;
			var content=document.getElementById("content").value;
			if(theme==null || theme==""||content==null || content==""){
				alert("请输入完整的内容和主题");
				return false;
			}
			var now=new Date();
			var year=now.getFullYear();
			var month=now.getMonth()+1;
				if(month<10){
					month="0"+month;
				}
			var day=now.getDate();
			if(day<10){
				day="0"+day;
			}
			
			var h=now.getHours(); 
			if(h<10){
				h="0"+h;
			}
			var m=now.getMinutes(); 
			if(m<10){
				m="0"+m;
			}
			var s=now.getSeconds(); 
			if(s<10){
				s="0"+s;
			}
			date=year+'-'+month+'-'+day+" "+h+":"+m+":"+s;
			
			var themeobj=document.getElementById("theme");	
			<%User user=(User)session.getAttribute("USER");%>	
			var writerobj=<%=user.getUsername() %>
			var contentobj=document.getElementById("content");
			
			var theme=themeobj.value;
			var writer=writerobj.value;
			var content=contentobj.value;			
			$.ajax({
				type : "POST",
				url : "${pageContext.request.contextPath}/Publish",
				data : {
					'theme' : theme,
					'writer' : writer,
					'date' : date,
					'content' : content
				},
				error : function(result) {
					alert("发布失败");
				},
				success : function(result) {
					alert(result.msg);
					document.getElementById("new_Message").click();
				},
				dataType : "json"
			});			
			return true;
		}
</script>
</head>
<body style="background-color: #EBEDF0">
	<div>
		主题:<input id="theme" name="theme"/>
	</div>
	<div>
		作者:${USER.getUsername()}
	</div>
	<div>
		日期:<span id="date" name="date"></span>
	</div>
	<div>
		内容:<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<textarea id="content" cols="40" rows="4" name="content"></textarea>
	</div>
	<br>
	<div>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="btn btn-default" type="submit" value="发布" onclick="publish()">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="btn btn-default" type="reset" />
	</div>

	<!-- 发布成功后，显示最新留言 -->
		<a href="${pageContext.request.contextPath}/GetAllMsg?currPage=1&page=look"
		style="display: none" target="contentframe" id="new_Message">getMessage</a>
</body>
</html>