/**
 * 初始化商品详情对话框
 */
var Bs_shopInfoDlg = {
    bs_shopInfoData : {},
    zTreeInstance : null
};

/**
 * 清除数据
 */
Bs_shopInfoDlg.clearData = function() {
    this.bs_shopInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Bs_shopInfoDlg.set = function(key, val) {
    this.bs_shopInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Bs_shopInfoDlg.get = function(key) {
    return $("#" + key).val();
}
/**
 * 关闭此对话框
 */
Bs_shopInfoDlg.close = function() {
   parent.layer.closeAll()
}

/**
 * 收集数据
 */
Bs_shopInfoDlg.collectData = function() {
    this.set('shop_id').set('shop_no').set('shop_nm').set('shop_weigth').set('shop_spec').set('shop_no_num').set('shop_unit').set('xyd_st_id').set('xyd_cre_dt').set('xyd_up_dt').set('xyd_user_id');
}

/**
 * 提交添加
 */
Bs_shopInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();
    if ($("#shop_no").val()==""){
        return false;
    }
    if ($("#shop_nm").val()==""){
        return false;
    }
    if ($("#shop_weigth").val()==""){
        return false;
    }
    if ($("#shop_spec").val()==""){
        return false;
    }
    if ($("#shop_no_num").val()==""){
        return false;
    }
    if ($("#shop_unit").val()==""){
        return false;
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/bs_shop/add", function(DATA){
        Feng.success("添加成功!");

                var ajax1 = new $ax(Feng.ctxPath + "/bs_shop/list", function(data){
                    tableData=data
                });
                 var demoReload = parent.$('#condition').val();
                ajax1.set('condition',demoReload);
                            ajax1.set('xyd_st_id',parent.$('#xyd_st_id').val());
                    ajax1.start();
         window.parent.layui.table.reload('Bs_shopTable', {data:tableData});
        Bs_shopInfoDlg.close();
    },function(DATA){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.bs_shopInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
Bs_shopInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();
    if ($("#shop_no").val()==""){
        return false;
    }
    if ($("#shop_nm").val()==""){
        return false;
    }
    if ($("#shop_weigth").val()==""){
        return false;
    }
    if ($("#shop_spec").val()==""){
        return false;
    }
    if ($("#shop_no_num").val()==""){
        return false;
    }
    if ($("#shop_unit").val()==""){
        return false;
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/bs_shop/update", function(DATA){
        Feng.success("修改成功!"); var ajax1 = new $ax(Feng.ctxPath + "/bs_shop/list", function(data){
          tableData=data
      });
       var demoReload = parent.$('#condition').val();
      ajax1.set('condition',demoReload);
      ajax1.set('xyd_st_id',parent.$('#xyd_st_id').val());
          ajax1.start();
window.parent.layui.table.reload('Bs_shopTable', {data:tableData});
        Bs_shopInfoDlg.close();
    },function(DATA){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.bs_shopInfoData);
    ajax.start();
}

 $(document).ready(function () {
        $(".i-checks").iCheck({checkboxClass: "icheckbox_square-green", radioClass: "iradio_square-green",})
    });
    $('#filePicker').click(function () {
        $('#duan').remove();
    });

/**校验开始**/
    function validate() {
        var e = "<i class='fa fa-times-circle'></i> ";
        $("#signupForm").validate({
            rules: {
             shop_id: {
                    required: !0,
                },
             shop_no: {
                    required: !0,
                },
             shop_nm: {
                    required: !0,
                },
             shop_weigth: {
                    required: !0,
                },
             shop_spec: {
                    required: !0,
                },
             shop_no_num: {
                    required: !0,
                },
             shop_unit: {
                    required: !0,
                },
             xyd_st_id: {
                    required: !0,
                },
             xyd_cre_dt: {
                    required: !0,
                },
             xyd_up_dt: {
                    required: !0,
                },
             xyd_user_id: {
                    required: !0,
                },


            },
            messages: {
                         shop_id: {
                                required:  e + "请输入正确的商品ID",

                            },
                         shop_no: {
                                required:  e + "请输入正确的商品编码",

                            },
                         shop_nm: {
                                required:  e + "请输入正确的商品名称",

                            },
                         shop_weigth: {
                                required:  e + "请输入正确的商品重量",

                            },
                         shop_spec: {
                                required:  e + "请输入正确的商品规格",

                            },
                         shop_no_num: {
                                required:  e + "请输入正确的商品条码",

                            },
                         shop_unit: {
                                required:  e + "请输入正确的商品单位",

                            },
                         xyd_st_id: {
                                required:  e + "请输入正确的删除状态",

                            },
                         xyd_cre_dt: {
                                required:  e + "请输入正确的创建日期",

                            },
                         xyd_up_dt: {
                                required:  e + "请输入正确的修改日期",

                            },
                         xyd_user_id: {
                                required:  e + "请输入正确的操作用户",

                            },

            },
            showErrors: function (errorMap, errorList) {
                var msg = "";
                $.each(errorList, function (i, v) {
                    //msg += (v.message + "\r\n");
                    //在此处用了layer的方法,显示效果更美观
                    layer.tips(v.message, v.element, { tips:[2,'red'],time: 2000 });
                    return false;
                });
            },
			/* 失去焦点时不验证 */
            onfocusout: false
        })

    };


/**校验结束**/

