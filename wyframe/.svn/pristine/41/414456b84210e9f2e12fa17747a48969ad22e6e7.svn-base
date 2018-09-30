/**
 * 商品管理管理初始化
 */
var Xgt_goods_product = {
    id: "Xgt_goods_productTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Xgt_goods_product.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: '键值', field: 'prd_id', visible: false, align: 'center', valign: 'middle'},
        {title: '名称', field: 'prd_nm', align: 'center', valign: 'middle', sortable: true}
        ,
        {title: '条码', field: 'prd_no', align: 'center', valign: 'middle', sortable: true}
        ,
        {title: '系列', field: 'prd_sn', align: 'center', valign: 'middle', sortable: true}
        ,
        {title: '型号', field: 'prd_model', align: 'center', valign: 'middle', sortable: true}
        ,
        {title: '规格', field: 'prd_spec', align: 'center', valign: 'middle', sortable: true}
        ,
        {title: '分类', field: 'prd_cls_nm', align: 'center', valign: 'middle', sortable: true}
        ,
        {title: '品牌', field: 'prd_brand_nm', align: 'center', valign: 'middle', sortable: true}
        ,
        {title: '单位', field: 'prd_unit_nm', align: 'center', valign: 'middle', sortable: true}
        ,
        {title: '采购价', field: 'prd_purchase', align: 'center', valign: 'middle', sortable: true}
        ,
        {title: '销售价', field: 'prd_price', align: 'center', valign: 'middle', sortable: true}
        ,
        {title: '状态', field: 'st_id', align: 'center', valign: 'middle', sortable: true}
    ];
};

/**
 * 检查是否选中
 */
Xgt_goods_product.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Xgt_goods_product.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加商品管理
 */
Xgt_goods_product.openAddXgt_goods_product = function () {
    var index = layer.open({
        type: 2,
        title: '添加商品管理',
        area: ['80%', '90%'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/xgt_goods_product/xgt_goods_product_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看商品管理详情_修改
 */
Xgt_goods_product.openXgt_goods_productDetail_update = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '商品管理详情_修改',
            area: ['80%', '90%'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/xgt_goods_product/xgt_goods_product_update/' + Xgt_goods_product.seItem.prd_id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除商品管理
 */
Xgt_goods_product.delete = function () {
    if (this.check()) {
        var operation = function(){
            var ajax = new $ax(Feng.ctxPath + "/xgt_goods_product/delete", function (data) {
                Feng.success("删除成功!");
                Xgt_goods_product.table.refresh();
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("xgt_goods_productId",Xgt_goods_product.seItem.prd_id);
            ajax.start();
        }
        Feng.confirm("是否刪除该商品管理?", operation);
    }
};

/**
 * 查询商品管理列表
 */
Xgt_goods_product.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    queryData['st_id'] = $("#st_id").val();
    queryData['prd_id'] = Xgt_goods_product.prd_id;
    Xgt_goods_product.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Xgt_goods_product.initColumn();
    var table = new BSTable(Xgt_goods_product.id, "/xgt_goods_product/list", defaultColunms);
    table.setPaginationType("client");
    Xgt_goods_product.table = table.init();

    var ztree = new $ZTree("producttree", "/xgt_goods_product/tree");
    ztree.bindOnClick(Xgt_goods_product.onClickProducts);
    ztree.init();
});

Xgt_goods_product.onClickProducts = function(e, treeId, treeNode) {
    Xgt_goods_product.prd_id = treeNode.id;
    console.log(Xgt_goods_product.prd_id);
    Xgt_goods_product.search();
}

/**
 * 导出商品管理
 */
Xgt_goods_product.export = function () {
    window.location.href=Feng.ctxPath + "/xgt_goods_product/export";
};

/**
 * 打开查看商品管理详情
 */
Xgt_goods_product.openXgt_goods_productDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '商品管理详情',
            area: ['80%', '90%'], //宽高
            fix: false, //不0定
            maxmin: true,
            content: Feng.ctxPath + '/xgt_goods_product/xgt_goods_product_detail/' + Xgt_goods_product.seItem.prd_id
        });
        this.layerIndex = index;
    }
};

/**
 * 收集数据
 */
Xgt_goods_product.collectData = function() {
    this .set('prd_id') .set('prd_brand_id') .set('prd_vendor_id') .set('prd_cls_id') .set('prd_unit_id') .set('prd_no') .set('prd_nm') .set('prd_model') .set('prd_nm_alias') .set('prd_nm_dsc') .set('prd_nm_img') .set('prd_crt_dt') .set('prd_price') .set('cpn_id');
}

/**
 * 添加商品管理
 */
Xgt_goods_product.add = function () {
    alert(this.collectData());
    var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/xgt_goods_product/add", function (data) {
            Feng.success("添加成功!");
            Xgt_goods_product.table.refresh();
        }, function (data) {
            Feng.error("添加失败!" + data.responseJSON.message + "!");
        });
        ajax.start();
    }
    Feng.confirm("是否添加该商品管理?", operation);
};
