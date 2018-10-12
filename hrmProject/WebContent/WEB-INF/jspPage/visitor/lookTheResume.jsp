<%@page import="com.ixanq.entity.Visitor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>简历</title>
<script src="${pageContext.request.contextPath}/bootstrap/js/jquery-1.7.2.js"></script>
</head>
<body>
<%-- <%@include file="/hrmProject/WebContent/WEB-INF/jspPage/baseNav.jsp.jsp"%> --%>
<%-- <%@include file="./jspPage/baseNav.jsp"%>  --%>
<%
	Visitor visitor=(Visitor)request.getAttribute("visitor2");
	session.setAttribute("visitor", visitor);%>
<%@include file="baseNav.jsp" %>
<%-- <%@include file="baseNav.jsp"%> <!-- 相同目录下路径不用写 --> --%>


我是简历(查看简历)
</body>
</html>