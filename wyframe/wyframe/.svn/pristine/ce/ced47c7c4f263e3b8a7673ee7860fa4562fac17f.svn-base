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
    $("#areaName").attr("value", Sys_areaInfoDlg.zTreeInstance.getSelectedVal());
    $("#par_area_id").attr("value", treeNode.id);
    Sys_areaInfoDlg.areaName = Sys_areaInfoDlg.ztreeInstance.getSelectedVal();
    Sys_areaInfoDlg.par_area_id = treeNode.id;
}


$(function() {

    var ztree = new $ZTree("areaTree", "/sys_area/tree");
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
	Feng.showInputTree("areaName", "areaTreeDiv", 15, 34);
}

/**
 * 清除数据
 */
Sys_areaInfoDlg.clearData = function() {
    this.sys_areaInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Sys_areaInfoDlg.set = function(key, val) {
    this.sys_areaInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Sys_areaInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
Sys_areaInfoDlg.close = function() {
    parent.layer.closeAll()
}

/**
 * 收集数据
 */
Sys_areaInfoDlg.collectData = function() {
    this .set('area_id') .set('area_nm') .set('par_area_id') .set('prov_id') .set('prov_nm') .set('city_id') .set('city_nm') .set('region_id') .set('region_nm') .set('street_id') .set('street_nm') .set('area_deep') .set('area_sort');
}

/**
 * 提交添加
 */
Sys_areaInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/sys_area/add", function(data){
        Feng.success("添加成功!");
        var ajax1 = new $ax(Feng.ctxPath + "/sys_area/list", function(data){
            tableData=data
        });
        ajax1.start();
        window.parent.layui.table.reload('Sys_areaTable', {data:tableData});

        Sys_areaInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.sys_areaInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
Sys_areaInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();
    if ($("#area_nm").val()==""){
        return false;
    }
    if ($("#areaName").val()==""){
        return false;
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/sys_area/update", function(data){
        Feng.success("修改成功!");
        var ajax1 = new $ax(Feng.ctxPath + "/sys_area/list", function(data){
            tableData=data
        });
        ajax1.start();
        window.parent.layui.table.reload('Sys_areaTable', {data:tableData});

        Sys_areaInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.sys_areaInfoData);
    ajax.start();
}


/**
  * 初始化xyd详情对话框
  */
 var Sys_areaInfo = {
     Sys_areaInfoData : {}
 };

 /**
  * 设置对话框中的数据
  *
  * @param key 数据的名称
  * @param val 数据的具体值
  */
 Sys_areaInfo.set = function(key, val) {
 	this.Sys_areaInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
 	return this;
 }
 /**
  * 收集数据
  */
 Sys_areaInfo.collectData = function() {
     this  .set('area_id') .set('area_nm') .set('par_area_id') .set('prov_id') .set('prov_nm') .set('city_id') .set('city_nm') .set('region_id') .set('region_nm') .set('street_id') .set('street_nm') .set('area_deep') .set('area_sort')
     ;
 }

 /**
  * 提交添加
  */
 Sys_areaInfo.add = function() {
     this.collectData();
     if ($("#area_nm").val()==""){
         return false;
     }
     if ($("#areaName").val()==""){
         return false;
     }
     //提交信息
     var ajax = new $ax(Feng.ctxPath + "/sys_area/add", function(data){
         Feng.success("添加成功!");
         var ajax1 = new $ax(Feng.ctxPath + "/sys_area/list", function(data){
             tableData=data
         });
         ajax1.start();
         window.parent.layui.table.reload('Sys_areaTable', {data:tableData});

         Sys_areaInfoDlg.close();
     },function(data){
         Feng.error("添加失败!" + data.responseJSON.message + "!");
     });
      	ajax.set(this.Sys_areaInfoData);
	    ajax.start();
 }

 
 
 