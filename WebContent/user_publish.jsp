<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body style="background-color: #EBEDF0" >
&nbsp;&nbsp;
<a href="${pageContext.request.contextPath}/GetAllMsg?currPage=1&page=look" target="contentframe" class="btn btn-default">查看留言</a>&nbsp;&nbsp;
 	<c:if test="${userShell==2}">
		<a href="function_publish.jsp" target="functionframe" class="btn btn-default">添加留言</a>&nbsp;&nbsp;
	
	</c:if> 
</body>
</html>