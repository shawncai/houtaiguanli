/**
 * 销售渠道管理初始化
 */
var Bs_sale_channel = {
    id: "Bs_sale_channelTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Bs_sale_channel.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
       {title: '销售渠道ID', field: 'chnl_id', visible: false, align: 'center', valign: 'middle'},
        
        {title: '渠道编号', field: 'chnl_no', align: 'center', valign: 'middle', sortable: true}
,
        
        {title: '渠道名称', field: 'chnl_nm', align: 'center', valign: 'middle', sortable: true}
,
        
        {title: '渠道描述', field: 'chnl_desc', align: 'center', valign: 'middle', sortable: true}
,
        
        {title: '渠道联系方式', field: 'chnl_phone', align: 'center', valign: 'middle', sortable: true}
,
        
        {title: '销售用户名称', field: 'chnl_user_nm', align: 'center', valign: 'middle', sortable: true}
    ];
};

/**
 * 检查是否选中
 */
Bs_sale_channel.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Bs_sale_channel.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加销售渠道
 */
Bs_sale_channel.openAddBs_sale_channel = function () {
    var index = layer.open({
        type: 2,
        title: '添加销售渠道',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/bs_sale_channel/bs_sale_channel_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看销售渠道详情
 */
Bs_sale_channel.openBs_sale_channelDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '销售渠道详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/bs_sale_channel/bs_sale_channel_update/' + Bs_sale_channel.seItem.chnl_id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除销售渠道
 */
Bs_sale_channel.delete = function () {
    if (this.check()) {
     var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/bs_sale_channel/delete", function (data) {
            Feng.success("删除成功!");
            Bs_sale_channel.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("bs_sale_channelId",Bs_sale_channel.seItem.chnl_id);
        ajax.start();
    }
    	 Feng.confirm("是否刪除该销售渠道?", operation);
    }
};

/**
 * 查询销售渠道列表
 */
Bs_sale_channel.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Bs_sale_channel.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Bs_sale_channel.initColumn();
    var table = new BSTable(Bs_sale_channel.id, "/bs_sale_channel/list", defaultColunms);
    table.setPaginationType("client");
    Bs_sale_channel.table = table.init();
    
   
});
