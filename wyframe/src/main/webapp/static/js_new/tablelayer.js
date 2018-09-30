layui.use('table', function(){
  var table = layui.table;
  var tableData=new Array();
  table.render({
    elem: '#test'
    ,data:tableData
    ,even:true
    ,height: 332
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
      ,{field:'id', width:40,  title: 'ID',align:'center',  fixed: 'left',templet: '#indexTpl'}
      ,{fixed: 'left',title : '操作',width:90, align:'center', toolbar: '#barDemo',fixed: 'left'}
      ,{field:'prd_nm_img',sort: true,align:'center',width:80, title: '图片',fixed: 'left' }
      ,{field:'prd_nm',sort: true, title: '产品名称',align:'center',width:160,fixed: 'left' }
      ,{field:'prd_no',  title: '条码',align:'center',width:160, sort: true, }
      ,{field:'prd_id',  title: '产品ID',align:'center',width:160,sort: true,}
      ,{field:'prd_brand_id', title: '生产品牌ID',align:'center',width:160, sort: true, }
      ,{field:'prd_vendor_id',  title: '生产厂商ID',align:'center',width:160,sort: true, }
      ,{field:'prd_cls_id',  title: '产品分类ID',align:'center',width:160,sort: true, }
      ,{field:'prd_spec',  title: '规格',align:'center',width:160, sort: true, }
      ,{field:'prd_model', sort: true,align:'center',width:160, title: '型号', }
      ,{field:'prd_sn', sort: true,align:'center',width:160, title: '编号', }
      ,{field:'prd_purchase', sort: true,align:'center',width:160, title: '批发价', }
      ,{field:'prd_price', sort: true,align:'center',width:160, title: '零售价', }
      ,{field:'prd_unit_id',  title: '单位', align:'center',width:160,sort: true, }
      ,{field:'numb',  title: '数量', sort: true,align:'center',width:160,  event: 'setSign'}
      ,{field:'prd_nm_alias',sort: true,align:'center',width:160, title: '产品简称', }
      ,{field:'prd_nm_dsc', sort: true,align:'center',width:160, title: '产品描述', }
      ,{field:'amount',sort: true,align:'center',width:90, title: '金额',style:'color:red',fixed: 'right', }
      ,{field:'prd_remarks', sort: true,align:'center',width:70, title: '备注',fixed: 'right', }
    ]]
    ,done: function(res, curr, count){
    //如果是异步请求数据方式，res即为你接口返回的信息。
    //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
    console.log(res);
    //得到当前页码
    //  console.log(curr);
    //得到数据总量
    // console.log(count);
          $("[data-field='prd_id']").css('display','none');
          $("[data-field='prd_brand_id']").css('display','none');
          $("[data-field='prd_vendor_id']").css('display','none');
          $("[data-field='prd_cls_id']").css('display','none');
          $("[data-field='prd_id']").css('display','none');
          $("[data-field='prd_id']").css('display','none');
          $("[data-field='prd_id']").css('display','none');
          $("[data-field='prd_nm_alias']").css('display','none');
          $("[data-field='prd_nm_dsc']").css('display','none');
    }
  });
});

layui.use('table', function(){
  var table = layui.table;
  //监听表格复选框选择
  table.on('checkbox(demo)', function(obj){
    

  });
  //监听工具条
  table.on('tool(demo)', function(obj){
    var data = obj.data;
    if(obj.event === 'detail'){
      layer.msg('ID：'+ data.id + ' 的查看操作');
    } else if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
        obj.del();
        layer.close(index);
         var datazz= table.cache.test;


          console.log(datazz);
          var some=datazz.length;
var sum=0.00
for (var i = 0; i < some; i++) {
  var zzz=datazz[i].amount;
  if(zzz!=undefined){
    sum+=zzz;
  }
  
}

console.log(sum)
$('#totalAmount').html(parseFloat(sum).toFixed(2));
      });

    } else if(obj.event === 'edit'){
      layer.alert('编辑行：<br>'+ JSON.stringify(data))

      
    }
    var data = obj.data;
    
    if(obj.event === 'setSign'){
      layer.prompt({
        formType: 0
        ,title: '修改数量'
        ,value: data.numb
      }, function(value, index){
        var table = layui.table;
        var chen =value*data.prd_price;
        layer.close(index);
        
        //这里一般是发送修改的Ajax请求
       
        //同步更新表格和缓存对应的值
        obj.update({
           numb:value, 
          amount: chen
        });

console.log(table.cache.test)
var datazz= table.cache.test;
var some=datazz.length;
var sum=0.00;
for (var i = 0; i < some; i++) {
  var zzz=datazz[i].amount;
  if(zzz!=undefined){
    sum+=zzz;

  }
  
}
console.log(sum)
$('#totalAmount').html(parseFloat(sum).toFixed(2));
      });
    }
  });




  //复选框选中操作
  var $ = layui.$, active = {
    getCheckData: function(){ //获取选中数据

        var checkStatus = table.checkStatus('test')
      ,data = checkStatus.data;
      var arr =JSON.stringify(data);
        layer.alert(arr);

      console.log(arr);

    }
    ,getCheckLength: function(){ //获取选中数目
      var checkStatus = table.checkStatus('test')
      ,data = checkStatus.data;
      layer.msg('选中了：'+ data.length + ' 个');
    }
    ,isAll: function(){ //验证是否全选
      var checkStatus = table.checkStatus('test');
      layer.msg(checkStatus.isAll ? '全选': '未全选')
    }
  };
  
  $('.demoTable .layui-btn').on('click', function(){
    var type = $(this).data('type');
    active[type] ? active[type].call(this) : '';
  });
    var checkedArr=[];
