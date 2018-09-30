/**
 * 初始化订单详情对话框
 */
var Bs_billInfoDlg = {
    bs_billInfoData : {},
    zTreeInstance : null
};

/**
 * 清除数据
 */
Bs_billInfoDlg.clearData = function() {
    this.bs_billInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Bs_billInfoDlg.set = function(key, val) {
    this.bs_billInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Bs_billInfoDlg.get = function(key) {
    return $("#" + key).val();
}
/**
 * 关闭此对话框
 */
Bs_billInfoDlg.close = function() {
   parent.layer.closeAll()
}

/**
 * 收集数据
 */
Bs_billInfoDlg.collectData = function() {
    this.set('bill_id').set('bill_no').set('buy_dt').set('pay_dt').set('total_money').set('access_mem').set('access_addr_desc').set('access_phone').set('area_id').set('city_id').set('send_chnl_id').set('lu_user').set('send_dt').set('bill_st_id').set('staff_user').set('crt_dt').set('prov_id').set('user_remark').set('remarks').set('send_st').set('send_user').set('send_cre_dt').set('send_remark').set('total_num').set('card_no').set('src_bill_no').set('new_area_desc').set('xyd_st_id').set('xyd_cre_dt');
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
             bill_id: {
                    required: !0,
                },
             bill_no: {
                    required: !0,
                },
             buy_dt: {
                    required: !0,
                },
             pay_dt: {
                    required: !0,
                },
             total_money: {
                    required: !0,
                },
             access_mem: {
                    required: !0,
                },
             access_addr_desc: {
                    required: !0,
                },
             access_phone: {
                    required: !0,
                },
             area_id: {
                    required: !0,
                },
             send_chnl_id: {
                    required: !0,
                },
             lu_user: {
                    required: !0,
                },
             send_dt: {
                    required: !0,
                },
             bill_st_id: {
                    required: !0,
                },
             staff_user: {
                    required: !0,
                },
             crt_dt: {
                    required: !0,
                },
             prov_id: {
                    required: !0,
                },
             user_remark: {
                    required: !0,
                },
             remarks: {
                    required: !0,
                },
             send_st: {
                    required: !0,
                },
             send_user: {
                    required: !0,
                },
             send_cre_dt: {
                    required: !0,
                },
             send_remark: {
                    required: !0,
                },
             total_num: {
                    required: !0,
                },
             card_no: {
                    required: !0,
                },
             src_bill_no: {
                    required: !0,
                },
             new_area_desc: {
                    required: !0,
                },
             xyd_st_id: {
                    required: !0,
                },
             xyd_cre_dt: {
                    required: !0,
                },


            },
            messages: {
                         bill_id: {
                                required:  e + "请输入正确的订单序号",

                            },
                         bill_no: {
                                required:  e + "请输入正确的订单编号",

                            },
                         buy_dt: {
                                required:  e + "请输入正确的下单日期",

                            },
                         pay_dt: {
                                required:  e + "请输入正确的支付日期",

                            },
                         total_money: {
                                required:  e + "请输入正确的总金额",

                            },
                         access_mem: {
                                required:  e + "请输入正确的收货人",

                            },
                         access_addr_desc: {
                                required:  e + "请输入正确的收货人地址",

                            },
                         access_phone: {
                                required:  e + "请输入正确的收货人电话",

                            },
                         area_id: {
                                required:  e + "请输入正确的地区ID",

                            },
                         send_chnl_id: {
                                required:  e + "请输入正确的配送商",

                            },
                         lu_user: {
                                required:  e + "请输入正确的录入人",

                            },
                         send_dt: {
                                required:  e + "请输入正确的发货日期",

                            },
                         bill_st_id: {
                                required:  e + "请输入正确的订单状态",

                            },
                         staff_user: {
                                required:  e + "请输入正确的操作人",

                            },
                         crt_dt: {
                                required:  e + "请输入正确的创建日期",

                            },
                         prov_id: {
                                required:  e + "请输入正确的省级",

                            },
                         user_remark: {
                                required:  e + "请输入正确的用户备注",

                            },
                         remarks: {
                                required:  e + "请输入正确的系统备注",

                            },
                         send_st: {
                                required:  e + "请输入正确的配送状态",

                            },
                         send_user: {
                                required:  e + "请输入正确的配送操作人",

                            },
                         send_cre_dt: {
                                required:  e + "请输入正确的配送时间",

                            },
                         send_remark: {
                                required:  e + "请输入正确的配送备注",

                            },
                         total_num: {
                                required:  e + "请输入正确的总量",

                            },
                         card_no: {
                                required:  e + "请输入正确的水卡卡号",

                            },
                         src_bill_no: {
                                required:  e + "请输入正确的原始单号",

                            },
                         new_area_desc: {
                                required:  e + "请输入正确的全部地址",

                            },
                         xyd_st_id: {
                                required:  e + "请输入正确的删除状态",

                            },
                         xyd_cre_dt: {
                                required:  e + "请输入正确的创建日期",

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

layui.use('table', function(){
 var table = layui.table;
   var tableData=new Array();

  table.render({
    elem: Bs_billParamTable1
    ,data: tableData
    ,even:true
    ,height: 520
    ,id:"Bs_billParamTable1"
    ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
      layout: [ 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
      //,curr: 5 //设定初始在第 5 页
          ,limits: [30,60]
          ,limit: 30
      ,groups: 1 //只显示 1 个连续页码
      ,first: false //不显示首页
      ,last: false //不显示尾页

    }
    ,cols: [[
    {type:'checkbox', fixed: 'left'}

      ,{field:'shop_id',width:120,title: '商品ID',align:'center',fixed: '',sort: true }
      ,{field:'shop_no',width:120,title: '商品编码',align:'center',fixed: '',sort: true }
      ,{field:'shop_nm',width:120,title: '商品名称',align:'center',fixed: '',sort: true }
      ,{field:'shop_weigth',width:120,title: '商品重量',align:'center',fixed: '',sort: true }
      ,{field:'shop_spec',width:120,title: '商品规格',align:'center',fixed: '',sort: true }
      ,{field:'shop_no_num',width:120,title: '商品条码',align:'center',fixed: '',sort: true }
      ,{field:'shop_unit',width:120,title: '商品单位',align:'center',fixed: '',sort: true }
,{field:'num',fixed: 'right',title : '数量',width:120, align:'center', edit:'text',}
    ]]

  });
});


layui.use('table', function(){
  var table = layui.table;
  //监听工具条
  table.on('tool(test)', function(obj){
    var data = obj.data;
    if(obj.event === 'edit'){



    } else if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
        obj.del();
        layer.close(index);
      });

    } else if(obj.event === 'detail'){






    }

  });


  //复选框选中操作
  var $ = layui.$, active = {
    getCheckData: function(){ //获取选中数据

    }
    ,getCheckLength: function(){ //获取选中数目

    }
    ,isAll: function(){ //验证是否全选

    }
  };

  $('.demoTable .layui-btn').on('click', function(){
    var type = $(this).data('type');
    active[type] ? active[type].call(this) : '';
  });







/**
 * 点击添加订单
 */
$('#add_some').on('click', function () {
    var selectContent2 = layui.table.cache.Bs_billParamTable1;
          var arr = selectContent2;
          var removeItem ="";
          selectContent1 = $.grep(selectContent2, function(value) {
              return value != removeItem;
          });
          console.log(selectContent1)
          var some =selectContent1.length;
          var strs="0,";
          for (var i = 0; i < some; i++) {

              var obj =selectContent1[i].shop_id;
              strs+=obj+",";
          }

    layer.open({
        type: 2,
        title: '添加订单',
        area: ['100%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/bs_bill/bs_bill_addParam/'+strs
    });

});



/**
 * 删除订单
 */

var checkedArr=[];
  $("#delete_all").click(function(){

        var checkStatus = table.checkStatus('Bs_billParamTable1')
            ,data = checkStatus.data, tmpArr = [], ids = [];

        var na = data.map(function(v){return v.shop_id;});
        var zh=na.join();
        console.log(zh);
        var nnn= na.length;
        var arr1 = layui.table.cache.Bs_billParamTable1;

        var arr = arr1.filter(function (item) {
            return na.indexOf(item.shop_id) < 0;
        })
        console.log(arr);
        if (data.length == 0){
            layui.layer.msg('请选择要删除行');
            return;
        }
        table.reload('Bs_billParamTable1', {
            data:arr
        });

    });









});


/**
 * 提交添加
 */
Bs_billInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();
    if ($("#access_mem").val()==""){
        return false;
    }
    if ($("#access_addr_desc").val()==""){
        return false;
    }
    if ($("#access_phone").val()==""){
        return false;
    }
    if ($("#user_remark").val()==""){
        return false;
    }
    if ($("#remarks").val()==""){
        return false;
    }
    if ($("#card_no").val()==""){
        return false;
    }
    if ($("#src_bill_no").val()==""){
        return false;
    }
    var biaoge =layui.table.cache.Bs_billParamTable1;
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/bs_bill/add", function(DATA){
        Feng.success("添加成功!");

                var ajax1 = new $ax(Feng.ctxPath + "/bs_bill/list", function(data){
                    tableData=data
                });
                 var demoReload = parent.$('#condition').val();
                ajax1.set('condition',demoReload);
                            ajax1.set('bill_st_id',parent.$('#bill_st_id').val());
                            ajax1.set('send_st',parent.$('#send_st').val());
                            ajax1.set('xyd_st_id',parent.$('#xyd_st_id').val());
                    ajax1.start();
         window.parent.layui.table.reload('Bs_billTable', {data:tableData});
        Bs_billInfoDlg.close();
    },function(DATA){
        Feng.error("添加失败!" + DATA.responseJSON.message + "!");
    });
    ajax.set('idata',JSON.stringify(this.bs_billInfoData));
          ajax.set('tdata',JSON.stringify(biaoge));
    ajax.start();
}










