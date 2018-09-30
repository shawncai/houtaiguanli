@/*
    select标签中各个参数的说明:
    name : select的名称
    id : select的id
    underline : 是否带分割线
@*/
<div class="col-sm-6 col-xs-6">
<div class="form-group">
    <label class="col-sm-4 control-label col-xs-6 ">${name}：</label>
    <div class="col-sm-7 col-xs-12">
        <select class="form-control" id="${id}"
                @if(isNotEmpty(value)){
                value="${value}"
                @}
        >
            ${tagBody!}
        </select>
    </div>
        @if(isNotEmpty(hidden)){
            <input class="form-control" type="hidden" id="${hidden}" value="${hiddenValue!}">
        @}
</div>
</div>
@if(isNotEmpty(underline) && underline == 'true'){

@}


