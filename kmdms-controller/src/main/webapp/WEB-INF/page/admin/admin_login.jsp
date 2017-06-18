<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<meta name="keywords"
	content="Flat Dark Web Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />

<link href="${pageContext.request.contextPath }/css/admin/style.css" rel='stylesheet' type='text/css' />

<script type="text/javascript" src="${pageContext.request.contextPath }/js/common/jquery-1.9.1.js"></script>

</head>
<body <%--style="background-image: url('${pageContext.request.contextPath/img/admin/bg1.jpg}')"--%>>

	<h1>学生宿舍管理系统后台登录页面</h1>
	<div class="login-form">
		<div class="head-info">
			<label class="lbl-1"> </label> <label class="lbl-2"> </label> <label
				class="lbl-3"> </label>
		</div>
		<div class="clear"></div>
		<div class="avtar">
			<img src="${pageContext.request.contextPath }/img/admin/avtar.png" />
		</div>
		<form id="admin_forum" action="${pageContext.request.contextPath }/admin/login.action" method="post">
			<input name="adminName" id="admin_forum_account" type="text" value="${adminName}" class="text" value="账号" onFocus="this.value = '';"
				onBlur="if (this.value == '') {this.value = '账号';}">
			<div class="key">
				<input name="password" type="password"  value="${password}" onFocus="this.value = '';"
					onBlur="if (this.value == '') {this.value = 'Password';}">
			</div>
			${msg}
			<div class="signin">
			<input type="submit" value="Login">
			</div>
		</form>
	</div>

</body>
</html>