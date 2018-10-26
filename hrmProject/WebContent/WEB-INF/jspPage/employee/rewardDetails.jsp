<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.ixanq.entity.WorkPosition" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>奖惩详情</title>
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
            <strong>奖惩信息</strong>
        </title>
        <div class="center">
            <td width="50%" align="center" valign="top" bgcolor="#00FF99">
                <form action="${pageContext.request.contextPath}/personalRewardMessegess">
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
                        <td colspan="6" bgcolor="#00FFFF"><strong>奖惩信息</strong></td>
                    </tr>

                    <tr>
                        <td>ID</td>
                        <td>员工名称</td>
                        <td>奖惩原因</td>
                        <td>奖惩金额</td>
                        <td>时间</td>
                    </tr>

                    <c:forEach items="${requestScope.rewards}" var="reward">
                        <tr>
                            <td>${reward.id}</td>
                            <td>${sessionScope.employee.realName}</td>
                            <td>${reward.reason}</td>
                            <td>${reward.money}</td>
                            <td><f:formatDate value="${reward.time}"/></td>
                        </tr>
                    </c:forEach>
                    <c:if test="${empty rewards}">
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
