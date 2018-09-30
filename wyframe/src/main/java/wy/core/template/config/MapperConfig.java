package wy.core.template.config;

import java.util.ArrayList;
import java.util.List;

/**
 * Mapper模板生成配置
 * 
 * @author WyZnn
 *
 */
public class MapperConfig {
	private ContextConfig contextConfig;
	private String mapperPathTemplate;
	private String packageName;
	private String xmlPathTemplate;
	private List<String> mapperImports;
	public void init() {
		ArrayList<String> imports = new ArrayList<String>();
		imports.add("com.baomidou.mybatisplus.mapper.BaseMapper");
		imports.add(contextConfig.getPackageName() + contextConfig.getModuleName() + ".model."
				+ contextConfig.getBizEnBigName());
		this.mapperImports = imports;
		this.xmlPathTemplate = contextConfig.getPathTemplate() + contextConfig.getModuleName()
				+ "\\dao\\mapping\\{}Mapper.xml";
		this.mapperPathTemplate = contextConfig.getPathTemplate() + contextConfig.getModuleName()
				+ "\\dao\\{}Mapper.java";
		this.packageName = contextConfig.getPackageName() + contextConfig.getModuleName() + ".dao";

	}

	public String getXmlPathTemplate() {
		return xmlPathTemplate;
	}

	public void setXmlPathTemplate(String xmlPathTemplate) {
		this.xmlPathTemplate = xmlPathTemplate;
	}

	public ContextConfig getContextConfig() {
		return contextConfig;
	}

	public void setContextConfig(ContextConfig contextConfig) {
		this.contextConfig = contextConfig;
	}

	public String getMapperPathTemplate() {
		return mapperPathTemplate;
	}

	public void setMapperPathTemplate(String mapperPathTemplate) {
		this.mapperPathTemplate = mapperPathTemplate;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public List<String> getMapperImports() {
		return mapperImports;
	}

	public void setMapperImports(List<String> mapperImports) {
		this.mapperImports = mapperImports;
	}

}
