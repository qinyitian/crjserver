function  hello() {

    var name = document.getElementById("inputMedia_name").value;
    var Email = document.getElementById("inputEmail").value;
    var Phone = document.getElementById("inputPhone").value;
    var Address = document.getElementById("inputAddress").value;
    var Password1 = document.getElementById("inputPassword1").value;
    var invite_code = document.getElementById("inputinvite_code").value;
    $.ajax({
        type: "post",
        contentType: "application/json;charset=utf-8",
        url: "cjrserver/Media_check",//请求地址
        data: JSON.stringify({ "Media_name": name, "Email": Email, "Phone": Phone,  "Address": Address,
            "Password": Password1, "invite_code": invite_code}),//向后台提交的参数
        success: function(data) {
            console.log("success...");
        },
        error: function(data) {
            console.log("error...");
        }
    })
}

