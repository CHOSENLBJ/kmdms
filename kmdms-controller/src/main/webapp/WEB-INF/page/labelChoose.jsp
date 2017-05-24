<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>学生宿舍管理系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	
	<link href="css/bootstrap/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/labelChoose/label.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/labelChoose/label_choose.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/button/button.css" />
	<script src="${pageContext.request.contextPath }/js/common/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/label/label.js" ></script>
</head>
	<body>
		<!--标签-->
		<div id="kmdms_labelList">
			<!--一页标签-->
			<div class="kmdms_labelList_page">
				<label class="kmdms_labelList_label"><span>小星星</span></label>
				<label class="kmdms_labelList_label"><span>小星星</span></label>
				<label class="kmdms_labelList_label"><span>小星星</span></label>
				<label class="kmdms_labelList_label"><span>小星星</span></label>
				<label class="kmdms_labelList_label"><span>小星星</span></label>
				<label class="kmdms_labelList_label"><span>小星星</span></label>
			</div>
			<div class="kmdms_labelList_page">
				<label class="kmdms_labelList_label"><span>小星星</span></label>
				<label class="kmdms_labelList_label"><span>小星星</span></label>
				<label class="kmdms_labelList_label"><span>小星星</span></label>
				<label class="kmdms_labelList_label"><span>小星星</span></label>
				<label class="kmdms_labelList_label"><span>小星星</span></label>
				<label class="kmdms_labelList_label"><span>小星星</span></label>
			</div>
			<div class="kmdms_labelList_page">
				<label class="kmdms_labelList_label"><span>小星星</span></label>
				<label class="kmdms_labelList_label"><span>小星星</span></label>
				<label class="kmdms_labelList_label"><span>小星星</span></label>
				<label class="kmdms_labelList_label"><span>小星星</span></label>
				<label class="kmdms_labelList_label"><span>小星星</span></label>
				<label class="kmdms_labelList_label"><span>小星星</span></label>
			</div>
			<!--翻页-->
			<div id="kmdms_labelList_switch">
				<span data-pc="1"></span>
				<span data-pc="2"></span>
				<span data-pc="3"></span>
			</div>
		</div>
		
		<!--用户的选择-->
		<div id="kmdms_choose" class="row">
			<!--所选标签-->
			<div id="kmdms_choose_label" class="col-md-6 row">
				<form>
				<div class="col-md-4"></div>
				<div id="kmdms_choose_label_frame" class="col-md-4">
					<div><label><span></span></label><img src="${pageContext.request.contextPath }/img/close.png"></div>
					<div><label><span></span></label><img src="${pageContext.request.contextPath }/img/close.png"></div>
					<div><label><span></span></label><img src="${pageContext.request.contextPath }/img/close.png"></div>
				</div>
				<div id="kmdms_choose_label_createAndSubmit" class="col-md-4">
					<div><button type="submit" class="button blue serif skew glossy">确定选择</button></div>
					<div><button type="button" class="button blue serif skew glossy" data-toggle="modal" data-target="#myLabel">定义标签</button></div>
				</div>
				</form>
			</div>
			<!--规则-->
			<div class="col-md-6">
				<h3>规则说明</h3>
				<div id="kmdms_choose_rule">
					<strong>1.春眠不觉晓</strong><br />
					<strong>2.处处闻啼鸟</strong><br />
					<strong>3.夜来风雨声</strong><br />
					<strong>4.花落知多少</strong><br />
				</div>
			</div>
		</div>
		<!--自定义框-->
		<div class="modal fade modal fade bs-example-modal-sm" id="myLabel" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
		  <div class="modal-dialog modal-sm" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">自定义标签</h4>
		      </div>
		      <div class="modal-body">
		        <input type="text" placeholder="请输入你的要求" />
		      </div>
		      <div class="modal-footer">
		        <button id="myLabel_create" type="button" class="btn btn-primary" >创建</button>
		      </div>
		    </div>
		  </div>
		</div>		
		<script src="${pageContext.request.contextPath }/js/common/bootstrap.min.js"></script>
	</body>
</html>
