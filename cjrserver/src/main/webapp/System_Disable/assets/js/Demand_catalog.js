var DemandTableID;
$('#DemandTable').bootstrapTable({
    method:'post',
    dataType:'json',
    pagination: true,                   //是否显示分页（*）
    pageSize: 10 //每页的记录行数（*）

});
function StateFormatter(value, row, index) {
    if(row['demandTable_State']==0)
        return '<span class="label label-primary">正在进行</span>';
    else if(row['demandTable_State']==1)
        return '<span class="label label-danger">已经完成</span>';
}
function actionFormatter(value, row, index) {

    return [
        '<a class="like" href="javascript:void(0)" title="Select" data-dismiss="modal">',
        '<i class="glyphicon glyphicon-plus"></i>',
        '</a>'
    ].join('');
}
window.DemandactionEvents = {
    'click .like': function (e, value, row, index) {
        document.getElementById("DemandTable_input").value=row['demandTable_Name'];
        DemandTableID = row['demandTable_ID'];
    }
};

$('#DemandTable_input').click(function (){
    //隐藏ID列
    $('#DemandTable').bootstrapTable('hideColumn', 'demandTable_ID');
    //重新加载悬浮窗TenderPlanTable数据
    $.ajax({
        type: "POST",
        url:"/Demand/ShowAll",
        success: function(msg){
            $('#DemandTable').bootstrapTable('load',msg);
        }
    });
});

$('#tr1').click(function (){
    //隐藏ID列
     $('#DemandTable').bootstrapTable('hideColumn', 'demandTable_ID');
    //重新加载悬浮窗TenderPlanTable数据
    $.ajax({
        type: "POST",
        url:"/Demand/ShowAll",
        success: function(msg){
            $('#DemandTable').bootstrapTable('load',msg);
        }
    });
});

$('#searchInfo').click(function (){
    //根据招标计划ID查询对应companyinfo~666666666666666666656666666666666666666																								
    $.ajax({
        type: "POST",
        url:"/getdemanddetail?DemandTable_ID="+DemandTableID,
        success: function(msg){
            $('#DetailTable').bootstrapTable('load',msg);
        }
    });
});


$('#Demanded').click(function () {
        var TenderPlanName = document.getElementById("DemandTable_input").value;
        var ids = $.map($('#DetailTable').bootstrapTable('getSelections'), function (row) {
            return row.id;
        });
        $('#DetailTable').bootstrapTable('remove', {
            field: 'id',
            values: ids
        });
        var allTableData =$('#DetailTable').bootstrapTable('getSelections');
        //获取悬浮框数据
        var CompanyNameList = new Array();
       // var allTableData = $('#DetailTable').bootstrapTable('getData');
        var allTableData2 = JSON.stringify(allTableData);
        //获取json中demand_ID,生成数组
        for(var i=0;i<eval(allTableData2).length;i++)
        {
            CompanyNameList[i]=allTableData[i].demand_ID;//这里不能用已经转换的JSON格式，要用原本的
        }
        var user_id = jQuery("#user_name").data("userid");//==========================================================有错误，输出为空，改====================================================
        alert(user_id);
        $.ajax({
            type:"post",
            traditional: true,
            url: "/postdemand",//请求地址
            data: { "Disability":user_id,"DemandTable_ID": DemandTableID ,"arr": CompanyNameList },//向后台提交的参数
            success: function(data) {
                alert(data);
               // window.location.href="BidingResult.html";
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            },

        })
    });

//function Submit(){
//	var json = "0,";
//	var arr = $.parseJSON(array);
//	
//	for(var n=0;n<informations_num;n++)
//	{
//		if(document.getElementById(n).checked==true){
//			json = json + arr[n].demand_ID + ",";
//		}
//	}
//	json = json + "0";
//
//	$.ajax({
//      type: "post",
//      contentType: "application/x-www-form-urlencoded;charset=utf-8",
//      url: "/postdemand",//请求地址
//      data: {"jarr":json},
//      dataType:"text",
//      success: function(back) {
//      	alert(back);
//      },
//      error: function(XMLHttpRequest, textStatus, errorThrown) {
//          alert(XMLHttpRequest.status);
//          alert(XMLHttpRequest.readyState);
//          alert(textStatus);
//      },
//  })
//}
//
//
//function getjson(){
//	   
//	$.ajax({
//      type: "get",
//      url: "/getallequipment",//请求地址
//
//      dataType:"text",
//      
//      success: function(data) {
//      	add(data);
//      },
//      error: function(XMLHttpRequest, textStatus, errorThrown) {
//          alert(XMLHttpRequest.status);
//          alert(XMLHttpRequest.readyState);
//          alert(textStatus);
//      },
//  })
//}

