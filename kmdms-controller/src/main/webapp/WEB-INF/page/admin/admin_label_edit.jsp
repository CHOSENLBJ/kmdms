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
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/pintuer.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/admin.css">
<script src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script src="${pageContext.request.contextPath }/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>标签</strong></div>
  <div class="body-content">
    <form id="admin_label_form" method="post" class="form-x" data-action="${pageContext.request.contextPath }/label/editLabel.action" action="">  
      <div class="form-group" >
      	<span class="form-group">
        <span class="label">
          <label>标签内容：</label>
        </span>
        <span class="field">
			<textarea name="content" id="label_content"></textarea>
        </span>
      </span>
      <br />
        <span class="field" style="float:right">
          <button class="button bg-main icon-check-square-o" type="submit">
							提交</button>
        </span>
      </div>
    </form>
  </div>
</div>
</body>
</html>