//修改页面
layui.use('table', function(){
    var table = layui.table;
    var tableData=new Array();
    $.ajax({
        url:Feng.ctxPath +"/bs_bill/initParam/"+$('#bill_id').val()
        ,type:"get"
        ,async:false
        ,dataType:"json"
        , success: function(result){
            tableData=result;

        }
    });
    table.render({
        elem: Bs_billParamTable3
        ,data: tableData
        ,even:true
        ,height: 520
        ,id:"Bs_billParamTable3"
        ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
            layout: [ 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
            //,curr: 5 //设定初始在第 5 页
            ,limits: [30,60]
            ,limit: 30
            ,groups: 1 //只显示 1 个连续页码
            ,first: false //不显示首页
            ,last: false //不显示尾页

        }
        ,cols: [[
           {type:'checkbox', fixed: 'left'}

             ,{field:'shop_id',width:120,title: '商品ID',align:'center',fixed: '',sort: true }
             ,{field:'shop_no',width:120,title: '商品编码',align:'center',fixed: '',sort: true }
             ,{field:'shop_nm',width:120,title: '商品名称',align:'center',fixed: '',sort: true }
             ,{field:'shop_weigth',width:120,title: '商品重量',align:'center',fixed: '',sort: true }
             ,{field:'shop_spec',width:120,title: '商品规格',align:'center',fixed: '',sort: true }
             ,{field:'shop_no_num',width:120,title: '商品条码',align:'center',fixed: '',sort: true }
             ,{field:'shop_unit',width:120,title: '商品单位',align:'center',fixed: '',sort: true }
       ,{field:'num',fixed: 'right',title : '数量',width:120, align:'center', edit:'text',}
           ]]

    });
});

