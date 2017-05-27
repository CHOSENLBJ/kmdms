$(document).ready(function() {
	var random = Math.random();
	//操作的第几个标签
	var i = 0;
	//当前页
	var pc = 1;
	//显示第一页
	$('.kmdms_labelList_page:eq(0) label').fadeTo('slow',0.9);
	//定义标签的随机颜色
	var colors = ['C9EFA0', 'FF0000', 'F5B539', 'A3573C', '0000FF', 'FF00FF', 'B4B420', '00FFFF', 'D56', 'C9FCA0'];
	$("#kmdms_labelList label").each(function(index, value) {
		//定义标签在x纵轴上的坐标
		var x = ($(window).width() - parseInt($(this).css('width'))) * Math.random();
		var y = (parseInt($(this).parents('#kmdms_labelList').css('height')) - 50) * Math.random();
		var color = colors[Math.ceil(Math.random() * colors.length)];
		$(this).css({
			'top': y + 'px',
			'left': x + 'px',
			'background-color': '#' + color,
			'box-shadow' : '1px 1px 3px 3px #' + color
		});
	});

	//若用户有选择标签则显示
	$('#kmdms_choose_label_frame label').each(function(index){
		if($(this).text() != '') {
			i++;
			var color = colors[Math.ceil(Math.random() * colors.length)];
			$('#kmdms_choose_label_frame img:eq('+ index +')').show();
			$(this).attr('class','kmdms_labelList_label');
			$(this).css({
				'cursor' : 'auto',
				'position' : 'static',
				'background-color' : '#' + color,
				'box-shadow' : '1px 1px 3px 3px ' + '#' + color,
				'filter' : 'alpha(opacity=90)',
				'-moz-opacity' : '0.9',
				'opacity' : '0.9'
			})
		}
	})
	//翻页
	$('#kmdms_labelList_switch span').each(function(index, value) {
		$(value).on('mouseover', function() {
			pc = index;
			$('.kmdms_labelList_page label').hide().fadeTo(0,0);
			$('.kmdms_labelList_page:eq(' + index + ') label').show().fadeTo('slow',0.9);
		});
	});
	
	//标签移动中的一些事件
	var labelMove = function(thisLabel){
		var isDown = true;
		var isInit = true;
		var x_init;
		var y_init;
		var pX = thisLabel.position().left;
		var pY = thisLabel.position().top;
 		$(this).css({
			'cursor': 'move'
		});
		
		//鼠标拖拽
		thisLabel.on('mousemove', function(e) {
			if (isDown) {
				e = e || window.event;
				if(isInit){
				x_init = e.clientX; //鼠标第一次移动时获取x轴坐标，为了确保浮动图标不会晃动，进行了精确的定位
				y_init = e.clientY; //鼠标第一次移动时获取y轴坐标
				isInit = false;
				}
				var x = e.clientX; //鼠标移动时获取x轴坐标
				var y = e.clientY; //鼠标移动时获取y轴坐标
				$(this).css({
					'top': (y - y_init + pY) + 'px',
					'left': (x - x_init + pX) + 'px'
				});
			};
		});
		
		//拖拽到指定区域放置
		//获取选择框的位置
		var frame_top = $('#kmdms_choose_label_frame').offset().top;
		var frame_left = $('#kmdms_choose_label_frame').offset().left;
		//获取选择框的宽高
		var frame_width = parseInt($('#kmdms_choose_label_frame').css('width'));
		var frame_height = parseInt($('#kmdms_choose_label_frame').css('height'));
		
		
		//松开鼠标
		thisLabel.on('mouseup', function() {
				$(this).css({
					'cursor': 'auto'
				});
				isInit = true;
				pX = $(this).position().left;
				pY = $(this).position().top;
				//获得标签id
				var labelId = $(this).attr('data-myId');
				var label_y = $(this).offset().top;
				var label_x = $(this).offset().left;
				isDown = false;
				//如果该标签在选择框位置内则加入选择框并隐藏
				if(label_x > frame_left && label_x < frame_left + frame_width){
					if(label_y > frame_top && label_y < frame_top + frame_height){
						$('#kmdms_choose_label_frame img:eq('+ i +')').show();
						$('#kmdms_choose_label_frame label:eq('+ i +') span').text($(this).text());
						$('#kmdms_choose_label_frame label:eq('+ i +')').attr('class','kmdms_labelList_label');
						//表示该标签
						$('#kmdms_choose_label_frame label:eq('+ i +')').attr('data-myId',labelId);
						$('#kmdms_choose_label_frame label:eq('+ i +')').css({
							'cursor' : 'auto',
							'position' : 'static',
							'background-color' : $(this).css('background-color'),
							'box-shadow' : '1px 1px 3px 3px ' + $(this).css('background-color'),
							'filter' : 'alpha(opacity=90)',
							'-moz-opacity' : '0.9',
							'opacity' : '0.9'
						});
						if( i < 3) {
							i++;
							//隐藏标签
							$(this).css({
								'top' : '-40px'
							});
							$(this).hide();
						}else{
							$(this).css({
								'top' : '160px'
							});
						}
						return;
					}
				}
				//在其他地方则复位
				if($(this).offset().top > 160)
				$(this).css({
					'top' : '160px'
				});
			});
	
	};
	
	//拖拽
	$('.kmdms_labelList_page label').each(function(){
		$(this).on('mousedown',function(){
			labelMove($(this));
		});
	});
	
	//用户取消所选标签
	var deleteLabel = function(){
		$('#kmdms_choose_label_frame img').on('click',function(){
			$(this).parents('#kmdms_choose_label_frame').append('<div><label><span></span></label><img src=' + projectName + + 'img/close.png></div>');
			$(this).parent().remove();
			i--;
			$('#kmdms_choose_label_frame img').unbind('click');
			var dataId = $(this).prevAll('label').attr('data-myId');
			//恢复原有标签
			$('#kmdms_labelList label[data-myId='+ dataId +']').css({
				'cursor' : 'pointer',
				'top' : Math.random() * (parseInt($('#kmdms_labelList').css('height')) - 50)
			}).fadeTo('slow',0.9);
			deleteLabel();
		});
	};
	deleteLabel();
	
	//用户自定义标签
	$('#myLabel #myLabel_create').on('click',function(){
		$('#myLabel').modal('hide');

        var createLabel = $("#create_label").val();
        $.post( projectName + "kmdms/label/createLabel.action", {createLabel : createLabel}, function(backData, textStatus, ajax){
            var response_text = ajax.responseText;
            if(response_text != "EXISTS")
			{
				var labelJS = eval("(" + ajax.responseText + ")");
				//创建并加入
				$('.kmdms_labelList_page:eq(0)').append('<label class=kmdms_labelList_label><span>'+ labelJS.content+'</span></label>');
				var $lastLabel = $('.kmdms_labelList_page:eq(0) label:last');
				var x = ($(window).width() - parseInt($lastLabel.css('width'))) * Math.random();
				var y = (parseInt($('#kmdms_labelList').css('height')) - 50) * Math.random();
				var color = colors[Math.ceil(Math.random() * colors.length)];
				$lastLabel.css({
					'top': y + 'px',
					'left': x + 'px',
					'background-color': '#' + color,
					'box-shadow' : '1px 1px 3px 3px #' + color
				}).fadeTo(2000,0.9);
				$lastLabel.on('mousedown',function(){
					labelMove($lastLabel);
				});
				alert("创建成功！");
            } else{
            	alert("该标签已存在或存在与该标签含义近似的标签，请换一个标签！");
			}
        });


	});
	
});