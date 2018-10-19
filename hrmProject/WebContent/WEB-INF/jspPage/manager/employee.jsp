<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.ixanq.entity.Visitor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>员工管理</title>
    <style>
        body{
            width: 100%;
            height: 85%;
            background-image: url("/logo/backgrond.jpg");
            background-repeat: repeat;
        }
        #head{
            width: 40%;
            margin: 20px auto;
            text-align: center;
            font-size: 18px;
            text-decoration-color: #677985;
            background-color: #67b168;
        }
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath}\bootstrap\js\jquery-1.7.2.js"></script>
    <script>


    </script>
</head>
<body>
<%@include file="managerBaseNav.jsp" %>
<div id="head">
    <div style="text-align: center;margin: 0 auto;font-size: 22px">员工信息</div>
    <table border="2px"  align="center" style="background-color: green">
        <tr>
            <td>ID</td>
            <td>员工名字</td>
            <td>状态</td>
            <td>修改部门职位</td>
            <td>开除</td>
        </tr>
        <c:forEach items="${requestScope.employees}" var="employee">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.realName}</td>
                <td>${employee.status}</td>
                <td><a href="${pageContext.request.contextPath}/updateEmployeeDepartmentMesseges?id=${employee.id}&&workPositionId=${employee.workPositionId}">修改部门职位</a></td>
                <td><a href="${pageContext.request.contextPath}/outOfTheEmployeeFromWork?id=${employee.id}">开除</a></td>

            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

