/**
 * 调拨单管理初始化
 */
var Xgt_goods_store_bill = {
    id: "Xgt_goods_store_billTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Xgt_goods_store_bill.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
       	{title: '调拨单ID', field: 'bill_out_id', visible: false, align: 'center', valign: 'middle'},
        {title: '类型', field: 'req_bill_type', align: 'center', valign: 'middle', sortable: true}
,
        {title: '批次号', field: 'bill_no', align: 'center', valign: 'middle', sortable: true}
,
        {title: '调拨单描述', field: 'bill_dsc', align: 'center', valign: 'middle', sortable: true}
,
        {title: '出库仓库ID', field: 'out_cpn_store_id', align: 'center', valign: 'middle', sortable: true}
,
        {title: '企业信息ID', field: 'cpn_id', align: 'center', valign: 'middle', sortable: true}
,
        {title: '分支机构ID', field: 'cpn_branch_id', align: 'center', valign: 'middle', sortable: true}
,
        {title: '创建时间', field: 'cre_dt', align: 'center', valign: 'middle', sortable: true}
,
        {title: '操作人', field: 'oper_user', align: 'center', valign: 'middle', sortable: true}
,
        {title: '操作状态', field: 'st_id', align: 'center', valign: 'middle', sortable: true}
,
        {title: '审核状态', field: 'aud_st_id', align: 'center', valign: 'middle', sortable: true}
,
        {title: '审核人', field: 'aud_user', align: 'center', valign: 'middle', sortable: true}
    ];
};

/**
 * 检查是否选中
 */
Xgt_goods_store_bill.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Xgt_goods_store_bill.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加调拨单
 */
Xgt_goods_store_bill.openAddXgt_goods_store_bill = function () {
    var index = layer.open({
        type: 2,
        title: '添加调拨单',
        area: ['100%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/xgt_goods_store_bill_allot/xgt_goods_store_bill_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看调拨单_修改
 */
Xgt_goods_store_bill.openXgt_goods_store_billDetail_update = function () {
    if (this.check()&&Xgt_goods_store_bill.seItem.st_id=="编辑") {
        var index = layer.open({
            type: 2,
            title: '调拨单_修改',
            area: ['100%', '100%'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/xgt_goods_store_bill_allot/xgt_goods_store_bill_edit/' + Xgt_goods_store_bill.seItem.bill_req_id

        });
        this.layerIndex = index;
    }else{
        Feng.error("已提交不能修改");
    }
};

/**
 * 打开调拨单_审核
 */
Xgt_goods_store_bill.openXgt_goods_store_billDetail_review = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '调拨单审核',
            area: ['100%', '100%'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/xgt_goods_store_bill_allot/xgt_goods_store_bill_review/' + Xgt_goods_store_bill.seItem.bill_req_id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除调拨单
 */
Xgt_goods_store_bill.delete = function () {
    if (this.check()&&Xgt_goods_store_bill.seItem.aud_st_id=="待审核") {
     var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/xgt_goods_store_bill_allot/delete", function (data) {
            Feng.success("删除成功!");
            Xgt_goods_store_bill.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("id",Xgt_goods_store_bill.seItem.bill_req_id);
        ajax.start();
    }
    	 Feng.confirm("是否刪除该调拨单?", operation);
    }else{
        Feng.error("删除失败！");
    }
};

/**
 * 查询调拨单列表
 */
Xgt_goods_store_bill.search = function () {
    var queryData = {};
    queryData['name'] = $("#name").val();
    queryData['st_id'] = $("#st_id").val();
    queryData['aud_st_id'] = $("#aud_st_id").val();
    Xgt_goods_store_bill.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Xgt_goods_store_bill.initColumn();
    var table = new BSTable(Xgt_goods_store_bill.id, "/xgt_goods_store_bill_allot/list", defaultColunms);
    table.setPaginationType("client");
    Xgt_goods_store_bill.table = table.init();
});

/**
 * 导出调拨单
 */
Xgt_goods_store_bill.export = function () {
       window.location.href=Feng.ctxPath + "/xgt_goods_store_bill_allot/export";
};

/**
 * 打开查看调拨单详情
 */
Xgt_goods_store_bill.openXgt_goods_store_billDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '调拨单详情',
            area: ['100%', '100%'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/xgt_goods_store_bill_allot/xgt_goods_store_bill_detail/' + Xgt_goods_store_bill.seItem.bill_req_id
        });
        this.layerIndex = index;
    }
};

/**
 * 收集数据
 */
Xgt_goods_store_bill.collectData = function() {
    this .set('bill_out_id') .set('out_bill_type') .set('bill_no') .set('bill_dsc') .set('cpn_store_id') .set('cpn_id') .set('cpn_branch_id') .set('cre_dt') .set('oper_user').set('aud_st_id').set('aud_user');
}

/**
 * 添加调拨单
 */
Xgt_goods_store_bill.add = function () {
  	alert(this.collectData());
     var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/xgt_goods_store_bill_allot/add", function (data) {
            Feng.success("添加成功!");
            Xgt_goods_store_bill.table.refresh();
        }, function (data) {
            Feng.error("添加失败!" + data.responseJSON.message + "!");
        });
        ajax.start();
    }
    	 Feng.confirm("是否添加该调拨单?", operation);
};
