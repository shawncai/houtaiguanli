/**
 * 初始化产品单位详情对话框
 */
var Xgt_goods_prd_unitInfoDlg = {
    xgt_goods_prd_unitInfoData : {}
};

/**
 * 清除数据
 */
Xgt_goods_prd_unitInfoDlg.clearData = function() {
    this.xgt_goods_prd_unitInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xgt_goods_prd_unitInfoDlg.set = function(key, val) {
    this.xgt_goods_prd_unitInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xgt_goods_prd_unitInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
Xgt_goods_prd_unitInfoDlg.close = function() {
    parent.layer.close(window.parent.Xgt_goods_prd_unit.layerIndex);
}

/**
 * 收集数据
 */
Xgt_goods_prd_unitInfoDlg.collectData = function() {
    this .set('prd_unit_id') .set('prd_unit_nm') .set('prd_unit_alias')
    
    ;
}

/**
 * 提交添加
 */
Xgt_goods_prd_unitInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();
    if ($("#prd_unit_nm").val()==""){
        return false;
    }
    if ($("#prd_unit_alias").val()==""){
        return false;
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_goods_prd_unit/add", function(data){
        Feng.success("添加成功!");
        window.parent.Xgt_goods_prd_unit.table.refresh();
        Xgt_goods_prd_unitInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xgt_goods_prd_unitInfoData);
    ajax.start();
}


/**
 * 提交添加
 */
Xgt_goods_prd_unitInfoDlg.addContinueSubmit = function() {
    if ($("#prd_unit_nm").val()==""){
        return false;
    }
    if ($("#prd_unit_nm").val()==""){
        return false;
    }
    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_goods_prd_unit/add", function(data){
        Feng.success("添加成功!");
        window.parent.Xgt_goods_prd_unit.table.refresh();
        $("#prd_unit_alias").val("");
        $("#prd_unit_nm").val("");
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xgt_goods_prd_unitInfoData);
    ajax.start();
}
/**
 * 提交修改
 */
Xgt_goods_prd_unitInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();
    if ($("#prd_unit_nm").val()==""){
        return false;
    }
    if ($("#prd_unit_alias").val()==""){
        return false;
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_goods_prd_unit/update", function(data){
        Feng.success("修改成功!");
        window.parent.Xgt_goods_prd_unit.table.refresh();
        Xgt_goods_prd_unitInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xgt_goods_prd_unitInfoData);
    ajax.start();
}


/**
  * 初始化xyd详情对话框
  */
 var Xgt_goods_prd_unitInfo = {
     Xgt_goods_prd_unitInfoData : {}
 };

 /**
  * 设置对话框中的数据
  *
  * @param key 数据的名称
  * @param val 数据的具体值
  */
 Xgt_goods_prd_unitInfo.set = function(key, val) {
 	this.Xgt_goods_prd_unitInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
 	return this;
 }
 /**
  * 收集数据
  */
 Xgt_goods_prd_unitInfo.collectData = function() {
     this  .set('prd_unit_id') .set('prd_unit_nm') .set('prd_unit_alias')
     ;
 }

 /**
  * 提交添加
  */
 Xgt_goods_prd_unitInfo.add = function() {
     this.collectData();
     if ($("#prd_unit_nm").val()==""){
         return false;
     }
     if ($("#prd_unit_alias").val()==""){
         return false;
     }
     //提交信息
     var ajax = new $ax(Feng.ctxPath + "/xgt_goods_prd_unit/add", function(data){
         Feng.success("添加成功!");
         window.parent.Xgt_goods_prd_unit.table.refresh();
         Xgt_goods_prd_unitInfoDlg.close();
     },function(data){
         Feng.error("添加失败!" + data.responseJSON.message + "!");
     });
      	ajax.set(this.Xgt_goods_prd_unitInfoData);
	    ajax.start();
 }

 //校验输入框中的内容