layui.use('table', function(){
    var table = layui.table;
    //监听工具条
    table.on('tool(test)', function(obj){
        var data = obj.data;
        if(obj.event === 'edit'){



        } else if(obj.event === 'del'){
            layer.confirm('真的删除行么', function(index){
                obj.del();
                layer.close(index);
            });

        } else if(obj.event === 'detail'){






        }

    });


    //复选框选中操作
    var $ = layui.$, active = {
        getCheckData: function(){ //获取选中数据

        }
        ,getCheckLength: function(){ //获取选中数目

        }
        ,isAll: function(){ //验证是否全选

        }
    };

    $('.demoTable .layui-btn').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });







    /**
     * 点击添加订单
     */
    $('#add_some2').on('click', function () {
        var selectContent2 = layui.table.cache.Bs_billParamTable3;
        var arr = selectContent2;
        var removeItem ="";
        selectContent1 = $.grep(selectContent2, function(value) {
            return value != removeItem;
        });
        console.log(Bs_billParamTable3)
        var some =selectContent2.length;
        var strs="0,";
        for (var i = 0; i < some; i++) {

            var obj =selectContent1[i].shop_id;
            strs+=obj+",";
        }

        layer.open({
            type: 2,
            title: '添加订单',
            area: ['100%', '100%'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/bs_bill/bs_bill_addParam/'+strs
        });

    });



    /**
     * 删除订单
     */

    var checkedArr=[];
    $("#delete_all2").click(function(){

        var checkStatus = table.checkStatus('Bs_billParamTable3')
            ,data = checkStatus.data, tmpArr = [], ids = [];

        var na = data.map(function(v){return v.shop_id;});
        var zh=na.join();
        console.log(zh);
        var nnn= na.length;
        var arr1 = layui.table.cache.Bs_billParamTable3;

        var arr = arr1.filter(function (item) {
            return na.indexOf(item.shop_id) < 0;
        })
        console.log(arr);
        if (data.length == 0){
            layui.layer.msg('请选择要删除行');
            return;
        }
        table.reload('Bs_billParamTable3', {
            data:arr
        });

    });


});




