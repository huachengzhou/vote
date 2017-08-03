<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据处理中心</title>
<style type="text/css">
a {
	text-decoration: none;
}
</style>
</head>
<body>
	<table align="center" width="75%">
		<caption>管理员操作</caption>

		<tbody>
			<tr>
				<th><a href="${pageContext.request.contextPath}/Data?method=delete1"><font color="red">删除候选人</font> </a></th>
			</tr>
			<tr>
				<th><a href="${pageContext.request.contextPath}/Data?method=add1"><font color="blue">增加候选人</font> </a></th>
			</tr>
			<tr>
				<th><a href="${pageContext.request.contextPath}/Data?method=select1"><font color="green">查询候选人</font> </a></th>
			</tr>
			<tr>
				<th><a href="${pageContext.request.contextPath}/Data?method=update1"><font color="gold">修改候选人</font> </a></th>
			</tr>
		</tbody>
	</table>
	<jsp:include page="/WEB-INF/view/back.jsp"></jsp:include>
</body>
</html>