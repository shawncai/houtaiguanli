package wy.core.template.engine;

import wy.core.template.engine.base.XydTemplateEngine;
import wy.core.util.ToolUtil;

/**
 * 通用的模板生成引擎
 *
 * @author fengshuonan
 * @date 2017-05-09 20:32
 */
public class SimpleTemplateEngine extends XydTemplateEngine {

	@Override
	protected void generatePageEditHtml() {
		String path = ToolUtil.format(
				super.getContextConfig().getProjectPath() + getPageConfig().getPageEditPathTemplate(),
				super.getContextConfig().getBizEnName(), super.getContextConfig().getBizEnName());
		generateFile("xydTemplate/"+super.getContextConfig().getTemplatePath()+"/page_edit.html.btl", path);
		System.out.println("生成编辑页面成功!");
	}

	@Override
	protected void generatePageAddHtml() {
		String path = ToolUtil.format(
				super.getContextConfig().getProjectPath() + getPageConfig().getPageAddPathTemplate(),
				super.getContextConfig().getBizEnName(), super.getContextConfig().getBizEnName());
		generateFile("xydTemplate/"+super.getContextConfig().getTemplatePath()+"/page_add.html.btl", path);
		System.out.println("生成添加页面成功!");
	}

	@Override
	protected void generatePageInfoJs() {
		String path = ToolUtil.format(
				super.getContextConfig().getProjectPath() + getPageConfig().getPageInfoJsPathTemplate(),
				super.getContextConfig().getBizEnName(), super.getContextConfig().getBizEnName());
		generateFile("xydTemplate/"+super.getContextConfig().getTemplatePath()+"/page_info.js.btl", path);
		System.out.println("生成页面详情js成功!");
	}

	@Override
	protected void generatePageJs() {
		String path = ToolUtil.format(
				super.getContextConfig().getProjectPath() + getPageConfig().getPageJsPathTemplate(),
				super.getContextConfig().getBizEnName(), super.getContextConfig().getBizEnName());
		generateFile("xydTemplate/"+super.getContextConfig().getTemplatePath()+"/page.js.btl", path);
		System.out.println("生成页面js成功!");
	}

	@Override
	protected void generatePageHtml() {
		String path = ToolUtil.format(super.getContextConfig().getProjectPath() + getPageConfig().getPagePathTemplate(),
				super.getContextConfig().getBizEnName(), super.getContextConfig().getBizEnName());
		generateFile("xydTemplate/"+super.getContextConfig().getTemplatePath()+"/page.html.btl", path);
		System.out.println("生成页面成功!");
	}

	@Override
	protected void generateController() {
		String controllerPath = ToolUtil.format(
				super.getContextConfig().getProjectPath() + super.getControllerConfig().getControllerPathTemplate(),
				ToolUtil.firstLetterToUpper(super.getContextConfig().getBizEnName()));
		generateFile("xydTemplate/"+super.getContextConfig().getTemplatePath()+"/Controller.java.btl", controllerPath);
		System.out.println("生成控制器成功!");
	}

	@Override
	protected void generateDao() {
		String daoPath = ToolUtil.format(
				super.getContextConfig().getProjectPath() + super.getDaoConfig().getDaoPathTemplate(),
				ToolUtil.firstLetterToUpper(super.getContextConfig().getBizEnName()));
		generateFile("xydTemplate/"+super.getContextConfig().getTemplatePath()+"/Dao.java.btl", daoPath);
		System.out.println("生成Dao成功!");

		String mappingPath = ToolUtil.format(
				super.getContextConfig().getProjectPath() + super.getDaoConfig().getXmlPathTemplate(),
				ToolUtil.firstLetterToUpper(super.getContextConfig().getBizEnName()));
		generateFile("xydTemplate/"+super.getContextConfig().getTemplatePath()+"/Mapping.xml.btl", mappingPath);
		System.out.println("生成Dao Mapping xml成功!");
	}

