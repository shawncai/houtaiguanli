/**
 * 微信公众号管理初始化
 */
var Wx_main = {
    id: "Wx_mainTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Wx_main.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
       	{title: '微信公众号ID', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '公众号名称', field: 'wxname', align: 'center', valign: 'middle', sortable: true}
,
        {title: 'APPID', field: 'appid', align: 'center', valign: 'middle', sortable: true}
,
        {title: 'APPSECRET', field: 'appsecret', align: 'center', valign: 'middle', sortable: true}
,
        {title: 'TOKEN', field: 'token', align: 'center', valign: 'middle', sortable: true}
,
        {title: 'ACCESS_TOKEN', field: 'access_token', align: 'center', valign: 'middle', sortable: true}
    ];
};

/**
 * 检查是否选中
 */
Wx_main.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Wx_main.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加微信公众号
 */
Wx_main.openAddWx_main = function () {
    var index = layer.open({
        type: 2,
        title: '添加微信公众号',
        area: ['100%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/wx_main/wx_main_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看微信公众号详情_修改
 */
Wx_main.openWx_mainDetail_update = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '微信公众号详情_修改',
            area: ['100%', '100%'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/wx_main/wx_main_update/' + Wx_main.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除微信公众号
 */
Wx_main.delete = function () {
    if (this.check()) {
     var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/wx_main/delete", function (data) {
            Feng.success("删除成功!");
            Wx_main.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("wx_mainId",Wx_main.seItem.id);
        ajax.start();
    }
    	 Feng.confirm("是否刪除该微信公众号?", operation);
    }
};

/**
 * 查询微信公众号列表
 */
Wx_main.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Wx_main.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Wx_main.initColumn();
    var table = new BSTable(Wx_main.id, "/wx_main/list", defaultColunms);
    table.setPaginationType("client");
    Wx_main.table = table.init();
});

/**
 * 导出微信公众号
 */
Wx_main.export = function () {
       window.location.href=Feng.ctxPath + "/wx_main/export";
};

/**
 * 打开查看微信公众号详情
 */
Wx_main.openWx_mainDetail = function () {
    this.check();
    var ajax = new $ax(Feng.ctxPath + '/wx_main/wx_main_detail/' + Wx_main.seItem.id, function (data) {
    	Feng.success("当前操作的公众号为:"+Wx_main.seItem.wxname);
    }, function (data) {
        Feng.error("操作失败!" + data.responseJSON.message + "!");
    });
    ajax.start();
};

/**
 * 收集数据
 */
Wx_main.collectData = function() {
    this .set('id') .set('wxname') .set('appid') .set('appsecret') .set('token') .set('access_token');
}

/**
 * 添加微信公众号
 */
Wx_main.add = function () {
  	alert(this.collectData());
     var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/wx_main/add", function (data) {
            Feng.success("添加成功!");
            Wx_main.table.refresh();
        }, function (data) {
            Feng.error("添加失败!" + data.responseJSON.message + "!");
        });
        ajax.start();
    }
    	 Feng.confirm("是否添加该微信公众号?", operation);
};
