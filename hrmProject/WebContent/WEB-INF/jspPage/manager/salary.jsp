<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.ixanq.entity.Visitor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>薪资</title>
    <style>
        body{
            width: 100%;
            height: 85%;
            background-image: url("/logo/backgrond.jpg");
            background-repeat: repeat;
        }
    </style>
    <script src="${pageContext.request.contextPath}/bootstrap/js/jquery-1.7.2.js"></script>
</head>
<body>
<%@include file="managerBaseNav.jsp" %>
${requestScope.allEmployee}
    <table>
        <tr>
            <td>ID</td>
            <td>姓名</td>
            <td>考勤记录</td>
            <td>发放工资</td>
        </tr>

        <c:forEach items="${requestScope.allEmployee}" var="employee">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.realName}</td>
                <td><a href="#">考勤记录</a></td>
                <td><a href="#">发放工资</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>