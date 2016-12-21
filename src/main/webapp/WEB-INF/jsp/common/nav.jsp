<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">菜鸟教程</a>
		</div>
		<div>
			<!--向左对齐-->
			<ul class="nav navbar-nav navbar-left">
				<li><a href="#">商品</a></li>
				<li><a href="#">用户</a></li>
			</ul>
			<form class="navbar-form navbar-left" role="search">
				<button type="submit" class="btn btn-default">向左对齐-提交按钮</button>
			</form>
			<p class="navbar-text navbar-left">向左对齐-文本</p>
			<!--向右对齐-->
			<ul class="nav navbar-nav navbar-right">

				<c:if test="${user==null}">
					<li><a data-toggle="modal" data-target="#loginModal"> 登录 </a></li>
					<li><a data-toggle="modal" data-target="#loginModal"> 注册 </a></li>
				</c:if>

				<!-- 登陆情况 -->
				<c:if test="${user!=null}">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> ${user.userName} <b class="caret"></b>
					</a>
						<ul class="dropdown-menu">
							<li><a href="#">jmeter</a></li>
							<li><a href="#">EJB</a></li>
							<li><a href="#">Jasper Report</a></li>
							<li class="divider"></li>
							<li><a href="#">分离的链接</a></li>
							<li class="divider"></li>
							<li><a
								onclick="handler.logoutBtn();">推出</a></li>
						</ul></li>
				</c:if>
			</ul>
		</div>
	</div>
</nav>

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
						<input type="text" name="userPhone" id="userPhone"
							placeholder="填写手机号" class="form-control">
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<%--验证信息--%>
				<button type="button" id="loginBtn" class="btn btn-success"
					onclick="handler.loginBtn();">
					<span class="glyphicon glyphicon-phone"> </span>提交
				</button>
			</div>

		</div>
	</div>
</div>