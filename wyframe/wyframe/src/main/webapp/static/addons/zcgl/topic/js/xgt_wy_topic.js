/**
 * 站点栏目管理初始化
 */
var Xgt_wy_topic = {
    id: "Xgt_wy_topicTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Xgt_wy_topic.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
       	{title: '站点栏目ID', field: 'topic_id', visible: false, align: 'center', valign: 'middle'},
        {title: '图片与文件ID', field: 'image_file_id', align: 'center', valign: 'middle', sortable: true},
        {title: '栏目ID', field: 'item_id', align: 'center', valign: 'middle', sortable: true},
        {title: '企业信息ID', field: 'cpn_id', align: 'center', valign: 'middle', sortable: true},
        {title: '站点项目名称', field: 'top_pro_nm', align: 'center', valign: 'middle', sortable: true},
        {title: '站点项目别名', field: 'top_pro_nm_alias', align: 'center', valign: 'middle', sortable: true},
        {title: '项目站点内容', field: 'top_pro_nr', align: 'center', valign: 'middle', sortable: true},
        {title: '上级栏目ID', field: 'par_item_id', align: 'center', valign: 'middle', sortable: true},
        {title: '状态', field: 'st_id', align: 'center', valign: 'middle', sortable: true},
        {title: '操作人', field: 'oper_user', align: 'center', valign: 'middle', sortable: true}
    ];
};

/**
 * 检查是否选中
 */
Xgt_wy_topic.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Xgt_wy_topic.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加站点栏目
 */
Xgt_wy_topic.openAddXgt_wy_topic = function () {
    var index = layer.open({
        type: 2,
        title: '添加站点栏目',
        area: ['100%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/xgt_wy_topic/xgt_wy_topic_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看站点栏目详情_修改
 */
Xgt_wy_topic.openXgt_wy_topicDetail_update = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '站点栏目详情_修改',
            area: ['100%', '100%'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/xgt_wy_topic/xgt_wy_topic_update/' + Xgt_wy_topic.seItem.topic_id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除站点栏目
 */
Xgt_wy_topic.delete = function () {
    if (this.check()) {
     var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/xgt_wy_topic/delete", function (data) {
            Feng.success("删除成功!");
            Xgt_wy_topic.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("xgt_wy_topicId",Xgt_wy_topic.seItem.topic_id);
        ajax.start();
    }
    	 Feng.confirm("是否刪除该站点栏目?", operation);
    }
};

/**
 * 查询站点栏目列表
 */
Xgt_wy_topic.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Xgt_wy_topic.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Xgt_wy_topic.initColumn();
    var table = new BSTable(Xgt_wy_topic.id, "/xgt_wy_topic/list", defaultColunms);
    table.setPaginationType("client");
    Xgt_wy_topic.table = table.init();
    
    loadBranchtree();
});

function loadBranchtree() {
	var ajax = new $ax(Feng.ctxPath + "/xgt_wy_item/ceshi", function(data) {		
		for(var i = 0; i < data.length; i++) {
			$("#ceshi").append(
				"<input class='form-control' id=" + data[i].item_id + " name=" + data[i].item_nm +" type='text'></br>");
		}
	}, function(data) {
		Feng.error("查询失败!" + data.responseJSON.message + "!");
	});
	ajax.start();
}

/**
 * 导出站点栏目
 */
Xgt_wy_topic.export = function () {
       window.location.href=Feng.ctxPath + "/xgt_wy_topic/export";
};

/**
 * 打开查看站点栏目详情
 */
Xgt_wy_topic.openXgt_wy_topicDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '站点栏目详情',
            area: ['100%', '100%'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/xgt_wy_topic/xgt_wy_topic_detail/' + Xgt_wy_topic.seItem.topic_id
        });
        this.layerIndex = index;
    }
};

/**
 * 收集数据
 */
Xgt_wy_topic.collectData = function() {
    this .set('topic_id') .set('image_file_id') .set('item_id') .set('cpn_id') .set('top_pro_nm') .set('top_pro_nm_alias') .set('top_pro_nr') .set('par_item_id') .set('st_id') .set('oper_user');
}

/**
 * 添加站点栏目
 */
Xgt_wy_topic.add = function () {
  	alert(this.collectData());
     var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/xgt_wy_topic/add", function (data) {
            Feng.success("添加成功!");
            Xgt_wy_topic.table.refresh();
        }, function (data) {
            Feng.error("添加失败!" + data.responseJSON.message + "!");
        });
        ajax.start();
    }
    	 Feng.confirm("是否添加该站点栏目?", operation);
};
