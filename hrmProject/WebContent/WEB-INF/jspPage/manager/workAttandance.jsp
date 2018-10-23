<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.ixanq.entity.Visitor"%>
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
</head>
<body>
<%@include file="managerBaseNav.jsp" %>
<div class="head">
    <title class="center">
        <strong>员工信息</strong>
    </title>
    <div class="center">
        <td width="730" height="800" align="center" valign="top" bgcolor="#00FF99">
            <table width="730" height="400" border="2px" cellpadding="0" cellspacing="0" style="background-color: #00aFFF">
                <tr align="center">
                    <td colspan="6" bgcolor="#00FFFF"><strong>员工信息</strong></td>
                </tr>

                <tr>
                    <td>ID</td>
                    <td>员工名称</td>
                    <td>查看考勤记录</td>
                    <td>查看奖惩记录</td>
                    <td>查看薪资</td>
                </tr>

                <c:forEach items="${requestScope.employees}" var="employee">
                    <tr>
                        <td>${employee.id}</td>
                        <td>${employee.realName}</td>
                        <td><a href="${pageContext.request.contextPath}/lookThisDetailsAttandance?employeeId=${employee.id}">查看考勤记录</a></td>
                        <td><a href="${pageContext.request.contextPath}/lookThisDetailsRewards?employeeId=${employee.id}">查看奖惩记录</a></td>
                        <td><a href="${pageContext.request.contextPath}/lookThisDetailsSalary?employeeId=${employee.id}">查看薪资</a></td>
                    </tr>
                </c:forEach>
                <c:if test="${empty attendances}">
                    <tr>
                        <td colspan="5">暂无信息</td>
                    </tr>
                </c:if>
                <tr>
                    <td colspan="5"><a href="javaScript:history.back(-1);">返回</a></td>
                </tr>
            </table>
        </td>
    </div>
</div>
</body>
</html>