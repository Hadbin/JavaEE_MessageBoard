<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<title>Insert title here</title>

</head>
<body style="background-color: #EBEDF0">
		<div style="background: #DFF0D8;"><font size="5">主题:${bean.theme }</font>
		<br /></div>
		
		<div class="bg-warning">
			<font size="5">作者:${bean.writer }</font>
		</div>
		<div style="background: #DFF0D8;">
			<font size="5">日期:${bean.date }</font>
		</div>
		<div class="bg-warning">
			<font size="5">内容:${bean.content }</font>
		</div>
		<div style="height: 270px; background-color: #FAFAD2">
			<font size="5">回复:<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${bean.reply }</font>
			
		</div>
</body>
</html>