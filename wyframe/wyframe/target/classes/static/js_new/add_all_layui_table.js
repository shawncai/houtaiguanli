layui.use('table', function(){
  var table = layui.table;
    var tableData=new Array()
    $.ajax({
        url: Feng.ctxPath +"/xgt_goods_store_bill/productList"
        ,type:"get"
        ,async:false
        ,dataType:"json"
        , success: function(result){
            tableData=result;

        }
    });
  table.render({
    elem: '#test'
    ,data:tableData
    ,even:true
    ,height: 332
    ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
      layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
      //,curr: 5 //设定初始在第 5 页
      ,groups: 1 //只显示 1 个连续页码
      ,first: false //不显示首页
      ,last: false //不显示尾页
      
    }
      ,cols: [[
          {type:'checkbox', fixed: 'left'}
          ,{field:'id', width:60,  title: 'ID',align:'center',  fixed: 'left',templet: '#indexTpl'}
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
          ,{field:'prd_nm_alias',sort: true,align:'center',width:160, title: '产品简称', }
          ,{field:'prd_nm_dsc', sort: true,align:'center',width:160, title: '产品描述', }
          ,{field:'prd_remarks', sort: true,align:'center',width:160, title: '备注',fixed: 'right', }
      ]]
    ,done: function(res, curr, count){
    //如果是异步请求数据方式，res即为你接口返回的信息。
    //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
    // console.log(res);
    // //得到当前页码
    // console.log(curr);
    // //得到数据总量
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

console.log(sum)
$('#totalAmount').html(parseFloat(sum).toFixed(2));
      });

    } else if(obj.event === 'edit'){
      layer.alert('编辑行：<br>'+ JSON.stringify(data))

      obj.update({
      username: '444'
      
    });
    }
    var data = obj.data;
    
    if(obj.event === 'setSign'){
      layer.prompt({
        formType: 2
        ,title: '修改 ID 为 ['+ data.id +'] 的用户签名'
        ,value: data.experience
      }, function(value, index){
        var table = layui.table;
        var chen =value*data.score;
        layer.close(index);
        
        //这里一般是发送修改的Ajax请求
       
        //同步更新表格和缓存对应的值
      

      });
    }
  });




  //复选框选中操作
  var $ = layui.$, active = {
    getCheckData: function(){ //获取选中数据
      var checkStatus = table.checkStatus('test')
      ,data = checkStatus.data;
      layer.alert(JSON.stringify(data));
      
      var oldData=parent.layui.table.cache.test;
      console.log(oldData);
        for (var i = 0; i < data.length; i++) {
           oldData.push(data[i]);
          parent.layui.table.reload('test',{
              data : oldData
          });
        }
console.log(oldData);

parent.layer.closeAll()




      
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

//全选删除
var checkedArr=[];
table.on('checkbox(demo)', function(obj){
if (obj.type=='all') return;
if (obj.checked){
checkedArr[obj.data.id] = obj.data.LAY_TABLE_INDEX;
}
else{
delete checkedArr[obj.data.id];
}
});

$("#add_some").click(function(){
var checkStatus = table.checkStatus('test')
,data = checkStatus.data, tmpArr = [], ids = [];
if (checkStatus.isAll){
for (var i=0; i<data.length ; i++){
checkedArr[data[i].id]=i;
ids.push(data[i].id);
}
}
else{ 
for (var i=0; i<data.length ; i++){
tmpArr[data[i].id]=checkedArr[data[i].id];
ids.push(data[i].id);
}
checkedArr = tmpArr;
}

//没有选中任何一行
if (checkedArr.length == 0){
layui.layer.msg('请选择要删除行');
return;
}

layui.layer.confirm('真的删除么', function(index){
layui.layer.close(index);
//ajax从数据库删除 ids.toString();
$.each(checkedArr, function(k){
$("tr[data-index="+checkedArr[k]+"]").remove();
});
layui.layer.msg('删除成功');
});

});

//
$('#tijiao').click(function(){
    console.log(table.cache.test);
})

   
$('#').click(function(){
  var tableContainer = $('div[lay-filter="LAY-table-1"]');
        tableContainer.find('input[name="layTableCheckbox"]:checked').each(function(){
            var trDel = $(this).parents('tr');
            trDel.remove();
        })
})


});


// $('#item_info_btn_add').click(function(){  
//         var selectContent = $("#staff").bootstrapTable('getAllSelections');  
//         parent.$('#exampleTableToolbar').bootstrapTable("append", selectContent);
//         parent.layer.closeAll()

// oldData.push(data1);
//           table.reload('test',{
//               data : oldData
//           });

//     }); 






$('#item_info_btn_close').click(function(){  
        
        parent.layer.closeAll()
       

    });


$('#case_add').on('click', function(){
    layer.open({
        type: 2,
        title: '商品新增',
        area: ['70%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        shadeClose: true,
        content:Feng.ctxPath +  '/xgt_goods_store_bill/inStoreProductAdd',
        end: function () {
            location.reload();
        }
    });
});