	@Override
	protected void generateService() {
		String servicePath = ToolUtil.format(
				super.getContextConfig().getProjectPath() + super.getServiceConfig().getServicePathTemplate(),
				ToolUtil.firstLetterToUpper(super.getContextConfig().getBizEnName()));
		generateFile("xydTemplate/"+super.getContextConfig().getTemplatePath()+"/Service.java.btl", servicePath);
		System.out.println("生成Service成功!");

		String serviceImplPath = ToolUtil.format(
				super.getContextConfig().getProjectPath() + super.getServiceConfig().getServiceImplPathTemplate(),
				ToolUtil.firstLetterToUpper(super.getContextConfig().getBizEnName()));
		generateFile("xydTemplate/"+super.getContextConfig().getTemplatePath()+"/ServiceImpl.java.btl", serviceImplPath);
		System.out.println("生成ServiceImpl成功!");
	}

	@Override
	protected void generateModel() {
		String modelPath = ToolUtil.format(
				super.getContextConfig().getProjectPath() + super.getModelConfig().getModelPathTemplate(),
				ToolUtil.firstLetterToUpper(super.getContextConfig().getBizEnName()));
		generateFile("xydTemplate/"+super.getContextConfig().getTemplatePath()+"/Model.java.btl", modelPath);
		System.out.println("生成Model成功!");
	}

	@Override
	protected void generateMapper() {
		String mapperPath = ToolUtil.format(
				super.getContextConfig().getProjectPath() + super.getMapperConfig().getMapperPathTemplate(),
				ToolUtil.firstLetterToUpper(super.getContextConfig().getBizEnName()));
		generateFile("xydTemplate/"+super.getContextConfig().getTemplatePath()+"/Mapper.java.btl", mapperPath);
		System.out.println("生成Mapper成功!");
		
		String mappingPath = ToolUtil.format(
				super.getContextConfig().getProjectPath() + super.getMapperConfig().getXmlPathTemplate(),
				ToolUtil.firstLetterToUpper(super.getContextConfig().getBizEnName()));
		generateFile("xydTemplate/"+super.getContextConfig().getTemplatePath()+"/Mapper.xml.btl", mappingPath);
		System.out.println("生成Mapper Mapper xml成功!");
	}

	@Override
	protected void generateWarpper() {
		String warpperPath =  ToolUtil.format(
				super.getContextConfig().getProjectPath() + super.getWarpperConfig().getWarpperPathTemplate(),
				ToolUtil.firstLetterToUpper(super.getContextConfig().getBizEnName()));
		generateFile("xydTemplate/"+super.getContextConfig().getTemplatePath()+"/Warpper.java.btl", warpperPath);
		System.out.println("生成Warpper成功!");
	}

	@Override
	protected void generatePageDetailHtml() {
		String path = ToolUtil.format(
				super.getContextConfig().getProjectPath() + getPageConfig().getPageDetailPathTemplate(),
				super.getContextConfig().getBizEnName(), super.getContextConfig().getBizEnName());
		generateFile("xydTemplate/"+super.getContextConfig().getTemplatePath()+"/page_detail.html.btl", path);
		System.out.println("生成详情页面成功!");		
	}

	@Override
	protected void generatePageParamHtml() {
		String path = ToolUtil.format(
				super.getContextConfig().getProjectPath() + getPageConfig().getPageParamPathTemplate(),
				super.getContextConfig().getBizEnName(), super.getContextConfig().getBizEnName());
		generateFile("xydTemplate/"+super.getContextConfig().getTemplatePath()+"/page_addParam.html.btl", path);
		System.out.println("生成参数页面成功!");				
	}

	@Override
	protected void generateWSDL() {
		String path =  ToolUtil.format(
				super.getContextConfig().getProjectPath() + getWsdlConfig().getModelPathTemplate(),
				"WSDLController");
		generateFile("xydTemplate/"+super.getContextConfig().getTemplatePath()+"/wsdlController.java.btl", path);
		System.out.println("生成接口成功!");				
	}
}
