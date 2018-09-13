$(function () {
    init();
})

//画扇形
CanvasRenderingContext2D.prototype.sector = function (x, y, radius, sDeg, eDeg) {
// 初始保存
    this.save();
// 位移到目标点
    this.translate(x, y);
    this.beginPath();
// 画出圆弧
    this.arc(0, 0, radius, sDeg, eDeg);
// 再次保存以备旋转
    this.save();
// 旋转至起始角度
    this.rotate(eDeg);
// 移动到终点，准备连接终点与圆心
    this.moveTo(radius, 0);
// 连接到圆心
    this.lineTo(0, 0);
// 还原
    this.restore();
// 旋转至起点角度
    this.rotate(sDeg);
// 从圆心连接到起点
    this.lineTo(radius, 0);
    this.closePath();
// 还原到最初保存的状态
    this.restore();
    return this;
}
//前几次角度之和
var sum2;
var prizeList;
function init() {
    $.post(
        "/getPrizeList",
        {},
        function (data, status) {
            if (status == "success") {
                prizeList = new Array();
                prizeList = data;

                //算概率总和
                var sum = 0;
                for (var i = 0; i < prizeList.length; i++) {
                    sum = sum + prizeList[i].prizePro;
                }
                sum2= 0;
                var zp = document.getElementById('cvs').getContext('2d');
                var deg = Math.PI / 180;
                var prizeTableModel = "";
                for (var i = 0; i < prizeList.length; i++) {

                    //根据概率算本次角度
                    var angle = (prizeList[i].prizePro / sum) * 360;

                    //270为垂直Y轴开始
                    zp.fillStyle = prizeList[i].prizeColor;
                    zp.sector(800 / 2, 300, 300, (270 + sum2) * deg, (270 + sum2 + angle) * deg).fill();
                    //算前几次角度和
                    sum2 = sum2 + angle;
                    //奖品列表
                    prizeTableModel += '<tr><td width="80px" style="color: ' + prizeList[i].prizeColor + '">' + prizeList[i].prizeName + '</td><td style="background:  ' + prizeList[i].prizeColor + ';width: 50px">' + '</td></tr>'
                }
                //加入奖品列表
                var prizeTable;
                prizeTable = '<table border="0">'
                    + prizeTableModel
                    + '</table>';
                $("#prizeTable").append(prizeTable);
            }
        }
    )

}



