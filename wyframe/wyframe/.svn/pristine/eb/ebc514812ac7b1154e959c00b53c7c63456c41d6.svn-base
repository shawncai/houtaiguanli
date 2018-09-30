/**
 * 初始化销售渠道详情对话框
 */
var Bs_sale_channelInfoDlg = {
    bs_sale_channelInfoData : {},
    zTreeInstance : null
};

/**
 * 清除数据
 */
Bs_sale_channelInfoDlg.clearData = function() {
    this.bs_sale_channelInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Bs_sale_channelInfoDlg.set = function(key, val) {
    this.bs_sale_channelInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Bs_sale_channelInfoDlg.get = function(key) {
    return $("#" + key).val();
}
/**
 * 关闭此对话框
 */
Bs_sale_channelInfoDlg.close = function() {
   parent.layer.closeAll()
}

/**
 * 收集数据
 */
Bs_sale_channelInfoDlg.collectData = function() {
    this.set('chnl_id').set('chnl_no').set('chnl_nm').set('chnl_desc').set('chnl_phone').set('chnl_user_nm').set('xyd_st_id').set('xyd_cre_dt').set('xyd_up_dt').set('id');
}

/**
 * 提交添加
 */
Bs_sale_channelInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    if ($("#chnl_no").val()==""){
        return false;
    }
    if ($("#chnl_desc").val()==""){
        return false;
    }
    if ($("#chnl_user_nm").val()==""){
        return false;
    }
    if ($("#chnl_nm").val()==""){
        return false;
    }
    if ($("#chnl_phone").val()==""){
        return false;
    }

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/bs_sale_channel/add", function(DATA){
        Feng.success("添加成功!");

                var ajax1 = new $ax(Feng.ctxPath + "/bs_sale_channel/list", function(data){
                    tableData=data
                });
                 var demoReload = parent.$('#condition').val();
                ajax1.set('condition',demoReload);
                            ajax1.set('xyd_st_id',parent.$('#xyd_st_id').val());
                    ajax1.start();
         window.parent.layui.table.reload('Bs_sale_channelTable', {data:tableData});
        Bs_sale_channelInfoDlg.close();
    },function(DATA){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.bs_sale_channelInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
Bs_sale_channelInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    if ($("#chnl_no").val()==""){
        return false;
    }
    if ($("#chnl_desc").val()==""){
        return false;
    }
    if ($("#chnl_user_nm").val()==""){
        return false;
    }
    if ($("#chnl_nm").val()==""){
        return false;
    }
    if ($("#chnl_phone").val()==""){
        return false;
    }

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/bs_sale_channel/update", function(DATA){
        Feng.success("修改成功!"); var ajax1 = new $ax(Feng.ctxPath + "/bs_sale_channel/list", function(data){
          tableData=data
      });
       var demoReload = parent.$('#condition').val();
      ajax1.set('condition',demoReload);
      ajax1.set('xyd_st_id',parent.$('#xyd_st_id').val());
          ajax1.start();
window.parent.layui.table.reload('Bs_sale_channelTable', {data:tableData});
        Bs_sale_channelInfoDlg.close();
    },function(DATA){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.bs_sale_channelInfoData);
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
             chnl_id: {
                    required: !0,
                },
             chnl_no: {
                    required: !0,
                },
             chnl_nm: {
                    required: !0,
                },
             chnl_desc: {
                    required: !0,
                },
             chnl_phone: {
                    required: !0,
                    minlength : 11,
                    isMobile : true
                },
             chnl_user_nm: {
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
             id: {
                    required: !0,
                },


            },
            messages: {
                         chnl_id: {
                                required:  e + "请输入正确的销售渠道ID",

                            },
                         chnl_no: {
                                required:  e + "请输入正确的销售渠道编号",

                            },
                         chnl_nm: {
                                required:  e + "请输入正确的销售渠道名称",

                            },
                         chnl_desc: {
                                required:  e + "请输入正确的销售渠道描述",

                            },
                         chnl_phone: {
                                required:  e + "请输入正确的销售渠道电话",
                                minlength : "确认手机不能小于11个字符",
                                isMobile : "请正确填写您的手机号码"
                            },
                         chnl_user_nm: {
                                required:  e + "请输入正确的销售渠道用户",

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
                         id: {
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

