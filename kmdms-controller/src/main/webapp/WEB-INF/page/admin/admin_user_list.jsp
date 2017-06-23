<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<title></title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/admin/pintuer.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/admin/admin.css">
	<script src="${pageContext.request.contextPath }/js/common/jquery-1.9.1.js"></script>
	<script src="${pageContext.request.contextPath }/js/admin/pintuer.js"></script>
</head>

<body>
	<form id="user_edit_form" method="post" action="" id="listform">
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder"> 内容列表</strong> <a href=""
					style="float:right; display:none;">添加字段</a>
			</div>
			<div class="padding border-bottom">
				<ul class="search" style="padding-left:10px;">
					<li>
						<select name="searchType" class="selected" style="line-height:20px;padding:9px;">
							<option ${searchType == "petname" ? "selected=selected" : "" } value="petname">按昵称搜索</option>
							<option ${searchType == "telephone" ? "selected=selected" : "" } value="telephone">按手机号搜索</option>
							<option ${searchType == "email" ? "selected=selected" : "" } value="email">按邮箱搜索</option>
							<option ${searchType == "address" ? "selected=selected" : "" } value="address">按地址搜索</option>
						</select>
						<input type="text" placeholder="请输入搜索关键字" name="keywords"
						class="input" value="${keywords }"
						style="width:250px; line-height:17px;display:inline-block" />
						<input class="button border-main icon-search"
						onclick="changesearch()" type="submit"  value="搜索" />
					</li>
				</ul>
			</div>
			<table class="table table-hover text-center">
				<tr>
					<th>昵称</th>
					<th>手机</th>
					<th>邮箱</th>
					<th>生日</th>
					<th>地址</th>
					<th>性别</th>
					<th>真实姓名</th>
					<th>身份证号</th>
					<th>状态</th>
					<th width="170">操作</th>
				</tr>
				<c:forEach items="${userPageBean.beanList }" var="user">
				<tr>
					<td>${user.petname }</td>
					<td>${user.telephone == null || user.telephone  eq "" ?  "未绑定" : user.telephone }</td>
					<td>${user.email == null || user.email  eq "" ?  "未绑定" : user.email }</td>
					<td><fmt:formatDate value="${user.birthday }" type="date"/></td>
					<td>${user.address }</td>
					<c:if test="${user.sex == sex_private }">
						<td>保密</td>
					</c:if>
					<c:if test="${user.sex != sex_private }">
						<td>${user.sex == sex_man ? "男" : "女" }</td>
					</c:if>
					<td>${user.realname }</td>
					<td>${user.idnumber }</td>
					<td>
						<c:if test="${user.status == status_admin }">管理员</c:if>
						<c:if test="${user.status == status_normal }">正常</c:if>
						<c:if test="${user.status == status_freeze }">冻结</c:if>
					</td>
					<td>
						<div class="button-group">
							<a class="button border-main" href="${pageContext.request.contextPath }/user/admin_user_editUI.action?userid=${user.userid }"><span
								class="icon-edit"></span> 修改</a> <a onclick="return confirm('确定删除吗')" class="button border-red"
								href="${pageContext.request.contextPath }/user/admin_user_delete.action?userid=${user.userid }&pageCode=${userPageBean.pageCode }&keywords=${keywords }&searchType=${searchType }" ><span
								class="icon-trash-o"></span> 删除</a>
						</div>
					</td>
				</tr>
				</c:forEach>
				<tr>
				<!--分页-->
					<c:if test="${userPageBean.totalPage > 1}">
					<!-- 计算页码 -->
						<c:choose>
							<c:when test="${userPageBean.totalPage < 7 }">
								<c:set var="begin" value="1"></c:set>
								<c:set var="end" value="${userPageBean.totalPage }"></c:set>
							</c:when>
							<c:otherwise>
								<c:set var="begin" value="${userPageBean.pageCode - 4 }"></c:set>
								<c:set var="end" value="${userPageBean.pageCode + 3 }"></c:set>
								<c:if test="${begin < 1 }">
									<c:set var="begin" value="1"></c:set>
									<c:set var="end" value="7"></c:set>
								</c:if>
								<c:if test="${end > userPageBean.totalPage }">
									<c:set var="begin" value="${userPageBean.totalPage - 6 }"></c:set>
									<c:set var="end" value="${userPageBean.totalPage }"></c:set>
								</c:if>
							</c:otherwise>
						</c:choose>
					<input id="pageBean_pc" type="hidden" value="${userPageBean.pageCode }">
					<td colspan="8">
						<div class="pagelist">
							<c:if test="${userPageBean.pageCode > 1 }"><a href="${pageContext.request.contextPath }/user/admin_user_${pageMethod }.action?pageCode=${userPageBean.pageCode-1 }&keywords=${keywords }&searchType=${searchType }">上一页</a></c:if>
							<c:forEach var="i" begin="${begin }" end="${end }">
								<c:choose>
									<c:when test="${i != userPageBean.pageCode}"><a href="${pageContext.request.contextPath }/user/admin_user_${pageMethod }.action?pageCode=${i }&keywords=${keywords }&searchType=${searchType }">${i }</a></c:when>
									<c:when test="${i == userPageBean.pageCode}"><span class="current">${i }</span></c:when>
								</c:choose>
							</c:forEach>
							<!-- <span class="current">1</span><a href="">2</a> -->
							<c:if test="${userPageBean.pageCode < userPageBean.totalPage }">
							<a href="${pageContext.request.contextPath }/user/admin_user_${pageMethod }.action?pageCode=${userPageBean.pageCode+1 }&keywords=${keywords }&searchType=${searchType }">下一页</a>
							</c:if>
							<a href="${pageContext.request.contextPath }/user/admin_user_${pageMethod }.action?pageCode=${userPageBean.totalPage }&keywords=${keywords }&searchType=${searchType }">尾页</a>
						</div>
					</td>
					</c:if>
				</tr>
			</table>
		</div>
	</form>
</body>

</html>