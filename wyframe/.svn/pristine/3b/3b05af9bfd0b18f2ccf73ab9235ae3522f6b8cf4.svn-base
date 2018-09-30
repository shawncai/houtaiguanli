/**
 * 订单管理初始化
 */
var Bs_bill = {
    id: "Bs_billTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};




layui.use('table', function(){
  var table = layui.table;
  var tableData=new Array();
  $.ajax({
      url:Feng.ctxPath +"/bs_bill/list"
      ,type:"get"
      ,async:false
      ,dataType:"json"
      , success: function(result){
          tableData=result;

      }
  });
  table.render({
    elem:Bs_billTable
    ,data: tableData
    ,even:true
    ,height: 'full-217'
    ,id:"Bs_billTable"
    ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
          layout:  ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
      //,curr: 5 //设定初始在第 5 页
      ,groups: 5 //只显示 1 个连续页码
      ,first: false //不显示首页
      ,last: false //不显示尾页

    }
    ,cols: [[
    {type:'checkbox', fixed: 'left'}

            ,{field:'bill_id',width:120,title: '订单序号',align:'center',fixed: 'left',sort: true }
            ,{field:'bill_no',width:252,title: '订单编号',align:'center',fixed: 'left',sort: true }
            ,{field:'buy_dt',width:190,title: '下单日期',align:'center',fixed: '',sort: true }
            ,{field:'pay_dt',width:190,title: '支付日期',align:'center',fixed: '',sort: true }
            ,{field:'total_money',width:120,title: '总金额',align:'center',fixed: '',sort: true }
            ,{field:'access_mem',width:120,title: '收货人',align:'center',fixed: '',sort: true }
            ,{field:'access_addr_desc',width:390,title: '收货人地址',align:'center',fixed: '',sort: true }
            ,{field:'access_phone',width:120,title: '收货人电话',align:'center',fixed: '',sort: true }
            ,{field:'area_nm',width:120,title: '地区',align:'center',fixed: '',sort: true }
            ,{field:'send_chnl_nm',width:210,title: '配送商',align:'center',fixed: '',sort: true }
            ,{field:'lu_user',width:120,title: '录入人',align:'center',fixed: '',sort: true }
            ,{field:'send_dt',width:120,title: '发货日期',align:'center',fixed: '',sort: true }
            ,{field:'bill_st_id',width:120,title: '订单状态',align:'center',fixed: '',sort: true }
            ,{field:'staff_user',width:120,title: '操作人',align:'center',fixed: '',sort: true }
            ,{field:'crt_dt',width:190,title: '创建日期',align:'center',fixed: '',sort: true }
            ,{field:'prov_nm',width:120,title: '省级',align:'center',fixed: '',sort: true }
            ,{field:'user_remark',width:195,title: '用户备注',align:'center',fixed: '',sort: true }
            ,{field:'remarks',width:195,title: '系统备注',align:'center',fixed: '',sort: true }
            ,{field:'send_st',width:195,title: '配送状态',align:'center',fixed: '',sort: true }
            ,{field:'name',width:120,title: '配送操作人',align:'center',fixed: '',sort: true }
            ,{field:'send_cre_dt',width:120,title: '配送时间',align:'center',fixed: '',sort: true }
            ,{field:'send_remark',width:190,title: '配送备注',align:'center',fixed: '',sort: true }
            ,{field:'total_num',width:120,title: '总量',align:'center',fixed: '',sort: true }
            ,{field:'card_no',width:220,title: '水卡卡号',align:'center',fixed: '',sort: true }
            ,{field:'src_bill_no',width:250,title: '原始单号',align:'center',fixed: '',sort: true }
            ,{field:'new_area_desc',width:390,title: '全部地址',align:'center',fixed: '',sort: true }
            ,{field:'xyd_st_id',width:120,title: '删除状态',align:'center',fixed: '',sort: true }
            ,{field:'xyd_cre_dt',width:190,title: '创建日期',align:'center',fixed: '',sort: true }
,{fixed: 'right',title : '操作',width:180, align:'center', toolbar: '#barDemo',}
    ]]
    ,done: function(res, curr, count){
    //如果是异步请求数据方式，res即为你接口返回的信息。
    //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
    //console.log(res);
    //得到当前页码
    //  console.log(curr);
    //得到数据总量
    // console.log(count);
    }
  });
});


