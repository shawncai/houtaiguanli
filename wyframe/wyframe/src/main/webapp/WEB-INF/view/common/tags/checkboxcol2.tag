@/*
表单中input框标签中各个参数的说明:

hidden : input hidden框的id
id : input框id
name : input框名称
readonly : readonly属性
clickFun : 点击事件的方法名
style : 附加的css属性
@*/
<div class="col-sm-6 col-xs-6"  style="height: 49px;">
    <div class="form-group">
        <label class="col-sm-4 control-label col-xs-6 ">${name}：</label>
        <div class="checkbox i-checks col-sm-7 text-left col-xs-12">
        <label class="checkbox-inline i-checks">
            <input type="checkbox"id="${id}"  name="${name}"
                   @if(isEmpty(value)){
                   value="0"
                   @}
                   @if(isNotEmpty(value)){
                   value="${value}"
                   @}
                  >
        </label>
        </div>

    </div>
</div>


