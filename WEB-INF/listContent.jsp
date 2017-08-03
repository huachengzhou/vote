<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>候选人情况</title>
<style type="text/css">
body table {
	text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/view/back.jsp"></jsp:include>
	<center>
		<h2>欢迎${!empty sessionScope.user?user.username:'游客光临'}</h2>
	</center>
	<table align="center" border="1px solid red" width="60%">
		<caption>候选人详细信息</caption>

		<tbody>
			<tr>
				<th>头像</th>
				<td><img alt="图片崩溃" src="${content.image.path}" width="50px" height="50px"></td>
			</tr>
			<tr>
				<td>人名</td>
				<th>${content.vote.content}</th>
			</tr>
			<tr>
				<th>年龄</th>
				<td>${content.age}</td>
			</tr>
			<tr>
				<th>描述</th>
				<td>${content.description}</td>
			</tr>
		</tbody>
	</table>
</body>
</html>