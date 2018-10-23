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
        tr,td{
            text-align: center;
        }
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath}\bootstrap\js\jquery-1.7.2.js"></script>
    <script>
        $(function(){
            $(".addReward").click(function(){
                var $td=$(this).parent().parent().children();
                var $tr=$(this).parent().parent();
                var id=$td[0].innerHTML;
                $("form").show();
                $(".inputHidden").val(id);
            })
        })

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
            <td>添加奖惩</td>
            <td>发工资</td>
            <td>开除</td>
        </tr>
        <c:forEach items="${requestScope.employees}" var="employee">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.realName}</td>
                <td>${employee.status}</td>
                <td><a href="${pageContext.request.contextPath}/updateEmployeeDepartmentMesseges?id=${employee.id}&&workPositionId=${employee.workPositionId}">修改部门职位</a></td>
                <td><a class="addReward">添加奖惩</a></td>
                <td><a href="${pageContext.request.contextPath}/mmanageSalary?employeeId=${employee.id}">发工资</a></td>
                <td><a href="${pageContext.request.contextPath}/outOfTheEmployeeFromWork?id=${employee.id}">开除</a></td>

            </tr>
        </c:forEach>
        <tr>
            <td colspan="6"><a href="javaScript:history.back(-1);">返回</a></td>
        </tr>
    </table>

    <br><br><br>
    <form hidden action="${pageContext.request.contextPath}/addRewardForEmployee" method="post">

        <input class="inputHidden" type="hidden" name="employeeId"><%--☆☆☆☆☆☆☆☆☆☆☆☆--%>

        <table width="90%" border="2px" cellpadding="0" cellspacing="0" style="background-color: #00aFFF" align="center">
            <tr>
                <td colspan="2" style="font-size:20px;">奖惩</td>
            </tr>
            <tr>
                <td>原因：</td>
                <td><input type="text" name="reason" ></td>
            </tr>
            <tr>
                <td>奖金:</td>
                <td colspan="2"><input type="number" name="money"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="确认"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