Bs_billInfoDlg.sendUpdate= function()  {

    var send_st =  $("#sendUpdate").val();
    var sendTime = $("#sendTime").val();
    var bs_billId = $("#bill_id").val();
    var send_remark = $("#send_remark").val();
    var ajax = new $ax(Feng.ctxPath + "/bs_bill/bs_bill_sendUpdateIng/"+bs_billId, function (DATA) {
        Feng.success("更新成功!");
        var ajax1 = new $ax(Feng.ctxPath + "/bs_bill/list", function(data){
            tableData=data
        });
        ajax1.start();
        window.parent.layui.table.reload('Bs_billTable', {data:tableData});
        Bs_billInfoDlg.close();
    }, function (data) {
        Bs_billInfoDlg.close();
    });
    ajax.set("send_st",send_st);
    ajax.set("sendTime",sendTime);
    ajax.set("send_remark",send_remark);
    ajax.start();
}


//加载省份
function loadProv(){
    var ajax = new $ax(Feng.ctxPath + "/sys_area/queryProvList", function(data){
        $("#prov_id").find("option").remove();
        console.log(data)
        for (var i=0;i<data.length;i++){
            $("#prov_id").append("<option value='"+data[i].area_id+"'>"+data[i].area_nm+"</option>");
        }
    },function(data){

    });

    ajax.start();
    var key=$("#sheng").val();
    console.log(key)
    //根据值让option选中
    $("#prov_id option[value='"+key+"']").attr("selected","selected");


}

//加载城市
function loadCity(){
    loadProv()
    var ajax = new $ax(Feng.ctxPath + "/sys_area/queryCityList", function(data){
        $("#city_id").find("option").remove();
        for (var i=0;i<data.length;i++){
            $("#city_id").append("<option value='"+data[i].city_id+"'>"+data[i].city_nm+"</option>");
        }
    },function(data){

    });
    ajax.set("prov_id",($("#prov_id").val()));
    ajax.start();

}

//加载区县
function loadRegion(){
    var ajax = new $ax(Feng.ctxPath + "/sys_area/queryRegionList", function(data){

        $("#area_id").find("option").remove();

        for (var i=0;i<data.length;i++){
            if(data[i].region_id!=undefined) {
                $("#area_id").append("<option value='" + data[i].region_id + "'>" + data[i].region_nm + "</option>");
            }
        }

    },function(data){

    });
    ajax.set("city_id",($("#city_id").val()));
    ajax.start();

}

