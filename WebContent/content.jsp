<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<title>查看留言内容</title>
<style>
a {
	text-decoration: none;
}

body {
	/* background-image: url(img/1.jpg); */
	background-size: auto;
}
</style>
</head>
<body style="background-color: #EBEDF0" >
<%--
	<div>
		 <a href="${pageContext.request.contextPath}/Content?currPage=1" target="contentframe" id="new_Message">最新留言</a> 
	</div>
--%>
	
	<%
		int i = 1;
	%>
	<c:forEach items="${msg.list }" var="p"><%--等价于 ${requestScope.msg.list}   --%>
		<!-- 这里的.list是msg实体中的list集合 -->
		<%
			if (i % 2 == 0) {//隔行换色
		%>
		<div class="bg-warning" >
		<%-- 	<c:if test="${USER.id!=p.userId}"><!-- 当前用户的id和发布留言作者的id不一致 --> --%>
				<font color='#AEC' face='宋体' size='5'> <!-- 根据id查看留言 --> 
					<span>&nbsp;<a href="${pageContext.request.contextPath }/GetMsgById?id=${p.id}&page=look"
						target="functionframe" >${p.theme}
						</a>
					</span>
				</font> 
				<font face='黑体' size='4'> <span style='float: right;'>${p.date }&nbsp;&nbsp;</span></font>
		<%-- 	</c:if> --%>

			
<%-- 	<c:if test="${USER.id!=p.userId}"><!-- 当前用户的id和发布留言作者的id一致 -->
		${p.userId }
	
	</c:if> --%>
			
			
		</div>
		<%
			} else {
		%>
		<div class="bg-success">
			<font color='#AEC' face='宋体' size='5'> <!-- 根据id查看留言 --> 
				<span>&nbsp;<a href="${pageContext.request.contextPath }/GetMsgById?id=${p.id}&page=look" target="functionframe">${p.theme} </a>
				</span>
			</font> 
			<font face='黑体' size='4'> 
				<span style='float: right;'>${p.date}&nbsp;&nbsp;</span>
			</font>
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
			<a class="btn btn-default" href='${pageContext.request.contextPath}/GetAllMsg?currPage=1&page=look'>首页</a>
			<a class="btn btn-default" href='${pageContext.request.contextPath}/GetAllMsg?currPage=${msg.currPage-1}&page=look'>上一页</a>
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
				<a class="btn btn-default" href="${pageContext.request.contextPath}/GetAllMsg?currPage=${n }&page=look">${n }</a>
			</c:if>
		</c:forEach>

		<!-- 若是最后一页 则 末页和下一页不展示 -->
		<c:if test="${msg.currPage!=msg.totalPage }">
			<a class="btn btn-default" href='${pageContext.request.contextPath}/GetAllMsg?currPage=${msg.currPage+1}&page=look'>下一页</a>
			<a class="btn btn-default" href='${pageContext.request.contextPath}/GetAllMsg?currPage=${msg.totalPage}&page=look'>末页</a>
			<br>
		</c:if>
		<br />
		<p class="text-primary">当前第${msg.currPage }页/共${msg.totalPage }页</p>
		

	</center>

</body>
</html>