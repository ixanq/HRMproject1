<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <title>修改密码</title>
    <base href="${pageContext.request.contextPath}/">
    <style>
        body{
            width: 100%;
            height: 85%;
            background-image: url("/logo/backgrond.jpg");
            background-repeat: repeat;
        }
        .head{
            width: 60%;
            margin: 10px auto;
            background-color: #c0a16b;


        }
        .warning{
            color: red;
            display: none;
        }
        #submit{
            background-color: #2aabd2;
        }
        #div1{
            margin: 5px 40%;
            size: 40px;
            font-size: 30px;
        }

        #ahref{
            margin: 0px 20px 10px 70%;
            background-position: left;
        }
    </style>
    <script src="${pageContext.request.contextPath}/bootstrap/js/jquery-1.7.2.js"></script>
    <script>
        $(function(){
            $("form").submit(function(){
                var password=$("#password").val();
                var password1=$("#password1").val();
                var password2=$("#password2").val();

                if(password==""||password==null){
                    $("#passwordWarning").text("密码不能为空").css("color","red");
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
                if(password1!=password2){
                    $(".warning").eq(2).css("display","inline");
                    return false;
                }else {
                    $(".warning").eq(2).css("display","none");
                }
            })
        })
    </script>
</head>
<body bgcolor="#bdb76b">
    <%@include file="employeeBaseNav.jsp" %>
    ${requestScope.originPasswordError}
    <div class="head">
        <form action="${pageContext.request.contextPath}/updatePWDandCommit" method="post" >
            <div id="div1">修改密码</div>
            <table bgcolor="lime" border="2px" align="center">
                <tr>
                    <td>原始密码：</td>
                    <td><input id="password" type="password" name="oPassword"></td>
                    <td>
                        <span id="passwordWarning" style="display: inline;" class="warning">
                            <c:if test="${requestScope.originPasswordError!=null}">密码错误</c:if>
                        </span>
                     </td>
                </tr>

                <tr>
                    <td>新密码：</td>
                    <td><input id="password1" type="password" name="password"></td>`
                    <td><span id="password1Warning" class="warning">新密码不能为空</span></td>
                </tr>

                <tr>
                    <td>密码确认：</td>
                    <td><input id="password2" type="password"></td>
                    <td><span id="password2Warning" class="warning">密码不一致</span></td>
                </tr>

                <tr>
                    <td colspan="2" style="text-align: center"><input id="submit" type="submit" value="保存修改"></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
