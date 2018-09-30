/**
 * 初始化入驻企业详情对话框
 */
var Xyd_cpn_cataInfoDlg = {
    xyd_cpn_cataInfoData : {}
};

/**
 * 初始化入驻企业详情对话框
 */
var Cpn_cata_paridDlg = {
	Cpn_cata_paridData : {},
	cpnzTreeInstance : null
};

/**
 * 点击公司ztree列表的选项时
 *
 * @param e
 * @param treeId
 * @param treeNode
 * @returns
 */
Cpn_cata_paridDlg.onClickCpn = function(e, treeId, treeNode) {
    $("#cpnPname").attr("value", Cpn_cata_paridDlg.cpnzTreeInstance.getSelectedVal());
    $("#par_cpn_cata_id").attr("value", treeNode.id);
    Cpn_cata_paridDlg.cpnPname = Cpn_cata_paridDlg.cpnzTreeInstance.getSelectedVal();
    Cpn_cata_paridDlg.par_cpn_cata_id = treeNode.id;
}

$(function() {

    var cpnztree = new $ZTree("cpnareaTree", "/xyd_cpn_cata/tree");
    cpnztree.bindOnClick(Cpn_cata_paridDlg.onClickCpn);
    cpnztree.init();
    Cpn_cata_paridDlg.cpnzTreeInstance = cpnztree;
});

/**
 * 显示公司选择的树
 *
 * @returns
 */
Cpn_cata_paridDlg.showCpnSelectTree = function() {
	Feng.showInputTree("cpnPname", "cpnTreeDiv", 15, 34);
}

/**
 * 清除数据
 */
Xyd_cpn_cataInfoDlg.clearData = function() {
    this.xyd_cpn_cataInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xyd_cpn_cataInfoDlg.set = function(key, val) {
    this.xyd_cpn_cataInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xyd_cpn_cataInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
Xyd_cpn_cataInfoDlg.close = function() {
    parent.layer.close(window.parent.Xyd_cpn_cata.layerIndex);
}

/**
 * 收集数据
 */
Xyd_cpn_cataInfoDlg.collectData = function() {
    this .set('cpn_cata_id') .set('cpn_cata_code') .set('cpn_cata_nm') .set('par_cpn_cata_id');
}

/**
 * 提交添加
 */
Xyd_cpn_cataInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xyd_cpn_cata/add", function(data){
        Feng.success("添加成功!");
        window.parent.Xyd_cpn_cata.table.refresh();
        Xyd_cpn_cataInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xyd_cpn_cataInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
Xyd_cpn_cataInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xyd_cpn_cata/update", function(data){
        Feng.success("修改成功!");
        window.parent.Xyd_cpn_cata.table.refresh();
        Xyd_cpn_cataInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xyd_cpn_cataInfoData);
    ajax.start();
}


/**
  * 初始化xyd详情对话框
  */
 var Xyd_cpn_cataInfo = {
     Xyd_cpn_cataInfoData : {}
 };

 /**
  * 设置对话框中的数据
  *
  * @param key 数据的名称
  * @param val 数据的具体值
  */
 Xyd_cpn_cataInfo.set = function(key, val) {
 	this.Xyd_cpn_cataInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
 	return this;
 }
 /**
  * 收集数据
  */
 Xyd_cpn_cataInfo.collectData = function() {
     this  .set('cpn_cata_id') .set('cpn_cata_code') .set('cpn_cata_nm') .set('par_cpn_cata_id');
 }

 /**
  * 提交添加
  */
 Xyd_cpn_cataInfo.add = function() {
     this.collectData();
     //提交信息
     var ajax = new $ax(Feng.ctxPath + "/xyd_cpn_cata/add", function(data){
         Feng.success("添加成功!");
         window.parent.Xyd_cpn_cata.table.refresh();
         Xyd_cpn_cataInfoDlg.close();
     },function(data){
         Feng.error("添加失败!" + data.responseJSON.message + "!");
     });
      	ajax.set(this.Xyd_cpn_cataInfoData);
	    ajax.start();
 }

 
 
 