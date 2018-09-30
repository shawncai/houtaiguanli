package wy.core.template.config;

import java.util.ArrayList;
import java.util.List;

/**
 * Warpper模板生成配置
 * 
 * @author WyZnn
 *
 */
public class WarpperConfig {
	private ContextConfig contextConfig;
	private String warpperPathTemplate;
	private String packageName;
	private List<String> warpperImports;

	public void init() {
		ArrayList<String> imports = new ArrayList<String>();
		imports.add("java.util.Map");
		imports.add("wy.common.constant.factory.ConstantFactory");
		imports.add("wy.core.base.warpper.BaseControllerWarpper");
		imports.add("java.util.List");
		imports.add("wy.config.properties.XydProperties");
		imports.add("wy.core.util.SpringContextHolder");
		this.warpperImports = imports;
		this.warpperPathTemplate = contextConfig.getPathTemplate() + contextConfig.getModuleName()
				+ "\\warpper\\{}Warpper.java";
		this.packageName = contextConfig.getPackageName() + contextConfig.getModuleName() + ".warpper";
	}

	public ContextConfig getContextConfig() {
		return contextConfig;
	}

	public void setContextConfig(ContextConfig contextConfig) {
		this.contextConfig = contextConfig;
	}

	public String getWarpperPathTemplate() {
		return warpperPathTemplate;
	}

	public void setWarpperPathTemplate(String warpperPathTemplate) {
		this.warpperPathTemplate = warpperPathTemplate;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public List<String> getWarpperImports() {
		return warpperImports;
	}

	public void setWarpperImports(List<String> warpperImports) {
		this.warpperImports = warpperImports;
	}

}
