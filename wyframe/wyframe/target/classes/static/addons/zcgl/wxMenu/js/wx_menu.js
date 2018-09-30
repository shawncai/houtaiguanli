/**
 * 自定义菜单管理初始化
 */
var Wx_menu = {
    id: "Wx_menuTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Wx_menu.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
       	{title: '自定义菜单ID', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '主菜单', field: 'fmenu', align: 'center', valign: 'middle', sortable: true}
,
        {title: '副菜单', field: 'smenu', align: 'center', valign: 'middle', sortable: true}
,
        {title: '上级菜单', field: 'pmenu', align: 'center', valign: 'middle', sortable: true}
,
        {title: '菜单类型', field: 'type', align: 'center', valign: 'middle', sortable: true}
,
        {title: '微信ID', field: 'wxid', align: 'center', valign: 'middle', sortable: true}
    ];
};

/**
 * 检查是否选中
 */
Wx_menu.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Wx_menu.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加自定义菜单
 */
Wx_menu.openAddWx_menu = function () {
    var index = layer.open({
        type: 2,
        title: '添加自定义菜单',
        area: ['100%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/wx_menu/wx_menu_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看自定义菜单详情_修改
 */
Wx_menu.openWx_menuDetail_update = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '自定义菜单详情_修改',
            area: ['100%', '100%'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/wx_menu/wx_menu_update/' + Wx_menu.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除自定义菜单
 */
Wx_menu.delete = function () {
    if (this.check()) {
     var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/wx_menu/delete", function (data) {
            Feng.success("删除成功!");
            Wx_menu.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("wx_menuId",Wx_menu.seItem.id);
        ajax.start();
    }
    	 Feng.confirm("是否刪除该自定义菜单?", operation);
    }
};

/**
 * 查询自定义菜单列表
 */
Wx_menu.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Wx_menu.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Wx_menu.initColumn();
    var table = new BSTable(Wx_menu.id, "/wx_menu/list", defaultColunms);
    table.setPaginationType("client");
    Wx_menu.table = table.init();
});

/**
 * 导出自定义菜单
 */
Wx_menu.export = function () {
       window.location.href=Feng.ctxPath + "/wx_menu/export";
};

/**
 * 打开查看自定义菜单详情
 */
Wx_menu.openWx_menuDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '自定义菜单详情',
            area: ['100%', '100%'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/wx_menu/wx_menu_detail/' + Wx_menu.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 收集数据
 */
Wx_menu.collectData = function() {
    this .set('id') .set('fmenu') .set('smenu') .set('pmenu') .set('type') .set('wxid');
}

/**
 * 添加自定义菜单
 */
Wx_menu.add = function () {
  	alert(this.collectData());
     var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/wx_menu/add", function (data) {
            Feng.success("添加成功!");
            Wx_menu.table.refresh();
        }, function (data) {
            Feng.error("添加失败!" + data.responseJSON.message + "!");
        });
        ajax.start();
    }
    	 Feng.confirm("是否添加该自定义菜单?", operation);
};
