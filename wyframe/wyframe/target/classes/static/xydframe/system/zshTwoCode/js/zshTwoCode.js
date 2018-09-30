/**
 * Created by Administrator on 2018/7/5.
 */
/**
 * 代码生成管理初始化
 */
var Code = {
    ztreeInstance: null,
    pcode: null,
    pcodeName: null
};
/**
 * 点击父级编号input框时
 */
Code.onClickDept = function (e, treeId, treeNode) {
    $("#pcodeName").attr("value", Code.ztreeInstance.getSelectedVal());
    $("#pcode").attr("value", treeNode.id);
    Code.pcodeName = Code.ztreeInstance.getSelectedVal();
    Code.pcode =  treeNode.id;
};

Code.showMenuSelectTree = function () {
    Feng.showInputTree("pcodeName", "pcodeTreeDiv", 15, 34);
};



$(function () {

    var ztree = new $ZTree("pcodeTree", "/menu/selectMenuTreeList");
    ztree.bindOnClick(Code.onClickDept);
    ztree.init();
    Code.ztreeInstance = ztree;

});

$("#bizEnName").change(function(){
    var opt=$("#bizEnName").val();
    $("input:checkBox[name='tname']").on('ifChecked', function(event){
        $('#moduleName').val(opt);
    });
    $("input:checkBox[name='tname']").on('ifUnchecked', function(event){
        $('#moduleName').val("");
    });
    layui.use('table', function(){
        var table = layui.table;
        var form = layui.form;
        var tableData=new Array();
        $.ajax({
            url: Feng.ctxPath +"/autoCode/initTable/"+opt
            ,type:"get"
            ,async:false
            ,dataType:"json"
            , success: function(result){
                tableData=result;
            }
        });
        //第一个实例
        table.render({
            elem: '#demo'
            ,data: tableData
            ,even:true
            ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                layout: [ 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
                //,curr: 5 //设定初始在第 5 页
                ,limits: [30,60]
                ,limit: 30
                ,groups: 1 //只显示 1 个连续页码
                ,first: false //不显示首页
                ,last: false //不显示尾页

            }
            ,height: 600
            ,cols: [[ //表头
                {title : '操作',width:90, align:'center', toolbar: '#barDemo',fixed: 'left'}
                ,{field: 'columnName', title: '字段名称', width:100,align:'center',fixed: 'left'}
                ,{field: 'columnRemark', title: '字段备注', width:100,align:'center',edit: 'text',fixed: 'left'}
                ,{field: 'order', title: '排序', width:100,align:'center',edit: 'text',fixed: 'left'}
                ,{field: 'columnType', title: '数据类型',width:100, align:'center',}
                ,{field: 'javaType', title: 'JAVA类型', width:100,align:'center',edit: 'text'}
                ,{field: 'formType', title: '表单类型', width:150,align:'center', toolbar: '#formTypeselected'}
                ,{field: 'isSearch', title: '是否搜索',width:100,align:'center',templet: '#isSearchshifou',}
                ,{field: 'checkType', title: '字段校验',width:150,align:'center',toolbar: '#checkTypeselected'}
                ,{field: 'isQuery', title: '查询条件', width:100,align:'center',templet: '#isQueryshifou'}
                ,{field: 'queryDict', title: '查询字段', width:100,align:'center',edit: 'text'}
                ,{field: 'fixed', title: '固定列', width:100,align:'center',toolbar: '#fixedselected'}
                ,{field: 'treeParam', title: 'tree参数', width:100,align:'center',edit: 'text'}
                ,{field: 'fieldChange', title: '字段转换', width:100,align:'center',toolbar: '#fieldChangeselected'}
                ,{field: 'fieldTable', title: '所在表名', width:100,align:'center',edit: 'text'}
                ,{field: 'toField', title: '转换字段', width:100,align:'center',edit: 'text',}
                ,{field: 'width', title: '表格宽度', width:150,align:'center', edit:'text'}
                ,{field: 'isOrder', title: '是否排序', width:100,align:'center',templet: '#isOrdershifou'}
                ,{field: 'tablePage', title: '表格字段', width:150,align:'center',templet: '#tablePageshifou' }
                ,{field: 'addPage', title: '添加字段', width:150,align:'center',templet: '#addPageshifou' }
                ,{field: 'editPage', title: '编辑字段', width:150,align:'center',templet: '#editPageshifou' }
                ,{field: 'detailPage', title: '详情字段', width:150,align:'center',templet: '#detailPageshifou' }
                ,{field: 'excelPage', title: '导出字段', width:150,align:'center',templet: '#excelPageshifou' }
                ,{field: 'printPage', title: '打印字段', width:150,align:'center',templet: '#printPageshifou' }
            ]]
        });

        //监听工具条
        table.on('tool(test)', function(obj){
            var data = obj.data;
            if(obj.event === 'detail'){
                layer.msg('ID：'+ data.id + ' 的查看操作');
            } else if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    obj.del();
                    layer.close(index);
                });

            }



        });

        form.on('switch(isSearchshifou)', function(obj){
            // layer.tips(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);
        });
//是否搜索
        form.on('switch(isSearchshifou)', function(obj){
            var selectIfKey=obj.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");

            if(obj.elem.checked == true){//是主键
                // 给对象主键赋值
                tableData[parentTrIndex].isSearch = 1;
                // 获取允许为空的div

            }else{
                // 给对象赋值
                tableData[parentTrIndex].isSearch = 0;
            }
        });

        //查询条件
        form.on('switch(isQueryshifou)', function(obj){
            var selectIfKey=obj.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");

            if(obj.elem.checked == true){//是主键
                // 给对象主键赋值
                tableData[parentTrIndex].isQuery = 1;
            }else{
                // 给对象赋值
                tableData[parentTrIndex].isQuery = 0;
            }
        });

//左侧加树
        form.on('switch(isLeftTreeshifou)', function(obj){
            var selectIfKey=obj.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");

            if(obj.elem.checked == true){//是主键
                // 给对象主键赋值
                tableData[parentTrIndex].isLeftTree = 1;
            }else{
                // 给对象赋值
                tableData[parentTrIndex].isLeftTree =0 ;
            }
        });
//左侧加树
        form.on('switch(isOrdershifou)', function(obj){
            var selectIfKey=obj.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");

            if(obj.elem.checked == true){//是主键
                // 给对象主键赋值
                tableData[parentTrIndex].isOrder = true;
            }else{
                // 给对象赋值
                tableData[parentTrIndex].isOrder =false;
            }
        });

//表单类型获取
        form.on('select(formTypeselected)', function(data){


            var selectIfKey=data.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");
            tableData[parentTrIndex].formType=parseInt(data.value);

        });

//字段校验获取
        form.on('select(checkTypeselected)', function(data){


            var selectIfKey=data.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");
            tableData[parentTrIndex].checkType=parseInt(data.value);

        });


//固定列获取
        form.on('select(fixedselected)', function(data){
            var selectIfKey=data.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");
            console.log(data.value);
            if(data.value=="0"){
                tableData[parentTrIndex].fixed=''
            }else if(data.value=="1"){
                tableData[parentTrIndex].fixed='left';
            }else if(data.value=="2"){
                tableData[parentTrIndex].fixed='right';
            }


        });


//字段转换获取
        form.on('select(fieldChangeselected)', function(data){


            var selectIfKey=data.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");
            tableData[parentTrIndex].fieldChange=parseInt(data.value);

        });


        //表格字段
        form.on('switch(tablePageshifou)', function(obj){
            var selectIfKey=obj.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");

            if(obj.elem.checked == true){//是主键
                // 给对象主键赋值
                tableData[parentTrIndex].tablePage == true;
            }else{
                // 给对象赋值
                tableData[parentTrIndex].tablePage =0;
            }
        });


        //添加字段
        form.on('switch(addPageshifou)', function(obj){
            var selectIfKey=obj.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");

            if(obj.elem.checked == true){//是主键
                // 给对象主键赋值
                tableData[parentTrIndex].addPage == true;
            }else{
                // 给对象赋值
                tableData[parentTrIndex].addPage =0;
            }
        });


        //编辑字段
        form.on('switch(editPageshifou)', function(obj){
            var selectIfKey=obj.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");

            if(obj.elem.checked == true){//是主键
                // 给对象主键赋值
                tableData[parentTrIndex].editPage == true;
            }else{
                // 给对象赋值
                tableData[parentTrIndex].editPage =0;
            }
        });

        //详情字段
        form.on('switch(detailPageshifou)', function(obj){
            var selectIfKey=obj.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");

            if(obj.elem.checked == true){//是主键
                // 给对象主键赋值
                tableData[parentTrIndex].detailPage == true;
            }else{
                // 给对象赋值
                tableData[parentTrIndex].detailPage =0;
            }
        });

        //导出字段
        form.on('switch(excelPageshifou)', function(obj){
            var selectIfKey=obj.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");

            if(obj.elem.checked == true){//是主键
                // 给对象主键赋值
                tableData[parentTrIndex].excelPage == true;
            }else{
                // 给对象赋值
                tableData[parentTrIndex].excelPage =0;
            }
        });


        //打印字段
        form.on('switch(printPageshifou)', function(obj){
            var selectIfKey=obj.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");
            console.log(obj)
            if(obj.elem.checked == true){//是主键
                // 给对象主键赋值
                tableData[parentTrIndex].printPage == true;
            }else{
                // 给对象赋值
                tableData[parentTrIndex].printPage =0;
            }
        });





    });


});
//副表开始
$("#fuTable").change(function(){
    var opt=$("#fuTable").val();
    layui.use('table', function(){
        var table = layui.table;
        var form = layui.form;
        var tableData=new Array();
        $.ajax({
            url: Feng.ctxPath +"/autoCode/initTable/"+opt
            ,type:"get"
            ,async:false
            ,dataType:"json"
            , success: function(result){
                tableData=result;
            }
        });
        //第一个实例
        table.render({
            elem: '#demo1'
            ,data: tableData
            ,even:true
            ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                layout: [ 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
                //,curr: 5 //设定初始在第 5 页
                ,limits: [30,60]
                ,limit: 30
                ,groups: 1 //只显示 1 个连续页码
                ,first: false //不显示首页
                ,last: false //不显示尾页

            }
            ,height: 600
            ,cols: [[ //表头
                {title : '操作',width:90, align:'center', toolbar: '#barDemo1',fixed: 'left'}
                ,{field: 'columnName', title: '字段名称', width:100,align:'center',fixed: 'left'}
                ,{field: 'columnRemark', title: '字段备注', width:100,align:'center',edit: 'text',fixed: 'left'}
                ,{field: 'order', title: '排序', width:100,align:'center',edit: 'text',fixed: 'left'}
                ,{field: 'columnType', title: '数据类型',width:100, align:'center',}
                ,{field: 'javaType', title: 'JAVA类型', width:100,align:'center',edit: 'text'}
                ,{field: 'formType', title: '表单类型', width:150,align:'center', toolbar: '#formTypeselected1'}
                ,{field: 'isSearch', title: '是否搜索',width:100,align:'center',templet: '#isSearchshifou1',}
                ,{field: 'checkType', title: '字段校验',width:150,align:'center',toolbar: '#checkTypeselected1'}
                ,{field: 'isQuery', title: '查询条件', width:100,align:'center',templet: '#isQueryshifou1'}
                ,{field: 'queryDict', title: '查询字段', width:100,align:'center',edit: 'text'}
                ,{field: 'fixed', title: '固定列', width:100,align:'center',toolbar: '#fixedselected1'}
                ,{field: 'treeParam', title: 'tree参数', width:100,align:'center',edit: 'text'}
                ,{field: 'fieldChange', title: '字段转换', width:100,align:'center',toolbar: '#fieldChangeselected1'}
                ,{field: 'fieldTable', title: '所在表名', width:100,align:'center',edit: 'text'}
                ,{field: 'toField', title: '转换字段', width:100,align:'center',edit: 'text',}
                ,{field: 'width', title: '表格宽度', width:150,align:'center', edit:'text'}
                ,{field: 'isOrder', title: '是否排序', width:100,align:'center',templet: '#isOrdershifou1'}
                ,{field: 'tablePage', title: '表格字段', width:150,align:'center',templet: '#tablePageshifou1' }
                ,{field: 'addPage', title: '添加字段', width:150,align:'center',templet: '#addPageshifou1' }
                ,{field: 'editPage', title: '编辑字段', width:150,align:'center',templet: '#editPageshifou1' }
                ,{field: 'detailPage', title: '详情字段', width:150,align:'center',templet: '#detailPageshifou1' }
                ,{field: 'excelPage', title: '导出字段', width:150,align:'center',templet: '#excelPageshifou1' }
                ,{field: 'printPage', title: '打印字段', width:150,align:'center',templet: '#printPageshifou1' }
            ]]
        });

        //监听工具条
        table.on('tool(test1)', function(obj){
            var data = obj.data;
            if(obj.event === 'detail'){
                layer.msg('ID：'+ data.id + ' 的查看操作');
            } else if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    obj.del();
                    layer.close(index);
                });

            }



        });

        form.on('switch(isSearchshifou1)', function(obj){
            // layer.tips(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);
        });
//是否搜索
        form.on('switch(isSearchshifou1)', function(obj){
            var selectIfKey=obj.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");

            if(obj.elem.checked == true){//是主键
                // 给对象主键赋值
                tableData[parentTrIndex].isSearch = 1;
                // 获取允许为空的div

            }else{
                // 给对象赋值
                tableData[parentTrIndex].isSearch = 0;
            }
        });

        //查询条件
        form.on('switch(isQueryshifou1)', function(obj){
            var selectIfKey=obj.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");

            if(obj.elem.checked == true){//是主键
                // 给对象主键赋值
                tableData[parentTrIndex].isQuery = 1;
            }else{
                // 给对象赋值
                tableData[parentTrIndex].isQuery = 0;
            }
        });

//左侧加树
        form.on('switch(isLeftTreeshifou1)', function(obj){
            var selectIfKey=obj.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");

            if(obj.elem.checked == true){//是主键
                // 给对象主键赋值
                tableData[parentTrIndex].isLeftTree = 1;
            }else{
                // 给对象赋值
                tableData[parentTrIndex].isLeftTree =0 ;
            }
        });
//左侧加树
        form.on('switch(isOrdershifou1)', function(obj){
            var selectIfKey=obj.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");

            if(obj.elem.checked == true){//是主键
                // 给对象主键赋值
                tableData[parentTrIndex].isOrder = true;
            }else{
                // 给对象赋值
                tableData[parentTrIndex].isOrder =false;
            }
        });

//表单类型获取
        form.on('select(formTypeselected1)', function(data){


            var selectIfKey=data.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");
            tableData[parentTrIndex].formType=parseInt(data.value);

        });

//字段校验获取
        form.on('select(checkTypeselected1)', function(data){


            var selectIfKey=data.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");
            tableData[parentTrIndex].checkType=parseInt(data.value);

        });


//固定列获取
        form.on('select(fixedselected1)', function(data){
            var selectIfKey=data.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");
            console.log(data.value);
            if(data.value=="0"){
                tableData[parentTrIndex].fixed=''
            }else if(data.value=="1"){
                tableData[parentTrIndex].fixed='left';
            }else if(data.value=="2"){
                tableData[parentTrIndex].fixed='right';
            }


        });


//字段转换获取
        form.on('select(fieldChangeselected1)', function(data){


            var selectIfKey=data.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");
            tableData[parentTrIndex].fieldChange=parseInt(data.value);

        });


        //表格字段
        form.on('switch(tablePageshifou1)', function(obj){
            var selectIfKey=obj.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");

            if(obj.elem.checked == true){//是主键
                // 给对象主键赋值
                tableData[parentTrIndex].tablePage == true;
            }else{
                // 给对象赋值
                tableData[parentTrIndex].tablePage =0;
            }
        });


        //添加字段
        form.on('switch(addPageshifou1)', function(obj){
            var selectIfKey=obj.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");

            if(obj.elem.checked == true){//是主键
                // 给对象主键赋值
                tableData[parentTrIndex].addPage == true;
            }else{
                // 给对象赋值
                tableData[parentTrIndex].addPage =0;
            }
        });


        //编辑字段
        form.on('switch(editPageshifou1)', function(obj){
            var selectIfKey=obj.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");

            if(obj.elem.checked == true){//是主键
                // 给对象主键赋值
                tableData[parentTrIndex].editPage == true;
            }else{
                // 给对象赋值
                tableData[parentTrIndex].editPage =0;
            }
        });

        //详情字段
        form.on('switch(detailPageshifou1)', function(obj){
            var selectIfKey=obj.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");

            if(obj.elem.checked == true){//是主键
                // 给对象主键赋值
                tableData[parentTrIndex].detailPage == true;
            }else{
                // 给对象赋值
                tableData[parentTrIndex].detailPage =0;
            }
        });

        //导出字段
        form.on('switch(excelPageshifou1)', function(obj){
            var selectIfKey=obj.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");

            if(obj.elem.checked == true){//是主键
                // 给对象主键赋值
                tableData[parentTrIndex].excelPage == true;
            }else{
                // 给对象赋值
                tableData[parentTrIndex].excelPage =0;
            }
        });


        //打印字段
        form.on('switch(printPageshifou1)', function(obj){
            var selectIfKey=obj.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");
            console.log(obj)
            if(obj.elem.checked == true){//是主键
                // 给对象主键赋值
                tableData[parentTrIndex].printPage == true;
            }else{
                // 给对象赋值
                tableData[parentTrIndex].printPage =0;
            }
        });





    });


});
//副表结束
//参数表开始
$("#paramTable").change(function(){
    var opt=$("#paramTable").val();
    layui.use('table', function(){
        var table = layui.table;
        var form = layui.form;
        var tableData=new Array();
        $.ajax({
            url: Feng.ctxPath +"/autoCode/initTable/"+opt
            ,type:"get"
            ,async:false
            ,dataType:"json"
            , success: function(result){
                tableData=result;
            }
        });
        //第一个实例
        table.render({
            elem: '#demo2'
            ,data: tableData
            ,even:true
            ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                layout: [ 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
                //,curr: 5 //设定初始在第 5 页
                ,limits: [30,60]
                ,limit: 30
                ,groups: 1 //只显示 1 个连续页码
                ,first: false //不显示首页
                ,last: false //不显示尾页

            }
            ,height: 600
            ,cols: [[ //表头
                {title : '操作',width:90, align:'center', toolbar: '#barDemo2',fixed: 'left'}
                ,{field: 'columnName', title: '字段名称', width:100,align:'center',fixed: 'left'}
                ,{field: 'columnRemark', title: '字段备注', width:100,align:'center',edit: 'text',fixed: 'left'}
                ,{field: 'order', title: '排序', width:100,align:'center',edit: 'text',fixed: 'left'}
                ,{field: 'columnType', title: '数据类型',width:100, align:'center',}
                ,{field: 'javaType', title: 'JAVA类型', width:100,align:'center',edit: 'text'}
                ,{field: 'formType', title: '表单类型', width:150,align:'center', toolbar: '#formTypeselected2'}
                ,{field: 'isSearch', title: '是否搜索',width:100,align:'center',templet: '#isSearchshifou2',}
                ,{field: 'checkType', title: '字段校验',width:150,align:'center',toolbar: '#checkTypeselected2'}
                ,{field: 'isQuery', title: '查询条件', width:100,align:'center',templet: '#isQueryshifou2'}
                ,{field: 'queryDict', title: '查询字段', width:100,align:'center',edit: 'text'}
                ,{field: 'fixed', title: '固定列', width:100,align:'center',toolbar: '#fixedselected2'}
                ,{field: 'treeParam', title: 'tree参数', width:100,align:'center',edit: 'text'}
                ,{field: 'fieldChange', title: '字段转换', width:100,align:'center',toolbar: '#fieldChangeselected2'}
                ,{field: 'fieldTable', title: '所在表名', width:100,align:'center',edit: 'text'}
                ,{field: 'toField', title: '转换字段', width:100,align:'center',edit: 'text',}
                ,{field: 'width', title: '表格宽度', width:150,align:'center', edit:'text'}
                ,{field: 'isOrder', title: '是否排序', width:100,align:'center',templet: '#isOrdershifou2'}
                ,{field: 'tablePage', title: '表格字段', width:150,align:'center',templet: '#tablePageshifou2' }
                ,{field: 'addPage', title: '添加字段', width:150,align:'center',templet: '#addPageshifou2' }
                ,{field: 'editPage', title: '编辑字段', width:150,align:'center',templet: '#editPageshifou2' }
                ,{field: 'detailPage', title: '详情字段', width:150,align:'center',templet: '#detailPageshifou2' }
                ,{field: 'excelPage', title: '导出字段', width:150,align:'center',templet: '#excelPageshifou2' }
                ,{field: 'printPage', title: '打印字段', width:150,align:'center',templet: '#printPageshifou2' }
            ]]
        });

        //监听工具条
        table.on('tool(test2)', function(obj){
            var data = obj.data;
            if(obj.event === 'detail'){
                layer.msg('ID：'+ data.id + ' 的查看操作');
            } else if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    obj.del();
                    layer.close(index);
                });

            }



        });

        form.on('switch(isSearchshifou2)', function(obj){
            // layer.tips(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);
        });
//是否搜索
        form.on('switch(isSearchshifou2)', function(obj){
            var selectIfKey=obj.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");

            if(obj.elem.checked == true){//是主键
                // 给对象主键赋值
                tableData[parentTrIndex].isSearch = 1;
                // 获取允许为空的div

            }else{
                // 给对象赋值
                tableData[parentTrIndex].isSearch = 0;
            }
        });

        //查询条件
        form.on('switch(isQueryshifou2)', function(obj){
            var selectIfKey=obj.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");

            if(obj.elem.checked == true){//是主键
                // 给对象主键赋值
                tableData[parentTrIndex].isQuery = 1;
            }else{
                // 给对象赋值
                tableData[parentTrIndex].isQuery = 0;
            }
        });

//左侧加树
        form.on('switch(isLeftTreeshifou2)', function(obj){
            var selectIfKey=obj.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");

            if(obj.elem.checked == true){//是主键
                // 给对象主键赋值
                tableData[parentTrIndex].isLeftTree = 1;
            }else{
                // 给对象赋值
                tableData[parentTrIndex].isLeftTree =0 ;
            }
        });
//左侧加树
        form.on('switch(isOrdershifou2)', function(obj){
            var selectIfKey=obj.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");

            if(obj.elem.checked == true){//是主键
                // 给对象主键赋值
                tableData[parentTrIndex].isOrder = true;
            }else{
                // 给对象赋值
                tableData[parentTrIndex].isOrder =false;
            }
        });

//表单类型获取
        form.on('select(formTypeselected2)', function(data){


            var selectIfKey=data.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");
            tableData[parentTrIndex].formType=parseInt(data.value);

        });

//字段校验获取
        form.on('select(checkTypeselected2)', function(data){


            var selectIfKey=data.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");
            tableData[parentTrIndex].checkType=parseInt(data.value);

        });


//固定列获取
        form.on('select(fixedselected2)', function(data){
            var selectIfKey=data.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");
            console.log(data.value);
            if(data.value=="0"){
                tableData[parentTrIndex].fixed=''
            }else if(data.value=="1"){
                tableData[parentTrIndex].fixed='left';
            }else if(data.value=="2"){
                tableData[parentTrIndex].fixed='right';
            }


        });


//字段转换获取
        form.on('select(fieldChangeselected2)', function(data){


            var selectIfKey=data.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");
            tableData[parentTrIndex].fieldChange=parseInt(data.value);

        });


        //表格字段
        form.on('switch(tablePageshifou2)', function(obj){
            var selectIfKey=obj.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");

            if(obj.elem.checked == true){//是主键
                // 给对象主键赋值
                tableData[parentTrIndex].tablePage == true;
            }else{
                // 给对象赋值
                tableData[parentTrIndex].tablePage =0;
            }
        });


        //添加字段
        form.on('switch(addPageshifou2)', function(obj){
            var selectIfKey=obj.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");

            if(obj.elem.checked == true){//是主键
                // 给对象主键赋值
                tableData[parentTrIndex].addPage == true;
            }else{
                // 给对象赋值
                tableData[parentTrIndex].addPage =0;
            }
        });


        //编辑字段
        form.on('switch(editPageshifou2)', function(obj){
            var selectIfKey=obj.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");

            if(obj.elem.checked == true){//是主键
                // 给对象主键赋值
                tableData[parentTrIndex].editPage == true;
            }else{
                // 给对象赋值
                tableData[parentTrIndex].editPage =0;
            }
        });

        //详情字段
        form.on('switch(detailPageshifou2)', function(obj){
            var selectIfKey=obj.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");

            if(obj.elem.checked == true){//是主键
                // 给对象主键赋值
                tableData[parentTrIndex].detailPage == true;
            }else{
                // 给对象赋值
                tableData[parentTrIndex].detailPage =0;
            }
        });

        //导出字段
        form.on('switch(excelPageshifou2)', function(obj){
            var selectIfKey=obj.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");

            if(obj.elem.checked == true){//是主键
                // 给对象主键赋值
                tableData[parentTrIndex].excelPage == true;
            }else{
                // 给对象赋值
                tableData[parentTrIndex].excelPage =0;
            }
        });


        //打印字段
        form.on('switch(printPageshifou2)', function(obj){
            var selectIfKey=obj.othis;
            // 获取当前所在行
            var parentTr = selectIfKey.parents("tr");
            // 获取当前所在行的索引
            var parentTrIndex = parentTr.attr("data-index");
            console.log(obj)
            if(obj.elem.checked == true){//是主键
                // 给对象主键赋值
                tableData[parentTrIndex].printPage == true;
            }else{
                // 给对象赋值
                tableData[parentTrIndex].printPage =0;
            }
        });





    });


});
//参数表结束







