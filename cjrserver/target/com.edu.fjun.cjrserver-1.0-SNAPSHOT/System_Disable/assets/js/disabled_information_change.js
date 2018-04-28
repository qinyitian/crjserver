function useget(data) {

    var com = data.split(",");

    var disabled_idenity=com[0].substring(1);
    var disabled_name=com[1];
    var disabled_email=com[3];
    var disabled_address=com[2];
    var disabled_sex=com[4];
    var disabled_job=com[5];
    var disabled_date=com[6].substring(0,9);
    document.getElementById("disabled_idenity").value=disabled_idenity;
    document.getElementById("disabled_name").value=disabled_name;
    document.getElementById("disabled_email").value=disabled_email;
    document.getElementById("disabled_address").value=disabled_address;
    document.getElementById("disabled_sex").value=disabled_sex;
    document.getElementById("disabled_job").value=disabled_job;
    document.getElementById("disabled_date").value=disabled_date;

}
function get(){
    var user_id = jQuery("#user_name").data("userid");//==========================================================有错误，输出为空，改====================================================

    $.ajax({
        type: "post",
		datatype:"text",
        url: "/getdisableinfo?Disability_Identity="+userid,//请求地址
        error: function() {
            alert("error");
        },
        success: function(data) {
                useget(data);
            }
    });

}

function change(){
    var disabled_idenity=document.getElementById("disabled_idenity").value;
    var disabled_name=document.getElementById("disabled_name").value;
    var disabled_email=document.getElementById("disabled_email").value;
    var disabled_address=document.getElementById("disabled_address").value;
    var disabled_sex=document.getElementById("disabled_sex").value;
    var disabled_job=document.getElementById("disabled_job").value;
    var disabled_date=document.getElementById("disabled_date").value;

    $.ajax({
        type: "post",
        url: "/modifydisableinfo",//请求地址
        contentType: "application/json ; charset=utf-8",
        data:JSON.stringify({
            "Disability_Identity":disabled_idenity,
            "RealName":disabled_name,
            "Email":disabled_email,
            "Address":disabled_address,
            "Sex":disabled_sex,
            "Job":disabled_job,
            "Birthday":disabled_date
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
