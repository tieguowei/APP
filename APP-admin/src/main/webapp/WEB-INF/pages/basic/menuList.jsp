<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/core.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>菜单管理</title>
<script type="text/javascript" src="${path }/static/js/bootstrap.js"></script>
	<link rel="stylesheet" href="${path}/css/menu/menu.css">
	<script src="${path}/js/menu/menu.js" charset="UTF-8" type="text/javascript"></script>
</head>
<body>

<div class="panel panel-default">
	<div class="panel-body">
		<form id="conForm" class=" form-inline">
			  <div class="form-group">
			    <div class="col-md-2 ">
			    <input type="text" class="form-control" id="menu_name" placeholder="请输入菜单名称">
			    </div>
			  </div>
  		<button type="button" onclick="Menu.searchMenu()" class="btn btn-info ">
   			<span class="glyphicon glyphicon-search" aria-hidden="true" >  搜索</span>
   		</button>
   		<button type="button" onclick="Menu.empty()" class="btn btn-danger ">
   			<span class="glyphicon glyphicon-remove" aria-hidden="true" > 清空</span>
   		</button>
</form>
	</div>
</div>


<div style="overflow:scroll;">
  <table id="menu-table" style="min-width:1200px;" class="table table-hover table-striped table-condensed table-bordered" />
</div>

<!--toolbar  -->
<div id="toolbar" class="btn-toolbar">

<shiro:hasPermission name="menuManager:add">
		
  <button onclick="Menu.addMenu()" type="button" class="btn btn-success">
      <span class="glyphicon glyphicon-plus" aria-hidden="true">添加</span>
    </button>
 </shiro:hasPermission>
   
</div>


<!-- 模态框（Modal） -->
<!-- 添加菜单 -->
<div id="addDlg" class="modal fade" tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">添加菜单</h4>
            </div>
            <div class="container">
			<form class="form-horizontal" id="addForm"  method="post">
			
			<div class="form-group">
			<label class="col-md-2 control-label">菜单名称：</label>
			<div class="col-md-3 ">
			<input type="text" id="nameZh" name="nameZh" class="form-control form-control-static" placeholder="请输入菜单名称">
			</div>
			</div>
			
			<div class="form-group">
			<label class="col-md-2 control-label">请求地址：</label>
			<div class="col-md-3">
			<input type="text"  name="menuUrl" class="form-control form-control-static" placeholder="请输入请求地址" >
			</div>
			</div>
			
			<div class="form-group">
			<label class="col-md-2 control-label">菜单类型：</label>
			<div class="col-md-3">
			<input type="text"  name="menuType" class="form-control form-control-static" placeholder="请输入菜单类型" >
			</div>
			</div>
			
			
			<div class="form-group">
			<label class="col-md-2 control-label">权限标识：</label>
			<div class="col-md-3">
			<input type="text"  name="permission" class="form-control form-control-static" placeholder="请输入权限标识" >
			</div>
			</div>
			
			<div class="form-group">
			<label class="col-md-2 control-label">父级菜单ID：</label>
			<div class="col-md-3">
			<select id="parentId" name="parentId" class="form-control form-control-static"></select>
			</div>
			</div>
			
			<div class="form-group">
			<label class="col-md-2 control-label">图标样式：</label>
			<div class="col-md-3">
			<input type="text"  name="menuIcon" class="form-control form-control-static" placeholder="请输入图标样式" >
			</div>
			</div>
			
			<div class="form-group">
			<label class="col-md-2 control-label">状态：</label>
			<div class="col-md-3" class="form-control form-control-static">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input   type="radio" checked name="menuStatus" value="1">启用&nbsp;&nbsp;&nbsp;&nbsp;
			<input  type="radio" name="menuStatus" value="2">禁用
			</div>
			</div>
			
			
			<div class="form-group">
			<label class="col-md-2 control-label">菜单描述：</label>
			<div class="col-md-3">
			<textarea rows="2" id="remark" name="remark" cols="20" class="form-control form-control-static" placeholder="请输入角色 描述"></textarea>
			</div>
			</div>
			
			
            <div class="modal-footer col-md-6">
            <!--用来清空表单数据-->
            <input type="reset" name="reset" style="display: none;" />
                <button type="button" class="btn btn-default" onclick="Menu.closeDlg()">关闭</button>
               <button type="button" onclick="Menu.saveMenu()" class="btn btn-primary">保存</button>
            </div>
            </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


<!-- 修改 -->
<div id="updateDlg" class="modal fade"  tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改菜单</h4>
            </div>
            <div class="container">
			<form class="form-horizontal" id="updateForm"  method="post">
			<div class="form-group">
			<label class="col-md-2 control-label">菜单名称：</label>
			<div class="col-md-3 ">
			<input type="hidden" id="update_menu_id" name="menuId">
			<input type="text" id="update_menu_name" name="nameZh" class="form-control form-control-static" placeholder="请输入菜单名称">
			</div>
			</div>

			<div class="form-group">
			<label class="col-md-2 control-label">请求地址：</label>
			<div class="col-md-3">
			<input type="text" id="update_menu_url" name="menuUrl" class="form-control form-control-static" placeholder="请输入请求地址" >
			</div>
			</div>


			<div class="form-group">
			<label class="col-md-2 control-label">菜单类型：</label>
			<div class="col-md-3">
			<input type="text"  id="update_menu_type" name="menuType" class="form-control form-control-static" placeholder="请输入菜单类型" >
			</div>
			</div>


			<div class="form-group">
			<label class="col-md-2 control-label">权限标识：</label>
			<div class="col-md-3">
			<input type="text"id="update_menu_permission"  name="permission" class="form-control form-control-static" placeholder="请输入权限标识" >
			</div>
			</div>



			<div class="form-group">
			<label class="col-md-2 control-label">父级菜单ID：</label>
			<div class="col-md-3">
			<select  id="update_menu_parentId" name="parentId" class="form-control form-control-static"></select>
			</div>
			</div>

			<div class="form-group">
			<label class="col-md-2 control-label">图标样式：</label>
			<div class="col-md-3">
			<input type="text" id="update_menu_icon" name="menuIcon" class="form-control form-control-static" placeholder="请输入图标样式" >
			</div>
			</div>

			<div class="form-group">
			<label class="col-md-2 control-label">状态：</label>
			<div class="col-md-3" class="form-control form-control-static">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input id="open"  type="radio" checked name="menuStatus" value="1">启用&nbsp;&nbsp;&nbsp;&nbsp;
			<input id="close" type="radio" name="menuStatus" value="2">禁用
			</div>
			</div>

			<div class="form-group">
			<label class="col-md-2 control-label">菜单描述：</label>
			<div class="col-md-3">
			<textarea rows="2" id="menu_update_remark" name="remark" cols="20" class="form-control form-control-static" placeholder="请输入角色 描述"></textarea>
			</div>
			</div>


            <div class="modal-footer col-md-6">
            <!--用来清空表单数据-->
            <input type="reset" name="reset" style="display: none;" />
                <button type="button" class="btn btn-default" onclick="Menu.closeDlg()">关闭</button>
               <button type="button" onclick="Menu.updateMenu()" class="btn btn-primary">保存</button>
            </div>
            </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

</body>
</html>