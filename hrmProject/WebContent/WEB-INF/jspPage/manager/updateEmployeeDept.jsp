<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.ixanq.entity.Visitor"%>
<%@ page import="java.util.List" %>
<%@ page import="com.ixanq.entity.Department" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>员工管理</title>
    <style>
        body{
            width: 100%;
            height: 85%;
            background-image: url("/logo/backgrond.jpg");
            background-repeat: repeat;
        }
        #head{
            width: 70%;
            margin: 20px auto;
            text-align: center;
            font-size: 18px;
            text-decoration-color: #677985;
            background-color: #67b168;
        }
    </style>
    <script src="${pageContext.request.contextPath}/bootstrap/js/jquery-1.7.2.js"></script>

    <script>
        $(function(){
            $(".update").click(function(){
               /* $("#first").hide();*/
                $("form").show();
            })
        })
        $(function() {
            $("#workPosition").hide(); //初始化的时候第二个下拉列表隐藏
        });
        function firstSel() {//如果第一个下拉列表的值改变则调用此方法
            var orderTypeId = $("#departmentId").val();//得到第一个下拉列表的值
            if(orderTypeId!=null && "" != orderTypeId){
                //通过ajax传入后台，把orderTypeName数据传到后端
                $.ajax({
                    url:"${pageContext.request.contextPath}/findAllWorkPosition",
                    type:"get",
                    dataType:"json",
                    data:{"id":orderTypeId},
                    success:function (data) {
                        var res = JSON.stringify(data);
                        var option;
                        $.each(data,function(i,n){//循环，i为下标从0开始，n为集合中对应的第i个对象
                            option += "<option value='"+n.id+"'>"+n.name+"</option>"
                        });
                        $("#workPositionId").html(option);//将循环拼接的字符串插入第二个下拉列表
                        $("#workPositionId").show();//把第二个下拉列表展示
                    }

                })
            }else {
                $("#workPositionId").hide();
            }
        };


    </script>
</head>
<body>
<%@include file="managerBaseNav.jsp" %>
<div id="head">
    <div style="text-align: center;margin: 0 auto;font-size: 22px">员工信息</div>
    <table border="2px"  align="center" style="background-color: green">
        <tr>
            <td>ID</td>
            <td>员工名字</td>
            <td>员工部门职位</td>
            <td>修改职位</td>
        </tr>
        <tr>
            <td>${requestScope.employee.id}</td>
            <td>${requestScope.employee.realName}</td>
            <td class="first">${requestScope.department.name} &nbsp;&nbsp;${requestScope.workPosition.name}</td>
            <td><a class="update">修改</a></td>

        </tr>
        <tr>
            <td colspan="4"><a href="javaScript:history.back(-1);">返回</a></td>
        </tr>
    </table>
   <%-- <%
        List<Department> departments=(List<Department>)request.getAttribute("allDepartment");
        departments.get()
    %>--%>
    <form hidden action="${pageContext.request.contextPath}/updateEmployeeAndCommit" method="post">
        <table style="width: 65%;" align="center" bgcolor="lime" border="2px" color="lime">
            <input type="hidden" name="employeeId" value="${requestScope.employee.id}">
            <td class="ifUpdaate">
                <select id="departmentId" style="width:70px;" name="departmentId" onchange="firstSel()">
                    <c:forEach items="${requestScope.allDepartment}" var="department">
                        <option value="${department.id}">${department.name}</option>
                    </c:forEach>

                </select>
                <select id="workPositionId" name="workPositionId">

                </select>
            </td>
            <td><input type="submit" value="确认"></td>
        </table>
    </form>
</div>
</body>
</html>

