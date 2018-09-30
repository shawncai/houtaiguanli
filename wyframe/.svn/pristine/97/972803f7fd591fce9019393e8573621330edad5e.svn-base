/**
 * 地区管理初始化
 */
var Sys_area = {
    id: "Sys_areaTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Sys_area.initColumn = function () {
    var columns = [
        {field: 'selectItem', radio: true},
       	{title: '地区ID', field: 'area_id', visible: false, align: 'center', valign: 'middle'},
        {title: '地区名称', field: 'area_nm', align: 'center', valign: 'middle', sortable: true},
        {title: '上级地区', field: 'par_area_nm', align: 'center', valign: 'middle', sortable: true},
        {title: '所属省份名称', field: 'prov_nm', align: 'center', valign: 'middle', sortable: true},
        {title: '所属地市名称', field: 'city_nm', align: 'center', valign: 'middle', sortable: true},
        {title: '所属区域名称', field: 'region_nm', align: 'center', valign: 'middle', sortable: true},
        {title: '所属街道', field: 'street_id', align: 'center', valign: 'middle', sortable: true},
        {title: '所属街道名称', field: 'street_nm', align: 'center', valign: 'middle', sortable: true},
        {title: '地区层级', field: 'area_deep', align: 'center', valign: 'middle', sortable: true},
        {title: '地区排序', field: 'area_sort', align: 'center', valign: 'middle', sortable: true}]
    return columns;
};

/**
 * 检查是否选中
 */
Sys_area.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Sys_area.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加地区
 */
Sys_area.openAddSys_area = function () {
    var areaId = Sys_area.area_id;
    if(areaId==undefined){
        Feng.error("请在左侧选择分类!");
    }else {
        var index = layer.open({
            type: 2,
            title: '添加地区',
            area: ['70%', '250px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/sys_area/sys_area_add/' + areaId
        });
        this.layerIndex = index;
    }
};

/**
 * 打开查看地区详情_修改
 */
Sys_area.openSys_areaDetail_update = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '地区详情_修改',
            area: ['70%', '250px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/sys_area/sys_area_update/' + Sys_area.seItem.area_id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除地区
 */
Sys_area.delete = function () {
    if (this.check()) {
     var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/sys_area/delete", function (data) {
            Feng.success("删除成功!");
            Sys_area.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("sys_areaId",Sys_area.seItem.area_id);
        ajax.start();
    }
    	 Feng.confirm("是否刪除该地区?", operation);
    }
};

/**
 * 查询地区列表
 */
Sys_area.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    queryData['area_id'] = Sys_area.area_id;
    Sys_area.table.refresh({query: queryData});
};

//$(function () {
//	var defaultColunms = Sys_area.initColumn();
//	
//	var table = new BSTreeTable(Sys_area.id, "/sys_area/list", defaultColunms);
//    table.setExpandColumn(2);
//    table.setIdField("area_id");
//    table.setCodeField("area_id");
//    table.setParentCodeField("par_area_id");
//    table.setExpandAll(false);
//    table.init();
//    Sys_area.table = table;
//});

$(function () {
    var defaultColunms = Sys_area.initColumn();
    var table = new BSTable(Sys_area.id, "/sys_area/list", defaultColunms);
    table.setPaginationType("client");
    Sys_area.table = table.init();

    var ztree = new $ZTree("areatree", "/sys_area/tree");
    ztree.bindOnClick(Sys_area.onClickArea);
    ztree.init();
});


Sys_area.onClickArea = function(e, treeId, treeNode) {
    Sys_area.area_id = treeNode.id;
    console.log(Sys_area.area_id);
    Sys_area.search();
}

/**
 * 导出地区
 */
Sys_area.export = function () {
       window.location.href=Feng.ctxPath + "/sys_area/export";
};

/**
 * 打开查看地区详情
 */
Sys_area.openSys_areaDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '地区详情',
            area: ['70%', '250px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/sys_area/sys_area_detail/' + Sys_area.seItem.area_id
        });
        this.layerIndex = index;
    }
};

/**
 * 收集数据
 */
Sys_area.collectData = function() {
    this .set('area_id') .set('area_nm') .set('par_area_id') .set('prov_id') .set('prov_nm') .set('city_id') .set('city_nm') .set('region_id') .set('region_nm') .set('street_id') .set('street_nm') .set('area_deep') .set('area_sort');
}

/**
 * 添加地区
 */
Sys_area.add = function () {
  	alert(this.collectData());
     var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/sys_area/add", function (data) {
            Feng.success("添加成功!");
            Sys_area.table.refresh();
        }, function (data) {
            Feng.error("添加失败!" + data.responseJSON.message + "!");
        });
        ajax.start();
    }
    	 Feng.confirm("是否添加该地区?", operation);
};
