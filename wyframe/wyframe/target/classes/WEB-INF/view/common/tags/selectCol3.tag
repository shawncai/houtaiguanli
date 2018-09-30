@/*
    select标签中各个参数的说明:
    name : select的名称
    id : select的id
    underline : 是否带分割线
@*/
<div class="col-sm-3 col-xs-3">
<div class="form-group" >
    <div class="col-sm-12 col-xs-12">
        <select class="form-control" id="${id}"  name="${name}">
            @for(ele in map){
				@if(ele.num == value!){
					<option value="${ele.num}" selected = "selected">${ele.name}</option>
				@}else{
					<option value="${ele.num}">${ele.name}</option>
				@}
			@}
        </select>
    </div>
        @if(isNotEmpty(hidden)){
            <input class="form-control" type="hidden" id="${hidden}" value="${hiddenValue!}">
        @}
</div>
</div>
@if(isNotEmpty(underline) && underline == 'true'){

@}


