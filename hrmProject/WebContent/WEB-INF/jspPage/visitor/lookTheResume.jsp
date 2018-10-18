<%@ page import="com.ixanq.entity.Resume" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ixanq.entity.Visitor" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>个人简历</title>
    <style>
        .head{
            width: 100%;
            height: 85%;
            background-image: url("/logo/backgrond.jpg");
            /*background-size: 100% 100%;!*平铺*!*/
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
</head>
<body>
<%@include file="baseNav.jsp"%> <!-- 相同目录下路径不用写 -->
<%
    Resume resume = (Resume) request.getAttribute("resumeByVisitorName");
    request.setAttribute("resume",resume);
%>
<div class="head">
    <title class="center">
        <strong>查看简历</strong>
    </title>
    <div class="center">
        <h2></h2>
            <td width="613" height="800" align="center" valign="top" bgcolor="#00FF99">
                <table width="650" height="429" border="2px" <%--cellpadding="0" cellspacing="0"--%> bgcolor="#00FFFF">
                    <tr align="center">
                        <td colspan="6" bgcolor="#00FFFF"><strong>个人简历</strong></td>

                    </tr>
                    <tr>
                        <td width="97" align="center" bgcolor="#00FFFF">姓名</td>
                        <td width="100" bgcolor="#00FFFF">${resume.name}</td>
                        <td width="97" align="center" bgcolor="#00FFFF">性别</td>
                        <td width="100" bgcolor="#00FFFF">${resume.gender}</td>
                        <td colspan="2" rowspan="5" align="center" valign="middle" bgcolor="#00FFFF">
                            <img src="/logo/touxiang.png" style="width: 120px;height:150px" alt="照片">
                        </td>
                    </tr>
                    <tr>
                        <td align="center" bgcolor="#00FFFF">年龄</td>
                        <td bgcolor="#00FFFF">${resume.age}</td>
                        <td align="center" bgcolor="#00FFFF">政治面貌</td>
                        <td bgcolor="#00FFFF">${resume.politicalStatus}</td>
                    </tr>
                    <tr>
                        <td align="center" bgcolor="#00FFFF">联系方式</td>
                        <td bgcolor="#00FFFF">${resume.tel}</td>
                        <td align="center" bgcolor="#00FFFF">Email</td>
                        <td align="center" bgcolor="#00FFFF">${resume.email}</td>
                    </tr>
                    <tr>
                        <td align="center" bgcolor="#00FFFF">上份工作</td>
                        <td bgcolor="#00FFFF">${resume.lastWork}</td>
                        <td align="center" bgcolor="#00FFFF">期望薪资</td>
                        <td bgcolor="#00FFFF">${resume.salary}</td>
                    </tr>

                    <tr>
                        <td align="center" bgcolor="#00FFFF">应聘职位</td>
                        <td  bgcolor="#00FFFF">
                            ${requestScope.departmentbyId.name}&nbsp;&nbsp;&nbsp;
                                ${requestScope.workPositionById.name}
                        </td>
                        <td align="center" bgcolor="#00FFFF">学历</td>
                        <td bgcolor="#00FFFF">
                            ${resume.master}
                        </td>
                    </tr>

                    <tr>
                        <td align="center" bgcolor="#00FFFF">工作经验</td>
                        <td colspan="4" bgcolor="#00FFFF">
                            ${resume.workBackground}
                        </td>
                    </tr>
                    <tr>
                        <td align="center" bgcolor="#00FFFF">兴趣爱好</td>
                        <td colspan="4" bgcolor="#00FFFF">
                           ${resume.hobbies}
                        </td>
                    </tr>

                    <tr>
                        <td colspan="3" bgcolor="#bdb76b" style="text-align: center"><a href="${pageContext.request.contextPath}/lookAdvertiseForVisitor">查看招聘信息</a></td>
                        <td colspan="2" bgcolor="#bdb76b" style="text-align: center"><a href="javascript:history.back(-1)">返回</a></td>
                    </tr>
                </table>
            </td>
    </div>
</div>
</body>
</html>
