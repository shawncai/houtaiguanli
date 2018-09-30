/**
 * 初始化企业仓库详情对话框
 */
var Xyd_cpn_storeInfoDlg = {
    xyd_cpn_storeInfoData : {},
    cpnzTreeInstance : null
};

/**
 * 点击仓库ztree列表的选项时
 *
 * @param e
 * @param treeId
 * @param treeNode
 * @returns
 */
Xyd_cpn_storeInfoDlg.onClickCpn = function(e, treeId, treeNode) {
    $("#cpndNm").attr("value", Xyd_cpn_storeInfoDlg.cpnzTreeInstance.getSelectedVal());
    $("#par_store_id").attr("value", treeNode.id);
    Xyd_cpn_storeInfoDlg.cpndNm = Xyd_cpn_storeInfoDlg.cpnzTreeInstance.getSelectedVal();
    Xyd_cpn_storeInfoDlg.par_store_id = treeNode.id;
}

$(function() {
    var cpnztree = new $ZTree("cpnareaTree", "/xyd_cpn_store/tree");
    cpnztree.bindOnClick(Xyd_cpn_storeInfoDlg.onClickCpn);
    cpnztree.init();
    Xyd_cpn_storeInfoDlg.cpnzTreeInstance = cpnztree;
});

/**
 * 显示仓库选择的树
 *
 * @returns
 */
Xyd_cpn_storeInfoDlg.showCpnSelectTree = function() {
    Feng.showInputTree("cpndNm", "cpnTreeDiv", 15, 34);
}

function loadCpn() {
    var ajax = new $ax(Feng.ctxPath + "/xyd_cpn_dept/cpnList", function(data) {
        for(var i = 0; i < data.length; i++) {
            $("#cpn_id").append(
                "<option value=" + data[i].cpn_id + ">"
                + data[i].cpn_nm + "</option>");
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
Xyd_cpn_storeInfoDlg.clearData = function() {
    this.xyd_cpn_storeInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xyd_cpn_storeInfoDlg.set = function(key, val) {
    this.xyd_cpn_storeInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xyd_cpn_storeInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
Xyd_cpn_storeInfoDlg.close = function() {
    parent.layer.close(window.parent.Xyd_cpn_store.layerIndex);
}

/**
 * 收集数据
 */
Xyd_cpn_storeInfoDlg.collectData = function() {
    this .set('cpn_store_id') .set('cpn_id') .set('cpn_branch_id') .set('cpn_store_nm') .set('cpn_store_no') .set('par_store_id') .set('st_id') .set("man_man") .set("man_email") .set("man_phone") .set("man_address") .set("remarks");
}

/**
 * 提交添加
 */
Xyd_cpn_storeInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xyd_cpn_store/add", function(data){
        Feng.success("添加成功!");
        window.parent.Xyd_cpn_store.table.refresh();
        Xyd_cpn_storeInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xyd_cpn_storeInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
Xyd_cpn_storeInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();
    if ($("#cpn_store_nm").val()==""){
        return false;
    }
    if ($("#man_man").val()==""){
        return false;
    }
    if ($("#cpn_store_no").val()==""){
        return false;
    }
    if ($("#cpndNm").val()==""){
        return false;
    }
    if ($("#man_email").val()==""){
        return false;
    }
    if ($("#man_address").val()==""){
        return false;
    }
    if ($("#man_phone").val()==""){
        return false;
    }
    if ($("#remarks").val()==""){
        return false;
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xyd_cpn_store/update", function(data){
        Feng.success("修改成功!");
        window.parent.Xyd_cpn_store.table.refresh();
        Xyd_cpn_storeInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xyd_cpn_storeInfoData);
    ajax.start();
}


/**
 * 初始化xyd详情对话框
 */
var Xyd_cpn_storeInfo = {
    Xyd_cpn_storeInfoData : {}
};

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xyd_cpn_storeInfo.set = function(key, val) {
    this.Xyd_cpn_storeInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}
/**
 * 收集数据
 */
Xyd_cpn_storeInfo.collectData = function() {
    this  .set('cpn_store_id') .set('cpn_id') .set('cpn_branch_id') .set('cpn_store_nm') .set('cpn_store_no') .set('par_store_id') .set('st_id') .set("man_man") .set("man_email") .set("man_phone") .set("man_address") .set("remarks");
}

/**
 * 提交添加
 */
Xyd_cpn_storeInfo.add = function() {
    this.collectData();
    if ($("#cpn_store_nm").val()==""){
        return false;
    }
    if ($("#man_man").val()==""){
        return false;
    }
    if ($("#cpn_store_no").val()==""){
        return false;
    }
    if ($("#cpndNm").val()==""){
        return false;
    }
    if ($("#man_email").val()==""){
        return false;
    }
    if ($("#man_address").val()==""){
        return false;
    }
    if ($("#man_phone").val()==""){
        return false;
    }
    if ($("#remarks").val()==""){
        return false;
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xyd_cpn_store/add", function(data){
        Feng.success("添加成功!");
        window.parent.Xyd_cpn_store.table.refresh();
        Xyd_cpn_storeInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.Xyd_cpn_storeInfoData);
    ajax.start();
}