<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        #head{
            width: 70%;
            margin: 20px auto;
            text-align: center;
            font-size: 18px;
            text-decoration-color: #677985;
            background-color: #67b168;
        }
        tr,td{
            text-align: center;
        }
    </style>
    <script src="${pageContext.request.contextPath}/bootstrap/js/jquery-1.7.2.js"></script>
</head>
<body>
<%@include file="employeeBaseNav.jsp" %>
    <div id="head">
        <table border="2px"  align="center" style="background-color: green;width: 65%">
            <tr>
                <td>ID</td>
                <td>部门名称</td>
                <td>查看职位</td>
            </tr>
            <c:forEach items="${requestScope.allDepartment}" var="department">
                <tr>
                    <td>${department.id}</td>
                    <td>${department.name}</td>
                    <td><a href="${pageContext.request.contextPath}/lookDepartmentWorkPosirionInEmployee?departmentId=${department.id}">查看职位</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="4"><a href="javaScript:history.back(-1);">返回</a></td>
            </tr>
        </table>
    </div>
</body>
</html>