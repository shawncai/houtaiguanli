/**
 * 入驻企业管理初始化
 */
var Xyd_cpn_cata = {
    id: "Xyd_cpn_cataTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Xyd_cpn_cata.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
       	{title: '入驻企业', field: 'cpn_cata_id', visible: false, align: 'center', valign: 'middle'},
       	{title: '企业分类名称', field: 'cpn_cata_nm', align: 'center', valign: 'middle', sortable: true},
        {title: '企业分类标准编码', field: 'cpn_cata_code', align: 'center', valign: 'middle', sortable: true},
       	{title: '上级企业分类', field: 'par_cpn_cata_id', align: 'center', valign: 'middle', sortable: true}
    ];
};

/**
 * 检查是否选中
 */
Xyd_cpn_cata.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Xyd_cpn_cata.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加入驻企业
 */
Xyd_cpn_cata.openAddXyd_cpn_cata = function () {
    var index = layer.open({
        type: 2,
        title: '添加入驻企业',
        area: ['100%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/xyd_cpn_cata/xyd_cpn_cata_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看入驻企业详情_修改
 */
Xyd_cpn_cata.openXyd_cpn_cataDetail_update = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '入驻企业详情_修改',
            area: ['100%', '100%'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/xyd_cpn_cata/xyd_cpn_cata_update/' + Xyd_cpn_cata.seItem.cpn_cata_id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除入驻企业
 */
Xyd_cpn_cata.delete = function () {
    if (this.check()) {
     var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/xyd_cpn_cata/delete", function (data) {
            Feng.success("删除成功!");
            Xyd_cpn_cata.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("xyd_cpn_cataId",Xyd_cpn_cata.seItem.cpn_cata_id);
        ajax.start();
    }
    	 Feng.confirm("是否刪除该入驻企业?", operation);
    }
};

/**
 * 查询入驻企业列表
 */
Xyd_cpn_cata.search = function () {
    var queryData = {};
    queryData['cpn_cata_nm'] = $("#cpn_cata_nm").val();
    queryData['cpn_cata_id'] = Xyd_cpn_cata.cpn_cata_id;
    console.log($("#cpn_cata_nm").val());
    console.log(Xyd_cpn_cata.cpn_cata_id);
    Xyd_cpn_cata.table.refresh({query: queryData});
};

Xyd_cpn_cata.onClickCata = function(e, treeId, treeNode) {
	Xyd_cpn_cata.cpn_cata_id = treeNode.id;
	Xyd_cpn_cata.search();
}

$(function () {
  var defaultColunms = Xyd_cpn_cata.initColumn();
  var table = new BSTable(Xyd_cpn_cata.id, "/xyd_cpn_cata/list", defaultColunms);
  table.setPaginationType("client");
  Xyd_cpn_cata.table = table.init();

  var ztree = new $ZTree("catatree", "/xyd_cpn_cata/tree");
  ztree.bindOnClick(Xyd_cpn_cata.onClickCata);
  ztree.init();
  
//	var table = new BSTreeTable(Xyd_cpn_cata.id, "/xyd_cpn_cata/list", defaultColunms);
//	table.setExpandColumn(2);
//	table.setIdField("cpn_cata_id");
//	table.setCodeField("cpn_cata_id");
//	table.setParentCodeField("par_cpn_cata_id");
//	table.setExpandAll(true);
//	table.init();
//	Xyd_cpn_cata.table = table;
});

/**
 * 导出入驻企业
 */
Xyd_cpn_cata.export = function () {
       window.location.href=Feng.ctxPath + "/xyd_cpn_cata/export";
};

/**
 * 打开查看入驻企业详情
 */
Xyd_cpn_cata.openXyd_cpn_cataDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '入驻企业详情',
            area: ['100%', '100%'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/xyd_cpn_cata/xyd_cpn_cata_detail/' + Xyd_cpn_cata.seItem.cpn_cata_id
        });
        this.layerIndex = index;
    }
};

/**
 * 收集数据
 */
Xyd_cpn_cata.collectData = function() {
    this .set('cpn_cata_id') .set('cpn_cata_code') .set('cpn_cata_nm') .set('par_cpn_cata_id');
}

/**
 * 添加入驻企业
 */
Xyd_cpn_cata.add = function () {
  	alert(this.collectData());
     var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/xyd_cpn_cata/add", function (data) {
            Feng.success("添加成功!");
            Xyd_cpn_cata.table.refresh();
        }, function (data) {
            Feng.error("添加失败!" + data.responseJSON.message + "!");
        });
        ajax.start();
    }
    	 Feng.confirm("是否添加该入驻企业?", operation);
};
