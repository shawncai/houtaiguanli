/**
 * 初始化房间详情对话框
 */
var Xgt_cpn_roomInfoDlg = {
    xgt_cpn_roomInfoData : {}
};

/**
 * 清除数据
 */
Xgt_cpn_roomInfoDlg.clearData = function() {
    this.xgt_cpn_roomInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xgt_cpn_roomInfoDlg.set = function(key, val) {
    this.xgt_cpn_roomInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xgt_cpn_roomInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
Xgt_cpn_roomInfoDlg.close = function() {
    parent.layer.close(window.parent.Xgt_cpn_room.layerIndex);
}

/**
 * 收集数据
 */
Xgt_cpn_roomInfoDlg.collectData = function() {
    this .set('room_id') .set('room_nm') .set('room_yt') .set('room_adrs') .set('room_adrs_x') .set('room_adrs_y') .set('romm_photo_url') .set('romm_photo_url6') .set('romm_photo_url5') .set('romm_photo_url4') .set('romm_photo_url3') .set('romm_photo_url2') .set('par_room_id') .set('cpn_branch_id') .set('cre_dt') .set('st_id') .set('oper_user')
    
    ;
}

/**
 * 提交添加
 */
Xgt_cpn_roomInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_cpn_room/add", function(data){
        Feng.success("添加成功!");
        window.parent.Xgt_cpn_room.table.refresh();
        Xgt_cpn_roomInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set("xgt_cpn_room",JSON.stringify(this.xgt_cpn_roomInfoData));
    ajax.start();
}

/**
 * 提交修改
 */
Xgt_cpn_roomInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_cpn_room/update", function(data){
        Feng.success("修改成功!");
        window.parent.Xgt_cpn_room.table.refresh();
        Xgt_cpn_roomInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xgt_cpn_roomInfoData);
    ajax.start();
}


/**
  * 初始化xyd详情对话框
  */
 var Xgt_cpn_roomInfo = {
     Xgt_cpn_roomInfoData : {}
 };

 /**
  * 设置对话框中的数据
  *
  * @param key 数据的名称
  * @param val 数据的具体值
  */
 Xgt_cpn_roomInfo.set = function(key, val) {
 	this.Xgt_cpn_roomInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
 	return this;
 }
 /**
  * 收集数据
  */
 Xgt_cpn_roomInfo.collectData = function() {
     this  .set('room_id') .set('room_nm') .set('room_yt') .set('room_adrs') .set('room_adrs_x') .set('room_adrs_y') .set('romm_photo_url') .set('romm_photo_url6') .set('romm_photo_url5') .set('romm_photo_url4') .set('romm_photo_url3') .set('romm_photo_url2') .set('par_room_id') .set('cpn_branch_id') .set('cre_dt') .set('st_id') .set('oper_user')
     ;
 }

 /**
  * 提交添加
  */
 Xgt_cpn_roomInfo.add = function() {
     this.collectData();
     //提交信息
     var ajax = new $ax(Feng.ctxPath + "/xgt_cpn_room/add", function(data){
         Feng.success("添加成功!");
         window.parent.Xgt_cpn_room.table.refresh();
         Xgt_cpn_roomInfoDlg.close();
     },function(data){
         Feng.error("添加失败!" + data.responseJSON.message + "!");
     });
      	ajax.set(this.Xgt_cpn_roomInfoData);
	    ajax.start();
 }

 
 
 