/**
 * 企业员工管理初始化
 */
var Xyd_goods_store_staff_seach= {
    id: "staff_seach",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};
$(function () {
    var defaultColunms = Xyd_goods_store_staff_seach.initColumn();
    var table = new BSTable("staff_seach", "/mgr/list", defaultColunms);
    table.setPaginationType("client");
    Xyd_goods_store_staff_seach.table = table.init();
 
});

/**
 * 初始化表格的列
 */
Xyd_goods_store_staff_seach.initColumn = function () {
    return [
        {field: 'state', checkbox: true},
       	{title: 'ID', field: 'id',  align: 'center', valign: 'middle',sortable: true},
       	{title: '账号',  field:'account', align: 'center', valign: 'middle',sortable: true},
       	{title: '姓名',  field: 'name', align: 'center', valign: 'middle', sortable: true},
       	{title: '生日',  field: 'birthday', align: 'center', valign: 'middle', sortable: true},
       	{title: '性别',  field: 'sex', align: 'center', valign: 'middle', sortable: true},
        {title: '邮箱',  field: 'email', align: 'center', valign: 'middle', sortable: true},
        {title: '电话',  field: 'phone', align: 'center', valign: 'middle', sortable: true},
        {title: '角色名', field: 'roleid', align: 'center', valign: 'middle', sortable: true},


    ];
};



//确认按钮
$('#item_info_btn_add').click(function(){  
        var selectContent = $("#staff_seach").bootstrapTable('getSelections')[0];  
        parent.$("#condition2").val(selectContent.name);
    parent.$("#condition2_hidden").val(selectContent.id);
        parent.layer.closeAll()
        $("#staff_close_span").attr("style","display:block");

    }); 
//取消按钮
$('#item_info_btn_close').click(function(){  
        
        parent.layer.closeAll()
       

    }); 




//按钮经手人新增
var index = parent.layer.getFrameIndex(window.name);
$('#staff_add').on('click', function(){
    layer.open({
       type: 2,
      title: '经手人新增',
        area: ['70%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        shadeClose: true,
      content: 'inStoreUserAdd'
    });
  });
