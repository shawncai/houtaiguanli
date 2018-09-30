@/*
    select标签中各个参数的说明:
    name : select的名称
    id : select的id
    underline : 是否带分割线
@*/

     <label class="col-sm-2 control-label">${name}</label>
<div class="col-sm-3">
        <select class="form-control" id="${id}"  name="${name}">
            @for(ele in map){
				@if(ele.num == value!){
					<option value="${ele.num}" selected = "selected">${ele.name}</option>
				@}else{
					<option value="${ele.num}">${ele.name}</option>
				@}
			@}
        </select>
        @if(isNotEmpty(hidden)){
            <input class="form-control" type="hidden" id="${hidden}" value="${hiddenValue!}">
        @}
</div>



