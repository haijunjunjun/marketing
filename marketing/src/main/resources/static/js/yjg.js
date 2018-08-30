function yunjiagongToast(msg) {
    if (msg == "") {
        return;
    }
    var msgStr = msg.toString();
    var len = 0;
    var str = '<div class="yz_toastRem" id="yzToastRem">' + msgStr + "</div>";
    //toast弹出框(rem版本)--王凯强
    for (var i = 0; i < msgStr.length; i++) { //遍历字符串长度  
        if (msgStr.charCodeAt(i) > 127 || msgStr.charCodeAt(i) == 94) {
            len += 2;
        } else {
            len++;
        }
    }
    document.getElementsByTagName("body").item(0).insertAdjacentHTML("beforeend", str);
    setTimeout(function () {
        if (len > 47) { //动态改变toast的宽度
            document.getElementById("yzToastRem").style.width = 8 + "rem";
            document.getElementById("yzToastRem").style.bottom = 40 + "%";
            document.getElementById("yzToastRem").style.whiteSpace = "normal";
        } else {
            document.getElementById("yzToastRem").style.width = len * 0.175 + "rem";
            document.getElementById("yzToastRem").style.whiteSpace = "nowrap";
        }
        ;
        document.getElementById("yzToastRem").style.opacity = 0.9;
        document.getElementById("yzToastRem").innerText = msg;
        setTimeout(function () {
            document.getElementById("yzToastRem").parentNode.removeChild(document.getElementById("yzToastRem"));
        }, 3000);
    }, 400);
};