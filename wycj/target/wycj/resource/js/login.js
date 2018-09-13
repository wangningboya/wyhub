function login() {

    if($("#userAccount").val()==""||$("#userAccount").val()==null){
        alert("请输入账号！！！");
        return;
    }else if($("#userPwd").val()==""||$("#userPwd").val()==null){
        alert("请输入密码");
        return;
    }

    $.post(
        "/login2",
        {
            userAccount:$("#userAccount").val(),
            userPwd:$("#userPwd").val()
        },
        function (data,status) {
            if(status=="success"){
                // alert("data:"+data+"status:"+status);
                if(data==""||data==null){
                    alert("账号不存在！！！");
                    window.location.href="/register"
                }else if(data.userPwd==""||data.userPwd==null){
                    alert("账号或密码错误！！！")
                }else{
                    // document.cookie="userAccount="+data.userAccount;
                    // document.cookie="userPwd="+data.userPwd;
                    alert("登陆成功！！！");
                    window.location.href="/index"
                }
            }

    })
}