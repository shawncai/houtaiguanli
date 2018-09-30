package wy.core.template.config;

import java.util.ArrayList;
import java.util.List;

/**
 * 控制器模板生成的配置
 *
 * @author fengshuonan
 * @date 2017-05-07 22:12
 */
public class ControllerConfig {

    private ContextConfig contextConfig;

    private String controllerPathTemplate;
    private String packageName;//包名称
    private List<String> imports;//所引入的包

    public void init() {
        ArrayList<String> imports = new ArrayList<>();
        imports.add("wy.core.base.controller.BaseController");
        imports.add("org.springframework.stereotype.Controller");
        imports.add("org.springframework.web.bind.annotation.RequestMapping");
        imports.add("org.springframework.web.bind.annotation.ResponseBody");
        imports.add("org.springframework.ui.Model");
        imports.add("java.util.ArrayList"); 
        imports.add("java.util.Map"); 
        imports.add("java.util.List"); 
        imports.add("java.util.HashMap"); 
        imports.add("java.io.IOException"); 
        imports.add("java.io.BufferedInputStream"); 
        imports.add("java.io.OutputStream"); 
        imports.add("java.io.File");  
        imports.add("java.util.Arrays");
        imports.add("com.alibaba.fastjson.JSON");
        imports.add("wy.core.util.DateUtil");  
        imports.add("java.io.FileInputStream"); 
        imports.add("wy.core.shiro.ShiroKit");
        imports.add("javax.servlet.http.HttpServletResponse");
        imports.add("org.springframework.web.bind.annotation.RequestMethod"); 
        imports.add("java.util.Date"); 
        imports.add("net.sf.jxls.exception.ParsePropertyException"); 
        imports.add("net.sf.jxls.transformer.XLSTransformer"); 
        imports.add("javax.annotation.Resource"); 
        imports.add("org.apache.poi.openxml4j.exceptions.InvalidFormatException"); 
        imports.add("org.springframework.web.bind.annotation.RequestParam"); 
        imports.add("org.springframework.ui.Model"); 
        imports.add("wy.core.log.LogObjectHolder");
        imports.add("wy.core.util.DateUtil");
        imports.add("wy.common.constant.factory.ConstantFactory");
        imports.add("wy.config.properties.XydProperties");
        imports.add("com.alibaba.fastjson.JSON");
        imports.add("net.sf.json.JSONObject");
        imports.add("wy.common.annotion.Permission");
        imports.add("wy.common.annotion.BussinessLog");
        imports.add("wy.common.persistence.model.Page;");
        imports.add("wy.common.persistence.model.ResultMap");
        imports.add("wy.core.node.Node");
        imports.add("wy.core.util.TreeBuilder");
        imports.add("javax.servlet.http.HttpServletRequest");
        imports.add(contextConfig.getPackageName()+contextConfig.getModuleName()+".model."+contextConfig.getBizEnBigName());
        imports.add("org.springframework.web.bind.annotation.PathVariable");
        imports.add(contextConfig.getPackageName() + contextConfig.getModuleName() + ".dao."+contextConfig.getBizEnBigName()+"Dao");
        imports.add(contextConfig.getPackageName()+ contextConfig.getModuleName() + ".dao."+contextConfig.getBizEnBigName()+"Mapper");
        imports.add(contextConfig.getPackageName() + contextConfig.getModuleName() + ".warpper."+contextConfig.getBizEnBigName()+"Warpper");
        this.imports = imports;
        this.packageName = contextConfig.getPackageName() + contextConfig.getModuleName() + ".controller";
        this.controllerPathTemplate = contextConfig.getPathTemplate() + contextConfig.getModuleName() + "\\controller\\{}Controller.java";
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public List<String> getImports() {
        return imports;
    }

    public void setImports(List<String> imports) {
        this.imports = imports;
    }

    public String getControllerPathTemplate() {
        return controllerPathTemplate;
    }

    public void setControllerPathTemplate(String controllerPathTemplate) {
        this.controllerPathTemplate = controllerPathTemplate;
    }

    public ContextConfig getContextConfig() {
        return contextConfig;
    }

    public void setContextConfig(ContextConfig contextConfig) {
        this.contextConfig = contextConfig;
    }
}
