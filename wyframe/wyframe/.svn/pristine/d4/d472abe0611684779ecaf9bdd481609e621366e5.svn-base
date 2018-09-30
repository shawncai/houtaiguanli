/**
 * 企业员工管理初始化
 */
var Xyd_goods_store_case_seach= {
    id: "case_seach",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};
$(function () {
    var defaultColunms = Xyd_goods_store_case_seach.initColumn();
    var table = new BSTable("case_seach", "/xyd_cpn_store/list", defaultColunms);
    table.setPaginationType("client");
    Xyd_goods_store_case_seach.table = table.init();
 
});

/**
 * 初始化表格的列
 */
Xyd_goods_store_case_seach.initColumn = function () {
    return [
        {field: 'state', checkbox: true},
       	{title: '仓库ID', field: 'cpn_store_id',  align: 'center', valign: 'middle',sortable: true},
       	{title: '仓库名称',  field:'cpn_store_nm', align: 'center', valign: 'middle',sortable: true},
       	{title: '仓库标准编码',  field: 'cpn_store_no', align: 'center', valign: 'middle', sortable: true},
       	{title: '联系人',  field: 'man_man', align: 'center', valign: 'middle', sortable: true},
       	{title: '邮箱',  field: 'man_email', align: 'center', valign: 'middle', sortable: true},
        {title: '电话',  field: 'man_phone', align: 'center', valign: 'middle', sortable: true},
        {title: '地址',  field: 'man_address', align: 'center', valign: 'middle', sortable: true},
        {title: '备注',  field: 'remarks', align: 'center', valign: 'middle', sortable: true},
        {title: '上级仓库', field: 'par_store_id', align: 'center', valign: 'middle', sortable: true},
        {title: '状态',  field: 'st_id', align: 'center', valign: 'middle', sortable: true},

    ];
};



//确认按钮
$('#item_info_btn_add').click(function(){  
        var selectContent = $("#case_seach").bootstrapTable('getSelections')[0];  
        parent.$("#condition1").val(selectContent.cpn_store_nm);
    parent.$("#condition1_hidden").val(selectContent.cpn_store_id);
        parent.layer.closeAll()
        $("#case_close_span").attr("style","display:block");

    }); 
//取消按钮
$('#item_info_btn_close').click(function(){  
        
        parent.layer.closeAll()
       

    }); 




//按钮仓库新增
var index = parent.layer.getFrameIndex(window.name);
$('#case_add').on('click', function(){
    layer.open({
       type: 2,
      title: '仓库新增',
        area: ['70%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        shadeClose: true,
      content:Feng.ctxPath +  'inStoreStoreAdd'
    });
  });