/**
 * 自动回复管理初始化
 */
var Wx_autoReply = {
    id: "Wx_autoReplyTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Wx_autoReply.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
       	{title: '自动回复ID', field: 'ID', visible: false, align: 'center', valign: 'middle'},
        {title: '关键字', field: 'key', align: 'center', valign: 'middle', sortable: true}
,
        {title: '回复文本内容', field: 'reply', align: 'center', valign: 'middle', sortable: true}
,
        {title: '类型', field: 'type', align: 'center', valign: 'middle', sortable: true}
    ];
};

/**
 * 检查是否选中
 */
Wx_autoReply.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Wx_autoReply.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加自动回复
 */
Wx_autoReply.openAddWx_autoReply = function () {
    var index = layer.open({
        type: 2,
        title: '添加自动回复',
        area: ['100%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/wx_autoReply/wx_autoReply_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看自动回复详情_修改
 */
Wx_autoReply.openWx_autoReplyDetail_update = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '自动回复详情_修改',
            area: ['100%', '100%'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/wx_autoReply/wx_autoReply_update/' + Wx_autoReply.seItem.ID
        });
        this.layerIndex = index;
    }
};

/**
 * 删除自动回复
 */
Wx_autoReply.delete = function () {
    if (this.check()) {
     var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/wx_autoReply/delete", function (data) {
            Feng.success("删除成功!");
            Wx_autoReply.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("wx_autoReplyId",Wx_autoReply.seItem.ID);
        ajax.start();
    }
    	 Feng.confirm("是否刪除该自动回复?", operation);
    }
};

/**
 * 查询自动回复列表
 */
Wx_autoReply.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Wx_autoReply.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Wx_autoReply.initColumn();
    var table = new BSTable(Wx_autoReply.id, "/wx_autoReply/list", defaultColunms);
    table.setPaginationType("client");
    Wx_autoReply.table = table.init();
});

/**
 * 导出自动回复
 */
Wx_autoReply.export = function () {
       window.location.href=Feng.ctxPath + "/wx_autoReply/export";
};

/**
 * 打开查看自动回复详情
 */
Wx_autoReply.openWx_autoReplyDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '自动回复详情',
            area: ['100%', '100%'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/wx_autoReply/wx_autoReply_detail/' + Wx_autoReply.seItem.ID
        });
        this.layerIndex = index;
    }
};

/**
 * 收集数据
 */
Wx_autoReply.collectData = function() {
    this .set('ID') .set('key') .set('reply') .set('type');
}

/**
 * 添加自动回复
 */
Wx_autoReply.add = function () {
  	alert(this.collectData());
     var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/wx_autoReply/add", function (data) {
            Feng.success("添加成功!");
            Wx_autoReply.table.refresh();
        }, function (data) {
            Feng.error("添加失败!" + data.responseJSON.message + "!");
        });
        ajax.start();
    }
    	 Feng.confirm("是否添加该自动回复?", operation);
};
