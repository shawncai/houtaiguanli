/**
 * 企业员工管理初始化
 */



var Xyd_goods_store_bill = {
    id: "exampleTableToolbar",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};
$(function () {
    var defaultColunms = Xyd_goods_store_bill.initColumn();
    var table = new BSTable("exampleTableToolbar", "", defaultColunms);
    table.setPaginationType("client");
    Xyd_goods_store_bill.table = table.init();

});

/**
 * 初始化表格的列
 */
Xyd_goods_store_bill.initColumn = function () {
    return [
        {field: 'state', checkbox: true},
        {title: '序号', field: 'SHOP',formatter:function(value,row,index){row.SHOP = index;return index+1;}, align: 'center', valign: 'middle'},
        {title: '产品ID', field: 'prd_id', visible: false, align: 'center', valign: 'middle'},
        {title: '操作',  field:'Button', formatter:operateFormatter,events: operateEvents, align: 'center', valign: 'middle',sortable: true,},
        {title: '生产品牌ID', field: 'prd_brand_id',visible: false, align: 'center', valign: 'middle', sortable: true},
       {title: '生产厂商ID', field: 'prd_vendor_id',visible: false, align: 'center', valign: 'middle', sortable: true},
            {title: '产品分类ID', field: 'prd_cls_id',visible: false, align: 'center', valign: 'middle', sortable: true},
            {title: '单位ID',  field: 'prd_unit_id',visible: false, align: 'center', valign: 'middle', sortable: true},
             {title: '产品标准编码',  field: 'prd_no', align: 'center', valign: 'middle', sortable: true},
             {title: '产品名称',  field: 'prd_nm', align: 'center', valign: 'middle', sortable: true},
        {title: '仓库数量',  field: 'sum', align: 'center', valign: 'middle', sortable: true},
        {title: '出库数量', editable: {type: 'text', title: '数量', validate: function (v) {if (isNaN(v)) return '数量必须是数字';var age = parseInt(v);if (age <= 0) return '数量必须是正整数';}
    },field: 'out_num',formatter:numb, align: 'center', valign: 'middle', sortable: true},
        {title: '产品型号',  field: 'prd_model', align: 'center', valign: 'middle', sortable: true},
        {title: '产品简称',  field: 'prd_nm_alias', align: 'center', valign: 'middle', sortable: true},
        {title: '产品描述',  field: 'prd_nm_dsc', align: 'center', valign: 'middle', sortable: true},
        {title: '产品图片',  field: 'prd_nm_img', align: 'center', valign: 'middle', sortable: true},
        {title: '产品售价',  field: 'prd_price', align: 'center', valign: 'middle', sortable: true},
        {title: '金额',  field:'amount', formatter:numbz, align: 'center', valign: 'middle',sortable: true,},
    ];
   

};


function numbz(value, row, index) {
                 if(value == undefined) return "0.00";
                        else return value; 
                       
        }



function numb(value, row, index) {
                   if(value == undefined) return "0";
                        else return value;
                        if(row.out_num >row.sum){
                            return "0"
                        }
        }




 function operateFormatter(value, row, index) {
    return [
        '<a class="remove" href="javascript:void(0)" title="Remove">',
        '<i class="glyphicon glyphicon-remove"></i>',
        '</a>'
    ].join('');
}
window.operateEvents = {
    'click .remove': function (e, value, row, index) {
        $('#exampleTableToolbar').bootstrapTable('remove', {
            field: 'SHOP',
            values: [row.SHOP]
        });
 var data =$('#exampleTableToolbar').bootstrapTable('getData');
        var some= data.length;
        var sum=0.00;
        for (var i = 0; i < some; i++) {

            var obj =data[i].amount;
            if (obj!=undefined) {
                sum+=obj;
            }
        }
        console.log(sum)
        $('#totalAmount').html(parseFloat(sum).toFixed(2));
    },
};

