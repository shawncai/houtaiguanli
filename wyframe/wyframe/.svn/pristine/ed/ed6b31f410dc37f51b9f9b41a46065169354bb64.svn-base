package wy.core.template.engine.base;

import wy.core.template.config.*;

/**
 * 模板生成父类
 *
 * @author fengshuonan
 * @date 2017-05-08 20:17
 */
public class AbstractTemplateEngine {

	protected ContextConfig contextConfig; // 全局配置
	protected ControllerConfig controllerConfig; // 控制器的配置
	protected PageConfig pageConfig; // 页面的控制器
	protected DaoConfig daoConfig; // Dao配置
	protected ServiceConfig serviceConfig; // Service配置
	protected ModelConfig modelConfig; // Model配置
	protected MapperConfig mapperConfig; // Mapper配置
	protected WarpperConfig warpperConfig; // Warpper配置
	protected WSDLConfig wsdlConfig; // wsdl配置

	public void initConfig() {
		if (this.contextConfig == null) {
			this.contextConfig = new ContextConfig();
		}
		if (this.controllerConfig == null) {
			this.controllerConfig = new ControllerConfig();
		}
		if (this.pageConfig == null) {
			this.pageConfig = new PageConfig();
		}
		if (this.daoConfig == null) {
			this.daoConfig = new DaoConfig();
		}
		if (this.serviceConfig == null) {
			this.serviceConfig = new ServiceConfig();
		}
		if (this.modelConfig == null) {
			this.modelConfig = new ModelConfig();
		}
		if (this.mapperConfig == null) {
			this.mapperConfig = new MapperConfig();
		}
		if (this.warpperConfig == null) {
			this.warpperConfig = new WarpperConfig();
		}
		if (this.wsdlConfig == null) {
			this.wsdlConfig = new WSDLConfig();
		}

		this.controllerConfig.setContextConfig(this.contextConfig);
		this.controllerConfig.init();

		this.serviceConfig.setContextConfig(this.contextConfig);
		this.serviceConfig.init();

		this.daoConfig.setContextConfig(this.contextConfig);
		this.daoConfig.init();

		this.pageConfig.setContextConfig(this.contextConfig);
		this.pageConfig.init();

		this.modelConfig.setContextConfig(this.contextConfig);
		this.modelConfig.init();

		this.mapperConfig.setContextConfig(this.contextConfig);
		this.mapperConfig.init();

		this.warpperConfig.setContextConfig(this.contextConfig);
		this.warpperConfig.init();
		
		this.wsdlConfig.setContextConfig(this.contextConfig);
		this.wsdlConfig.init();
	}

	public PageConfig getPageConfig() {
		return pageConfig;
	}

	public void setPageConfig(PageConfig pageConfig) {
		this.pageConfig = pageConfig;
	}

	public ContextConfig getContextConfig() {
		return contextConfig;
	}

	public void setContextConfig(ContextConfig contextConfig) {
		this.contextConfig = contextConfig;
	}

	public ControllerConfig getControllerConfig() {
		return controllerConfig;
	}

	public void setControllerConfig(ControllerConfig controllerConfig) {
		this.controllerConfig = controllerConfig;
	}

	public DaoConfig getDaoConfig() {
		return daoConfig;
	}

	public void setDaoConfig(DaoConfig daoConfig) {
		this.daoConfig = daoConfig;
	}

	public ServiceConfig getServiceConfig() {
		return serviceConfig;
	}

	public void setServiceConfig(ServiceConfig serviceConfig) {
		this.serviceConfig = serviceConfig;
	}

	public ModelConfig getModelConfig() {
		return modelConfig;
	}

	public void setModelConfig(ModelConfig modelConfig) {
		this.modelConfig = modelConfig;
	}

	public MapperConfig getMapperConfig() {
		return mapperConfig;
	}

	public void setMapperConfig(MapperConfig mapperConfig) {
		this.mapperConfig = mapperConfig;
	}

	public WarpperConfig getWarpperConfig() {
		return warpperConfig;
	}

	public void setWarpperConfig(WarpperConfig warpperConfig) {
		this.warpperConfig = warpperConfig;
	}

	public WSDLConfig getWsdlConfig() {
		return wsdlConfig;
	}

	public void setWsdlConfig(WSDLConfig wsdlConfig) {
		this.wsdlConfig = wsdlConfig;
	}
	
	

}
