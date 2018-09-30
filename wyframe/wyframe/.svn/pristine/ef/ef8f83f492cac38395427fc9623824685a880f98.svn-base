package wy.core.template.config;

import java.util.ArrayList;
import java.util.List;

/**
 * Dao模板生成的配置
 *
 * @author fengshuonan
 * @date 2017-05-07 22:12
 */
public class DaoConfig {

    private ContextConfig contextConfig;

    private String daoPathTemplate;

    private String xmlPathTemplate;

    private String packageName;
    
    private List<String> imports;
    
    public void init() {
        this.daoPathTemplate = contextConfig.getPathTemplate() + contextConfig.getModuleName() + "\\dao\\{}Dao.java";
        this.xmlPathTemplate = contextConfig.getPathTemplate() + contextConfig.getModuleName() + "\\dao\\mapping\\{}Dao.xml";
        this.packageName = contextConfig.getPackageName() + contextConfig.getModuleName() + ".dao";
        ArrayList<String> imports = new ArrayList<String>();
        imports.add("java.util.List");
        imports.add("java.util.Map");
        imports.add(contextConfig.getPackageName()+contextConfig.getModuleName()+".model."+contextConfig.getBizEnBigName());
        imports.add("org.apache.ibatis.annotations.Param");
        imports.add("wy.core.node.Node");
        imports.add("wy.common.persistence.model.Page");
        this.imports=imports;
    }

    public ContextConfig getContextConfig() {
        return contextConfig;
    }

    public void setContextConfig(ContextConfig contextConfig) {
        this.contextConfig = contextConfig;
    }

    public String getDaoPathTemplate() {
        return daoPathTemplate;
    }

    public void setDaoPathTemplate(String daoPathTemplate) {
        this.daoPathTemplate = daoPathTemplate;
    }

    public String getXmlPathTemplate() {
        return xmlPathTemplate;
    }

    public void setXmlPathTemplate(String xmlPathTemplate) {
        this.xmlPathTemplate = xmlPathTemplate;
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

}
