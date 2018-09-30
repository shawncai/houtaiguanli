/**
 * 图片管理初始化
 */
var Xyd_image_file = {
    id: "Xyd_image_fileTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Xyd_image_file.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
       	{title: '图片ID', field: 'image_file_id', visible: false, align: 'center', valign: 'middle'},
        {title: '名称', field: 'image_file_nm', align: 'center', valign: 'middle', sortable: true}
,
        {title: '原始图url', field: 'image_file_src_url', align: 'center', valign: 'middle', sortable: true}
,
        {title: '缩略图url', field: 'image_file_url', align: 'center', valign: 'middle', sortable: true}
,
        {title: '文件url', field: 'file_url', align: 'center', valign: 'middle', sortable: true}
,
        {title: '文件类型', field: 'img_file_cls', align: 'center', valign: 'middle', sortable: true}
,
        {title: '长度', field: 'img_long', align: 'center', valign: 'middle', sortable: true}
,
        {title: '宽带', field: 'img_wid', align: 'center', valign: 'middle', sortable: true}
,
        {title: '创建时间', field: 'cre_dt', align: 'center', valign: 'middle', sortable: true}
,
        {title: '使用状态', field: 'st_id', align: 'center', valign: 'middle', sortable: true}
,
        {title: '操作人', field: 'oper_user', align: 'center', valign: 'middle', sortable: true}
    ];
};

/**
 * 检查是否选中
 */
Xyd_image_file.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Xyd_image_file.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加图片
 */
Xyd_image_file.openAddXyd_image_file = function () {
    var index = layer.open({
        type: 2,
        title: '添加图片',
        area: ['100%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/xyd_image_file/xyd_image_file_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看图片详情_修改
 */
Xyd_image_file.openXyd_image_fileDetail_update = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '图片详情_修改',
            area: ['100%', '100%'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/xyd_image_file/xyd_image_file_update/' + Xyd_image_file.seItem.image_file_id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除图片
 */
Xyd_image_file.delete = function () {
    if (this.check()) {
     var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/xyd_image_file/delete", function (data) {
            Feng.success("删除成功!");
            Xyd_image_file.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("xyd_image_fileId",Xyd_image_file.seItem.image_file_id);
        ajax.start();
    }
    	 Feng.confirm("是否刪除该图片?", operation);
    }
};

/**
 * 查询图片列表
 */
Xyd_image_file.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Xyd_image_file.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Xyd_image_file.initColumn();
    var table = new BSTable(Xyd_image_file.id, "/xyd_image_file/list", defaultColunms);
    table.setPaginationType("client");
    Xyd_image_file.table = table.init();
});

/**
 * 导出图片
 */
Xyd_image_file.export = function () {
       window.location.href=Feng.ctxPath + "/xyd_image_file/export";
};

/**
 * 打开查看图片详情
 */
Xyd_image_file.openXyd_image_fileDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '图片详情',
            area: ['100%', '100%'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/xyd_image_file/xyd_image_file_detail/' + Xyd_image_file.seItem.image_file_id
        });
        this.layerIndex = index;
    }
};

/**
 * 收集数据
 */
Xyd_image_file.collectData = function() {
    this .set('image_file_id') .set('image_file_nm') .set('image_file_src_url') .set('image_file_url') .set('file_url') .set('img_file_cls') .set('img_long') .set('img_wid') .set('cre_dt') .set('st_id') .set('oper_user');
}

/**
 * 添加图片
 */
Xyd_image_file.add = function () {
  	alert(this.collectData());
     var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/xyd_image_file/add", function (data) {
            Feng.success("添加成功!");
            Xyd_image_file.table.refresh();
        }, function (data) {
            Feng.error("添加失败!" + data.responseJSON.message + "!");
        });
        ajax.start();
    }
    	 Feng.confirm("是否添加该图片?", operation);
};
