<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ixanq.entity.Visitor" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改简历</title>
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
        $(function() {
            $("form").submit(function(){
                var resumeId=$("#resumeId").val();
                var visitorName=$("#visitorName").val();
                var name=$("#name").val();
               // var gender=$("#").val();
                var age=$("#age").val();
                var politicalStatus=$("#politicalStatus").val();
                var tel=$("#tel").val();
                var email=$("#email").val();
                var lastWork=$("#lastWork").val();
                var salary=$("#salary").val();
                var departmentId=$("#departmentId").val();
                var workPositionId=$("#workPositionId").val();
                var master=$("#master").val();
                var workBackground=$("#workBackground").val();
                var hobby=$("#hobby").val();
                if( resumeId==""||visitorName==""||name==""||age==""||politicalStatus==""||tel==""||email==""||
                    lastWork==""||salary==""||departmentId==""||workPositionId==""||master==""||workBackground==""||hobby==""){
                    alert("请填写所有内容，不能为空");
                    return false;
                }
            })
        });
    </script>
</head>
<body>
<%@include file="baseNav.jsp"%> <!-- 相同目录下路径不用写 -->

<div class="head">
    <title class="center">
        <strong>修改简历</strong>
    </title>
    <div class="center">
        <form action="${pageContext.request.contextPath}/updateAndCommitResume" method="post">
            <input type="hidden" id="resumeId" name="resumeId" value="${requestScope.resumeByVisitorName.id}">
            <input type="hidden" id="visitorName" name="visitorName" value="${requestScope.resumeByVisitorName.visitorName}">
            <td width="613" height="800" align="center" valign="top" bgcolor="#00FF99">
                <table width="650" height="429" border="2px" cellpadding="0" cellspacing="0" bgcolor="#00FFFF">
                    <tr align="center">
                        <td colspan="6" bgcolor="#00FFFF"><strong>个人简历</strong></td>

                    </tr>
                    <tr>
                        <td width="97" align="center" bgcolor="#00FFFF">姓名</td>
                        <td width="100" bgcolor="#00FFFF"><input type="text" id="name" name="name" value="${requestScope.resumeByVisitorName.name}"></td>
                        <td width="97" align="center" bgcolor="#00FFFF">性别</td>
                        <td width="100" bgcolor="#00FFFF">
                            <input type="radio" name="gender" value="男" checked />男
                            <input type="radio" name="gender" value="女" />女 </td>
                        <td colspan="2" rowspan="5" align="center" valign="middle" bgcolor="#00FFFF">
                            <img src="/logo/touxiang.png" style="width: 120px;height:150px" alt="照片">
                        </td>
                    </tr>
                    <tr>
                        <td align="center" bgcolor="#00FFFF">年龄</td>
                        <td bgcolor="#00FFFF"><input type="number" id="age" name="age" value="${requestScope.resumeByVisitorName.age}"></td>
                        <td align="center" bgcolor="#00FFFF">政治面貌</td>
                        <td bgcolor="#00FFFF">
                            <select name="politicalStatus" id="politicalStatus">
                                <option value="普通群众">普通群众</option>
                                <option value="共青团员" selected>共青团员</option>
                                <option value="党员">党员</option>
                            </select>

                        </td>
                    </tr>
                    <tr>
                        <td align="center" bgcolor="#00FFFF">联系方式</td>
                        <td bgcolor="#00FFFF"><input type="tel" id="tel" name="tel" value="${requestScope.resumeByVisitorName.tel}"></td>
                        <td align="center" bgcolor="#00FFFF">Email</td>
                        <td align="center" bgcolor="#00FFFF"><input type="email" id="email" name="email" value="${requestScope.resumeByVisitorName.email}"></td>
                    </tr>
                    <tr>
                        <td align="center" bgcolor="#00FFFF">上份工作</td>
                        <td bgcolor="#00FFFF"><input type="text" id="lastWork" name="lastWork" value="${requestScope.resumeByVisitorName.lastWork}"></td>
                        <td align="center" bgcolor="#00FFFF">期望薪资</td>
                        <td bgcolor="#00FFFF">
                            <select name="salary" id="salary">
                                <option value="3000-5000">3000-5000</option>
                                <option value="5000-6000">5000-6000</option>
                                <option value="6000-7000" selected>6000-7000</option>
                                <option value="7000-9000">7000-9000</option>
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td align="center" bgcolor="#00FFFF">应聘职位</td>
                        <td  bgcolor="#00FFFF">
                            <select id="departmentId" style="width:70px;" name="departmentId" onchange="firstSel()">
                            <c:forEach items="${requestScope.allDepartment}" var="department">
                                <option value="${department.id}">${department.name}</option>
                            </c:forEach>

                        </select>
                            <select id="workPositionId" name="workPositionId">

                            </select>
                        </td>
                        <td align="center" bgcolor="#00FFFF">学历</td>
                        <td bgcolor="#00FFFF">
                            <select name="master" id="master">
                                <option value="大专">大专</option>
                                <option value="本科">本科</option>
                                <option value="硕士">硕士</option>
                                <option value="博士">博士</option>
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td align="center" bgcolor="#00FFFF">工作经验</td>
                        <td colspan="4" bgcolor="#00FFFF">
                            <input type="text" id="workBackbround" name="workBackbround" value="${requestScope.resumeByVisitorName.workBackground}" style="width: 600px;height: 60px" ></input>
                        </td>
                    </tr>
                    <tr>
                        <td align="center" bgcolor="#00FFFF">兴趣爱好</td>
                        <td colspan="4" bgcolor="#00FFFF">
                            <input type="text" id="hobby" name="hobby" value="${requestScope.resumeByVisitorName.hobbies}" style="width: 600px;height: 30px" ></input>
                        </td>
                    </tr>

                    <tr>
                        <td colspan="3" bgcolor="#bdb76b" style="text-align: center"><input type="submit" value="确认修改"></td>
                        <td colspan="2" bgcolor="#bdb76b" style="text-align: center"><a href="#">返回</a></td>
                    </tr>
                </table>
            </td>
        </form>
    </div>
</div>
</body>
</html>
