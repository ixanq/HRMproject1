<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>员工信息</title>
    <style>
        body{
            width: 100%;
            height: 85%;
            background-image: url("/logo/backgrond.jpg");
            background-repeat: repeat;
        }
        #head{
            width: 90%;
            margin: 20px auto;
            text-align: center;
            font-size: 18px;
            text-decoration-color: #677985;
            background-color: #d9534f;
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
    <div style="text-align: center;margin: 0 auto;font-size: 22px">查询结果</div>

        <table width="80%" border="2px" cellpadding="0" cellspacing="0" style="background-color: #00aFFF" align="center">
            <input type="hidden" name="employeeId" value="${requestScope.employee1.id}">
            <tr>
                <td>ID</td>
                <td>姓名：</td>
                <td>性别：</td>
                <td>Email：</td>
            </tr>
            <c:forEach items="${requestScope.employees}" var="employee">
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.realName}</td>
                    <td>${employee.gender}</td>
                    <td>${employee.email}</td>
                </tr>
            </c:forEach>
            <c:if test="${empty requestScope.employees}">
                <tr>
                    <td colspan="4">暂无查询结果</td>
                </tr>
            </c:if>
            <tr>
                <td colspan="4"><a href="javaScript:history.back(-1);">返回</a></td>
            </tr>
        </table>

</div>
</body>
</html>