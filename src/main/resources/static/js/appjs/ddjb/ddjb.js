//初始化方法
$(function () {// 初始化内容
    document.getElementById("goodsDiv").style.display = "none";
});

function linkGenerate() {
    var arr = $('#ddjbform').serializeArray();
    var data = {};
    $.each(arr, function (i, obj) {
        data[obj.name] = obj.value;
    });

    $.ajax({
        url: "/ddjb/linkGenerate?" + "goodsId=" + data.goodsId,//url
        dataType: "json",//返回的数据类型
        type: "get",//发起请求的方式
        success: function (data) {
            //String mobile_url; //唤醒拼多多app的推广长链接
            //String pid;  //pid
            console.log("data:  " + JSON.stringify(data));
            $("#linkContent").val(data.mobile_url);
            $("#pid").val(data.pid);
            document.getElementById("goodsDiv").style.display = "inline";
        },
        error: function (data) {
            console.log(JSON.stringify(data));
        }
    });
}

function copyLink() {
    var val = document.getElementById('linkContent');
    var vals = $('#linkContent').val();
    if (vals ==="" || vals == null){
    alert("内容为空,无法复制");
    }else{
        window.getSelection().selectAllChildren(val);
        document.execCommand("Copy");
        alert("复制成功");
    }
}