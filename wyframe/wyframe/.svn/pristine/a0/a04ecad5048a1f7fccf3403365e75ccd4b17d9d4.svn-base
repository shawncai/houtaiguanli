/**
 * 企业员工管理初始化
 */
var Xyd_goods_store_bill_add = {
    id: "add_all",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};
$(function () {
    var defaultColunms = Xyd_goods_store_bill_add.initColumn();
    var table = new BSTable("add_all", "/xgt_goods_store_bill_out/productList", defaultColunms);
    table.setPaginationType("client");
    Xyd_goods_store_bill_add.table = table.init();
 
});

/**
 * 初始化表格的列
 */
Xyd_goods_store_bill_add.initColumn = function () {
    return [
        {field: 'state', checkbox: true},
        {title: 'ID', field: 'SHOP',visible: false,formatter:function(value,row,index){row.SHOP = index;return index+1;}, align: 'center', valign: 'middle'},
        {title: '产品ID', field: 'prd_id', visible: false, align: 'center', valign: 'middle'},
        {title: '生产品牌ID', field: 'prd_brand_id',visible: false, align: 'center', valign: 'middle', sortable: true},
        {title: '生产厂商ID', field: 'prd_vendor_id',visible: false, align: 'center', valign: 'middle', sortable: true},
        {title: '产品分类ID', field: 'prd_cls_id',visible: false, align: 'center', valign: 'middle', sortable: true},
        {title: '单位ID',  field: 'prd_unit_id',visible: false, align: 'center', valign: 'middle', sortable: true},
        {title: '产品标准编码',  field: 'prd_no', align: 'center', valign: 'middle', sortable: true},
        {title: '产品名称',  field: 'prd_nm', align: 'center', valign: 'middle', sortable: true},
        {title: '仓库数量', field: 'sum', align: 'center', valign: 'middle', sortable: true},
        {title: '产品型号',  field: 'prd_model', align: 'center', valign: 'middle', sortable: true},
        {title: '产品简称',  field: 'prd_nm_alias', align: 'center', valign: 'middle', sortable: true},
        {title: '产品描述',  field: 'prd_nm_dsc', align: 'center', valign: 'middle', sortable: true},
        {title: '产品图片',  field: 'prd_nm_img', align: 'center', valign: 'middle', sortable: true},
        {title: '产品售价',  field: 'prd_price', align: 'center', valign: 'middle', sortable: true},
        {title: '金额',  field:'tot',visible: false,  align: 'center', valign: 'middle',sortable: true,},
    ];
};

function numb(value, row, index) {
    if(value == undefined) return "0";
    else return value;
};
 
//确认按钮
$('#item_info_btn_add').click(function(){  
        var selectContent = $("#add_all").bootstrapTable('getAllSelections');
        parent.$('#detailTable').bootstrapTable("append", selectContent);
    var selects = $('#add_all').bootstrapTable('getSelections');

    parent.layer.closeAll()
    }); 






$('#item_info_btn_close').click(function(){  
        
        parent.layer.closeAll()
       

    });


$('#case_add').on('click', function(){
    layer.open({
        type: 2,
        title: '商品新增',
        area: ['70%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        shadeClose: true,
        content:Feng.ctxPath +  '/xgt_goods_store_bill_out/inStoreProductAdd'
    });
});

