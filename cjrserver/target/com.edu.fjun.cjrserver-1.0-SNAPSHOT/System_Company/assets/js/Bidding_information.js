var TenderID;
 function actionFormatter(value, row, index) {
         return [
             '<a class="like" href="javascript:void(0)" title="Like"  data-dismiss="modal">',
             '<i class="glyphicon glyphicon-plus"></i>',
             '</a>'
         ].join('');
     }

  window.actionEvents = {
         'click .like': function (e, value, row, index) {

             TenderID = row['tenderPlan_ID'];
             alert("343");
             //根据招标计划ID查询对应文件下载路径
             $.ajax({
                 type: "POST",
                 url:"/gettenderplanfilepath?TenderPlanID="+TenderID,
                 success: function(data) {
                     alert(data);
                     window.location.href=localhost+data;
                 }
            });
        }
    };

//勾选项目欧朴
 $('#Bidding').click(function () {

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
         CompanyNameList[i]=allTableData[i].tenderPlan_ID;//这里不能用已经转换的JSON格式，要用原本的
         alert(allTableData[i].tenderPlan_ID);
     }
     var tender = allTableData[0].tenderPlan_ID;
     var user_name = jQuery("#user_name").data("user_name");
     $.ajax({
         type:"post",
         traditional: true,
         url: "/company/posttender",//请求地址
         data: { "TenderPlan_ID": tender, "CompanyName": user_name},//向后台提交的参数
         success: function(data) {
             alert(data);
             window.location.href="BidingResult.html";
         },
         error: function(XMLHttpRequest, textStatus, errorThrown) {
             alert(XMLHttpRequest.status);
             alert(XMLHttpRequest.readyState);
             alert(textStatus);
         },

     })
 });