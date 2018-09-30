/**
 * 初始化企业分支机构详情对话框
 */
var Xyd_cpn_branchInfoDlg = {
    xyd_cpn_branchInfoData : {},
    cpnzTreeInstance : null
};

/**
 * 点击公司ztree列表的选项时
 *
 * @param e
 * @param treeId
 * @param treeNode
 * @returns
 */
Xyd_cpn_branchInfoDlg.onClickCpn = function(e, treeId, treeNode) {
    $("#areaName").attr("value",
        Xyd_cpn_branchInfoDlg.cpnzTreeInstance.getSelectedVal());
    $("#cpn_area_id").attr("value", treeNode.id);
    Xyd_cpn_branchInfoDlg.areaName = Xyd_cpn_branchInfoDlg.cpnzTreeInstance
        .getSelectedVal();
    Xyd_cpn_branchInfoDlg.cpn_area_id = treeNode.id;
}

$(function() {
    var cpnztree = new $ZTree("areaTree", "/sys_area/tree");
    cpnztree.bindOnClick(Xyd_cpn_branchInfoDlg.onClickCpn);
    cpnztree.init();
    Xyd_cpn_branchInfoDlg.cpnzTreeInstance = cpnztree;
});

/**
 * 显示地区选择的树
 *
 * @returns
 */
Xyd_cpn_branchInfoDlg.showAreaSelectTree = function() {
    Feng.showInputTree("areaName", "areaTreeDiv", 15, 34);
}

function loadCpn() {
    var ajax = new $ax(Feng.ctxPath + "/xyd_cpn_dept/cpnList", function(data) {
        for (var i = 0; i < data.length; i++) {
            // if(cpnId == data[i].cpn_id){
            // $("#cpn_id").append(
            // "<option value=" + data[i].cpn_id + " selected='selected'>"
            // + data[i].cpn_nm + "</option>");
            // }else{
            $("#cpn_id").append(
                "<option value=" + data[i].cpn_id + ">" + data[i].cpn_nm
                + "</option>");
            // }
        }
    }, function(data) {
        Feng.error("查询失败！" + data.responseJSON.message + "!");
    });
    ajax.start();
}

$(function() {
    loadCpn();
})

/**
 * 清除数据
 */
Xyd_cpn_branchInfoDlg.clearData = function() {
    this.xyd_cpn_branchInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key
 *            数据的名称
 * @param val
 *            数据的具体值
 */
Xyd_cpn_branchInfoDlg.set = function(key, val) {
    this.xyd_cpn_branchInfoData[key] = (typeof value == "undefined") ? $(
        "#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key
 *            数据的名称
 * @param val
 *            数据的具体值
 */
Xyd_cpn_branchInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
Xyd_cpn_branchInfoDlg.close = function() {
    parent.layer.close(window.parent.Xyd_cpn_branch.layerIndex);
}

/**
 * 收集数据
 */
Xyd_cpn_branchInfoDlg.collectData = function() {
    this.set('cpn_branch_id').set('cpn_id').set('cpn_branch_nm').set(
        'cpn_branch_code').set('cpn_branch_phone').set('cpn_area_id').set(
        'cpn_area_desc').set('user_id').set('st_id');
}

/**
 * 提交添加
 */
Xyd_cpn_branchInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    // 提交信息
    var ajax = new $ax(Feng.ctxPath + "/xyd_cpn_branch/add", function(data) {
        Feng.success("添加成功!");
        window.parent.Xyd_cpn_branch.table.refresh();
        Xyd_cpn_branchInfoDlg.close();
    }, function(data) {
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xyd_cpn_branchInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
Xyd_cpn_branchInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();
    if ($("#cpn_branch_nm").val()==""){
        return false;
    }
    if ($("#cpn_branch_code").val()==""){
        return false;
    }
    if ($("#cpn_branch_phone").val()==""){
        return false;
    }
    if ($("#cpn_area_desc").val()==""){
        return false;
    }
    if ($("#user_id").val()==""){
        return false;
    }
    if ($("#areaName").val()==""){
        return false;
    }
    // 提交信息
    var ajax = new $ax(Feng.ctxPath + "/xyd_cpn_branch/update", function(data) {
        Feng.success("修改成功!");
        window.parent.Xyd_cpn_branch.table.refresh();
        Xyd_cpn_branchInfoDlg.close();
    }, function(data) {
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xyd_cpn_branchInfoData);
    ajax.start();
}

/**
 * 初始化xyd详情对话框
 */
var Xyd_cpn_branchInfo = {
    Xyd_cpn_branchInfoData : {}
};

/**
 * 设置对话框中的数据
 *
 * @param key
 *            数据的名称
 * @param val
 *            数据的具体值
 */
Xyd_cpn_branchInfo.set = function(key, val) {
    this.Xyd_cpn_branchInfoData[key] = (typeof value == "undefined") ? $(
        "#" + key).val() : value;
    return this;
}
/**
 * 收集数据
 */
Xyd_cpn_branchInfo.collectData = function() {
    this.set('cpn_branch_id').set('cpn_id').set('cpn_branch_nm').set(
        'cpn_branch_code').set('cpn_branch_phone').set('cpn_area_id').set(
        'cpn_area_desc').set('user_id').set('st_id');
}

/**
 * 提交添加
 */
Xyd_cpn_branchInfo.add = function() {
    this.collectData();
    if ($("#cpn_branch_nm").val()==""){
        return false;
    }
    if ($("#cpn_branch_code").val()==""){
        return false;
    }
    if ($("#cpn_branch_phone").val()==""){
        return false;
    }
    if ($("#cpn_area_desc").val()==""){
        return false;
    }
    if ($("#user_id").val()==""){
        return false;
    }
    if ($("#areaName").val()==""){
        return false;
    }
    // 提交信息
    var ajax = new $ax(Feng.ctxPath + "/xyd_cpn_branch/add", function(data) {
        Feng.success("添加成功!");
        window.parent.Xyd_cpn_branch.table.refresh();
        Xyd_cpn_branchInfoDlg.close();
    }, function(data) {
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.Xyd_cpn_branchInfoData);
    ajax.start();
}
