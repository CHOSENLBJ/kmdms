/*隐藏其他标签并显示当前标签*/
$(document).ready(function(){
	//初始化，默认选择我的标签
	$('#index_content>div').hide();
	$('#index_content>div:eq(0)').show();
	
	$('#index_tab li').each(function(index){
		$(this).on('click',function(){
			//标志当前标签
			$('#index_tab li').each(function(){
				$(this).attr('class',$(this).attr('class').replace('active_tab',''));
			})
			$(this).attr('class',$(this).attr('class') + ' active_tab');
			//显示当前标签的内容
			$('#index_content>div').hide();
			$('#index_content>div:eq('+ index +')').show();
		})
	})
})