$(function () {
    loadProv();
    loadCity();
    loadRegion();
    $("#prov_id").change(function () {
        var ajax = new $ax(Feng.ctxPath + "/sys_area/queryCityList", function(data){
            $("#city_id").find("option").remove();
            $("#area_id").find("option").remove();
            for (var i=0;i<data.length;i++){
                $("#city_id").append("<option value='"+data[i].city_id+"'>"+data[i].city_nm+"</option>");
            }

        },function(data){
            Feng.error("城市加载失败!" + data.responseJSON.message + "!");
        });
        ajax.set("prov_id",($("#prov_id").val()));
        ajax.start();



        var ajax1 = new $ax(Feng.ctxPath + "/sys_area/queryRegionList", function(data){

            $("#area_id").find("option").remove();

            for (var i=0;i<data.length;i++){
                if(data[i].region_id!=undefined) {
                    $("#area_id").append("<option value='" + data[i].region_id + "'>" + data[i].region_nm + "</option>");
                }
            }

        },function(data){
            Feng.error("区县加载失败!" + data.responseJSON.message + "!");
        });
        ajax1.set("city_id",($("#city_id").val()));
        ajax1.start();



    });

    $("#city_id").change(function () {
        var ajax = new $ax(Feng.ctxPath + "/sys_area/queryRegionList", function(data){

            $("#area_id").find("option").remove();

            for (var i=0;i<data.length;i++){
                if(data[i].region_id!=undefined) {
                    $("#area_id").append("<option value='" + data[i].region_id + "'>" + data[i].region_nm + "</option>");
                }
            }

        },function(data){
            Feng.error("区县加载失败!" + data.responseJSON.message + "!");
        });
        ajax.set("city_id",($("#city_id").val()));
        ajax.start();
    });
    var key1=$("#cheng").val();
    console.log(key1)
    //根据值让option选中
    $("#city_id option[value='"+key1+"']").attr("selected","selected");

    var key2=$("#qu").val();
    console.log(key2)
    //根据值让option选中
    $("#area_id option[value='"+key2+"']").attr("selected","selected");
});




/**
 * 提交修改
 */
Bs_billInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();
    if ($("#access_mem").val()==""){
        return false;
    }
    if ($("#access_addr_desc").val()==""){
        return false;
    }
    if ($("#access_phone").val()==""){
        return false;
    }
    if ($("#user_remark").val()==""){
        return false;
    }
    if ($("#remarks").val()==""){
        return false;
    }
    if ($("#card_no").val()==""){
        return false;
    }
    if ($("#src_bill_no").val()==""){
        return false;
    }
var biaoge =layui.table.cache.Bs_billParamTable3;
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/bs_bill/update", function(DATA){
        Feng.success("修改成功!"); var ajax1 = new $ax(Feng.ctxPath + "/bs_bill/list", function(data){
          tableData=data
      });
       var demoReload = parent.$('#condition').val();
      ajax1.set('condition',demoReload);
      ajax1.set('bill_st_id',parent.$('#bill_st_id').val());
      ajax1.set('send_st',parent.$('#send_st').val());
      ajax1.set('xyd_st_id',parent.$('#xyd_st_id').val());
          ajax1.start();
window.parent.layui.table.reload('Bs_billTable', {data:tableData});
        Bs_billInfoDlg.close();
    },function(DATA){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.bs_billInfoData);
              ajax.set('tdata',JSON.stringify(biaoge));
    ajax.start();
}

function validate() {
    var e = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate({
        rules: {
            bill_id: {
                required: !0,
            },
            access_mem: {
                required: !0,
            },
            access_addr_desc: {
                required: !0,
            },
            user_remark: {
                required: !0,
            },
            access_phone: {
                required: !0,
                minlength : 11,
                isMobile : true
            },
            remarks: {
                required: !0,
            },
            card_no: {
                required: !0,
            },
            src_bill_no: {
                required: !0,
            },
        },
        messages: {
            bill_id: {
                required:  e + "请输入正确的订单ID",

            },
            access_mem: {
                required:  e + "请输入正确的收货人",

            },
            access_addr_desc: {
                required:  e + "请输入正确的收货人地址",

            },
            user_remark: {
                required:  e + "请输入正确的用户备注",

            },
            access_phone: {
                required:  e + "请输入正确的收货联系方式",
                minlength : "确认手机不能小于11个字符",
                isMobile : "请正确填写您的手机号码"
            },
            remarks: {
                required:  e + "请输入正确的系统备注",

            },
            card_no: {
                required:  e + "请输入正确的水卡卡号",

            },
            src_bill_no: {
                required:  e + "请输入正确的原始卡号",

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
}
