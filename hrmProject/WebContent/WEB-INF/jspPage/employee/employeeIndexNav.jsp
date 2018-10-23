<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.ixanq.entity.Visitor"%>
<%@ page import="com.ixanq.entity.Employee" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工主页</title>
	<style>
		body{
			width: 100%;
			height: 85%;
			background-image: url("/logo/backgrond.jpg");
			background-repeat: repeat;
		}

		#addseccessfuly{
			width: 50%;
			height:30%;
			margin: 40px auto;
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
	 <div id="addseccessfuly">
		 <c:if test="${requestScope.updateEmployeeInfoToDb!=null}">
			 员工信息修改成功<br>
		 </c:if>
		 <c:if test="${requestScope.etrainIsEmpty!=null}">
			 您所在的部门还没有培训信息<br>
		 </c:if>
		 <c:if test="${requestScope.updatePWDandCommit!=null}">
			 修改密码成功<br>
		 </c:if>
		 <c:if test="${requestScope.commitTheErrorSeccess!=null}">
			 复议已提交<br>
		 </c:if>

	 </div>




</body>
</html>