<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<title>Insert title here</title>
<style>
a {
	text-decoration: none;
}

body {
	style="background-color: #EBEDF0";
	background-size: auto;
}
</style>
<script>
	//删除留言
	function DelMsg() {
		if (!confirm("确认要删除？")) {
			window.event.returnValue = false;
		}
	}
</script>
</head>
<body style="background-color: #EBEDF0">

	<!-- 这里的隔行换色，可以用ready(function(){代码。。。})方法将内容包起来，用for循环自然数，根据单双数实现隔行换色 -->
	<%
		int i = 1;
	%>
	<c:forEach items="${msg.list }" var="p">
		<%
			if (i % 2 == 0) {
		%>
		<div class="bg-warning">
			<font color='#AEC' face='宋体' size='5'> <span>&nbsp;<a
					href="${pageContext.request.contextPath }/GetMsgById?id=${p.id}&page=look"
					target="functionframe">${p.theme}</a></span>
			</font> 
			 	<c:if test="${ p.edit==1}"><!-- 如果该留言未被修改过 -->
					<font face='黑体' size='4' style='float: right;'> <span>${p.date}</span>
						&nbsp; <a href="${pageContext.request.contextPath }/GetMsgById?id=${p.id}&page=update" target="functionframe">回复</a> <!-- 将id传到后台，修改某条留言 --> 
						&nbsp; <a href="${pageContext.request.contextPath }/DelMsgById?id=${p.id}" target="contentframe" onclick="DelMsg()">删除</a> <!-- 将id传到后台，删除某条留言 -->
					</font>
				</c:if> 
				<c:if test="${ p.edit==0}"><!-- 如果该留言已被修改过 -->
					<font face='黑体' size='4' style='float: right;'> <span>${p.date}</span>
						&nbsp; <a href="${pageContext.request.contextPath }/DelMsgById?id=${p.id}" target="contentframe" onclick="DelMsg()">删除</a> <!-- 将id传到后台，删除某条留言 -->
					</font>
				</c:if> 
			
		</div>
		<%
			} else {
		%>
		<div class="bg-success">
			<font color='#AEC' face='宋体' size='5'> <span>&nbsp;<a
					href="${pageContext.request.contextPath }/GetMsgById?id=${p.id}&page=look"
					target="functionframe">${p.theme}</a></span>
			</font> 
			 	<c:if test="${ p.edit==1}"><!-- 如果该留言未被修改过 -->
					<font face='黑体' size='4' style='float: right;'> <span>${p.date}</span>
						&nbsp; <a href="${pageContext.request.contextPath }/GetMsgById?id=${p.id}&page=update" target="functionframe">回复</a> <!-- 将id传到后台，修改某条留言 --> 
						&nbsp; <a href="${pageContext.request.contextPath }/DelMsgById?id=${p.id}" target="contentframe" onclick="DelMsg()">删除</a> <!-- 将id传到后台，删除某条留言 -->
					</font>
				</c:if> 
				<c:if test="${ p.edit==0}"><!-- 如果该留言已被修改过 -->
					<font face='黑体' size='4' style='float: right;'> <span>${p.date}</span>
						&nbsp; <a href="${pageContext.request.contextPath }/DelMsgById?id=${p.id}" target="contentframe" onclick="DelMsg()">删除</a> <!-- 将id传到后台，删除某条留言 -->
					</font>
				</c:if> 
		</div>
		<%
			}
				i++;
		%>
	</c:forEach>
<br />
	<center>
		<!-- 若是第一页 则首页和上一页不展示 -->
		<c:if test="${msg.currPage!=1 }">
			<a class="btn btn-default" href='${pageContext.request.contextPath}/GetAllMsg?currPage=1&page=edit'>首页</a>
			<a class="btn btn-default" href='${pageContext.request.contextPath}/GetAllMsg?currPage=${msg.currPage-1}&page=edit'>上一页</a>
		</c:if>
		<!-- 前5后4显示页面条数 -->
		<!-- 将所有页码展示出来 -->
		<c:forEach begin="${ msg.currPage-5>0?  msg.currPage-5:1 }"
			end="${ msg.currPage+4>msg.totalPage?  msg.totalPage: msg.currPage+4}"
			var="n">
			<!-- 若是当前页，该页不可点 -->
			<c:if test="${msg.currPage==n }">
				<button class="btn btn-default btn-lg" disabled="disabled">${n }</button>
			</c:if>
			<!-- 若不是当前页，该页可点 -->
			<c:if test="${msg.currPage!=n }">
				<a class="btn btn-default" href="${pageContext.request.contextPath}/GetAllMsg?currPage=${n }&page=edit">${n }</a>
			</c:if>
		</c:forEach>

		<!-- 若是最后一页 则 末页和下一页不展示 -->
		<c:if test="${msg.currPage!=msg.totalPage }">
			<a class="btn btn-default" href='${pageContext.request.contextPath}/GetAllMsg?currPage=${msg.currPage+1}&page=edit'>下一页</a>
			<a class="btn btn-default" href='${pageContext.request.contextPath}/GetAllMsg?currPage=${msg.totalPage}&page=edit'>末页</a>
			<br>
		</c:if>
		<br />
		<p class="text-primary">当前第${msg.currPage }页/共${msg.totalPage }页</p>

	</center>

</body>
</html>