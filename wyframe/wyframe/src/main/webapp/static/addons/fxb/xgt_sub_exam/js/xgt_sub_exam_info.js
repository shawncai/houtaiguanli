/**
 * 初始化试卷详情对话框
 */
var Xgt_sub_examInfoDlg = {
    xgt_sub_examInfoData : {},
    zTreeInstance : null
};

/**
 * 清除数据
 */
Xgt_sub_examInfoDlg.clearData = function() {
    this.xgt_sub_examInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xgt_sub_examInfoDlg.set = function(key, val) {
    this.xgt_sub_examInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Xgt_sub_examInfoDlg.get = function(key) {
    return $("#" + key).val();
}
/**
 * 关闭此对话框
 */
Xgt_sub_examInfoDlg.close = function() {
   parent.layer.closeAll()
}

/**
 * 收集数据
 */
Xgt_sub_examInfoDlg.collectData = function() {
    this.set('sub_exam_id').set('sub_exam_nm').set('par_sub_exam_id').set('sub_id').set('id').set('sub_exam_no').set('one_sel_sum').set('more_sel_sum').set('yes_no_sum').set('insert_sum').set('spec_qp_sum').set('mdi_dt').set('cre_dt').set('st_id');
}

/**
 * 提交添加
 */
Xgt_sub_examInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_sub_exam/add", function(DATA){
        Feng.success("添加成功!");
                // var ajax1 = new $ax(Feng.ctxPath + "/xgt_sub_exam/bulidJson", function(Data){
                //     console.log(Data)
                //
                //
                // });
                //
                //     ajax1.start();
        parent.layui.table.reload('Xgt_sub_examTable', {
            url: Feng.ctxPath +"/xgt_sub_exam/backContent"

        });
        parent.layer.closeAll();
    },function(DATA){
        Feng.error("添加失败!" + DATA.responseJSON.message + "!");
    });
    ajax.set(this.xgt_sub_examInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
Xgt_sub_examInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xgt_sub_exam/update", function(DATA){
        var tableData=[];
        Feng.success("修改成功!"); var ajax1 = new $ax(Feng.ctxPath + "/xgt_sub_exam/list", function(data){
            tableData=data
      });
       var demoReload = parent.$('#condition').val();
      ajax1.set('condition',demoReload);
      ajax1.set('limit',1000);
      ajax1.set('st_id',parent.$('#st_id').val());
          ajax1.start();
window.parent.layui.table.reload('Xgt_sub_examTable', {data:tableData});
        parent.layer.closeAll()
    },function(DATA){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xgt_sub_examInfoData);
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
             sub_exam_id: {
                    required: !0,
                },
             sub_exam_nm: {
                    required: !0,
                },
             par_sub_exam_id: {
                    required: !0,
                },
             sub_id: {
                    required: !0,
                },
             id: {
                    required: !0,
                },
             sub_exam_no: {
                    required: !0,
                },
             one_sel_sum: {
                    required: !0,
                },
             more_sel_sum: {
                    required: !0,
                },
             yes_no_sum: {
                    required: !0,
                },
             insert_sum: {
                    required: !0,
                },
             spec_qp_sum: {
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
                         sub_exam_id: {
                                required:  e + "请输入正确的试卷ID ",

                            },
                         sub_exam_nm: {
                                required:  e + "请输入正确的试卷名称",

                            },
                         par_sub_exam_id: {
                                required:  e + "请输入正确的上级试卷ID",

                            },
                         sub_id: {
                                required:  e + "请输入正确的科目ID",

                            },
                         id: {
                                required:  e + "请输入正确的用户ID",

                            },
                         sub_exam_no: {
                                required:  e + "请输入正确的试卷编号",

                            },
                         one_sel_sum: {
                                required:  e + "请输入正确的单选数量",

                            },
                         more_sel_sum: {
                                required:  e + "请输入正确的多选数量",

                            },
                         yes_no_sum: {
                                required:  e + "请输入正确的判断题数量",

                            },
                         insert_sum: {
                                required:  e + "请输入正确的填空题数量",

                            },
                         spec_qp_sum: {
                                required:  e + "请输入正确的简单题数量",

                            },
                         mdi_dt: {
                                required:  e + "请输入正确的变更时间",

                            },
                         cre_dt: {
                                required:  e + "请输入正确的创建时间",

                            },
                         st_id: {
                                required:  e + "请输入正确的状态   	状态-1：停用；1：正常；2：暂停",

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

