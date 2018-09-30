/**
 * 栏目管理初始化
 */
var Xgt_wy_item = {
    id: "Xgt_wy_itemTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Xgt_wy_item.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: '栏目', field: 'item_id', visible: false, align: 'center', valign: 'middle'},
        {title: '栏目名称', field: 'item_nm', align: 'center', valign: 'middle', sortable: true},
        {title: '上级栏目', field: 'par_item_nm', align: 'center', valign: 'middle', sortable: true},
        {title: '栏目别名', field: 'item_nm_alias', align: 'center', valign: 'middle', sortable: true},
        {title: '栏目分类', field: 'item_cls', align: 'center', valign: 'middle', sortable: true},
        {title: '栏目描述', field: 'item_dsc', align: 'center', valign: 'middle', sortable: true},
        {title: '排序', field: 'seq_no', align: 'center', valign: 'middle', sortable: true},
        {title: '状态', field: 'st_id', align: 'center', valign: 'middle', sortable: true},
        {title: '操作人', field: 'oper_user', align: 'center', valign: 'middle', sortable: true}
    ];
};

/**
 * 检查是否选中
 */
Xgt_wy_item.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Xgt_wy_item.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加栏目
 */
Xgt_wy_item.openAddXgt_wy_item = function () {
    var ItemId = Xgt_wy_item.par_item_id;
    if(ItemId==undefined){
        Feng.error("请在左侧选择分类!");
    }else
    {var index = layer.open({
        type: 2,
        title: '添加栏目',
        area: ['70%', '300px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/xgt_wy_item/xgt_wy_item_add/'+ItemId
    });
    this.layerIndex = index;}
};

/**
 * 打开查看栏目详情_修改
 */
Xgt_wy_item.openXgt_wy_itemDetail_update = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '栏目详情_修改',
            area: ['70%', '300px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/xgt_wy_item/xgt_wy_item_update/' + Xgt_wy_item.seItem.item_id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除栏目
 */
Xgt_wy_item.delete = function () {
    if (this.check()) {
        var operation = function(){
            var ajax = new $ax(Feng.ctxPath + "/xgt_wy_item/delete", function (data) {
                Feng.success("删除成功!");
                Xgt_wy_item.table.refresh();
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("xgt_wy_itemId",Xgt_wy_item.seItem.item_id);
            ajax.start();
        }
        Feng.confirm("是否刪除该栏目?", operation);
    }
};

/**
 * 查询栏目列表
 */
Xgt_wy_item.search = function () {
    var queryData = {};

    /* queryData['par_item_id'] = Xgt_wy_item.par_item_id;
     console.log(Xgt_wy_item.par_item_id);

     queryData['item_nm'] = $("#item_nm").val()*/;
    queryData['condition'] = $("#condition").val();
    queryData['itemId']=Xgt_wy_item.par_item_id;

    Xgt_wy_item.table.refresh({query: queryData});
};

Xgt_wy_item.onClickItem = function(e, treeId, treeNode) {
    Xgt_wy_item.par_item_id = treeNode.id;
    console.log(Xgt_wy_item.par_item_id);
    console.log(treeNode);
    Xgt_wy_item.search();
}

$(function () {
    var defaultColunms = Xgt_wy_item.initColumn();
    var table = new BSTable("Xgt_wy_itemTable", "/xgt_wy_item/list2", defaultColunms);
    table.setPaginationType("client");
    Xgt_wy_item.table = table.init();

    var ztree = new $ZTree("itemtree", "/xgt_wy_item/itemTree");
    ztree.bindOnClick(Xgt_wy_item.onClickItem);
    ztree.init();
});

/**
 * 导出栏目
 */
Xgt_wy_item.export = function () {
    window.location.href=Feng.ctxPath + "/xgt_wy_item/export";
};

/**
 * 打开查看栏目详情
 */
Xgt_wy_item.openXgt_wy_itemDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '栏目详情',
            area: ['70%', '300px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/xgt_wy_item/xgt_wy_item_detail/' + Xgt_wy_item.seItem.item_id
        });
        this.layerIndex = index;
    }
};

/**
 * 收集数据
 */
Xgt_wy_item.collectData = function() {
    this .set('item_id') .set('item_nm') .set('item_nm_alias') .set('item_dsc') .set('item_cls') .set('par_item_id') .set('seq_no') .set('st_id') .set('oper_user');
}

/**
 * 添加栏目
 */
Xgt_wy_item.add = function () {
    alert(this.collectData());
    var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/xgt_wy_item/add", function (data) {
            Feng.success("添加成功!");
            Xgt_wy_item.table.refresh();
        }, function (data) {
            Feng.error("添加失败!" + data.responseJSON.message + "!");
        });
        ajax.start();
    }
    Feng.confirm("是否添加该栏目?", operation);
};
