<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>商品列表</title>
<%@include file="common/head.jsp"%>
</head>
<body>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading text-center">
				<h2>商品列表</h2>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<td>商品ID</td>
							<td>商品名称</td>
							<td>商品价格</td>
							<td>商品状态</td>
							<td>商品数量</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="goods" items="${goodslist}">
							<tr>
								<td>${goods.goodsId}</td>
								<td>${goods.title}</td>
								<td>${goods.price}</td>
								<td><c:if test="${goods.state==0}">已下架</c:if> <c:if test="${goods.state==1}">销售中</c:if></td>
								<td>${goods.number}</td>
								<td><button class="btn btn-info" id="goodsBuy" onclick="handler.goodsBuy(${goods.goodsId});">购买</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
	</div>


	<%--登录弹出层 输入电话--%>
	<div id="loginModal" class="modal fade">

		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h3 class="modal-title text-center">
						<span class="glyphicon glyphicon-phone"> </span>用户电话
					</h3>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-xs-8 col-xs-offset-2">
							<input type="text" name="userPhone" id="userPhone" placeholder="填写手机号" class="form-control">
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<%--验证信息--%>
					<span id="userPhoneMessage" class="glyphicon"> </span>
					<button type="button" id="loginBtn" class="btn btn-success">
						<span class="glyphicon glyphicon-phone"></span>提交
					</button>
				</div>

			</div>
		</div>

	</div>

</body>
<script src="http://apps.bdimg.com/libs/jquery.cookie/1.4.1/jquery.cookie.js"></script>
<script src="<%=path%>/resource/script/handler.js" type="text/javascript"></script>
<script type="text/javascript">
$(function () {
	//初始化业务逻辑script
    handler.goods.init({});
})
</script>
</html>