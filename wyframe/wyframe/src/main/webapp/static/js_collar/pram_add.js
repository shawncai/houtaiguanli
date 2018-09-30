/**
 * 初始化生产厂商详情对话框
 */
var Xgt_goods_prd_vendorInfoDlg = {
    xgt_goods_prd_vendorInfoData : {}
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
    this .set('prd_id') .set('prd_nm') .set('prd_model') .set('prd_nm_alias') .set('prd_nm_dsc') .set('prd_nm_img') .set('prd_price') ;
}


/**
 * 提交添加
 */
Xgt_goods_prd_vendorInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_goods_product/add", function(data){
        Feng.success("添加成功!");

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

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_goods_product/add", function(data){
        Feng.success("修改成功!");

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
};
console.log(Xgt_goods_prd_vendorInfo.set())
/**
 * 收集数据
 */
Xgt_goods_prd_vendorInfo.collectData = function() {
    this .set('prd_id') .set('prd_nm') .set('prd_model') .set('prd_nm_alias') .set('prd_nm_dsc') .set('prd_nm_img') .set('prd_price') ;
};

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

    var vendorId = $("#prd_vendor_id").val();


    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_goods_product/add", function(data){
        Feng.success("添加成功!");

//         Xgt_goods_prd_vendorInfoDlg.close();
    },function(data){
        //Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.Xgt_goods_prd_vendorInfoData);
    ajax.start();
}

$('#ensure').click(function () {
    parent.$("#add_all").bootstrapTable('refresh');
    parent.layer.closeAll();
})

$('#cancel').click(function(){

    parent.layer.closeAll()


});