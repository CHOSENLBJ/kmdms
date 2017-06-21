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
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/admin/pintuer.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/admin/admin.css">
		<script src="${pageContext.request.contextPath }/js/common/jquery-1.9.1.js"></script>
		<script src="${pageContext.request.contextPath }/js/admin/pintuer.js"></script>
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
						<th>学号</th>
						<th>宿舍楼</th>
						<th>房间号</th>
						<th>床号</th>
						<th width="170">操作</th>
					</tr>
					<tr>
						<td>XX</td>
						<td>XX</td>
						<td>XX</td>
						<td>XX</td>
						<td><div class="button-group"> <a class="button border-main" href="${pageContext.request.contextPath }/building/toEditBuilding.action"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="" onclick="return del()"><span class="icon-trash-o"></span> 删除</a> </div></td>
					</tr>
					<!--分页
					<c:if test="${buildingPageBean.totalPage > 1 }">
						<c:choose>
							<c:when test="${buildingPageBean.totalPage < 7 }">
								<c:set var="begin" value="1"></c:set>
								<c:set var="end" value="${buildingPageBean.totalPage }"></c:set>
							</c:when>
							<c:otherwise>
								<c:set var="begin" value="${buildingPageBean.pageCode - 4 }"></c:set>
								<c:set var="end" value="${buildingPageBean.pageCode + 3 }"></c:set>
								<c:if test="${begin < 1 }">
									<c:set var="begin" value="1"></c:set>
									<c:set var="end" value="7"></c:set>
								</c:if>
								<c:if test="${end > buildingPageBean.totalPage }">
									<c:set var="begin" value="${buildingPageBean.totalPage - 6 }"></c:set>
									<c:set var="end" value="${buildingPageBean.totalPage }"></c:set>
								</c:if>
							</c:otherwise>
						</c:choose>
					<td colspan="8">
						<div class="pagelist">
							<c:if test="${buildingPageBean.pageCode > 1 }"><a href="${pageContext.request.contextPath }/building/getBuildingList.action?pc=${buildingPageBean.pageCode-1 }">上一页</a></c:if>
							<c:forEach var="i" begin="${begin }" end="${end }">
								<c:choose>
									<c:when test="${i != buildingPageBean.pageCode}"><a href="${pageContext.request.contextPath }/building/getBuildingList.action?pc=${i }">${i }</a></c:when>
									<c:when test="${i == buildingPageBean.pageCode}"><span class="current">${i }</span></c:when>
								</c:choose>
							</c:forEach>
							<c:if test="${buildingPageBean.pageCode < buildingPageBean.totalPage }">
							<a href="${pageContext.request.contextPath }/building/getBuildingList.action?pc=${buildingPageBean.pageCode+1 }">下一页</a>
							</c:if>
							<a href="${pageContext.request.contextPath }/building/getBuildingList.action?pc=${buildingPageBean.totalPage }">尾页</a>
						</div>
					</td>
					</c:if>
					-->
				</table>
				<div style="text-align: center;padding: 10px;">
					<span class="field" >
	          			<button id="dormitory_allocation" class="button bg-main icon-check-square-o" type="button">
						一键分配</button>
	        		</span>
        		</div>
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