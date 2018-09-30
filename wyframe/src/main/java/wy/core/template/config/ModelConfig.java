package wy.core.template.config;

import java.util.ArrayList;
import java.util.List;

/**
 * Model模板生成的配置
 * 
 * @author Administrator
 *
 */
public class ModelConfig {
	private ContextConfig contextConfig;
	private String modelPathTemplate;
	private String packageName;
	private List<String> imports;

	public void init() {
		ArrayList<String> imports  = new ArrayList<String>();
		imports.add("com.baomidou.mybatisplus.annotations.TableId");
		imports.add("java.util.Date");
		imports.add("java.sql.Timestamp");
		imports.add("com.baomidou.mybatisplus.enums.IdType");
		this.imports=imports;
		this.modelPathTemplate = contextConfig.getPathTemplate() + contextConfig.getModuleName()
				+ "\\model\\{}.java";
		this.packageName = contextConfig.getPackageName() + contextConfig.getModuleName() + ".model";
	}

	public ContextConfig getContextConfig() {
		return contextConfig;
	}

	public void setContextConfig(ContextConfig contextConfig) {
		this.contextConfig = contextConfig;
	}

	public String getModelPathTemplate() {
		return modelPathTemplate;
	}

	public void setModelPathTemplate(String modelPathTemplate) {
		this.modelPathTemplate = modelPathTemplate;
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
