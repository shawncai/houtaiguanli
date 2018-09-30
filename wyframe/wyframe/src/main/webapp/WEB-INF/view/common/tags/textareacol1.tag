@/*
表单中input框标签中各个参数的说明:

hidden : input hidden框的id
id : input框id
name : input框名称
readonly : readonly属性
clickFun : 点击事件的方法名
style : 附加的css属性
@*/
<div class="col-sm-12 col-xs-12">
    <div class="form-group">
        <label class="col-sm-4 control-label col-xs-4 ">${name}：</label>
        <div class="col-sm-8 col-xs-8">
        <textarea class="form-control" aria-required="true" id="${id}" name="${id}">
            </textarea>
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


