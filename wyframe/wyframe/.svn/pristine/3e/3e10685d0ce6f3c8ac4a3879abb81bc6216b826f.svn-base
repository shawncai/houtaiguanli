/**
 * 初始化商品管理详情对话框
 */
var Xgt_goods_productInfoDlg = {
    xgt_goods_productInfoData : {}
};

/**
 * 清除数据
 */
Xgt_goods_productInfoDlg.clearData = function() {
    this.xgt_goods_productInfoData = {};
}

/**<input type="hidden" id="prd_nm_img" value="">
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xgt_goods_productInfoDlg.set = function(key, val) {
    this.xgt_goods_productInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xgt_goods_productInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
Xgt_goods_productInfoDlg.close = function() {
    parent.layer.close(window.parent.Xgt_goods_product.layerIndex);
}

/**
 * 收集数据
 */
Xgt_goods_productInfoDlg.collectData = function() {
    this .set('prd_id') .set('prd_brand_id') .set('prd_sn') .set('prd_cls_id') .set('prd_unit_id') .set('prd_no') .set('prd_nm') .set('prd_model') .set('prd_nm_alias') .set('prd_spec') .set('prd_nm_img') .set('prd_nm_dsc') .set('prd_remarks') .set('cpn_id').set('prd_purchase').set('prd_price').set('cpn_branch_id').set('st_id').set('oper_user')

    ;
}

/**
 * 提交添加
 */
Xgt_goods_productInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();
    console.log(Xgt_goods_productInfoDlg.collectData())
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_goods_product/add", function(data){
        Feng.success("添加成功!");
        window.parent.Xgt_goods_product.table.refresh();
        Xgt_goods_productInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xgt_goods_productInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
Xgt_goods_productInfoDlg.editSubmit = function() {
    if ($("#prd_nm").val()==""){
        return false;
    }
    if ($("#prd_nm_alias").val()==""){
        return false;
    }
    if ($("#prd_price").val()==""){
        return false;
    }
    if ($("#prd_remarks").val()==""){
        return false;
    }
    if ($("#prd_purchase").val()==""){
        return false;
    }
    if ($("#prd_spec").val()==""){
        return false;
    }
    if ($("#prd_no").val()==""){
        return false;
    }
    if ($("#prd_sn").val()==""){
        return false;
    }
    if ($("#prd_model").val()==""){
        return false;
    }
    this.clearData();
    this.collectData();
    console.log( this.collectData())
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_goods_product/update", function(data){
        Feng.success("修改成功!");
        window.parent.Xgt_goods_product.table.refresh();
        Xgt_goods_productInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xgt_goods_productInfoData);
    ajax.start();
}


/**
 * 初始化xyd详情对话框
 */
var Xgt_goods_productInfo = {
    Xgt_goods_productInfoData : {}
};

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xgt_goods_productInfo.set = function(key, val) {
    this.Xgt_goods_productInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}
/**
 * 收集数据
 */
Xgt_goods_productInfo.collectData = function() {
    this .set('prd_id') .set('prd_brand_id') .set('prd_sn') .set('prd_cls_id') .set('prd_unit_id') .set('prd_no') .set('prd_nm') .set('prd_model') .set('prd_nm_alias') .set('prd_spec') .set('prd_nm_img') .set('prd_nm_dsc') .set('prd_remarks') .set('cpn_id').set('prd_purchase').set('prd_price').set('cpn_branch_id').set('st_id').set('oper_user')
    ;
}

/**
 * 提交添加
 */
Xgt_goods_productInfo.add = function() {
    this.collectData();
    if ($("#prd_nm").val()==""){
        return false;
    }
    if ($("#prd_nm_alias").val()==""){
        return false;
    }
    if ($("#prd_price").val()==""){
        return false;
    }
    if ($("#prd_remarks").val()==""){
        return false;
    }
    if ($("#prd_purchase").val()==""){
        return false;
    }
    if ($("#prd_spec").val()==""){
        return false;
    }
    if ($("#prd_no").val()==""){
        return false;
    }
    if ($("#prd_sn").val()==""){
        return false;
    }
    if ($("#prd_model").val()==""){
        return false;
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_goods_product/add", function(data){
        Feng.success("添加成功!");
        window.parent.Xgt_goods_product.table.refresh();
        Xgt_goods_productInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.Xgt_goods_productInfoData);
    ajax.start();
}

function  nullIs(keyId) {
    if(("#"+keyId).val()==""){
        return;
    }
}
/**
 * 提交添加
 */
Xgt_goods_productInfo.addContinueSubmit = function() {
    this.collectData();
    if ($("#prd_nm").val()==""){
        return false;
    }
    if ($("#prd_nm_alias").val()==""){
        return false;
    }
    if ($("#prd_price").val()==""){
        return false;
    }
    if ($("#prd_remarks").val()==""){
        return false;
    }
    if ($("#prd_purchase").val()==""){
        return false;
    }
    if ($("#prd_spec").val()==""){
        return false;
    }
    if ($("#prd_no").val()==""){
        return false;
    }
    if ($("#prd_sn").val()==""){
        return false;
    }
    if ($("#prd_model").val()==""){
        return false;
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_goods_product/add", function(data){
        Feng.success("添加成功!");
        window.parent.Xgt_goods_product.table.refresh();
        $("#prd_nm").val("");
        $("#prd_nm_alias").val("");
        $("#prd_sn").val("");
        $("#prd_spec").val("");
        $("#prd_purchase").val("");
        $("#prd_cls_id").val("");
        $("#prd_no").val("");
        $("#prd_model").val("");
        $("#prd_unit_id").val("");
        $("#prd_price").val("");
        $("#prd_remarks").val("");
        $("#prd_nm_dsc").val("");
        $("#prd_nm_img").val("");
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.Xgt_goods_productInfoData);
    ajax.start();
}


$('#testList').click(function () {
    $('#duan').remove();
})