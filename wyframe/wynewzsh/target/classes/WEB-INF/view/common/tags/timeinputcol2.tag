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
<div class="form-group">
    <label class="col-sm-4 control-label col-xs-6 ">${name}：</label>
    <div class="col-sm-7 col-xs-12">
        <input class="form-control layer-date" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" id="${id}" name="${id}"
               @if(isNotEmpty(value)){
               value="${tool.dateType(value)}"
               @}
               @if(isNotEmpty(type)){
               type="${type}"
               @}else{
               type="text"
               @}
               @if(isNotEmpty(readonly)){
               readonly="${readonly}"
               @}
               @if(isNotEmpty(clickFun)){
               onclick="${clickFun}"
               @}
               @if(isNotEmpty(onkeyup)){
               onkeyup="${onkeyup}"
               @}
               @if(isNotEmpty(style)){
               style="${style}"
               @}
               @if(isNotEmpty(disabled)){
               disabled="${disabled}"
               @}
        >
    </div>
    @if(isNotEmpty(hidden)){
    <input class="form-control" type="hidden" id="${hidden}" value="${hiddenValue!}">
    @}

    @if(isNotEmpty(selectFlag)){
    <div id="${selectId}" style="display: none; position: absolute; z-index: 200;">
        <ul id="${selectTreeId}" class="ztree tree-box" style="${selectStyle!}"></ul>
    </div>
    @}
</div>
</div>
@if(isNotEmpty(underline) && underline == 'true'){

@}

