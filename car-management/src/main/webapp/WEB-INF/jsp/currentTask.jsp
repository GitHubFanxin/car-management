<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="check" tagdir="/WEB-INF/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>公车管理平台 - Tables</title>

<link href="<%=basePath%>static/css/bootstrap.min.css" rel="stylesheet">

<link href="<%=basePath%>static/css/bootstrap-table.css" rel="stylesheet">
<link href="<%=basePath%>static/css/styles.css" rel="stylesheet">
<link href="<%=basePath%>static/css/custom.css" rel="stylesheet">

<!--[if lt IE 9]>
<script src="static/js/html5shiv.js"></script>
<script src="static/js/respond.min.js"></script>
<![endif]-->

</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#sidebar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><span>公车管理</span>平台</a>
				<ul class="user-menu">
					<li class="dropdown pull-right"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"><span
							class="glyphicon glyphicon-user"></span> <shiro:principal /><span
							class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#"><span class="glyphicon glyphicon-user"></span>
									用户资料 </a></li>
							<li><a href="#"><span class="glyphicon glyphicon-cog"></span>
									设置</a></li>
							<li><a href="${pageContext.request.contextPath}/logout"><span
									class="glyphicon glyphicon-log-out"></span> 退出</a></li>
						</ul></li>
				</ul>
			</div>

		</div>
		<!-- /.container-fluid -->
	</nav>

	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<form role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search">
			</div>
		</form>
		<ul class="nav menu">
			<li><a href="<%=basePath %>home"><span
					class="glyphicon glyphicon-dashboard"></span> 主面板</a></li>
					
			<check:hasAnyPermissions name="visit:user,visit:role">
			<li class="parent"><a data-toggle="collapse" href="#sub-item-1">
					<span class="glyphicon glyphicon-th"></span> 系统管理 <span
					class="icon pull-right"><em
						class="glyphicon glyphicon-s glyphicon-plus"></em></span>
			</a>
				<ul class="children collapse" id="sub-item-1">
				<shiro:hasPermission name="visit:user">
					<li><a class="" href="user-manage"> <span
							class="glyphicon glyphicon-share-alt"></span> 用户管理
					</a></li>
				</shiro:hasPermission>
				<shiro:hasPermission name="visit:role">
					<li><a class="" href="role-manage"> <span
							class="glyphicon glyphicon-share-alt"></span> 角色管理
					</a></li>
				</shiro:hasPermission>
				</ul></li>
			</check:hasAnyPermissions>
			
			<check:hasAnyPermissions name="visit:approve,visit:car,visit:driver">
			<li class="parent"><a data-toggle="collapse" href="#sub-item-2">
					<span class="glyphicon glyphicon-pencil"></span> 公车管理 <span
					class="icon pull-right"><em
						class="glyphicon glyphicon-s glyphicon-plus"></em></span>
			</a>
				<ul class="children collapse" id="sub-item-2">
				<shiro:hasPermission name="visit:approve">
					<li><a class="" href="approve"> <span
							class="glyphicon glyphicon-share-alt"></span> 用车审核
					</a></li>
				</shiro:hasPermission>
				<shiro:hasPermission name="visit:car">
					<li><a class="" href="car-manage"> <span
							class="glyphicon glyphicon-share-alt"></span> 车辆管理
					</a></li>
				</shiro:hasPermission>
				<shiro:hasPermission name="visit:driver">
					<li><a class="" href="driver-manage"> <span
							class="glyphicon glyphicon-share-alt"></span> 司机管理
					</a></li>
				</shiro:hasPermission>
				</ul></li>
			</check:hasAnyPermissions>
			
			<check:hasAnyPermissions name="visit:apply,visit:myapplication,visit:history">
			<li class="parent"><a data-toggle="collapse" href="#sub-item-3">
					<span class="glyphicon glyphicon-info-sign"></span> 公车使用 <span
					class="icon pull-right"><em
						class="glyphicon glyphicon-s glyphicon-plus"></em></span>
			</a>
				<ul class="children collapse" id="sub-item-3">
				<shiro:hasPermission name="visit:apply">
					<li><a class="" href="application-form"> <span
							class="glyphicon glyphicon-share-alt"></span> 申请用车
					</a></li>
				</shiro:hasPermission>
				<shiro:hasPermission name="visit:myapplication">
					<li><a class="" href="myapplication"> <span
							class="glyphicon glyphicon-share-alt"></span> 我的申请记录
					</a></li>
				</shiro:hasPermission>
				<shiro:hasPermission name="visit:history">
					<li><a class="" href="myUseHistory"> <span
							class="glyphicon glyphicon-share-alt"></span> 我的用车记录
					</a></li>
				</ul></li>
				</shiro:hasPermission>
			</check:hasAnyPermissions>
				
			<check:hasAnyPermissions name="visit:newtask,visit:taskhistory">
			<li class="parent"><a data-toggle="collapse" href="#sub-item-4">
					<span class="glyphicon glyphicon-info-sign"></span> 我的任务<span
					class="icon pull-right"><em
						class="glyphicon glyphicon-s glyphicon-plus"></em></span>
			</a>
				<ul class="children collapse" id="sub-item-4">
				<shiro:hasPermission name="visit:newtask">
					<li><a class="" href="mynewtask"> <span
							class="glyphicon glyphicon-share-alt"></span> 新的任务
					</a></li>
				</shiro:hasPermission>
				<shiro:hasPermission name="visit:taskhistory">
					<li><a class="" href="mytaskhistory"> <span
							class="glyphicon glyphicon-share-alt"></span> 我的任务记录
					</a></li>
				</shiro:hasPermission>
				</ul></li>
			</check:hasAnyPermissions>
			
			<shiro:hasPermission name="visit:track">
			<li><a href="track"><span
					class="glyphicon glyphicon-stats"></span> 行程监控 </a></li>
			</shiro:hasPermission>
			
			<shiro:hasPermission name="visit:report">
			<li><a href="report"><span
					class="glyphicon glyphicon-stats"></span> 使用报表 </a></li>
			</shiro:hasPermission>
			
			<li role="presentation" class="divider"></li>
			
			<li><a href="setting"><span
					class="glyphicon glyphicon-user"></span> 设置 </a></li>
		</ul>
	</div>
	<!--/.sidebar-->

	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="home"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">我的任务</li>
			</ol>
		</div>
		<!--/.row-->

		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">我的任务</h1>
			</div>
		</div>
		<!--/.row-->


		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">当前任务</div>
					<div class="panel-body">
						<p id="task"></p>
					</div>
				</div>
			</div>
		</div>
		<!--/.row-->


	</div>
	<!--/.main-->


	<script src="<%=basePath%>static/js/jquery-1.11.1.min.js"></script>
	<script src="<%=basePath%>static/js/bootstrap.min.js"></script>
	<script src="<%=basePath%>static/js/chart.min.js"></script>

	<script src="<%=basePath%>static/js/easypiechart.js"></script>

	<script src="<%=basePath%>static/js/bootstrap-datepicker.js"></script>
	<script src="<%=basePath%>static/js/bootstrap-table.js"></script>
	<script src="<%=basePath%>static/js/custom.js"></script>
	<script>
	$(function(){
		initCurrentTask();
	});
	
	function initCurrentTask(){
		$.ajax({
			'type' : 'post',
			'url' : 'driver/currentRoute',
			'success' : function(result){
				var taskPreviewHtml = "";
				if(result!=null&&result!=""){
					taskPreviewHtml = taskPreviewHtml + "<p><b>"+result.startpoint+
					"</b> --- <b>"+result.destination+"</b></p>";
				if(result.roundtrip===true){
					taskPreviewHtml = taskPreviewHtml+"<p>往返</p>";
				}else{
					taskPreviewHtml = taskPreviewHtml+"<p>单程</p>";
				}
				taskPreviewHtml = taskPreviewHtml+
					"<p>乘客：<b>"+result.passengerName+"</b></p>"+
					"<p>"+result.date+"</p>"+
					"<p>"+result.passengerPhone+"</p>";
				}else{
					taskPreviewHtml = "当前没有接受任何任务"
				}
				$('#taskpreview').html(taskPreviewHtml);
			}
		});
	}
	</script>
</body>

</html>
