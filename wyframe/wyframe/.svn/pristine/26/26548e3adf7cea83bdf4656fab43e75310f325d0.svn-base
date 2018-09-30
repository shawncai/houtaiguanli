package wy.core.template.config;

import java.util.ArrayList;
import java.util.List;

public class WSDLConfig {
	private ContextConfig contextConfig;
	private String modelPathTemplate;
	private String packageName;
	private List<String> imports;

	public void init() {
		ArrayList<String> imports = new ArrayList<String>();
		imports.add("wy.common.controller.BaseController");
		imports.add("org.springframework.stereotype.Controller");
		imports.add("org.springframework.web.bind.annotation.RequestMapping");
		imports.add("org.springframework.web.bind.annotation.ResponseBody");
		imports.add("java.util.ArrayList");
		imports.add("java.util.Map");
		imports.add("java.util.List");
		imports.add("io.swagger.annotations.Api");
		imports.add("io.swagger.annotations.ApiParam");
		imports.add("java.util.HashMap");
		imports.add("org.springframework.web.bind.annotation.RequestMethod");
		imports.add("java.util.Date");
		imports.add("org.springframework.web.bind.annotation.RequestBody");
		imports.add("javax.annotation.Resource");
		imports.add("org.springframework.web.bind.annotation.RequestParam");
		imports.add("io.swagger.annotations.ApiImplicitParam");
		imports.add("io.swagger.annotations.ApiImplicitParams");
		imports.add("io.swagger.annotations.ApiOperation");
		imports.add("wy.xydframe."+contextConfig.getModuleName()+".dao.*");
		imports.add("wy.xydframe."+contextConfig.getModuleName()+".model.*");
		this.imports = imports;
		this.modelPathTemplate = "\\src\\main\\java\\com\\wy\\xyd\\core\\wsdl\\{}.java";
		this.packageName = "wy.core.wsdl";
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

	public List<String> getImports() {
		return imports;
	}

	public void setImports(List<String> imports) {
		this.imports = imports;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

}
