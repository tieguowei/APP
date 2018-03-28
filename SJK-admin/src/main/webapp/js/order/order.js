var Order = function (){
    return{
        init:function (){
            $('#orderList-table').bootstrapTable({
                url: "order/orderListByPage",
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
                pageList : [ 10, 20, 50, 100, 200, 500 ],//分页数
                toolbar:"#toolbar",
                showColumns : false, //显示隐藏列
                uniqueId: "id", //一每行的唯一标识，一般为主键列
                queryParamsType:'',
                queryParams: Order.queryParams,//传递参数（*）
                columns : [{
                    field : "order_no",
                    title : "订单编号",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                }, {
                    field : "merchant_name",
                    title : "商户名称",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                }, {
                    field : "nickname",
                    title : "购买用户",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                },{
                    field: 'operate',
                    title: '操作',
                    class : 'col-md-2',
                    align: 'center',
                    valign: 'middle',
                    formatter: Order.operateFormatter,
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
        queryParams:function (params){
            var temp = {
                pageSize: params.pageSize,  //页面大小
                pageNumber: params.pageNumber //页码
            };
            return temp;
        },
        operateFormatter:function(value, row, index) {
            return ['<shiro:hasPermission name="merchantManager:update"><button type="button" class=" btn btn-info" onclick="openUpdatePage('+row.id+')">修改</button></shiro:hasPermission>'
            ].join('');
        }
    }
}();

$(function (){
    Order.init();
})