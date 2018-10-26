<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.List" %>
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
        .head{
            width: 100%;
        }
        .center{
            width: 900px;
            margin:0 auto;
            margin-left:300px ;
        }

        td,tr{
            text-align: center;
        }
    </style>
    <script src="${pageContext.request.contextPath}/bootstrap/js/jquery-1.7.2.js"></script>
    <script>


    </script>
</head>
<body>
<%@include file="employeeBaseNav.jsp" %>
<div class="head">
    <title class="center">
        <strong>考勤记录</strong>
    </title>
    <div class="center">
        <td width="50%" align="center" valign="top" bgcolor="#00FF99">
            <form action="${pageContext.request.contextPath}/personalCheckWorkAttandanceMessegess">
                <table width="55%" style="background-color: #c0a16b">
                    <tr>
                        <td><input type="number" name="year" placeholder="yyyy">年</td>
                        <td><input type="number" name="month" placeholder="MM"> 月</td>
                        <td><input type="submit" value="搜索"></td>
                    </tr>
                </table>
            </form>
        </td>
        <td width="730" height="800" align="center" valign="top" bgcolor="#00FF99">
            <table width="730" height="400" border="2px" cellpadding="0" cellspacing="0" style="background-color: #00aFFF">
                <tr align="center">
                    <td colspan="6" bgcolor="#00FFFF"><strong>考勤记录</strong></td>
                </tr>

                <tr>
                    <td>ID</td>
                    <td>员工名称</td>
                    <td>上班时间</td>
                    <td>下班时间</td>
                    <td>上班</td>
                    <td>下班</td>
                </tr>

                <c:forEach items="${requestScope.attendances}" var="attendance">
                    <tr>
                        <td>${attendance.id}</td>
                        <td>${sessionScope.employee.realName}</td>
                        <td><f:formatDate value="${attendance.beginWork}" pattern="yyyy-MM-dd HH:MM:ss"/></td>
                        <td><f:formatDate value="${attendance.endWork}" pattern="yyyy-MM-dd HH:MM:ss"/></td>
                        <td>${attendance.isLate}</td>
                        <td>${attendance.isLeave}</td>
                    </tr>
                </c:forEach>
                <c:if test="${empty attendances}">
                    <tr>
                        <td colspan="6">暂无信息</td>
                    </tr>
                </c:if>
                <tr>
                    <td colspan="6"><a href="javaScript:history.back(-1);">返回</a></td>
                </tr>
            </table>
        </td>
    </div>
</div>
</body>
</html>
