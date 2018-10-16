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
</head>
<body>
<%@include file="baseNav.jsp"%> <!-- 相同目录下路径不用写 -->

<div class="head">
    <title class="center">
        <strong>修改简历</strong>
    </title>
    <div class="center">
        <form action="" method="post">
            <td width="613" height="800" align="center" valign="top" bgcolor="#00FF99">
                <table width="650" height="429" border="2px" cellpadding="0" cellspacing="0" bgcolor="#00FFFF">
                    <tr align="center">
                        <td colspan="6" bgcolor="#00FFFF"><strong>个人简历</strong></td>

                    </tr>
                    <tr>
                        <td width="97" align="center" bgcolor="#00FFFF">姓名</td>
                        <td width="100" bgcolor="#00FFFF"><input type="text" name="vname" placeholder="请输入真实姓名"></td>
                        <td width="97" align="center" bgcolor="#00FFFF">性别</td>
                        <td width="100" bgcolor="#00FFFF">
                            <input type="radio" name="vgender" value="男" checked />男
                            <input type="radio" name="vgender" value="女" />女 </td>
                        <td colspan="2" rowspan="5" align="center" valign="middle" bgcolor="#00FFFF">
                            <img src="/logo/touxiang.png" style="width: 120px;height:150px" alt="照片">
                        </td>
                    </tr>
                    <tr>
                        <td align="center" bgcolor="#00FFFF">年龄</td>
                        <td bgcolor="#00FFFF"><input type="number" name="vage" placeholder="请输入年龄"></td>
                        <td align="center" bgcolor="#00FFFF">政治面貌</td>
                        <td bgcolor="#00FFFF">
                            <select name="master">
                                <option value="普通群众">普通群众</option>
                                <option value="共青团员">共青团员</option>
                                <option value="党员">党员</option>
                            </select>

                        </td>
                    </tr>
                    <tr>
                        <td align="center" bgcolor="#00FFFF">联系方式</td>
                        <td bgcolor="#00FFFF"><input type="tel" name="vtel" placeholder="手机号"></td>
                        <td align="center" bgcolor="#00FFFF">Email</td>
                        <td align="center" bgcolor="#00FFFF"><input type="email" name="vemail" placeholder="xxxx.@qq.com"></td>
                    </tr>
                    <tr>
                        <td align="center" bgcolor="#00FFFF">上份工作</td>
                        <td bgcolor="#00FFFF"><input type="text" name="vLastwork" placeholder="请输入工作名称或无"></td>
                        <td align="center" bgcolor="#00FFFF">期望薪资</td>
                        <td bgcolor="#00FFFF">
                            <select name="vsalary">
                                <option value="3000-5000">3000-5000</option>
                                <option value="5000-6000">5000-6000</option>
                                <option value="6000-7000">6000-7000</option>
                                <option value="7000-9000">7000-9000</option>
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td align="center" bgcolor="#00FFFF">应聘职位</td>
                        <td  bgcolor="#00FFFF">
                            <select name="">
                                <option>a</option>
                                <option>b</option>
                                <option>c</option>
                            </select>
                            <select name="" >
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                            </select>
                        </td>
                        <td align="center" bgcolor="#00FFFF">学历</td>
                        <td bgcolor="#00FFFF">
                            <select name="vmaster">
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
                            <textarea name="vworkbackbround" style="width: 600px;height: 60px" placeholder="请输入1~150个汉字"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td align="center" bgcolor="#00FFFF">兴趣爱好</td>
                        <td colspan="4" bgcolor="#00FFFF">
                            <textarea name="vhobby" style="width: 600px;height: 30px" placeholder="请输入兴趣爱好"></textarea>
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
