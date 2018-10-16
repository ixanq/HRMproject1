<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>填写简历</title>
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
            var orderTypeId = $("#department").val();//得到第一个下拉列表的值
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
                        $("#workPosition").html(option);//将循环拼接的字符串插入第二个下拉列表
                        $("#workPosition").show();//把第二个下拉列表展示
                    }

                })
            }else {
                $("#workPosition").hide();
            }
        };
    </script>
</head>
<body>
<%@include file="baseNav.jsp"%> <!-- 相同目录下路径不用写 -->

    <div class="head">
            <title class="center">
                <strong>填写简历</strong>
            </title>
        <div class="center">
            <form action="${pageContext.request.contextPath}/writeResumeAndCommit" method="post">
                <td width="730" height="800" align="center" valign="top" bgcolor="#00FF99">
                    <table width="730" height="400" border="2px" cellpadding="0" cellspacing="0" bgcolor="#00FFFF">
                        <tr align="center">
                            <td colspan="6" bgcolor="#00FFFF"><strong>个人简历</strong></td>

                        </tr>
                        <tr>
                            <td width="300" align="center" bgcolor="#00FFFF">姓名</td>
                            <td width="100" bgcolor="#00FFFF"><input type="text" name="name" placeholder="请输入真实姓名"></td>
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
                            <td bgcolor="#00FFFF"><input type="number" name="age" placeholder="请输入年龄"></td>
                            <td align="center" bgcolor="#00FFFF">政治面貌</td>
                            <td bgcolor="#00FFFF">
                                <select name="politicalStatus" style="width: 170px;">
                                    <option value="普通群众">普通群众</option>
                                    <option value="共青团员">共青团员</option>
                                    <option value="党员">党员</option>
                                </select>

                            </td>
                        </tr>
                        <tr>
                            <td align="center" bgcolor="#00FFFF">联系方式</td>
                            <td bgcolor="#00FFFF"><input type="tel" name="tel" placeholder="手机号"></td>
                            <td align="center" bgcolor="#00FFFF">Email</td>
                            <td align="center" bgcolor="#00FFFF"><input type="email" name="email" placeholder="xxxx.@qq.com"></td>
                        </tr>
                        <tr>
                            <td align="center" bgcolor="#00FFFF">上份工作</td>
                            <td bgcolor="#00FFFF"><input type="text" name="lastWork" placeholder="请输入工作名称或无"></td>
                            <td align="center" bgcolor="#00FFFF">期望薪资</td>
                            <td bgcolor="#00FFFF">
                                <select name="salary" style="width: 170px;">
                                    <option value="3000-5000">3000-5000</option>
                                    <option value="5000-6000">5000-6000</option>
                                    <option value="6000-7000">6000-7000</option>
                                    <option value="7000-9000">7000-9000</option>
                                    <option value="9000-13000">7000-9000</option>
                                </select>
                            </td>
                        </tr>

                        <tr>
                            <td align="center" bgcolor="#00FFFF">应聘职位</td>
                            <td  bgcolor="#00FFFF">
                                <select id="department" style="width:70px;" name="departmentId" onchange="firstSel()">
                                    <c:forEach items="${requestScope.allDepartment}" var="department">
                                         <option value="${department.id}">${department.name}</option>
                                    </c:forEach>

                                </select>
                                <select id="workPosition" name="workPositionId">

                                </select>
                            </td>
                            <td align="center" bgcolor="#00FFFF">学历</td>
                            <td bgcolor="#00FFFF">
                                <select name="master" style="width: 170px;">
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
                                <textarea name="workBackground" style="width: 600px;height: 60px" placeholder="请输入1~150个汉字"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td align="center" bgcolor="#00FFFF">兴趣爱好</td>
                            <td colspan="4" bgcolor="#00FFFF">
                                <textarea name="hobby" style="width: 600px;height: 30px" placeholder="请输入兴趣爱好"></textarea>
                            </td>
                        </tr>

                        <tr>
                            <td colspan="3" bgcolor="#bdb76b" style="text-align: center"><input type="submit" value="保存"></td>
                            <td colspan="2" bgcolor="#bdb76b" style="text-align: center"><a href="#">返回</a></td>
                        </tr>
                    </table>
                </td>
            </form>
        </div>
    </div>
</body>
</html>