layui.use('table', function(){
  var table = layui.table;
  //监听表格复选框选择
  table.on('checkbox(Bs_billTable)', function(obj){


  });
  //监听工具条
  table.on('tool(test)', function(obj){
    var data = obj.data;
    if(obj.event === 'edit'){
      /**
       * 打开查看订单详情_修改
       */
      Bs_bill.seItem=data
             layer.open({
                  type: 2,
                  title: '订单详情_修改',
                  area: ['100%', '100%'], //宽高
                  fix: false, //不固定
                  maxmin: true,
                  content: Feng.ctxPath + '/bs_bill/bs_bill_update/' + Bs_bill.seItem.bill_id
              });



    } else if(obj.event === 'song'){

        /**
         * 配送更新
         */
        console.log(data);
        console.log(data.send_st);
        Bs_bill.seItem=data
            if (data.send_st!="配送完成") {
                layer.open({
                    type: 2,
                    title: '配送更新',
                    area: ['40%', '60%'], //宽高
                    fix: false, //不固定
                    maxmin: true,
                    content: Feng.ctxPath + '/bs_bill/bs_bill_sendUpdate/' + Bs_bill.seItem.bill_id
                });

            }else{
                Feng.error("订单已配送完成不能更新!");
            }


    } else if(obj.event === 'detail'){
      /**
       * 打开查看订单详情
       */
       Bs_bill.seItem=data

               layer.open({
                  type: 2,
                  title: '订单详情',
                  area: ['100%', '100%'], //宽高
                  fix: false, //不固定
                  maxmin: true,
                  content: Feng.ctxPath + '/bs_bill/bs_bill_detail/' + Bs_bill.seItem.bill_id
              });
    }

    else if(obj.event === 'print'){
        /**
         * 打开打印订单详情
         */
        Bs_bill.seItem=data
        layer.open({
            type: 2,
            title: '订单打印',
            area: ['100%', '100%'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/bs_bill/bs_bill_print/' + Bs_bill.seItem.bill_id
        });
    }

  });



  //复选框选中操作
  var $ = layui.$, active = {
    getCheckData: function(){ //获取选中数据

        var checkStatus = table.checkStatus(Bs_bill.id)
      ,data = checkStatus.data;
      var arr =JSON.stringify(data);
        layer.alert(arr);
    }
    ,getCheckLength: function(){ //获取选中数目
      var checkStatus = table.checkStatus(Bs_bill.id)
      ,data = checkStatus.data;
      layer.msg('选中了：'+ data.length + ' 个');
          if(data.length == 0){
              Feng.info("请先选中表格中的某一记录！");
              return false;
          }else{
              Bs_bill.seItem = data[0];
              return true;
          }
    }
    ,isAll: function(){ //验证是否全选
      var checkStatus = table.checkStatus(Bs_bill.id);
      layer.msg(checkStatus.isAll ? '全选': '未全选')
    }
  };

  $('.demoTable .layui-btn').on('click', function(){
    var type = $(this).data('type');
    active[type] ? active[type].call(this) : '';
  });







/**
 * 点击添加订单
 */
Bs_bill.openAddBs_bill = function () {
    var index = layer.open({
        type: 2,
        title: '添加订单',
        area: ['100%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/bs_bill/bs_bill_add'
    });
    this.layerIndex = index;
};



/**
 * 删除订单
 */


Bs_bill.delete = function () {
var checkStatus = layui.table.checkStatus('Bs_billTable');
    var data = checkStatus.data;
  var zzz = data.map(function(v){return v.bill_id;});
   var  bill_id=zzz.join();
     var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/bs_bill/delete", function (DATA) {
            Feng.success("删除成功!");
 var tableData=new Array()
            $.ajax({
                url:Feng.ctxPath +"/bs_bill/list"
                ,type:"get"
                ,async:false
                ,dataType:"json"
                , success: function(result){
                    tableData=result;

                }
            });
            table.reload('Bs_billTable',{
                data : tableData
            });
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("bs_billIds",bill_id);
        ajax.start();
    }
    	 Feng.confirm("是否刪除该订单?", operation);

};


/**
 * 查询订单列表
 */
Bs_bill.search = function () {
     var tableData=new Array()
        var demoReload = $('#condition').val();
        var ajax = new $ax(Feng.ctxPath + "/bs_bill/list", function(DATA){
            tableData=DATA
        });
        ajax.set('condition',demoReload);
                    ajax.set('bill_st_id',$('#bill_st_id').val());
                    ajax.set('send_st',$('#send_st').val());
                    ajax.set('xyd_st_id',$('#xyd_st_id').val());
            ajax.start();

            //执行重载
            table.reload('Bs_billTable', {
                data:tableData
            });
};

    /**
     * 打开打印订单
     */


    Bs_bill.openPrint = function () {
        var checkStatus = layui.table.checkStatus('Bs_billTable');
        var data = checkStatus.data;
        var zzz = data.map(function(v){return v.bill_id;});
        var  bill_id=zzz.join();
            var index = layer.open({
                type: 2,
                title: '打印订单',
                area: ['100%', '100%'], //宽高
                fix: false, //不固定
                maxmin: true,
                content: Feng.ctxPath + '/bs_bill/bs_bill_print/' + bill_id
            });
            this.layerIndex = index;


    }

/**
 * 导出订单
 */

Bs_bill.export = function () {
       window.location.href=Feng.ctxPath + "/bs_bill/export";
};




});

layui.use('laydate', function(){
    var laydate = layui.laydate;

    //执行一个laydate实例
    laydate.render({
        elem: '#hello', //指定元素
        type: 'datetime',

    });
});
