/**
 * 初始化栏目详情对话框
 */
var Xgt_wy_itemInfoDlg = {
    xgt_wy_itemInfoData : {}
};

/**
 * 初始化栏目详情对话框
 */
var Xgt_wy_itemIdDlg = {
    xgt_wy_itemIdData : {},
    xgtzTreeInstance : null
};

/**
 * 点击栏目ztree列表的选项时
 *
 * @param e
 * @param treeId
 * @param treeNode
 * @returns
 */
Xgt_wy_itemIdDlg.onClickitem = function(e, treeId, treeNode) {
    $("#itemPname").attr("value", Xgt_wy_itemIdDlg.xgtzTreeInstance.getSelectedVal());
    $("#par_item_id").attr("value", treeNode.id);
    Xgt_wy_itemIdDlg.itemPname = Xgt_wy_itemIdDlg.xgtzTreeInstance.getSelectedVal();
    Xgt_wy_itemIdDlg.par_item_id = treeNode.id;
}

$(function() {

    var itemztree = new $ZTree("itemareaTree", "/xgt_wy_item/tree");
    itemztree.bindOnClick(Xgt_wy_itemIdDlg.onClickitem);
    itemztree.init();
    Xgt_wy_itemIdDlg.xgtzTreeInstance = itemztree;
});

/**
 * 显示栏目选择的树
 *
 * @returns
 */
Xgt_wy_itemIdDlg.showItemSelectTree = function() {
    Feng.showInputTree("itemPname", "itemTreeDiv", 15, 34);
}

/**
 * 清除数据
 */
Xgt_wy_itemInfoDlg.clearData = function() {
    this.xgt_wy_itemInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xgt_wy_itemInfoDlg.set = function(key, val) {
    this.xgt_wy_itemInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xgt_wy_itemInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
Xgt_wy_itemInfoDlg.close = function() {
    parent.layer.close(window.parent.Xgt_wy_item.layerIndex);

}

/**
 * 收集数据
 */
Xgt_wy_itemInfoDlg.collectData = function() {
    this .set('item_id') .set('item_nm') .set('item_nm_alias') .set('item_dsc') .set('item_cls') .set('par_item_id') .set('seq_no') .set('st_id') .set('oper_user')

    ;
}

/**
 * 提交添加
 */
Xgt_wy_itemInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_wy_item/add", function(data){
        Feng.success("添加成功!");
        window.parent.Xgt_wy_item.table.refresh();
        Xgt_wy_itemInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xgt_wy_itemInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
Xgt_wy_itemInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();
    if ($("#itemPname").val()==""){
        return false;
    }
    if ($("#item_nm").val()==""){
        return false;
    } if ($("#item_nm_alias").val()==""){
        return false;
    }
    if ($("#oper_user").val()==""){
        return false;
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_wy_item/update", function(data){
        Feng.success("修改成功!");
        window.parent.Xgt_wy_item.table.refresh();
        Xgt_wy_itemInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xgt_wy_itemInfoData);
    ajax.start();
}


/**
 * 初始化xyd详情对话框
 */
var Xgt_wy_itemInfo = {
    Xgt_wy_itemInfoData : {}
};

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xgt_wy_itemInfo.set = function(key, val) {
    this.Xgt_wy_itemInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}
/**
 * 收集数据
 */
Xgt_wy_itemInfo.collectData = function() {
    this  .set('item_id') .set('item_nm') .set('item_nm_alias') .set('item_dsc') .set('item_cls') .set('par_item_id') .set('seq_no') .set('st_id') .set('oper_user')
    ;
}

/**
 * 提交添加
 */
Xgt_wy_itemInfo.add = function() {

    this.collectData();
    if ($("#itemPname").val()==""){
        return false;
    }
    if ($("#item_nm").val()==""){
        return false;
    } if ($("#item_nm_alias").val()==""){
        return false;
    }
    if ($("#oper_user").val()==""){
        return false;
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_wy_item/add", function(data){
        Feng.success("添加成功!");
        window.parent.Xgt_wy_item.table.refresh();
        Xgt_wy_itemInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.Xgt_wy_itemInfoData);
    ajax.start();
}



