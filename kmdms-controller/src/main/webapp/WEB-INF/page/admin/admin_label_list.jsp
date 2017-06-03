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
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap/bootstrap.min.css" >
<script src="${pageContext.request.contextPath }/js/common/jquery-1.9.1.js"></script>
<script src="${pageContext.request.contextPath }/js/admin/pintuer.js"></script>
<style>
			#label_attr td{
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
					<ul class="search" style="padding-left:10px;">
						<li><input type="text" placeholder="请输入搜索关键字" name="keywords"
							class="input"
							style="width:250px; line-height:17px;display:inline-block" /> <a
							href="javascript:void(0)" class="button border-main icon-search"
							onclick=> 搜索</a></li>
					</ul>
				</div>
				<table id="label_attr" class="table table-hover text-center">
					<tr>
						<th>标签内容</th>
						<th>选择人数</th>
						<th width="170">操作</th>
					</tr>
					<tr>
						<td>打篮球的</td>
						<td>50</td>
						<td><div class="button-group"> <a class="button border-main" href="admin_building_edit.html"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="" onclick="return del()"><span class="icon-trash-o"></span> 删除</a> </div></td>
					</tr>
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