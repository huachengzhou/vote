<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%--国际化 上面 --%>
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
		<caption>投票人基本信息</caption>

		<tbody>
			<tr>
				<td>IP</td>
				<th>最后投票时间</th>
				<th>归属地</th>
			</tr>
			<c:forEach var="info" items="${infoList}">
				<tr>
					<td>${info.ip}</td>
					<td>
					<fmt:formatDate value="${info.votetime}" type="both" dateStyle="full" timeStyle="default"/>
					 </td>
					 <th>${!empty info.address.location?info.address.location:'成都'}</th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>