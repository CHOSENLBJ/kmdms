<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<title></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/pintuer.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/admin.css">
		<script src="${pageContext.request.contextPath }/js/jquery.js"></script>
		<script src="${pageContext.request.contextPath }/js/pintuer.js"></script>
		<style>
			#dormitory_attr td{
				vertical-align: middle;
			}
		</style>
	</head>
	<body>
		<form method="post" action="" id="listform">
			<div class="panel admin-panel">
				<div class="panel-head"> 
					<strong class="icon-reorder"> 内容列表</strong> <a href=""
						style="float:right; display:none;">添加字段</a>
				</div>
				<div class="padding border-bottom">
				</div>
				<table id="dormitory_attr" class="table table-hover text-center">
					<tr>
						<th>宿舍楼名</th>
						<th>床位数</th>
						<th>层间数</th>
						<th>楼层数</th>
						<th>居住人数</th>
						<th width="170">操作</th>
					</tr>
					<c:forEach items="${buildingPageBean.beanList }" var="building">
					<tr>
						<td>${building.buildingName }</td>
						<td>${building.bedCount * building.dCount * building.floorCount }</td>
						<td>${building.dCount }</td>
						<td>${building.floorCount }</td>
						<td>${building.totalPeople }</td>
						<td><div class="button-group"> <a class="button border-main" href="${pageContext.request.contextPath }/building/toEditBuilding.action"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="" onclick="return del()"><span class="icon-trash-o"></span> 删除</a> </div></td>
					</tr>
					</c:forEach>
				</table>
			</div>
		</form>
		<script type="text/javascript">
			//单个删除
			function del(id, mid, iscid) {
				if (confirm("您确定要删除吗?")) {
				}
			}
		</script>
	</body>
	
</html>