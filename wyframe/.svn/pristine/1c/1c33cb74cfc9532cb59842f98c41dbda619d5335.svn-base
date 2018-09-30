 var $table;
var selectionIds = [];  //保存选中ids  
 (function() {
    $('#exampleTableToolbar').bootstrapTable({
      url: "/static/js_new/bootstrap_table_test2.json",
      search: true,
      striped : true,
      showRefresh: true,
      showToggle: false,
      showColumns: true,
      idField: "Id",
      pagination: true,
      clickToSelect: true,
      checkbox:true,
      uniqueId: 'attrValue',   
      toolbar: '#exampleToolbar',
      iconSize: 'outline',
      checkboxHeader:false,
      icons: {
        refresh: 'glyphicon-repeat',
        toggle: 'glyphicon-list-alt',
        columns: 'glyphicon-list'
      },
      queryParams: function (param) {
                return {};
            },

    });
  })();

var Expense = {
    id: "exampleTableToolbar", //表格id
    seItem: null,   //选中的条目
    table: null,
    layerIndex: -1
};

 function reloadRowData(obj, row, key, index){
    row[key] = obj.val();
    $('#exampleTableToolbar').bootstrapTable('getOptions').data.splice(index, 1, row);
};

 function viewOptions(value, row, index) {
            if (row.state == 3) {
                return '<button type="button" class="btn btn-danger button-margin" onclick="Expense.deleteRecord(' + row.id + ')" id=""><i class="glyphicon glyphicon-trash"></i>&nbsp;删除</button>';
            } else {
                return '<button type="button" class="btn btn-primary button-margin" onclick="Expense.findRecord(' + row.id + ')" id=""><i class="glyphicon glyphicon-plus"></i>&nbsp;增加</button>' +
                    '<button type="button" class="btn btn-danger button-margin" onclick="deletetr(this)" id=""><i class="glyphicon glyphicon-trash"></i>&nbsp;删除</button>';
            }
        }

//删除行操作
function deletetr(tdobject){  
    var td=$(tdobject);  
    td.parents("tr").remove();  
};

    