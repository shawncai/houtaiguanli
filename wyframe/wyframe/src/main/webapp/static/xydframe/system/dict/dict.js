/**
 * 字典管理初始化
 */
var Dict = {
    id: "DictTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};
//
// /**
//  * 初始化表格的列
//  */
// Dict.initColumn = function () {
//     return [
//         {field: 'selectItem', radio: true},
//         {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
//         {title: '名称', field: 'name', align: 'center', valign: 'middle', sortable: true},
//         {title: '详情', field: 'detail', align: 'center', valign: 'middle', sortable: true},
//         {title: '备注', field: 'tips', align: 'center', valign: 'middle', sortable: true}];
// };
//
// /**
//  * 检查是否选中
//  */
// Dict.check = function () {
//     var selected = $('#' + this.id).bootstrapTable('getSelections');
//     if (selected.length == 0) {
//         Feng.info("请先选中表格中的某一记录！");
//         return false;
//     } else {
//         Dict.seItem = selected[0];
//         return true;
//     }
// };

/**
 * 点击添加字典
 */
Dict.openAddDict = function () {
    var index = layer.open({
        type: 2,
        title: '添加字典',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/dict/dict_add'
    });
    this.layerIndex = index;
};
//
// /**
//  * 打开查看字典详情
//  */
// Dict.openDictDetail = function () {
//     if (this.check()) {
//         var index = layer.open({
//             type: 2,
//             title: '字典详情',
//             area: ['800px', '420px'], //宽高
//             fix: false, //不固定
//             maxmin: true,
//             content: Feng.ctxPath + '/dict/dict_edit/' + Dict.seItem.id
//         });
//         this.layerIndex = index;
//     }
// };
//
// /**
//  * 删除字典
//  */
// Dict.delete = function () {
//     if (this.check()) {
//
//         var operation = function(){
//             var ajax = new $ax(Feng.ctxPath + "/dict/delete", function (data) {
//                 Feng.success("删除成功!");
//                 Dict.table.refresh();
//             }, function (data) {
//                 Feng.error("删除失败!" + data.responseJSON.message + "!");
//             });
//             ajax.set("dictId", Dict.seItem.id);
//             ajax.start();
//         };
//
//         Feng.confirm("是否刪除字典 " + Dict.seItem.name + "?", operation);
//     }
// };

/**
 * 查询字典列表
 */
Dict.search = function () {
    var queryData = {};
    var demoReload = $('#condition').val();
    queryData['condition'] = $("#condition").val();
    var ajax = new $ax(Feng.ctxPath +"/dict/backContent", function(DATA){
        console.log(DATA)
        layui.use('table', function(){
            var table = layui.table;

            table.render({
                elem: '#DictTable'
                ,data:DATA.data
                ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                    layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
                    //,curr: 5 //设定初始在第 5 页
                    ,groups: 1 //只显示 1 个连续页码
                    ,first: false //不显示首页
                    ,last: false //不显示尾页

                }
                ,even:true
                ,height: 520
                ,id:"DictTable"
                ,cols: [[
                    {type:'checkbox', fixed: 'left'}
                    ,{title: 'id', field: 'id',width:180,align:'center',fixed: 'left',sort: true }
                    ,{title: '名称', field: 'name',width:250,align:'center',fixed: 'left',sort: true }
                    ,{title: '上级id', field: 'pid',width:180,align:'center',fixed: 'left',sort: true }
                    ,{title: '详情', field: 'detail',width:250,align:'center',fixed: '',sort: true }
                    ,{title: '备注', field: 'tips', width:250,align:'center',fixed: '',sort: true }
                    ,{fixed: 'right',title : '操作',width:90, align:'center', toolbar: '#barDemo',}
                ]]
            });
        });
    });
    ajax.set('condition',demoReload);
    ajax.set('limit',9000);
    ajax.start();




};

// $(function () {
//     var defaultColunms = Dict.initColumn();
//     var table = new BSTable(Dict.id, "/dict/list", defaultColunms);
//     table.setPaginationType("client");
//     Dict.table = table.init();
// });



