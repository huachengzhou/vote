<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员操作</title>
<style type="text/css">
a{
text-decoration:none;
}
</style>
</head>
<body>
	<table align="center" border="1px solid red" width="65%">
		<caption>查询候选人信息</caption>
		<tbody>
			<tr>
				<th>候选人名字</th>
				<td>候选人票数</td>
			</tr>
			<c:forEach var="vote" items="${voteList}">
         <tr>
         <th>${vote.content}</th>
         
         <td>${vote.ticket}</td>
         </tr>
			</c:forEach>
		</tbody>
	</table>
	<jsp:include page="/WEB-INF/view/back2.jsp"></jsp:include>
</body>
</html>