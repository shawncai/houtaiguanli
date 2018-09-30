var WsdlCode= {
		ztreeInstance: null,
		CodeData: {},
		id : "wsdlCodeTable", // 表格id
		seItem : 0, // 选中的条目
		table : null,
		layerIndex : -1,
		pcode: null,
		pcodeName: null
	};

WsdlCode.initColumn = function(){
    return [
        {field: 'selectItem',checked: true},
        {title: '字段名称', field: 'columnName', align: 'center', valign: 'middle'},
        {title: '字段备注', field: 'columnRemark', align: 'center', valign: 'middle'},
        {title: '数据库类型', field: 'sqlType',align: 'center', valign: 'middle'},
        {title: 'JAVA类型', field: 'javaType', align: 'center', valign: 'middle'}
    ];
};

WsdlCode.initTable = function () {
	var tableName = $("#tableName").val().split(".");
    var defaultColunms = WsdlCode.initColumn();
    var table = new BSTable(WsdlCode.id, "/code/typeList/"+tableName[0]+"-"+tableName[1], defaultColunms);
    table.setPaginationType("client");
    WsdlCode.table = table.init();
};


/**
 * 提交代码生成
 */
WsdlCode.generate = function () {
	var baseAjax = Feng.baseAjax("/code/wsdlGenerate", "生成代码");
	baseAjax.set("path");
	baseAjax.set("moduleName");
	baseAjax.set("tableName",$("#tableName").val());
	var selecteds = $('#' + this.id).bootstrapTable('getSelections');
	baseAjax.set("table",JSON.stringify(selecteds));
	baseAjax.set("add",$('#add').is(':checked')+"");
	baseAjax.set("update",$('#update').is(':checked')+"");
	baseAjax.set("delete",$('#delete').is(':checked')+"");
	baseAjax.set("list",$('#list').is(':checked')+"");
	baseAjax.set("detail",$('#detail').is(':checked')+"");
//	baseAjax.set("info",JSON.stringify(selecteds)+"80804675"+$('#add').is(':checked')+"");
	baseAjax.start();
};