/**
 * 自动回复管理初始化
 */
var Wx_auto_reply = {
    id: "Wx_auto_replyTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Wx_auto_reply.initColumn = function () {
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
Wx_auto_reply.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Wx_auto_reply.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加自动回复
 */
Wx_auto_reply.openAddWx_auto_reply = function () {
    var index = layer.open({
        type: 2,
        title: '添加自动回复',
        area: ['100%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/wx_auto_reply/wx_auto_reply_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看自动回复详情_修改
 */
Wx_auto_reply.openWx_auto_replyDetail_update = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '自动回复详情_修改',
            area: ['100%', '100%'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/wx_auto_reply/wx_auto_reply_update/' + Wx_auto_reply.seItem.ID
        });
        this.layerIndex = index;
    }
};

/**
 * 删除自动回复
 */
Wx_auto_reply.delete = function () {
    if (this.check()) {
     var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/wx_auto_reply/delete", function (data) {
            Feng.success("删除成功!");
            Wx_auto_reply.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("wx_auto_replyId",Wx_auto_reply.seItem.ID);
        ajax.start();
    }
    	 Feng.confirm("是否刪除该自动回复?", operation);
    }
};



/**
 * 查询自动回复列表
 */
Wx_auto_reply.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Wx_auto_reply.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Wx_auto_reply.initColumn();
    var table = new BSTable(Wx_auto_reply.id, "/wx_auto_reply/list", defaultColunms);
    table.setPaginationType("client");
    Wx_auto_reply.table = table.init();
});

/**
 * 导出自动回复
 */
Wx_auto_reply.export = function () {
       window.location.href=Feng.ctxPath + "/wx_auto_reply/export";
};

/**
 * 打开查看自动回复详情
 */
Wx_auto_reply.openWx_auto_replyDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '自动回复详情',
            area: ['100%', '100%'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/wx_auto_reply/wx_auto_reply_detail/' + Wx_auto_reply.seItem.ID
        });
        this.layerIndex = index;
    }
};

/**
 * 收集数据
 */
Wx_auto_reply.collectData = function() {
    this .set('ID') .set('key') .set('reply') .set('type');
}

/**
 * 添加自动回复
 */
Wx_auto_reply.add = function () {
  	alert(this.collectData());
     var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/wx_auto_reply/add", function (data) {
            Feng.success("添加成功!");
            Wx_auto_reply.table.refresh();
        }, function (data) {
            Feng.error("添加失败!" + data.responseJSON.message + "!");
        });
        ajax.start();
    }
    	 Feng.confirm("是否添加该自动回复?", operation);
};
