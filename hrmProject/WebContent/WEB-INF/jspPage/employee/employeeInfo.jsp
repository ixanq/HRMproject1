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
    <div style="text-align: center;margin: 0 auto;font-size: 22px">员工信息</div>

    <form  action="${pageContext.request.contextPath}/updateEmployeeInfoToDb" method="post">
        <table width="80%" border="2px" cellpadding="0" cellspacing="0" style="background-color: #00aFFF" align="center">
            <input type="hidden" name="employeeId" value="${requestScope.employee1.id}">
            <tr>
                <td>真实姓名：</td>
                <td><input type="text" name="realName" value="${requestScope.employee1.realName}"></td>

                <td>性别：</td>
                <td>
                <input type="radio" name="gender" value="男" <c:if test="${requestScope.employee1.gender eq '男'}">checked="checked"</c:if>>男
                <input type="radio" name="gender" value="女" <c:if test="${requestScope.employee1.gender eq '女'}">checked="checked"</c:if>>女
                </td>
            </tr>

            <tr>
                <td>年龄：</td>
                <td><input type="number" name="age" value="${requestScope.employee1.age}"></td>

                <td>学历：</td>
                <td><input type="text" name="degree" value="${requestScope.employee1.degree}"></td>
            </tr>

            <tr>


                <td>Email：</td>
                <td><input type="email" name="email" value="${requestScope.employee1.email}"></td>
            </tr>

            <tr>
                <td>应聘职位：</td>
                <td>${requestScope.department.name}&nbsp;${requestScope.position.name}</td>
                <td>入职时间：</td>
                <td><f:formatDate value="${requestScope.employee1.beginTime}"/></td>

            </tr>
            

            <tr>
                <td colspan="2"><input type="submit" value="保存"></td>
                <td colspan="2"><a href="javaScript:history.back(-1);">返回</a></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>