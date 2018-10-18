<%@ page import="com.ixanq.entity.Visitor" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>面试邀请信息</title>
    <style>
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
                    var url="${pageContext.request.contextPath}/ajaxDeleteInterviewById";
                    var args={"id":id};
                    $.post(url,args,function(data){
                        if(data=="yes"){
                            $tr.remove();
                        }
                    })
                }
            })
        })
    </script>
</head>
<body>
<%@include file="baseNav.jsp"%> <!-- 相同目录下路径不用写 -->

<div class="head">
    <title class="center">
        <strong>面试邀请信息</strong>
    </title>
    <div class="center">
        <form action="${pageContext.request.contextPath}/" method="post">
            <td width="730" height="800" align="center" valign="top" bgcolor="#00FF99">
                <table width="730" height="400" border="2px" cellpadding="0" cellspacing="0" style="background-color: #00aFFF">
                    <tr align="center">
                        <td colspan="6" bgcolor="#00FFFF"><strong>招聘信息</strong></td>
                    </tr>

                    <tr>
                        <td>ID</td>
                        <td>名称</td>
                        <td>面试时间</td>
                        <td>面试</td>
                        <td>删除</td>

                    </tr>

                    <tr>
                        <td>${requestScope.interview.id}</td>
                        <td>${requestScope.interview.visitorName}</td>
                        <td>${requestScope.interview.viewTime}</td>
                        <td><a href="${pageContext.request.contextPath}/gotoInterview?id=${requestScope.interview.id}">面试</a></td>
                        <td><a href="#" class="delete">删除</a></td>
                        <td></td>

                    </tr>

                    <tr>
                        <td colspan="5" style="text-align: center;"><a href="javaScript:history.back(-1);">返回</a></td>

                    </tr>


                </table>
            </td>
        </form>
    </div>
</div>
</body>
</html>
