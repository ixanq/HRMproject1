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
    <title>职位</title>
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
    <script>


    </script>
</head>
<body>
<%@include file="employeeBaseNav.jsp" %>
<div class="head">
    <title class="center">
        <strong>职位信息</strong>
    </title>
    <div class="center">
        <td width="730" height="800" align="center" valign="top" bgcolor="#00FF99">
            <table width="730" height="400" border="2px" cellpadding="0" cellspacing="0" style="background-color: #00aFFF">
                <tr align="center">
                    <td colspan="6" bgcolor="#00FFFF"><strong>职位信息</strong></td>
                </tr>

                <tr>
                    <td>ID</td>
                    <td>职位名称</td>
                    <td>创建时间</td>
                    <td>查看该职位下的员工</td>
                </tr>

                <c:forEach items="${requestScope.workPositions}" var="workPosition">
                    <tr>
                        <td>${workPosition.id}</td>
                        <td>${workPosition.name}</td>
                        <td><f:formatDate value="${workPosition.createTime}"/></td>
                        <td><a  href="${pageContext.request.contextPath}/lookEmployeeUnderworkPosition?workPositionId=${workPosition.id}">查看</a></td>
                    </tr>
                </c:forEach>

                <tr>
                    <td colspan="6"><a href="javaScript:history.back(-1);">返回</a></td>
                </tr>
            </table>
        </td>
    </div>
</div>
</body>
</html>
