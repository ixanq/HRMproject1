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
			添加成功<br>
		</c:if>
		<c:if test="${requestScope.resumeExist!=null}">
			您已经有简历了，请前往查看<br>
		</c:if>
		<c:if test="${requestScope.plesaseWriteAgain!=null}">
			您还没有简历，无法查看，请先添加<br>
		</c:if>
		<c:if test="${requestScope.pleaseRewriteAgAin!=null}">
			您还没有简历，无法修改，请先添加<br>
		</c:if>
		<c:if test="${requestScope.updateSeccessfully!=null}">
			简历修改成功，请前往查看功能查看<br>
		</c:if>
		<c:if test="${requestScope.sendResumeisSeccessfully!=null}">
			投递简历成功，请耐心等待面试官回应。。。<br>
		</c:if>
		<c:if test="${requestScope.resumeForManagerIsExist!=null}">
			这个职位您已经投过简历，请换一个职位试一试<br>
		</c:if>
		<c:if test="${requestScope.youHaveInterviewMessegess!=null}">
			您有面试邀请，请前往在查看<br>
		</c:if>
		<c:if test="${requestScope.thereAreNoInterviewMesseges!=null}">
			暂未发现面试邀请<br>
		</c:if>
		<c:if test="${requestScope.lookTheAdvertiseDetailMasseges!=null}">
			暂未发现面试邀请<br>
		</c:if>
		<c:if test="${requestScope.noadvertises!=null}">
			暂未发现面试邀请<br>
		</c:if>
		<c:if test="${requestScope.pleaseWaitThegotoInterviewResult!=null}">
			面试成功，请等待面试官最后的结果<br>
		</c:if>



	</div>
</body>
</html>