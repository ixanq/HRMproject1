<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.ixanq.entity.Visitor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>游客主页</title>
	<style>
		body{
			width: 100%;
			height: 85%;
			background-image: url("/logo/backgrond.jpg");
			background-repeat: repeat;
		}
		#addseccessfuly{
			width: 50%;
			height: 25%;
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
	 <%@include file="baseNav.jsp" %>

	 <%--aaaaaaa${sessionScope.visitor}--%>
	<div id="addseccessfuly">
		<c:if test="${requestScope.addSeccessfully!=null}">
			添加成功
		</c:if>
		<c:if test="${requestScope.resumeExist!=null}">
			您已经有简历了，请前往查看
		</c:if>
		<c:if test="${requestScope.plesaseWriteAgain!=null}">
			您还没有简历，无法查看，请先添加
		</c:if>
		<c:if test="${requestScope.pleaseRewriteAgAin!=null}">
			您还没有简历，无法修改，请先添加
		</c:if>
		<c:if test="${requestScope.updateSeccessfully!=null}">
			简历修改成功，请前往查看功能查看
		</c:if>
		<c:if test="${requestScope.sendResumeisSeccessfully!=null}">
			投递简历成功，请耐心等待面试官回应。。。
		</c:if>

	</div>
</body>
</html>