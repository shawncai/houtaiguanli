/**
 * 房间管理初始化
 */
var Xgt_cpn_room = {
    id: "Xgt_cpn_roomTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Xgt_cpn_room.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
       	{title: '房间ID', field: 'room_id', visible: false, align: 'center', valign: 'middle'},
        {title: '房间名称', field: 'room_nm', align: 'center', valign: 'middle', sortable: true}
,
        {title: '房间用途', field: 'room_yt', align: 'center', valign: 'middle', sortable: true}
,
        {title: '房间地址', field: 'room_adrs', align: 'center', valign: 'middle', sortable: true}
,
        {title: '房间坐标X', field: 'room_adrs_x', align: 'center', valign: 'middle', sortable: true}
,
        {title: '房间坐标Y', field: 'room_adrs_y', align: 'center', valign: 'middle', sortable: true}
,
        {title: '房间照片', field: 'romm_photo_url', align: 'center', valign: 'middle', sortable: true}
,
        {title: '房间照片6', field: 'romm_photo_url6', align: 'center', valign: 'middle', sortable: true}
,
        {title: '房间照片5', field: 'romm_photo_url5', align: 'center', valign: 'middle', sortable: true}
,
        {title: '房间照片4', field: 'romm_photo_url4', align: 'center', valign: 'middle', sortable: true}
,
        {title: '房间照片3', field: 'romm_photo_url3', align: 'center', valign: 'middle', sortable: true}
,
        {title: '房间照片2', field: 'romm_photo_url2', align: 'center', valign: 'middle', sortable: true}
,
        {title: '上级房间', field: 'par_room_id', align: 'center', valign: 'middle', sortable: true}
,
        {title: '分支机构ID', field: 'cpn_branch_nm', align: 'center', valign: 'middle', sortable: true}
,
        {title: '创建时间', field: 'cre_dt', align: 'center', valign: 'middle', sortable: true}
,
        {title: '状态', field: 'st_id', align: 'center', valign: 'middle', sortable: true}
,
        {title: '操作人', field: 'oper_user', align: 'center', valign: 'middle', sortable: true}
    ];
};

/**
 * 检查是否选中
 */
Xgt_cpn_room.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Xgt_cpn_room.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加房间
 */
Xgt_cpn_room.openAddXgt_cpn_room = function () {
    var index = layer.open({
        type: 2,
        title: '添加房间',
        area: ['100%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/xgt_cpn_room/xgt_cpn_room_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看房间详情_修改
 */
Xgt_cpn_room.openXgt_cpn_roomDetail_update = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '房间详情_修改',
            area: ['100%', '100%'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/xgt_cpn_room/xgt_cpn_room_update/' + Xgt_cpn_room.seItem.room_id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除房间
 */
Xgt_cpn_room.delete = function () {
    if (this.check()) {
     var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/xgt_cpn_room/delete", function (data) {
            Feng.success("删除成功!");
            Xgt_cpn_room.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("xgt_cpn_roomId",Xgt_cpn_room.seItem.room_id);
        ajax.start();
    }
    	 Feng.confirm("是否刪除该房间?", operation);
    }
};

/**
 * 查询房间列表
 */
Xgt_cpn_room.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Xgt_cpn_room.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Xgt_cpn_room.initColumn();
    var table = new BSTable(Xgt_cpn_room.id, "/xgt_cpn_room/list2", defaultColunms);
    table.setPaginationType("client");
    Xgt_cpn_room.table = table.init();
});

/**
 * 导出房间
 */
Xgt_cpn_room.export = function () {
       window.location.href=Feng.ctxPath + "/xgt_cpn_room/export";
};

/**
 * 打开查看房间详情
 */
Xgt_cpn_room.openXgt_cpn_roomDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '房间详情',
            area: ['100%', '100%'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/xgt_cpn_room/xgt_cpn_room_detail/' + Xgt_cpn_room.seItem.room_id
        });
        this.layerIndex = index;
    }
};

/**
 * 收集数据
 */
Xgt_cpn_room.collectData = function() {
    this .set('room_id') .set('room_nm') .set('room_yt') .set('room_adrs') .set('room_adrs_x') .set('room_adrs_y') .set('romm_photo_url') .set('romm_photo_url6') .set('romm_photo_url5') .set('romm_photo_url4') .set('romm_photo_url3') .set('romm_photo_url2') .set('par_room_id') .set('cpn_branch_id') .set('cre_dt') .set('st_id') .set('oper_user');
}

/**
 * 添加房间
 */
Xgt_cpn_room.add = function () {
	 this.clearData();
	    this.collectData();
     var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/xgt_cpn_room/add", function (data) {
            Feng.success("添加成功!");
            Xgt_cpn_room.table.refresh();
        }, function (data) {
            Feng.error("添加失败!" + data.responseJSON.message + "!");
        });
        ajax.start();
    }
    	 Feng.confirm("是否添加该房间?", operation);
};
