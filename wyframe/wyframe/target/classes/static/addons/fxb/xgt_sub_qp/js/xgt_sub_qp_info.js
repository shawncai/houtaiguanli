/**
 * 初始化题目详情对话框
 */
var Xgt_sub_qpInfoDlg = {
    xgt_sub_qpInfoData : {},
    zTreeInstance : null
};

/**
 * 清除数据
 */
Xgt_sub_qpInfoDlg.clearData = function() {
    this.xgt_sub_qpInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xgt_sub_qpInfoDlg.set = function(key, val) {
    this.xgt_sub_qpInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xgt_sub_qpInfoDlg.get = function(key) {
    return $("#" + key).val();
}
/**
 * 关闭此对话框
 */
Xgt_sub_qpInfoDlg.close = function() {
   parent.layer.closeAll()
}

/**
 * 收集数据
 */
Xgt_sub_qpInfoDlg.collectData = function() {
    this.set('sub_qp_id').set('sub_qp_title').set('sub_id').set('sub_exam_id').set('sub_qp_tp_id').set('sub_qp_ea_id').set('sub_qp_sel_a').set('sub_qp_sel_b').set('sub_qp_sel_c').set('sub_qp_sel_d').set('sub_qp_yes').set('sub_qp_no').set('sub_qp_answer').set('sub_qp_anl').set('spec_flg').set('mdi_dt').set('cre_dt').set('st_id').set('cpn_id');
}

/**
 * 提交添加
 */
Xgt_sub_qpInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_sub_qp/add", function(DATA){
        Feng.success("添加成功!");

                var ajax1 = new $ax(Feng.ctxPath + "/xgt_sub_qp/list", function(data){
                    tableData=data
                });
                 var demoReload = parent.$('#condition').val();
                ajax1.set('condition',demoReload);
                            ajax1.set('st_id',parent.$('#st_id').val());
                    ajax1.start();
         window.parent.layui.table.reload('Xgt_sub_qpTable', {data:tableData});
        Xgt_sub_qpInfoDlg.close();
    },function(DATA){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xgt_sub_qpInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
Xgt_sub_qpInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_sub_qp/update", function(DATA){
        Feng.success("修改成功!"); var ajax1 = new $ax(Feng.ctxPath + "/xgt_sub_qp/list", function(data){
          tableData=data
      });
       var demoReload = parent.$('#condition').val();
      ajax1.set('condition',demoReload);
      ajax1.set('st_id',parent.$('#st_id').val());
          ajax1.start();
window.parent.layui.table.reload('Xgt_sub_qpTable', {data:tableData});
        Xgt_sub_qpInfoDlg.close();
    },function(DATA){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xgt_sub_qpInfoData);
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
             sub_qp_id: {
                    required: !0,
                },
             sub_qp_title: {
                    required: !0,
                },
             sub_id: {
                    required: !0,
                },
             sub_exam_id: {
                    required: !0,
                },
             sub_qp_tp_id: {
                    required: !0,
                },
             sub_qp_ea_id: {
                    required: !0,
                },
             sub_qp_sel_a: {
                    required: !0,
                },
             sub_qp_sel_b: {
                    required: !0,
                },
             sub_qp_sel_c: {
                    required: !0,
                },
             sub_qp_sel_d: {
                    required: !0,
                },
             sub_qp_yes: {
                    required: !0,
                },
             sub_qp_no: {
                    required: !0,
                },
             sub_qp_answer: {
                    required: !0,
                },
             sub_qp_anl: {
                    required: !0,
                },
             spec_flg: {
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
             cpn_id: {
                    required: !0,
                },


            },
            messages: {
                         sub_qp_id: {
                                required:  e + "请输入正确的题目ID",

                            },
                         sub_qp_title: {
                                required:  e + "请输入正确的题目内容",

                            },
                         sub_id: {
                                required:  e + "请输入正确的科目",

                            },
                         sub_exam_id: {
                                required:  e + "请输入正确的试卷",

                            },
                         sub_qp_tp_id: {
                                required:  e + "请输入正确的题目类型 ",

                            },
                         sub_qp_ea_id: {
                                required:  e + "请输入正确的题目难度",

                            },
                         sub_qp_sel_a: {
                                required:  e + "请输入正确的选项A",

                            },
                         sub_qp_sel_b: {
                                required:  e + "请输入正确的选项B",

                            },
                         sub_qp_sel_c: {
                                required:  e + "请输入正确的选项C",

                            },
                         sub_qp_sel_d: {
                                required:  e + "请输入正确的选项D",

                            },
                         sub_qp_yes: {
                                required:  e + "请输入正确的正选项",

                            },
                         sub_qp_no: {
                                required:  e + "请输入正确的错选项",

                            },
                         sub_qp_answer: {
                                required:  e + "请输入正确的答案",

                            },
                         sub_qp_anl: {
                                required:  e + "请输入正确的题目分析",

                            },
                         spec_flg: {
                                required:  e + "请输入正确的分类 ",

                            },
                         mdi_dt: {
                                required:  e + "请输入正确的变更时间",

                            },
                         cre_dt: {
                                required:  e + "请输入正确的创建时间",

                            },
                         st_id: {
                                required:  e + "请输入正确的状态  ",

                            },
                         cpn_id: {
                                required:  e + "请输入正确的企业信息",

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
