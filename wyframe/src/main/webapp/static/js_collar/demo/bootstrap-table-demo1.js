
var index = parent.layer.getFrameIndex(window.name);
$('#table_add').on('click', function(){
    layer.open({
       type: 2,
      title: '供货商新增',
        area: ['70%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        shadeClose: true,
      content: 'table_ad.html'
    });
  });

(function() {
    $('#exampleTableToolbar').bootstrapTable({
      url: "js/demo/bootstrap_table_test2.json",
      search: true,
      showRefresh: true,
      showToggle: true,
      showColumns: true,
      singleSelect: true,   
      toolbar: '#exampleToolbar',
      iconSize: 'outline',
      icons: {
        refresh: 'glyphicon-repeat',
        toggle: 'glyphicon-list-alt',
        columns: 'glyphicon-list'
      }
    });
      
  })();


 
 $('#item_info_btn_add').click(function(){  
        var selectContent = $("#exampleTableToolbar").bootstrapTable('getSelections')[0];  
        parent.$("#condition").val(selectContent.name);
        parent.layer.closeAll()
        $("#close_span").attr("style","display:block");

    }); 

$('#item_info_btn_close').click(function(){  
        
        parent.layer.closeAll()
       

    }); 




   

