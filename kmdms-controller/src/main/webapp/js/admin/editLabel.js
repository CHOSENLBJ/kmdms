$(document).ready(function(){
	$('#admin_label_form').on('submit',function(){
		var url = $(this).attr('data-action');
		$.ajax({
			type : 'post',
			url : url,
			data : {
				'content' : $('#label_content').val()
			},
			success : function(data){
				alert(data);
			}
		});
		return false;
	});
});