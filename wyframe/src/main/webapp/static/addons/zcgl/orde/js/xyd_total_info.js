/**
 * 初始化订单详情对话框
 */
var Xyd_totalInfoDlg = {
    xyd_totalInfoData : {}
};

/**
 * 清除数据
 */
Xyd_totalInfoDlg.clearData = function() {
    this.xyd_totalInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xyd_totalInfoDlg.set = function(key, val) {
    this.xyd_totalInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xyd_totalInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
Xyd_totalInfoDlg.close = function() {
    parent.layer.close(window.parent.Xyd_total.layerIndex);
}

/**
 * 收集数据
 */
Xyd_totalInfoDlg.collectData = function() {
    this .set('msg_id') .set('msg_nm') .set('msg_desc') .set('order_staff')
     .set('msg_detl_id') .set('msg_id') .set('SHOP_ID') .set('msg_detl_desc') .set('msg_http')
    ;
}

/**
 * 提交添加
 */
Xyd_totalInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xyd_total/add", function(data){
        Feng.success("添加成功!");
        window.parent.Xyd_total.table.refresh();
        Xyd_totalInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
     ajax.set("str",JSON.stringify(this.xyd_totalInfoData));
    ajax.start();
}

/**
 * 提交修改
 */
Xyd_totalInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xyd_total/update", function(data){
        Feng.success("修改成功!");
        window.parent.Xyd_total.table.refresh();
        Xyd_totalInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xyd_totalInfoData);
      var selected = $('#' + Xyd_totalParam.id).bootstrapTable('getSelections');
	var str = "";
	for(var i =0;i<selected.length;i++){
		str=str+selected[i].SHOP_ID+".";
	}
	ajax.set("str",str);
    ajax.start();
}


/**
 * 订单管理初始化
 */
var Xyd_totalParam = {
    id: "paramTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 点击添加订单
 */
Xyd_totalParam.appendXyd_total = function () {
    var index = layer.open({
        type: 2,
        title: '添加参数',
        area: ['100%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/xyd_total/xyd_total_add_param'
    });
    this.layerIndex = index;
};

/**
 * 初始化表格的列
 */
Xyd_totalParam.initColumn = function () {
    return [
        {field: 'selectItem', checkbox: true}
,        {title: '商品ID', field: 'SHOP_ID', align: 'center', valign: 'middle', sortable: true}
,        {title: '商品编码', field: 'shop_no', align: 'center', valign: 'middle', sortable: true}
,        {title: '商品名称', field: 'shop_nm', align: 'center', valign: 'middle', sortable: true}
,        {title: '商品重量', field: 'shop_weigth', align: 'center', valign: 'middle', sortable: true}
,        {title: '商品规格', field: 'shop_spec', align: 'center', valign: 'middle', sortable: true}
,        {title: '商品条码', field: 'SHOP_NO_NUM', align: 'center', valign: 'middle', sortable: true}
,        {title: '商品单位', field: 'shop_unit', align: 'center', valign: 'middle', sortable: true}
    ];
};

/**
 *参数表页面table
 */
var Xyd_total_params = {
    id: "paramsTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Xyd_total_params.initColumn = function () {
    return [
        {field: 'selectItem', checkbox: true}
,        {title: '商品ID', field: 'SHOP_ID', align: 'center', valign: 'middle', sortable: true}
,        {title: '商品编码', field: 'shop_no', align: 'center', valign: 'middle', sortable: true}
,        {title: '商品名称', field: 'shop_nm', align: 'center', valign: 'middle', sortable: true}
,        {title: '商品重量', field: 'shop_weigth', align: 'center', valign: 'middle', sortable: true}
,        {title: '商品规格', field: 'shop_spec', align: 'center', valign: 'middle', sortable: true}
,        {title: '商品条码', field: 'SHOP_NO_NUM', align: 'center', valign: 'middle', sortable: true}
,        {title: '商品单位', field: 'shop_unit', align: 'center', valign: 'middle', sortable: true}
    ];
    
};

function selects(){
	var selected = $('#' + Xyd_total_params.id).bootstrapTable('getSelections');
	var str = "";
	for(var i =0;i<selected.length;i++){
		str=str+selected[i].SHOP_ID+".";
	}
	var ajax = new $ax(Feng.ctxPath + "/xyd_total/param/"+str, function (data) {
    window.parent.Xyd_totalParam.table.refresh();
    parent.layer.close(window.parent.Xyd_totalParam.layerIndex);
     }, function (data) {
    	 parent.layer.close(window.parent.Xyd_totalParam.layerIndex);
     });
     ajax.start();
}
function removes(){
	var selected = $('#' + Xyd_totalParam.id).bootstrapTable('getSelections');
	var str = "";
	for(var i =0;i<selected.length;i++){
		str=str+selected[i].SHOP_ID+".";
	}
	 var operation = function(){
	        var ajax = new $ax(Feng.ctxPath + "/xyd_total/deleteParam/"+str, function (data) {
	            Feng.success("删除成功!");
	            Xyd_totalParam.table.refresh();
	        }, function (data) {
	            Feng.error("删除失败!" + data.responseJSON.message + "!");
	        });
	        ajax.start();
	    }
	    	 Feng.confirm("是否刪除?", operation);
}

/**
  * 初始化xyd详情对话框
  */
 var Xyd_totalInfo = {
     Xyd_totalInfoData : {}
 };

 /**
  * 设置对话框中的数据
  *
  * @param key 数据的名称
  * @param val 数据的具体值
  */
 Xyd_totalInfo.set = function(key, val) {
 	this.Xyd_totalInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
 	return this;
 }
 /**
  * 收集数据
  */
 Xyd_totalInfo.collectData = function() {
     this  .set('msg_id') .set('msg_nm') .set('msg_desc') .set('order_staff')
     ;
 }

 /**
  * 提交添加
  */
 Xyd_totalInfo.add = function() {
     this.collectData();
     var iData = JSON.stringify(this.Xyd_totalInfoData);
	 var selected = $('#' + Xyd_totalParam.id).bootstrapTable('getSelections');
	 var tData = JSON.stringify(selected);
     //提交信息
     var ajax = new $ax(Feng.ctxPath + "/xyd_total/add", function(data){
         Feng.success("添加成功!");
         window.parent.Xyd_total.table.refresh();
         Xyd_totalInfoDlg.close();
     },function(data){
         Feng.error("添加失败!" + data.responseJSON.message + "!");
     });
      	ajax.set("iData",iData);
		ajax.set("tData",tData);
	    ajax.start();
 }

 
 $(function () {
    var defaultColunms = Xyd_totalParam.initColumn();
    var table = new BSTable(Xyd_totalParam.id, "/xyd_total/paramList", defaultColunms);
    table.setPaginationType("client");
    Xyd_totalParam.table = table.init();
    
    var defaultColunmss = Xyd_total_params.initColumn();
    var tables = new BSTable(Xyd_total_params.id, "/xyd_total/paramsList", defaultColunmss);
    tables.setPaginationType("client");
    Xyd_total_params.table = tables.init();
});
 
 