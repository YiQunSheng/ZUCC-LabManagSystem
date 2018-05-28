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
</head>
<body>
   <button type="button" class="btn btn-default logOut">点击下机</button>

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
</html>
