package wy.core.template.config;

/**
 * 页面 模板生成的配置
 *
 * @author fengshuonan
 * @date 2017-05-07 22:12
 */
public class PageConfig {

	private ContextConfig contextConfig;

	private String pagePathTemplate;
	private String pageAddPathTemplate;
	private String pageEditPathTemplate;
	private String pageJsPathTemplate;
	private String pageInfoJsPathTemplate;
	private String pageDetailPathTemplate;
	private String pageParamPathTemplate;
	
	public void init() {
		pagePathTemplate = contextConfig.getPageTemplate() + contextConfig.getModuleName() + "\\{}.html";
		pageAddPathTemplate = contextConfig.getPageTemplate() + contextConfig.getModuleName()
				+ "\\{}_add.html";
		pageEditPathTemplate = contextConfig.getPageTemplate() + contextConfig.getModuleName()
				+ "\\{}_edit.html";
		pageJsPathTemplate = contextConfig.getJsTemplate() + contextConfig.getModuleName() + "\\js\\{}.js";
		pageInfoJsPathTemplate = contextConfig.getJsTemplate() + contextConfig.getModuleName()
				+ "\\js\\{}_info.js";
		pageDetailPathTemplate = contextConfig.getPageTemplate() + contextConfig.getModuleName()
		+ "\\{}_detail.html";
		pageParamPathTemplate = contextConfig.getPageTemplate() + contextConfig.getModuleName()
		+ "\\{}_addParam.html";
	}

	public String getPagePathTemplate() {
		return pagePathTemplate;
	}

	public void setPagePathTemplate(String pagePathTemplate) {
		this.pagePathTemplate = pagePathTemplate;
	}

	public String getPageJsPathTemplate() {
		return pageJsPathTemplate;
	}

	public void setPageJsPathTemplate(String pageJsPathTemplate) {
		this.pageJsPathTemplate = pageJsPathTemplate;
	}

	public String getPageAddPathTemplate() {
		return pageAddPathTemplate;
	}

	public void setPageAddPathTemplate(String pageAddPathTemplate) {
		this.pageAddPathTemplate = pageAddPathTemplate;
	}

	public String getPageEditPathTemplate() {
		return pageEditPathTemplate;
	}

	public void setPageEditPathTemplate(String pageEditPathTemplate) {
		this.pageEditPathTemplate = pageEditPathTemplate;
	}

	public String getPageInfoJsPathTemplate() {
		return pageInfoJsPathTemplate;
	}

	public void setPageInfoJsPathTemplate(String pageInfoJsPathTemplate) {
		this.pageInfoJsPathTemplate = pageInfoJsPathTemplate;
	}

	public ContextConfig getContextConfig() {
		return contextConfig;
	}

	public void setContextConfig(ContextConfig contextConfig) {
		this.contextConfig = contextConfig;
	}

	public String getPageDetailPathTemplate() {
		return pageDetailPathTemplate;
	}

	public void setPageDetailPathTemplate(String pageDetailPathTemplate) {
		this.pageDetailPathTemplate = pageDetailPathTemplate;
	}

	public String getPageParamPathTemplate() {
		return pageParamPathTemplate;
	}

	public void setPageParamPathTemplate(String pageParamPathTemplate) {
		this.pageParamPathTemplate = pageParamPathTemplate;
	}

}