$('#exampleTableToolbar').off('editable-save.bs.table');
$('#exampleTableToolbar').on('editable-save.bs.table',function(e,field,row,oldValue,$el){
if(row.out_num>row.sum){ layer.msg('不能超过仓库数量', {icon: 5}); $('#exampleTableToolbar').bootstrapTable('updateCell', {
    index:row.SHOP,
    field:'out_num',
    value:0
});
    $('#exampleTableToolbar').bootstrapTable('updateCell', {
        index:row.SHOP,
        field:'amount',
        value:0.00
    });
    var data =$('#exampleTableToolbar').bootstrapTable('getData');
    var some= data.length;
    var sum=0.00;
    for (var i = 0; i < some; i++) {

        var obj =data[i].amount;
        if (obj!=undefined) {
            sum+=obj;
        }
    }

    $('#totalAmount').html(parseFloat(sum).toFixed(2));
return false}
	var total=row.out_num*row.prd_price;
	
    	        $('#exampleTableToolbar').bootstrapTable('updateCell', {
             index:row.SHOP,
            field:'amount',
            value:total
        });

var data =$('#exampleTableToolbar').bootstrapTable('getData');
var some= data.length;
 var sum=0.00;
      for (var i = 0; i < some; i++) {

          var obj =data[i].amount;
          if (obj!=undefined) {
          sum+=obj;
          }
      }
      console.log(sum)
 $('#totalAmount').html(parseFloat(sum).toFixed(2));

})




    var $table = $('#exampleTableToolbar'),
        $button = $('#delete_all');
    $(function () {
        $button.click(function () {
            var ids = $.map($table.bootstrapTable('getSelections'), function (row) {
                return row.prd_id;
            });
            $table.bootstrapTable('remove', {
                field: 'prd_id',
                values: ids
            });

             var data =$('#exampleTableToolbar').bootstrapTable('getData');
        var some= data.length;
        var sum=0.00;
        for (var i = 0; i < some; i++) {

            var obj =data[i].amount;
            if (obj!=undefined) {
                sum+=obj;
            }
        }
        console.log(sum)
        $('#totalAmount').html(parseFloat(sum).toFixed(2));
        });
    });



$('#tijiao').click(function(){
    if($('#condition_hidden').val()==""){
        layer.msg('供货商不能为空', {icon: 5});
        return false
    }
    if($('#condition1_hidden').val()==""){
        layer.msg('出库仓库不能为空', {icon: 5});
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
    var vendor=" "+","+$('#condition_hidden').val()+','+$('#condition1_hidden').val()+','+$('#condition2_hidden').val()+','+$('#hello').val()+','+$('#remark').val()+','+$('#allotStore').html()+","+$("#totalAmount").html();
    console.log(vendor);
    var selectContent = $("#exampleTableToolbar").bootstrapTable('getData');
    console.log(selectContent);
    var operation = function(){

        var selectContent = $("#exampleTableToolbar").bootstrapTable('getData');

        for(var i=0;i<selectContent.length;i++){
            console.log(selectContent[i].numb);
            if(selectContent[i].out_num==0||selectContent[i].out_num==undefined){
                console.log(selectContent[i].prd_nm);
                return  layer.msg(selectContent[i].prd_nm+'数量不能为0', {icon: 5});
            }

        }
        var ajax = new $ax(Feng.ctxPath + "/xgt_goods_store_bill_allot/add", function (data) {
            Feng.success("提交成功!");
            window.load();
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
        layer.msg('出库仓库不能为空', {icon: 5});
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
    var vendor=" "+","+$('#condition_hidden').val()+','+$('#condition1_hidden').val()+','+$('#condition2_hidden').val()+','+$('#hello').val()+','+$('#remark').val()+','+$('#allotStore').html()+","+$("#totalAmount").html();
    console.log(vendor);
    var operation = function(){

        var selectContent = $("#exampleTableToolbar").bootstrapTable('getData');

        for(var i=0;i<selectContent.length;i++){
            console.log(selectContent[i].out_num);
            if(selectContent[i].out_num==0||selectContent[i].out_num==undefined){
                console.log(selectContent[i].prd_nm);
                return  layer.msg(selectContent[i].prd_nm+'数量不能为0', {icon: 5});
            }

        }
        var ajax = new $ax(Feng.ctxPath + "/xgt_goods_store_bill_allot/save_in", function (data) {
            Feng.success("保存成功!");
            window.load();
        }, function (data) {
            Feng.error("保存失败!" + data.responseJSON.message + "!");
        });
        ajax.set('iData',JSON.stringify(selectContent));
        ajax.set('tData',vendor)
        ajax.start();
    }
    Feng.confirm("是否提交?", operation);
});