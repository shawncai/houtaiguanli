/**
 * 订单管理初始化
 */
var Xyd_total = {
    id: "Xyd_totalTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Xyd_total.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
       	{title: '订单ID', field: 'msg_id', visible: false, align: 'center', valign: 'middle'},
        {title: '信息名称', field: 'msg_nm', align: 'center', valign: 'middle', sortable: true}
,
        {title: '信息描述', field: 'msg_desc', align: 'center', valign: 'middle', sortable: true}
,
        {title: '操作人', field: 'order_staff', align: 'center', valign: 'middle', sortable: true}
    ];
};

/**
 * 检查是否选中
 */
Xyd_total.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Xyd_total.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加订单
 */
Xyd_total.openAddXyd_total = function () {
    var index = layer.open({
        type: 2,
        title: '添加订单',
        area: ['100%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/xyd_total/xyd_total_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看订单详情_修改
 */
Xyd_total.openXyd_totalDetail_update = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '订单详情_修改',
            area: ['100%', '100%'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/xyd_total/xyd_total_update/' + Xyd_total.seItem.msg_id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除订单
 */
Xyd_total.delete = function () {
    if (this.check()) {
     var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/xyd_total/delete", function (data) {
            Feng.success("删除成功!");
            Xyd_total.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("xyd_totalId",Xyd_total.seItem.msg_id);
        ajax.start();
    }
    	 Feng.confirm("是否刪除该订单?", operation);
    }
};

/**
 * 查询订单列表
 */
Xyd_total.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Xyd_total.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Xyd_total.initColumn();
    var table = new BSTable(Xyd_total.id, "/xyd_total/list", defaultColunms);
    table.setPaginationType("client");
    Xyd_total.table = table.init();
});

/**
 * 导出订单
 */
Xyd_total.export = function () {
       window.location.href=Feng.ctxPath + "/xyd_total/export";
};

/**
 * 打开查看订单详情
 */
Xyd_total.openXyd_totalDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '订单详情',
            area: ['100%', '100%'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/xyd_total/xyd_total_detail/' + Xyd_total.seItem.msg_id
        });
        this.layerIndex = index;
    }
};

/**
 * 收集数据
 */
Xyd_total.collectData = function() {
    this .set('msg_id') .set('msg_nm') .set('msg_desc') .set('order_staff');
}

/**
 * 添加订单
 */
Xyd_total.add = function () {
  	alert(this.collectData());
     var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/xyd_total/add", function (data) {
            Feng.success("添加成功!");
            Xyd_total.table.refresh();
        }, function (data) {
            Feng.error("添加失败!" + data.responseJSON.message + "!");
        });
        ajax.start();
    }
    	 Feng.confirm("是否添加该订单?", operation);
};