var Generate=function () {
    var baseAjax = Feng.baseAjax("/twoCode/generate", "生成代码");
    baseAjax.set("dataBase",$('#dataBase').val());
    baseAjax.set("bizEnName",$('#bizEnName').val());
    baseAjax.set("bizChName",$('#bizChName').val());
    baseAjax.set("moduleName",$('#moduleName').val());
    baseAjax.set("layout", $("input[name='layout']:checked").val());
    console.log($("input[name='layout']:checked").val())
    baseAjax.set("pcodeName",Code.pcodeName);
    baseAjax.set("pcode",Code.pcode);
    baseAjax.set("path",$('#path').val());
    var selectContent = layui.table.cache.demo;
    console.log(selectContent);
    var selectContent1 = layui.table.cache.demo1;
    console.log(selectContent1);
    baseAjax.set("fuCols",JSON.stringify(selectContent1));
    var selectContent2 = layui.table.cache.demo2;
    console.log(selectContent2);
    baseAjax.set("paramCols",JSON.stringify(selectContent2));
    baseAjax.set("table",JSON.stringify(selectContent));
    alert(JSON.stringify(selectContent));
    baseAjax.set("add",$('#add').is(':checked')+"");
    baseAjax.set("update",$('#update').is(':checked')+"");
    baseAjax.set("delete",$('#delete').is(':checked')+"");
    baseAjax.set("export",$('#export').is(':checked')+"");
    baseAjax.set("detail",$('#detail').is(':checked')+"");
    baseAjax.set("print",$('#print').is(':checked')+"");
    baseAjax.set("project",$('#project').val());
    baseAjax.set("fuTable",$('#fuTable').val());
    baseAjax.set("paramTable",$('#paramTable').val());
    baseAjax.start();
}







