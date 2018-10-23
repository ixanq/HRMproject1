<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.ixanq.entity.Visitor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>招聘信息</title>
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
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath}\bootstrap\js\jquery-1.7.2.js"></script>
    <script>

        $(function(){
            $(".delete").click(function(){
                if(confirm("确认删除？")){
                    var $td=$(this).parent().parent().children();
                    var id=$td[0].innerHTML;
                    var $tr=$(this).parent().parent();
                    var url="${pageContext.request.contextPath}/ajaxDeleteAdvertiseById";
                    var args={"id":id};
                    $.post(url,args,function(data){
                        if(data=="deleteSeccessfully"){
                            $tr.remove();
                        }
                    })
                }
            })
        })
    </script>
</head>
<body>
<%@include file="managerBaseNav.jsp" %>
<div id="head">
    <table border="2px"  align="center" style="background-color: green">
        <tr>
            <td>ID</td>
            <td>招聘名称</td>
            <td>薪资</td>
            <td>需要人数</td>
            <td>查看</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${requestScope.advertises}" var="advertise">
            <tr>
                <td>${advertise.id}</td>
                <td>${advertise.advertiseName}</td>
                <td>${advertise.salary}</td>
                <td>${advertise.needPersonNumber}</td>
                <td><a href="${pageContext.request.contextPath}/lookTheAdvertiseDetailMasseges?id=${advertise.id}">查看详情</a></td>
                <td><a class="delete" >删除</a></td>

            </tr>
        </c:forEach>
        <tr>
            <td colspan="6"><a href="${pageContext.request.contextPath}/addAdvertisesforAdmin">添加新的招聘信息</a></td>
        </tr>
    </table>
</div>
</body>
</html>

