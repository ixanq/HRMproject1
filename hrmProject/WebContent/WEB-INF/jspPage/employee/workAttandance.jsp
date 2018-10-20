<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.ixanq.entity.Visitor"%>
<%@ page import="com.ixanq.entity.Employee" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>考勤记录</title>
    <style>
        body{
            width: 100%;
            height: 85%;
            background-image: url("/logo/backgrond.jpg");
            background-repeat: repeat;
        }
        .right{
            width: 20%;
            height: 30%;
            margin: 20px 0 90% 70%;
            background-color: azure;
        }

        .center{
            width: 45%;
            height: 25%;
            margin: 10px auto;
            background-color: #c0a16b;
            text-align: center;
            font-size: 32px;
        }
    </style>
    <script src="${pageContext.request.contextPath}/bootstrap/js/jquery-1.7.2.js"></script>
</head>
<body>
    <%@include file="employeeBaseNav.jsp" %>
    <div class="right">
        <td><a href="addworkAttendenceForEmployee">上班签到</a></td>&nbsp;&nbsp;&nbsp;&nbsp;<td><a a href="addworkAttendenceForEmployee">下班签到</a></td>
    </div>
    <div class="center">

        <c:if test="${requestScope.youHaveAlreadyWorkAtendance!=null}">
            您上班打卡已经打过了，不能再次签到<br>
        </c:if>
        <c:if test="${requestScope.WorkAtendanceIsInTime!=null}">
            打卡成功!<br>
        </c:if>

    </div>
</body>
</html>