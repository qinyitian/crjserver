function getinfo(data){

    var com = data.split(",");

    var company_name=com[0].substring(1);
    var company_address=com[1];
    var company_email=com[2];
    var company_scope=com[3];
    var company_license=com[4].substring(0,10);
	document.getElementById("company_name").value=company_name;
	document.getElementById("company_address").value=company_address;
	document.getElementById("company_email").value=company_email;
	document.getElementById("company_scope").value=company_scope;
	document.getElementById("company_license").value=company_license;
	
}

function get(){
    var user_name = jQuery("#user_name").data("user_name");
    alert(user_name);
    $.ajax({
        type: "post",
        datatype:"text",
        url: "/getcompanyinfo?Company_Name="+user_name,//请求地址
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
        },
        success: function(data) {
            getinfo(data);
        }
    });

}

function change(){
    var company_name=document.getElementById("company_name").value;
    var company_adress=document.getElementById("company_address").value;
    var company_email=document.getElementById("company_email").value;
    var company_scope=document.getElementById("company_scope").value;
    var company_license=document.getElementById("company_license").value;

    $.ajax({
        type: "post",
        url: "/modifycompanyinfo",//请求地址
        contentType: "application/json ; charset=utf-8",
        data:JSON.stringify({
            "Company_Name":company_name,
            "Company_Address":company_adress,
            "Company_Email":company_email,
            "Company_BusinessScope":company_scope,
            "Business_License":company_license,
        }),
        success: function(data) {
            alert(data);
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
        }
    });

}