//layui tree + layui table


layui.use('table', function(){
    var table = layui.table;

    table.render({
        elem:'#DictTable'
        ,url: Feng.ctxPath +"/dict/backContent"
        ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
            layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
            //,curr: 5 //设定初始在第 5 页
            ,groups: 1 //只显示 1 个连续页码
            ,first: false //不显示首页
            ,last: false //不显示尾页

        }
        ,even:true
        ,height: 520
        ,id:"DictTable"
        ,cols: [[
            {type:'checkbox', fixed: 'left'}
            ,{title: 'id', field: 'id',width:180,align:'center',fixed: 'left',sort: true }
            ,{title: '名称', field: 'name',width:250,align:'center',fixed: 'left',sort: true }
            ,{title: '上级id', field: 'pid',width:180,align:'center',fixed: 'left',sort: true }
            ,{title: '详情', field: 'detail',width:250,align:'center',fixed: '',sort: true }
            ,{title: '备注', field: 'tips', width:250,align:'center',fixed: '',sort: true }
            ,{fixed: 'right',title : '操作',width:90, align:'center', toolbar: '#barDemo',}
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
    //监听工具条

    table.on('tool(test)', function(obj){
        var seItem = obj.data;
        if(obj.event === 'edit'){
            /**
             * 字典修改
             */
            layer.open({
                type: 2,
                title: '字典修改',
                area: ['800px', '420px'], //宽高
                fix: false, //不固定
                maxmin: true,
                content: Feng.ctxPath + '/dict/dict_edit/' + seItem.id
            });



        } else if(obj.event === 'del'){
            var operation = function(){
                var ajax = new $ax(Feng.ctxPath + "/dict/delete", function () {
                    Feng.success("删除成功!");
                    var tableData=new Array()
                    $.ajax({
                        url:Feng.ctxPath +"/dict/backContent"
                        ,type:"post"
                        ,async:false
                        ,dataType:"json"
                        , success: function(result){
                            tableData=result;

                        }
                    });
                    table.reload('DictTable',{
                        data : tableData
                    });


                }, function (data) {
                    Feng.error("删除失败!" + data.responseJSON.message + "!");
                });
                ajax.set("dictId", Dict.seItem.id);
                ajax.start();
            };

            Feng.confirm("是否删除角色 " + seItem.name + "?",operation);

        } else if(obj.event === 'detail'){


        }

    });




});


layui.use(['tree', 'layer'], function(){
    'use strict';
    var tableData='';
    $.ajax({
        url:Feng.ctxPath +"/dict/bulidJsonTree"
        ,type:"get"
        ,async:false
        ,dataType:"json"
        , success: function(result){
            tableData=JSON.parse(result)
        }
    });
    console.log(tableData)



    layui.tree({
        elem: '#dict' //指定元素
        ,click: function(item){ //点击节点回调
            var ajax = new $ax(Feng.ctxPath + "/dict/bulidJson", function (MDATA) {
                    layui.use('table', function(){
                        var table = layui.table;

                        table.render({
                            elem: '#DictTable'
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
                            ,id:"DictTable"
                            ,cols: [[
                                {type:'checkbox', fixed: 'left'}

                                ,{title: 'id', field: 'id',width:180,align:'center',fixed: 'left',sort: true }
                                ,{title: '名称', field: 'name',width:250,align:'center',fixed: 'left',sort: true }
                                ,{title: '上级id', field: 'pid',width:180,align:'center',fixed: 'left',sort: true }
                                ,{title: '详情', field: 'detail',width:250,align:'center',fixed: '',sort: true }
                                ,{title: '备注', field: 'tips', width:250,align:'center',fixed: '',sort: true }
                                ,{fixed: 'right',title : '操作',width:90, align:'center', toolbar: '#barDemo',}
                            ]]
                        });
                    });




            }, function (MDATA) {
                Feng.error("失败!" + MDATA.responseJSON.message + "!");
            });
            ajax.set('id',item.id);
            ajax.set('limit',10)
            ajax.start();

            console.log(item.id)
        }
        ,nodes:tableData
    });



});