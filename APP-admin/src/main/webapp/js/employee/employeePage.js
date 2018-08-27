/**
 * 员工管理
 */
$(function (){
	//select2 多选
    $("#rid").select2({
        language: "zh-CN", //设置 提示语言
        maximumSelectionLength: 3,  //设置最多可以选择多少项
        //width: "100%", //设置下拉框的宽度
        placeholder: "请选择",
        tags: false  //输入无效
    });
    Employee.formValidator();
    Employee.init();
});
//表格数据展示
var Employee = function (){
    return{
        init:function (){
        	
            $('#employee-table').bootstrapTable({
                url: "employee/getEmployeeList",
                method:"post",
                dataType: "json",
                contentType: "application/x-www-form-urlencoded",
                striped:true,//隔行变色
                cache:false,  //是否使用缓存
                showColumns:false,// 列
                toobar:'#toolbar',
                pagination: true, //分页
                sortable: false, //是否启用排序
                singleSelect: false,
                search:false, //显示搜索框
                buttonsAlign: "right", //按钮对齐方式
                showRefresh:false,//是否显示刷新按钮
                sidePagination: "server", //服务端处理分页
                pageSize : 5, //默认每页条数
                pageNumber : 1, //默认分页
                pageList:[5, 10, 20,30],//分页步进值
                smartDisplay:false,
                toolbar:"#toolbar",
                showColumns : false, //显示隐藏列
                uniqueId: "employee_id", //每一行的唯一标识，一般为主键列
                queryParamsType:'',
                queryParams: Employee.queryParams,//传递参数（*）
                columns : [{
                    field : "name",
                    title : "姓名",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                }, {
                    field : "sex",
                    title : "性别",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                }, {
                    field : "employee_no",
                    title : "员工编号",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                }, {
                    field : "mobile",
                    title : "手机号码",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                }, {
                    field : "activated_state",
                    title : "状态",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                },{
                    field: 'operate',
                    title: '操作',
                    class : 'col-md-2',
                    align: 'center',
                    valign: 'middle',
                    formatter: Employee.operateFormatter,
                }],
                formatLoadingMessage : function() {
                    return "请稍等，正在加载中...";
                },
                formatNoMatches : function() {
                    return '无符合条件的记录';
                }
            });
        },
        queryParams:function(params){
            var temp = {
                pageSize: params.pageSize,  //页面大小
                pageNumber: params.pageNumber, //页码
                employeeNo: $("#search_employee_no").val(),
                employeeName:$("#search_employee_name").val(),
            };
            return temp;
        },
        operateFormatter:function(value, row, index){/*employeeManager:updateRole*/
            return ['<shiro:hasPermission name="employeeManager:updateRole"><button type="button" class=" btn btn-warning" onclick="Employee.getRole('+row.employee_id+')">角色</button></shiro:hasPermission>',
                '<shiro:hasPermission name="employeeManager:update"><button type="button" class=" btn btn-info" onclick="Employee.openUpdateModal('+row.employee_id+')">修改</button></shiro:hasPermission>',
                '<shiro:hasPermission name="employeeManager:delete"><button class=" btn btn-danger" type="button" onclick="Employee.deleteEmployee('+row.employee_id+')">删除</button></shiro:hasPermission>'
            ].join('');
        },
        //角色分配
        getRole:function(employeeId){
            $("#employeeId").val(employeeId);
            $.ajax({
                url:'employee/getRole',
                dataType:'json',
                type:'post',
                traditional:true,
                data:{
                	employeeId:employeeId
                },
                
                success:function(data){
                	
                    $("#rid").empty();
                    $.each(data.role,function(index,items){
                    	
                        $("#rid").append("<option value='"+items.id+"'>"+items.roleName+"</option>");
                    });
                    if((data.userRole!=null)){
                    	
                        $.each(data.userRole,function(index,items){
                        	
                            $("#rid").val(data.userRole).trigger("change");//select2 选中
                        });
                    }else{
                        $("#rid").val(0).trigger("change");
                    }
                },
                error:function(){
                    $.alert({
                        title: '提示信息！',
                        content: '请求失败！',
                        type: 'red'
                    });
                }
            })
            $("#roleDlg").modal('show');
        },
        //保存修改角色
        saveRole:function(){
            var employeeId=$("#employeeId").val();
            var rids=$("#rid").val();//select2 获取多选值
            
            $.ajax({
                url:'employee/updateEmployeeRole',
                dataType:'json',
                type:'post',
                traditional:true,
                data:{
                    employeeId:employeeId,
                    rid:rids
                },
                success:function(data){
                    if(data){
                        $.alert({
                            title: '提示信息！',
                            content: '保存成功！',
                            type: 'blue'
                        });
                        Employee.closeDlg();
                        $("#employee-table").bootstrapTable('refresh');
                    }else{
                        $.alert({
                            title: '提示信息！',
                            content: '保存失败！',
                            type: 'red'
                        });
                       
                    }
                }
            })
        },
        //修改前，打开模态框
        openUpdateModal:function(employeeId){
            $.ajax({
                url:'employee/getEmployeeById',
                dataType:'json',
                type:'post',
                data:{
                	employeeId:employeeId
                },
                success:function(data){
                    $("#update_employee_id").val(data.employee.employeeId);
                    $("#update_employee_name").val(data.employee.name);
                    $("#update_employee_no").val(data.employee.employeeNo);
                    if(data.employee.sex==0){
                    	  document.getElementById("update_employee_sex0").checked = true;
                    	}
                    	if(data.employee.sex==1){
                    	  document.getElementById("update_employee_sex1").checked = true;
                    	}
                    $("#update_employee_mobile").val(data.employee.mobile);
                    $("#updateDlg").modal('show');
                },
                error:function(){
                    $.alert({
                        title: '提示信息！',
                        content: '请求失败！',
                        type: 'red'
                    });
                }
            });
        },
        //修改用户
        updateEmployee:function(){
            if($("#updateForm").data("bootstrapValidator").validate().isValid()){
                $.ajax({
                    url:'employee/updateEmployee',
                    dataType:'json',
                    type:'post',
                    data:$("#updateForm").serialize(),
                    success:function(data){
                        if(data){
                            $.alert({
                                title: '提示信息！',
                                content: '修改成功！',
                                type: 'blue'
                            });
                            Employee.closeDlg();
                            $("#employee-table").bootstrapTable('refresh');
                        }else{
                            $.alert({
                                title: '提示信息！',
                                content: '修改失败！',
                                type: 'red'
                            });
                        }
                       
                    }
                });
            }
        },
        //删除
        deleteEmployee:function(employeeId){
            $.confirm({
                title: '提示信息!',
                content: '您确定要删除这个商户吗？',
                type: 'blue',
                typeAnimated: true,
                buttons: {
                    确定: {
                        action: function(){
                        	
                            $.ajax({
                                url:'employee/deleteEmployee',
                                dataType:'json',
                                type:'post',
                                data:{
                                	employeeId:employeeId
                                },
                                success:function(data){
                                    if(data){
                                        $.alert({
                                            title: '提示信息！',
                                            content: '删除成功!',
                                            type: 'blue'
                                        });
                                    }else{
                                        $.alert({
                                            title: '提示信息！',
                                            content: '删除失败!',
                                            type: 'red'
                                        });
                                    }
                                    $("#employee-table").bootstrapTable('refresh');
                                },
                                error:function(){
                                    $.alert({
                                        title: '提示信息！',
                                        content: '请求失败！',
                                        type: 'red'
                                    });
                                }
                            });
                        }
                    },
                    取消: function () {
                    }
                }
            });
        },
        //添加，打开模态框
        openDlg:function(){
            $("#addDlg").modal('show');
        },
        //添加用户
        saveEmployee:function(){
            if($("#addForm").data('bootstrapValidator').validate().isValid()){
                $.ajax({
                    url:'employee/saveEmployee',
                    type:'post',
                    dataType:'json',
                    data:$("#addForm").serialize(),
                    success:function(data){
                        if(data){
                            $.alert({
                                title: '提示信息！',
                                content: '添加成功!',
                                type: 'blue'
                            });
                        }else{
                            $.alert({
                                title: '提示信息！',
                                content: '添加失败！',
                                type: 'red'
                            });
                        }
                        $("#employee-table").bootstrapTable('refresh');
                        Employee.closeDlg();
                    },
                    error:function(){
                        $.alert({
                            title: '提示信息！',
                            content: '请求失败！',
                            type: 'red'
                        });
                    }
                });
            }
        },
        //关闭模态框
        closeDlg:function () {
            $("#roleDlg").modal('hide');
            $("#updateDlg").modal('hide');
            $("#addDlg").modal('hide');
            $("input[type=reset]").trigger("click");
            $('#addForm').data('bootstrapValidator', null);
            $('#updateForm').data('bootstrapValidator', null);
            Employee.formValidator();
        },
        formValidator:function () {
            $("#addForm").bootstrapValidator({
                fields:{
                	employeeName:{
                        validators:{
                            notEmpty:{
                                message:"姓名不能为空"
                            },
                            stringLength:{
                                max:20,
                                message:"字符长度不能超过20个字符"
                            }
                        }
                    },
                    employeeNo:{
                        validators:{
                            notEmpty:{
                                message:"员工编号不能为空"
                            },
                            stringLength:{
                                max:20,
                                message:"字符长度不能超过20个字符"
                            }
                        }
                    }
                }
            });


            $("#updateForm").bootstrapValidator({
                fields:{
                	employeeName:{
                        validators:{
                            notEmpty:{
                                message:"姓名不能为空！"
                            },
                            stringLength:{
                                max:20,
                                message:"字符长度不能超过20个字符"
                            }
                        }
                    }
                }
            });
        },
        //搜索
        searchEmployee:function () {
            $("#employee-table").bootstrapTable('refresh');
        },
        //清空
        empty:function () {
            $("#search_employee_no").val('');
            $("#search_employee_name").val('');
            $("#employee-table").bootstrapTable('refresh');
        }
    }
}();

