<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加候选人</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/Data?method=update2" method="post">
		<table border="1px solid gold" align="center">
			<caption>修改候选人信息</caption>
			<tr>
				<th>候选人名字<input type="text" name="content" value="${content.vote.content}"></th>
			</tr>
			<tr>
				<th>候选人初票数<input type="text" name="ticket" value="${content.vote.ticket}"></th>
			</tr>
			<tr>
				<th>年龄<input type="text" name="age" value="${content.age}"></th>
			</tr>
			<tr>
				<th>职业<input type="text" name="description" value="${content.description}"></th>
			</tr>
			<tr>
			<th><input type="hidden" name="id" value="${id}"></th>
			</tr>
			<tr>
				<th><input type="submit" value="提交"></th>
			</tr>
		</table>
	</form>
</body>
</html>