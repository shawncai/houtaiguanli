/**
 * 商品管理初始化
 */
var Xyd_shop = {
    id: "Xyd_shopTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};




layui.use('table', function(){
  var table = layui.table;
  var tableData=new Array()
  $.ajax({
      url:Feng.ctxPath +"/xyd_shop/list"
      ,type:"get"
      ,async:false
      ,dataType:"json"
      , success: function(result){
          tableData=result;

      }
  });
  table.render({
    elem: '#'+Xyd_shop.id
    ,data: tableData
    ,even:true
    ,height: 520
    ,id:"Xyd_shopTable"
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
     ,{fixed: 'left',title : '操作',width:200, align:'center', toolbar: '#barDemo',}
      ,{field:'shop_id',width:100,title: '商品ID',align:'center',fixed: 'left',sort: true}
      ,{field:'shop_no',width:100,title: '商品编码',align:'center',fixed: 'left',sort: true}
      ,{field:'shop_nm',width:120,title: '商品名称',align:'center',fixed: '',sort: true}
      ,{field:'shop_weigth',width:180,title: '商品重量',align:'center',fixed: 'left',sort: true}
      ,{field:'shop_spec_id',width:180,title: '商品规格',align:'center',fixed: '',sort: true}
      ,{field:'shop_no_num',width:180,title: '商品条码',align:'center',fixed: '',sort: true}
      ,{field:'shop_unit',width:180,title: '商品单位',align:'center',fixed: '',sort: true}
      ,{field:'checkbox',width:180,title: '测试',align:'center',fixed: '',sort: true}
      ,{field:'remark',width:180,title: '备注',align:'center',fixed: '',sort: true}
      ,{field:'par_shop_id',width:180,title: '上级商品',align:'center',fixed: '',sort: true}
      ,{field:'xyd_st_id',width:180,title: '删除状态',align:'center',fixed: '',sort: true}
      ,{field:'xyd_user_id',width:180,title: '操作用户',align:'center',fixed: '',sort: true}

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
  table.on('checkbox(Xyd_shopTable)', function(obj){


  });
  //监听工具条
  table.on('tool(test)', function(obj){
    var data = obj.data;
    if(obj.event === 'edit'){
      /**
       * 打开查看商品详情_修改
       */
      Xyd_shop.seItem=data
             layer.open({
                  type: 2,
                  title: '商品详情_修改',
                  area: ['100%', '100%'], //宽高
                  fix: false, //不固定
                  maxmin: true,
                  content: Feng.ctxPath + '/xyd_shop/xyd_shop_update/' + Xyd_shop.seItem.shop_id
              });



    } else if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
        obj.del();
        layer.close(index);
      });

    } else if(obj.event === 'detail'){
      /**
       * 打开查看商品详情
       */
       Xyd_shop.seItem=data

               layer.open({
                  type: 2,
                  title: '商品详情',
                  area: ['100%', '100%'], //宽高
                  fix: false, //不固定
                  maxmin: true,
                  content: Feng.ctxPath + '/xyd_shop/xyd_shop_detail/' + Xyd_shop.seItem.shop_id
              });





    }

  });


  //复选框选中操作
  var $ = layui.$, active = {
    getCheckData: function(){ //获取选中数据

        var checkStatus = table.checkStatus(Xyd_shop.id)
      ,data = checkStatus.data;
      var arr =JSON.stringify(data);
        layer.alert(arr);
    }
    ,getCheckLength: function(){ //获取选中数目
      var checkStatus = table.checkStatus(Xyd_shop.id)
      ,data = checkStatus.data;
      layer.msg('选中了：'+ data.length + ' 个');
          if(data.length == 0){
              Feng.info("请先选中表格中的某一记录！");
              return false;
          }else{
              Xyd_shop.seItem = data[0];
              return true;
          }
    }
    ,isAll: function(){ //验证是否全选
      var checkStatus = table.checkStatus(Xyd_shop.id);
      layer.msg(checkStatus.isAll ? '全选': '未全选')
    }
  };

  $('.demoTable .layui-btn').on('click', function(){
    var type = $(this).data('type');
    active[type] ? active[type].call(this) : '';
  });







/**
 * 点击添加商品
 */
Xyd_shop.openAddXyd_shop = function () {
    var index = layer.open({
        type: 2,
        title: '添加商品',
        area: ['100%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/xyd_shop/xyd_shop_add'
    });
    this.layerIndex = index;
};



/**
 * 删除商品
 */

 layui.table.on('radio(test)', function(obj){
         var xuanzhong=obj.data;
         Xyd_shop.seItem=xuanzhong
     });
Xyd_shop.delete = function () {
var checkStatus = layui.table.checkStatus('Xyd_shopTable');
    var data = checkStatus.data;
  var zzz = data.map(function(v){return v.shop_id;});
    var zh=zzz.join();
   var  shop_id=zh
     var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/xyd_shop/delete", function (DATA) {
            Feng.success("删除成功!");
 var tableData=new Array()
            $.ajax({
                url:Feng.ctxPath +"/xyd_shop/list"
                ,type:"get"
                ,async:false
                ,dataType:"json"
                , success: function(result){
                    tableData=result;

                }
            });
            table.reload('Xyd_shopTable',{
                data : tableData
            });
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("xyd_shopId",shop_id);
        ajax.start();
    }
    	 Feng.confirm("是否刪除该商品?", operation);

};

/**
 * 查询商品列表
 */
Xyd_shop.search = function () {
     var tableData=new Array()
        var demoReload = $('#condition').val();
        var ajax = new $ax(Feng.ctxPath + "/xyd_shop/list", function(DATA){
            tableData=DATA
        });
        ajax.set('condition',demoReload);
            ajax.start();

            //执行重载
            table.reload('Xyd_shopTable', {
                data:tableData
            });
};



/**
 * 导出商品
 */
Xyd_shop.export = function () {
       window.location.href=Feng.ctxPath + "/xyd_shop/export";
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
