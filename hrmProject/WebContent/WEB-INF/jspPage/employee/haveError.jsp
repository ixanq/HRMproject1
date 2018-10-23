<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ixanq.entity.WorkPosition" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>复议</title>
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
        <strong>复议内容</strong>
    </title>
    <div class="center">
        <td width="50%" align="center" valign="top" bgcolor="#00FF99">
            <form action="${pageContext.request.contextPath}/commitTheError" method="post">
                <table width="55%" style="background-color: #c0a16b">
                    <tr>
                        <td colspan="3">请输入复议内容：</td>
                        <td colspan="1"><input type="submit" value="确定"></td>
                    </tr>
                    <tr>
                        <td>
                            <textarea style="width: 50%;height: 25%" name="content" placeholder="请输入复议内容"></textarea>
                        </td>
                    </tr>
                </table>
            </form>
        </td>
    </div>
</div>
</body>
</html>
