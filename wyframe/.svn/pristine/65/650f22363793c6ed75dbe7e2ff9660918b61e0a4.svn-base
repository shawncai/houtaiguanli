/**
 * 初始化自动回复详情对话框
 */
var Wx_auto_replyInfoDlg = {
    wx_auto_replyInfoData : {}
};

/**
 * 清除数据
 */
Wx_auto_replyInfoDlg.clearData = function() {
    this.wx_auto_replyInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Wx_auto_replyInfoDlg.set = function(key, val) {
    this.wx_auto_replyInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Wx_auto_replyInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
Wx_auto_replyInfoDlg.close = function() {
    parent.layer.close(window.parent.Wx_auto_reply.layerIndex);
}

/**
 * 收集数据
 */
Wx_auto_replyInfoDlg.collectData = function() {
    this .set('ID') .set('key') .set('reply') .set('type')
    
    ;
}

/**
 * 提交添加
 */
Wx_auto_replyInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/wx_auto_reply/add", function(data){
        Feng.success("添加成功!");
        window.parent.Wx_auto_reply.table.refresh();
        Wx_auto_replyInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.wx_auto_replyInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
Wx_auto_replyInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/wx_auto_reply/update", function(data){
        Feng.success("修改成功!");
        window.parent.Wx_auto_reply.table.refresh();
        Wx_auto_replyInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.wx_auto_replyInfoData);
    ajax.start();
}


/**
  * 初始化xyd详情对话框
  */
 var Wx_auto_replyInfo = {
     Wx_auto_replyInfoData : {}
 };

 /**
  * 设置对话框中的数据
  *
  * @param key 数据的名称
  * @param val 数据的具体值
  */
 Wx_auto_replyInfo.set = function(key, val) {
 	this.Wx_auto_replyInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
 	return this;
 }
 /**
  * 收集数据
  */
 Wx_auto_replyInfo.collectData = function() {
     this  .set('ID') .set('key') .set('reply') .set('type')
     ;
 }

 /**
  * 提交添加
  */
 Wx_auto_replyInfo.add = function() {
     this.collectData();
     //提交信息
     var ajax = new $ax(Feng.ctxPath + "/wx_auto_reply/add", function(data){
         Feng.success("添加成功!");
         window.parent.Wx_auto_reply.table.refresh();
         Wx_auto_replyInfoDlg.close();
     },function(data){
         Feng.error("添加失败!" + data.responseJSON.message + "!");
     });
      	ajax.set(this.Wx_auto_replyInfoData);
	    ajax.start();
 }

 
 
 