<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="com.ixanq.entity.Visitor"%>
<%@ page import="com.ixanq.entity.Employee" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>培训信息</title>
    <style>
        body{
            width: 100%;
            height: 85%;
            background-image: url("/logo/backgrond.jpg");
            background-repeat: repeat;
        }
        #head{
            width: 85%;
            margin: 20px auto;
            text-align: center;
            font-size: 18px;
            text-decoration-color: #677985;
            background-color: #67b168;
        }
    </style>
    <script src="${pageContext.request.contextPath}/bootstrap/js/jquery-1.7.2.js"></script>
</head>
<body>
<%@include file="employeeBaseNav.jsp" %>
    <div id="head">
        <table align="center" width="80%" border="2px" cellpadding="0" cellspacing="0" style="background-color: #00aFFF">
            <tr>
                <td>ID：</td>
                <td>培训名称：</td>
                <td>培训时间：</td>
                <td>部门：</td>
            </tr>
            <tr>
                <td>${requestScope.train.id}</td>
                <td>${requestScope.train.name}</td>
                <td><f:formatDate value="${requestScope.train.trainTime}"/></td>
                <td>${requestScope.train.department}</td>
            </tr>

            <tr>
                <td colspan="4">
                    <a href="javaScript:history.back(-1);">返回</a>
                </td>
            </tr>
        </table>
    </div>
</body>
</html>