$(document).ready(function(){
	join = function(){
		//遮罩层
		var sHeight = document.documentElement.scrollHeight;
		var sWidth = document.documentElement.scrollWidth;
		sHeight = sHeight > 610 ? sHeight : 610;
		$('.mask').height(sHeight + "px");
		$('.mask').width(sWidth + "px");
		$('#chooseAddress').show();
		$('.mask').show();
		$('#close').on('click',function(){
			$('.mask').hide();
			$('#chooseAddress').hide();
		});
	}
});
