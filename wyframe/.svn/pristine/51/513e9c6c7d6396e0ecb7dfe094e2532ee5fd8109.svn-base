/**
 * 初始化配送商详情对话框
 */
var Bs_send_channelInfoDlg = {
    bs_send_channelInfoData : {}
};

/**
 * 清除数据
 */
Bs_send_channelInfoDlg.clearData = function() {
    this.bs_send_channelInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Bs_send_channelInfoDlg.set = function(key, val) {
    this.bs_send_channelInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Bs_send_channelInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
Bs_send_channelInfoDlg.close = function() {
    parent.layer.close(window.parent.Bs_send_channel.layerIndex);
}

/**
 * 收集数据
 */
Bs_send_channelInfoDlg.collectData = function() {
    this .set('send_chnl_id') .set('send_chnl_no') .set('send_chnl_nm') .set('send_chnl_desc') .set('send_chnl_phoe') .set('send_chnl_num') .set('send_chnl_flg');
}

/**
 * 提交添加
 */
Bs_send_channelInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/bs_send_channel/add", function(data){
        Feng.success("添加成功!");
        window.parent.Bs_send_channel.table.refresh();
        Bs_send_channelInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.bs_send_channelInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
Bs_send_channelInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/bs_send_channel/update", function(data){
        Feng.success("修改成功!");
        window.parent.Bs_send_channel.table.refresh();
        Bs_send_channelInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.bs_send_channelInfoData);
    ajax.start();
}

	$(function() {
       //提交信息
    var ajax = new $ax(Feng.ctxPath + "/dict/selectDict", function (data) {
    		for(var i= 0;i<data.length;i++){
    		$("#send_chnl_flg").append(
    				"<option value='" + data[i].id + "'>"
    				+ data[i].name + "</option>");
    	}
    });
    ajax.set("dictId",50);
    ajax.start();
});
