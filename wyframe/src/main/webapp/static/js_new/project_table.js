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
    	layer.open({
    	 type: 2,
      title: '供货商搜索',
        area: ['100%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        shadeClose: true,
      content: Feng.ctxPath + '/xgt_goods_store_bill/inStoreVendorPage'
    });
  });
    
    $('#seach_span').on('click', function(){
    layer.open({
    	 type: 2,
      title: '供货商搜索',
        area: ['100%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        shadeClose: true,
      content: Feng.ctxPath + '/xgt_goods_store_bill/inStoreVendorPage'
    });
  });
  
  $('#add_span').on('click', function(){
    layer.open({
    	 type: 2,
      title: '供货商新增',
        area: ['70%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        shadeClose: true,
        content:Feng.ctxPath +  '/xgt_goods_store_bill/inStoreVendorAdd'
    });
  });
  
  
  /*仓库搜索和新增*/
 
 $('.case').on('click', function(){
    	layer.open({
    	 type: 2,
      title: '仓库搜索',
        area: ['100%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        shadeClose: true,
      content: Feng.ctxPath + '/xgt_goods_store_bill/inStoreStorePage'
    });
  });
    
    $('#case_seach_span').on('click', function(){
    layer.open({
    	 type: 2,
      title: '仓库搜索',
        area: ['100%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        shadeClose: true,
      content: Feng.ctxPath + '/xgt_goods_store_bill/inStoreStorePage'
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
      content: Feng.ctxPath + '/xgt_goods_store_bill/inStoreStoreAdd'
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
      content: Feng.ctxPath + '/xgt_goods_store_bill/inStoreUserPage'
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
      content: Feng.ctxPath + '/xgt_goods_store_bill/inStoreUserPage'
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
      content: Feng.ctxPath + '/xgt_goods_store_bill/inStoreUserAdd'
    });
  });

  $('#add_some').on('click', function(){
      var selectContent2 = layui.table.cache.test;
      var arr = selectContent2;
      var removeItem ="";
      selectContent1 = $.grep(selectContent2, function(value) {
          return value != removeItem;
      });
      console.log(selectContent1)
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
      content: Feng.ctxPath + '/xgt_goods_store_bill/xgt_goods_store_bill_add_param/'+str

    });
  });


  $('#seach').on('click', function(){
      layer.open({
          type: 2,
          title: '订单查询',
          area: ['100%', '100%'], //宽高
          fix: false, //不固定
          maxmin: true,
          shadeClose: true,
          content: '/xgt_goods_store_bill/indexCheck'
      });
  });