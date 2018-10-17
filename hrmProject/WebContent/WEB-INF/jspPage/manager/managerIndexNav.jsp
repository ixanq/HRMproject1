<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        #addseccessfuly{
            width: 50%;
            height:30%;
            margin: 40px auto;
            text-align: center;
            font-size: 32px;
            text-decoration-color: green;
            background-color: #c0a16b;
        }
    </style>
    <script src="${pageContext.request.contextPath}/bootstrap/js/jquery-1.7.2.js"></script>
</head>
<body>
<%@include file="managerBaseNav.jsp" %>
    <div id="addseccessfuly">
        <c:if test="${requestScope.thereAreMesseges!=null}">
            您有未读简历，请前往阅读
        </c:if>
        <c:if test="${requestScope.thereIsNoMesseges!=null}">
            您暂时未收到简历信息，请填写招聘信息
        </c:if>
        <c:if test="${requestScope.messegesIsDelete!=null}">
            招聘信息被删光了，请进行其他操作
        </c:if>
        <c:if test="${requestScope.empityResumeMasseges!=null}">
            没有招聘信息，请进行其他操作
        </c:if>



    </div>
</body>
</html>