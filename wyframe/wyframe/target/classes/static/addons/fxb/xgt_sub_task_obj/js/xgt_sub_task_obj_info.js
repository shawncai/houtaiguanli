/**
 * 初始化作业对象详情对话框
 */
var Xgt_sub_task_objInfoDlg = {
    xgt_sub_task_objInfoData : {},
    zTreeInstance : null
};

/**
 * 清除数据
 */
Xgt_sub_task_objInfoDlg.clearData = function() {
    this.xgt_sub_task_objInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xgt_sub_task_objInfoDlg.set = function(key, val) {
    this.xgt_sub_task_objInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xgt_sub_task_objInfoDlg.get = function(key) {
    return $("#" + key).val();
}
/**
 * 关闭此对话框
 */
Xgt_sub_task_objInfoDlg.close = function() {
   parent.layer.closeAll()
}

/**
 * 收集数据
 */
Xgt_sub_task_objInfoDlg.collectData = function() {
    this.set('task_obj_id').set('task_id').set('id').set('accept_dt').set('over_dt').set('over_st_id').set('right_num').set('error_num').set('mdi_dt').set('cre_dt').set('cpn_id').set('st_id');
}

/**
 * 提交添加
 */
Xgt_sub_task_objInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_sub_task_obj/add", function(DATA){
        Feng.success("添加成功!");

                var ajax1 = new $ax(Feng.ctxPath + "/xgt_sub_task_obj/list", function(data){
                    tableData=data
                });

                    ajax1.start();
         window.parent.layui.table.reload('Xgt_sub_task_objTable', {data:tableData});
        Xgt_sub_task_objInfoDlg.close();
    },function(DATA){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xgt_sub_task_objInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
Xgt_sub_task_objInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_sub_task_obj/update", function(DATA){
        Feng.success("修改成功!"); var ajax1 = new $ax(Feng.ctxPath + "/xgt_sub_task_obj/list", function(data){
          tableData=data
      });
       var demoReload = parent.$('#condition').val();
      ajax1.set('condition',demoReload);
      ajax1.set('over_st_id',parent.$('#over_st_id').val());
      ajax1.set('st_id',parent.$('#st_id').val());
          ajax1.start();
window.parent.layui.table.reload('Xgt_sub_task_objTable', {data:tableData});
        Xgt_sub_task_objInfoDlg.close();
    },function(DATA){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xgt_sub_task_objInfoData);
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
             task_obj_id: {
                    required: !0,
                },
             task_id: {
                    required: !0,
                },
             id: {
                    required: !0,
                },
             accept_dt: {
                    required: !0,
                },
             over_dt: {
                    required: !0,
                },
             over_st_id: {
                    required: !0,
                },
             right_num: {
                    required: !0,
                },
             error_num: {
                    required: !0,
                },
             mdi_dt: {
                    required: !0,
                },
             cre_dt: {
                    required: !0,
                },
             cpn_id: {
                    required: !0,
                },
             st_id: {
                    required: !0,
                },


            },
            messages: {
                         task_obj_id: {
                                required:  e + "请输入正确的作业对象ID",

                            },
                         task_id: {
                                required:  e + "请输入正确的作业任务ID",

                            },
                         id: {
                                required:  e + "请输入正确的完成作业用户ID",

                            },
                         accept_dt: {
                                required:  e + "请输入正确的接任务时间",

                            },
                         over_dt: {
                                required:  e + "请输入正确的任务完成时间",

                            },
                         over_st_id: {
                                required:  e + "请输入正确的完成状态　",

                            },
                         right_num: {
                                required:  e + "请输入正确的正确数",

                            },
                         error_num: {
                                required:  e + "请输入正确的错误树",

                            },
                         mdi_dt: {
                                required:  e + "请输入正确的变更时间",

                            },
                         cre_dt: {
                                required:  e + "请输入正确的创建时间",

                            },
                         cpn_id: {
                                required:  e + "请输入正确的企业信息ID",

                            },
                         st_id: {
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
