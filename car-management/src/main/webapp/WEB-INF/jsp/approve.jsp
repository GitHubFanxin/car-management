<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
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
				<a class="navbar-brand" href="#"><span>System</span>Admin</a>
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
			<shiro:hasAnyRoles name="admin">
			<li class="parent"><a data-toggle="collapse" href="#sub-item-1">
					<span class="glyphicon glyphicon-th"></span> 系统管理 <span
					class="icon pull-right"><em
						class="glyphicon glyphicon-s glyphicon-plus"></em></span>
			</a>
				<ul class="children collapse" id="sub-item-1">
					<li><a class="" href="<%=basePath %>basedata/user"> <span
							class="glyphicon glyphicon-share-alt"></span> 用户管理
					</a></li>
					<li><a class="" href="<%=basePath %>basedata/role"> <span
							class="glyphicon glyphicon-share-alt"></span> 角色管理
					</a></li>
				</ul></li>
			</shiro:hasAnyRoles>
			
			<shiro:hasAnyRoles name="admin,approver">
			<li class="parent"><a data-toggle="collapse" href="#sub-item-2">
					<span class="glyphicon glyphicon-pencil"></span> 公车管理 <span
					class="icon pull-right"><em
						class="glyphicon glyphicon-s glyphicon-plus"></em></span>
			</a>
				<ul class="children collapse" id="sub-item-2">
					<li><a class="" href="<%=basePath %>manage/approve"> <span
							class="glyphicon glyphicon-share-alt"></span> 用车审核
					</a></li>
					<li><a class="" href="<%=basePath %>manage/car"> <span
							class="glyphicon glyphicon-share-alt"></span> 车辆管理
					</a></li>
					<li><a class="" href="<%=basePath %>manage/driver"> <span
							class="glyphicon glyphicon-share-alt"></span> 司机管理
					</a></li>
				</ul></li>
			</shiro:hasAnyRoles>
			
			<shiro:hasAnyRoles name="user">
			<li class="parent"><a data-toggle="collapse" href="#sub-item-3">
					<span class="glyphicon glyphicon-info-sign"></span> 公车使用 <span
					class="icon pull-right"><em
						class="glyphicon glyphicon-s glyphicon-plus"></em></span>
			</a>
				<ul class="children collapse" id="sub-item-3">
					<li><a class="" href="<%=basePath %>usecar/apply"> <span
							class="glyphicon glyphicon-share-alt"></span> 申请用车
					</a></li>
					<li><a class="" href="<%=basePath %>usecar/myapplication"> <span
							class="glyphicon glyphicon-share-alt"></span> 我的申请记录
					</a></li>
					<li><a class="" href="<%=basePath %>usecar/history"> <span
							class="glyphicon glyphicon-share-alt"></span> 我的用车记录
					</a></li>
				</ul></li>
			</shiro:hasAnyRoles>
				
			<shiro:hasAnyRoles name="driver">
			<li class="parent"><a data-toggle="collapse" href="#sub-item-4">
					<span class="glyphicon glyphicon-info-sign"></span> 我的任务<span
					class="icon pull-right"><em
						class="glyphicon glyphicon-s glyphicon-plus"></em></span>
			</a>
				<ul class="children collapse" id="sub-item-4">
					<li><a class="" href="<%=basePath %>driver/newtask"> <span
							class="glyphicon glyphicon-share-alt"></span> 新的任务
					</a></li>
					<li><a class="" href="<%=basePath %>driver/task-history"> <span
							class="glyphicon glyphicon-share-alt"></span> 我的任务记录
					</a></li>
				</ul></li>
			</shiro:hasAnyRoles>
			
			<shiro:hasAnyRoles name="admin">
			<li><a href="<%=basePath %>manage/report"><span
					class="glyphicon glyphicon-stats"></span> 使用报表 </a></li>
			</shiro:hasAnyRoles>
			
			<li role="presentation" class="divider"></li>
			
			<li><a href="<%=basePath %>basedata/setting"><span
					class="glyphicon glyphicon-user"></span> 设置 </a></li>
		</ul>
	</div>
	<!--/.sidebar-->

	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="<%=basePath %>home"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">公车使用</li>
			</ol>
		</div>
		<!--/.row-->

		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">公车使用</h1>
			</div>
		</div>
		<!--/.row-->

		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">用车申请管理</div>
					<div class="panel-body">
						<div id="toolbar">
							<button id="btn_check" class="btn btn-primary" disabled="disabled"
								data-toggle="modal" data-target="#driverModal">审核</button>
						</div>
						<table id="table"></table>
					</div>
				</div>
			</div>
		</div>
		
			<!-- Modal -->
	<div class="modal fade" id="driverModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">审核 选择司机</h4>
				</div>
				<div class="modal-body">
					<table id="driverTable"></table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="btn_driverOk" disabled="disabled"
						data-toggle="modal" data-target="#carModal">确认</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="carModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">审核 选择车辆</h4>
				</div>
				<div class="modal-body">
					<table id="carTable"></table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="btn_pass" disabled="disabled">确认</button>
				</div>
			</div>
		</div>
	</div>

	</div>

	<script src="<%=basePath%>static/js/jquery-1.11.1.min.js"></script>
	<script src="<%=basePath%>static/js/bootstrap.min.js"></script>
	<script src="<%=basePath%>static/js/chart.min.js"></script>

	<script src="<%=basePath%>static/js/easypiechart.js"></script>

	<script src="<%=basePath%>static/js/bootstrap-datepicker.js"></script>
	<script src="<%=basePath%>static/js/bootstrap-table.js"></script>
	<script src="<%=basePath%>static/js/custom.js"></script>
	<script>
	
		$(function(){
			$('#table').bootstrapTable({
				method:"post",
				contentType:"application/x-www-form-urlencoded",
				pagination:true,
				showToggle:true,
				showRefresh:true,
				showColumns:true,
				singleSelect:true,
				rowStyle: rowStyle,
				search:true,
				clickToSelect:true,
				toolbar:"#toolbar",
				url: "<%=basePath%>manage/approve/unapproved-list",
				sidePagination: 'server',
				columns: [{
				checkbox:true
				},{ 
					field: "applicationId",
					title: "申请编号",
					sortable: true,
				},{
					field: "applicantName",
					title: "申请人"
				},{ 
					field: "startpoint",
					title: "出发地"
				},{ 
					field: "destination",
					title: "目的地"
				},{
					field: "roundtrip",
					title: "往返"
				},{
					field: "applyDate",
					title: "申请日期"
				},{
					field: "state",
					title: "状态"
				}]
			});
			//$('#btn_check').click(pass);
			$('#btn_check').click(driverTableInit);
			$('#btn_driverOk').click(carTableInit);
			$('#btn_pass').click(pass);
			$('#table').on('check.bs.table',function(row,e){
				$("#btn_check").attr("disabled",false);
			});
			$('#table').on('uncheck.bs.table',function(row,e){
				$("#btn_check").attr("disabled",true);
			});
		});
		
		$.postJSON = function(url,jsondata,callback){//JSON请求
			return jQuery.ajax({
				'type' : 'POST',
				'url' : url,
				'contentType' : 'application/json',
				'data' : JSON.stringify(jsondata),
				'dataType' : 'json',
				'success' : callback
			});
		};
		
		var selectedDriverId;
		var selectedCarId;
		
		function pass(){
			var applicationData = $('#table').bootstrapTable('getSelections');
			var driverData = $('#driverTable').bootstrapTable('getSelections');
			var carData = $('#carTable').bootstrapTable('getSelections');
			var json = {
					"applicationId" : applicationData[0].applicationId,
					"driverId" : driverData[0].driverId,
					"carId" : carData[0].carId
			}
			url = "approve/pass";
			 $.postJSON(url,json,function(result){
				 $("#driverModal").modal("hide");
				 $("#carModal").modal("hide");
					$("#bt_pass").attr("disabled",true);
				});
		}
		
		function saveDriver(){
			var rowData = $('#driverTable').bootstrapTable('getSelections');
			selectedDriverId = rowData[0].driverId;
		}
		
		function saveCar(){
			var rowData = $('#carTable').bootstrapTable('getSelections');
			selectedDriverId = rowData[0].carId;
		}
		
		function driverTableInit(){
			$('#driverTable').bootstrapTable({
				method:"post",
				contentType:"application/x-www-form-urlencoded",
				pagination:true,
				showToggle:true,
				showRefresh:true,
				showColumns:true,
				singleSelect:true,
				rowStyle: rowStyle,
				search:true,
				clickToSelect:true,
				url: '<%=basePath%>manage/driver/list',
				sidePagination: 'server',
				columns: [{
				checkbox:true
				},{ 
					field: "workNum",
					title: "工号",
					sortable: true,
				},{ 
					field: "realname",
					title: "姓名",
					sortable: true,
				},{ 
					field: "state",
					title: "状态"
				}]
			});
			$('#driverTable').on('check.bs.table',function(row,e){
				$("#btn_driverOk").attr("disabled",false);
			});
			$('#driverTable').on('uncheck.bs.table',function(row,e){
				$("#btn_driverOk").attr("disabled",true);
			});
		}
		
		function carTableInit(){
			$('#carTable').bootstrapTable({
				method:"post",
				contentType:"application/x-www-form-urlencoded",
				pagination:true,
				showToggle:true,
				showRefresh:true,
				showColumns:true,
				singleSelect:true,
				rowStyle: rowStyle,
				search:true,
				clickToSelect:true,
				url: '<%=basePath%>manage/car/list',
				sidePagination: 'server',
				columns: [{
				checkbox:true
				},{ 
					field: "carNum",
					title: "车辆编号",
					sortable: true,
				},{ 
					field: "carName",
					title: "车辆名称"
				},
				{ 
					field: "state",
					title: "车辆状态"
				},{
					field: "available",
					title: "是否可用"
				}]
			});
			$('#carTable').on('check.bs.table',function(row,e){
				$("#btn_pass").attr("disabled",false);
			});
			$('#carTable').on('uncheck.bs.table',function(row,e){
				$("#btn_pass").attr("disabled",true);
			});
		}
		
		
		
		function rowStyle(row, index) {
	        var classes = ['success', 'info', 'warning', 'danger'];
	
	        if (index % 2 === 0 ) {
	            return {
	                classes: classes[index/2%4]
	            };
	        }
	        return {};
	    }
	</script>
</body>

</html>
