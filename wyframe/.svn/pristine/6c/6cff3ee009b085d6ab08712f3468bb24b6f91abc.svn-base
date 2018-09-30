/**
 * 企业员工管理初始化
 */
var Xyd_cpn_dept = {
    id: "Xyd_cpn_deptTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Xyd_cpn_dept.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: '健值', field: 'cpn_dept_id', visible: false, align: 'center', valign: 'middle'},
        {title: '部门', field: 'cpn_dept_nm', align: 'center', valign: 'middle', sortable: true},
        {title: '编码', field: 'cpn_dept_code', align: 'center', valign: 'middle', sortable: true},
        {title: '上级部门', field: 'par_cpn_dept_nm', align: 'center', valign: 'middle', sortable: true},
        {title: '状态', field: 'st_id', align: 'center', valign: 'middle', sortable: true},
        {title: '变更时间', field: 'cre_dt', align: 'center', valign: 'middle', sortable: true}
    ];
};

/**
 * 检查是否选中
 */
Xyd_cpn_dept.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Xyd_cpn_dept.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加企业员工
 */
Xyd_cpn_dept.openAddXyd_cpn_dept = function () {
    var deptId = Xyd_cpn_dept.cpn_dept_id;
    if(deptId==undefined){
        Feng.error("请在左侧选择分类!");
    }else {
        var index = layer.open({
            type: 2,
            title: '添加企业组织',
            area: ['80%', '300px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/xyd_cpn_dept/xyd_cpn_dept_add/' + deptId
        });
        this.layerIndex = index;
    }
};

/**
 * 打开查看企业员工详情_修改
 */
Xyd_cpn_dept.openXyd_cpn_deptDetail_update = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '企业员工详情_修改',
            area: ['60%', '300px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/xyd_cpn_dept/xyd_cpn_dept_update/' + Xyd_cpn_dept.seItem.cpn_dept_id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除企业员工
 */
Xyd_cpn_dept.delete = function () {
    if (this.check()) {
        var operation = function(){
            var ajax = new $ax(Feng.ctxPath + "/xyd_cpn_dept/delete", function (data) {
                Feng.success("删除成功!");
                Xyd_cpn_dept.table.refresh();
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("xyd_cpn_deptId",Xyd_cpn_dept.seItem.cpn_dept_id);
            ajax.start();
        }
        Feng.confirm("是否刪除该企业员工?", operation);
    }
};

/**
 * 查询企业员工列表
 */
Xyd_cpn_dept.search = function () {
    var queryData = {};
    queryData['cpn_dept_id'] = Xyd_cpn_dept.cpn_dept_id;
    console.log(Xyd_cpn_dept.cpn_dept_id);
    queryData['condition'] = $("#condition").val();
    queryData['cpn_dept_nm'] = $("#cpn_dept_nm").val();
    Xyd_cpn_dept.table.refresh({query: queryData});
};

Xyd_cpn_dept.onClickDept = function(e, treeId, treeNode) {
    Xyd_cpn_dept.cpn_dept_id = treeNode.id;
    Xyd_cpn_dept.search();
}

$(function () {
    var defaultColunms = Xyd_cpn_dept.initColumn();
    var table = new BSTable("Xyd_cpn_deptTable", "/xyd_cpn_dept/list", defaultColunms);
    table.setPaginationType("client");
    Xyd_cpn_dept.table = table.init();

    var ztree = new $ZTree("depttree", "/xyd_cpn_dept/tree/"+0);
    ztree.bindOnClick(Xyd_cpn_dept.onClickDept);
    ztree.init();
});

/**
 * 导出企业员工
 */
Xyd_cpn_dept.export = function () {
    window.location.href=Feng.ctxPath + "/xyd_cpn_dept/export";
};

/**
 * 打开查看企业员工详情
 */
Xyd_cpn_dept.openXyd_cpn_deptDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '企业员工详情',
            area: ['60%', '300px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/xyd_cpn_dept/xyd_cpn_dept_detail/' + Xyd_cpn_dept.seItem.cpn_dept_id
        });
        this.layerIndex = index;
    }
};

/**
 * 收集数据
 */
Xyd_cpn_dept.collectData = function() {
    this .set('cpn_dept_id') .set('cpn_id') .set('cpn_branch_id') .set('cpn_dept_nm') .set('cpn_dept_code') .set('par_cpn_dept_id') .set('st_id');
}

/**
 * 添加企业员工
 */
Xyd_cpn_dept.add = function () {
    alert(this.collectData());
    var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/xyd_cpn_dept/add", function (data) {
            Feng.success("添加成功!");
            Xyd_cpn_dept.table.refresh();
        }, function (data) {
            Feng.error("添加失败!" + data.responseJSON.message + "!");
        });
        ajax.start();
    }
    Feng.confirm("是否添加该企业员工?", operation);
};
