<%@ page import="com.ixanq.entity.Visitor" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>填写招聘信息</title>
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
        $(function () {
           $("form").submit(function(){
               var flag=false;
               var count=0;//输入框数量
               $("input").each(function(i,domEle){
                   if($(domEle).val()!=null&&$(domEle).val()!=""){
                       count++;
                       if(count>=5){
                       flag=true;
                       }
                   }
               })
               return flag;
           })
        })
    </script>
</head>
<body>
<%@include file="managerBaseNav.jsp"%> <!-- 相同目录下路径不用写 -->

<div class="head">
    <title class="center">
        <strong>填写招聘信息</strong>
    </title>
    <div class="center">
        <form action="${pageContext.request.contextPath}/addAdvertiseAndCommit" method="post">
            <td width="500" height="700" align="center" valign="top" bgcolor="#00FF99">
                <table width="500" height="400" border="2px" cellpadding="0" cellspacing="0" style="background-color: green">
                    <tr align="center">
                        <td colspan="6" bgcolor="#00FFFF"><strong>填写招聘信息</strong></td>
                    </tr>


                    <tr>
                        <td>名称</td>
                        <td><input type="text" name="advertiseName"></td>
                    </tr>

                    <tr>
                        <td>薪资</td>
                        <td><input type="text" name="salary"></td>
                    </tr>


                    <tr>
                        <td>需要人数</td>
                        <td ><input type="number" name="needPersonNumber"></td>
                    </tr>


                    <tr>
                        <td>职位描述</td>
                        <td><input type="text" name="advertiseDescreption"></td>
                    </tr>

                    <tr>
                        <td style="text-align: center" colspan="2"><input type="submit" value="发布"> </td>
                    </tr>
                </table>
            </td>
        </form>
    </div>
</div>
</body>
</html>
