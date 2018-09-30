@/*
表单中input框标签中各个参数的说明:

hidden : input hidden框的id
id : input框id
name : input框名称
readonly : readonly属性
clickFun : 点击事件的方法名
style : 附加的css属性
@*/
<div class="col-sm-12 col-xs-12" style="height: 49px;">
    <div class="form-group">
        <div class="checkbox i-checks col-sm-5 control-label col-xs-5">
        <label class="checkbox-inline i-checks">
            ${name}：

            <input type="checkbox"id="${id}"  name="${name}"
                   @if(isNotEmpty(value)){
                   value="${value}"
                   @}
            >

        </label>
        </div>
    </div>
</div>


