/**
 * 试卷管理初始化
 */
var Xgt_sub_exam = {
    id: "Xgt_sub_examTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};







layui.use('table', function(){
  var table = layui.table;
  table.render({
    elem: '#'+Xgt_sub_exam.id
    ,url: Feng.ctxPath +"/xgt_sub_exam/backContent"
    ,even:true
    ,height: 520
    ,id:"Xgt_sub_examTable"
   ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
            layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
            //,curr: 5 //设定初始在第 5 页
            ,groups: 1 //只显示 1 个连续页码
            ,first: false //不显示首页
            ,last: false //不显示尾页

        }
    ,cols: [[
    {type:'checkbox', fixed: 'left'}
      ,{field:'sub_exam_id',width:120,title: '试卷ID ',align:'center',fixed: 'left',sort: true }
      ,{field:'sub_exam_nm',width:120,title: '试卷名称',align:'center',fixed: '',sort: true }
      ,{field:'par_sub_exam_nm',width:120,title: '上级试卷名称',align:'center',fixed: '',sort: true }
      ,{field:'sub_nm',width:120,title: '科目ID',align:'center',fixed: '',sort: true }
      ,{field:'name',width:120,title: '用户ID',align:'center',fixed: '',sort: true }
      ,{field:'sub_exam_no',width:120,title: '试卷编号',align:'center',fixed: '',sort: true }
      ,{field:'one_sel_sum',width:120,title: '单选数量',align:'center',fixed: '',sort: true }
      ,{field:'more_sel_sum',width:120,title: '多选数量',align:'center',fixed: '',sort: true }
      ,{field:'yes_no_sum',width:120,title: '判断题数量',align:'center',fixed: '',sort: true }
      ,{field:'insert_sum',width:120,title: '填空题数量',align:'center',fixed: '',sort: true }
      ,{field:'spec_qp_sum',width:120,title: '简单题数量',align:'center',fixed: '',sort: true }
      ,{field:'mdi_dt',width:120,title: '变更时间',align:'center',fixed: '',sort: true }
      ,{field:'cre_dt',width:120,title: '创建时间',align:'center',fixed: '',sort: true }
      ,{field:'st_id',width:120,title: '状态',align:'center',fixed: '',sort: true }
      ,{fixed: 'right',title : '操作',width:130, align:'center', toolbar: '#barDemo',}

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
  table.on('checkbox(Xgt_sub_examTable)', function(obj){


  });
  //监听工具条
  table.on('tool(test)', function(obj){
    var data = obj.data;
    if(obj.event === 'edit'){
      /**
       * 打开查看试卷详情_修改
       */
      Xgt_sub_exam.seItem=data
             layer.open({
                  type: 2,
                  title: '试卷详情_修改',
                  area: ['100%', '100%'], //宽高
                  fix: false, //不固定
                  maxmin: true,
                  content: Feng.ctxPath + '/xgt_sub_exam/xgt_sub_exam_update/' + Xgt_sub_exam.seItem.sub_exam_id
              });



    } else if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
        obj.del();
        layer.close(index);
      });

    }  else if(obj.event === 'delete'){
             Xgt_sub_exam.seItem=data
              var operation = function(){
                  var ajax = new $ax(Feng.ctxPath + '/xgt_sub_exam/delete', function () {
                      Feng.success("删除成功!");
                      var tableData=new Array()
                      $.ajax({
                          url:Feng.ctxPath +"/xgt_sub_exam/backContent"
                          ,type:"post"
                          ,async:false
                          ,dataType:"json"
                          , success: function(result){
                              tableData=result;

                          }
                      });
                      table.reload('Xgt_sub_examTable',{
                          data : tableData
                      });


                  }, function (data) {
                      Feng.error("删除失败!" + data.responseJSON.message + "!");
                  });
                  ajax.set("xgt_sub_examIds", Xgt_sub_exam.seItem.sub_exam_id);
                  ajax.start();
              };
              Feng.confirm("是否删除数据 " + "?",operation);

          }
          else if(obj.event === 'detail'){
      /**
       * 打开查看试卷详情
       */
       Xgt_sub_exam.seItem=data

               layer.open({
                  type: 2,
                  title: '试卷详情',
                  area: ['100%', '100%'], //宽高
                  fix: false, //不固定
                  maxmin: true,
                  content: Feng.ctxPath + '/xgt_sub_exam/xgt_sub_exam_detail/' + Xgt_sub_exam.seItem.sub_exam_id
              });





    }

  });


  //复选框选中操作
  var $ = layui.$, active = {
    getCheckData: function(){ //获取选中数据

        var checkStatus = table.checkStatus(Xgt_sub_exam.id)
      ,data = checkStatus.data;
      var arr =JSON.stringify(data);
        layer.alert(arr);
    }
    ,getCheckLength: function(){ //获取选中数目
      var checkStatus = table.checkStatus(Xgt_sub_exam.id)
      ,data = checkStatus.data;
      layer.msg('选中了：'+ data.length + ' 个');
          if(data.length == 0){
              Feng.info("请先选中表格中的某一记录！");
              return false;
          }else{
              Xgt_sub_exam.seItem = data[0];
              return true;
          }
    }
    ,isAll: function(){ //验证是否全选
      var checkStatus = table.checkStatus(Xgt_sub_exam.id);
      layer.msg(checkStatus.isAll ? '全选': '未全选')
    }
  };

  $('.demoTable .layui-btn').on('click', function(){
    var type = $(this).data('type');
    active[type] ? active[type].call(this) : '';
  });










/**
 * 删除试卷
 */
/*
 layui.table.on('radio(test)', function(obj){
         var xuanzhong=obj.data;
         Xgt_sub_exam.seItem=xuanzhong
     });
Xgt_sub_exam.delete = function () {
var checkStatus = layui.table.checkStatus('Xgt_sub_examTable');
    var data = checkStatus.data;
  var zzz = data.map(function(v){return v.sub_exam_id;});
   var  sub_exam_id=zzz.join();
     var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/xgt_sub_exam/delete", function (DATA) {
            Feng.success("删除成功!");
 var tableData=new Array()
            $.ajax({
                url:Feng.ctxPath +"/xgt_sub_exam/backContent"
                ,type:"get"
                ,async:false
                ,dataType:"json"
                , success: function(result){
                    tableData=result;

                }
            });
            table.reload('Xgt_sub_examTable',{
                data : tableData
            });
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("xgt_sub_examIds",sub_exam_id);
        ajax.start();
    }
    	 Feng.confirm("是否刪除该试卷?", operation);

};*/

/**
 * 查询试卷列表
 */
Xgt_sub_exam.search = function () {
     var tableData=new Array()
        var demoReload = $('#condition').val();
        var ajax = new $ax(Feng.ctxPath + "/xgt_sub_exam/backContent", function(DATA){

        layui.use('table', function(){
          var table = layui.table;
          table.render({
            elem: '#Xgt_sub_examTable'
            ,data: DATA.data
            ,even:true
            ,height: 520
            ,id:"Xgt_sub_examTable"
           ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                    layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
                    //,curr: 5 //设定初始在第 5 页
                    ,groups: 1 //只显示 1 个连续页码
                    ,first: false //不显示首页
                    ,last: false //不显示尾页

                }
            ,cols: [[
            {type:'checkbox', fixed: 'left'}
              ,{field:'sub_exam_id',width:120,title: '试卷ID ',align:'center',fixed: 'left',sort: true }
              ,{field:'sub_exam_nm',width:120,title: '试卷名称',align:'center',fixed: '',sort: true }
              ,{field:'par_sub_exam_nm',width:120,title: '上级试卷名称',align:'center',fixed: '',sort: true }
              ,{field:'sub_nm',width:120,title: '科目ID',align:'center',fixed: '',sort: true }
              ,{field:'name',width:120,title: '用户ID',align:'center',fixed: '',sort: true }
              ,{field:'sub_exam_no',width:120,title: '试卷编号',align:'center',fixed: '',sort: true }
              ,{field:'one_sel_sum',width:120,title: '单选数量',align:'center',fixed: '',sort: true }
              ,{field:'more_sel_sum',width:120,title: '多选数量',align:'center',fixed: '',sort: true }
              ,{field:'yes_no_sum',width:120,title: '判断题数量',align:'center',fixed: '',sort: true }
              ,{field:'insert_sum',width:120,title: '填空题数量',align:'center',fixed: '',sort: true }
              ,{field:'spec_qp_sum',width:120,title: '简单题数量',align:'center',fixed: '',sort: true }
              ,{field:'mdi_dt',width:120,title: '变更时间',align:'center',fixed: '',sort: true }
              ,{field:'cre_dt',width:120,title: '创建时间',align:'center',fixed: '',sort: true }
              ,{field:'st_id',width:120,title: '状态',align:'center',fixed: '',sort: true }
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




        });
         ajax.set('limit',9000);
        ajax.set('condition',demoReload);
                    ajax.set('st_id',$('#st_id').val());
            ajax.start();


};



/**
 * 导出试卷
 */
Xgt_sub_exam.export = function () {
       window.location.href=Feng.ctxPath + "/xgt_sub_exam/export";
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




var xiao=null
//树
layui.use(['tree', 'layer'], function(){
    'use strict';
    var tableData='';
    $.ajax({
        url:Feng.ctxPath +"/xgt_sub_exam/bulidJsonTree"
        ,type:"get"
        ,async:false
        ,dataType:"json"
        , success: function(result){
            tableData=JSON.parse(result)
        }
    });
    console.log(tableData)



    layui.tree({
        elem: '#xgt_sub_exam' //指定元素
        ,click: function(item){ //点击节点回调
            xiao=item.id;
            var ajax = new $ax(Feng.ctxPath + "/xgt_sub_exam/bulidJson", function (MDATA) {
                layui.use('table', function(){
                    var table = layui.table;

                    table.render({
                        elem: '#Xgt_sub_examTable'
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
                        ,id:"Xgt_sub_examTable"
                        ,cols: [[
                            {type:'checkbox', fixed: 'left'}
                              ,{field:'sub_exam_id',width:120,title: '试卷ID ',align:'center',fixed: 'left',sort: true }
                              ,{field:'sub_exam_nm',width:120,title: '试卷名称',align:'center',fixed: '',sort: true }
                              ,{field:'par_sub_exam_nm',width:120,title: '上级试卷名称',align:'center',fixed: '',sort: true }
                              ,{field:'sub_nm',width:120,title: '科目ID',align:'center',fixed: '',sort: true }
                              ,{field:'name',width:120,title: '用户ID',align:'center',fixed: '',sort: true }
                              ,{field:'sub_exam_no',width:120,title: '试卷编号',align:'center',fixed: '',sort: true }
                              ,{field:'one_sel_sum',width:120,title: '单选数量',align:'center',fixed: '',sort: true }
                              ,{field:'more_sel_sum',width:120,title: '多选数量',align:'center',fixed: '',sort: true }
                              ,{field:'yes_no_sum',width:120,title: '判断题数量',align:'center',fixed: '',sort: true }
                              ,{field:'insert_sum',width:120,title: '填空题数量',align:'center',fixed: '',sort: true }
                              ,{field:'spec_qp_sum',width:120,title: '简单题数量',align:'center',fixed: '',sort: true }
                              ,{field:'mdi_dt',width:120,title: '变更时间',align:'center',fixed: '',sort: true }
                              ,{field:'cre_dt',width:120,title: '创建时间',align:'center',fixed: '',sort: true }
                              ,{field:'st_id',width:120,title: '状态',align:'center',fixed: '',sort: true }
                              ,{fixed: 'right',title : '操作',width:120, align:'center', toolbar: '#barDemo',}

                            ]]
                    });
                });




            }, function (MDATA) {
                Feng.error("失败!" + MDATA.responseJSON.message + "!");
            });
            ajax.set('id',item.id);
            ajax.set('limit',10)
            ajax.start();







        }
        ,nodes:tableData
    });



});


/**
 * 点击添加试卷
 */


$('#tianjia').on('click', function () {
    var Id = xiao;
    console.log(Id)
    if(Id==null){
        layer.msg('请在左侧选择分类');
    }else {
        var index = layer.open({
            type: 2,
            title: '添加试卷',
            area: ['100%', '100%'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/xgt_sub_exam/xgt_sub_exam_add/'+Id
        });
        this.layerIndex = index;
    }
})
