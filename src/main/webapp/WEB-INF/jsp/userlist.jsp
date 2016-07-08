<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>用户列表</title>
<%@include file="common/head.jsp"%>
</head>
<body>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading text-center">
				<h2>用户列表</h2>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<td>用户ID</td>
							<td>用户名</td>
							<td>手机号</td>
							<td>积分</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="user" items="${userlist}">
							<tr>
								<td>${user.userId}</td>
								<td>${user.userName}</td>
								<td>${user.userPhone}</td>
								<td>${user.score}</td>
								<td><fmt:formatDate value="${user.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
	</div>
</body>
</html>