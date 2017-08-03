<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>候选人情况</title>
<style type="text/css">
body {
	margin: 0 auto;
}

body table {
	text-align: center;
}

.dd {
	position: absolute;
	left: 1200px;
	top: 100px;
}
</style>
</head>
<body>
	<c:choose>
		<c:when test="${!empty sessionScope.user}">
			<a href="${pageContext.request.contextPath}/VoteServlet?method=exit">安全退出</a>
		</c:when>
		<c:otherwise>
.
</c:otherwise>
	</c:choose>
	<center>
		<h2>欢迎${!empty sessionScope.user?user.username:'游客光临'}</h2>
	</center>
	<div width="1000px">
		<table align="center" border="1px solid red" width="65%">
			<caption>候选人基本信息</caption>
			<tbody>
				<tr>
					<td>用户</td>
					<td>票数</td>
					<td>操作</td>
				</tr>
				<c:forEach var="vote" items="${voteList}">
					<tr>

						<td><a
							href="${pageContext.request.contextPath}/VoteServlet?id=${vote.id}&method=findContentById"
							style="text-decoration: none"> ${vote.content} </a></td>

						<td><img alt="图片崩溃" src="./images/bar.jpg" height="20px"
							width="${vote.ticket*2}px"></td>

						<td><c:choose>
								<c:when test="${!empty sessionScope.user}">
									<a
										href="${pageContext.request.contextPath}/VoteServlet?method=updateById&id=${vote.id}"
										style="text-decoration: none">投票</a>
								</c:when>
								<c:otherwise>
					需要登录
					</c:otherwise>
							</c:choose></td>

					</tr>
				</c:forEach>
				<tr>
					<th colspan="3"><c:choose>
							<c:when test="${!empty sessionScope.user}">
							</c:when>
							<c:otherwise>
								<a
									href="${pageContext.request.contextPath}/VoteServlet?method=logn"
									style="text-decoration: none">登陆</a>
							</c:otherwise>
						</c:choose></th>
				</tr>
				<tr>
					<th colspan="3"><a
						href="${pageContext.request.contextPath}/VoteServlet?method=findAllInfo"
						style="text-decoration: none"> 查询所有人投票信息</a></th>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="dd">
		<table width="80%" border="1px solid blue" align="center">
			<caption>热门候选人</caption>
			<tbody>
				<c:forEach begin="1" end="3" var="vote" items="${voteList2}"
					varStatus="status">
					<tr>
						<!-- 如果是第一个则显示内容,注意varStatus表示容器的状态 -->
						<th><c:if test="${status.first==true}">
								<img alt="崩溃" src="./images/agree.gif">
							</c:if> ${vote.content}
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div>
		<table width="1000px">
			<tbody>
				<tr>
					<p style="float: left; display: block;">
						测试用户名:<font color="blue" size="3">周文</font> 密码:<font color="blue"
							size="3">123456</font> </br>
					</p>
				</tr>
				<tr>
				<th><a href="${pageContext.request.contextPath}/VoteServlet?method=backLoginUP" style="text-decoration: none;"><font color="red">管理员入口</font></a></th>
				</tr>
				<tr>
					<p style="float: right; display: block;">XXX投票系统</p>
				</tr>
				<div style="float: none;"></div>
			</tbody>
		</table>
	</div>
</body>
</html>