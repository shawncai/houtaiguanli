@/*
    表单中input框标签中各个参数的说明:

    hidden : input hidden框的id
    id : input框id
    name : input框名称
    readonly : readonly属性
    clickFun : 点击事件的方法名
    style : 附加的css属性
@*/
<div class="col-sm-6 col-xs-6">
    <input type="hidden" id="${id}" value="">
    <label class="col-sm-4 control-label col-xs-6" style="margin-left: -3px">${name}：</label>
    <div class="col-sm-7 col-xs-12"  >
        <input id="${id}"   class="form-control" name="${name}" type="hidden" />

        <div class="layui-upload" style="width: 270px">
            <button type="button" class="layui-btn layui-btn-normal" id="testList">选择文件</button>
            <button type="button" class="layui-btn" id="testListAction">开始上传</button>
            <div id="duan">
                <img    class="img-rounded" style="width: 122px;"
                        @if(isNotEmpty(value)){
                        src="${value}"
                        @}
                />
            </div>
            <div class="layui-upload-list">
                <!--<img class="layui-upload-img" id="demo1" width="100px">-->
                <table class="layui-table">
                    <thead>
                    <tr><th>文件名</th>
                        <th>大小</th>
                        <th>状态</th>
                        <th>操作</th>
                    </tr></thead>
                    <tbody id="demoList"></tbody>
                </table>
            </div>
        </div>
    </div>
</div>
@if(isNotEmpty(underline) && underline == 'true'){
    <div class="hr-line-dashed"></div>
@}


