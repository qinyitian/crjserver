 var TenderName;
$('#TenderPlanTable').bootstrapTable({
    method:'post',
    dataType:'json',
    pagination: true,                   //是否显示分页（*）
    pageSize: 10 //每页的记录行数（*）

});
    function actionFormatter(value, row, index) {
        return [
            '<a class="like" href="javascript:void(0)" title="Like" data-dismiss="modal">',
            '<i class="glyphicon glyphicon-plus"></i>',
            '</a>'
        ].join('');
    }
 window.TenderactionEvents = {
     'click .like': function (e, value, row, index) {
         document.getElementById("TenderPlanName_input").value=row['tenderPlan_name'];
         TenderID = row['tenderPlan_ID'];
         //根据招标计划ID查询对应companyinfo
         $.ajax({
             type: "POST",
             url:"/TenderPlan/ReturnTenderPlanCompany?TenderPlanID="+row['tenderPlan_ID'],
             success: function(msg){
                 $('#CompanyInfo').bootstrapTable('load',msg);
             }
         });
     }
 };
    //点击事件
    $('#TenderPlanName_input').click(function (){

    	//加一个判断如果已经投票alert（不可重复投票）
        //隐藏ID列
        $('#TenderPlanTable').bootstrapTable('hideColumn', 'tenderPlan_ID');
        //重新加载悬浮窗TenderPlanTable数据
        $.ajax({
            type: "POST",
            url:"/TenderPlan/ReturnTenderPlan",
            success: function(msg){
                $('#TenderPlanTable').bootstrapTable('load',msg);
            }
        });
    });

    $('#tr1').click(function (){

        //加一个判断如果已经投票alert（不可重复投票）
        //隐藏ID列
        $('#TenderPlanTable').bootstrapTable('hideColumn', 'tenderPlan_ID');
        //重新加载悬浮窗TenderPlanTable数据
        $.ajax({
            type: "POST",
            url:"/TenderPlan/ReturnTenderPlan",
            success: function(msg){
                $('#TenderPlanTable').bootstrapTable('load',msg);
            }
        });
    });

 $('#searchInfo').click(function (){
     //根据招标计划ID查询对应companyinfo
     $.ajax({
         type: "POST",
         url:"/TenderPlan/ReturnTenderPlanCompany?TenderPlanID="+TenderID,
         success: function(msg){
             $('#CompanyInfo').bootstrapTable('load',msg);
         }
     });
 });


     $('#voting').click(function () {
        var TenderPlanName = document.getElementById("TenderPlanName_input").value;
        var ids = $.map($('#CompanyInfo').bootstrapTable('getSelections'), function (row) {
            return row.id;
        });
        $('#CompanyInfo').bootstrapTable('remove', {
            field: 'id',
            values: ids
        });
        var allTableData =$('#CompanyInfo').bootstrapTable('getSelections');
        //获取悬浮框数据
        var CompanyNameList = new Array();
//        var allTableData = $('#CompanyInfo').bootstrapTable('getData');
        var allTableData2 = JSON.stringify(allTableData);
        //获取json中demand_ID,生成数组
        for(var i=0;i<eval(allTableData2).length;i++)
        {
            CompanyNameList[i]=allTableData[i].company_Name;//这里不能用已经转换的JSON格式，要用原本的
        }
        var companyname = allTableData[0].company_Name;

         var user_id = jQuery("#user_name").data("userid");//==========================================================有错误，输出为空，改====================================================
         alert(userid);
         $.ajax({
            type:"post",
            traditional: true,
            url: "/postvote",//请求地址
            data: { "TenderPlanName": TenderPlanName, "disability":userid, "CompanyName":companyname },//向后台提交的参数
            success: function(data) {
                alert(data);
                //window.location.href="BidingResult.html";
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            },

        })

    });
      