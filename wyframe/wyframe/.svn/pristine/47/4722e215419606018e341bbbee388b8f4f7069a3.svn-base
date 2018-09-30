/**
 * 初始化产品品牌详情对话框
 */
var Xgt_goods_prd_brandInfoDlg = {
    xgt_goods_prd_brandInfoData : {},
    brandzTreeInstance : null
};

/**
 * 初始化产品品牌详情对话框
 */
/*var Xgt_goods_brandIdDlg = {
 xgt_goods_brandIdData : {},
 brandzTreeInstance : null
 };*/
/**
 * 清除数据
 */
Xgt_goods_prd_brandInfoDlg.clearData = function() {
    this.xgt_goods_prd_brandInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xgt_goods_prd_brandInfoDlg.set = function(key, val) {
    this.xgt_goods_prd_brandInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xgt_goods_prd_brandInfoDlg.get = function(key) {
    return $("#" + key).val();
}

Xgt_goods_prd_brandInfoDlg.onClickbrand = function(e, treeId, treeNode) {
    $("#brandName").attr("value", Xgt_goods_prd_brandInfoDlg.brandzTreeInstance.getSelectedVal());
    $("#par_prd_brand_id").attr("value", treeNode.id);
    Xgt_goods_prd_brandInfoDlg.brandName = Xgt_goods_prd_brandInfoDlg.brandzTreeInstance.getSelectedVal();
    Xgt_goods_prd_brandInfoDlg.par_prd_brand_id = treeNode.id;
}

$(function() {
    var brandztree = new $ZTree("brandareaTree", "/xgt_goods_prd_brand/tree");
    brandztree.bindOnClick(Xgt_goods_prd_brandInfoDlg.onClickbrand);
    brandztree.init();
    Xgt_goods_prd_brandInfoDlg .brandzTreeInstance= brandztree;
});
Xgt_goods_prd_brandInfoDlg.showBrandSelectTree = function() {
    Feng.showInputTree("brandName", "brandTreeDiv", 15, 34);
}
/**
 * 关闭此对话框
 */
Xgt_goods_prd_brandInfoDlg.close = function() {
    parent.layer.close(window.parent.Xgt_goods_prd_brand.layerIndex);
}

/**
 * 收集数据
 */
Xgt_goods_prd_brandInfoDlg.collectData = function() {
    this .set('prd_brand_id') .set('par_prd_brand_id').set('prd_brand_remarks') .set('prd_brand_nm') .set('prd_brand_alias') .set('cpn_id') .set('cpn_branch_id') .set('st_id') .set('oper_user')
    ;
}

/**
 * 提交添加
 */
Xgt_goods_prd_brandInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();
    if ($("#brandName").val()==""){
        return false;
    }
    if ($("#prd_brand_nm").val()==""){
        return false;
    }
    if ($("#prd_brand_alias").val()==""){
        return false;
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_goods_prd_brand/add", function(data){
        Feng.success("添加成功!");
        window.parent.Xgt_goods_prd_brand.table.refresh();
        Xgt_goods_prd_brandInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xgt_goods_prd_brandInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
Xgt_goods_prd_brandInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();
    if ($("#brandName").val()==""){
        return false;
    }
    if ($("#prd_brand_nm").val()==""){
        return false;
    }
    if ($("#prd_brand_alias").val()==""){
        return false;
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_goods_prd_brand/update", function(data){
        Feng.success("修改成功!");
        window.parent.Xgt_goods_prd_brand.table.refresh();
        Xgt_goods_prd_brandInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xgt_goods_prd_brandInfoData);
    ajax.start();
}


/**
 * 初始化xyd详情对话框
 */
var Xgt_goods_prd_brandInfo = {
    Xgt_goods_prd_brandInfoData : {}
};

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xgt_goods_prd_brandInfo.set = function(key, val) {
    this.Xgt_goods_prd_brandInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}
/**
 * 收集数据
 */
Xgt_goods_prd_brandInfo.collectData = function() {
    this .set('prd_brand_id') .set('par_prd_brand_id').set('prd_brand_remarks') .set('prd_brand_nm') .set('prd_brand_alias') .set('cpn_id') .set('cpn_branch_id') .set('st_id') .set('oper_user')
    ;
}

/**
 * 提交添加
 */
Xgt_goods_prd_brandInfo.add = function() {
    this.collectData();
    if ($("#brandName").val()==""){
        return false;
    }
    if ($("#prd_brand_nm").val()==""){
        return false;
    }
    if ($("#prd_brand_alias").val()==""){
        return false;
    }
    if ($("#prd_brand_remarks").val()==""){
        return false;
    }

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_goods_prd_brand/add", function(data){
        Feng.success("添加成功!");
        window.parent.Xgt_goods_prd_brand.table.refresh();
        Xgt_goods_prd_brandInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.Xgt_goods_prd_brandInfoData);
    ajax.start();
}

/**
 * 提交继续并添加
 */
Xgt_goods_prd_brandInfo.addContinue = function() {
    this.collectData();
    if ($("#brandName").val()==""){
        return false;
    }
    if ($("#prd_brand_nm").val()==""){
        return false;
    }
    if ($("#prd_brand_alias").val()==""){
        return false;
    }
    if ($("#prd_brand_remarks").val()==""){
        return false;
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_goods_prd_brand/add", function(data){
        Feng.success("添加成功!");
        window.parent.Xgt_goods_prd_brand.table.refresh();
        $("#prd_brand_nm").val("");
        $("#prd_brand_alias").val("");
        $("#prd_brand_remarks").val("");
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.Xgt_goods_prd_brandInfoData);
    ajax.start();
}

