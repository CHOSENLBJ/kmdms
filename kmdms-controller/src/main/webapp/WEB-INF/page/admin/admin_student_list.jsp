<%@ page language="java"  pageEncoding="UTF-8"%>
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
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/admin/join.css">
		<script src="${pageContext.request.contextPath }/js/common/jquery-1.9.1.js"></script>
		<script src="${pageContext.request.contextPath }/js/admin/pintuer.js"></script>
		<script src="${pageContext.request.contextPath }/js/admin/joinDormitory.js"></script>
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
					<strong class="icon-reorder"> 学生列表</strong> <a href=""
						style="float:right; display:none;">添加字段</a>
				</div>
				<div class="padding border-bottom">
					<ul class="search" style="padding-left:10px;">
						<li><input id="label_keyword" type="text" value="${keywords}" placeholder="请输入学号" name="keywords"
								   class="input"
								   style="width:250px; line-height:17px;display:inline-block" /> <a
								href="${pageContext.request.contextPath }/student/getStudentList.action?pc=1&stuId=" class="button border-main icon-search"
								onclick="getkeyword(this)"> 搜索</a></li>

					</ul>
					<script>
                        function getkeyword(a){
                            $(a).attr('href',$(a).attr('href') + $('#label_keyword').val());
                        }
					</script>
				</div>
				<table id="dormitory_attr" class="table table-hover text-center">
					<tr>
						<th>学号</th>
						<th>姓名</th>
						<th>宿舍楼</th>
						<th>房间号</th>
						<th>床号</th>
						<th width="170">操作</th>
					</tr>
					<c:if test="${studentPageBean != null}">
						<c:forEach items="${studentPageBean.beanList}" var="student" >
							<tr>
								<td>${student.stuId}</td>
								<td>${student.stuName}</td>
								<td>${student.dormitoryCustom.building.buildingName}</td>
								<td>${student.dormitoryCustom.roomNum}</td>
								<td>${student.bedNum}</td>
								<td><div class="button-group">
									<c:choose>
										<c:when test="${student.dormitoryCustom == null}">
											<a class="button border-main" href="#" onclick="return join('${pageContext.request.contextPath}/building/getAllBuildingRoughInfo.action', '${student.stuId}', '${studentPageBean.pageCode}', '${keywords}')">
												<span class="icon-edit"></span> 住宿
											</a>
										</c:when>
										<c:otherwise>
											<a class="button border-red" href="#" onclick="return del('${pageContext.request.contextPath}/student/quitStuDormitory.action?stu_id=${student.stuId}&pc=${studentPageBean.pageCode}&stuId=${keywords}')">
												<span class="icon-trash-o"></span> 退宿
											</a>
										</c:otherwise>
									</c:choose>
								</div></td>
							</tr>
						</c:forEach>
					</c:if>

					<!--分页-->
					<c:if test="${studentPageBean.totalPage > 1 }">
						<c:choose>
							<c:when test="${studentPageBean.totalPage < 7 }">
								<c:set var="begin" value="1"></c:set>
								<c:set var="end" value="${studentPageBean.totalPage }"></c:set>
							</c:when>
							<c:otherwise>
								<c:set var="begin" value="${studentPageBean.pageCode - 4 }"></c:set>
								<c:set var="end" value="${studentPageBean.pageCode + 3 }"></c:set>
								<c:if test="${begin < 1 }">
									<c:set var="begin" value="1"></c:set>
									<c:set var="end" value="7"></c:set>
								</c:if>
								<c:if test="${end > studentPageBean.totalPage }">
									<c:set var="begin" value="${studentPageBean.totalPage - 6 }"></c:set>
									<c:set var="end" value="${studentPageBean.totalPage }"></c:set>
								</c:if>
							</c:otherwise>
						</c:choose>
					<td colspan="8">
						<div class="pagelist">
							<c:if test="${studentPageBean.pageCode > 1 }"><a href="${pageContext.request.contextPath }/student/getStudentList.action?pc=${studentPageBean.pageCode-1 }">上一页</a></c:if>
							<c:forEach var="i" begin="${begin }" end="${end }">
								<c:choose>
									<c:when test="${i != studentPageBean.pageCode}"><a href="${pageContext.request.contextPath }/student/getStudentList.action?pc=${i }">${i }</a></c:when>
									<c:when test="${i == studentPageBean.pageCode}"><span class="current">${i }</span></c:when>
								</c:choose>
							</c:forEach>
							<c:if test="${studentPageBean.pageCode < studentPageBean.totalPage }">
							<a href="${pageContext.request.contextPath }/student/getStudentList.action?pc=${studentPageBean.pageCode+1 }">下一页</a>
							</c:if>
							<a href="${pageContext.request.contextPath }/student/getStudentList.action?pc=${studentPageBean.totalPage }">尾页</a>
						</div>
					</td>
					</c:if>

				</table>
				<div style="text-align: center;padding: 10px;">
					<span class="field" >
	          			<button id="dormitory_allocation" class="button bg-main icon-check-square-o" type="button">
						一键分配</button>
	        		</span>
        		</div>
			</div>
		</form>
		<form action="${pageContext.request.contextPath}/student/editStuDormitory.action" method="post">
			<input type="hidden" name="stu_id" id="STID" />
			<input type="hidden" name="pc" id="PCID" />
			<input type="hidden" name="stuId" id="STUID" />
			<div id="chooseAddress">
				<div>
					<h2>选择宿舍</h2>
				</div>
				<div>
					<select id="BuLID" name="building_id">
						<option >选择宿舍楼</option>
					</select>
					<select id="DomID" name="dormitory_id">
						<option>选择宿舍</option>
					</select>
					<select id="BeNID" name="bed_num">
						<option>选择床号</option>
					</select>
				</div>
				<div>
					<button type="submit" class="bg-main">确定</button>
				</div>
				<span id="close">X</span>
			</div>
		</form>
		<input type="hidden" value="${pageContext.request.contextPath}" id="projectName">
		<div class="mask"></div>
		<script type="text/javascript">
			//单个删除
			function del(url) {
				if (confirm("您确定要退宿吗?")) {
				    window.location.href = url;
				}
			}
		</script>
	</body>
	
</html>

