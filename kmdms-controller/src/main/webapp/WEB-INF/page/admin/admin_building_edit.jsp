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
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>用户</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="${pageContext.request.contextPath }/user/admin_user_editByAdmin.action">  
      <input type="hidden" value="${userEdit.userid }" name="userid" />
      <span class="form-group">
        <span class="label">
          <label>昵称：</label>
        </span>
        <span class="field">
          <input type="text" class="input w50" value="${userEdit.petname }" name="petname"  />
          <span class="tips"></span>
        </span>
		<span class="label">
          <label>手机：</label>
        </span>
        <span class="field">
          <input type="text" class="input w50" value="${userEdit.telephone }" name="telephone"  />
          <span class="tips"></span>
        </span>
      </span>
      <br/>
	  <span class="form-group">
        <span class="label">
          <label>密码：</label>
        </span>
        <span class="field">
          <input type="text" class="input w50" value="${userEdit.password }" name="password"  />
          <span class="tips"></span>
        </span>
        <span class="label">
          <label>邮箱：</label>
        </span>
        <span class="field">
          <input type="text" class="input w50" value="${userEdit.email }" name="email"  />
          <span class="tips"></span>
        </span>
      </span>
      <br/>
      <span class="form-group">
        <span class="label">
          <label>地址：</label>
        </span>
        <span class="field">
          <input type="text" class="input w50" value="${userEdit.address }" name="address"  />
          <span class="tips"></span>
        </span>
        <span class="label">
          <label>生日：</label>
        </span>
        <span class="field">
          <input type="text" class="input w50" value='<fmt:formatDate value="${userEdit.birthday }" type="date"/>' name="birthday"  />
          <span class="tips"></span>
        </span>
      </span>
      <br/>
      <span class="form-group">
        <span class="label">
          <label>真实姓名：</label>
        </span>
        <span class="field">
          <input type="text" class="input w50" value="${userEdit.realname }" name="realname"  />
          <span class="tips"></span>
        </span>
        <span class="label">
          <label>身份证号：</label>
        </span>
        <span class="field">
          <input type="text" class="input w50" value="${userEdit.idnumber }" name="idnumber"  />
          <span class="tips"></span>
        </span>
      </span>
      <br/>
      <span class="form-group">
        <span class="label">
          <label>性别：</label>
        </span>
        <span class="field">
          <input type="radio" ${userEdit.sex == 1 ? "checked=checked" : "" } value="1" name="sex"  /><span style="padding: 0 10px">男</span>
          <input type="radio" ${userEdit.sex == 2 ? "checked=checked" : "" } value="2" name="sex"  /><span style="padding: 0 10px">女</span>
          <input type="radio" ${userEdit.sex == 0 ? "checked=checked" : "" } value="0" name="sex"  /><span style="padding: 0 10px">保密</span>
          <span class="tips"></span>
        </span>
      </span>
      <br />
	 <br/>
      <div class="form-group" >
        <span class="label">
          <label></label>
        </span>
        <span class="field" style="float:right">
          <button class="button bg-main icon-check-square-o" type="submit">
							提交</button>
        </span>
      </div>
    </form>
  </div>
</div>
</body></html>