<%--
  Created by IntelliJ IDEA.
  User: ytuln
  Date: 2018/2/28
  Time: 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传车辆信息</title>
    <link rel="shortcut icon" type="image/x-icon" href="../skins/images/car.ico" media="screen" />
    <link rel="stylesheet" type="text/css" href="../skins/css/public/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../skins/css/public/validform.css">
    <link rel="stylesheet" type="text/css" href="../skins/css/public/autocomplete.css">
    <link rel="stylesheet" type="text/css" href="../skins/css/public/header.css">
    <link rel="stylesheet" type="text/css" href="../skins/css/public/footer.css">
    <link rel="stylesheet" type="text/css"  href="../skins/css/car.css">
</head>
<body>
<!--Import the head.jsp -->
<jsp:include page="public/header.jsp"></jsp:include>
    <div class="content">

        <form class="message" action="<%=request.getContextPath()%>/service/car/insert" enctype="multipart/form-data" method="post">
            <table class="table table-bordered message_table">
                <tr>
                    <td>上传图片</td>
                    <td class="images-td">
                        <button class="btn btn-default upload-image">上传图片</button>
                    </td>
                </tr>
                <tr>
                    <td>商家名称：</td>
                    <td>
                        <input class="shopName" type="text" name="shopName" placeholder="请输入商家名称">
                    </td>
                </tr>
                <tr>
                    <td>品牌：</td>
                    <td>
<%--
                        <input class="carBrand" type="text" name="carBrand" placeholder="请输入车辆所属品牌" datatype="*">
--%>
                        <select name="carBrand" id="carBrand" style="width: 480px">
                            <option value="请选择车辆品牌">请选择车辆品牌</option>
                            <option value="别克" > 别克</option> <option value="大众" > 大众</option>
                            <option value="标致" > 标致</option> <option value="日产" > 日产</option>
                            <option value="宝马" > 宝马</option> <option value="Jeep" >Jeep</option>
                            <option value="马自达" > 马自达</option> <option value="沃尔沃" > 沃尔沃</option>
                            <option value="丰田" > 丰田</option> <option value="法拉利" >法拉利</option>
                            <option value="奔驰" > 奔驰</option> <option value="比亚迪" > 比亚迪</option>
                            <option value="路虎" > 路虎</option> <option value="林肯" > 林肯</option>
                            <option value="雷诺" > 雷诺</option> <option value="英菲蒂尼" > 英菲蒂尼</option>
                            <option value="特斯拉" >特斯拉</option> <option value="玛莎拉蒂" > 玛莎拉蒂</option>
                        </select>

                    </td>
                </tr>
                <tr>
                    <td>名称：</td>
                    <td><input class="carName" type="text" name="carName" placeholder="请输入车辆名称" datatype="*">

                    </td>
                </tr>
                <tr>
                    <td>类型：</td>
                    <td>
                        <select name="carType" id="carType" style="width: 480px">
                            <option value="请选择车辆类型">请选择车辆类型</option>
                            <option value="SUV" > SUV</option> <option value="紧凑型车" > 紧凑型车</option>
                            <option value="卡车" > 卡车</option> <option value="皮车" > 皮车</option>
                            <option value="货车" > 货车</option> <option value="MPV" >商务车</option>
                            <option value="跑车" >跑车</option>
                            </select>
                    </td>
                </tr>
                <tr>
                    <td>价格：/元</td>
                    <td><input class="carPrice" type="text" name="carPrice" placeholder="请输入车辆价格" datatype="n">

                    </td>
                </tr>
                <tr>
                    <td>总数量：</td>
                    <td><input class="carAmount" type="number" name="carAmount" placeholder="请输入车辆数量" datatype="*">

                    </td>
                </tr>
                <tr>
                    <td>载人数：</td>
                    <td><input class="carPeople" type="number" name="carPeople" placeholder="请输入最大载人数" datatype="*">

                    </td>
                </tr>
                <tr>
                    <td>载货量：/吨</td>
                    <td><input class="carGood" type="number" name="carGood" placeholder="请输入最大载货量/吨" datatype="*">

                    </td>
                </tr>
                <tr>
                    <td>里程数：</td>
                    <td><input class="carMilage" type="number" name="carMilage" placeholder="请输入已跑里程数" datatype="*">

                    </td>
                </tr>
                <tr>
                    <td>购买日期：</td>
                    <td><input class="carTime" type="date" name="carTime" placeholder="请输入购买日期" datatype="*">

                    </td>
                </tr>
                <tr>
                    <td>介绍：</td>
                    <td>
                    <textarea class="car-info-textArea" name="carInfo" placeholder="请填写车辆介绍" datatype="*">
                    </textarea>

                    </td>
                </tr>
                <tr>
                    <td colspan="2" class="btn-td">
                        <button class="btn btn-primary submit">提交</button>&nbsp;
                        <button type="reset" class="btn btn-default reset">重置</button>
                    </td>
                </tr>
            </table>
        </form>

        <div class="images-show">

        </div>
    </div>
<!--Import the footer.jsp -->
<jsp:include page="public/footer.jsp"></jsp:include>
</body>

