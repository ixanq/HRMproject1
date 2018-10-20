<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.ixanq.entity.Visitor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>培训信息</title>
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
            $(".add").click(function(){
                $("form").show();
            })
        })
        $(function(){
            $(".delete").click(function(){
                if(confirm("确认删除？")){
                    var $td=$(this).parent().parent().children();
                    var $tr=$(this).parent().parent();
                    var id=$td[0].innerHTML;
                    var url="${pageContext.request.contextPath}/ajaxDeleteTrainById";
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
${requestScope.allTrain}
<div id="head">
    <table border="2px"  align="center" style="background-color: green">
        <tr>
            <td>ID</td>
            <td>培训名称</td>
            <td>培训时间</td>
            <td>培训部门</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${requestScope.allTrain}" var="train">
            <tr>
                <td>${train.id}</td>
                <td>${train.name}</td>
                <td>${train.trainTime}</td>
                <td>${train.department}</td>
                <td><a class="delete">删除</a></td>

            </tr>
        </c:forEach>
        <tr>
            <td colspan="2"><a class="add">添加</a></td>
            <td colspan="3"><a href="javaScript:history.back()-1;">返回</a></td>
        </tr>
    </table>

    <br>
    <form hidden action="${pageContext.request.contextPath}/addTrainForDepartment" method="post">
        <table width="75%" border="2px" cellpadding="0" cellspacing="0" style="background-color: #00aFFF">
            <tr>
                <td>名称：</td>
                <td><input type="text" name="name" ></td>
            </tr>
            <tr>
                <td>名称：</td>
                <td><input type="text" name="trainDate" placeholder="yyyy-MM-dd HH:MM:ss" ></td>
            </tr>
            <tr>
                <td>部门：</td>
                <td>
                    <select id="departmentId" style="width:70px;" name="department">
                        <c:forEach items="${requestScope.allDepartment}" var="department">
                            <option value="${department.name}">${department.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan=""><input type="submit" value="确认"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