//全选删除
    $("#delete_all").click(function(){

        var checkStatus = table.checkStatus('test')
            ,data = checkStatus.data, tmpArr = [], ids = [];

        var na = data.map(function(v){return v.prd_id;});
var zh=na.join();
console.log(zh);
        var nnn= na.length;
        var arr1 = layui.table.cache.test;

        var arr = arr1.filter(function (item) {
            return na.indexOf(item.prd_id) < 0;
        })
        console.log(arr);
        // arr.del=function(){
        //     var index = arr.length;
        //     var deleindex = 0;
        //     for(var i=0; i<index; i++){
        //         for(var z=0;z<nnn;z++){
        //             if(arr[i]['prd_id'] ===na[z]){
        //                 deleindex = i-z;
        //                 break
        //             }
        //
        //         }
        //     }
        //
        //     arr.splice(deleindex,nnn);
        //     console.log(deleindex)
        //     console.log(nnn);
        //
        //     return arr;
        // };
        // arr.del()

        var some=arr.length;
        var sum=0.00
        for (var i = 0; i < some; i++) {
            var zzz=arr[i].amount;
            if(zzz!=undefined){
                sum+=zzz;
            }

        }

        $('#totalAmount').html(parseFloat(sum).toFixed(2));




        console.log(arr);
        if (data.length == 0){
            layui.layer.msg('请选择要删除行');
            return;
        }
        table.reload('test', {
           data:arr
        });

    });


//搜索重载

    var $ = layui.$, active = {
        reload: function(){
            var demoReload = $('#demoReload');

            //执行重载
            table.reload('test', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                ,where: {
                    key: {
                        id: demoReload.val()
                    }
                }
            });
        }
    };

    $('.demoTable .layui-btn').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });





});

//






layui.use('laydate', function(){
    var laydate = layui.laydate;

    //执行一个laydate实例
    laydate.render({
        elem: '#hello', //指定元素
        type: 'datetime',

    });
});
$('#tijiao').click(function(){
    var vendor=" "+","+$('#condition_hidden').val()+','+$('#condition1_hidden').val()+','+$('#condition2_hidden').val()+','+$('#hello').val()+','+$('#remark').val()+','+$('#inBillNo').html()+","+$("#totalAmount").html();
    console.log(vendor);
    var selectContent = layui.table.cache.test;
    console.log(selectContent);
    if($('#condition_hidden').val()==""){
        layer.msg('供货商不能为空', {icon: 5});
        return false
    }
    if($('#condition1_hidden').val()==""){
        layer.msg('仓库不能为空', {icon: 5});
        return false
    }
    if($('#condition2_hidden').val()==""){
        layer.msg('经手人不能为空', {icon: 5});
        return false
    }
    if($('#hello').val()==""){
        layer.msg('日期不能为空', {icon: 5});
        return false
    }

    var operation = function(){
        var selectContent = layui.table.cache.test;

        for(var i=0;i<selectContent.length;i++){
            console.log(selectContent[i].numb);
            if(selectContent[i].numb==0||selectContent[i].numb==undefined){
                console.log(selectContent[i].prd_nm);
                return  layer.msg(selectContent[i].prd_nm+'数量不能为0', {icon: 5});
            }

        }

        var ajax = new $ax(Feng.ctxPath + "/xgt_goods_store_bill/add", function (data) {
            Feng.success("提交成功!");
            var ajax1 = new $ax(Feng.ctxPath + "/xgt_goods_store_bill/getInStoreNo", function (data1) {
                document.getElementById("inBillNo").innerHTML=data1;
            }, function (data1) {
                Feng.error("初始化入库单号失败!" + data1.responseJSON.message + "!");
            });
            ajax1.start();
        }, function (data) {
            Feng.error("提交失败!" + data.responseJSON.message + "!");
        });
        ajax.set('iData',JSON.stringify(selectContent));
        ajax.set('tData',vendor)
        ajax.start();
    }
    Feng.confirm("是否提交?", operation);
});

$('#baocun').click(function(){
    if($('#condition_hidden').val()==""){
        layer.msg('供货商不能为空', {icon: 5});
        return false
    }
    if($('#condition1_hidden').val()==""){
        layer.msg('仓库不能为空', {icon: 5});
        return false
    }
    if($('#condition2_hidden').val()==""){
        layer.msg('经手人不能为空', {icon: 5});
        return false
    }
    if($('#hello').val()==""){
        layer.msg('日期不能为空', {icon: 5});
        return false
    }
    var vendor=' ,' +
        ''+$('#condition_hidden').val()+','+$('#condition1_hidden').val()+','+$('#condition2_hidden').val()+','+$('#hello').val()+','+$('#remark').val()+','+$('#inBillNo').html()+","+$("#totalAmount").html();
    console.log(vendor);
    var selectContent = layui.table.cache.test;
    console.log(selectContent);
    var operation = function(){

        var selectContent = layui.table.cache.test;

        for(var i=0;i<selectContent.length;i++){
            console.log(selectContent[i].numb);
            if(selectContent[i].numb==0){
                console.log(selectContent[i].prd_nm);
                return  layer.msg(selectContent[i].prd_nm+'数量不能为0', {icon: 5});
            }

        }
        var ajax = new $ax(Feng.ctxPath + "/xgt_goods_store_bill/save_in", function (data) {
            Feng.success("保存成功!");
            window.load();
        }, function (data) {
            Feng.error("保存失败!" + data.responseJSON.message + "!");
        });
        ajax.set('iData',JSON.stringify(selectContent));
        ajax.set('tData',vendor)
        ajax.start();
    }
    Feng.confirm("是否保存?", operation);
});