<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
查看留言 <br />
		<div>
			主题:${bean.theme }
		</div>
		<div>
			作者:${bean.writer }
		</div>
		<div>
			日期:${bean.date }
		</div>
		<div>
			内容:<br />${bean.content }
		</div>
		<div>
			回复:<br />${bean.reply }
			<!-- <textarea cols="30" rows="10"></textarea> -->
		</div>
</body>
</html>