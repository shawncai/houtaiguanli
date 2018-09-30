/**
 * 企业员工管理初始化
 */
var Xyd_goods_store_bill_seach= {
    id: "gonghuo",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};
$(function () {
    var defaultColunms = Xyd_goods_store_bill_seach.initColumn();
    var table = new BSTable("gonghuo", "/xgt_goods_prd_vendor/vendorList", defaultColunms);
    table.setPaginationType("client");
    Xyd_goods_store_bill_seach.table = table.init();
 
});

/**
 * 初始化表格的列
 */
Xyd_goods_store_bill_seach.initColumn = function () {
    return [
        {field: 'state', checkbox: true},
       	{title: '合作商ID', field: 'prd_vendor_id',  align: 'center', valign: 'middle',sortable: true},
       	{title: '合作商名称',  field:'prd_vendor_nm', align: 'center', valign: 'middle',sortable: true},
        {title: '合作商别名',  field:'prd_vendor_alia', align: 'center', valign: 'middle',sortable: true},
        {title: '编号',  field:'prd_vendor_no', align: 'center', valign: 'middle',sortable: true},
        {title: '上级目录',  field:'par_prd_vendor', align: 'center', valign: 'middle',sortable: true},
        {title: '联系人',  field:'prd_vendor_man', align: 'center', valign: 'middle',sortable: true},
        {title: '邮箱',  field:'man_email', align: 'center', valign: 'middle',sortable: true},
        {title: '手机号',  field:'man_phone', align: 'center', valign: 'middle',sortable: true},
        {title: '地址',  field:'man_address', align: 'center', valign: 'middle',sortable: true},
        {title: '备注',  field:'remarks', align: 'center', valign: 'middle',sortable: true},
       	{title: '合伙类别',  field: 'vendor_flg', align: 'center', valign: 'middle', sortable: true},
       	{title: '企业信息ID',  field: 'cpn_id', align: 'center', valign: 'middle', sortable: true},
       	{title: '分支机构ID',  field: 'cpn_branch_id', align: 'center', valign: 'middle', sortable: true},
        {title: '变更时间',  field: 'mdi_dt', align: 'center', valign: 'middle', sortable: true},
        {title: '创建时间', field: 'cre_dt', align: 'center', valign: 'middle', sortable: true},
        {title: '状态',  field: 'st_id', align: 'center', valign: 'middle', sortable: true},
        {title: '操作人',  field: 'oper_user', align: 'center', valign: 'middle', sortable: true},

    ];
};



//确认按钮
$('#item_info_btn_add').click(function(){  
        var selectContent = $("#gonghuo").bootstrapTable('getSelections')[0];
        parent.$("#condition").val(selectContent.prd_vendor_nm);
    parent.$("#condition_hidden").val(selectContent.prd_vendor_id);
    parent.layer.closeAll()
        $("#close_span").attr("style","display:block");

    }); 
//取消按钮
$('#item_info_btn_close').click(function(){  
        
        parent.layer.closeAll()
       

    }); 




//按钮供货商新增
var index = parent.layer.getFrameIndex(window.name);
$('#table_add').on('click', function(){
    layer.open({
       type: 2,
      title: '供货商新增',
        area: ['70%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        shadeClose: true,
      content:Feng.ctxPath +  '/xgt_goods_store_bill/inStoreVendorAdd'
    });
  });