/**
 * 用户详情对话框（可用于添加和修改对话框）
 */
var UserInfoDlg = {
    userInfoData: {},
    validateFields: {
        account: {
            validators: {
                notEmpty: {
                    message: '账户不能为空'
                }
            }
        },
        name: {
            validators: {
                notEmpty: {
                    message: '姓名不能为空'
                }
            }
        },
        citySel: {
            validators: {
                notEmpty: {
                    message: '部门不能为空'
                }
            }
        },
        password: {
            validators: {
                notEmpty: {
                    message: '密码不能为空'
                },
                identical: {
                    field: 'rePassword',
                    message: '两次密码不一致'
                },
            }
        },
        rePassword: {
            validators: {
                notEmpty: {
                    message: '密码不能为空'
                },
                identical: {
                    field: 'password',
                    message: '两次密码不一致'
                },
            }
        }
    }
};

/**
 * 清除数据
 */
UserInfoDlg.clearData = function () {
    this.userInfoData = {};
};

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
UserInfoDlg.set = function (key, val) {
    this.userInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
};

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
UserInfoDlg.get = function (key) {
    return $("#" + key).val();
};

/**
 * 关闭此对话框
 */
UserInfoDlg.close = function () {
    parent.layer.close(window.parent.MgrUser.layerIndex);
};

/**
 * 点击部门input框时
 *
 * @param e
 * @param treeId
 * @param treeNode
 * @returns
 */
/*UserInfoDlg.onClickDept = function (e, treeId, treeNode) {
    $("#deptName").attr("value", UserInfoDlg.zTreeInstance.getSelectedVal());
    $("#par_cpn_dept_id").attr("value", treeNode.id);
    UserInfoDlg.deptName=UserInfoDlg.zTreeInstance.getSelectedVal();
    UserInfoDlg.par_cpn_dept_id= treeNode.id;
};*/

/**
 * 显示部门选择的树
 *
 * @returns
 */
UserInfoDlg.showDeptSelectTree = function () {
    var cityObj = $("#citySel");
    var cityOffset = $("#citySel").offset();
    $("#menuContent").css({
        left: cityOffset.left + "px",
        top: cityOffset.top + cityObj.outerHeight() + "px"
    }).slideDown("fast");

    $("body").bind("mousedown", onBodyDown);
};

/*UserInfoDlg.showSelectTree = function () {
    Feng.showInputTree("deptName", "deptTreeDiv", 15, 34);
}*/

/**
 * 显示用户详情部门选择的树
 *
 * @returns
 */
UserInfoDlg.showInfoDeptSelectTree = function () {
    var cityObj = $("#citySel");
    var cityPosition = $("#citySel").position();
    $("#menuContent").css({
        left: cityPosition.left + "px",
        top: cityPosition.top + cityObj.outerHeight() + "px"
    }).slideDown("fast");

    $("body").bind("mousedown", onBodyDown);
};

/**
 * 隐藏部门选择的树
 */
UserInfoDlg.hideDeptSelectTree = function () {
    $("#menuContent").fadeOut("fast");
    $("body").unbind("mousedown", onBodyDown);// mousedown当鼠标按下就可以触发，不用弹起
};

/**
 * 收集数据
 */
UserInfoDlg.collectData = function () {
    this.set('id').set('account').set('sex').set('password').set('avatar')
        .set('email').set("par_cpn_dept_id").set('name').set('birthday').set('rePassword').set('phone');
};

/**
 * 验证两个密码是否一致
 */
UserInfoDlg.validatePwd = function () {
    var password = this.get("password");
    var rePassword = this.get("rePassword");
    if (password == rePassword) {
        return true;
    } else {
        return false;
    }
};

/**
 * 验证数据是否为空
 */
UserInfoDlg.validate = function () {
    $('#userInfoForm').data("bootstrapValidator").resetForm();
    $('#userInfoForm').bootstrapValidator('validate');
    return $("#userInfoForm").data('bootstrapValidator').isValid();
};

/**
 * 提交添加用户
 */
UserInfoDlg.addSubmit = function () {

    this.clearData();
    this.collectData();

    if (!this.validate()) {
        return;
    }

    if (!this.validatePwd()) {
        Feng.error("两次密码输入不一致");
        return;
    }

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/mgr/add", function (data) {
        Feng.success("添加成功!");
        window.parent.MgrUser.table.refresh();
        UserInfoDlg.close();
    }, function (data) {
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.userInfoData);
    ajax.start();
};
/**
 * 提交添加并继续添加用户
 */
UserInfoDlg.addontinueSubmit = function () {

    this.clearData();
    this.collectData();

    if (!this.validate()) {
        return;
    }

    if (!this.validatePwd()) {
        Feng.error("两次密码输入不一致");
        return;
    }

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/mgr/add", function (data) {
        Feng.success("添加成功!");
        window.parent.MgrUser.table.refresh();
        $("#account").val("");
        $("#password").val("");
        $("#avatar").val("");
        $("#email").val("");
        $("#name").val("");
        $("#birthday").val("");
        $("#rePassword").val("");
        $("#phone").val("");

        // UserInfoDlg.close();
    }, function (data) {
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.userInfoData);
    ajax.start();
};

/**
 * 提交修改
 */

UserInfoDlg.editSubmit = function () {

    this.clearData();
    this.collectData();

    if (!this.validate()) {
        return;
    }

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/mgr/edit", function (data) {
        Feng.success("修改成功!");
        if (window.parent.MgrUser != undefined) {
            window.parent.MgrUser.table.refresh();
            UserInfoDlg.close();
        }
    }, function (data) {
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.userInfoData);
    ajax.start();
};

/**
 * 修改密码
 */
