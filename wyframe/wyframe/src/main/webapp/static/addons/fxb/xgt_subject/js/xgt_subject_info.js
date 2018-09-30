/**
 * 初始化科目详情对话框
 */
var Xgt_subjectInfoDlg = {
    xgt_subjectInfoData : {},
    zTreeInstance : null
};

/**
 * 清除数据
 */
Xgt_subjectInfoDlg.clearData = function() {
    this.xgt_subjectInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xgt_subjectInfoDlg.set = function(key, val) {
    this.xgt_subjectInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xgt_subjectInfoDlg.get = function(key) {
    return $("#" + key).val();
}
/**
 * 关闭此对话框
 */
Xgt_subjectInfoDlg.close = function() {
   parent.layer.closeAll()
}

/**
 * 收集数据
 */
Xgt_subjectInfoDlg.collectData = function() {
    this.set('sub_id').set('sub_nm').set('cpn_id').set('xyd_st_id').set('xyd_cre_dt').set('xyd_up_dt').set('id');
}

/**
 * 提交添加
 */
Xgt_subjectInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_subject/add", function(DATA){
        Feng.success("添加成功!");

                var ajax1 = new $ax(Feng.ctxPath + "/xgt_subject/list", function(data){
                    tableData=data
                });
                    ajax1.start();
         window.parent.layui.table.reload('Xgt_subjectTable', {data:tableData});
        Xgt_subjectInfoDlg.close();
    },function(DATA){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xgt_subjectInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
Xgt_subjectInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_subject/update", function(DATA){
        Feng.success("修改成功!"); var ajax1 = new $ax(Feng.ctxPath + "/xgt_subject/list", function(data){
          tableData=data
      });
       var demoReload = parent.$('#condition').val();
      ajax1.set('condition',demoReload);
      ajax1.set('xyd_st_id',parent.$('#xyd_st_id').val());
          ajax1.start();
window.parent.layui.table.reload('Xgt_subjectTable', {data:tableData});
        Xgt_subjectInfoDlg.close();
    },function(DATA){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xgt_subjectInfoData);
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
             sub_id: {
                    required: !0,
                },
             sub_nm: {
                    required: !0,
                },
             cpn_id: {
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
                         sub_id: {
                                required:  e + "请输入正确的科目ID",

                            },
                         sub_nm: {
                                required:  e + "请输入正确的科目名称",

                            },
                         cpn_id: {
                                required:  e + "请输入正确的企业信息",

                            },
                         xyd_st_id: {
                                required:  e + "请输入正确的状态",

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

