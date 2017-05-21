<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>学生宿舍管理系统登录页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<link href="${pageContext.request.contextPath }/css/bootstrap/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/index/index.css" />
	<script src="${pageContext.request.contextPath }/js/common/jquery-1.9.1.js"></script>
  </head>
  
  <body>
		<!--登录-->
		<div id="myLogin">
			<div class="row">
				<div class="col-md-4"></div>
				<div id="kmdms-login" class="col-md-4">
					<form method="post" action="">
						<div>
							<h4 id="kmdms-login-title">登录</h4>
						</div>
						<div>
							<input id="kmdms-login-name" type="text" placeholder="请输入学号" />
							<p id="kmdms-login-name-error">&nbsp;</p>
						</div>
						<div>
							<input id="kmdms-login-pwd" type="password" placeholder="请输入密码" />
							<p id="kmdms-login-pwd-error">&nbsp;</p>
						</div>
						<div>
							<input id="kmdms-login-vc" type="text" placeholder="请输入验证码" />
							<p id="kmdms-login-vc-error">&nbsp;</p>
						</div>
						<div>
							<button type="submit" class="btn">登录</button>
						</div>
						<div id="kmdms-login-findPwd">
							<a href="#">找回密码</a><strong>
						</div>
					</form>
				</div>
			</div>
			<div class="col-md-4"></div>
		</div>
		<script src="${pageContext.request.contextPath }/js/common/bootstrap.min.js"></script>
	</body>
</html>
