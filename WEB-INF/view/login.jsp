<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/VoteServlet?method=login" method="post">
		<table border="1px solid gold" align="center">
			<caption>登陆</caption>
			<tbody>
				<tr>
					<td><input type="text" name="username" size="20"></td>
				</tr>
				<tr>
					<td><input type="password" name="password" size="20"></td>
				</tr>
				<tr>
					<th><input type="submit" value="提交"></th>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>