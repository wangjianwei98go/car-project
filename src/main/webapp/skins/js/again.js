$(function () {
    /*
    首先判断路径，是否带参。如果不带参，则显示参数不完整
    带参之后判别参数是车辆id还是商家id。然后传入不同后台
    返回数据后返回给不同模板
    */
    onLoad();

    //设置轮播图播放时间
   carouselTime();

    $(".carInfo").hover(function () {
        $(this).toggleClass("mouseEnter");
    }).click(function () {
        var href = $(this).attr("href");
        window.location.href = context + "/jsp/detail.jsp?carId="+href;
    });

    $(".confirm-form").Validform({
        btnSubmit:"#aaa",
        tiptype:3,
        datatype:{
            //参数gets是获取到的表单元素值，obj为当前表单元素，curform为当前验证的表单，regxp为内置的一些正则表达式的引用;
            //后台查询账户是否存在,这里不查询密码，将密码查询放到后台这样安全
            "amount":function(gets,obj,curform,regxp){
                var amount =parseInt($(".car-amount").text());
                if(gets>0&&gets<=amount){
                    return true;
                }
                return false;
            }
        },
        callback:function(data){
            rentagain();
        }
    });

});


function onLoad() {
    var url = window.location.href;
    var params = url.indexOf("?");
    //是否带参
    if (!(params == -1)) {
        var canshu = url.substring(params + 1);
        var index = canshu.indexOf("=");
        if (index != -1){
            //参数类型
            var param = canshu.substring(0,index);
            //参数id
            var id= canshu.substring(index+1);
            //判断是车辆还是商家
            if(param == "carId"){
                ajaxFUN("car",id);
                addActive();
            }else if(param == "shopId"){
                ajaxFUN("shop",id);
            }
        }else {
            $("html").empty().html("<h4>输入参数不完整，请重试！</h4>");
        }
    }else {
        $("html").empty().html("<h4>输入参数不完整，请重试！</h4>");
    }
}
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return decodeURI(r[2]); return null;
}
function ajaxFUN(type,id) {
    $.ajax({
        url: context + "/service/"+type+"/id",
        type: 'GET',
        async: false,
        contentType: "application/json;charset=utf-8",
        data:"id="+id,
        success: function (data) {
            var infoType = data.infoType;
            var info = data.info;
            if(info){
                if(infoType=="car"){
                    $("title").html(info.carBrand + info.carName+"详情页");
                    var temp = template("carResult", {
                        "carResult": info
                    });
                    $(".content").empty().append(temp);
                    var jingdu = info.shopJingDu;
                    var weidu = info.shopWeiDu;
                    /*setPotin(jingdu,weidu);*/
                }else if(infoType=="shop"){
                    $("title").html(info.shopName+"详情页");
                    var temp = template("shopResult", {
                        "shopResult": info
                    });
                    $(".content").empty().append(temp);

                }
            }else {
                $(".content").empty().html("<a href='index.jsp'>对不起，该车辆已下架，请重新选择车辆吧。</a>2秒后自动跳转到首页");
                setTimeout(function () {
                   window.location.href=context+"/jsp/index.jsp";
                },2000);
            }

        },
        error: function () {
            alert("error");
        }
    });
}

function carouselTime() {
    $("#image-around").carousel({
        interval:2000
    });
}

//给车辆模板中的轮播图第一个添加 active 样式
function addActive() {
    $("#image-around>.carousel-inner>.item").eq(0).addClass("active");
}

function rentagain() {
    var  user = getCookie("userName");
    var orderId=getQueryString("orderId");
    var carBrand = $(".car-brand").text();
    var carName = $(".car-name").text();
    var day =$(".day").val();
    var count =$(".count").val();
    var price = $(".price").text();
    var allPrice = price*count*day;
    if(user){
        var d = dialog({
            title:"续租信息",
            content: '您选择了'+carBrand +'  '+carName+',' +
                day+'天，'+count+'辆'+
                '共'+allPrice+'元！',
            okValue: '确认续租',
            ok: function () {
                window.location.href = document.referrer;
                rentagain1(orderId,day,count,allPrice);
            },
            cancelValue: '取消',
            cancel: function () {}
        });
        d.show();
    }else {
        var d = dialog({
            content: '请登录后再选择！',
            okValue: '确定',
            ok: function () {
                window.location.href = context +"/jsp/login.jsp";
            },
            cancelValue: '取消',
            cancel: function () {}
        });
        d.show();
    }
}

function  rentagain1(orderId,day,count,price) {
    var userId=getCookie("userId");
    $.ajax({
        url: context + "/service/order/again",
        type: 'GET',
        async: true,
        contentType: "application/json;charset=utf-8",
        data:{"orderId":orderId,"userId":userId,"price":price,"count":count,"day":day},
        success: function (data) {
        }
    });
    window.location.href = document.referrer;
}
