/**
 * 初始化企业组织详情对话框
 */
var Xyd_cpn_deptInfoDlg = {
    xyd_cpn_deptInfoData : {},
    cpnzTreeInstance : null
};

/**
 * 初始化企业组织详情对话框*/
var Xyd_cpn_deptPnameDlg = {
    Xyd_cpn_deptPnameDlg : {},
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
Xyd_cpn_deptInfoDlg.onClickCpn = function(e, treeId, treeNode) {
    $("#cpndNm").attr("value", Xyd_cpn_deptInfoDlg.cpnzTreeInstance.getSelectedVal());
    $("#par_cpn_dept_id").attr("value", treeNode.id);
    Xyd_cpn_deptInfoDlg.cpndNm = Xyd_cpn_deptInfoDlg.cpnzTreeInstance.getSelectedVal();
    Xyd_cpn_deptInfoDlg.par_cpn_dept_id = treeNode.id;
}

$(function() {
    var dept_id = $("#cpn_dept_id").val();
    var cpnztree = new $ZTree("cpnareaTree","/xyd_cpn_dept/tree/"+0);
    cpnztree.bindOnClick(Xyd_cpn_deptInfoDlg.onClickCpn);
    cpnztree.init();
    Xyd_cpn_deptInfoDlg.cpnzTreeInstance = cpnztree;
});

/**
 * 显示公司选择的树
 *
 * @returns
 */
Xyd_cpn_deptInfoDlg.showCpnSelectTree = function() {
    Feng.showInputTree("cpndNm", "cpnTreeDiv", 15, 34);
}

/*function loadCpn() {
 var ajax = new $ax(Feng.ctxPath + "/xyd_cpn/nowList", function(data) {
 for(var i=0; i < data.length; i++) {
 $("#cpn_id").append(
 "<option value=" + data[i].cpn_id + ">"
 + data[i].cpn_nm + "</option>");
 }
 }, function(data) {
 Feng.error("查询失败！" + data.responseJSON.message + "!");
 });
 ajax.start();
 }

 $(function() {
 loadCpn();
 })*/
//初始化企业
/*$(function ()  {
 var ajax = new $ax(Feng.ctxPath + "/xyd_cpn/spList/" , function (data) {

 for(var i = 0; i < data.length; i++) {
 $("#cpn_id").append(
 "<option value=" + data[i].cpn_id + ">"
 + data[i].cpn_nm + "</option>");
 }
 }, function(data) {
 Feng.error("获取列表失败!" + data.responseJSON.message + "!");
 });
 ajax.start();

 changeBranch();


 $("#cpn_id").change(
 function () {
 var cpnId = $('#cpn_id').val();
 if(cpnId!=undefined){
 $("#cpn_branch_id").empty();
 var ajax = new $ax(Feng.ctxPath + "/xyd_cpn_branch/nowCpnBranchList/"+cpnId , function (data) {

 for(var i = 0; i < data.length; i++) {
 $("#cpn_branch_id").append(
 "<option value=" + data[i].cpn_branch_id + ">"
 + data[i].cpn_branch_nm + "</option>");
 }
 }, function(data) {
 Feng.error("获取列表失败!" + data.responseJSON.message + "!");
 })};
 ajax.start();
 }
 )
 });
 //初始化分支
 function changeBranch()  {
 var cpnId = $('#cpn_id').val();
 if(cpnId!=undefined){

 var ajax = new $ax(Feng.ctxPath + "/xyd_cpn_branch/nowCpnBranchList/"+cpnId , function (data) {

 for(var i = 0; i < data.length; i++) {
 $("#cpn_branch_id").append(
 "<option value=" + data[i].cpn_branch_id + ">"
 + data[i].cpn_branch_nm + "</option>");
 }
 }, function(data) {
 Feng.error("获取列表失败!" + data.responseJSON.message + "!");
 });
 ajax.start();
 }
 };*/

/**
 * 清除数据
 */
Xyd_cpn_deptInfoDlg.clearData = function() {
    this.xyd_cpn_deptInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xyd_cpn_deptInfoDlg.set = function(key, val) {
    this.xyd_cpn_deptInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xyd_cpn_deptInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
Xyd_cpn_deptInfoDlg.close = function() {
    parent.layer.closeAll()
}

/**
 * 收集数据
 */
Xyd_cpn_deptInfoDlg.collectData = function() {
    this .set('cpn_dept_id') .set('cpn_id') .set('cpn_branch_id') .set('cpn_dept_nm') .set('cpn_dept_code') .set('par_cpn_dept_id') .set('st_id');
}

/**
 * 提交添加
 */
Xyd_cpn_deptInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xyd_cpn_dept/add", function(data){
        Feng.success("添加成功!");
        var ajax1 = new $ax(Feng.ctxPath + "/xyd_cpn_dept/list", function(data){
            tableData=data
        });
        ajax1.start();
        window.parent.layui.table.reload('deptTable', {data:tableData});
        Xyd_cpn_deptInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xyd_cpn_deptInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
Xyd_cpn_deptInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    var cpnid = $("#cpn_id").val();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xyd_cpn_dept/update", function(data){
        Feng.success("修改成功!");
        var ajax1 = new $ax(Feng.ctxPath + "/xyd_cpn_dept/list", function(data){
            tableData=data
        });
        ajax1.start();
        window.parent.layui.table.reload('deptTable', {data:tableData});
        Xyd_cpn_deptInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xyd_cpn_deptInfoData);
    ajax.set("cpnid",cpnid);
    ajax.start();
}

/**
 * 初始化xyd详情对话框
 */
var Xyd_cpn_deptInfo = {
    Xyd_cpn_deptInfoData : {}
};

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xyd_cpn_deptInfo.set = function(key, val) {
    this.Xyd_cpn_deptInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}
/**
 * 收集数据
 */
Xyd_cpn_deptInfo.collectData = function() {
    this  .set('cpn_dept_id') .set('cpn_id') .set('cpn_branch_id') .set('cpn_dept_nm') .set('cpn_dept_code') .set('par_cpn_dept_id') .set('st_id')
    ;
}

/**
 * 提交添加
 */
Xyd_cpn_deptInfo.add = function() {
    this.collectData();
    if ($("#cpn_dept_nm").val()==""){
        return false;
    }
    if ($("#cpn_dept_code").val()==""){
        return false;
    }
    var cpnid = $("#cpn_id").val();
//     alert($("#cpn_id").val());

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/dept/add", function(data){
        Feng.success("添加成功!");
        var ajax1 = new $ax(Feng.ctxPath + "/xyd_cpn_dept/list", function(data){
            tableData=data
        });
        ajax1.start();
        window.parent.layui.table.reload('deptTable', {data:tableData});

        Xyd_cpn_deptInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.Xyd_cpn_deptInfoData);
    ajax.set("cpnid",cpnid);
    ajax.start();
}

/**
 * 提交修改
 */
Xyd_cpn_deptInfo.editSubmit = function() {

    this.clearData();
    this.collectData();

    var cpnid = $("#cpn_id").val();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xyd_cpn_dept/update", function(data){
        Feng.success("修改成功!");
        var ajax1 = new $ax(Feng.ctxPath + "/xyd_cpn_dept/list", function(data){
            tableData=data
        });
        ajax1.start();
        window.parent.layui.table.reload('deptTable', {data:tableData});
        Xyd_cpn_deptInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xyd_cpn_deptInfoData);
    ajax.set("cpnid",cpnid);
    ajax.start();
}