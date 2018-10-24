<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ixanq.entity.WorkPosition" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>职位下的员工信息</title>
    <style>
        body{
            width: 100%;
            height: 85%;
            background-image: url("/logo/backgrond.jpg");
            background-repeat: repeat;
        }
        .head{
            width: 100%;
            height: 85%;
            background-image: url("/logo/backgrond.jpg");
            background-repeat: repeat;
        }
        .center{
            width: 900px;
            height: 850px;
            margin:0 auto;
            margin-left:300px ;
        }

        td,tr{
            text-align: center;
        }
    </style>
    <script src="${pageContext.request.contextPath}/bootstrap/js/jquery-1.7.2.js"></script>
    <script>


    </script>
</head>
<body>
<%@include file="employeeBaseNav.jsp" %>

<div class="head">
    <title class="center">
        <strong>职位下的员工</strong>
    </title>
    <div class="center">
        <td width="730" height="800" align="center" valign="top" bgcolor="#00FF99">
            <table width="730" height="400" border="2px" cellpadding="0" cellspacing="0" style="background-color: #00aFFF">
                <tr align="center">
                    <td colspan="6" bgcolor="#00FFFF"><strong>员工通讯录</strong></td>
                </tr>

                <tr>
                    <td>ID</td>
                    <td>员工名称</td>
                    <td>年龄</td>
                    <td>学位</td>
                    <td>Email</td>
                    <td>状态</td>
                </tr>

                <c:forEach items="${requestScope.employees}" var="employee">
                    <tr>
                        <td>${employee.id}</td>
                        <td>${employee.realName}</td>
                        <td>${employee.age}</td>
                        <td>${employee.degree}</td>
                        <td>${employee.email}</td>
                        <td>${employee.status}</td>
                    </tr>
                </c:forEach>

                <tr>
                    <td colspan="6"><a href="javaScript:history.back(-1);">返回</a></td>
                </tr>
            </table>
        </td>
    </div>
</div>
</body>
</html>
