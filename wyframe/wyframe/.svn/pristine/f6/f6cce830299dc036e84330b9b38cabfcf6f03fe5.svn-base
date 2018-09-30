/**
 * 初始化生产厂商详情对话框
 */
var Xgt_goods_prd_vendorInfoDlg = {
    xgt_goods_prd_vendorInfoData : {},
    vendorzTreeInstance : null
};

/**
 * 清除数据
 */
Xgt_goods_prd_vendorInfoDlg.clearData = function() {
    this.xgt_goods_prd_vendorInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xgt_goods_prd_vendorInfoDlg.set = function(key, val) {
    this.xgt_goods_prd_vendorInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xgt_goods_prd_vendorInfoDlg.get = function(key) {
    return $("#" + key).val();
}
Xgt_goods_prd_vendorInfoDlg.onClickvendor = function(e, treeId, treeNode) {
    $("#vendorName").attr("value", Xgt_goods_prd_vendorInfoDlg.vendorzTreeInstance.getSelectedVal());
    $("#par_prd_vendor_id").attr("value", treeNode.id);
    Xgt_goods_prd_vendorInfoDlg.vendorName = Xgt_goods_prd_vendorInfoDlg.vendorzTreeInstance.getSelectedVal();
    Xgt_goods_prd_vendorInfoDlg.par_prd_vendor_id = treeNode.id;
}

$(function() {
    var vendorztree = new $ZTree("vendorareaTree", "/xgt_goods_prd_vendor/tree");
    vendorztree.bindOnClick(Xgt_goods_prd_vendorInfoDlg.onClickvendor);
    vendorztree.init();
    Xgt_goods_prd_vendorInfoDlg .vendorzTreeInstance= vendorztree;
});
Xgt_goods_prd_vendorInfoDlg.showVendorSelectTree = function() {
    Feng.showInputTree("vendorName", "vendorTreeDiv", 15, 34);
}
/**
 * 关闭此对话框
 */
Xgt_goods_prd_vendorInfoDlg.close = function() {
    parent.layer.close(window.parent.Xgt_goods_prd_vendor.layerIndex);
}

/**
 * 收集数据
 */
Xgt_goods_prd_vendorInfoDlg.collectData = function() {
    this .set('prd_vendor_id') .set('prd_vendor_nm') .set('prd_vendor_alias') .set('prd_vendor_man') .set('man_email') .set('man_phone') .set('vendor_flg') .set('cpn_id') .set('cpn_branch_id') .set('st_id') .set('oper_user').set('man_address').set('par_prd_vendor_id').set('remarks');
}

/**
 * 提交添加
 */
Xgt_goods_prd_vendorInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_goods_prd_vendor/add", function(data){
        Feng.success("添加成功!");
        window.parent.Xgt_goods_prd_vendor.table.refresh();
        Xgt_goods_prd_vendorInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xgt_goods_prd_vendorInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
Xgt_goods_prd_vendorInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();
    if ($("#prd_vendor_nm").val()==""){
        return false;
    }
    if ($("#prd_vendor_man").val()==""){
        return false;
    }
    if ($("#remarks").val()==""){
        return false;
    }

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_goods_prd_vendor/update", function(data){
        Feng.success("修改成功!");
        window.parent.Xgt_goods_prd_vendor.table.refresh();
        Xgt_goods_prd_vendorInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xgt_goods_prd_vendorInfoData);
    ajax.start();
}


/**
 * 初始化xyd详情对话框
 */
var Xgt_goods_prd_vendorInfo = {
    Xgt_goods_prd_vendorInfoData : {}
};

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xgt_goods_prd_vendorInfo.set = function(key, val) {
    this.Xgt_goods_prd_vendorInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}
/**
 * 收集数据
 */
Xgt_goods_prd_vendorInfo.collectData = function() {
    this .set('prd_vendor_id') .set('prd_vendor_nm') .set('prd_vendor_alias') .set('prd_vendor_man') .set('man_email') .set('man_phone') .set('vendor_flg') .set('cpn_id') .set('cpn_branch_id') .set('st_id') .set('oper_user').set('man_address').set('par_prd_vendor_id').set('remarks');
}

/**
 * 清除数据
 */
Xgt_goods_prd_vendorInfo.clearData = function() {
    this.Xgt_goods_prd_vendorInfoData = {};
}

/**
 * 提交添加
 */
Xgt_goods_prd_vendorInfo.add = function() {

    this.collectData();
    if ($("#prd_vendor_nm").val()==""){
        return false;
    }
    if ($("#prd_vendor_man").val()==""){
        return false;
    }
    if ($("#remarks").val()==""){
        return false;
    }
    var vendorId = $("#prd_vendor_id").val();
    console.log(vendorId);
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_goods_prd_vendor/add", function(data){
        Feng.success("添加成功!");
        window.parent.Xgt_goods_prd_vendor.table.refresh();
        Xgt_goods_prd_vendorInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.Xgt_goods_prd_vendorInfoData);
    ajax.start();
}

/**
 * 提交并继续添加
 */
Xgt_goods_prd_vendorInfo.addContinue = function() {

    this.collectData();

    if ($("#prd_vendor_nm").val()==""){
        return false;
    }
    if ($("#prd_vendor_man").val()==""){
        return false;
    }
    if ($("#man_address").val()==""){
        return false;
    }
    var vendorId = $("#prd_vendor_id").val();
    console.log(vendorId);
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_goods_prd_vendor/add", function(data){
        Feng.success("添加成功!");
        window.parent.Xgt_goods_prd_vendor.table.refresh();
        $("#prd_vendor_nm").val("");
        $("#man_phone").val("");
        $("#prd_vendor_alias").val("");
        $("#prd_vendor_man").val("");
        $("#man_email").val("");
        $("#man_address").val("");
        $("#remarks").val("");
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.Xgt_goods_prd_vendorInfoData);
    ajax.start();
}