UserInfoDlg.chPwd = function () {
    var ajax = new $ax(Feng.ctxPath + "/mgr/changePwd", function (data) {
    	var oldPwd = $('oldPwd').val();
    	var newPwd = $('newPwd').val();
        Feng.success("修改成功!");
    }, function (data) {
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set("oldPwd");
    ajax.set("newPwd");
    ajax.set("rePwd");
    ajax.start();

};

function onBodyDown(event) {
    if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(
            event.target).parents("#menuContent").length > 0)) {
        UserInfoDlg.hideDeptSelectTree();
    }
}
// //初始化企业
// $(function ()  {
// 	var ajax = new $ax(Feng.ctxPath + "/xyd_cpn/spList/" , function (data) {
//
// 		for(var i = 0; i < data.length; i++) {
// 			$("#cpn_id").append(
// 					"<option value=" + data[i].cpn_id + ">"
// 					+ data[i].cpn_nm + "</option>");
// 		}
// 	}, function(data) {
// 		Feng.error("获取列表失败!" + data.responseJSON.message + "!");
// 	});
// 	ajax.start();
//
//     changeBranch();
//     changeDept();
// });
//初始化分支
function changeBranch()  {
	var cpnId = $('#cpn_id').val();
	if(cpnId!=undefined){
		
	var ajax = new $ax(Feng.ctxPath + "/xyd_cpn_branch/nowCpnBranchList/"+cpnId , function (data) {
		
		for(var i = 0; i < data.length; i++) {
			$("#cpn_branch_id").append(
					"<option value=" + data[i].cpn_branch_id + ">"
					+ data[i].cpn_branch_nm + "</option>");		
		} 
	}, function(data) {
		Feng.error("获取列表失败!" + data.responseJSON.message + "!");
	});
	ajax.start();
	}
};
//初始化部门
function changeDept()  {
	
	var cpnBranchId = $('#cpn_branch_id').val();
	if(cpnBranchId!=undefined){
		
	var ajax = new $ax(Feng.ctxPath + "/xyd_cpn_dept/nowBranchDeptList/"+cpnBranchId , function (data) {
		
		for(var i = 0; i < data.length; i++) {
			$("#par_cpn_dept_id").append(
					"<option value=" + data[i].par_cpn_dept_id + ">"
					+ data[i].cpn_dept_nm + "</option>");		
		} 
	}, function(data) {
		Feng.error("获取列表失败!" + data.responseJSON.message + "!");
	});
	ajax.start();
	}
};

$(function () {
//     var deptName =$("#userDeptName").val();
//     //document.getElementById('deptName').value =deptName;
// $("#par_cpn_dept_id").val($("#userDeptId").val());
//
// 	$("#cpn_id").change(//初始化分支
//         function()  {
//             $("#cpn_branch_id").empty();//去除所有option
//             var cpnId = $('#cpn_id').val();
//             if(cpnId!=undefined){
//                 var ajax = new $ax(Feng.ctxPath + "/xyd_cpn_branch/nowCpnBranchList/"+cpnId , function (data) {
//                     for(var i = 0; i < data.length; i++) {
//                         $("#cpn_branch_id").append(
//                             "<option value=" + data[i].cpn_branch_id + ">"
//                             + data[i].cpn_branch_nm + "</option>");
//                     }
//                         $("#par_cpn_dept_id").empty();
//                         var cpnBranchId = $('#cpn_branch_id').val();
//                         if(cpnBranchId!=undefined){
//                             var ajax = new $ax(Feng.ctxPath + "/xyd_cpn_dept/nowBranchDeptList/"+cpnBranchId , function (data) {
//                                 for(var i = 0; i < data.length; i++) {
//                                     $("#par_cpn_dept_id").append(
//                                         "<option value=" + data[i].par_cpn_dept_id + ">"
//                                         + data[i].cpn_dept_nm + "</option>");
//                                 }
//                             }, function(data) {
//                                 Feng.error("获取列表失败!" + data.responseJSON.message + "!");
//                             });
//                             ajax.start();
//                         }
//                 }, function(data) {
//                     Feng.error("获取列表失败!" + data.responseJSON.message + "!");
//                 });
//                 ajax.start();
//             }
//         } );
// 	$("#cpn_branch_id").change(//初始化部门
// 			function()  {
// 			    $("#par_cpn_dept_id").empty();
// 				var cpnBranchId = $('#cpn_branch_id').val();
//                 if(cpnBranchId!=undefined){
//                     var ajax = new $ax(Feng.ctxPath + "/xyd_cpn_dept/nowBranchDeptList/"+cpnBranchId , function (data) {
//                         for(var i = 0; i < data.length; i++) {
//                             $("#par_cpn_dept_id").append(
//                                 "<option value=" + data[i].par_cpn_dept_id + ">"
//                                 + data[i].cpn_dept_nm + "</option>");
//                         }
//                     }, function(data) {
//                         Feng.error("获取列表失败!" + data.responseJSON.message + "!");
//                     });
//                     ajax.start();
//                 }
// 			});
	
	
    Feng.initValidator("userInfoForm", UserInfoDlg.validateFields);
    var userDeptId = $("#userDeptId").val();
    if (userDeptId==undefined){
        userDeptId=0;
    }
    // var ztree = new $ZTree("treeDemo", "/xyd_cpn_dept/tree/"+userDeptId);
    // ztree.bindOnClick(UserInfoDlg.onClickDept);
    // ztree.init();
    // UserInfoDlg.zTreeInstance = ztree;

    //初始化性别选项
    $("#sex").val($("#sexValue").val());

    // 初始化头像上传
    var avatarUp = new $WebUpload("avatar");
    avatarUp.init();
});
