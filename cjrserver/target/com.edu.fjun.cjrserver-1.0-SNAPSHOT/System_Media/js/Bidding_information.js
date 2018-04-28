var head = new Array("项目id","项目名称","开始时间","截止时间","详情文件","我要投标")

function submittender(tender_id){

	$.ajax({
        type: "post",
        contentType: "application/json;charset=utf-8",
        url: "/tender",//请求地址
        data: JSON.stringify({ "telephone":"12580","TenderPlan_ID":TenderPlan_id}),//向后台提交的参数
        success: function(data) {
        	alert(data);
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
        },
    })
	
}

 function actionFormatter(value, row, index) {
        return '<a class="dowload" >修改</a>';
    }

 window.actionEvents = {
        'click .dowload': function(e, value, row, index) {      
              //修改操作
            }
        }
function add(data){
	
	var tender = $.parseJSON(data);

	
//	var informations = new Bidding_information(tender.length);
//	赋值
    
　　var parent = document.getElementById("Drop-down box");
　　var div = document.createElement("div");
    div.setAttribute("class", "panel-body");
    div.setAttribute("id","panel1");
　   parent.appendChild(div);

　　var parent = document.getElementById("panel1");
　　var table = document.createElement("table");
    table .setAttribute("class", "table table-striped table-bordered bootstrap-datatable datatable");
    table .setAttribute("id","table1");
　   parent.appendChild(table);

　　var parent = document.getElementById("table1");
　　var thead = document.createElement("thead");
    thead.setAttribute("id","thead_head");
　   parent.appendChild(thead);

    var parent = document.getElementById("thead_head");
　　var tr = document.createElement("tr");
    tr.setAttribute("id","tr_head");
　   parent.appendChild(tr);

   for(var m=0;m<6;m++)
   {
   	var parent = document.getElementById("tr_head");
　　var th = document.createElement("th");
    th.innerHTML=head[m];
　   parent.appendChild(th);
   }
   
   var parent = document.getElementById("table1");
　　var tbody = document.createElement("tbody");
    tbody.setAttribute("id","tbody1");
　   parent.appendChild(tbody);
  
   for(var n=0;n<tender.length;n++)
   {
   	var parent = document.getElementById("tbody1");
　　var trn= document.createElement("tr");
    var trn_id = "tr" + n;
    trn.setAttribute("id",trn_id);
　   parent.appendChild(trn);

    var parent = document.getElementById(trn_id);
　　var td1= document.createElement("td");
    td1.innerHTML=tender[n].TenderPlan_ID;//id

　   parent.appendChild(td1);

    var parent = document.getElementById(trn_id);
　　var td2= document.createElement("td");
    td2.innerHTML=tender[n].TenderPlan_name;//name
　   parent.appendChild(td2);
 
    var parent = document.getElementById(trn_id);
　　var td3= document.createElement("td");
    td3.innerHTML=tender[n].TenderPlan_StartTime;//start_time
　   parent.appendChild(td3);

   var parent = document.getElementById(trn_id);
　　var td4= document.createElement("td");
    td4.innerHTML=tender[n].TenderPlan_EndTime;//end_time
　   parent.appendChild(td4);

    var parent = document.getElementById(trn_id);
　　var td5= document.createElement("td");
    var td_id = "td"+n;
    td5.setAttribute("id",td_id);
　   parent.appendChild(td5);

    var parent = document.getElementById(td_id);
　　var a= document.createElement("a");
    a.innerHTML=tender[n].TenderPlan_ID_FileName;//file_name
    a.setAttribute("href",tender[n].TenderPlan_FilePath); //file_path

　   parent.appendChild(a);

   var parent = document.getElementById(trn_id);
   　　var td6= document.createElement("td");
       td6.setAttribute("id","td_"+n);
   　   parent.appendChild(td6);

      var parent = document.getElementById("td_"+n);
   　　var button1= document.createElement("button");
       button1.innerHTML="投标";
       var button_id = tender[n].TenderPlan_ID;
       button1.setAttribute("id",button_id);
       button1.setAttribute("onclick","submittender(this.id);");//函数
        button1.setAttribute("class","btn btn-primary");
   　   parent.appendChild(button1);
    
   }


    
}

function getjson(){
	   

	$.ajax({
        type: "get",
        url: "/getalltender",//请求地址

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

