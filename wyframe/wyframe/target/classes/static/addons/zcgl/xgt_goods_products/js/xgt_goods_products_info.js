/**
 * 初始化商品测试详情对话框
 */
var Xgt_goods_productsInfoDlg = {
    xgt_goods_productsInfoData : {},
    zTreeInstance : null
};

/**
 * 清除数据
 */
Xgt_goods_productsInfoDlg.clearData = function() {
    this.xgt_goods_productsInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xgt_goods_productsInfoDlg.set = function(key, val) {
    this.xgt_goods_productsInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xgt_goods_productsInfoDlg.get = function(key) {
    return $("#" + key).val();
}
/**
 * 关闭此对话框
 */
Xgt_goods_productsInfoDlg.close = function() {
   parent.layer.closeAll()
}

/**
 * 收集数据
 */
Xgt_goods_productsInfoDlg.collectData = function() {
    this.set('prd_id').set('prd_nm').set('prd_brand_id').set('prd_nm_alias').set('prd_cls_id').set('prd_sn').set('prd_unit_id').set('prd_model').set('prd_spec').set('prd_no').set('prd_crt_dt').set('prd_purchase').set('prd_price').set('xyd_cre_dt').set('xyd_up_dt').set('id').set('prd_nm_img').set('prd_nm_dsc').set('xyd_st_id');
}

/**
 * 提交添加
 */
Xgt_goods_productsInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_goods_products/add", function(DATA){
        Feng.success("添加成功!");

                var ajax1 = new $ax(Feng.ctxPath + "/xgt_goods_products/list", function(data){
                    tableData=data
                });
                 var demoReload = parent.$('#condition').val();
                ajax1.set('condition',demoReload);
                            ajax1.set('xyd_st_id',parent.$('#xyd_st_id').val());
                    ajax1.start();
         window.parent.layui.table.reload('Xgt_goods_productsTable', {data:tableData});
        Xgt_goods_productsInfoDlg.close();
    },function(DATA){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xgt_goods_productsInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
Xgt_goods_productsInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_goods_products/update", function(DATA){
        Feng.success("修改成功!"); var ajax1 = new $ax(Feng.ctxPath + "/xgt_goods_products/list", function(data){
          tableData=data
      });
       var demoReload = parent.$('#condition').val();
      ajax1.set('condition',demoReload);
      ajax1.set('xyd_st_id',parent.$('#xyd_st_id').val());
          ajax1.start();
window.parent.layui.table.reload('Xgt_goods_productsTable', {data:tableData});
        Xgt_goods_productsInfoDlg.close();
    },function(DATA){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xgt_goods_productsInfoData);
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
             prd_id: {
                    required: !0,
                },
             prd_nm: {
                    required: !0,
                },
             prd_brand_id: {
                    required: !0,
                },
             prd_nm_alias: {
                    required: !0,
                },
             prd_cls_id: {
                    required: !0,
                },
             prd_sn: {
                    required: !0,
                email : true
                },
             prd_unit_id: {
                    required: !0,
                },
             prd_model: {
                    required: !0,
                },
             prd_spec: {
                    required: !0,
                },
             prd_no: {
                    required: !0,
                minlength : 11,
                isMobile : true
                },
             prd_crt_dt: {
                    required: !0,
                },
             prd_purchase: {
                    required: !0,
                },
             prd_price: {
                    required: !0,
                },
             xyd_cre_dt: {
                    required: !0,
                },
             xyd_up_dt: {
                    required: !0,
                },
             id: {
                    required: !0,
                },
             prd_nm_img: {
                    required: !0,
                },
             prd_nm_dsc: {
                    required: !0,
                },
             xyd_st_id: {
                    required: !0,
                },


            },
            messages: {
                         prd_id: {
                                required:  e + "请输入正确的键值",

                            },
                         prd_nm: {
                                required:  e + "请输入正确的名称",

                            },
                         prd_brand_id: {
                                required:  e + "请输入正确的品牌",

                            },
                         prd_nm_alias: {
                                required:  e + "请输入正确的简称",

                            },
                         prd_cls_id: {
                                required:  e + "请输入正确的分类",

                            },
                         prd_sn: {
                                required:  e + "请输入正确的序列",


                            },
                         prd_unit_id: {
                                required:  e + "请输入正确的单位",

                            },
                         prd_model: {
                                required:  e + "请输入正确的型号",

                            },
                         prd_spec: {
                                required:  e + "请输入正确的规格",

                            },
                         prd_no: {
                                required:  e + "请输入正确的条码",

                           minlength : "确认手机不能小于11个字符",
                           isMobile : "请输入正确的手机号码",

                            },
                         prd_crt_dt: {
                                required:  e + "请输入正确的上市时间",

                            },
                         prd_purchase: {
                                required:  e + "请输入正确的采购价",

                            },
                         prd_price: {
                                required:  e + "请输入正确的销售价",

                            },
                         xyd_cre_dt: {
                                required:  e + "请输入正确的创建日期",

                            },
                         xyd_up_dt: {
                                required:  e + "请输入正确的修改日期",

                            },
                         id: {
                                required:  e + "请输入正确的操作人",

                            },
                         prd_nm_img: {
                                required:  e + "请输入正确的图片",

                            },
                         prd_nm_dsc: {
                                required:  e + "请输入正确的描述",

                            },
                         xyd_st_id: {
                                required:  e + "请输入正确的状态",

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

