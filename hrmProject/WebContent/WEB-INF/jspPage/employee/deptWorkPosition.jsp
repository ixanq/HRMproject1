<%@page import="com.ixanq.entity.Visitor"%>
<%@ page import="com.ixanq.entity.Employee" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>部门职位</title>
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
<%@include file="employeeBaseNav.jsp" %>
部门职位
</body>
</html>