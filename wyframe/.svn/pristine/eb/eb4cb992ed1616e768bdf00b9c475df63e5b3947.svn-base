/**
 * 配送商管理初始化
 */
var Bs_send_channel = {
    id: "Bs_send_channelTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Bs_send_channel.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
       {title: '配送商ID', field: 'send_chnl_id', visible: false, align: 'center', valign: 'middle'},
        
        {title: '配送渠道编号', field: 'send_chnl_no', align: 'center', valign: 'middle', sortable: true}
,
        
        {title: '配送渠道名称', field: 'send_chnl_nm', align: 'center', valign: 'middle', sortable: true}
,
        
        {title: '配送渠道描述', field: 'send_chnl_desc', align: 'center', valign: 'middle', sortable: true}
,
        
        {title: '配送渠道联系方式', field: 'send_chnl_phoe', align: 'center', valign: 'middle', sortable: true}
,
        
        {title: '配送数量', field: 'send_chnl_num', align: 'center', valign: 'middle', sortable: true}
,
        
        {title: '1：大于；2：大于等于；3：小于；4：小于等于', field: 'send_chnl_flg', align: 'center', valign: 'middle', sortable: true}
    ];
};

/**
 * 检查是否选中
 */
Bs_send_channel.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Bs_send_channel.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加配送商
 */
Bs_send_channel.openAddBs_send_channel = function () {
    var index = layer.open({
        type: 2,
        title: '添加配送商',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/bs_send_channel/bs_send_channel_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看配送商详情
 */
Bs_send_channel.openBs_send_channelDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '配送商详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/bs_send_channel/bs_send_channel_update/' + Bs_send_channel.seItem.send_chnl_id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除配送商
 */
Bs_send_channel.delete = function () {
    if (this.check()) {
     var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/bs_send_channel/delete", function (data) {
            Feng.success("删除成功!");
            Bs_send_channel.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("bs_send_channelId",Bs_send_channel.seItem.send_chnl_id);
        ajax.start();
    }
    	 Feng.confirm("是否刪除该配送商?", operation);
    }
};

/**
 * 查询配送商列表
 */
Bs_send_channel.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Bs_send_channel.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Bs_send_channel.initColumn();
    var table = new BSTable(Bs_send_channel.id, "/bs_send_channel/list", defaultColunms);
    table.setPaginationType("client");
    Bs_send_channel.table = table.init();
    
   
});
