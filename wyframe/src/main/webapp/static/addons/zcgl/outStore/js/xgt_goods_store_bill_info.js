/**
 * 初始化入库单详情对话框
 */
var Xgt_goods_store_billInfoDlg = {
	xgt_goods_store_billInfoData : {}
};

/**
 * 清除数据
 */
Xgt_goods_store_billInfoDlg.clearData = function() {
	this.xgt_goods_store_billInfoData = {};
}

/**
 * 设置对话框中的数据
 * 
 * @param key
 *            数据的名称
 * @param val
 *            数据的具体值
 */
Xgt_goods_store_billInfoDlg.set = function(key, val) {
	this.xgt_goods_store_billInfoData[key] = (typeof value == "undefined") ? $(
			"#" + key).val() : value;
	return this;
}

/**
 * 设置对话框中的数据
 * 
 * @param key
 *            数据的名称
 * @param val
 *            数据的具体值
 */
Xgt_goods_store_billInfoDlg.get = function(key) {
	return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
Xgt_goods_store_billInfoDlg.close = function() {
	parent.layer.close(window.parent.Xgt_goods_store_bill.layerIndex);
}

/**
 * 收集数据
 */
Xgt_goods_store_billInfoDlg.collectData = function() {
	this.set('out_bill_type').set('store').set('bill_in_id').set('out_bill_type').set('bill_no').set('bill_dsc').set('cpn_store_id').set('cre_dt').set('st_id').set('oper_user');
}

/**
 * 提交添加
 */
Xgt_goods_store_billInfoDlg.addSubmit = function() {

	this.clearData();
	this.collectData();

	// 提交信息
	var ajax = new $ax(Feng.ctxPath + "/xgt_goods_store_bill/add", function(
			data) {
		Feng.success("添加成功!");
		window.parent.Xgt_goods_store_bill.table.refresh();
		Xgt_goods_store_billInfoDlg.close();
	}, function(data) {
		Feng.error("添加失败!" + data.responseJSON.message + "!");
	});
	ajax.set("str", JSON.stringify(this.xgt_goods_store_billInfoData));
	ajax.start();
}

/**
 * 提交修改
 */
Xgt_goods_store_billInfoDlg.editSubmit = function() {

	this.clearData();
	this.collectData();

	// 提交信息
	var ajax = new $ax(Feng.ctxPath + "/xgt_goods_store_bill/update", function(
			data) {
		Feng.success("修改成功!");
		window.parent.Xgt_goods_store_bill.table.refresh();
		Xgt_goods_store_billInfoDlg.close();
	}, function(data) {
		Feng.error("修改失败!" + data.responseJSON.message + "!");
	});
	ajax.set(this.xgt_goods_store_billInfoData);
	var selected = $('#' + Xgt_goods_store_billParam.id).bootstrapTable(
			'getSelections');
	var str = "";
	for (var i = 0; i < selected.length; i++) {
		str = str + selected[i].prd_id + ".";
	}
	ajax.set("str", str);
	ajax.start();
}

Xgt_goods_store_billInfoDlg.next = function(){
	var ajax = new $ax(Feng.ctxPath + "/xgt_goods_store_bill/", function(
			data) {
		Feng.success("审核成功!");
		window.parent.Xgt_goods_store_bill.table.refresh();
	}, function(data) {
		Feng.error("修改失败!" + data.responseJSON.message + "!");
	});
	ajax.set("id",$("#bill_out_id").val());
	ajax.set("state", $("#st_id").val());
	ajax.start();
}
/**
 * 提交审核
 */
Xgt_goods_store_billInfoDlg.reviewSubmit = function() {

	this.clearData();
	this.collectData();
    var allContent = $("#detailTable").bootstrapTable('getData');
	// 提交信息
	var ajax = new $ax(Feng.ctxPath + "/xgt_goods_store_bill_out/review/", function(
			data) {
		Feng.success("审核成功!");
		window.parent.Xgt_goods_store_bill.table.refresh();
	}, function(data) {
		Feng.error("修改失败!" + data.responseJSON.message + "!");
	});
	ajax.set("idata",JSON.stringify(this.xgt_goods_store_billInfoData));
	ajax.set("tdata",JSON.stringify(allContent));
    ajax.set("id",id);
	ajax.start();
    parent.layer.closeAll();
}
/**
 * 入库单管理初始化
 */
var Xgt_goods_store_billParam = {
	id : "paramTable", // 表格id
	seItem : null, // 选中的条目
	table : null,
	layerIndex : -1
};

Xgt_goods_store_billInfoDlg.next = function(){
	Xgt_goods_store_billInfoDlg.refresh();
}

/**
 * 点击添加订单
 */
Xgt_goods_store_billParam.appendXgt_goods_store_bill = function() {
	var index = layer.open({
		type : 2,
		title : '添加参数',
		area : [ '100%', '100%' ], // 宽高
		fix : false, // 不固定
		maxmin : true,
		content : Feng.ctxPath
				+ '/xgt_goods_store_bill/xgt_goods_store_bill_add_param'
	});
	this.layerIndex = index;
};

/**
 * 初始化表格的列
 */
Xgt_goods_store_billParam.initColumn = function() {
	return [ {
		field : 'selectItem',
		checkbox : true
	}, {
		title : '产品ID',
		field : 'prd_id',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '产品名称',
		field : 'prd_nm',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '产品数量',
		field : 'in_num',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '产品分类ID',
		field : 'prd_cls_id',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '生产品牌ID',
		field : 'prd_brand_id',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '生产厂商ID',
		field : 'prd_vendor_id',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '单位ID',
		field : 'prd_unit_id',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '产品标准编码',
		field : 'prd_no',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '产品型号',
		field : 'prd_model',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '产品价格',
		field : 'prd_price',
		align : 'center',
		valign : 'middle',
		sortable : true
	} ,{
		title : '操作',
		field : 'prd_oper',
		align : 'center',
		valign : 'middle',
		sortable : true
	}];
};

/**
 * 参数表页面table
 */
var Xgt_goods_store_bill_params = {
	id : "paramsTable", // 表格id
	seItem : null, // 选中的条目
	table : null,
	layerIndex : -1
};

/**
 * 初始化表格的列
 */
Xgt_goods_store_bill_params.initColumn = function() {
	return [ {
		field : 'selectItem',
		checkbox : true
	}, {
		title : '产品ID',
		field : 'prd_id',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '生产品牌ID',
		field : 'prd_brand_id',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '生产厂商ID',
		field : 'prd_vendor_id',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '产品分类ID',
		field : 'prd_cls_id',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '单位ID',
		field : 'prd_unit_id',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '产品标准编码',
		field : 'prd_no',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '产品名称',
		field : 'prd_nm',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '产品型号',
		field : 'prd_model',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '产品简称',
		field : 'prd_nm_alias',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '产品描述',
		field : 'prd_nm_dsc',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '产品图片',
		field : 'prd_nm_img',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '产品上市日期',
		field : 'prd_crt_dt',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '产品售价',
		field : 'prd_price',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '企业信息ID',
		field : 'cpn_id',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '分支机构ID',
		field : 'cpn_branch_id',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '变更时间',
		field : 'mdi_dt',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '创建时间',
		field : 'cre_dt',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '状态',
		field : 'st_id',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '操作人',
		field : 'oper_user',
		align : 'center',
		valign : 'middle',
		sortable : true
	} ];

};

function selects() {
	var selected = $('#' + Xgt_goods_store_bill_params.id).bootstrapTable(
			'getSelections');
	var str = "";
	for (var i = 0; i < selected.length; i++) {
		str = str + selected[i].prd_id + ".";
	}
	var ajax = new $ax(
			Feng.ctxPath + "/xgt_goods_store_bill/param/" + str,
			function(data) {
				window.parent.Xgt_goods_store_billParam.table.refresh();
				parent.layer
						.close(window.parent.Xgt_goods_store_billParam.layerIndex);
			},
			function(data) {
				parent.layer
						.close(window.parent.Xgt_goods_store_billParam.layerIndex);
			});
	ajax.start();
}
function remove(id) {

	var operation = function() {
		var ajax = new $ax(Feng.ctxPath + "/xgt_goods_store_bill/deleteParam/"+id
				, function(data) {
			Feng.success("删除成功!");
			Xgt_goods_store_billParam.table.refresh();
		}, function(data) {
			Feng.error("删除失败!" + data.responseJSON.message + "!");
		});
		ajax.start();
	}
	Feng.confirm("是否刪除?", operation);
}

/**
 * 初始化xyd详情对话框
 */
var Xgt_goods_store_billInfo = {
	Xgt_goods_store_billInfoData : {}
};

/**
 * 设置对话框中的数据
 * 
 * @param key
 *            数据的名称
 * @param val
 *            数据的具体值
 */
Xgt_goods_store_billInfo.set = function(key, val) {
	this.Xgt_goods_store_billInfoData[key] = (typeof value == "undefined") ? $(
			"#" + key).val() : value;
	return this;
}
/**
 * 收集数据
 */
Xgt_goods_store_billInfo.collectData = function() {
	this.set('store').set('bill_no').set('bill_dsc');
}

//产品添加
Xgt_goods_store_billParam.addPro = function(){
	var proId = $("#proNm").val();
	var proNum = $("#proNum").val();
	var prd_price = $("#prd_price").val();
	var ajax = new $ax(Feng.ctxPath + "/xgt_goods_store_bill/addPro", function(
			data) {
		Feng.success("添加成功!");
		Xgt_goods_store_billParam.table.refresh();
	}, function(data) {
		Feng.error("添加失败!" + data.responseJSON.message + "!");
	});
	ajax.set("proId", proId);
	ajax.set("proNum", proNum);
	ajax.set("prd_price", prd_price);
	ajax.start();
}
/**
 * 提交添加
 */
Xgt_goods_store_billInfo.add = function() {
	this.collectData();
	var iData = JSON.stringify(this.Xgt_goods_store_billInfoData);
	var selected = $('#' + Xgt_goods_store_billParam.id).bootstrapTable(
			'getSelections');
	var tData = JSON.stringify(selected);
	// 提交信息
	var ajax = new $ax(Feng.ctxPath + "/xgt_goods_store_bill/add", function(
			data) {
		Feng.success("添加成功!");
		window.parent.Xgt_goods_store_bill.table.refresh();
		Xgt_goods_store_billInfoDlg.close();
	}, function(data) {
		Feng.error("添加失败!" + data.responseJSON.message + "!");
	});
	ajax.set("iData", iData);
	ajax.set("tData", tData);
	ajax.start();
}

$(function() {
	var defaultColunms = Xgt_goods_store_billParam.initColumn();
	var table = new BSTable(Xgt_goods_store_billParam.id,
			"/xgt_goods_store_bill/paramList", defaultColunms);
	table.setPaginationType("client");
	Xgt_goods_store_billParam.table = table.init();

	var defaultColunmss = Xgt_goods_store_bill_params.initColumn();
	var tables = new BSTable(Xgt_goods_store_bill_params.id,
			"/xgt_goods_store_bill/paramsList", defaultColunmss);
	tables.setPaginationType("client");
	Xgt_goods_store_bill_params.table = tables.init();
});

// 查询分类
$(function() {
	var ajax = new $ax(Feng.ctxPath + "/xgt_goods_prd_cls/list",
			function(data) {
				for ( var item in data) {
					$("#cls").append(
							"\<option value='" + data[item].prd_cls_id + "'\>"
									+ data[item].prd_cls_nm + "\</option\>");
				}
			}, function(data) {
				Feng.error("添加失败!" + data.responseJSON.message + "!");
			});
	ajax.start();

	// 分类选择
	$("#cls").change(function() {
		var clsId = $("#vendor").val();
	
		var ajax = new $ax(Feng.ctxPath + "/xgt_goods_store_bill/changeCls"+clsId, function(
				data) {
		}, function(data) {
		});
		ajax.start();
	});
});

// 查询厂商
$(function() {
	var ajax = new $ax(Feng.ctxPath + "/xgt_goods_prd_vendor/list", function(
			data) {
		for ( var item in data) {
			$("#vendor").append(
					"\<option value='" + data[item].prd_vendor_id + "'\>"
							+ data[item].prd_vendor_nm + "\</option\>");
		}
	}, function(data) {
		Feng.error("添加失败!" + data.responseJSON.message + "!");
	});
	ajax.start();
	// 厂商选择
	$("#vendor").change(function() {
		var vendorId = $("#vendor").val();
		var ajax = new $ax(Feng.ctxPath + "/xgt_goods_store_bill/changeVendor"+vendorId, function(
				data) {
		}, function(data) {
		});
		ajax.start();
	});	
	
});

//查询仓库
$(function() {
	var ajax = new $ax(Feng.ctxPath + "/xyd_cpn_store/list", function(
			data) {
		for ( var item in data) {
			$("#store").append(
					"\<option value='" + data[item].cpn_store_id + "'\>"
							+ data[item].cpn_store_nm + "\</option\>");
		}
	}, function(data) {
		Feng.error("添加失败!" + data.responseJSON.message + "!");
	});
	ajax.start();
	// 厂商选择
	$("#store").change(function() {
		var storeId = $("#store").val();
		
//		var ajax = new $ax(Feng.ctxPath + "/xgt_goods_store_bill/changeStore"+storeId, function(
//				data) {
//		}, function(data) {
//		});
//		ajax.start();
	});	
	
});

$(function(){
	var ajax = new $ax(Feng.ctxPath + "/xgt_goods_product/list", function(data) {
		for ( var item in data) {
			$("#proNm").append(
					"\<option value='" + data[item].prd_id + "'\>"
							+ data[item].prd_nm + "\</option\>");
		}
	}, function(data) {
		Feng.error("添加失败!" + data.responseJSON.message + "!");
	});
	ajax.start();

});
