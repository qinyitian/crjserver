function checkdisability()
{
    var x = document.getElementById("inputdisability").value;
    var y = document.getElementById("label_disability");
    if(x==null || x=="")
    {
        y.style.color="red";
        y.style.fontSize=5;
        y.innerHTML="残疾人证号不能为空";
        return false;
    }
    if(x.length!=20)
    {
        y.style.color="red";
        y.style.fontSize=5;
        y.innerHTML="残疾人证号格式错误";
        return false;
    }
    y.style.color="green";
    y.style.fontSize=5;
    y.innerHTML="正确";
    return true;
}
function checkuser_name()
{
    var x = document.getElementById("inputuser_name").value;
    var y = document.getElementById("label_use_name");
    if(x==null || x=="")
    {
        y.style.color="red";
        y.style.fontSize=5;
        y.innerHTML="用户名不能为空";
        return false;
    }
    if(x.length>20)
    {
        y.style.color="red";
        y.style.fontSize=5;
        y.innerHTML="用户名过长";
        return false;
    }
    else
    {
        y.style.color="green";
        y.style.fontSize=5;
        y.innerHTML="正确";
        return true;
    }
}
function checkrealname()
{
    var x = document.getElementById("inputrealname").value;
    var y = document.getElementById("label_realname");
    if(x==null || x=="")
    {
        y.style.color="red";
        y.style.fontSize=5;
        y.innerHTML="真实姓名不能为空";
        return false;
    }
    if(x.toString().length>20)
    {
        y.style.color="red";
        y.style.fontSize=5;
        y.innerHTML="真实姓名过长";
        return false;
    }
    y.style.color="green";
    y.style.fontSize=5;
    y.innerHTML="正确";
    return true;
}

function checkbirthday()
{
    var x = document.getElementById("inputbirthday").value;
    var y = document.getElementById("label_birthday");
    var result= x.match(/((^((1[8-9]\d{2})|([2-9]\d{3}))(-)(10|12|0?[13578])(-)(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(11|0?[469])(-)(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(0?2)(-)(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)(-)(0?2)(-)(29)$)|(^([3579][26]00)(-)(0?2)(-)(29)$)|(^([1][89][0][48])(-)(0?2)(-)(29)$)|(^([2-9][0-9][0][48])(-)(0?2)(-)(29)$)|(^([1][89][2468][048])(-)(0?2)(-)(29)$)|(^([2-9][0-9][2468][048])(-)(0?2)(-)(29)$)|(^([1][89][13579][26])(-)(0?2)(-)(29)$)|(^([2-9][0-9][13579][26])(-)(0?2)(-)(29)$))/);
    if(result==null || result=="")
    {
        y.style.color="red";
        y.style.fontSize=5;
        y.innerHTML="出生年月格式错误";
        return false;
    }
    y.style.color="green";
    y.style.fontSize=5;
    y.innerHTML="正确";
    return true;
}
function checkaddress()
{
    var x = document.getElementById("inputaddress").value;
    var y = document.getElementById("label_address");
    if(x==null || x=="")
    {
        y.style.color="red";
        y.style.fontSize=5;
        y.innerHTML="家庭地址不能为空";
        return false;
    }
    y.style.color="green";
    y.style.fontSize=5;
    y.innerHTML="正确";
    return true;
}
function checkjob()
{
    var x = document.getElementById("inputjob").value;
    var y = document.getElementById("label_job");
    if(x==null || x=="")
    {
        y.style.color="red";
        y.style.fontSize=5;
        y.innerHTML="工作不能为空";
        return false;
    }
    y.style.color="green";
    y.style.fontSize=5;
    y.innerHTML="正确";
    return true;
}
function checktelephone()
{

    var val=document.getElementById('inputtelephone').value;
    var y = document.getElementById("label_telephone");
    if (val=null || val=='')
    {
        y.style.color="red";
        y.style.fontSize=5;
        y.innerHTML="请输入手机号!";
        return false;
    }
    if(val.length != 11)
    {
        y.style.color="red";
        y.style.fontSize=5;
        y.innerHTML="输入错误，请重新输入！";
        return false;
    }
    y.style.color="green";
    y.style.fontSize=5;
    y.innerHTML="正确";
    return true;
}
function checkpassword1()
{
    var x = document.getElementById("inputpassword1").value;
    var y = document.getElementById("label_password1");
    if(x==null || x=="")
    {
        y.style.color="red";
        y.style.fontSize=5;
        y.innerHTML="密码不能为空";
        return false;
    }
    else
    {
        if(x.toString().length<6||x.toString().length>16)
        {
            y.style.color="red";
            y.style.fontSize=5;
            y.innerHTML="密码需要6-16位长度";
            return false;
        }
        else
        {
            y.style.color="green";
            y.style.fontSize=5;
            y.innerHTML="正确";
            return true;
        }
    }
}
function checkpassword2()
{
    var x = document.getElementById("inputpassword2").value;
    var z = document.getElementById("inputpassword1").value;
    var y = document.getElementById("label_password2");
    if(x==null || x=="")
    {
        y.style.color="red";
        y.style.fontSize=5;
        y.innerHTML="重复密码不能为空";
        return false;
    }
    if(x.toString()!=z.toString())
    {
        y.style.color="red";
        y.style.fontSize=5;
        y.innerHTML="密码不一致";
        return false;
    }
    y.style.color="green";
    y.style.fontSize=5;
    y.innerHTML="正确";
    return true;
}
function checkemail()
{
    var x = document.getElementById("inputemail").value;
    var y = document.getElementById("label_email");
    if(x==null || x=="")
    {
        y.style.color="red";
        y.style.fontSize=5;
        y.innerHTML="邮箱不能为空";
        return false;
    }
    var atpos=x.indexOf("@");
    var dotpos=x.lastIndexOf(".");
    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.value.length)
    {
        y.style.color="red";
        y.style.fontSize=5;
        alert("不是一个有效的邮箱地址");
        return false;
    }
    y.style.color="green";
    y.style.fontSize=5;
    y.innerHTML="正确";
    return true;
}
function checkmedia_name()
{
    var x = document.getElementById("inputMedia_name").value;
    var y = document.getElementById("label_media_name");
    if(x==null || x=="")
    {
        y.style.color="red";
        y.style.fontSize=5;
        y.innerHTML="名字不能为空";
        return false;
    }
    y.style.color="green";
    y.style.fontSize=5;
    y.innerHTML="正确";
    return true;
}
function checkinvite_code()
{
    var x = document.getElementById("inputinvite_code").value;
    var y = document.getElementById("label_invite_code");
    if(x==null || x=="")
    {
        y.style.color="red";
        y.style.fontSize=5;
        y.innerHTML="邀请码不能为空";
        return false;
    }
    if(x.toString().length!=20)
    {
        y.style.color="red";
        y.style.fontSize=10;
        y.innerHTML="邀请码格式错误";
        return false;
    }
    y.style.color="green";
    y.style.fontSize=5;
    y.innerHTML="正确";
    return true;
}
function  checksex() {
    var x = document.getElementsByName("sex");
    var y = document.getElementById("label_sex");
    for(var i=0;i<name.length;i++)
    {
        if(x[i].checked == true)
        {
            y.style.color="green";
            y.style.fontSize=5;
            y.innerHTML="正确";
            return true;
        }
    }
    y.style.color="red";
    y.style.fontSize=10;
    y.innerHTML="请选择性别";
    return false;
}
