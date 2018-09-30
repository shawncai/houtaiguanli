/**
 * 初始化销售渠道详情对话框
 */
var Bs_sale_channelInfoDlg = {
    bs_sale_channelInfoData : {}
};

/**
 * 清除数据
 */
Bs_sale_channelInfoDlg.clearData = function() {
    this.bs_sale_channelInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Bs_sale_channelInfoDlg.set = function(key, val) {
    this.bs_sale_channelInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Bs_sale_channelInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
Bs_sale_channelInfoDlg.close = function() {
    parent.layer.close(window.parent.Bs_sale_channel.layerIndex);
}

/**
 * 收集数据
 */
Bs_sale_channelInfoDlg.collectData = function() {
    this .set('chnl_id') .set('chnl_no') .set('chnl_nm') .set('chnl_desc') .set('chnl_phone') .set('chnl_user_nm');
}

/**
 * 提交添加
 */
Bs_sale_channelInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/bs_sale_channel/add", function(data){
        Feng.success("添加成功!");
        window.parent.Bs_sale_channel.table.refresh();
        Bs_sale_channelInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.bs_sale_channelInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
Bs_sale_channelInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/bs_sale_channel/update", function(data){
        Feng.success("修改成功!");
        window.parent.Bs_sale_channel.table.refresh();
        Bs_sale_channelInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.bs_sale_channelInfoData);
    ajax.start();
}

