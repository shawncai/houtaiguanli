/**
 * 企业管理初始化
 */
var Xyd_cpn = {
    id: "Xyd_cpnTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Xyd_cpn.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
       	{title: '企业', field: 'cpn_id', visible: false, align: 'center', valign: 'middle'},
       	{title: '企业名称', field: 'cpn_nm', align: 'center', valign: 'middle', sortable: true},
       	{title: '企业注册号', field: 'cpn_code', align: 'center', valign: 'middle', sortable: true},
        {title: '企业分类', field: 'cpn_cata_id', align: 'center', valign: 'middle', sortable: true},        
        {title: '企业法人', field: 'cpn_main_nm', align: 'center', valign: 'middle', sortable: true},
        {title: '企业法人联系方式', field: 'cpn_main_phone', align: 'center', valign: 'middle', sortable: true},
        {title: '企业法人邮箱', field: 'cpn_main_mail', align: 'center', valign: 'middle', sortable: true},
        {title: '办公地址', field: 'work_address', align: 'center', valign: 'middle', sortable: true},
        {title: '注册地址', field: 'code_address', align: 'center', valign: 'middle', sortable: true},
        {title: '申请人', field: 'cpn_acc_nm', align: 'center', valign: 'middle', sortable: true},
        {title: '申请人手机号', field: 'cpn_acc_phone', align: 'center', valign: 'middle', sortable: true},
        {title: '申请人邮箱', field: 'cpn_acc_mail', align: 'center', valign: 'middle', sortable: true},
        {title: '发展人', field: 'sale_user_id', align: 'center', valign: 'middle', sortable: true},
        {title: '企业状态', field: 'cpn_st', align: 'center', valign: 'middle', sortable: true},
        {title: '企业审批状态', field: 'cp_sp_st', align: 'center', valign: 'middle', sortable: true},
        {title: '审批意见', field: 'approval_opinion', align: 'center', valign: 'middle', sortable: true}
    ];
};

/**
 * 检查是否选中
 */
Xyd_cpn.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Xyd_cpn.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加企业
 */
Xyd_cpn.openAddXyd_cpn = function () {
    var index = layer.open({
        type: 2,
        title: '添加企业',
        area: ['100%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/xyd_cpn/xyd_cpn_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看企业详情_修改
 */
Xyd_cpn.openXyd_cpnDetail_update = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '企业详情_修改',
            area: ['100%', '100%'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/xyd_cpn/xyd_cpn_update/' + Xyd_cpn.seItem.cpn_id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除企业
 */
Xyd_cpn.delete = function () {
    if (this.check()) {
     var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/xyd_cpn/delete", function (data) {
            Feng.success("删除成功!");
            Xyd_cpn.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("xyd_cpnId",Xyd_cpn.seItem.cpn_id);
        ajax.start();
    }
    	 Feng.confirm("是否刪除该企业?", operation);
    }
};

/**
 * 查询企业列表
 */
Xyd_cpn.search = function () {
    var queryData = {};
    queryData['cpn_nm'] = $("#cpn_nm").val();
    queryData['cpn_cata_id'] = Cpn_cata_paridDlg.cpn_cata_id;
    queryData['cpn_st'] = $("#cpn_st").val();
    console.log($("#cpn_st").val());
    Xyd_cpn.table.refresh({query: queryData});
};

$(function () {
	var defaultColunms = Xyd_cpn.initColumn();
    var table = new BSTable(Xyd_cpn.id, "/xyd_cpnReviewe/list" , defaultColunms);
    table.setPaginationType("client");
    Xyd_cpn.table = table.init();
});

function loadCpnSt() {
	var ajax = new $ax(Feng.ctxPath + "/dict/cpnSt", function(data) {
		
		$("#cpn_st").append(
				"<option value=''>请选择</option>");
		for(var i = 0; i < data.length; i++) {	
				$("#cpn_st").append(
						"<option value=" + data[i].num + ">"
						+ data[i].name + "</option>");
		}
	}, function(data) {
		Feng.error("查询失败！" + data.responseJSON.message + "!");
	});
	ajax.start();
}

$(function() {
	loadCpnSt();
})

/**
 * 初始化入驻企业详情对话框
 */
var Cpn_cata_paridDlg = {
	Cpn_cata_paridData : {},
	cpnzTreeInstance : null
};

/**
 * 点击公司ztree列表的选项时
 *
 * @param e
 * @param treeId
 * @param treeNode
 * @returns
 */
Cpn_cata_paridDlg.onClickCpn = function(e, treeId, treeNode) {
    $("#cpnPname").attr("value", Cpn_cata_paridDlg.cpnzTreeInstance.getSelectedVal());
    $("#cpn_cata_id").attr("value", treeNode.id);
    Cpn_cata_paridDlg.cpnPname = Cpn_cata_paridDlg.cpnzTreeInstance.getSelectedVal();
    Cpn_cata_paridDlg.cpn_cata_id = treeNode.id;
    
    Xyd_cpn.search();
}

$(function() {
    var cpnztree = new $ZTree("cpnareaTree", "/xyd_cpn_cata/tree");
    cpnztree.bindOnClick(Cpn_cata_paridDlg.onClickCpn);
    cpnztree.init();
    Cpn_cata_paridDlg.cpnzTreeInstance = cpnztree;
    
});

/**
 * 显示公司选择的树
 *
 * @returns
 */
Cpn_cata_paridDlg.showCpnSelectTree = function() {
	Feng.showInputTree("cpnPname", "cpnTreeDiv", 15, 34);
}

/**
 * 导出企业
 */
Xyd_cpn.export = function () {
       window.location.href=Feng.ctxPath + "/xyd_cpn/export";
};

/**
 * 打开查看企业详情
 */
Xyd_cpn.openXyd_cpnDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '企业详情',
            area: ['100%', '100%'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/xyd_cpnReviewe/xyd_cpn_detail/' + Xyd_cpn.seItem.cpn_id
        });
        this.layerIndex = index;
    }
};

/**
 * 收集数据
 */
Xyd_cpn.collectData = function() {
    this .set('cpn_id') .set('cpn_cata_id') .set('approval_opinion') .set('cpn_code') .set('cpn_nm') .set('cpn_main_nm') .set('cpn_main_phone') .set('cpn_main_mail') .set('work_area_id') .set('work_address') .set('code_area_id') .set('code_address') .set('cpn_acc_nm') .set('cpn_acc_phone') .set('cpn_acc_mail') .set('cpn_acc_card_no') .set('cpn_acc_card_url1') .set('cpn_acc_card_url2') .set('cpn_code_url') .set('cpn_st') .set('cp_sp_st') .set('sp_user_id') .set('sale_user_id');
}

/**
 * 添加企业
 */
Xyd_cpn.add = function () {
  	alert(this.collectData());
     var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/xyd_cpn/add", function (data) {
            Feng.success("添加成功!");
            Xyd_cpn.table.refresh();
        }, function (data) {
            Feng.error("添加失败!" + data.responseJSON.message + "!");
        });
        ajax.start();
    }
    	 Feng.confirm("是否添加该企业?", operation);
};
