<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/v1.1/css/bootstrap.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/jquery-1.11.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/v1.1/js/Blob.js/Blob.js"></script>
    <script src="${pageContext.request.contextPath}/v1.1/js/FileSaver.js/FileSaver.js"></script>
    <script src="${pageContext.request.contextPath}/v1.1/js/Bootstrap/bootstrap.min.js"></script>

    <style>
        .navbar-default .navbar-nav>li>a {
            color: white;
        }
        nav{
            background-image: url("/logo/head.jpg");
            background-repeat: repeat-x;
        }
    </style>


    <script>
        $(function () {
            $("#ul1 li a").each(function () {
                var $this = $(this);
                if($this[0].href==String(window.location)){
                    $("#ul1 li").removeClass("active");
                    $this.parent().addClass("active");  //active表示被选中效果的类名
                }
            }) 
        })
    </script>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <span class="icon-bar" style="color:red">当前管理员 ：${sessionScope.manager.name}</span>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav" id="ul1">
                <li class="active"><a href="${pageContext.request.contextPath}/mworkAtendance">查看考勤 <span class="sr-only">(current)</span></a></li>
                <li><a href="${pageContext.request.contextPath}/mmanageEmployee">员工管理</a></li>
                <li><a href="${pageContext.request.contextPath}/mmanageDepartment">部门职位管理</a></li>

                <li><a href="${pageContext.request.contextPath}/mmanageTrain">培训管理</a></li>
                <li><a href="${pageContext.request.contextPath}/lookAndDeleteResume">简历中心</a></li>

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">招聘管理 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/manageAdvertise">查看招聘信息</a></li>
                        <li><a href="${pageContext.request.contextPath}/addAdvertisesforAdmin">填写招聘信息</a></li>
                        <li><a href="${pageContext.request.contextPath}/lookAndDeleteResume">简历中心</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="${pageContext.request.contextPath}/lookAllGoInterview">查看面试请求</a></li>
                        <li role="separator" class="divider"></li>
                    </ul>
                </li>

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">财务管理 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="writeResume"></a></li>
                        <li><a href="${pageContext.request.contextPath}/mmanageEmployee">发放薪资</a></li>
                        <li><a href="${pageContext.request.contextPath}/mmanageEmployee">查看薪资发放记录</a></li>
                        <li><a href="${pageContext.request.contextPath}/lookTheRewardMesseges">查看奖惩记录</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#"></a></li>
                        <li role="separator" class="divider"></li>
                    </ul>
                </li>
            </ul>
            <%--<form class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>--%>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">反馈</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">设置 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/managerSignOut">退出</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#"></a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
</body>
</html>