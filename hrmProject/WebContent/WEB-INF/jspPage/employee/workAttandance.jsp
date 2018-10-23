<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
            margin-left: 70%;
            background-color: azure;
        }

        #center{
            width: 45%;
            height: 25%;
            margin: 80px auto;
            text-align: center;
            font-size: 32px;
            text-decoration-color: green;
            background-color: #c0a16b;
        }
    </style>
    <script src="${pageContext.request.contextPath}/bootstrap/js/jquery-1.7.2.js"></script>
</head>
<body>
    <%@include file="employeeBaseNav.jsp" %>
    <div class="right">
        <td><a href="addworkAttendenceForEmployee">上班签到</a></td>&nbsp;&nbsp;&nbsp;&nbsp;<td><a a href="updateworkAttendenceForEmployee">下班签到</a></td>
    </div>
    <div id="center">
        <c:if test="${!empty requestScope.youHaveAlreadyWorkAtendance}">
            您上班打卡已经打过了，不能再次签到<br>
        </c:if>
        <c:if test="${requestScope.WorkAtendanceIsInTime!=null}">
            打卡成功!<br>
        </c:if>
        <c:if test="${requestScope.WorkAtendanceIsLate!=null}">
            打卡成功,迟到： ${requestScope.WorkAtendanceIsLate}  &nbsp;小时<br>
        </c:if>
        <c:if test="${requestScope.WorkAtendanceIsTooLate!=null}">
            打卡迟到了，算旷工，记得下次早点来！<br>
        </c:if>
        <c:if test="${requestScope.youHaveAlreadyLeaveWorkAtendance!=null}">
            您已经打过下班卡，不能再次打卡<br>
        </c:if>
        <c:if test="${requestScope.youHaveNoworkAttandance!=null}">
            您还没有签到，无法签退<br>
        </c:if>
        <c:if test="${requestScope.WorkAtendanceLeveIsInTime!=null}">
            下班打卡成功!<br>
        </c:if>
        <c:if test="${requestScope.WorkLeaveAtendanceIsBefore!=null}">
            下班打卡成功,早退:&nbsp;${requestScope.WorkLeaveAtendanceIsBefore}&nbsp;个小时<br>
        </c:if>
        <c:if test="${requestScope.WorkLeaveAtendanceIsSoEarly!=null}">
            下班打卡成功，但下班打卡时间过早，工资扣没了<br>
        </c:if>


    </div>
</body>
</html>

