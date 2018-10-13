<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/12
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <title>登录界面</title>
     <style>
       .warning{
       background-color:#222222;
        color: red;
      } 

    </style>
     <script src="${pageContext.request.contextPath}/bootstrap/js/jquery-1.7.2.js"></script>
    <script>

        $(function(){
            $("input:eq(0)").blur(function(){
                var name=$("#name").val();
                var url="${pageContext.request.contextPath}/ajaxCheck";
                var args={"name":name};
                $.post(url,args,function(data){
                    if(data=="no"){
                        //用户名存在
                        $("#nameWarning").text("is OK！").css("display","inline");
                        $("#nameWarning ").css("color","lime");
                        $(":submit").attr("disabled",false);
                    }else{
                    	$("#nameWarning").text("该账号不存在").css("display","inline");
                        $("#nameWarning ").css("color","red");
                        //按钮禁用
                        $(":submit").attr("disabled",false);
                    }
                })
            })
        })

        $(function(){
            $("form").submit(function(){
                var name=$("input").eq(0).val();
                var password1=$("input").eq(1).val();
                if(name==""){
                	$("#nameWarning").text("名字错误").css("color","red");
                    $(".warning").eq(0).css("display","inline");
                    return false;
                }else {
                    $(".warning").eq(0).css("display","none");
                }
                if(password1==""){
                    $(".warning").eq(1).css("display","inline");
                    return false;
                }else {
                    $(".warning").eq(1).css("display","none");
                }
            })
        }) 
    </script>
    
</head>
<body>
	  <form action="visitorNav" method="post" >
      <table bgcolor="gray" border="2px" align="center">
        <tr>
          <td>用户名：</td>
          <td><input id="name" type="text" name="name" value="${requestScope.visitor2.name}"></td>
          <c:if test="${requestScope.nameError!=null}">
          <td><span id="nameWarning" class="warning">名字错误</span></td>
         </c:if>
        </tr>

        <tr>
          <td>密&nbsp;码：</td>
          <td><input id="password1" type="password" name="password"></td>
          <c:if test="${requestScope.passwordError!=null}">
          <td><span id="password1Warning" class="warning">密码错误</span></td>
         </c:if>
        </tr>

        <tr>
          <td colspan="2" style="text-align: center"><input  type="submit" value="登录"></td>
        </tr>
        
        <tr>
          <td colspan="2" style="text-align: center">账号不存在? <a href="${pageContext.request.contextPath}/index.jsp">注册</a></td>
        </tr>
      </table>
    </form>
	
</body>
</html>
