 $("#submit").click(function()  {
    $.ajax({
		url:"/getcompanyintroduce?Comopany_ID="+company_id,//需要company_id？？？要添加即可
		Type:"post",
        dataType:"json",
        traditional :true,
        success:function(data){
		    var newdata = data.substring(1,data.length-1);
            var arr = data.split(",");
		    var comopany_introduce = arr[0];//公司简介
            var comopany_logo = arr[1];//商标路径

            alert(data);
		},
     error:function (XMLHttpRequest, textStatus, errorThrown) {
         alert(XMLHttpRequest.status);
         alert(XMLHttpRequest.readyState);
         alert(textStatus);
     }
	})
})