<%--
  Created by IntelliJ IDEA.
  User: shengyiqun
  Date: 2018/5/24
  Time: 下午2:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="https://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $(".btn1").click(function(){
            $.ajax({
                data:{
                    id:$("#userId").val(),
                    name:"testName"
                },
                type:"POST",
                url:"/user/ajaxTest",
                success:function (msg) {
                    alert(msg);
                },
                error:function () {
                    alert("False!!!");
                }
            })

        });
    });
    function alt() {
        alert("alalal");
    }
</script>
<body>
<input type="text" id="userId">
<input type="button" class="btn1" value="testAjax">
</body>

</html>
