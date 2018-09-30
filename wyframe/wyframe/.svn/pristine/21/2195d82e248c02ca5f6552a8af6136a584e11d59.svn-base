/**
 * 企业分支机构管理初始化
 */
var Xyd_cpn_branch = {
    id: "Xyd_cpn_branchTable",	// 表格id
    seItem: null,		// 选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Xyd_cpn_branch.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: '企业分支机构', field: 'cpn_branch_id', visible: false, align: 'center', valign: 'middle'},
        {title: '机构名称', field: 'cpn_branch_nm', align: 'center', valign: 'middle', sortable: true},
        {title: '标准编码', field: 'cpn_branch_code', align: 'center', valign: 'middle', sortable: true},
        {title: '负责人', field: 'user_id', align: 'center', valign: 'middle', sortable: true},
        {title: '联系电话', field: 'cpn_branch_phone', align: 'center', valign: 'middle', sortable: true},
        {title: '详细地址', field: 'cpn_area_desc', align: 'center', valign: 'middle', sortable: true},
        {title: '企业信息', field: 'cpn_nm', align: 'center', valign: 'middle', sortable: true},
        {title: '状态', field: 'st_id', align: 'center', valign: 'middle', sortable: true}
    ];
};

/**
 * 检查是否选中
 */
Xyd_cpn_branch.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Xyd_cpn_branch.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加企业分支机构
 */
Xyd_cpn_branch.openAddXyd_cpn_branch = function () {
// var cpn_id = $("#cpn_id").val();
    var cpn_id = Xyd_cpn_branch.cpn_id;
//	console.log(cpn_id);
    var index = layer.open({
        type: 2,
        title: '添加企业分支机构',
        area: ['80%', '400px'], // 宽高
        fix: false, // 不固定
        maxmin: true,
        content: Feng.ctxPath + '/xyd_cpn_branch/xyd_cpn_branch_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看企业分支机构详情_修改
 */
Xyd_cpn_branch.openXyd_cpn_branchDetail_update = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '企业分支机构详情_修改',
            area: ['80%', '400px'], // 宽高
            fix: false, // 不固定
            maxmin: true,
            content: Feng.ctxPath + '/xyd_cpn_branch/xyd_cpn_branch_update/' + Xyd_cpn_branch.seItem.cpn_branch_id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除企业分支机构
 */
Xyd_cpn_branch.delete = function () {
    if (this.check()) {
        var operation = function(){
            var ajax = new $ax(Feng.ctxPath + "/xyd_cpn_branch/delete", function (data) {
                Feng.success("删除成功!");
                Xyd_cpn_branch.table.refresh();
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("xyd_cpn_branchId",Xyd_cpn_branch.seItem.cpn_branch_id);
            ajax.start();
        }
        Feng.confirm("是否刪除该企业分支机构?", operation);
    }
};

/**
 * 查询企业分支机构列表
 */
Xyd_cpn_branch.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Xyd_cpn_branch.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Xyd_cpn_branch.initColumn();
    var table = new BSTable(Xyd_cpn_branch.id, "/xyd_cpn_branch/list2", defaultColunms);
    table.setPaginationType("client");
    Xyd_cpn_branch.table = table.init();
});

/**
 * 导出企业分支机构
 */
Xyd_cpn_branch.export = function () {
    window.location.href=Feng.ctxPath + "/xyd_cpn_branch/export";
};

/**
 * 打开查看企业分支机构详情
 */
Xyd_cpn_branch.openXyd_cpn_branchDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '企业分支机构详情',
            area: ['80%', '400px'], // 宽高
            fix: false, // 不固定
            maxmin: true,
            content: Feng.ctxPath + '/xyd_cpn_branch/xyd_cpn_branch_detail/' + Xyd_cpn_branch.seItem.cpn_branch_id
        });
        this.layerIndex = index;
    }
};

/**
 * 收集数据
 */
Xyd_cpn_branch.collectData = function() {
    this .set('cpn_branch_id') .set('cpn_id') .set('cpn_branch_nm') .set('cpn_branch_code') .set('cpn_branch_phone') .set('cpn_area_id') .set('cpn_area_desc') .set('user_id') .set('st_id');
}

/**
 * 添加企业分支机构
 */
Xyd_cpn_branch.add = function () {
    alert(this.collectData());
    var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/xyd_cpn_branch/add", function (data) {
            Feng.success("添加成功!");
            Xyd_cpn_branch.table.refresh();
        }, function (data) {
            Feng.error("添加失败!" + data.responseJSON.message + "!");
        });
        ajax.start();
    }
    Feng.confirm("是否添加该企业分支机构?", operation);
};
