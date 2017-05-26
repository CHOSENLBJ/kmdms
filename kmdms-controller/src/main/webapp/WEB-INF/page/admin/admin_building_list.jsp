<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

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
	</head>

	<body>
		<form method="post" action="" id="listform">
			<div class="panel admin-panel">
				<div class="panel-head"><strong class="icon-reorder"> 宿舍列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
				<div class="padding border-bottom">
					<ul class="search" style="padding-left:10px;">
						<li>
							<input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
							<a href="javascript:void(0)" class="button border-main icon-search" onclick="changesearch()"> 搜索</a></li>
					</ul>
				</div>
				<table class="table table-hover text-center">
					<tr>
						<th>宿舍名</th>
						<th>楼层</th>
						<th>房位</th>
						<th>床位</th>
						<th>居住人数</th>
						<th width="170">操作</th>
					</tr>
					<tr>
						<td>中六</td>
						<td>5层</td>
						<td>40间</td>
						<td>4张</td>
						<td>160人</td>
						<td>
							<div class="button-group"> <a class="button border-main" href="#"><span class="icon-edit"></span> 查看</a> <a class="button border-red" href="http://www.baidu.com" onclick="return del()"><span class="icon-trash-o"></span> 删除</a> </div>
						</td>
					</tr>
					<tr>
						<td colspan="8">
							<div class="pagelist"> <a href="">上一页</a> <span class="current">1</span><a href="">2</a><a href="">3</a><a href="">下一页</a><a href="">尾页</a> </div>
						</td>
					</tr>
				</table>
			</div>
		</form>
		<script type="text/javascript">
			//搜索
			function changesearch() {
			}
			//单个删除
			function del(id, mid, iscid) {
				if (confirm("您确定要删除吗?")) {
				}
			}
		</script>
	</body>

</html>