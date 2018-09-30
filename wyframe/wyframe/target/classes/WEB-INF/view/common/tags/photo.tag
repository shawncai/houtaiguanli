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
        <div id="duan">
            <img    class="img-rounded" style="width: 122px;"
            @if(isNotEmpty(value)){
                    src="${value}"
            @}


            />
        </div>
        <div id="wrapper1">
            <div id="container">
                <!--头部，相册选择和格式选择-->
                <div id="uploader">
                    <div class="queueList">
                        <div id="dndArea" class="placeholder">
                            <div id="filePicker"></div>
                        </div>
                    </div>
                    <div class="statusBar" style="display:none;">
                        <div class="progress">
                            <span class="text">0%</span>
                            <span class="percentage"></span>
                        </div><div class="info"></div>
                        <div class="btns">
                            <div id="filePicker2"></div><div class="uploadBtn">开始上传</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
@if(isNotEmpty(underline) && underline == 'true'){
    <div class="hr-line-dashed"></div>
@}


