/**
 * 企业员工管理初始化
 */
var Xyd_cpn_dept = {
    id: "Xyd_cpn_deptTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};
//
// /**
//  * 初始化表格的列
//  */
// Xyd_cpn_dept.initColumn = function () {
//     return [
//         {field: 'selectItem', radio: true},
//         {title: '健值', field: 'cpn_dept_id', visible: false, align: 'center', valign: 'middle'},
//         {title: '部门', field: 'cpn_dept_nm', align: 'center', valign: 'middle', sortable: true},
//         {title: '编码', field: 'cpn_dept_code', align: 'center', valign: 'middle', sortable: true},
//         {title: '上级部门', field: 'par_cpn_dept_nm', align: 'center', valign: 'middle', sortable: true},
//         {title: '状态', field: 'st_id', align: 'center', valign: 'middle', sortable: true},
//         {title: '变更时间', field: 'cre_dt', align: 'center', valign: 'middle', sortable: true}
//     ];
// };
//
// /**
//  * 检查是否选中
//  */
// Xyd_cpn_dept.check = function () {
//     var selected = $('#' + this.id).bootstrapTable('getSelections');
//     if(selected.length == 0){
//         Feng.info("请先选中表格中的某一记录！");
//         return false;
//     }else{
//         Xyd_cpn_dept.seItem = selected[0];
//         return true;
//     }
// };

/**
 * 点击添加企业员工
 */
Xyd_cpn_dept.openAddXyd_cpn_dept = function () {
    var deptId = Xyd_cpn_dept.cpn_dept_id;
    if(deptId==undefined){
        Feng.error("请在左侧选择分类!");
    }
};

// /**
//  * 打开查看企业员工详情_修改
//  */
// Xyd_cpn_dept.openXyd_cpn_deptDetail_update = function () {
//     if (this.check()) {
//         var index = layer.open({
//             type: 2,
//             title: '企业员工详情_修改',
//             area: ['60%', '300px'], //宽高
//             fix: false, //不固定
//             maxmin: true,
//             content: Feng.ctxPath + '/xyd_cpn_dept/xyd_cpn_dept_update/' + Xyd_cpn_dept.seItem.cpn_dept_id
//         });
//         this.layerIndex = index;
//     }
// };
//
// /**
//  * 删除企业员工
//  */
// Xyd_cpn_dept.delete = function () {
//     if (this.check()) {
//         var operation = function(){
//             var ajax = new $ax(Feng.ctxPath + "/xyd_cpn_dept/delete", function (data) {
//                 Feng.success("删除成功!");
//                 Xyd_cpn_dept.table.refresh();
//             }, function (data) {
//                 Feng.error("删除失败!" + data.responseJSON.message + "!");
//             });
//             ajax.set("xyd_cpn_deptId",Xyd_cpn_dept.seItem.cpn_dept_id);
//             ajax.start();
//         }
//         Feng.confirm("是否刪除该企业员工?", operation);
//     }
// };

/**
 * 查询企业员工列表
 */
Xyd_cpn_dept.search = function () {
    var queryData = {};
    var demoReload = $('#condition').val();
    queryData['cpn_dept_id'] = Xyd_cpn_dept.cpn_dept_id;
    console.log(Xyd_cpn_dept.cpn_dept_id);
    queryData['condition'] = $("#condition").val();
    queryData['cpn_dept_nm'] = $("#cpn_dept_nm").val();
    var ajax = new $ax(Feng.ctxPath +"/dept/backContent", function(DATA){
        layui.use('table', function(){
            var table = layui.table;

            table.render({
                elem: '#deptTable'
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
                ,id:"deptTable"
                ,cols: [[
                    {type:'checkbox', fixed: 'left'}

                    ,{title: '健值', field: 'cpn_dept_id',width:150,align:'center',fixed: 'left',sort: true }
                    ,{title: '部门', field: 'cpn_dept_nm',width:185,align:'center',fixed: 'left',sort: true }
                    ,{title: '编码', field: 'cpn_dept_code',width:200,align:'center',fixed: '',sort: true }
                    ,{title: '上级部门', field: 'par_cpn_dept_nm', width:200,align:'center',fixed: '',sort: true }
                    ,{title: '状态', field: 'st_id', width:190,align:'center',fixed: '',sort: true }
                    ,{title: '变更时间', field: 'cre_dt', width:160,align:'center',fixed: '',sort: true }
                    ,{fixed: 'right',title : '操作',width:210, align:'center', toolbar: '#barDemo',}
                ]]
            });
        });
    });
    ajax.set('condition',demoReload);
    ajax.set('limit',9000);
    ajax.start();
};

Xyd_cpn_dept.onClickDept = function(e, treeId, treeNode) {
    Xyd_cpn_dept.cpn_dept_id = treeNode.id;
    Xyd_cpn_dept.search();
}

// $(function () {
//     var defaultColunms = Xyd_cpn_dept.initColumn();
//     var table = new BSTable("Xyd_cpn_deptTable", "/xyd_cpn_dept/list", defaultColunms);
//     table.setPaginationType("client");
//     Xyd_cpn_dept.table = table.init();
//
//     var ztree = new $ZTree("depttree", "/xyd_cpn_dept/tree/"+0);
//     ztree.bindOnClick(Xyd_cpn_dept.onClickDept);
//     ztree.init();
// });
//
// /**
//  * 导出企业员工
//  */
// Xyd_cpn_dept.export = function () {
//     window.location.href=Feng.ctxPath + "/xyd_cpn_dept/export";
// };
//
// /**
//  * 打开查看企业员工详情
//  */
// Xyd_cpn_dept.openXyd_cpn_deptDetail = function () {
//     if (this.check()) {
//         var index = layer.open({
//             type: 2,
//             title: '企业员工详情',
//             area: ['60%', '300px'], //宽高
//             fix: false, //不固定
//             maxmin: true,
//             content: Feng.ctxPath + '/xyd_cpn_dept/xyd_cpn_dept_detail/' + Xyd_cpn_dept.seItem.cpn_dept_id
//         });
//         this.layerIndex = index;
//     }
// };

/**
 * 收集数据
 */
Xyd_cpn_dept.collectData = function() {
    this .set('cpn_dept_id') .set('cpn_id') .set('cpn_branch_id') .set('cpn_dept_nm') .set('cpn_dept_code') .set('par_cpn_dept_id') .set('st_id');
}

// /**
//  * 添加企业员工
//  */
// Xyd_cpn_dept.add = function () {
//     alert(this.collectData());
//     var operation = function(){
//         var ajax = new $ax(Feng.ctxPath + "/xyd_cpn_dept/add", function (data) {
//             Feng.success("添加成功!");
//             Xyd_cpn_dept.table.refresh();
//         }, function (data) {
//             Feng.error("添加失败!" + data.responseJSON.message + "!");
//         });
//         ajax.start();
//     }
//     Feng.confirm("是否添加该企业员工?", operation);
// };




//layui tree + layui table


layui.use('table', function(){
    var table = layui.table;

    table.render({
        elem:'#deptTable'
        ,url: Feng.ctxPath +"/dept/backContent"
        ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
            layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
            //,curr: 5 //设定初始在第 5 页
            ,groups: 1 //只显示 1 个连续页码
            ,first: false //不显示首页
            ,last: false //不显示尾页

        }
        ,even:true
        ,height: 520
        ,id:"deptTable"
        ,cols: [[
            {type:'checkbox', fixed: 'left'}
            ,{title: '健值', field: 'cpn_dept_id',width:150,align:'center',fixed: 'left',sort: true }
            ,{title: '部门', field: 'cpn_dept_nm',width:185,align:'center',fixed: 'left',sort: true }
            ,{title: '编码', field: 'cpn_dept_code',width:200,align:'center',fixed: '',sort: true }
            ,{title: '上级部门', field: 'par_cpn_dept_nm', width:200,align:'center',fixed: '',sort: true }
            ,{title: '状态', field: 'st_id', width:190,align:'center',fixed: '',sort: true }
            ,{title: '变更时间', field: 'cre_dt', width:160,align:'center',fixed: '',sort: true }
            ,{fixed: 'right',title : '操作',width:210, align:'center', toolbar: '#barDemo',}
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
             * 部门修改
             */
             layer.open({
                type: 2,
                title: '企业员工详情_修改',
                area: ['60%', '300px'], //宽高
                fix: false, //不固定
                maxmin: true,
                content: Feng.ctxPath + '/xyd_cpn_dept/xyd_cpn_dept_update/' + seItem.cpn_dept_id
            });


        } else if(obj.event === 'del'){
            var operation = function(){
                var ajax = new $ax(Feng.ctxPath + "/xyd_cpn_dept/delete", function () {
                    Feng.success("删除成功!");
                    var tableData=new Array()
                    $.ajax({
                        url:Feng.ctxPath +"/dept/backContent"
                        ,type:"post"
                        ,async:false
                        ,dataType:"json"
                        , success: function(result){
                            tableData=result;

                        }
                    });
                    table.reload('deptTable',{
                        data : tableData
                    });


                }, function (data) {
                    Feng.error("删除失败!" + data.responseJSON.message + "!");
                });
                ajax.set("xyd_cpn_deptId",seItem.cpn_dept_id);
                ajax.start();
            };

            Feng.confirm("是否删除角色 " + seItem.name + "?",operation);

        } else if(obj.event === 'detail'){

//部门详情
             layer.open({
                type: 2,
                title: '企业员工详情',
                area: ['60%', '300px'], //宽高
                fix: false, //不固定
                maxmin: true,
                content: Feng.ctxPath + '/xyd_cpn_dept/xyd_cpn_dept_detail/' + seItem.cpn_dept_id
            });



        }

    });




});


layui.use(['tree', 'layer'], function(){
    'use strict';
    var tableData='';
    $.ajax({
        url:Feng.ctxPath +"/dept/bulidJsonTree"
        ,type:"get"
        ,async:false
        ,dataType:"json"
        , success: function(result){
            tableData=JSON.parse(result)
        }
    });
    console.log(tableData)



    layui.tree({
        elem: '#dept' //指定元素
        ,click: function(item){ //点击节点回调
            var ajax = new $ax(Feng.ctxPath + "/dept/bulidJson", function (MDATA) {
                layui.use('table', function(){
                    var table = layui.table;

                    table.render({
                        elem: '#deptTable'
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
                        ,id:"deptTable"
                        ,cols: [[
                            {type:'checkbox', fixed: 'left'}
                            ,{title: '健值', field: 'cpn_dept_id',width:150,align:'center',fixed: 'left',sort: true }
                            ,{title: '部门', field: 'cpn_dept_nm',width:185,align:'center',fixed: 'left',sort: true }
                            ,{title: '编码', field: 'cpn_dept_code',width:200,align:'center',fixed: '',sort: true }
                            ,{title: '上级部门', field: 'par_cpn_dept_nm', width:200,align:'center',fixed: '',sort: true }
                            ,{title: '状态', field: 'st_id', width:190,align:'center',fixed: '',sort: true }
                            ,{title: '变更时间', field: 'cre_dt', width:160,align:'center',fixed: '',sort: true }
                            ,{fixed: 'right',title : '操作',width:210, align:'center', toolbar: '#barDemo',}
                        ]]
                    });
                });




            }, function (MDATA) {
                Feng.error("失败!" + MDATA.responseJSON.message + "!");
            });
            ajax.set('id',item.id);
            ajax.set('limit',10)
            ajax.start();

            /**
             * 点击添加企业员工
             */
            Xyd_cpn_dept.openAddXyd_cpn_dept = function () {
                var deptId = item.id;
                    layer.open({
                        type: 2,
                        title: '添加企业组织',
                        area: ['80%', '300px'], //宽高
                        fix: false, //不固定
                        maxmin: true,
                        content: Feng.ctxPath + '/dept/xyd_cpn_dept_add/' + deptId
                    });


            };
            console.log(item.id)
        }
        ,nodes:tableData
    });



});
