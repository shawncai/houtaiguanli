/**
 * 初始化微信公众号详情对话框
 */
var Wx_mainInfoDlg = {
    wx_mainInfoData : {}
};

/**
 * 清除数据
 */
Wx_mainInfoDlg.clearData = function() {
    this.wx_mainInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Wx_mainInfoDlg.set = function(key, val) {
    this.wx_mainInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Wx_mainInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
Wx_mainInfoDlg.close = function() {
    parent.layer.close(window.parent.Wx_main.layerIndex);
}

/**
 * 收集数据
 */
Wx_mainInfoDlg.collectData = function() {
    this .set('id') .set('wxname') .set('appid') .set('appsecret') .set('token') .set('access_token')
    
    ;
}

/**
 * 提交添加
 */
Wx_mainInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/wx_main/add", function(data){
        Feng.success("添加成功!");
        window.parent.Wx_main.table.refresh();
        Wx_mainInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.wx_mainInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
Wx_mainInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/wx_main/update", function(data){
        Feng.success("修改成功!");
        window.parent.Wx_main.table.refresh();
        Wx_mainInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.wx_mainInfoData);
    ajax.start();
}


/**
  * 初始化xyd详情对话框
  */
 var Wx_mainInfo = {
     Wx_mainInfoData : {}
 };

 /**
  * 设置对话框中的数据
  *
  * @param key 数据的名称
  * @param val 数据的具体值
  */
 Wx_mainInfo.set = function(key, val) {
 	this.Wx_mainInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
 	return this;
 }
 /**
  * 收集数据
  */
 Wx_mainInfo.collectData = function() {
     this  .set('id') .set('wxname') .set('appid') .set('appsecret') .set('token') .set('access_token')
     ;
 }

 /**
  * 提交添加
  */
 Wx_mainInfo.add = function() {
     this.collectData();
     //提交信息
     var ajax = new $ax(Feng.ctxPath + "/wx_main/add", function(data){
         Feng.success("添加成功!");
         window.parent.Wx_main.table.refresh();
         Wx_mainInfoDlg.close();
     },function(data){
         Feng.error("添加失败!" + data.responseJSON.message + "!");
     });
      	ajax.set(this.Wx_mainInfoData);
	    ajax.start();
 }

 
 
 