<script type="text/html" id="resultList">
   <form class="message" action="<%=request.getContextPath()%>/service/car/update" enctype="multipart/form-data" method="post">
        <table class="table table-bordered message_table">
            <tr>
                <td>上传图片</td>
                <td class="images-td"><button type="button" class="btn btn-default upload-image">上传图片</button></td>
            </tr>
            <tr>
                <td>商家名称：</td>
                <td>
                    <input class="shopName" type="text" name="shopName" placeholder="请输入商家名称" value="{{result.shopName}}">
                </td>
            </tr>
            <tr>
                <td>品牌：</td>
                <td><input type="text" name="carBrand" placeholder="请输入车辆所属品牌" datatype="*" value="{{result.carBrand}}">
                    
                </td>
            </tr>
            <tr>
                <td>名称：</td>
                <td><input type="text" name="carName" placeholder="请输入车辆名称" datatype="*" value="{{result.carName}}">
                    
                </td>
            </tr>
            <tr>
                <td>类型：</td>
                <td><input type="text" name="carType" placeholder="请输入车辆类型" datatype="*" value="{{result.carType}}">
                    
                </td>
            </tr>
            <tr>
                <td>价格：/元</td>
                <td><input type="text" name="carPrice" placeholder="请输入车辆价格" datatype="n" value="{{result.carPrice}}">
                    
                </td>
            </tr>
            <tr>
                <td>总数量：</td>
                <td><input type="number" name="carAmount" placeholder="请输入车辆数量" datatype="*" value="{{result.carAmount}}">
                    
                </td>
            </tr>
            <tr>
                <td>载人数：</td>
                <td><input type="number" name="carPeople" placeholder="请输入最大载人数" datatype="*" value="{{result.carPeople}}">
                    
                </td>
            </tr>
            <tr>
                <td>载货量：/吨</td>
                <td><input type="number" name="carGood" placeholder="请输入最大载货量/吨" datatype="*" value="{{result.carGood}}">
                    
                </td>
            </tr>
            <tr>
                <td>里程数：</td>
                <td><input type="number" name="carMilage" placeholder="请输入已跑里程数" datatype="*" value="{{result.carMilage}}">

                </td>
            </tr>
            <tr>
                <td>购买日期：</td>
                <td><input type="date" name="carTime" placeholder="请输入购买日期" datatype="*" value="{{result.carTime}}">
                    
                </td>
            </tr>
            <tr>
                <td>介绍：</td>
                <td>
                    <textarea class="car-info-textArea" name="carInfo" placeholder="请填写车辆介绍" datatype="*">
                        {{result.carInfo}}
                    </textarea>
                    
                </td>
            </tr>
            <tr>
                <td colspan="2" class="btn-td">
                    <button class="btn btn-primary submit">提交</button>&nbsp;
                    <button type="reset" class="btn btn-default reset">重置</button>
                </td>
            </tr>
        </table>
    </form>
   <div class="images-show">
       {{each result.carImages as image}}
       <div class='image-par old-image-par' imagePath="{{image}}"><img class='car-images' src='<%=request.getContextPath()%>/skins/images/{{image}}'/><a onclick='deleteOldImage(this)'>删除</a></div>
       {{/each}}
   </div>
</script>

<script type="text/javascript">
    var context = "<%=request.getContextPath()%>";
</script>


<script type="text/javascript">
    var imgurl = "";
    function getImgURL(node) {
        var imgURL = "";
        try{
            var file = null;
            if(node.files && node.files[0] ){
                file = node.files[0];
            }else if(node.files && node.files.item(0)) {
                file = node.files.item(0);
            }
            //Firefox 因安全性问题已无法直接通过input[file].value 获取完整的文件路径
            try{
                //Firefox7.0
                imgURL =  file.getAsDataURL();
                //alert("//Firefox7.0"+imgRUL);
            }catch(e){
                //Firefox8.0以上
                imgRUL = window.URL.createObjectURL(file);
                //alert("//Firefox8.0以上"+imgRUL);
            }
        }catch(e){      //这里不知道怎么处理了，如果是遨游的话会报这个异常
            //支持html5的浏览器,比如高版本的firefox、chrome、ie10
            if (node.files && node.files[0]) {
                var reader = new FileReader();
                reader.onload = function (e) {
                    imgURL = e.target.result;
                };
                reader.readAsDataURL(node.files[0]);
            }
        }
        //imgurl = imgURL;
        createImg(imgRUL);
        return imgURL;
    }

    function createImg(imgRUL){   //根据指定URL创建一个Img对象
        var textHtml = "<div class='image-par'><img class='car-images' src='"+imgRUL+"'/><a onclick='deleteImage(this)'>删除</a></div>";
        $(".images-show").append(textHtml);
    }

    function getcarBrand() {
        var url=context+"/service/car/getcarBrand";
        $.ajax({
            url: url,
            type:"get",
            dataType: "json",
            success:function (data){
                var selectOption = "";
                selectOption += "<option></option>";
                $.each(data, function(n, value) {
                    // alert(n+" --"+JSON.stringify(value));
                    selectOption+="<option value="+value.s_value+">"+value.s_label+"</option>"
                });
                $('#selectbox').html(selectOption);
            }
        });
    }
</script>

<script type="text/javascript" src="../skins/js/public/jquery.js"></script>
<script type="text/javascript" src="../skins/js/public/bootstrap.js"></script>
<script type="text/javascript" src="../skins/js/public/public.js"></script>
<script type="text/javascript" src="../skins/js/public/Validform.js"></script>
<script type="text/javascript" src="../skins/js/public/header.js"></script>
<script type="text/javascript" src="../skins/js/public/arttemplate.js"></script>
<script type="text/javascript" src="../skins/js/public/autocomplete.js"></script>
<script type="text/javascript" src="../skins/js/car.js"></script>
</html>
