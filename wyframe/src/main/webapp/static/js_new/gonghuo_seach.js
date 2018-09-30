/**
 * 生产厂商管理初始化
 */
var Xgt_goods_prd_vendor = {
    id: "Xgt_goods_prd_vendorTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Xgt_goods_prd_vendor.initColumn = function () {
	return [
        {field: 'selectItem', radio: true},
       	{title: '合作伙伴', field: 'prd_vendor_id', visible: false, align: 'center', valign: 'middle'},
        {title: '合作伙伴名称', field: 'prd_vendor_nm', align: 'center', valign: 'middle', sortable: true},
        {title: '合作伙伴别名', field: 'prd_vendor_alias', align: 'center', valign: 'middle', sortable: true},
        {title: '联系人', field: 'prd_vendor_man', align: 'center', valign: 'middle', sortable: true},
        {title: '联系人邮箱', field: 'man_email', align: 'center', valign: 'middle', sortable: true},
        {title: '联系人手机号', field: 'man_phone', align: 'center', valign: 'middle', sortable: true},
        {title: '合伙类别', field: 'vendor_flg', align: 'center', valign: 'middle', sortable: true}
    ];
};

/**
 * 检查是否选中
 */
Xgt_goods_prd_vendor.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Xgt_goods_prd_vendor.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加生产厂商
 */
Xgt_goods_prd_vendor.openAddXgt_goods_prd_vendor = function () {
    var index = layer.open({
        type: 2,
        title: '添加生产厂商',
        area: ['100%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/xgt_goods_prd_vendor/xgt_goods_prd_vendor_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看生产厂商详情_修改
 */
Xgt_goods_prd_vendor.openXgt_goods_prd_vendorDetail_update = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '生产厂商详情_修改',
            area: ['100%', '100%'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/xgt_goods_prd_vendor/xgt_goods_prd_vendor_update/' + Xgt_goods_prd_vendor.seItem.prd_vendor_id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除生产厂商
 */
Xgt_goods_prd_vendor.delete = function () {
    if (this.check()) {
     var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/xgt_goods_prd_vendor/delete", function (data) {
            Feng.success("删除成功!");
            Xgt_goods_prd_vendor.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("xgt_goods_prd_vendorId",Xgt_goods_prd_vendor.seItem.prd_vendor_id);
        ajax.start();
    }
    	 Feng.confirm("是否刪除该生产厂商?", operation);
    }
};

/**
 * 查询生产厂商列表
 */
Xgt_goods_prd_vendor.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Xgt_goods_prd_vendor.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Xgt_goods_prd_vendor.initColumn();
    var table = new BSTable(Xgt_goods_prd_vendor.id, "/xgt_goods_prd_vendor/list", defaultColunms);
    table.setPaginationType("client");
    Xgt_goods_prd_vendor.table = table.init();
});

/**
 * 导出生产厂商
 */
Xgt_goods_prd_vendor.export = function () {
       window.location.href=Feng.ctxPath + "/xgt_goods_prd_vendor/export";
};

/**
 * 打开查看生产厂商详情
 */
Xgt_goods_prd_vendor.openXgt_goods_prd_vendorDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '生产厂商详情',
            area: ['100%', '100%'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/xgt_goods_prd_vendor/xgt_goods_prd_vendor_detail/' + Xgt_goods_prd_vendor.seItem.prd_vendor_id
        });
        this.layerIndex = index;
    }
};

/**
 * 收集数据
 */
Xgt_goods_prd_vendor.collectData = function() {
    this .set('prd_vendor_id') .set('prd_vendor_nm') .set('prd_vendor_alias') .set('prd_vendor_man') .set('man_email') .set('man_phone') .set('vendor_flg') .set('cpn_id') .set('cpn_branch_id') .set('st_id') .set('oper_user');
}

/**
 * 添加生产厂商
 */
Xgt_goods_prd_vendor.add = function () {
  	alert(this.collectData());
     var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/xgt_goods_prd_vendor/add", function (data) {
            Feng.success("添加成功!");
            Xgt_goods_prd_vendor.table.refresh();
        }, function (data) {
            Feng.error("添加失败!" + data.responseJSON.message + "!");
        });
        ajax.start();
    }
    	 Feng.confirm("是否添加该生产厂商?", operation);
};
