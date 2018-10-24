<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ixanq.entity.WorkPosition" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>复议内容</title>
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
            $(".addReward").click(function(){
                var $td=$(this).parent().parent().children();
                var $tr=$(this).parent().parent();
                var id=$td[1].innerHTML;//员工id //2
                $("form").show();
                $(".inputHidden").val(id);
            })
        })

        $(function(){
            $(".delete").click(function(){
                if(confirm("确认删除？")){
                    var $td=$(this).parent().parent().children();
                    var id=$td[0].innerHTML;
                    var $tr=$(this).parent().parent();
                    var url="${pageContext.request.contextPath}/ajaxDeleteReconsiderById";
                    var args={"id":id};
                    $.post(url,args,function(data){
                        if(data=="seccess"){
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
<div class="head">
    <title class="center">
        <strong>复议信息</strong>
    </title>
    <div class="center">

        <td width="730" height="600" align="center" valign="top" bgcolor="#00FF99">
            <table width="730" height="400" border="2px" cellpadding="0" cellspacing="0" style="background-color: #00aFFF">
                <tr align="center">
                    <td colspan="6" bgcolor="#00FFFF"><strong>复议</strong></td>
                </tr>

                <tr>
                    <td>ID</td>
                    <td>员工ID</td>
                    <td>复议内容</td>
                    <td>提交时间</td>
                    <td>补发奖惩</td>
                    <td>删除</td>
                </tr>

                <c:forEach items="${requestScope.reconsiders}" var="reconsider">
                    <tr>
                        <td>${reconsider.id}</td>
                        <td>${requestScope.employeeId}</td>
                        <td>${reconsider.content}</td>
                        <td>${reconsider.time}</td>
                        <td><a class="addReward">补发奖惩</a></td>
                        <td><a class="delete">删除</a></td>
                    </tr>
                </c:forEach>
                <c:if test="${empty reconsiders}">
                    <tr>
                        <td colspan="6">暂无信息</td>
                    </tr>
                </c:if>
                <tr>
                    <td colspan="5"><a href="javaScript:history.back(-1);">返回</a></td>
                </tr>
            </table>
        </td>

        <br><br><br>
        <form hidden action="${pageContext.request.contextPath}/addRewardForEmployee" method="post" style="width: 60%;">

            <input class="inputHidden" type="hidden" name="employeeId"><%--☆☆☆☆☆☆☆☆☆☆☆☆--%>

            <table width="50%" border="2px" cellpadding="0" cellspacing="0" style="background-color: #00aFFF" align="center">
                <tr>
                    <td colspan="2" style="font-size:20px;">奖惩</td>
                </tr>
                <tr>
                    <td>原因：</td>
                    <td><input type="text" name="reason" ></td>
                </tr>
                <tr>
                    <td>奖金:</td>
                    <td colspan="2"><input type="number" name="money"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="确认"></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
