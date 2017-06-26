$(document).ready(function(){
	join = function(url, stu_id, pc, stuId){
	    $("#STID").val(stu_id);
        $("#PCID").val(pc);
        $("#STUID").val(stuId);
        $.post(url, {}, function(backData, textStatus, ajax){
            $('#BuLID option').not(":first").remove();
            var buildings = ajax.responseText;
            if(buildings != "")
            {
                var buildingsJS = eval("(" + buildings + ")");
                for(var i = 0; i < buildingsJS.length; i++){
                    var building = buildingsJS[i];
                    var buildingId = building.buildingId;
                    var buildingName = building.buildingName;
                    $("#BuLID").append("<option value='" + buildingId + "'>" + buildingName + "</option>");
                }
            }
        });

        $("#BuLID").change(function(){
            $('#DomID option').not(":first").remove();
			var buildingId = $(this).val();
			var url = $("#projectName").val() + "/dormitory/getDormitoryByBuildingId.action";
            $.post(url, {buildingId : buildingId}, function(backData, textStatus, ajax){
                var dormitorys = ajax.responseText;
                if(dormitorys != "")
                {
                    var dormitorysJS = eval("(" + dormitorys + ")");
                    for(var i = 0; i < dormitorysJS.length; i++){
                        var dormitory = dormitorysJS[i];
                        var dormitoryId = dormitory.dormitoryId;
                        var roomNum = dormitory.roomNum;
                        $("#DomID").append("<option value='" + dormitoryId + "'>" + roomNum + "</option>");
                    }
                }
            });
		});

        $("#DomID").change(function(){
            $('#BeNID option').not(":first").remove();
            var dormitoryId = $(this).val();
            var url = $("#projectName").val() + "/dormitory/getEmptyBedByDormitoryId.action";
            $.post(url, {dormitoryId : dormitoryId}, function(backData, textStatus, ajax){
                var emptyBeds = ajax.responseText;
                if(emptyBeds != "")
                {
                    var emptyBedsJS = eval("(" + emptyBeds + ")");
                    for(var i = 0; i < emptyBedsJS.length; i++){
                        var emptyBeds = emptyBedsJS[i];
                        $("#BeNID").append("<option value='" + emptyBeds + "'>" + emptyBeds + "</option>");
                    }
                    if(emptyBedsJS.length == 0)$("#BeNID").append("<option >没有空床位</option>");
                }
            });
        });

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
