@/*
select标签中各个参数的说明:
name : select的名称
id : select的id
underline : 是否带分割线
@*/
<div class="input-group">
    <div class="input-group-btn">
        <button data-toggle="dropdown" class="btn btn-white dropdown-toggle"
                type="button">${name}
        </button>
    </div>
    <select class="form-control" id="${id}"  name="${name}">
        @for(ele in map){
        @if(ele.cpn_id == value!){
        <option value="${ele.cpn_id}" selected = "selected">${ele.cpn_nm}</option>
        @}else{
        <option value="${ele.cpn_id}">${ele.cpn_nm}</option>
        @}
        @}
    </select>
    @if(isNotEmpty(hidden)){
    <input class="form-control" type="hidden" id="${hidden}" value="${hiddenValue!}">
    @}
</div>
@if(isNotEmpty(underline) && underline == 'true'){

@}


