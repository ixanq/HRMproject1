<%@page import="com.ixanq.entity.Visitor"%>
<%@ page import="com.ixanq.entity.Manager" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>管理员主页</title>
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
<%
    Manager manager=(Manager) request.getAttribute("manager2");
    session.setAttribute("manager", manager);
%>
<%@include file="managerBaseNav.jsp" %>
</body>
</html>