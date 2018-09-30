@/*
select标签中各个参数的说明:
name : select的名称
id : select的id
underline : 是否带分割线
@*/
<div class="form-group">
    <label class="col-sm-4 control-label col-xs-6">${name}：</label>
    <div class="col-sm-7 col-xs-12">
        <select class="form-control" id="${id}"  name="${name}">
            @for(ele in map){
            @if(ele.cpn_branch_id == value!){
            <option value="${ele.cpn_branch_id}" selected = "selected">${ele.cpn_branch_nm}</option>
            @}else{
            <option value="${ele.cpn_branch_id}">${ele.cpn_branch_nm}</option>
            @}
            @}
        </select>
    </div>
    @if(isNotEmpty(hidden)){
    <input class="form-control" type="hidden" id="${hidden}" value="${hiddenValue!}">
    @}
</div>
@if(isNotEmpty(underline) && underline == 'true'){

@}


