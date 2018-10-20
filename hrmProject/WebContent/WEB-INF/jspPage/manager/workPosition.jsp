<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ixanq.entity.WorkPosition" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>职位</title>
    <style>
        body{
            width: 100%;
            height: 85%;
            background-image: url("/logo/backgrond.jpg");
            background-repeat: repeat;
        }
        .head{
            width: 100%;
            height: 85%;
            background-image: url("/logo/backgrond.jpg");
            background-repeat: repeat;
        }
        .center{
            width: 900px;
            height: 850px;
            margin:0 auto;
            margin-left:300px ;
        }

        td,tr{
            text-align: center;
        }
    </style>
    <script src="${pageContext.request.contextPath}/bootstrap/js/jquery-1.7.2.js"></script>
    <script>

        $(function(){
            $(".delete").click(function(){
                if(confirm("确认删除？")){
                    var $td=$(this).parent().parent().children();
                    var $tr=$(this).parent().parent();
                    var id=$td[0].innerHTML;
                    var url="${pageContext.request.contextPath}/deleteWorkPositionForDepartmen";
                    var args={"id":id};
                    $.post(url,args,function(data){
                        if(data=="ok"){
                            $tr.remove();
                        }
                    })
                }
            })
        })

        $(function(){
            $(".add").click(function(){
                $("form").show();
            })
        })
    </script>
</head>
<body>
<%@include file="managerBaseNav.jsp" %>
aaa:${requestScope.workPositions.get(0).departmentId}
<div class="head">
    <title class="center">
        <strong>职位信息</strong>
    </title>
   <%-- <%
        List<WorkPosition> workPositions=( List<WorkPosition>)request.getAttribute("workPositions");
        Integer departmentId=workPositions.get(0).getDepartmentId();
        pageContext.setAttribute("departmentId",departmentId);
    %>--%>
    <div class="center">
            <td width="730" height="800" align="center" valign="top" bgcolor="#00FF99">
                <table width="730" height="400" border="2px" cellpadding="0" cellspacing="0" style="background-color: #00aFFF">
                    <tr align="center">
                        <td colspan="6" bgcolor="#00FFFF"><strong>职位信息</strong></td>
                    </tr>

                    <tr>
                        <td>ID</td>
                        <td>职位名称</td>
                        <td>创建时间</td>
                        <td>删除</td>
                    </tr>

                    <c:forEach items="${requestScope.workPositions}" var="workPosition">
                    <tr>
                        <td>${workPosition.id}</td>
                        <td>${workPosition.name}</td>
                        <td>${workPosition.createTime}</td>
                        <td><a class="delete">删除</a></td>
                    </tr>
                    </c:forEach>

                    <tr>
                        <td colspan="3"><a  class="add">添加</a></td>
                        <td colspan="3"><a href="javaScript:history.back(-1);">返回</a></td>
                    </tr>
                </table>
                <form hidden action="${pageContext.request.contextPath}/addworkPositionForDepartment" method="post">
                    <table width="730" border="2px" cellpadding="0" cellspacing="0" style="background-color: #00aFFF">
                        <tr>
                            <td>名称：</td>
                            <td><input type="text" name="name" ></td>
                            <td><input type="hidden" name="departmentId" value="${requestScope.workPositions.get(0).departmentId}"></td>
                        </tr>
                        <tr>
                            <td colspan="6"><input type="submit" value="确认"></td>
                        </tr>
                    </table>
                </form>
            </td>
    </div>
</div>
</body>
</html>
