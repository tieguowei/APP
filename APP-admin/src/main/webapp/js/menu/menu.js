$(function(){
    Menu.formValidator();
    Menu.init();
});
var Menu = function(){
    return{
        init:function(){
            $('#menu-table').bootstrapTable({
                url: "menu/getMenuList",
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
                pageList : [5, 10, 20,30],//分页数
                smartDisplay:false,
                toolbar:"#toolbar",
                showColumns : false, //显示隐藏列
                uniqueId: "id", //每一行的唯一标识，一般为主键列
                queryParamsType:'',
                queryParams: Menu.queryParams,//传递参数（*）
                columns : [{
                    field : "name_zh",
                    title : "菜单名称",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                }, {
                    field : "menu_url",
                    title : "请求地址",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                }, {
                    field : "menu_icon",
                    title : "图标样式",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                }, {
                    field : "menu_type",
                    title : "菜单类型",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                }, {
                    field : "permission",
                    title : "权限编码",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                }, {
                    field : "menu_status",
                    title : "状态",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                },{
                    field : "remark",
                    title : "菜单描述",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                }, {
                    field: 'operate',
                    title: '操作',
                    class : 'col-md-2',
                    align: 'center',
                    valign: 'middle',
                    formatter: Menu.operateFormatter,
                }],
                formatLoadingMessage : function() {
                    return "请稍等，正在加载中...";
                },
                formatNoMatches : function() {
                    return '无符合条件的记录';
                }
            });
        },
        //得到查询的参数
        queryParams:function(params){
            var temp = {
                pageSize: params.pageSize,  //页面大小
                pageNumber: params.pageNumber, //页码
                nameZh: $("#menu_name").val(),
            };
            return temp;
        },
        operateFormatter:function (value, row, index) {
            return ['<shiro:hasPermission name="menuManager:update"><button type="button" class=" btn btn-info" onclick="Menu.getValue('+row.menu_id+')">修改</button></shiro:hasPermission>',
                '&nbsp;&nbsp;&nbsp;<shiro:hasPermission name="menuManager:delete"><button class=" btn btn-danger" type="button" onclick="Menu.delMenu('+row.menu_id+')">删除</button></shiro:hasPermission>'
            ].join('');
        },
        //删除
        delMenu:function (id) {
            $.confirm({
                title: '提示信息!',
                content: '您确定要删除这个菜单吗？',
                type: 'blue',
                typeAnimated: true,
                buttons: {
                    确定: {
                        action: function(){
                            $.ajax({
                                url:'menu/deleteMenu',
                                dataType:'json',
                                type:'post',
                                data:{
                                    menuId:id
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
                                    $("#menu-table").bootstrapTable('refresh');
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
        //添加
        saveMenu:function(){
            if($("#addForm").data('bootstrapValidator').validate().isValid()){
        			flag = true;
        			//校验名称菜单名称是否存在
        			var nameZh = $("#nameZh").val();
        			$.ajax({
        				url:'menu/checkMenuName',
        				dataType:'json',
        				data:{nameZh:nameZh},
        				type:'post',
        				async:false, //同步 验证后再执行
        				success:function(data){
        					if(!data){
        						flag = false;
        						$.alert({
        					        title: '提示信息！',
        					        content: '菜单名称已存在！',
        					        type: 'red'
        					    });
        					}
        				}
        			})
        			if(flag){
        				 $.ajax({
        					url:'menu/saveMenu',
        					dataType:'json',
        					type:'post',
        					data:$("#addForm").serialize(),
        					success:function(data){
        						if(data){
        						    $.alert({
        						    	 title: '提示信息！',
        							     content: '添加成功!',
        							     type: 'blue'
        						    });
        						    $("#menu-table").bootstrapTable('refresh');
        						    Menu.closeDlg();
        						}else{
        							$.alert({
        						        title: '提示信息！',
        						        content: '添加失败！',
        						        type: 'red'
        						    });
        						}
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
            }
        },
        //打开  添加 加载pid为0的菜单
        addMenu:function () {
            $.ajax({
                url:'menu/getParentMenuList',
                dataType:'json',
                type:'post',
                success:function(data){
                    $("#parentId").empty();
                    $("#parentId").append("<option value='0'>请选择</option>");
                    $.each(data,function(index,items){
                        $("#parentId").append("<option value="+items.menuId+">"+items.menuName+"</option>");
                    });
                },
                error:function(){
                    $.alert({
                        title: '提示信息！',
                        content: '请求失败！',
                        type: 'red'
                    });
                }
            });
            $("#addDlg").modal('show');
        },
        //修改 回显
        getValue:function (id) {
            $.ajax({
                url:'menu/getMenuById',
                dataType:'json',
                type:'post',
                data:{
                    mid:id
                },
                success:function(data){
                    $("#update_menu_id").val(id);
                    $("#update_menu_name").val(data.menu.nameZh);
                    $("#update_menu_url").val(data.menu.menuUrl);
                    $("#update_menu_icon").val(data.menu.menuIcon);
                    $("#update_menu_type").val(data.menu.menuType);
                    $("#update_menu_permission").val(data.menu.permission);
                    $("#menu_update_remark").val(data.menu.remark);
                    if(data.menu.menuStatus=='2'){
                        $("#close").prop('checked',true);
                    }else{
                        $("#open").prop('checked',true);
                    }

                    $("#update_menu_parentId").empty();
                    $("#update_menu_parentId").append("<option value='0'>请选择</option>");
                    $.each(data.list,function(index,items){
                        if(data.menu.parentId==items.menuId){
                            $("#update_menu_parentId").append("<option selected value="+items.menuId+">"+items.menuName+"</option>");
                        }else{
                            $("#update_menu_parentId").append("<option value="+items.menuId+">"+items.menuName+"</option>");
                        }


                    });
                },
                error:function(){
                    alert("请求失败！");
                }
            });
            $("#updateDlg").modal('show');
        },
        //修改
        updateMenu:function () {
            if($("#updateForm").data('bootstrapValidator').validate().isValid()){
            	flag = true;
    			//校验名称菜单名称是否存在
    			var nameZh = $("#update_menu_name").val();
    			var menuId = $("#update_menu_id").val();
    			$.ajax({
    				url:'menu/checkMenuName',
    				dataType:'json',
    				data:{nameZh:nameZh,menuId:menuId},
    				type:'post',
    				async:false, //同步 验证后再执行
    				success:function(data){
    					if(!data){
    						flag = false;
    						$.alert({
    					        title: '提示信息！',
    					        content: '菜单名称已存在！',
    					        type: 'red'
    					    });
    					}
    				}
    			})
    			if(flag){
            	$.ajax({
                    url:'menu/updateMenu',
                    dataType:'json',
                    type:'post',
                    data:$("#updateForm").serialize(),
                    success:function(data){
                        if(data == '1'){
                            $.alert({
                                title: '提示信息！',
                                content: '修改成功!',
                                type: 'blue'
                            });
                            $("#menu-table").bootstrapTable('refresh');
                            Menu.closeDlg();
                        }else{
                            $.alert({
                                title: '提示信息！',
                                content: '修改失败！',
                                type: 'red'
                            });
                        }
                    },
                    error:function(){
                        $.alert({
                            title: '提示信息！',
                            content: '修改失败!',
                            type: 'red'
                        });
                    }
                });
            }
            }
        },
        //关闭
        closeDlg:function () {
            $("#addDlg").modal('hide');
            $("#updateDlg").modal('hide');
            $("input[type=reset]").trigger("click");
            $('#updateForm').data('bootstrapValidator', null);
            $('#addForm').data('bootstrapValidator', null);
            Menu.formValidator();
        },
        formValidator:function () {
            $("#addForm").bootstrapValidator({
                fields:{
                    nameZh:{
                        validators:{
                            notEmpty:{
                                message:"菜单名称不能为空"
                            },
                            stringLength:{
                                max:20,
                                message:"字符长度不能超过20个字符"
                            }
                        }
                    },
                    menuIcon:{
                        validators:{
                            notEmpty:{
                                message:'图标样式不能为空'
                            }
                        }
                    },
                    menuType:{
                        validators:{
                            notEmpty:{
                                message:'菜单类型不能为空'
                            }
                        }
                    },
                    permission:{
                        validators:{
                            notEmpty:{
                                message:'权限标识不能为空'
                            }
                        }
                    }
                }
            });


            $("#updateForm").bootstrapValidator({
                fields:{
                    nameZh:{
                        validators:{
                            notEmpty:{
                                message:"菜单名称不能为空"
                            },
                            stringLength:{
                                max:20,
                                message:"字符长度不能超过20个字符"
                            }
                        }
                    },
                    menuIcon:{
                        validators:{
                            notEmpty:{
                                message:'图标样式不能为空'
                            }
                        }
                    },
                    menuType:{
                        validators:{
                            notEmpty:{
                                message:'菜单类型不能为空'
                            }
                        }
                    },
                    permission:{
                        validators:{
                            notEmpty:{
                                message:'权限标识不能为空'
                            }
                        }
                    }
                }
            });
        },
        //搜索
        searchMenu:function () {
        $("#menu-table").bootstrapTable('refresh');
        },
        //清空
        empty:function () {
            $("#menu_name").val('');
            $("#menu-table").bootstrapTable('refresh');
        }
    }
}();


