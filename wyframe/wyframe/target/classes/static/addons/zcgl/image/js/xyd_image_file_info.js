/**
 * 初始化图片详情对话框
 */
var Xyd_image_fileInfoDlg = {
    xyd_image_fileInfoData : {}
};

/**
 * 清除数据
 */
Xyd_image_fileInfoDlg.clearData = function() {
    this.xyd_image_fileInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xyd_image_fileInfoDlg.set = function(key, val) {
    this.xyd_image_fileInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xyd_image_fileInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
Xyd_image_fileInfoDlg.close = function() {
    parent.layer.close(window.parent.Xyd_image_file.layerIndex);
}

/**
 * 收集数据
 */
Xyd_image_fileInfoDlg.collectData = function() {
    this .set('image_file_id') .set('image_file_nm') .set('image_file_src_url') .set('image_file_url') .set('file_url') .set('img_file_cls') .set('img_long') .set('img_wid') .set('cre_dt') .set('st_id') .set('oper_user')
    
    ;
}

/**
 * 提交添加
 */
Xyd_image_fileInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xyd_image_file/add", function(data){
        Feng.success("添加成功!");
        window.parent.Xyd_image_file.table.refresh();
        Xyd_image_fileInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xyd_image_fileInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
Xyd_image_fileInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xyd_image_file/update", function(data){
        Feng.success("修改成功!");
        window.parent.Xyd_image_file.table.refresh();
        Xyd_image_fileInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xyd_image_fileInfoData);
    ajax.start();
}


/**
  * 初始化xyd详情对话框
  */
 var Xyd_image_fileInfo = {
     Xyd_image_fileInfoData : {}
 };

 /**
  * 设置对话框中的数据
  *
  * @param key 数据的名称
  * @param val 数据的具体值
  */
 Xyd_image_fileInfo.set = function(key, val) {
 	this.Xyd_image_fileInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
 	return this;
 }
 /**
  * 收集数据
  */
 Xyd_image_fileInfo.collectData = function() {
     this  .set('image_file_id') .set('image_file_nm') .set('image_file_src_url') .set('image_file_url') .set('file_url') .set('img_file_cls') .set('img_long') .set('img_wid') .set('cre_dt') .set('st_id') .set('oper_user')
     ;
 }

 /**
  * 提交添加
  */
 Xyd_image_fileInfo.add = function() {
     this.collectData();
     //提交信息
     var ajax = new $ax(Feng.ctxPath + "/xyd_image_file/add", function(data){
         Feng.success("添加成功!");
         window.parent.Xyd_image_file.table.refresh();
         Xyd_image_fileInfoDlg.close();
     },function(data){
         Feng.error("添加失败!" + data.responseJSON.message + "!");
     });
      	ajax.set(this.Xyd_image_fileInfoData);
	    ajax.start();
 }

 
 
 