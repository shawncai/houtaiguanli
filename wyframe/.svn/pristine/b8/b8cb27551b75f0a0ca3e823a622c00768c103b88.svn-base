/**
 * 企业仓库管理初始化
 */
var Xyd_cpn_store = {
    id: "Xyd_cpn_storeTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Xyd_cpn_store.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: '企业仓库', field: 'cpn_store_id', visible: false, align: 'center', valign: 'middle'},
        {title: '企业信息', field: 'cpn_nm', align: 'center', valign: 'middle', sortable: true},
        {title: '分支机构', field: 'cpn_branch_nm', align: 'center', valign: 'middle', sortable: true},
        {title: '仓库名称', field: 'cpn_store_nm', align: 'center', valign: 'middle', sortable: true},
        {title: '上级仓库', field: 'par_store_id', align: 'center', valign: 'middle', sortable: true},
        {title: '标准编码', field: 'cpn_store_no', align: 'center', valign: 'middle', sortable: true},
        {title: '联系人', field: 'man_man', align: 'center', valign: 'middle', sortable: true},
        {title: '联系人邮箱', field: 'man_email', align: 'center', valign: 'middle', sortable: true},
        {title: '联系人电话', field: 'man_phone', align: 'center', valign: 'middle', sortable: true},
        {title: '联系人地址', field: 'man_address', align: 'center', valign: 'middle', sortable: true},
        {title: '状态', field: 'st_id', align: 'center', valign: 'middle', sortable: true},
        {title: '备注', field: 'remarks', align: 'center', valign: 'middle', sortable: true}
    ];
};

/**
 * 检查是否选中
 */
Xyd_cpn_store.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Xyd_cpn_store.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加企业仓库
 */
Xyd_cpn_store.openAddXyd_cpn_store = function () {
    var index = layer.open({
        type: 2,
        title: '添加企业仓库',
        area: ['80%', '450px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/xyd_cpn_store/xyd_cpn_store_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看企业仓库详情_修改
 */
Xyd_cpn_store.openXyd_cpn_storeDetail_update = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '企业仓库详情_修改',
            area: ['80%', '450px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/xyd_cpn_store/xyd_cpn_store_update/' + Xyd_cpn_store.seItem.cpn_store_id
        });
        this.layerIndex = index;
    }
};

$(function () {
    var defaultColunms = Xyd_cpn_store.initColumn();
    var table = new BSTable(Xyd_cpn_store.id, "/xyd_cpn_store/list", defaultColunms);
    table.setPaginationType("client");
    Xyd_cpn_store.table = table.init();
});

/**
 * 删除企业仓库
 */
Xyd_cpn_store.delete = function () {
    if (this.check()) {
        var operation = function(){
            var ajax = new $ax(Feng.ctxPath + "/xyd_cpn_store/delete", function (data) {
                Feng.success("删除成功!");
                Xyd_cpn_store.table.refresh();
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("xyd_cpn_storeId",Xyd_cpn_store.seItem.cpn_store_id);
            ajax.start();
        }
        Feng.confirm("是否刪除该企业仓库?", operation);
    }
};

/**
 * 查询企业仓库列表
 */
Xyd_cpn_store.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Xyd_cpn_store.table.refresh({query: queryData});
};

/**
 * 导出企业仓库
 */
Xyd_cpn_store.export = function () {
    window.location.href=Feng.ctxPath + "/xyd_cpn_store/export";
};

/**
 * 打开查看企业仓库详情
 */
Xyd_cpn_store.openXyd_cpn_storeDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '企业仓库详情',
            area: ['80%', '450px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/xyd_cpn_store/xyd_cpn_store_detail/' + Xyd_cpn_store.seItem.cpn_store_id
        });
        this.layerIndex = index;
    }
};

/**
 * 收集数据
 */
Xyd_cpn_store.collectData = function() {
    this .set('cpn_store_id') .set('cpn_id') .set('cpn_branch_id') .set('cpn_store_nm') .set('cpn_store_no') .set('par_store_id') .set('st_id') .set("man_man") .set("man_email") .set("man_phone") .set("man_address") .set("remarks");
}

/**
 * 添加企业仓库
 */
Xyd_cpn_store.add = function () {
    alert(this.collectData());
    var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/xyd_cpn_store/add", function (data) {
            Feng.success("添加成功!");
            Xyd_cpn_store.table.refresh();
        }, function (data) {
            Feng.error("添加失败!" + data.responseJSON.message + "!");
        });
        ajax.start();
    }
    Feng.confirm("是否添加该企业仓库?", operation);
};
