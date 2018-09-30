  $(function () {
        $('#close_span').click(function () {
            $('input')[2].value = "";
        })
      })
    $(function () {
        $('#case_close_span').click(function () {
            $('input')[0].value = "";
           
        })
      })
    $(function () {
        $('#staff_close_span').click(function () {
            $('input')[4].value = "";
        })
      })
    
     $('.gonghuo').on('click', function(){
         var str= $("#condition_hidden").val()
    	layer.open({
    	 type: 2,
      title: '入库仓库',
        area: ['100%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        shadeClose: true,
      content: Feng.ctxPath + '/xgt_goods_store_bill_allot/inStoreVendorPage/'+str
    });
  });
    
    $('#seach_span').on('click', function(){
        var str= $("#condition_hidden").val()
    layer.open({
    	 type: 2,
      title: '入库仓库',
        area: ['100%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        shadeClose: true,
      content: Feng.ctxPath + '/xgt_goods_store_bill_allot/inStoreVendorPage/'+str
    });
  });
  
  $('#add_span').on('click', function(){
    layer.open({
    	 type: 2,
      title: '入库仓库新增',
        area: ['70%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        shadeClose: true,
        content:Feng.ctxPath +  '/xgt_goods_store_bill_allot/inStoreVendorAdd'
    });
  });
  
  
  /*仓库搜索和新增*/
 
 $('.case').on('click', function(){
     var str= $("#condition1_hidden").val()
    	layer.open({
    	 type: 2,
      title: '出库仓库搜索',
        area: ['100%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        shadeClose: true,
      content: Feng.ctxPath + '/xgt_goods_store_bill_out/inStoreStorePage/'+str
    });
  });
    
    $('#case_seach_span').on('click', function(){
        var str= $("#condition1_hidden").val()
    layer.open({
    	 type: 2,
      title: '出库仓库搜索',
        area: ['100%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        shadeClose: true,
      content: Feng.ctxPath + '/xgt_goods_store_bill_out/inStoreStorePage/'+str
    });
  });
  
  $('#case_add_span').on('click', function(){
    layer.open({
    	 type: 2,
      title: '仓库新增',
        area: ['70%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        shadeClose: true,
      content: Feng.ctxPath + '/xgt_goods_store_bill_out/inStoreStoreAdd'
    });
  });
  
  //经手人的搜索和添加
   $('.staff').on('click', function(){
    	layer.open({
    	 type: 2,
      title: '经手人搜索',
        area: ['100%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        shadeClose: true,
      content: Feng.ctxPath + '/xgt_goods_store_bill_out/inStoreUserPage'
    });
  });
    
    $('#staff_seach_span').on('click', function(){
    layer.open({
    	 type: 2,
      title: '经手人搜索',
        area: ['100%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        shadeClose: true,
      content: Feng.ctxPath + '/xgt_goods_store_bill_out/inStoreUserPage'
    });
  });
  
  $('#staff_add_span').on('click', function(){
    layer.open({
    	 type: 2,
      title: '经手人新增',
        area: ['70%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        shadeClose: true,
      content: Feng.ctxPath + '/xgt_goods_store_bill_out/inStoreUserAdd'
    });
  });

  $('#add_some').on('click', function(){
      if($('#condition1').val()==""){
          layer.msg('出库仓库不能为空', {icon: 5});
          return false
      }
      var selectContent1 = $("#exampleTableToolbar").bootstrapTable('getData');
      var some =selectContent1.length;
      var str="0,";
      for (var i = 0; i < some; i++) {

          var obj =selectContent1[i].prd_id;
          str+=obj+",";
      }

    layer.open({
       type: 2,
      title: '商品搜索',
        area: ['100%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        shadeClose: true,
      content: Feng.ctxPath + '/xgt_goods_store_bill_out/xgt_goods_store_bill_add_param/'+str+"-"+$('#condition1_hidden').val()
    });



  });
  
  
 