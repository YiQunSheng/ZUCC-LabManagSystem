<%@ page language="java" pageEncoding="GB2312" %>

<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
<head>
<title>Lomboz JSP</title>
</head>
<body bgcolor="#FFFFFF">
<%--<form action="user?method=logincheck" method="post">--%>
<form <%--action="${pageContext.request.contextPath} /hello/loginUser" method="post"--%>>
  用户：<input type="text" name="userId"/><br>
  密码：<input type="password" name="pwd"/><br>
  <input type="submit" value="登陆" id="submit1"/><br>
</form>
<%--<%
   String errmsg=(String)session.getAttribute("errormsg");
   if(errmsg!=null){
     session.removeAttribute("errormsg");
     out.println(errmsg);
   }
%>--%>
<script type="text/javascript">
    $(function() {
        $("#submit1").click(function() {
            var json = {
                'username':$(':input[name=userId]').val(),
                'password':$(':input[name=pwd]').val()
            };
            //json字符串 {"username":"admin","password":"123456"}
            var postdata = JSON.stringify(json);//json对象转换json字符串
            alert(postdata);
            $.ajax({
                type : 'POST',
                contentType : 'application/json',//注意类型
                /**
                 *(默认: true) 默认情况下，通过data选项传递进来的数据，如果是一个对象(技术上讲只要不是字符串)，
                 * 都会处理转化成一个查询字符串，以配合默认内容类型 "application/x-www-form-urlencoded"。
                 * 如果要发送 DOM 树信息或其它不希望转换的信息，请设置为 false。
                 */
                processData : false,
                url : '/user/login',
                dataType : 'json',
                data : postdata,
                success : function(data) {
                    alert('username : '+data.username+'\npassword : '+data.password);
                },
                error : function() {
                    alert('error...');
                }
            });
        });
    });
</script>
</body>
</html>