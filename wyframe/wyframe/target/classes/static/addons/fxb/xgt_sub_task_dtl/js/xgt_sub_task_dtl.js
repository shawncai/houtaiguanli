/**
 * 任务详情管理初始化
 */
var Xgt_sub_task_dtl = {
    id: "Xgt_sub_task_dtlTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};




layui.use('table', function(){
  var table = layui.table;
  var tableData=new Array();
  $.ajax({
      url:Feng.ctxPath +"/xgt_sub_task_dtl/list"
      ,type:"get"
      ,async:false
      ,dataType:"json"
      , success: function(result){
          tableData=result;

      }
  });
  table.render({
    elem: '#'+Xgt_sub_task_dtl.id
    ,data: tableData
    ,even:true
    ,height: 520
    ,id:"Xgt_sub_task_dtlTable"
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
      ,{field:'task_dtl_id',width:120,title: '任务详情',align:'center',fixed: '',sort: true }
      ,{field:'name',width:120,title: '用户名称',align:'center',fixed: '',sort: true }
      ,{field:'sub_qp_id',width:120,title: '题目',align:'center',fixed: '',sort: true }
      ,{field:'task_obj_id',width:120,title: '作业对象',align:'center',fixed: '',sort: true }
      ,{field:'user_ask',width:120,title: '答案',align:'center',fixed: '',sort: true }
      ,{field:'right_ask',width:120,title: '正确答案',align:'center',fixed: '',sort: true }
      ,{field:'right_errof_flg',width:120,title: '正确与否   ',align:'center',fixed: '',sort: true }
      ,{field:'mdi_dt',width:120,title: '变更时间',align:'center',fixed: '',sort: true }
      ,{field:'cre_dt',width:120,title: '创建时间',align:'center',fixed: '',sort: true }
      ,{field:'cpn_nm',width:120,title: '企业信息',align:'center',fixed: '',sort: true }
      ,{field:'st_id',width:161,title: '状态',align:'center',fixed: '',sort: true }
      ,{fixed: 'right',title : '操作',width:174, align:'center', toolbar: '#barDemo',}

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
  table.on('checkbox(Xgt_sub_task_dtlTable)', function(obj){


  });
  //监听工具条
  table.on('tool(test)', function(obj){
    var data = obj.data;
    if(obj.event === 'edit'){
      /**
       * 打开查看任务详情详情_修改
       */
      Xgt_sub_task_dtl.seItem=data
             layer.open({
                  type: 2,
                  title: '任务详情详情_修改',
                  area: ['100%', '100%'], //宽高
                  fix: false, //不固定
                  maxmin: true,
                  content: Feng.ctxPath + '/xgt_sub_task_dtl/xgt_sub_task_dtl_update/' + Xgt_sub_task_dtl.seItem.task_dtl_id
              });



    } else if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
        obj.del();
        layer.close(index);
      });

    } else if(obj.event === 'detail'){
      /**
       * 打开查看任务详情详情
       */
       Xgt_sub_task_dtl.seItem=data

               layer.open({
                  type: 2,
                  title: '任务详情详情',
                  area: ['100%', '100%'], //宽高
                  fix: false, //不固定
                  maxmin: true,
                  content: Feng.ctxPath + '/xgt_sub_task_dtl/xgt_sub_task_dtl_detail/' + Xgt_sub_task_dtl.seItem.task_dtl_id
              });





    }

  });


  //复选框选中操作
  var $ = layui.$, active = {
    getCheckData: function(){ //获取选中数据

        var checkStatus = table.checkStatus(Xgt_sub_task_dtl.id)
      ,data = checkStatus.data;
      var arr =JSON.stringify(data);
        layer.alert(arr);
    }
    ,getCheckLength: function(){ //获取选中数目
      var checkStatus = table.checkStatus(Xgt_sub_task_dtl.id)
      ,data = checkStatus.data;
      layer.msg('选中了：'+ data.length + ' 个');
          if(data.length == 0){
              Feng.info("请先选中表格中的某一记录！");
              return false;
          }else{
              Xgt_sub_task_dtl.seItem = data[0];
              return true;
          }
    }
    ,isAll: function(){ //验证是否全选
      var checkStatus = table.checkStatus(Xgt_sub_task_dtl.id);
      layer.msg(checkStatus.isAll ? '全选': '未全选')
    }
  };

  $('.demoTable .layui-btn').on('click', function(){
    var type = $(this).data('type');
    active[type] ? active[type].call(this) : '';
  });







/**
 * 点击添加任务详情
 */
Xgt_sub_task_dtl.openAddXgt_sub_task_dtl = function () {
    var index = layer.open({
        type: 2,
        title: '添加任务详情',
        area: ['100%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/xgt_sub_task_dtl/xgt_sub_task_dtl_add'
    });
    this.layerIndex = index;
};



/**
 * 删除任务详情
 */

 layui.table.on('radio(test)', function(obj){
         var xuanzhong=obj.data;
         Xgt_sub_task_dtl.seItem=xuanzhong
     });
Xgt_sub_task_dtl.delete = function () {
var checkStatus = layui.table.checkStatus('Xgt_sub_task_dtlTable');
    var data = checkStatus.data;
  var zzz = data.map(function(v){return v.task_dtl_id;});
   var  task_dtl_id=zzz.join();
     var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/xgt_sub_task_dtl/delete", function (DATA) {
            Feng.success("删除成功!");
 var tableData=new Array()
            $.ajax({
                url:Feng.ctxPath +"/xgt_sub_task_dtl/list"
                ,type:"get"
                ,async:false
                ,dataType:"json"
                , success: function(result){
                    tableData=result;

                }
            });
            table.reload('Xgt_sub_task_dtlTable',{
                data : tableData
            });
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("xgt_sub_task_dtlIds",task_dtl_id);
        ajax.start();
    }
    	 Feng.confirm("是否刪除该任务详情?", operation);

};

/**
 * 查询任务详情列表
 */
Xgt_sub_task_dtl.search = function () {
     var tableData=new Array()
        var demoReload = $('#condition').val();
        var ajax = new $ax(Feng.ctxPath + "/xgt_sub_task_dtl/list", function(DATA){
            tableData=DATA
        });
        ajax.set('condition',demoReload);
                    ajax.set('st_id',$('#st_id').val());
            ajax.start();

            //执行重载
            table.reload('Xgt_sub_task_dtlTable', {
                data:tableData
            });
};



/**
 * 导出任务详情
 */
Xgt_sub_task_dtl.export = function () {
       window.location.href=Feng.ctxPath + "/xgt_sub_task_dtl/export";
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