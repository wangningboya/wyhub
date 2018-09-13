$(function () {
    initMenu();
})


function initMenu() {
    $.post(
        "/findAuthByRoleId",
        {
            roleId:$("#roleId").val()
        },
        function (data) {
            var authList=new Array();
            authList=data;
            var menuLi=""
            for(var i=0;i<authList.length;i++){
                menuLi=menuLi
                    +'<li style="list-style: none;background: white">'
                    +'<a style="text-decoration: none" href="'+authList[i].authUrl+'">'+authList[i].authName+'</a>'
                    +'</li>'
            }
            var menu='<ul>'+menuLi+'</ul>'
            $("#menu").append(menu)
        }
    )
}

var running = false;
var angles=0;
var time;
var interval = undefined;
var startTime;
function xz() {
    if(running){
        stop();
    }else {
        start();
    }
}
function start() {
    //随机旋转时间
    time=Math.random()*1000*7+3000;
    startTime=new Date().getTime();
    angles=0;
    interval = setInterval(function() {
        document.getElementById("zz").style.transform = "rotatez(" + angles + "deg)";
        angles=angles+2;
        if(new Date().getTime()-startTime>time){
            stop();
            return;
        }
    }, 1);
    running = true;
}
function stop() {
    clearInterval(interval);
    running = false;
    var s=0;
    var s2=0;
    for (var i = 0; i < prizeList.length; i++) {
        s2 = s2 + prizeList[i].prizePro;
    }
    for (var i = 0; i < prizeList.length; i++) {
        if(i!=(prizeList.length-1)){
            if((angles%360)>s&&(angles%360)<(s+((prizeList[i].prizePro / s2) * 360))){
                if(prizeList[i].prizeName=="谢谢惠顾"){
                    alert("很遗憾，您未中奖。祝下次好运！");
                }else {
                    alert("恭喜你中了"+prizeList[i].prizeName+"！");
                }
                $.post(
                    "/addUserPrize",
                    {
                        userId:$("#userId").val(),
                        prizeId:prizeList[i].prizeId
                    },
                    function (data) {
                        alert("保存成功！");
                    }
                )
                return;
             }
        }else {
            if(prizeList[prizeList.length-1].prizeName=="谢谢惠顾"){
                alert("很遗憾，您未中奖。祝下次好运！");
            }else {
                alert("恭喜你中了"+prizeList[prizeList.length-1].prizeName+"！");
            }
            $.post(
                "/addUserPrize",
                {
                    userId:$("#userId").val(),
                    prizeId:prizeList[prizeList.length-1].prizeId
                },
                function (data) {
                    alert("保存成功！");
                }
            )
            return;
        }
        s=s+(prizeList[i].prizePro / s2) * 360;
    }
}