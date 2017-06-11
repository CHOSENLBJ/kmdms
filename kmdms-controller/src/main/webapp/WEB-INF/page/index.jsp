<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
					<a href="#" title="Your Messages" id="myMsg">
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
								<div class="g_12"><a style="float: right;font-size: 12px;" href="${pageContext.request.contextPath}/label/toChooseLabel.action">去修改/去选择</a></div>
							</div>
					</div>
				</div>
				<!--我的信息-->
				<div id="index_myInformation" class="g_10">
					<div class="widget_header">
						<h4 class="widget_header_title wwIcon i_16_valid">方便舍友了解你</h4>
					</div>
					<div class="widget_contents noPadding">
						<form action="${pageContext.request.contextPath}/student/editInfo.action" method="post">
							<div class="line_grid">
								<div class="g_2"><span class="label">我的QQ</span></div>
								<div class="g_9">
									<input type="text" class="simple_field" name="qq" value="${sessionScope.session_stu.qq}"  />
								</div>
							</div>
							<div class="line_grid">
								<div class="g_2"><span class="label">我的地址</span></div>
								<div class="g_9">
									<input type="text" class="simple_field" name="address" value="${sessionScope.session_stu.address}" />
								</div>
							</div>
							<div class="line_grid">
								<div class="g_2"><span class="label">个性化签名</span></div>
								<div class="g_9">
									<input type="text" class="simple_field" name="note" value="${sessionScope.session_stu.note}" />
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
						<h4 class="widget_header_title wwIcon i_16_valid" >我的通知</h4>
					</div>
					<div class="widget_contents noPadding">
							<div class="line_grid" id="putMessage">
								<%--<c:if test="${sessionScope.session_stu.messageList != null}">
									<c:forEach items="${sessionScope.session_stu.messageList}" var="message">
										<c:if test="${message.isRead == false}">
											<div class="g_12"><img src="${pageContext.request.contextPath }/img/Icons/22/i_22_inbox.png">&nbsp;<span class="label">${message.content}</span><span class="label fr"><fmt:formatDate value="${message.messageDate}" pattern="yyyy-MM-dd HH:mm:ss" /></span></div>
										</c:if>
										<c:if test="${message.isRead == true}">
											<div class="g_12"><img src="${pageContext.request.contextPath }/img/Icons/22/i_22_inbox_open.png">&nbsp;<span class="label">${message.content}</span><span class="label fr"><fmt:formatDate value="${message.messageDate}" pattern="yyyy-MM-dd HH:mm:ss" /></span></div>
										</c:if>
									</c:forEach>
								</c:if>--%>
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
								<div class="g_12"><span class="label">我的宿舍：
									<c:if test="${sessionScope.session_stu.dormitoryCustom != null && sessionScope.session_stu.dormitoryCustom.building != null}">
										${sessionScope.session_stu.dormitoryCustom.building.buildingName}${sessionScope.session_stu.dormitoryCustom.roomNum}
									</c:if>
								</span></div>
								<div class="g_12"><span class="label">我的舍友：</span></div>
								<c:if test="${sessionScope.session_stu.dormitoryCustom != null && sessionScope.session_stu.dormitoryCustom.studentList != null}">
									<c:forEach items="${sessionScope.session_stu.dormitoryCustom.studentList}" var="student" >
										<c:if test="${student.stuId != sessionScope.session_stu.stuId}">
											<div class="g_6">
												<img src="${pageContext.request.contextPath }/img/user_avatar.png" class="user_avatar fl" />
												<div class="fl index_myRoommate_information">
													<div><span>姓名：${student.stuName}</span></div>
													<div><span>地址：${student.address}</span></div>
													<div><span>QQ：${student.qq}</span></div>
												</div>
											</div>
										</c:if>
									</c:forEach>
								</c:if>
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

<
<script type="text/javascript">
	$("#myMsg").click(function(){
        $.post("${pageContext.request.contextPath}/message/getMessage.action", {}, function(backData, textStatus, ajax){
            $("#putMessage").empty();
            var response_text = ajax.responseText;
            if(response_text != "")
            {
                var messageJS = eval("(" + ajax.responseText + ")");
                for(var i = 0; i < messageJS.length; i++){
                    var message = messageJS[i];
                    var content = message.content;
                    var messageDate = new Date(message.messageDate).toLocaleString();
                    var style = message.isRead? "inbox_open" : "inbox";
					$("#putMessage").append('<div class="g_12"><img src="${pageContext.request.contextPath }/img/Icons/22/i_22_' + style + '.png">&nbsp;<span class="label">' + content + '</span><span class="label fr">' + messageDate + '</span></div>')
				}
            }
        });
	})

</script>

</html>