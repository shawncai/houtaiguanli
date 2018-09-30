/**
 * 初始化产品分类详情对话框
 */
var Xgt_goods_prd_clsInfoDlg = {
    xgt_goods_prd_clsInfoData : {}
};

/**
 * 初始化产品分类详情对话框
 */
var Xgt_goods_clsIdDlg = {
    xgt_goods_clsIdData : {},
    clszTreeInstance : null
};

/**
 * 点击产品分类ztree列表的选项时
 *
 * @param e
 * @param treeId
 * @param treeNode
 * @returns
 */
Xgt_goods_clsIdDlg.onClickcls = function(e, treeId, treeNode) {
    $("#clsName").attr("value", Xgt_goods_clsIdDlg.clszTreeInstance.getSelectedVal());
    $("#par_prd_cls_id").attr("value", treeNode.id);
    Xgt_goods_clsIdDlg.clsName = Xgt_goods_clsIdDlg.clszTreeInstance.getSelectedVal();
    Xgt_goods_clsIdDlg.par_prd_cls_id = treeNode.id;
}

$(function() {
    var clsztree = new $ZTree("clsareaTree", "/xgt_goods_prd_cls/tree");
    clsztree.bindOnClick(Xgt_goods_clsIdDlg.onClickcls);
    clsztree.init();
    Xgt_goods_clsIdDlg.clszTreeInstance = clsztree;
});

/**
 * 显示产品分类选择的树
 *
 * @returns
 */
Xgt_goods_clsIdDlg.showClsSelectTree = function() {
    Feng.showInputTree("clsName", "clsTreeDiv", 15, 34);
}

/**
 * 清除数据
 */
Xgt_goods_prd_clsInfoDlg.clearData = function() {
    this.xgt_goods_prd_clsInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xgt_goods_prd_clsInfoDlg.set = function(key, val) {
    this.xgt_goods_prd_clsInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xgt_goods_prd_clsInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
Xgt_goods_prd_clsInfoDlg.close = function() {
    parent.layer.close(window.parent.Xgt_goods_prd_cls.layerIndex);
}

/**
 * 收集数据
 */
Xgt_goods_prd_clsInfoDlg.collectData = function() {
    this .set('prd_cls_id') .set('prd_cls_nm').set('cls_code').set('sn_flg') .set('prd_cls_alias') .set('par_prd_cls_id') .set('cpn_id') .set('cpn_branch_id') .set('st_id') .set('oper_user')

    ;
}

/**
 * 提交添加
 */
Xgt_goods_prd_clsInfoDlg.addSubmit = function() {
    if ($("#cls_code").val()==""){
        return false;
    }
    if ($("#prd_cls_nm").val()==""){
        return false;
    }
    if ($("#prd_cls_alias").val()==""){
        return false;
    }
    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_goods_prd_cls/add", function(data){
        Feng.success("添加成功!");
        window.parent.Xgt_goods_prd_cls.table.refresh();
        Xgt_goods_prd_clsInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xgt_goods_prd_clsInfoData);
    ajax.start();
}

/**
 * 提交添加并继续添加
 */
Xgt_goods_prd_clsInfoDlg.addContinueSubmit = function() {

    this.clearData();
    this.collectData();

    if ($("#cls_code").val()==""){
        return false;
    }
    if ($("#prd_cls_nm").val()==""){
        return false;
    }
    if ($("#prd_cls_alias").val()==""){
        return false;
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_goods_prd_cls/add", function(data){
        Feng.success("添加成功!");
        window.parent.Xgt_goods_prd_cls.table.refresh();
        $("#prd_cls_alias").val("");
        $("#cls_code").val("");
        $("#prd_cls_nm").val("");
        $("#sn_flg").val("");
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xgt_goods_prd_clsInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
Xgt_goods_prd_clsInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();
    if ($("#cls_code").val()==""){
        return false;
    }
    if ($("#prd_cls_nm").val()==""){
        return false;
    }
    if ($("#prd_cls_alias").val()==""){
        return false;
    }
    if ($("#par_prd_cls_id").val()==""){
        return false;
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_goods_prd_cls/update", function(data){
        Feng.success("修改成功!");
        window.parent.Xgt_goods_prd_cls.table.refresh();
        Xgt_goods_prd_clsInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xgt_goods_prd_clsInfoData);
    ajax.start();
}


/**
 * 初始化xyd详情对话框
 */
var Xgt_goods_prd_clsInfo = {
    Xgt_goods_prd_clsInfoData : {}
};

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xgt_goods_prd_clsInfo.set = function(key, val) {
    this.Xgt_goods_prd_clsInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}
/**
 * 收集数据
 */
Xgt_goods_prd_clsInfo.collectData = function() {
    this  .set('prd_cls_id') .set('prd_cls_nm').set('cls_code').set('sn_flg') .set('prd_cls_alias') .set('par_prd_cls_id') .set('cpn_id') .set('cpn_branch_id') .set('st_id') .set('oper_user');
}

/**
 * 提交添加
 */
Xgt_goods_prd_clsInfo.add = function() {
    this.collectData();
    if ($("#cls_code").val()==""){
        return false;
    }
    if ($("#prd_cls_nm").val()==""){
        return false;
    }
    if ($("#prd_cls_alias").val()==""){
        return false;
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_goods_prd_cls/add", function(data){
        Feng.success("添加成功!");
        window.parent.Xgt_goods_prd_cls.table.refresh();
        Xgt_goods_prd_clsInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.Xgt_goods_prd_clsInfoData);
    ajax.start();
}



