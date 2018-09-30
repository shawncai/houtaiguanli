/**
 * 科目管理初始化
 */
var Xgt_subject = {
    id: "Xgt_subjectTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};




layui.use('table', function(){
  var table = layui.table;
  var tableData=new Array();
  $.ajax({
      url:Feng.ctxPath +"/xgt_subject/list"
      ,type:"get"
      ,async:false
      ,dataType:"json"
      , success: function(result){
          tableData=result;

      }
  });
  table.render({
    elem: '#'+Xgt_subject.id
    ,data: tableData
    ,even:true
    ,height: 520
    ,id:"Xgt_subjectTable"
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
      ,{field:'sub_id',width:193,title: '科目',align:'center',fixed: '',sort: true }
      ,{field:'sub_nm',width:209,title: '科目名称',align:'center',fixed: '',sort: true }
      ,{field:'cpn_nm',width:226,title: '企业信息',align:'center',fixed: '',sort: true }
      ,{field:'xyd_st_id',width:163,title: '状态',align:'center',fixed: '',sort: true }
      ,{field:'xyd_cre_dt',width:226,title: '创建日期',align:'center',fixed: '',sort: true }
      ,{field:'xyd_up_dt',width:189,title: '修改日期',align:'center',fixed: '',sort: true }
      ,{field:'name',width:236,title: '操作用户',align:'center',fixed: '',sort: true }
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
  table.on('checkbox(Xgt_subjectTable)', function(obj){


  });
  //监听工具条
  table.on('tool(test)', function(obj){
    var data = obj.data;
    if(obj.event === 'edit'){
      /**
       * 打开查看科目详情_修改
       */
      Xgt_subject.seItem=data
             layer.open({
                  type: 2,
                  title: '科目详情_修改',
                  area: ['100%', '100%'], //宽高
                  fix: false, //不固定
                  maxmin: true,
                  content: Feng.ctxPath + '/xgt_subject/xgt_subject_update/' + Xgt_subject.seItem.sub_id
              });



    } else if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
        obj.del();
        layer.close(index);
      });

    } else if(obj.event === 'detail'){
      /**
       * 打开查看科目详情
       */
       Xgt_subject.seItem=data

               layer.open({
                  type: 2,
                  title: '科目详情',
                  area: ['100%', '100%'], //宽高
                  fix: false, //不固定
                  maxmin: true,
                  content: Feng.ctxPath + '/xgt_subject/xgt_subject_detail/' + Xgt_subject.seItem.sub_id
              });





    }

  });


  //复选框选中操作
  var $ = layui.$, active = {
    getCheckData: function(){ //获取选中数据

        var checkStatus = table.checkStatus(Xgt_subject.id)
      ,data = checkStatus.data;
      var arr =JSON.stringify(data);
        layer.alert(arr);
    }
    ,getCheckLength: function(){ //获取选中数目
      var checkStatus = table.checkStatus(Xgt_subject.id)
      ,data = checkStatus.data;
      layer.msg('选中了：'+ data.length + ' 个');
          if(data.length == 0){
              Feng.info("请先选中表格中的某一记录！");
              return false;
          }else{
              Xgt_subject.seItem = data[0];
              return true;
          }
    }
    ,isAll: function(){ //验证是否全选
      var checkStatus = table.checkStatus(Xgt_subject.id);
      layer.msg(checkStatus.isAll ? '全选': '未全选')
    }
  };

  $('.demoTable .layui-btn').on('click', function(){
    var type = $(this).data('type');
    active[type] ? active[type].call(this) : '';
  });







/**
 * 点击添加科目
 */
Xgt_subject.openAddXgt_subject = function () {
    var index = layer.open({
        type: 2,
        title: '添加科目',
        area: ['100%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/xgt_subject/xgt_subject_add'
    });
    this.layerIndex = index;
};



/**
 * 删除科目
 */

 layui.table.on('radio(test)', function(obj){
         var xuanzhong=obj.data;
         Xgt_subject.seItem=xuanzhong
     });
Xgt_subject.delete = function () {
var checkStatus = layui.table.checkStatus('Xgt_subjectTable');
    var data = checkStatus.data;
  var zzz = data.map(function(v){return v.sub_id;});
   var  sub_id=zzz.join();
     var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/xgt_subject/delete", function (DATA) {
            Feng.success("删除成功!");
 var tableData=new Array()
            $.ajax({
                url:Feng.ctxPath +"/xgt_subject/list"
                ,type:"get"
                ,async:false
                ,dataType:"json"
                , success: function(result){
                    tableData=result;

                }
            });
            table.reload('Xgt_subjectTable',{
                data : tableData
            });
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("xgt_subjectIds",sub_id);
        ajax.start();
    }
    	 Feng.confirm("是否刪除该科目?", operation);

};

/**
 * 查询科目列表
 */
Xgt_subject.search = function () {
     var tableData=new Array()
        var demoReload = $('#condition').val();
        var ajax = new $ax(Feng.ctxPath + "/xgt_subject/list", function(DATA){
            tableData=DATA
        });
        ajax.set('condition',demoReload);
                    ajax.set('xyd_st_id',$('#xyd_st_id').val());
            ajax.start();

            //执行重载
            table.reload('Xgt_subjectTable', {
                data:tableData
            });
};



/**
 * 导出科目
 */
Xgt_subject.export = function () {
       window.location.href=Feng.ctxPath + "/xgt_subject/export";
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