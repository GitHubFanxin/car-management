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
			<li><a href="home"><span
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
				<li class="active">角色管理</li>
			</ol>
		</div>
		<!--/.row-->

		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">角色管理</h1>
			</div>
		</div>
		<!--/.row-->


		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">角色列表</div>
					<div class="panel-body">
						<div id="toolbar">
							<button id="bt_add" class="btn btn-default" data-toggle="modal"
								data-target="#myModal">添加</button>
							<button id="bt_edit" disabled="disabled" class="btn btn-primary"
								data-toggle="modal" data-target="#myModal">编辑</button>
							<button id="bt_delete" disabled="disabled" class="btn btn-danger"
								data-toggle="modal" data-target="#delete_modal">删除</button>
						</div>
						<table id="table"></table>
					</div>
				</div>
			</div>
		</div>
		<!--/.row-->


	</div>
	<!--/.main-->

	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">新增</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<input type="text" class="form-control" id="roleName"
							placeholder="角色名">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" id="description"
							placeholder="角色描述">
					</div>
					<div class="form-group">
						<div id="permission-tree" class=""></div>
					</div>					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="save">保存</button>
				</div>
			</div>
		</div>
	</div>
<!--Delete Modal -->
<div class="modal fade" id="delete_modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header alert bg-warning">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">警告</h4>
            </div>
            <div class="modal-body">
                <p>确定要删除<span id="delete_span"></span>吗</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="delete">删除</button>
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
	<script src="<%=basePath%>static/js/bootstrap-treeview.min.js"></script>
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
				url: "<%=basePath%>role/list",
				sidePagination: 'server',
				columns: [{
				checkbox:true
				},{ 
				field: "roleName",
				title: "角色名",
				sortable: true,
				},
				{ 
				field: "description",
				title: "角色描述"
				}]
			});

			$('#table').on('check.bs.table',function(row,e){
				$("#bt_edit").attr("disabled",false);
				$("#bt_delete").attr("disabled",false);
			});
			$('#table').on('uncheck.bs.table',function(row,e){
				$("#bt_edit").attr("disabled",true);
				$("#bt_delete").attr("disabled",true);
			});
			
			$("#bt_add").click(add);
			$("#bt_edit").click(edit);
			$("#bt_delete").click(function(){
				var rowData = $('#table').bootstrapTable('getSelections');
				$("#delete_span").text(rowData[0].roleName);
			});
			$("#delete").click(deleterole);
			$("#save").click(save);			
		});
		
		var isEdit=false;
		
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

function save() {
		var saveUrl;
		
		var selected = $("#permission-tree").treeview('getChecked');
		var permissions = "";
		for(var i=0;i<selected.length;i++){
			if(i>0){
				permissions = permissions+","+selected[i].permission;
			}else{
				permissions = selected[i].permission;
			}
		}
		
		if(isEdit){
			saveUrl="role/edit";
			var rowData = $('#table').bootstrapTable('getSelections');
			var dataJson = {
					"roleId":rowData[0].roleId,
		            "roleName": $("#roleName").val(),
		            "description": $("#description").val(),
		            "permissions" : permissions
		        };
		}else{
			saveUrl="role/add";
			var dataJson = {
		            "roleName": $("#roleName").val(),
		            "description": $("#description").val(),
		            "permissions" : permissions
		        };
		}
        $.postJSON(saveUrl,dataJson,function(result){
        	$('#table').bootstrapTable('refresh');
			$("#myModal").modal("hide");
			$("#bt_edit").attr("disabled",true);
			$("#bt_delete").attr("disabled",true);
		});
    }
	
	function add(){
		isEdit=false;
		$("#myModalLabel").text("新增");
		$("#roleName").val("");
		$("#description").val("");
		treeinit(-1);
	}
	
	function deleterole(){
		var url="role/delete";
		var rowData = $('#table').bootstrapTable('getSelections');
		var dataJson = {
	            "roleId": rowData[0].roleId,
	        };
	        $.postJSON(url,dataJson,function(result){
	        	$('#table').bootstrapTable('refresh');
				$("#delete_modal").modal("hide");
				$("#bt_edit").attr("disabled",true);
				$("#bt_delete").attr("disabled",true);
			});
	}
	
	function edit(){
		$("#myModalLabel").text("编辑");
		isEdit=true;
		var rowData = $('#table').bootstrapTable('getSelections');
		treeinit(rowData[0].roleId);
		$("#roleName").val(rowData[0].roleName);
		$("#description").val(rowData[0].description);
	}
	
	function treeinit(roleId){
		var url = "role/permissiontree"
		var dataJson = {
	            "roleId": roleId,
	     };
		$.postJSON(url,dataJson,function(result){
			$("#permission-tree").treeview({
				data:result,
				showIcon:false,
				showCheckbox:true
			});
		});
		
	}
	
	
	
						    function rowStyle(row, index) {
						        var classes = ['success', 'info', 'warning', 'danger'];
						
						        if (index % 2 === 0) {
						            return {
						                classes: classes[index / 2 % 4]
						            };
						        }
						        return {};
						    }
	</script>
</body>

</html>
