var remind_ID;
function actionFormatter(value, row, index) {
         return [
             '<a class="like" href="javascript:void(0)" title="Like"  data-dismiss="modal">',
             '<i class="glyphicon glyphicon-plus"></i>',
             '</a>'
         ].join('');
     }
  window.actionEvents = {
         'click .like': function (e, value, row, index) {

             remind_ID = row['notice_ID'];
             //根据消息ID查询对应连接
             $.ajax({
                 type: "POST",
                 url:"/getnoticelink?Notice_ID="+remaind_ID,
                 success: function(data) {
                 	var str = data.split('"');
                     window.location.href=str[1];//要打开的连接
                 }
            });
        }
    };