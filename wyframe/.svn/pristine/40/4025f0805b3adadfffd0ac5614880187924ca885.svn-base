/**
 * 初始化自定义菜单详情对话框
 */
var Wx_menuInfoDlg = {
    wx_menuInfoData : {}
};

/**
 * 清除数据
 */
Wx_menuInfoDlg.clearData = function() {
    this.wx_menuInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Wx_menuInfoDlg.set = function(key, val) {
    this.wx_menuInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Wx_menuInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
Wx_menuInfoDlg.close = function() {
    parent.layer.close(window.parent.Wx_menu.layerIndex);
}

/**
 * 收集数据
 */
Wx_menuInfoDlg.collectData = function() {
    this .set('id') .set('fmenu') .set('smenu') .set('pmenu') .set('type') .set('wxid')
    
    ;
}

/**
 * 提交添加
 */
Wx_menuInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/wx_menu/add", function(data){
        Feng.success("添加成功!");
        window.parent.Wx_menu.table.refresh();
        Wx_menuInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.wx_menuInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
Wx_menuInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/wx_menu/update", function(data){
        Feng.success("修改成功!");
        window.parent.Wx_menu.table.refresh();
        Wx_menuInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.wx_menuInfoData);
    ajax.start();
}


/**
  * 初始化xyd详情对话框
  */
 var Wx_menuInfo = {
     Wx_menuInfoData : {}
 };

 /**
  * 设置对话框中的数据
  *
  * @param key 数据的名称
  * @param val 数据的具体值
  */
 Wx_menuInfo.set = function(key, val) {
 	this.Wx_menuInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
 	return this;
 }
 /**
  * 收集数据
  */
 Wx_menuInfo.collectData = function() {
     this  .set('id') .set('fmenu') .set('smenu') .set('pmenu') .set('type') .set('wxid')
     ;
 }

 /**
  * 提交添加
  */
 Wx_menuInfo.add = function() {
     this.collectData();
     //提交信息
     var ajax = new $ax(Feng.ctxPath + "/wx_menu/add", function(data){
         Feng.success("添加成功!");
         window.parent.Wx_menu.table.refresh();
         Wx_menuInfoDlg.close();
     },function(data){
         Feng.error("添加失败!" + data.responseJSON.message + "!");
     });
      	ajax.set(this.Wx_menuInfoData);
	    ajax.start();
 }

 
 
 