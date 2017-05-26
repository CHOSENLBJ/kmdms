<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">
<head>
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
	<title>首页</title>
	<!-- The Main CSS File -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/index/style.css" />
	<!-- jQuery -->
	<script src="${pageContext.request.contextPath }/js/common/jquery-1.9.1.js"></script>
	<script src="${pageContext.request.contextPath }/js/index/tab.js"></script>
	<style>
		#index_myMsg img{
			vertical-align: middle;
		}
		#index_myRoommate img{
			height: 40px;
		}
		.index_myRoommate_information{
			font-size: 12pxstu;
		}
		.index_myRoommate_information div{
			margin-left: 15px;
			padding: 5px;
		}
	</style>
<body>
	<!-- Top Panel -->
	<div class="top_panel">
		<div class="wrapper">
			<div class="user" style="cursor: auto;">
				<img src="${pageContext.request.contextPath }/img/user_avatar.png" alt="user_avatar" class="user_avatar" />
				<span class="label">${sessionScope.session_stu.stuId}${sessionScope.session_stu.stuName}&nbsp;<a href="${pageContext.request.contextPath}/student/quit.action">[退出]</a></span>
			</div>
		</div>
	</div>

	<header class="main_header">
		<div class="wrapper">
			<div class="logo">
				<a href="#" title="Kanrisha Home">
					<img src="${pageContext.request.contextPath}/img/kanrisha_logo.png" alt="kanrisha_logo" />
				</a>
			</div>
		</div>
	</header>

	<div class="wrapper contents_wrapper">
		
		<aside class="sidebar">
			<ul class="tab_nav" id="index_tab">
				<li class="active_tab i_22_forms">
					<a href="#" title="Kit elements">
						<span class="tab_label">我的标签</span>
						<span class="tab_info">分配宿舍的依据</span>
					</a>
				</li>
				<li class="i_32_dashboard">
					<a href="#" title="General Info">
						<span class="tab_label">我的信息</span>
						<span class="tab_info">设置信息</span>
					</a>
				</li>
				<li class="i_32_inbox">
					<a href="#" title="Your Messages">
						<span class="tab_label">我的通知</span>
						<span class="tab_info">宿舍最新动态</span>
					</a>
				</li>
				<li class="	i_32_ui">
					<a href="#" title="Visual Data">
						<span class="tab_label">我的舍友</span>
						<span class="tab_info">了解一下舍友</span>
					</a>
				</li>
			</ul>
		</aside>

		<div class="contents">
			<div id="index_content" class="grid_wrapper">
				<!--我的标签-->
				<div id="index_myLabel" class="g_10">
					<div class="widget_header">
						<h4 class="widget_header_title wwIcon i_16_valid">我所选择的标签</h4>
					</div>
					<div class="widget_contents noPadding">
							<div class="line_grid">
								<c:if test="${sessionScope.session_stu.labelList != null}">
									<c:forEach items="${sessionScope.session_stu.labelList}" var="label" varStatus="status">
										<div class="g_12"><span class="label">${status.index + 1}.${label.content}</span></div>
									</c:forEach>
								</c:if>
								<%--<div class="g_12"><span class="label">1.小星星</span></div>
								<div class="g_12"><span class="label">2.小星星</span></div>
								<div class="g_12"><span class="label">3.小星星</span></div>--%>
								<div class="g_12"><a style="float: right;font-size: 12px;" href="#">去修改/去选择</a></div>
							</div>
					</div>
				</div>
				<!--我的信息-->
				<div id="index_myInformation" class="g_10">
					<div class="widget_header">
						<h4 class="widget_header_title wwIcon i_16_valid">方便舍友了解你</h4>
					</div>
					<div class="widget_contents noPadding">
						<form>
							<div class="line_grid">
								<div class="g_2"><span class="label">我的QQ</span></div>
								<div class="g_9">
									<input type="text" class="simple_field"  />
								</div>
							</div>
							<div class="line_grid">
								<div class="g_2"><span class="label">我的地址</span></div>
								<div class="g_9">
									<input type="text" class="simple_field"  />
								</div>
							</div>
							<div class="line_grid">
								<div class="g_2"><span class="label">个性化签名</span></div>
								<div class="g_9">
									<input type="text" class="simple_field"  />
								</div>
							</div>
							<div class="line_grid">
								<div class="g_2"><span class="label">保　存</span></div>
								<div class="g_9">
									<input type="submit" class="simple_buttons" value="提交" />
								</div>
							</div>
						</form>
					</div>
				</div>
				<!--我的通知-->
				<div id="index_myMsg" class="g_12">
					<div class="widget_header">
						<h4 class="widget_header_title wwIcon i_16_valid">我的通知</h4>
					</div>
					<div class="widget_contents noPadding">
							<div class="line_grid">
								<div class="g_12"><img src="${pageContext.request.contextPath }/img/Icons/22/i_22_inbox.png">&nbsp;<span class="label">你已经被分配到东区110宿舍</span><span class="label fr">2012-12-12 00:00</span></div>
								<div class="g_12"><img src="${pageContext.request.contextPath }/img/Icons/22/i_22_inbox.png">&nbsp;<span class="label">你已经被分配到东区110宿舍</span><span class="label fr">2012-12-12 00:00</span></div>
							</div>
					</div>
				</div>
				<!--我的舍友-->
				<div id="index_myRoommate" class="g_12">
					<div class="widget_header">
						<h4 class="widget_header_title wwIcon i_16_valid">我的舍友</h4>
					</div>
					<div class="widget_contents noPadding">
							<div class="line_grid">
								<div class="g_12"><span class="label">我的宿舍：中六107</span></div>
								<div class="g_12"><span class="label">我的舍友：</span></div>
								<div class="g_6">
									<img src="${pageContext.request.contextPath }/img/user_avatar.png" class="user_avatar fl" />
									<div class="fl index_myRoommate_information">
										<div><span>姓名：东方不败</span></div>
										<div><span>地址：黑木崖</span></div>
										<div><span>QQ：11111111</span></div>
									</div>
								</div>
								<div class="g_6">
									<img src="${pageContext.request.contextPath }/img/user_avatar.png" class="user_avatar fl" />
									<div class="fl index_myRoommate_information">
										<div><span>姓名：风清扬</span></div>
										<div><span>地址：思过崖</span></div>
										<div><span>QQ：22222222</span></div>
									</div>
								</div>
								<div class="g_6">
									<img src="${pageContext.request.contextPath }/img/user_avatar.png" class="user_avatar fl" />
									<div class="fl index_myRoommate_information">
										<div><span>姓名：任我行</span></div>
										<div><span>地址：梅庄</span></div>
										<div><span>QQ：333333</span></div>
									</div>
								</div>
							</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<footer>
		<div class="wrapper">
			<span class="copyright">
				&copy; Copyright &copy; 2013.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>
			</span>
		</div>
	</footer>
</body>
</html>