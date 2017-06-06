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
<script src="${pageContext.request.contextPath }/js/admin/dormitory.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>宿舍</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="user/admin_user_editByAdmin.action">  
      <div class="form-group" >
      	
      	<div id="admin_dormitory">
      		<div id="admin_dormitory_top"></div>
      		<div id="admin_dormitory_main">
      		</div>
      	</div>
      	
      	<span class="form-group">
        <span class="label">
          <label>宿舍楼名：</label>
        </span>
        <span class="field">
          <input id="dormitory_buildName" type="text" class="input w50" value="" name=""  />
          <span class="tips"></span>
        </span>
				<span class="label">
          <label>床位数：</label>
        </span>
        <span class="field">
          <input id="dormitory_bedNum" type="text" class="input w50" value="" name=""  />
          <span class="tips"></span>
        </span>
      </span>
      <br />
      <span class="form-group">
        <span class="label">
          <label>层间数：</label>
        </span>
        <span class="field">
          <input id="dormitory_count" type="text" class="input w50" value="" name=""  />
          <span class="tips"></span>
        </span>
				<span class="label">
          <label>楼层数：</label>
        </span>
        <span class="field">
          <input id="dormitory_floorCount" type="text" class="input w50" value="" name=""  />
          <span class="tips"></span>
        </span>
      </span>
      <br />
	      <span class="form-group">
	        <span class="label">
	          <label>命名规则：</label>
	        </span>
	        <span class="field">
	          <select id="dormitory_nameRule">
	          	<option value="1">1</option>
	          	<option value="2">2</option>
	          	<option value="3">3</option>
	          </select>
	        </span>
	      </span>
        <span class="field" style="float:right">
          <button class="button bg-main icon-check-square-o" type="submit">
							提交</button>
        </span>
        <span class="field" style="float:right">
          <button id="dormitory_preview" class="button bg-main icon-check-square-o" type="button">
							预览</button>
        </span>
      </div>
    </form>
  </div>
</div>
</body>
</html>