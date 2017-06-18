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
						<li><input id="label_keyword" type="text" placeholder="请输入搜索关键字" name="keywords"
							class="input"
							style="width:250px; line-height:17px;display:inline-block" /> <a
							href="${pageContext.request.contextPath }/label/getLabelList.action?pc=1&content=" class="button border-main icon-search"
							onclick="getkeyword(this)"> 搜索</a></li>
						
					</ul>
					<script>
						function getkeyword(a){
							$(a).attr('href',$(a).attr('href') + $('#label_keyword').val());
						}
					</script>
				</div>
				<table id="label_attr" class="table table-hover text-center">
					<tr>
						<th>标签内容</th>
						<th>选择人数</th>
						<th width="170">操作</th>
					</tr>
					<c:forEach items="${labelPageBean.beanList }" var="labelCustom">
					<tr>
						<td>${labelCustom.content }</td>
						<td>${labelCustom.chooseCount }</td>
						<td><div class="button-group">
								<a class="button border-main" href="admin_building_edit.html">
									<span class="icon-edit"></span> 修改
								</a>
								<a class="button border-red" href="" onclick="return del('${pageContext.request.contextPath}/label/deleteLabel.action?labelId=${labelCustom.labelId}&${labelPageBean.pageCode }&content=${keywords }')">
									<span class="icon-trash-o"></span> 删除
								</a>
						</div></td>
					</tr>
					</c:forEach>
					<tr>
					<!--分页-->
					<c:if test="${labelPageBean.totalPage > 1 }">
					<!-- 计算页码 -->
						<c:choose>
							<c:when test="${labelPageBean.totalPage < 7 }">
								<c:set var="begin" value="1"></c:set>
								<c:set var="end" value="${labelPageBean.totalPage }"></c:set>
							</c:when>
							<c:otherwise>
								<c:set var="begin" value="${labelPageBean.pageCode - 4 }"></c:set>
								<c:set var="end" value="${labelPageBean.pageCode + 3 }"></c:set>
								<c:if test="${begin < 1 }">
									<c:set var="begin" value="1"></c:set>
									<c:set var="end" value="7"></c:set>
								</c:if>
								<c:if test="${end > labelPageBean.totalPage }">
									<c:set var="begin" value="${labelPageBean.totalPage - 6 }"></c:set>
									<c:set var="end" value="${labelPageBean.totalPage }"></c:set>
								</c:if>
							</c:otherwise>
						</c:choose>
					<td colspan="8">
						<div class="pagelist">
							<c:if test="${labelPageBean.pageCode > 1 }"><a href="${pageContext.request.contextPath }/label/getLabelList.action?pc=${labelPageBean.pageCode-1 }&content=${keywords }">上一页</a></c:if>
							<c:forEach var="i" begin="${begin }" end="${end }">
								<c:choose>
									<c:when test="${i != labelPageBean.pageCode}"><a href="${pageContext.request.contextPath }/label/getLabelList.action?pc=${i }&content=${keywords }">${i }</a></c:when>
									<c:when test="${i == labelPageBean.pageCode}"><span class="current">${i }</span></c:when>
								</c:choose>
							</c:forEach>
							<!-- <span class="current">1</span><a href="">2</a> -->
							<c:if test="${labelPageBean.pageCode < labelPageBean.totalPage }">
							<a href="${pageContext.request.contextPath }/label/getLabelList.action?pc=${labelPageBean.pageCode+1 }&content=${keywords }">下一页</a>
							</c:if>
							<a href="${pageContext.request.contextPath }/label/getLabelList.action?pc=${labelPageBean.totalPage }&content=${keywords }">尾页</a>
						</div>
					</td>
					</c:if>
				</tr>
				</table>
			</div>
		</form>
		<script type="text/javascript">
			//单个删除
			function del(url) {
				if (confirm("您确定要删除吗?")) {
				    window.location.href = url;
				}
			}
		</script>
	</body>
	
</html>