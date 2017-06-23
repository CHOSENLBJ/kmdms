$(document).ready(function(){
	$('#admin_building_form').on('submit',function(){
		var url = $(this).attr('data-action');
		
		$.ajax({
			type : 'post',
			url : url,
			data : {
				'buildingId' : $('#dormitory_buildId').val(),
				'buildingName' : $('#dormitory_buildName').val(),
				'bedCount' : $('#dormitory_bedNum').val(),
				'dCount' : $('#dormitory_count').val(),
				'floorCount' : $('#dormitory_floorCount').val(),
				'nameRule' : $('#dormitory_nameRule').val(),
			},
			success : function(data){
				alert(data);
			}
		});
		return false;
	});
	$.deleteBuilding = function(a){
		var url = $(a).attr('href');
		$.ajax({
			type : 'post',
			url : url,
			data : {
				'buildingId' : $('#dormitory_buildId').val(),
			},
			success : function(data){
				alert(data);
			}
		});
		return false;
	};
});