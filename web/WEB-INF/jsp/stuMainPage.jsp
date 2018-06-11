<%--
  Created by IntelliJ IDEA.
  User: thlnkpad
  Date: 2018/5/28
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="jumbotron">
                <h1>
                    正在计费中
                </h1>
                <p>
                    单机下机以离开
                </p>
                <p>
                    <button class="btn btn-primary btn-large logOut" >点击下机</button>
                </p>
            </div>
            <h2>
                上机计时
            </h2>
            <input type="text" id="timetext" value="00时00分00秒" readonly><br>
            <%--<button type="button" class="btn btn-default logOut">点击下机</button>--%>

            <div class="row clearfix">
                <div class="col-md-12 column">
                </div>
            </div>
        </div>
    </div>
</div>


</body>
<script src="https://code.jquery.com/jquery.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript">
    $(document).ready(function () {


        $(".logOut").click(function () {
            var r=confirm("确定要下机吗?");
            if(r===true){
                $.ajax({
                    type:"post",
                    url:"/stu/logOut",
                    data:{
                    },
                    success:function (msg) {
                            window.location.href="http://127.0.0.1:8080/user/index"
                    } ,
                    error:function(textStatus){
                        alert("False!");
                        console.log(textStatus);
                }
                })
            }
        })
    })
</script>
<script type="text/javascript">
    $(document).ready(function () {
        var oTxt=document.getElementsByTagName("input")[0];
        var oStart=document.getElementsByTagName("input")[1];
        var oStop=document.getElementsByTagName("input")[2];
        var oReset=document.getElementsByTagName("input")[3];
        var n= 0, timer=null;
        //开始计时

            clearInterval(timer);
            timer=setInterval(function () {
                n++;
                var h=parseInt(n/3600);
                var m=parseInt(n/60);
                var s=parseInt(n%60);
//             if(m>=60)m=0;
                oTxt.value=toDub(h)+":"+toDub(m)+":"+toDub(s);
            },1000/60);

        //暂停并且清空计时器
        oStop.onclick= function () {
            clearInterval(timer);
        }
        //重置
        oReset.onclick= function () {
            oTxt.value="00:00:00";
            n=0;
        }
        //补零
        function toDub(n){

            return (n%60)<10?"0"+n:""+n%60;
        }
    })
</script>
<script src="https://code.jquery.com/jquery.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>
