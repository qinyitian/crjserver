var informations_num = 1;
var array ;

//table
$('#demandtable').bootstrapTable({
        method:'post',
        dataType:'json',
        url:"",
        pagination: true,                   //是否显示分页（*）
        pageSize: 10 //每页的记录行数（*）

    });
    
//查看简介
function actionFormatter(value, row, index) {
        return [
            '<button type="button" class="btn btn-default" data-toggle="modal" data-target="#brief_introduction">查看详情</button>'
        ].join('');
    }
    window.actionEvents = {
        'click .btn': function (e, value, row, index) {
        	$('#brief_introduction').bootstrapTable('hideColumn', 'demand_id');
        	$('#brief_introduction').bootstrapTable('hideColumn', 'demand_name');
        	$('#brief_introduction').bootstrapTable('hideColumn', 'catalog');
            $.ajax({
                 type: "POST",
                 url:"",  
                 success: function(msg){
                $('#brief_introduction').bootstrapTable('load',msg);
            }
            });
        }
    };



function Submit(){
	var json = "0,";
	var arr = $.parseJSON(array);
	
	for(var n=0;n<informations_num;n++)
    {
        if(document.getElementById(n).checked==true){
            json = json + arr[n].demand_ID + ",";
        }
	}
	json = json + "0";

	$.ajax({
        type: "post",
        contentType: "application/x-www-form-urlencoded;charset=utf-8",
        url: "/postdemand",//请求地址
        data: {"jarr":json},
        dataType:"text",
        success: function(back) {
        	alert(back);
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
        },
    })
}


function getjson(){
	   
	$.ajax({
        type: "get",
        url: "/getallequipment",//请求地址

        dataType:"text",
        
        success: function(data) {
        	add(data);
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
        },
    })
}

