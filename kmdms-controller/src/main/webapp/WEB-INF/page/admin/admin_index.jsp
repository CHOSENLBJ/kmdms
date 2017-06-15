<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>学生宿舍后台管理</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/admin/pintuer.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/admin/admin.css">
<script src="${pageContext.request.contextPath }/js/common/jquery-1.9.1.js"></script>
</head>

<body style="background-color:#f2f9fd;">
	<div class="header bg-main" >
		<div class="logo margin-big-left fadein-top">
			<h1>
				<img src="${pageContext.request.contextPath }/img/admin/avtar.png" class="radius-circle rotate-hover"
					height="50" alt="" /><font color="black">学生宿舍后台管理</font>
			</h1>
		</div>
		<div class="head-l">
			<a class="button button-little bg-green" href="" target="_blank"><span
				class="icon-home"></span> 前台首页</a> &nbsp;&nbsp; <a href="##"
				class="button button-little bg-blue"><span class="icon-wrench"></span>
				清除缓存</a> &nbsp;&nbsp; <a class="button button-little bg-red"
				href="login.html"><span class="icon-power-off"></span> 退出登录</a>
		</div>
	</div>
	<div class="leftnav">
		<div class="leftnav-title">
			<strong style="color:black"><span class="icon-list"></span>菜单列表</strong>
		</div>
		<h2>
			<span class="icon-bullhorn"></span>公告管理
		</h2>
		<ul>
			<li><a href="admin_send_msg.html" target="right"><span
					class="icon-caret-right"></span>发送通知</a></li>
		</ul>
		<h2>
			<span class="icon-user"></span>标签管理
		</h2>
		<ul>
			<li><a href="admin_label_edit.html" target="right"><span
					class="icon-caret-right"></span>创建标签</a></li>
			<li><a href="admin_label_list.html" target="right"><span
					class="icon-caret-right"></span>标签列表</a></li>
		</ul>
		<h2>
			<span class="icon-flag"></span>宿舍管理
		</h2>
		<ul>
			<li><a href="admin_building_list.html" target="right"><span
					class="icon-caret-right"></span>宿舍列表</a></li>
			<li><a href="admin_building_edit.html" target="right"><span
					class="icon-caret-right"></span>创建宿舍</a></li>
		</ul>
	</div>
	<ul class="bread">
		<li><a href="{:U('Index/info')}" target="right" class="icon-home">
				首页</a></li>
		<li><a href="##" id="a_leader_txt">网站信息</a></li>
		<li><b>当前管理者：</b><span style="color:black">中文</span></li>
	</ul>
	<div class="admin">
		<!-- 后台页面默认主页 -->
		<iframe scrolling="auto" rameborder="0" src="" name="right"
			width="100%" height="100%"></iframe>
	</div>
	<script type="text/javascript">
		$(function() {
			$(".leftnav h2").click(function() {
				$(this).next().slideToggle(200);
				$(this).toggleClass("on");
			})
			$(".leftnav ul li a").click(function() {
				$("#a_leader_txt").text($(this).text());
				$(".leftnav ul li a").removeClass("on");
				$(this).addClass("on");
			})
		});
	</script>
</body>

</html>