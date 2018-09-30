/**
 * 初始化企业详情对话框
 */
var Xyd_cpnInfoDlg = {
    xyd_cpnInfoData : {}
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
    $("#cpn_cata_id").attr("value", treeNode.id);
    Cpn_cata_paridDlg.cpnPname = Cpn_cata_paridDlg.cpnzTreeInstance.getSelectedVal();
    Cpn_cata_paridDlg.cpn_cata_id = treeNode.id;
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
 * 初始化地区详情对话框
 */
var Sys_areaInfoDlg = {
    sys_areaInfoData : {},
	zTreeInstance : null
};

/**
 * 点击地区ztree列表的选项时
 *
 * @param e
 * @param treeId
 * @param treeNode
 * @returns
 */
Sys_areaInfoDlg.onClickArea = function(e, treeId, treeNode) {
    $("#codeName").attr("value", Sys_areaInfoDlg.zTreeInstance.getSelectedVal());
    $("#code_area_id").attr("value", treeNode.id);
    Sys_areaInfoDlg.codeName = Sys_areaInfoDlg.zTreeInstance.getSelectedVal();
    Sys_areaInfoDlg.code_area_id = treeNode.id;
}

$(function() {

    var ztree = new $ZTree("codeareaTree", "/sys_area/tree");
    ztree.bindOnClick(Sys_areaInfoDlg.onClickArea);
    ztree.init();
    Sys_areaInfoDlg.zTreeInstance = ztree;
});

/**
 * 显示地区选择的树
 *
 * @returns
 */
Sys_areaInfoDlg.showAreaSelectTree = function() {
	Feng.showInputTree("codeName", "codeareaTreeDiv", 15, 34);
}

/**
 * 初始化地区详情对话框
 */
var Sys_areaInfoDlg2 = {
    sys_areaInfoData2 : {},
	zTreeInstance2 : null
};

/**
 * 点击地区ztree列表的选项时
 *
 * @param e
 * @param treeId
 * @param treeNode
 * @returns
 */
Sys_areaInfoDlg2.onClickArea2 = function(e, treeId, treeNode) {
    $("#workName").attr("value", Sys_areaInfoDlg2.zTreeInstance2.getSelectedVal());
    $("#work_area_id").attr("value", treeNode.id);
    Sys_areaInfoDlg2.workName = Sys_areaInfoDlg2.zTreeInstance2.getSelectedVal();
    Sys_areaInfoDlg2.work_area_id = treeNode.id;
}

$(function() {

    var ztree2 = new $ZTree("workareaTree", "/sys_area/tree");
    ztree2.bindOnClick(Sys_areaInfoDlg2.onClickArea2);
    ztree2.init();
    Sys_areaInfoDlg2.zTreeInstance2 = ztree2;
});

$(function() {
	var cardUrl1 = new $WebUpload("cpn_acc_card_url1");
	cardUrl1.init();
    
    var cardUrl2 = new $WebUpload("cpn_acc_card_url2");
    cardUrl2.init();
    
    var codeUrl1 = new $WebUpload("cpn_code_url");
    codeUrl1.init();
})

/**
 * 显示地区选择的树
 *
 * @returns
 */
Sys_areaInfoDlg2.showAreaSelectTree2 = function() {
	Feng.showInputTree("workName", "workareaTreeDiv", 15, 34);
}

/**
 * 清除数据
 */
Xyd_cpnInfoDlg.clearData = function() {
    this.xyd_cpnInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xyd_cpnInfoDlg.set = function(key, val) {
    this.xyd_cpnInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xyd_cpnInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
Xyd_cpnInfoDlg.close = function() {
    parent.layer.close(window.parent.Xyd_cpn.layerIndex);
}

/**
 * 收集数据
 */
Xyd_cpnInfoDlg.collectData = function() {
    this .set('cpn_id') .set('cpn_cata_id') .set('cpn_code') .set('approval_opinion') .set('cpn_nm') .set('cpn_main_nm') .set('cpn_main_phone') .set('cpn_main_mail') .set('work_area_id') .set('work_address') .set('code_area_id') .set('code_address') .set('cpn_acc_nm') .set('cpn_acc_phone') .set('cpn_acc_mail') .set('cpn_acc_card_no') .set('cpn_acc_card_url1') .set('cpn_acc_card_url2') .set('cpn_code_url') .set('cpn_st') .set('cp_sp_st') .set('sp_user_id') .set('sale_user_id');
}

/**
 * 提交添加
 */
Xyd_cpnInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xyd_cpn/add", function(data){
        Feng.success("添加成功!");
        window.parent.Xyd_cpn.table.refresh();
        Xyd_cpnInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xyd_cpnInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
Xyd_cpnInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();
    
    var cpn_id = $("#cpn_id").val();
    console.log(cpn_id);

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xyd_cpnReviewe/update/" + cpn_id, function(data){
        Feng.success("修改成功!");
        window.parent.Xyd_cpn.table.refresh();
        Xyd_cpnInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xyd_cpnInfoData);
    ajax.start();
}

/**
 * 审核不通过
 */
Xyd_cpnInfoDlg.notgo = function() {

    this.clearData();
    this.collectData();
    
    var cpn_id = $("#cpn_id").val();
    console.log(cpn_id);
    
    var approval_opinion = $("#approval_opinion").val();
    console.log(approval_opinion);

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xyd_cpnReviewe/notgo/" + cpn_id, function(data){
        Feng.success("修改成功!");
        window.parent.Xyd_cpn.table.refresh();
        Xyd_cpnInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xyd_cpnInfoData);
    ajax.set("approval_opinion");
    ajax.start();
}


/**
  * 初始化xyd详情对话框
  */
 var Xyd_cpnInfo = {
     Xyd_cpnInfoData : {}
 };

 /**
  * 设置对话框中的数据
  *
  * @param key 数据的名称
  * @param val 数据的具体值
  */
 Xyd_cpnInfo.set = function(key, val) {
 	this.Xyd_cpnInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
 	return this;
 }
 /**
  * 收集数据
  */
 Xyd_cpnInfo.collectData = function() {
     this  .set('cpn_id') .set('cpn_cata_id') .set('cpn_code') .set('approval_opinion') .set('cpn_nm') .set('cpn_main_nm') .set('cpn_main_phone') .set('cpn_main_mail') .set('work_area_id') .set('work_address') .set('code_area_id') .set('code_address') .set('cpn_acc_nm') .set('cpn_acc_phone') .set('cpn_acc_mail') .set('cpn_acc_card_no') .set('cpn_acc_card_url1') .set('cpn_acc_card_url2') .set('cpn_code_url') .set('cpn_st') .set('cp_sp_st') .set('sp_user_id') .set('sale_user_id');
 }

 /**
  * 提交添加
  */
 Xyd_cpnInfo.add = function() {
     this.collectData();
     //提交信息
     var ajax = new $ax(Feng.ctxPath + "/xyd_cpn/add", function(data){
         Feng.success("添加成功!");
         window.parent.Xyd_cpn.table.refresh();
         Xyd_cpnInfoDlg.close();
     },function(data){
         Feng.error("添加失败!" + data.responseJSON.message + "!");
     });
      	ajax.set(this.Xyd_cpnInfoData);
	    ajax.start();
 }

 
 
 