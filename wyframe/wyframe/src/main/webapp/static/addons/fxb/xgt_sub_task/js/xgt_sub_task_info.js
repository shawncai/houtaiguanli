/**
 * 初始化作业任务详情对话框
 */
var Xgt_sub_taskInfoDlg = {
    xgt_sub_taskInfoData : {},
    zTreeInstance : null
};

/**
 * 清除数据
 */
Xgt_sub_taskInfoDlg.clearData = function() {
    this.xgt_sub_taskInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xgt_sub_taskInfoDlg.set = function(key, val) {
    this.xgt_sub_taskInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xgt_sub_taskInfoDlg.get = function(key) {
    return $("#" + key).val();
}
/**
 * 关闭此对话框
 */
Xgt_sub_taskInfoDlg.close = function() {
   parent.layer.closeAll()
}

/**
 * 收集数据
 */
Xgt_sub_taskInfoDlg.collectData = function() {
    this.set('task_id').set('task_nm').set('id').set('sub_exam_id').set('sub_id').set('task_ask').set('over_dt').set('mdi_dt').set('cre_dt').set('st_id');
}



/**
 * 提交添加
 */
Xgt_sub_taskInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();
    var cheshi=$('#xuesheng').val()

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_sub_task/add", function(DATA){
        Feng.success("添加成功!");

                var ajax1 = new $ax(Feng.ctxPath + "/xgt_sub_task/list", function(data){
                    tableData=data
                });

                    ajax1.start();
         window.parent.layui.table.reload('Xgt_sub_taskTable', {data:tableData});
        parent.layer.closeAll()
    },function(DATA){
        var ajax1 = new $ax(Feng.ctxPath + "/xgt_sub_task/list", function(data){
            tableData=data
        });

        ajax1.start();
        window.parent.layui.table.reload('Xgt_sub_taskTable', {data:tableData});
        parent.layer.closeAll()
    });
    ajax.set(this.xgt_sub_taskInfoData);
    ajax.set('stids',cheshi)
    ajax.start();
}

/**
 * 提交修改
 */
Xgt_sub_taskInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_sub_task/update", function(DATA){
        Feng.success("修改成功!"); var ajax1 = new $ax(Feng.ctxPath + "/xgt_sub_task/list", function(data){
          tableData=data
      });
       var demoReload = parent.$('#condition').val();
      ajax1.set('condition',demoReload);
      ajax1.set('st_id',parent.$('#st_id').val());
          ajax1.start();
window.parent.layui.table.reload('Xgt_sub_taskTable', {data:tableData});
        Xgt_sub_taskInfoDlg.close();
    },function(DATA){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xgt_sub_taskInfoData);
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
             task_id: {
                    required: !0,
                },
             task_nm: {
                    required: !0,
                },
             id: {
                    required: !0,
                },
             sub_exam_id: {
                    required: !0,
                },
             sub_id: {
                    required: !0,
                },
             task_ask: {
                    required: !0,
                },
             over_dt: {
                    required: !0,
                },
             mdi_dt: {
                    required: !0,
                },
             cre_dt: {
                    required: !0,
                },
             st_id: {
                    required: !0,
                },


            },
            messages: {
                         task_id: {
                                required:  e + "请输入正确的作业任务ID",

                            },
                         task_nm: {
                                required:  e + "请输入正确的作业名称",

                            },
                         id: {
                                required:  e + "请输入正确的用户",

                            },
                         sub_exam_id: {
                                required:  e + "请输入正确的试卷",

                            },
                         sub_id: {
                                required:  e + "请输入正确的科目",

                            },
                         task_ask: {
                                required:  e + "请输入正确的作业要求",

                            },
                         over_dt: {
                                required:  e + "请输入正确的要求完成时间",

                            },
                         mdi_dt: {
                                required:  e + "请输入正确的变更时间",

                            },
                         cre_dt: {
                                required:  e + "请输入正确的创建时间",

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

