<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加候选人</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/Data?method=add" method="post">
		<table border="1px solid gold" align="center">
			<caption>添加候选人信息</caption>
			<tr>
				<th>候选人名字<input type="text" name="content"></th>
			</tr>
			<tr>
				<th>候选人初票数<input type="text" name="ticket"></th>
			</tr>
			<tr>
				<th>年龄<input type="text" name="age"></th>
			</tr>
			<tr>
				<th>职业<input type="text" name="description"></th>
			</tr>
			<tr>
				<th>头像路径<input type="text" name="path"></th>
			</tr>
			<tr>
				<th><input type="submit" value="提交"></th>
			</tr>
		</table>
	</form>
	<jsp:include page="/WEB-INF/view/back2.jsp"></jsp:include>
</body>
</html>