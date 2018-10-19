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
       #head{
           margin: 5px 40%;
           size: 40px;
           font-size: 30px;
       }
       .ahref,#ahref{
           margin: 0px 20px 10px 70%;
           background-position: left;
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
                        console.log("用户名存在");
                        $("#nameWarning1").text("is OK！").css("display","inline");
                        $("#nameWarning").text("").css("display","inline");
                        $("#nameWarning1 ").css("color","lime");
                        $(":submit").attr("disabled",false);
                    }else{
                        console.log("账号不存在");
                    	$("#nameWarning1").text("该账号不存在").css("display","inline");
                        $("#nameWarning").text("").css("display","inline");
                        $("#nameWarning1 ").css("color","red");
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

            $("#nameWarning").focus(function(){
                $("#nameWarning").css("display","none");
            })
        })

    </script>
    
</head>
<body bgcolor="#bdb76b">
      <div id="ahref"><a href="adminLogin.jsp">管理员登录</a></div>
      <div class="ahref"><a href="employeeLogin.jsp">员工登录</a></div>

      <div style="width: 50%;margin: 5px auto;background-color:green;font-size: 26">
          <c:if test="${requestScope.typeError!=null}">
              当前账号已经是员工，请前往员工登录界面。<br>
              或者换个其他账号试试
          </c:if>
      </div>

	  <form action="${pageContext.request.contextPath}/visitorNav" method="post" >
          <div id="head">游客登录</div>
      <table bgcolor="gray" border="2px" align="center">
        <tr>
          <td>用户名：</td>
          <td><input id="name" type="text" name="name"  value="${requestScope.visitor2.name}"></td>
          <c:if test="${requestScope.nameError!=null}">
          <td><span id="nameWarning" class="warning">名字错误</span></td>
         </c:if>
            <td><span id="nameWarning1" class="warning"></span></td>
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
