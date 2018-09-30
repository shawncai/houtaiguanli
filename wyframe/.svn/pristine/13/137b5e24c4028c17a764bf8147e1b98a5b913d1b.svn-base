/**
 * 产品分类管理初始化
 */
var Xgt_goods_prd_cls = {
    id: "Xgt_goods_prd_clsTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Xgt_goods_prd_cls.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: '分类键值', field: 'prd_cls_id', visible: false, align: 'center', valign: 'middle'},
        {title: '分类名称', field: 'prd_cls_nm', align: 'center', valign: 'middle', sortable: true},
        {title: '上级分类', field: 'par_prd_cls_nm', align: 'center', valign: 'middle', sortable: true},
        {title: '分类代码', field: 'cls_code', align: 'center', valign: 'middle', sortable: true},
        {title: '是否序列号', field: 'sn_flg', align: 'center', valign: 'middle', sortable: true},
        {title: '物品数量', field: 'num', align: 'center', valign: 'middle', sortable: true}
    ];
};

/**
 * 检查是否选中
 */
Xgt_goods_prd_cls.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Xgt_goods_prd_cls.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加产品分类
 */
Xgt_goods_prd_cls.openAddXgt_goods_prd_cls = function () {

    var clsId = Xgt_goods_prd_cls.prd_cls_id;
    if(clsId==undefined){
        Feng.error("请在左侧选择分类!");
    }else{
        var index = layer.open({
            type: 2,
            title: '添加产品分类',
            area: ['80%', '350px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/xgt_goods_prd_cls/xgt_goods_prd_cls_add/' + clsId
        });
        this.layerIndex = index;
    }
};

/**
 * 打开查看产品分类详情_修改
 */
Xgt_goods_prd_cls.openXgt_goods_prd_clsDetail_update = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '产品分类详情_修改',
            area: ['80%', '350px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/xgt_goods_prd_cls/xgt_goods_prd_cls_update/' + Xgt_goods_prd_cls.seItem.prd_cls_id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除产品分类
 */
Xgt_goods_prd_cls.delete = function () {
    if (this.check()) {
        var operation = function(){
            var ajax = new $ax(Feng.ctxPath + "/xgt_goods_prd_cls/delete", function (data) {
                Feng.success("删除成功!");
                Xgt_goods_prd_cls.table.refresh();
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("xgt_goods_prd_clsId",Xgt_goods_prd_cls.seItem.prd_cls_id);
            ajax.start();
        }
        Feng.confirm("是否刪除该产品分类?", operation);
    }
};

/**
 * 查询产品分类列表
 */
Xgt_goods_prd_cls.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    queryData['prd_cls_id'] = Xgt_goods_prd_cls.prd_cls_id;
    queryData['prd_cls_nm'] = $("#prd_cls_nm").val();
    Xgt_goods_prd_cls.table.refresh({query: queryData});
};

Xgt_goods_prd_cls.onClickCls = function(e, treeId, treeNode) {
    Xgt_goods_prd_cls.prd_cls_id = treeNode.id;
    console.log(Xgt_goods_prd_cls.prd_cls_id);
    Xgt_goods_prd_cls.search();
}

$(function () {
    var defaultColunms = Xgt_goods_prd_cls.initColumn();
    var table = new BSTable(Xgt_goods_prd_cls.id, "/xgt_goods_prd_cls/list", defaultColunms);
    table.setPaginationType("client");
    Xgt_goods_prd_cls.table = table.init();

    var ztree = new $ZTree("clstree", "/xgt_goods_prd_cls/tree");
    ztree.bindOnClick(Xgt_goods_prd_cls.onClickCls);
    ztree.init();
});

/**
 * 导出产品分类
 */
Xgt_goods_prd_cls.export = function () {
    window.location.href=Feng.ctxPath + "/xgt_goods_prd_cls/export";
};

/**
 * 打开查看产品分类详情
 */
Xgt_goods_prd_cls.openXgt_goods_prd_clsDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '产品分类详情',
            area: ['80%', '350px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/xgt_goods_prd_cls/xgt_goods_prd_cls_detail/' + Xgt_goods_prd_cls.seItem.prd_cls_id
        });
        this.layerIndex = index;
    }
};

/**
 * 收集数据
 */
Xgt_goods_prd_cls.collectData = function() {
    this .set('prd_cls_id') .set('prd_cls_nm').set('cls_code').set('sn_flg') .set('prd_cls_alias') .set('par_prd_cls_id') .set('cpn_id') .set('cpn_branch_id') .set('st_id') .set('oper_user');
}

/**
 * 添加产品分类
 */
Xgt_goods_prd_cls.add = function () {
    alert(this.collectData());
    var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/xgt_goods_prd_cls/add", function (data) {
            Feng.success("添加成功!");
            Xgt_goods_prd_cls.table.refresh();
        }, function (data) {
            Feng.error("添加失败!" + data.responseJSON.message + "!");
        });
        ajax.start();
    }
    Feng.confirm("是否添加该产品分类?", operation);
};
