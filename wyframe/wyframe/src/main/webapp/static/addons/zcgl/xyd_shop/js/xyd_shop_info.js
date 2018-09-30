/**
 * 初始化商品详情对话框
 */
var Xyd_shopInfoDlg = {
    xyd_shopInfoData : {},
    zTreeInstance : null
};

/**
 * 清除数据
 */
Xyd_shopInfoDlg.clearData = function() {
    this.xyd_shopInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xyd_shopInfoDlg.set = function(key, val) {
    this.xyd_shopInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xyd_shopInfoDlg.get = function(key) {
    return $("#" + key).val();
}
$('#shop_no_num').on('ifChecked', function(event){ //ifCreated 事件应该在插件初始化之前绑定
    $('#shop_no_num').val('1');
});

$('#shop_no_num').on('ifUnchecked', function(event){ //ifCreated 事件应该在插件初始化之前绑定
    $('#shop_no_num').val('0');
});


if($('#shop_no_num').val()==1){
    $('#shop_no_num').iCheck('check');
}
$('#checkbox').on('ifChecked', function(event){ //ifCreated 事件应该在插件初始化之前绑定
    $('#checkbox').val('1');
});

$('#checkbox').on('ifUnchecked', function(event){ //ifCreated 事件应该在插件初始化之前绑定
    $('#checkbox').val('0');
});


if($('#checkbox').val()==1){
    $('#checkbox').iCheck('check');
}
/**
 * 关闭此对话框
 */
Xyd_shopInfoDlg.close = function() {
   parent.layer.closeAll()
}

/**
 * 收集数据
 */
Xyd_shopInfoDlg.collectData = function() {
    this.set('shop_id').set('shop_no').set('shop_nm').set('shop_weigth').set('shop_spec_id').set('shop_no_num').set('shop_unit').set('checkbox').set('remark').set('par_shop_id').set('xyd_st_id').set('xyd_user_id');
}

/**
 * 提交添加
 */
Xyd_shopInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xyd_shop/add", function(DATA){
        Feng.success("添加成功!");
         window.parent.layui.table.reload('Xyd_shopTable', {url:Feng.ctxPath + "/xyd_shop/editList"});
        Xyd_shopInfoDlg.close();
    },function(DATA){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xyd_shopInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
Xyd_shopInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xyd_shop/update", function(DATA){
        Feng.success("修改成功!");
        window.parent.layui.table.reload('Xyd_shopTable', {url:Feng.ctxPath + "/xyd_shop/editList"});
        Xyd_shopInfoDlg.close();
    },function(DATA){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xyd_shopInfoData);
    ajax.start();
}

 $(document).ready(function () {
        $(".i-checks").iCheck({checkboxClass: "icheckbox_square-green", radioClass: "iradio_square-green",})
    });
    $('#filePicker').click(function () {
        $('#duan').remove();
    });


