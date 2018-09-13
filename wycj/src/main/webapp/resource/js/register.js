var flag=true;
function register() {
    if(!flag){
        alert("用户名重复！！！");
        return;
    }
    if ($("#userAccount").val() == null || $("#userAccount").val() == "") {
        alert("请输入账号！！！");
        return;
    } else if ($("#userPwd").val() == null || $("#userPwd").val() == "") {
        alert("请输入密码！！！");
        return;
    } else if ($("#userName").val() == null || $("#userName").val() == "") {
        alert("请输入姓名！！！");
        return;
    } else if ($("#userTel").val() == null || $("#userTel").val() == "") {
        alert("请输入手机号！！！");
        return;
    } else if ($("#userEmail").val() == null || $("#userEmail").val() == "") {
        alert("请输入邮箱！！！");
        return;
    } else if ($("#userSex").val() == null || $("#userSex").val() == "") {
        alert("请输入性别！！！");
        return;
    } else if ($("#userAddress").val() == null || $("#userAddress").val() == "") {
        alert("请输入收货地址！！！");
        return;
    }
    $.post(
        "/register2",
        {
            userAccount: $("#userAccount").val(),
            userPwd: $("#userPwd").val(),
            userName: $("#userName").val(),
            userTel: $("#userTel").val(),
            userEmail: $("#userEmail").val(),
            userSex: $("#userSex").val(),
            userAddress: $("#userAddress").val()
        },
        function (data, status) {
            if (status == "success") {
                if (data == "1") {
                    alert("注册成功！！！");
                    window.location.href = "/index"
                } else {
                    alert("注册失败！！！");
                }
            }
        }
    )
}

function checkAccount(obj) {
    var accountList=new Array();
    $.post(
        "/checkAccount",
        {},
        function (data) {
            for(var i=0;i<data.length;i++){
                if($(obj).val()==data[i]){
                    document.getElementById("check").style.display="inline";
                    flag=false;
                    return;
                }else {
                    document.getElementById("check").style.display="none";
                    flag=true;
                }
            }
        }
    )
}