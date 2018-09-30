/**
 * 商品测试管理初始化
 */
var Xgt_goods_products = {
    id: "Xgt_goods_productsTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};




layui.use('table', function(){
  var table = layui.table;

  table.render({
    elem: '#'+Xgt_goods_products.id
    ,url: Feng.ctxPath +"/xgt_goods_products/backContent"
      ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
          layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
          //,curr: 5 //设定初始在第 5 页
          ,groups: 1 //只显示 1 个连续页码
          ,first: false //不显示首页
          ,last: false //不显示尾页

      }
    ,even:true
    ,height: 520
    ,id:"Xgt_goods_productsTable"
      ,cols: [[
          {type:'checkbox', fixed: 'left'}
          ,{fixed: 'left',title : '操作',width:120, align:'center', toolbar: '#barDemo',}
          ,{title: '分类键值', field: 'prd_cls_id',width:70,align:'center',fixed: 'left',sort: true }
          ,{title: '分类名称', field: 'prd_cls_nm',width:120,align:'center',fixed: 'left',sort: true }
          ,{title: '上级分类', field: 'par_prd_cls_nm',width:120,align:'center',fixed: '',sort: true }
          ,{title: '分类代码', field: 'cls_code',width:120,align:'center',fixed: '',sort: true }
          ,{title: '是否序列号', field: 'sn_flg',width:120,align:'center',fixed: '',event:'zhuanhua',sort: true }
          ,{title: '物品数量', field: 'num',width:120,align:'center',fixed: '',sort: true }
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
  table.on('checkbox(Xgt_goods_productsTable)', function(obj){


  });
  //监听工具条
  table.on('tool(test)', function(obj){
    var data = obj.data;
    if(obj.event === 'edit'){
      /**
       * 打开查看商品测试详情_修改
       */
      Xgt_goods_products.seItem=data
             layer.open({
                  type: 2,
                  title: '商品测试详情_修改',
                  area: ['100%', '100%'], //宽高
                  fix: false, //不固定
                  maxmin: true,
                  content: Feng.ctxPath + '/xgt_goods_products/xgt_goods_products_update/' + Xgt_goods_products.seItem.prd_id
              });



    } else if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
        obj.del();
        layer.close(index);
      });

    } else if(obj.event === 'detail'){
      /**
       * 打开查看商品测试详情
       */
       Xgt_goods_products.seItem=data

               layer.open({
                  type: 2,
                  title: '商品测试详情',
                  area: ['100%', '100%'], //宽高
                  fix: false, //不固定
                  maxmin: true,
                  content: Feng.ctxPath + '/xgt_goods_products/xgt_goods_products_detail/' + Xgt_goods_products.seItem.prd_id
              });

        if(obj.event === 'zhuanhua'){
           var seItem=data
            console.log(data)



        }

    }





  });


  //复选框选中操作
  var $ = layui.$, active = {
    getCheckData: function(){ //获取选中数据

        var checkStatus = table.checkStatus(Xgt_goods_products.id)
      ,data = checkStatus.data;
      var arr =JSON.stringify(data);
        layer.alert(arr);
    }
    ,getCheckLength: function(){ //获取选中数目
      var checkStatus = table.checkStatus(Xgt_goods_products.id)
      ,data = checkStatus.data;
      layer.msg('选中了：'+ data.length + ' 个');
          if(data.length == 0){
              Feng.info("请先选中表格中的某一记录！");
              return false;
          }else{
              Xgt_goods_products.seItem = data[0];
              return true;
          }
    }
    ,isAll: function(){ //验证是否全选
      var checkStatus = table.checkStatus(Xgt_goods_products.id);
      layer.msg(checkStatus.isAll ? '全选': '未全选')
    }
  };

  $('.demoTable .layui-btn').on('click', function(){
    var type = $(this).data('type');
    active[type] ? active[type].call(this) : '';
  });







/**
 * 点击添加商品测试
 */
Xgt_goods_products.openAddXgt_goods_products = function () {
    var index = layer.open({
        type: 2,
        title: '添加商品测试',
        area: ['100%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/xgt_goods_products/xgt_goods_products_add'
    });
    this.layerIndex = index;
};



/**
 * 删除商品测试
 */

 layui.table.on('radio(test)', function(obj){
         var xuanzhong=obj.data;
         Xgt_goods_products.seItem=xuanzhong
     });
Xgt_goods_products.delete = function () {
var checkStatus = layui.table.checkStatus('Xgt_goods_productsTable');
    var data = checkStatus.data;
  var zzz = data.map(function(v){return v.prd_id;});
   var  prd_id=zzz.join();
     var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/xgt_goods_products/delete", function (DATA) {
            Feng.success("删除成功!");
 var tableData=new Array()
            $.ajax({
                url:Feng.ctxPath +"/xgt_goods_products/list"
                ,type:"get"
                ,async:false
                ,dataType:"json"
                , success: function(result){
                    tableData=result;

                }
            });
            table.reload('Xgt_goods_productsTable',{
                data : tableData
            });
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("xgt_goods_productsIds",prd_id);
        ajax.start();
    }
    	 Feng.confirm("是否刪除该商品测试?", operation);

};

/**
 * 查询商品测试列表
 */
Xgt_goods_products.search = function () {
     var tableData=new Array()
        var demoReload = $('#condition').val();
        var ajax = new $ax(Feng.ctxPath + "/xgt_goods_products/list", function(DATA){
            tableData=DATA
        });
        ajax.set('condition',demoReload);
                    ajax.set('xyd_st_id',$('#xyd_st_id').val());
            ajax.start();

            //执行重载
            table.reload('Xgt_goods_productsTable', {
                data:tableData
            });
};



/**
 * 导出商品测试
 */
Xgt_goods_products.export = function () {
       window.location.href=Feng.ctxPath + "/xgt_goods_products/export";
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


layui.use(['tree', 'layer'], function(){
    'use strict';
    var tableData='';
    $.ajax({
        url:Feng.ctxPath +"/xgt_goods_products/bulidJsonTree"
        ,type:"get"
        ,async:false
        ,dataType:"json"
        , success: function(result){
            tableData=JSON.parse(result)
        }
    });
    console.log(tableData)



    layui.tree({
        elem: '#demo1' //指定元素
        ,click: function(item){ //点击节点回调
                var ajax = new $ax(Feng.ctxPath + "/xgt_goods_products/bulidJson", function (MDATA) {
                    Feng.success("成功!");
                    console.log(MDATA.data)

                    layui.use('table', function(){
                        var table = layui.table;

                        table.render({
                            elem: '#'+Xgt_goods_products.id
                            ,data:MDATA.data
                            ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                                layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
                                //,curr: 5 //设定初始在第 5 页
                                ,groups: 1 //只显示 1 个连续页码
                                ,first: false //不显示首页
                                ,last: false //不显示尾页

                            }
                            ,even:true
                            ,height: 520
                            ,id:"Xgt_goods_productsTable"
                            ,cols: [[
                                {type:'checkbox', fixed: 'left'}
                                ,{fixed: 'left',title : '操作',width:120, align:'center', toolbar: '#barDemo',}
                                ,{title: '分类键值', field: 'prd_cls_id',width:70,align:'center',fixed: 'left',sort: true }
                                ,{title: '分类名称', field: 'prd_cls_nm',width:120,align:'center',fixed: 'left',sort: true }
                                ,{title: '上级分类', field: 'par_prd_cls_nm',width:120,align:'center',fixed: '',sort: true }
                                ,{title: '分类代码', field: 'cls_code',width:120,align:'center',fixed: '',sort: true }
                                ,{title: '是否序列号', field: 'sn_flg',width:120,align:'center',fixed: '',sort: true }
                                ,{title: '物品数量', field: 'num',width:120,align:'center',fixed: '',sort: true }
                            ]]
                        });
                    });




                }, function (MDATA) {
                    Feng.error("失败!" + MDATA.responseJSON.message + "!");
                });
                ajax.set('id',item.id);
            ajax.set('limit',10)
            ajax.start();


            console.log(item.id)
        }
        ,nodes:tableData
    });



});

