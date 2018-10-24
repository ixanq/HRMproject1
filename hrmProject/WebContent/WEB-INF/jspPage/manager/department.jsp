<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.ixanq.entity.Visitor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>部门管理</title>
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
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/jquery-1.7.2.js"></script>
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
                    var id=$td[0].innerHTML;
                    var $tr=$(this).parent().parent();
                    var url="${pageContext.request.contextPath}/ajaxdeleteDepartmentById";
                    var args={"id":id};
                    $.post(url,args,function(data){
                        if(data=="seccess"){
                            $tr.remove();
                        }else {
                            alert("该部门下存在员工，无法删除");
                        }
                    })
                }
            })
        })

        $(function(){
            $("form").submit(function(){
                var name=$("#name").val();
                if(name==""||name==null){
                    alert("内容不能为空");
                    return false;
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
            <td>部门名称</td>
            <td>查看职位</td>
            <td>删除部门</td>
        </tr>
        <c:forEach items="${requestScope.allDepartment}" var="department">
            <tr>
                <td>${department.id}</td>
                <td>${department.name}</td>
                <td><a href="${pageContext.request.contextPath}/lookDepartmentWorkPosirion?id=${department.id}">查看职位</a></td>
                <td><a class="delete">删除部门</a></td>

            </tr>
        </c:forEach>
        <tr>
            <td colspan="4"><a  class="add">添加部门</a></td>
        </tr>
    </table>
            <br><br><br>
    <form hidden action="${pageContext.request.contextPath}/addDepartmentToDB" method="post">
        <table width="50%" border="2px" cellpadding="0" cellspacing="0" style="background-color: #00aFFF" align="center">
            <tr>
                <td>部门名称：</td>
                <td><input type="text" id="name" name="name" ></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="确认"></td>
            </tr>
        </table>
    </form>
    </td>
</div>
</body>
</html>

