$('#entrepreneurListTable').bootstrapTable({
        url: '/adminpioneer/admin/entrepreneurList',   //请求后台的URL（*）
        method: 'post',                      //请求方式（*）
        striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                   //是否分页
        sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber: 1,                      //初始化加载第一页，默认第一页
        pageSize: 10,                       //单页记录值
        // pageList: [10, 25, 50, 100],        //分页步进值
        sortable: false,                    //是否启用排序
        sortOrder: "asc",                   //排序方式
        queryParams: function (params) {//请求服务器所传参数
            return {
                pageSize: params.limit,
                offset: params.offset
            }
        },//传递参数（*）
        toolbar: '#toolbar',                //工具按钮用哪个容器
        //search: true,                       //是否显示表格搜索
        strictSearch: true,                 //按回车健搜索
        showColumns: true,                  //是否显示所有的列
        showRefresh: true,                  //是否显示刷新按钮
        minimumCountColumns: 2,             //最少允许的列数
        clickToSelect: true,                //是否启用点击选中行
        uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
        responseHandler: responseHandler,//请求数据成功后，渲染表格前的方法
        columns: [{
            checkbox: true,
            visible: true                  //是否显示复选框
        }, {
            field: 'name',
            title: '标兵名称'
        }, {
            field: 'id',
            title: '操作',
            width: 120,
            align: 'center',
            formatter: function (value, row, index) {//操作栏的格式化
                var id = value;
                var result = "";
                result += "<a href='/adminpioneer/admin/entrepreneur/" + id + "' class='btn btn-xs'  title='编辑'><span class='glyphicon glyphicon-pencil'></span></a>";
                result += "<a href='javascript:;' class='btn btn-xs' onclick=\"deleteById('" + id + "')\" title='删除'><span class='glyphicon glyphicon-trash'></span></a>";
                return result;
            }
        }]
    }
);

function responseHandler(result) {
    return {
        total: result.total,
        rows: result.rows
    }
}

/*删除一条记录*/
function deleteById(id) {
    if (confirm("确定要删除吗？")) {
        $.ajax({
            type: "post",
            url: "/adminpioneer/admin/entrepreneurList/deleteById",
            contentType: 'application/json;charset=utf-8',  //发送信息至服务器时内容编码类型
            data: JSON.stringify({"id": id}),
            dataType: "json",
            async: true,//默认异步
            success: function (result) {
                alert(result.msg);
                //通过bootstrap table的refresh来重新加载数据
                $('#entrepreneurListTable').bootstrapTable('refresh');
            }
        });
    }
}

/*toolbar删除按钮，批量删除数据*/
$("#btn_delete").click(function () {
    var rows = $("#entrepreneurListTable").bootstrapTable('getSelections');
    if (rows.length == 0) {
        alert("请选择要删除的记录");
        return;
    }
    if (confirm("确定要删除吗？")) {
        var ids = '';
        for (var row of rows) {
            ids += row.id + ",";
        }
        ids = ids.substring(0, ids.length - 1);
        $.ajax({
            type: "post",
            url: "/adminpioneer/admin/entrepreneurList/deleteByIds",
            contentType: 'application/json;charset=utf-8',  //发送信息至服务器时内容编码类型
            data: JSON.stringify({"ids": ids}),
            dataType: "json",
            async: true,//默认异步
            success: function (result) {
                alert(result.msg);
                //通过bootstrap table的refresh来重新加载数据
                $('#entrepreneurListTable').bootstrapTable('refresh');
            }
        });
    }
});

