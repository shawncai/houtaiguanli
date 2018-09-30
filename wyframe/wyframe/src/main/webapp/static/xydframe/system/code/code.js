/**
 * 代码生成管理初始化
 */
var Code = {
	ztreeInstance: null,
	CodeData: {},
	id : "codeInfoTable", // 表格id
	seItem : 0, // 选中的条目
	table : null,
	layerIndex : -1,
	pcode: null,
	pcodeName: null
};
/**
 * 代码生成管理初始化
 */
var Code2 = {
	ztreeInstance: null,
	CodeData: {},
	id : "codeInfoTable2", // 表格id
	seItem : 0, // 选中的条目
	table : null,
	layerIndex : -1,
	pcode: null,
	pcodeName: null
};
//全部选中
function stateFormatter(value, row, index) {
    if (row.state == true)
        return {
            disabled : true,//设置是否可用
            checked : true//设置选中
        };
    return value;
}
/**
 * 初始化表格的列
 */
Code.initColumn = function () {
    return [
        {field: 'selectItem',checked: true},
        {title: '字段名称', field: 'columnName', align: 'center', valign: 'middle'},
        {title: '字段备注', field: 'columnRemark', align: 'center', valign: 'middle'},
        {title: '数据库类型', field: 'sqlType', visible: false,align: 'center', valign: 'middle'},
        {title: 'JAVA类型', field: 'javaType', align: 'center', valign: 'middle'},
        {title: '表单类型', field: 'formType', align: 'center', valign: 'middle'},
        {title: '词典ID', field: 'dictId', align: 'center', valign: 'middle'}
    ];
};

///**
// * 检查是否选中
// */
//Code.check = function () {
//    var selected = $('#' + this.id).bootstrapTable('getSelections');
//    if(selected.length == 0){
//        Feng.info("请先选中表格中的某一记录！");
//        return false;
//    }else{
//        Code.seItem = selected[0];
//        return true;
//    }
//};


/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Code.set = function (key, val) {
    this.roleInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}
/**
 * 收集数据
 */
Code.collectData = function () {
    this.set('pcodeName').set('add').set('update').set('delete');
}
/**
 * 点击父级编号input框时
 */
Code.onClickDept = function (e, treeId, treeNode) {
    $("#pcodeName").attr("value", Code.ztreeInstance.getSelectedVal());
    $("#pcode").attr("value", treeNode.id);
    Code.pcodeName = Code.ztreeInstance.getSelectedVal();
    Code.pcode =  treeNode.id;
};

Code.showMenuSelectTree = function () {
    Feng.showInputTree("pcodeName", "pcodeTreeDiv", 15, 34);
};



$(function () {

    var ztree = new $ZTree("pcodeTree", "/menu/selectMenuTreeList");
    ztree.bindOnClick(Code.onClickDept);
    ztree.init();
    Code.ztreeInstance = ztree;
    
});


Code.initTable = function () {
	var tableName = $("#tableName").val().split(".");
	$("#bizEnName").val(tableName[1]);
    var defaultColunms = Code.initColumn();
    var table = new BSTable(Code.id, "/code/typeList/"+tableName[0]+"-"+tableName[1], defaultColunms);
    table.setPaginationType("client");
    Code.table = table.init();
};
/**
 * 提交代码生成
 */
Code.generate = function () {
	var baseAjax = Feng.baseAjax("/code/generate", "生成代码");
	baseAjax.set("bizChName");
	baseAjax.set("bizEnName");
	baseAjax.set("path");
	baseAjax.set("moduleName");
	baseAjax.set("tableName");
	baseAjax.set("bizEnName3");
	var selecteds = $('#' + this.id).bootstrapTable('getSelections');
	for (var i = 0; i < selecteds.length; i++) {
	selecteds[i].shop_num = $('#' + selecteds[i].shop_id).val();
	var dict=$("#"+selecteds[i].columnName+"dictId").val();
	selecteds[i].dictId=dict;
	var l=	$("#"+selecteds[i].columnName).val();
	if(l==1){
		selecteds[i].formType="input";
	}else if(l==2){
		selecteds[i].formType="select";
	}else if(l==3){
		selecteds[i].formType="tree";
	}
	}
	baseAjax.set("table",JSON.stringify(selecteds));
	var selecteds2 = $('#' + Code2.id).bootstrapTable('getSelections');
	for (var i = 0; i < selecteds2.length; i++) {
	selecteds2[i].shop_num = $('#' + selecteds2[i].shop_id).val();
	var dict=$("#"+selecteds2[i].columnName+"dictId").val();
	selecteds2[i].dictId=dict;
	var l=	$("#"+selecteds2[i].columnName).val();
	if(l==1){
		selecteds2[i].formType="input";
	}else if(l==2){
		selecteds2[i].formType="select";
	}else if(l==3){
		selecteds2[i].formType="tree";
	}
	}
	if($("#bizEnName2").val()==""){
		baseAjax.set("table2","");
		baseAjax.set("bizEnName2","");
	}else{
		
		baseAjax.set("bizEnName2",$("#bizEnName2").val());
		baseAjax.set("table2",JSON.stringify(selecteds2));
	}
	baseAjax.set("pcodeName",Code.pcodeName);
	baseAjax.set("pcode",Code.pcode);
	baseAjax.set("add",$('#add').is(':checked')+"");
	baseAjax.set("update",$('#update').is(':checked')+"");
	baseAjax.set("delete",$('#delete').is(':checked')+"");
	baseAjax.set("export",$('#export').is(':checked')+"");
	baseAjax.set("detail",$('#detail').is(':checked')+"");
	baseAjax.start();
};

// 显示模块英文名
Code.showTableName = function() {
	var l=	$("#shop_id").val();
};

Code.initTable2 = function () {
	
	if($("#bizEnName2").val()!=""){
		var tableName2 = $("#bizEnName2").val().split(".");
//		$("#bizEnName2").val(tableName2[1]);
	    var defaultColunms2 = Code.initColumn();
	    var table2 = new BSTable(Code2.id, "/code/typeList2/"+tableName2[0]+"-"+tableName2[1], defaultColunms2);
	    table2.setPaginationType("client");
	    Code.table2 = table2.init();
	}
	
};

