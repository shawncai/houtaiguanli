/**
 * 初始化自动回复详情对话框
 */
var Wx_autoReplyInfoDlg = {
    wx_autoReplyInfoData : {}
};

/**
 * 清除数据
 */
Wx_autoReplyInfoDlg.clearData = function() {
    this.wx_autoReplyInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Wx_autoReplyInfoDlg.set = function(key, val) {
    this.wx_autoReplyInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Wx_autoReplyInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
Wx_autoReplyInfoDlg.close = function() {
    parent.layer.close(window.parent.Wx_autoReply.layerIndex);
}

/**
 * 收集数据
 */
Wx_autoReplyInfoDlg.collectData = function() {
    this .set('ID') .set('key') .set('reply') .set('type')
    
    ;
}

/**
 * 提交添加
 */
Wx_autoReplyInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/wx_autoReply/add", function(data){
        Feng.success("添加成功!");
        window.parent.Wx_autoReply.table.refresh();
        Wx_autoReplyInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.wx_autoReplyInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
Wx_autoReplyInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/wx_autoReply/update", function(data){
        Feng.success("修改成功!");
        window.parent.Wx_autoReply.table.refresh();
        Wx_autoReplyInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.wx_autoReplyInfoData);
    ajax.start();
}


/**
  * 初始化xyd详情对话框
  */
 var Wx_autoReplyInfo = {
     Wx_autoReplyInfoData : {}
 };

 /**
  * 设置对话框中的数据
  *
  * @param key 数据的名称
  * @param val 数据的具体值
  */
 Wx_autoReplyInfo.set = function(key, val) {
 	this.Wx_autoReplyInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
 	return this;
 }
 /**
  * 收集数据
  */
 Wx_autoReplyInfo.collectData = function() {
     this  .set('ID') .set('key') .set('reply') .set('type')
     ;
 }

 /**
  * 提交添加
  */
 Wx_autoReplyInfo.add = function() {
     this.collectData();
     //提交信息
     var ajax = new $ax(Feng.ctxPath + "/wx_autoReply/add", function(data){
         Feng.success("添加成功!");
         window.parent.Wx_autoReply.table.refresh();
         Wx_autoReplyInfoDlg.close();
     },function(data){
         Feng.error("添加失败!" + data.responseJSON.message + "!");
     });
      	ajax.set(this.Wx_autoReplyInfoData);
	    ajax.start();
 }

 
 
 