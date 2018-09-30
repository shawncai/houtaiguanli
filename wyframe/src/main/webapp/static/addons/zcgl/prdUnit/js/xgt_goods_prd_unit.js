/**
 * 产品单位管理初始化
 */
var Xgt_goods_prd_unit = {
    id: "Xgt_goods_prd_unitTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Xgt_goods_prd_unit.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
       	{title: '单位键值', field: 'prd_unit_id', visible: false, align: 'center', valign: 'middle'},
        {title: '单位名称', field: 'prd_unit_nm', align: 'center', valign: 'middle', sortable: true}
,
        {title: '单位代码', field: 'prd_unit_alias', align: 'center', valign: 'middle', sortable: true}
    ];
};

/**
 * 检查是否选中
 */
Xgt_goods_prd_unit.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Xgt_goods_prd_unit.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加产品单位
 */
Xgt_goods_prd_unit.openAddXgt_goods_prd_unit = function () {
    var index = layer.open({
        type: 2,
        title: '添加产品单位',
        area: ['80%', '30%'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/xgt_goods_prd_unit/xgt_goods_prd_unit_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看产品单位详情_修改
 */
Xgt_goods_prd_unit.openXgt_goods_prd_unitDetail_update = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '产品单位详情_修改',
            area: ['80%', '30%'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/xgt_goods_prd_unit/xgt_goods_prd_unit_update/' + Xgt_goods_prd_unit.seItem.prd_unit_id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除产品单位
 */
Xgt_goods_prd_unit.delete = function () {
    if (this.check()) {
     var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/xgt_goods_prd_unit/delete", function (data) {
            Feng.success("删除成功!");
            Xgt_goods_prd_unit.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("xgt_goods_prd_unitId",Xgt_goods_prd_unit.seItem.prd_unit_id);
        ajax.start();
    }
    	 Feng.confirm("是否刪除该产品单位?", operation);
    }
};

/**
 * 查询产品单位列表
 */
Xgt_goods_prd_unit.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Xgt_goods_prd_unit.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Xgt_goods_prd_unit.initColumn();
    var table = new BSTable(Xgt_goods_prd_unit.id, "/xgt_goods_prd_unit/findByName", defaultColunms);
    table.setPaginationType("client");
    Xgt_goods_prd_unit.table = table.init();
});

/**
 * 导出产品单位
 */
Xgt_goods_prd_unit.export = function () {
       window.location.href=Feng.ctxPath + "/xgt_goods_prd_unit/export";
};

/**
 * 打开查看产品单位详情
 */
Xgt_goods_prd_unit.openXgt_goods_prd_unitDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '产品单位详情',
            area: ['80%', '30%'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/xgt_goods_prd_unit/xgt_goods_prd_unit_detail/' + Xgt_goods_prd_unit.seItem.prd_unit_id
        });
        this.layerIndex = index;
    }
};

/**
 * 收集数据
 */
Xgt_goods_prd_unit.collectData = function() {
    this .set('prd_unit_id') .set('prd_unit_nm') .set('prd_unit_alias');
}

/**
 * 添加产品单位
 */
Xgt_goods_prd_unit.add = function () {
  	alert(this.collectData());
     var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/xgt_goods_prd_unit/add", function (data) {
            Feng.success("添加成功!");
            Xgt_goods_prd_unit.table.refresh();
        }, function (data) {
            Feng.error("添加失败!" + data.responseJSON.message + "!");
        });
        ajax.start();
    }
    	 Feng.confirm("是否添加该产品单位?", operation);
};
