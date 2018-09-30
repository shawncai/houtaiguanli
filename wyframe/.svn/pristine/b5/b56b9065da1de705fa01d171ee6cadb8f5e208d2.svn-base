/**
 * 初始化站点栏目详情对话框
 */
var Xgt_wy_topicInfoDlg = {
	xgt_wy_topicInfoData : {}
};

/**
 * 清除数据
 */
Xgt_wy_topicInfoDlg.clearData = function() {
	this.xgt_wy_topicInfoData = {};
}

/**
 * 设置对话框中的数据
 * 
 * @param key
 *            数据的名称
 * @param val
 *            数据的具体值
 */
Xgt_wy_topicInfoDlg.set = function(key, val) {
	this.xgt_wy_topicInfoData[key] = (typeof value == "undefined") ? $(
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
Xgt_wy_topicInfoDlg.get = function(key) {
	return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
Xgt_wy_topicInfoDlg.close = function() {
	parent.layer.close(window.parent.Xgt_wy_topic.layerIndex);
}

/**
 * 收集数据
 */
Xgt_wy_topicInfoDlg.collectData = function() {
	this.set('topic_id').set('image_file_id').set('item_id').set('cpn_id').set(
			'top_pro_nm').set('top_pro_nm_alias').set('top_pro_nr').set(
			'par_item_id').set('st_id').set('oper_user');
}

/**
 * 提交添加
 */
Xgt_wy_topicInfoDlg.addSubmit = function() {

	this.clearData();
	this.collectData();

	// 提交信息
	var ajax = new $ax(Feng.ctxPath + "/xgt_wy_topic/add", function(data) {
		Feng.success("添加成功!");
		window.parent.Xgt_wy_topic.table.refresh();
		Xgt_wy_topicInfoDlg.close();
	}, function(data) {
		Feng.error("添加失败!" + data.responseJSON.message + "!");
	});
	ajax.set(this.xgt_wy_topicInfoData);
	ajax.start();
}

/**
 * 提交修改
 */
Xgt_wy_topicInfoDlg.editSubmit = function() {

	this.clearData();
	this.collectData();

	// 提交信息
	var ajax = new $ax(Feng.ctxPath + "/xgt_wy_topic/update", function(data) {
		Feng.success("修改成功!");
		window.parent.Xgt_wy_topic.table.refresh();
		Xgt_wy_topicInfoDlg.close();
	}, function(data) {
		Feng.error("修改失败!" + data.responseJSON.message + "!");
	});
	ajax.set(this.xgt_wy_topicInfoData);
	ajax.start();
}

/**
 * 初始化xyd详情对话框
 */
var Xgt_wy_topicInfo = {
	Xgt_wy_topicInfoData : {}
};

/**
 * 设置对话框中的数据
 * 
 * @param key
 *            数据的名称
 * @param val
 *            数据的具体值
 */
Xgt_wy_topicInfo.set = function(key, val) {
	this.Xgt_wy_topicInfoData[key] = (typeof value == "undefined") ? $(
			"#" + key).val() : value;
	return this;
}
/**
 * 收集数据
 */
Xgt_wy_topicInfo.collectData = function() {
	this.set('topic_id').set('image_file_id').set('item_id').set('cpn_id').set(
			'top_pro_nm').set('top_pro_nm_alias').set('top_pro_nr').set(
			'par_item_id').set('st_id').set('oper_user');
}

/**
 * 提交添加
 */
Xgt_wy_topicInfo.add = function() {

	var ajaxOrder = new $ax(Feng.ctxPath + "/xgt_wy_item/orderItem", function(
			data2) {
		$("#param").val(JSON.stringify(data2));
	}, function(data2) {
		Feng.error("查询失败!" + data.responseJSON.message + "!");
	});
	ajaxOrder.start();
	// 提交信息
	var ajax = new $ax(Feng.ctxPath + "/xgt_wy_topic/add", function(data) {
		// 初始化
		var ajaxInit = new $ax(Feng.ctxPath + "/xgt_wy_topic/init", function(
				data) {
			for ( var i in data) {
				if (data[i].item_cls === 2) {
					$("#" + data[i].top_pro_nm_alias + "Img").attr("src",
							"/kaptcha/" + data[i].img_url);
					$("#" + data[i].top_pro_nm_alias)
							.val(data[i].image_file_id);
				} else if (data[i].item_cls === 1) {
					$("#" + data[i].top_pro_nm_alias).val(data[i].top_pro_nr);
				}
			}
		}, function(data) {
			Feng.error("初始化失败!" + data.responseJSON.message + "!");
		});
		// ajaxInit.set();
		ajaxInit.start();

		Feng.success("提交成功!");
	}, function(data) {
		Feng.error("提交失败!" + data.responseJSON.message + "!");
	});
	var dataAll = JSON.parse($("#param").val());
	// var dataStr ="[{\"item_id\":\"00\",\"value\":\"00\"}";
	for ( var item in dataAll) {
		// dataStr =
		// dataStr+",{\"item_id\":\""+dataAll[item].item_id+"\",\"value\":\""+$("#"+dataAll[item].item_nm_alias).val()+"\"}";
		if (dataAll[item].item_cls === 1) {
			dataAll[item].top_pro_nr = $("#" + dataAll[item].item_nm_alias)
					.val();
		} else if (dataAll[item].item_cls === 2) {
			dataAll[item].image_file_id = $("#" + dataAll[item].item_nm_alias)
					.val();
		}
	}
	// dataStr=dataStr+"]";
	ajax.set("dataStr", JSON.stringify(dataAll));
	ajax.start();
}

$(function() {
	var ajax = new $ax(
			Feng.ctxPath + "/xgt_wy_item/orderItem",
			function(data) {
				for ( var item in data) {
					// alert(JSON.stringify(data[item]));
					if (data[item].item_cls === 1) {
						$("#t_topic")
								.append(
										"<tr>"
												+ "<td class='td_title' style='text-align:center '>"
												+ data[item].item_nm
												+ "</td> "
												+ "<td><input type='text' class='form-control' id='"
												+ data[item].item_nm_alias
												+ "' style='width:500px' placeholder='"
												+ data[item].item_dsc
												+ "' /></td> " + "</tr>");
					} else if (data[item].item_cls === 2) {
						$("#t_topic")
								.append(
										"<tr> "
												+ "<td class='td_title' style='text-align:center '>"
												+ data[item].item_nm
												+ "</td> "
												+ "<td><div id='"
												+ data[item].item_nm_alias
												+ "PreId' >"
												+ " <div><img id='"
												+ data[item].item_nm_alias
												+ "Img' width='200px' height='200px' src='/static/img/webuploader.png' /></div></div><div class='head-scu-btn upload-btn' id='"
												+ data[item].item_nm_alias
												+ "BtnId' ><i class='fa fa-upload'></i>&nbsp;上传</div></tr><input type='hidden' id='"
												+ data[item].item_nm_alias
												+ "' value=''/>");
						var cardUrl1 = new $WebUpload(data[item].item_nm_alias);
						cardUrl1.init();
					} else if (data[item].item_cls == "3") {
						$("#t_topic")
								.append(
										"<tr> "
												+ "<td class='td_title' style='text-align:center '>"
												+ data[item].item_nm + "</td> "
												+ "<td><input id='"
												+ data[item].item_nm_alias
												+ "' type='file' id='"
												+ data[item].item_nm_alias
												+ "' placeholder='"
												+ data[item].item_dsc
												+ "' /></td> " + "</tr>");
					}
				}
			}, function(data) {
				Feng.error("查询失败!" + data.responseJSON.message + "!");
			});
	ajax.start();
	// value='${map."+data[item].item_nm_alias+"}'
	// 初始化
	var ajaxInit = new $ax(Feng.ctxPath + "/xgt_wy_topic/init", function(data) {
		for ( var i in data) {
			if (data[i].item_cls === 2) {
				$("#" + data[i].top_pro_nm_alias + "Img").attr("src",
						"/kaptcha/" + data[i].img_url);
				$("#" + data[i].top_pro_nm_alias).val(data[i].image_file_id);
			} else if (data[i].item_cls === 1) {
				$("#" + data[i].top_pro_nm_alias).val(data[i].top_pro_nr);
			}
		}
	}, function(data) {
		Feng.error("初始化失败!" + data.responseJSON.message + "!");
	});
	// ajaxInit.set();
	ajaxInit.start();

});
