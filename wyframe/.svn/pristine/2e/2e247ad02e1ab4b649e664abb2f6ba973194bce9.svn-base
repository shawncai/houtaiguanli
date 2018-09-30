/**
 * 配送商管理初始化
 */
var Bs_send_channel = {
    id: "Bs_send_channelTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};




layui.use('table', function(){
  var table = layui.table;
  var tableData=new Array();
  $.ajax({
      url:Feng.ctxPath +"/bs_send_channel/list"
      ,type:"get"
      ,async:false
      ,dataType:"json"
      , success: function(result){
          tableData=result;

      }
  });
  table.render({
    elem: '#'+Bs_send_channel.id
    ,data: tableData
    ,even:true
    ,height: 'full-217'
    ,id:"Bs_send_channelTable"
    ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
          layout:  ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
      //,curr: 5 //设定初始在第 5 页
      //     ,limits: [30,60]
      //     ,limit: 30
      ,groups: 5 //只显示 1 个连续页码
      ,first: false //不显示首页
      ,last: false //不显示尾页

    }
    ,cols: [[
    {type:'checkbox', fixed: 'left'}
      ,{field:'send_chnl_id',width:120,title: '序号',align:'center',fixed: '',sort: true }
      ,{field:'send_chnl_no',width:120,title: '配送渠道编号',align:'center',fixed: '',sort: true }
      ,{field:'send_chnl_nm',width:207,title: '配送渠道名称',align:'center',fixed: '',sort: true }
      ,{field:'send_chnl_desc',width:207,title: '配送渠道描述',align:'center',fixed: '',sort: true }
      ,{field:'send_chnl_phoe',width:153,title: '配送渠道电话',align:'center',fixed: '',sort: true }
      ,{field:'send_chnl_num',width:120,title: '范围符',align:'center',fixed: '',sort: true }
      ,{field:'send_chnl_flg',width:120,title: '配送数量',align:'center',fixed: '',sort: true }
      ,{field:'xyd_st_id',width:186,title: '删除状态',align:'center',fixed: '',sort: true }
      ,{field:'xyd_cre_dt',width:186,title: '创建日期',align:'center',fixed: '',sort: true }
      ,{field:'xyd_up_dt',width:186,title: '修改日期',align:'center',fixed: '',sort: true }
      ,{field:'name',width:120,title: '操作用户',align:'center',fixed: '',sort: true }
      ,{fixed: 'right',title : '操作',width:120, align:'center', toolbar: '#barDemo',}

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
  table.on('checkbox(Bs_send_channelTable)', function(obj){


  });
  //监听工具条
  table.on('tool(test)', function(obj){
    var data = obj.data;
    if(obj.event === 'edit'){
      /**
       * 打开查看配送商详情_修改
       */
      Bs_send_channel.seItem=data
             layer.open({
                  type: 2,
                  title: '配送商详情_修改',
                  area: ['100%', '100%'], //宽高
                  fix: false, //不固定
                  maxmin: true,
                  content: Feng.ctxPath + '/bs_send_channel/bs_send_channel_update/' + Bs_send_channel.seItem.send_chnl_id
              });



    } else if(obj.event === 'choice'){
        Bs_send_channel.seItem=data

        layer.open({
            type: 2,
            title: '区域选择详情',
            area: ['400px', '700px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/bs_send_channel/area_assign/' + Bs_send_channel.seItem.send_chnl_id
        });


    } else if(obj.event === 'detail'){
      /**
       * 打开查看配送商详情
       */
       Bs_send_channel.seItem=data

               layer.open({
                  type: 2,
                  title: '配送商详情',
                  area: ['100%', '100%'], //宽高
                  fix: false, //不固定
                  maxmin: true,
                  content: Feng.ctxPath + '/bs_send_channel/bs_send_channel_detail/' + Bs_send_channel.seItem.send_chnl_id
              });





    }

  });


  //复选框选中操作
  var $ = layui.$, active = {
    getCheckData: function(){ //获取选中数据

        var checkStatus = table.checkStatus(Bs_send_channel.id)
      ,data = checkStatus.data;
      var arr =JSON.stringify(data);
        layer.alert(arr);
    }
    ,getCheckLength: function(){ //获取选中数目
      var checkStatus = table.checkStatus(Bs_send_channel.id)
      ,data = checkStatus.data;
      layer.msg('选中了：'+ data.length + ' 个');
          if(data.length == 0){
              Feng.info("请先选中表格中的某一记录！");
              return false;
          }else{
              Bs_send_channel.seItem = data[0];
              return true;
          }
    }
    ,isAll: function(){ //验证是否全选
      var checkStatus = table.checkStatus(Bs_send_channel.id);
      layer.msg(checkStatus.isAll ? '全选': '未全选')
    }
  };

  $('.demoTable .layui-btn').on('click', function(){
    var type = $(this).data('type');
    active[type] ? active[type].call(this) : '';
  });







/**
 * 点击添加配送商
 */
Bs_send_channel.openAddBs_send_channel = function () {
    var index = layer.open({
        type: 2,
        title: '添加配送商',
        area: ['100%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/bs_send_channel/bs_send_channel_add'
    });
    this.layerIndex = index;
};



/**
 * 删除配送商
 */

 layui.table.on('radio(test)', function(obj){
         var xuanzhong=obj.data;
         Bs_send_channel.seItem=xuanzhong
     });
Bs_send_channel.delete = function () {
var checkStatus = layui.table.checkStatus('Bs_send_channelTable');
    var data = checkStatus.data;
  var zzz = data.map(function(v){return v.send_chnl_id;});
   var  send_chnl_id=zzz.join();
     var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/bs_send_channel/delete", function (DATA) {
            Feng.success("删除成功!");
 var tableData=new Array()
            $.ajax({
                url:Feng.ctxPath +"/bs_send_channel/list"
                ,type:"get"
                ,async:false
                ,dataType:"json"
                , success: function(result){
                    tableData=result;

                }
            });
            table.reload('Bs_send_channelTable',{
                data : tableData
            });
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("bs_send_channelIds",send_chnl_id);
        ajax.start();
    }
    	 Feng.confirm("是否刪除该配送商?", operation);

};

/**
 * 查询配送商列表
 */
Bs_send_channel.search = function () {
     var tableData=new Array()
        var demoReload = $('#condition').val();
        var ajax = new $ax(Feng.ctxPath + "/bs_send_channel/list", function(DATA){
            tableData=DATA
        });
        ajax.set('condition',demoReload);
                    ajax.set('xyd_st_id',$('#xyd_st_id').val());
            ajax.start();

            //执行重载
            table.reload('Bs_send_channelTable', {
                data:tableData
            });
};



/**
 * 导出配送商
 */
Bs_send_channel.export = function () {
       window.location.href=Feng.ctxPath + "/bs_send_channel/export";
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
