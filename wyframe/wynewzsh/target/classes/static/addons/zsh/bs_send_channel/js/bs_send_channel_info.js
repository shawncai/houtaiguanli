/**
 * 初始化配送商详情对话框
 */
var Bs_send_channelInfoDlg = {
    bs_send_channelInfoData : {},
    zTreeInstance : null
};

/**
 * 清除数据
 */
Bs_send_channelInfoDlg.clearData = function() {
    this.bs_send_channelInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Bs_send_channelInfoDlg.set = function(key, val) {
    this.bs_send_channelInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Bs_send_channelInfoDlg.get = function(key) {
    return $("#" + key).val();
}
/**
 * 关闭此对话框
 */
Bs_send_channelInfoDlg.close = function() {
   parent.layer.closeAll()
}

/**
 * 收集数据
 */
Bs_send_channelInfoDlg.collectData = function() {
    this.set('send_chnl_id').set('send_chnl_no').set('send_chnl_nm').set('send_chnl_desc').set('send_chnl_phoe').set('send_chnl_num').set('send_chnl_flg').set('xyd_st_id').set('xyd_cre_dt').set('xyd_up_dt').set('id');
}

/**
 * 提交添加
 */
Bs_send_channelInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();
    if ($("#send_chnl_no").val()==""){
        return false;
    }
    if ($("#send_chnl_desc").val()==""){
        return false;
    }
    if ($("#send_chnl_num").val()==""){
        return false;
    }
    if ($("#send_chnl_nm").val()==""){
        return false;
    }
    if ($("#send_chnl_phoe").val()==""){
        return false;
    }
    if ($("#send_chnl_flg").val()==""){
        return false;
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/bs_send_channel/add", function(DATA){
        Feng.success("添加成功!");

                var ajax1 = new $ax(Feng.ctxPath + "/bs_send_channel/list", function(data){
                    tableData=data
                });
                 var demoReload = parent.$('#condition').val();
                ajax1.set('condition',demoReload);
                            ajax1.set('xyd_st_id',parent.$('#xyd_st_id').val());
                    ajax1.start();
         window.parent.layui.table.reload('Bs_send_channelTable', {data:tableData});
        Bs_send_channelInfoDlg.close();
    },function(DATA){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.bs_send_channelInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
Bs_send_channelInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();
    if ($("#send_chnl_no").val()==""){
        return false;
    }
    if ($("#send_chnl_desc").val()==""){
        return false;
    }
    if ($("#send_chnl_num").val()==""){
        return false;
    }
    if ($("#send_chnl_nm").val()==""){
        return false;
    }
    if ($("#send_chnl_phoe").val()==""){
        return false;
    }
    if ($("#send_chnl_flg").val()==""){
        return false;
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/bs_send_channel/update", function(DATA){
        Feng.success("修改成功!"); var ajax1 = new $ax(Feng.ctxPath + "/bs_send_channel/list", function(data){
          tableData=data
      });
       var demoReload = parent.$('#condition').val();
      ajax1.set('condition',demoReload);
      ajax1.set('xyd_st_id',parent.$('#xyd_st_id').val());
          ajax1.start();
window.parent.layui.table.reload('Bs_send_channelTable', {data:tableData});
        Bs_send_channelInfoDlg.close();
    },function(DATA){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.bs_send_channelInfoData);
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
             send_chnl_id: {
                    required: !0,
                },
             send_chnl_no: {
                    required: !0,
                },
             send_chnl_nm: {
                    required: !0,
                },
             send_chnl_desc: {
                    required: !0,
                },
             send_chnl_phoe: {
                    required: !0,
                    minlength : 11,
                    isMobile : true
                },
             send_chnl_num: {
                    required: !0,
                },
             send_chnl_flg: {
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
                         send_chnl_id: {
                                required:  e + "请输入正确的序号",

                            },
                         send_chnl_no: {
                                required:  e + "请输入正确的配送渠道编号",

                            },
                         send_chnl_nm: {
                                required:  e + "请输入正确的配送渠道名称",

                            },
                         send_chnl_desc: {
                                required:  e + "请输入正确的配送渠道描述",

                            },
                         send_chnl_phoe: {
                                required:  e + "请输入正确的配送渠道电话",
                                minlength : "确认手机不能小于11个字符",
                                isMobile : "请正确填写您的手机号码"

                            },
                         send_chnl_num: {
                                required:  e + "请输入正确的范围符",

                            },
                         send_chnl_flg: {
                                required:  e + "请输入正确的配送数量",

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

