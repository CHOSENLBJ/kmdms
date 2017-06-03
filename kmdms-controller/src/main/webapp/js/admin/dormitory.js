$(document).ready(function(){
	
	//展示房间
	var showBuild= function(){
		//获取数据
		//层间数
		var dormitory_count = $('#dormitory_count').val();
		//楼层数
		var dormitory_floorCount = $('#dormitory_floorCount').val();
		//床位数
		var dormitory_bedNum = $('#dormitory_bedNum').val();
		//命名规则
		var dormitory_nameRule = $('#dormitory_nameRule').val();
		
		if(isNaN(dormitory_bedNum) || isNaN(dormitory_count) || isNaN(dormitory_floorCount)){
			alert("请输入合适的数字");
		}else{
			$('#admin_dormitory_main').css({
				'width' : dormitory_count * 100 + 'px',
				'height' : dormitory_floorCount * 60 + 'px'
			});
			$('#admin_dormitory_top').css({
				'border-left' : dormitory_count * 50 + 'px solid transparent',
				'border-right' : dormitory_count * 50 + 'px solid transparent',
			})
			var i = 0;
			var j = 0;
			//删除初始房间
			$('#admin_dormitory_main .admin_dormitory_main_floor').remove();
			//生成房间
			for(;i <= dormitory_floorCount - 1; i++){
				$('#admin_dormitory_main').append('<div class=admin_dormitory_main_floor></div>')
				for(j = 0; j <= dormitory_count - 1; j++){
					$('#admin_dormitory_main .admin_dormitory_main_floor:eq('+ i +')').append('<div class=admin_dormitory_main_unit><span></span></div>');
				}
			}
			//添加房号
			i = dormitory_floorCount - 1;
			if(dormitory_nameRule == 1){
				for(; i >= 0; i--){
					for(j = dormitory_count - 1; j >= 0; j--){
						if(j < 9)
						$('#admin_dormitory_main .admin_dormitory_main_floor:eq('+ i +') span:eq('+ j +')').
						text((dormitory_floorCount - i) + "0" + (j + 1));
						if(j >= 9)
						$('#admin_dormitory_main .admin_dormitory_main_floor:eq('+ i +') span:eq('+ j +')').
						text((dormitory_floorCount - i) + '' + (j + 1));
					}
				}
			}
		}
	};
	showBuild();
	//预览
	$('#dormitory_preview').on('click',function(){
		showBuild();
	});
});
