<%@page import="com.ixanq.entity.Visitor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/bootstrap/js/jquery-1.7.2.js"></script>
</head>
<body>
<li><a href="writeResume.jsp">填写简历</a></li>
<%
	Visitor visitor=(Visitor)request.getAttribute("visitor2");
	session.setAttribute("visitor", visitor);
	%>
	<%-- <%@include file="baseNav.jsp" %> --%>
</body>
</html>