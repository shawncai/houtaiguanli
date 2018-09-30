/**
 * 产品品牌管理初始化
 */
var Xgt_goods_prd_brand = {
    id: "Xgt_goods_prd_brandTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Xgt_goods_prd_brand.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: '品牌键值', field: 'prd_brand_id', visible: false, align: 'center', valign: 'middle'},
        {title: '品牌名称', field: 'prd_brand_nm', align: 'center', valign: 'middle', sortable: true},
        {title: '上级品牌', field: 'par_prd_brand_nm', align: 'center', valign: 'middle', sortable: true},
        {title: '品牌代码', field: 'prd_brand_alias', align: 'center', valign: 'middle', sortable: true},
        {title: '品牌介绍', field: 'prd_brand_remarks', align: 'center', valign: 'middle', sortable: true},
    ];
};

/**
 * 检查是否选中
 */
Xgt_goods_prd_brand.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Xgt_goods_prd_brand.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加产品品牌
 */
Xgt_goods_prd_brand.openAddXgt_goods_prd_brand = function () {
    var brandId = Xgt_goods_prd_brand.prd_brand_id;
    if(brandId==undefined){
        Feng.error("请在左侧选择分类!");
    }else {
        var index = layer.open({
            type: 2,
            title: '添加产品品牌',
            area: ['80%', '350px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/xgt_goods_prd_brand/xgt_goods_prd_brand_add/' + brandId
        });
        this.layerIndex = index;
    }
};

/**
 * 打开查看产品品牌详情_修改
 */
Xgt_goods_prd_brand.openXgt_goods_prd_brandDetail_update = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '产品品牌详情_修改',
            area: ['80%', '350px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/xgt_goods_prd_brand/xgt_goods_prd_brand_update/' + Xgt_goods_prd_brand.seItem.prd_brand_id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除产品品牌
 */
Xgt_goods_prd_brand.delete = function () {
    if (this.check()) {
        var operation = function(){
            var ajax = new $ax(Feng.ctxPath + "/xgt_goods_prd_brand/delete", function (data) {
                Feng.success("删除成功!");
                Xgt_goods_prd_brand.table.refresh();
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("xgt_goods_prd_brandId",Xgt_goods_prd_brand.seItem.prd_brand_id);
            ajax.start();
        }
        Feng.confirm("是否刪除该产品品牌?", operation);
    }
};

/**
 * 查询产品品牌列表
 */
Xgt_goods_prd_brand.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    queryData['prd_brand_id'] = Xgt_goods_prd_brand.prd_brand_id;
    Xgt_goods_prd_brand.table.refresh({query: queryData});
};
Xgt_goods_prd_brand.onClickBrand = function(e, treeId, treeNode) {
    Xgt_goods_prd_brand.prd_brand_id = treeNode.id;
    console.log( Xgt_goods_prd_brand.prd_brand_id );
    Xgt_goods_prd_brand.search();
}
$(function () {
    var defaultColunms = Xgt_goods_prd_brand.initColumn();
    var table = new BSTable(Xgt_goods_prd_brand.id, "/xgt_goods_prd_brand/list", defaultColunms);
    table.setPaginationType("client");
    Xgt_goods_prd_brand.table = table.init();

    var ztree = new $ZTree("brandtree", "/xgt_goods_prd_brand/tree");
    ztree.bindOnClick(Xgt_goods_prd_brand.onClickBrand);
    ztree.init();
});

/**
 * 导出产品品牌
 */
Xgt_goods_prd_brand.export = function () {
    window.location.href=Feng.ctxPath + "/xgt_goods_prd_brand/export";
};

/**
 * 打开查看产品品牌详情
 */
Xgt_goods_prd_brand.openXgt_goods_prd_brandDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '产品品牌详情',
            area: ['80%', '350px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/xgt_goods_prd_brand/xgt_goods_prd_brand_detail/' + Xgt_goods_prd_brand.seItem.prd_brand_id
        });
        this.layerIndex = index;
    }
};

/**
 * 收集数据
 */
Xgt_goods_prd_brand.collectData = function() {
    this .set('prd_brand_id').set('prd_brand_alias').set('prd_brand_remarks') .set('prd_brand_nm') .set('par_prd_brand_id') .set('cpn_id') .set('cpn_branch_id') .set('st_id') .set('oper_user');
}

/**
 * 添加产品品牌
 */
Xgt_goods_prd_brand.add = function () {
    alert(this.collectData());
    var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/xgt_goods_prd_brand/add", function (data) {
            Feng.success("添加成功!");
            Xgt_goods_prd_brand.table.refresh();
        }, function (data) {
            Feng.error("添加失败!" + data.responseJSON.message + "!");
        });
        ajax.start();
    }
    Feng.confirm("是否添加该产品品牌?", operation);
};
