//package wy.xydframe.system.controller;
//
//import com.alibaba.fastjson.JSON;
//import wy.core.base.controller.BaseController;
//import wy.core.util.ToolUtil;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import wy.common.annotion.Permission;
//import wy.common.constant.Const;
//import wy.common.exception.BizExceptionEnum;
//import wy.common.exception.BussinessException;
//import wy.config.properties.DruidProperties;
//import wy.core.template.config.ContextConfig;
//import wy.core.template.engine.SimpleTemplateEngine;
//import wy.core.template.engine.base.XydTemplateEngine;
//import wy.xydframe.system.dao.DictDao;
//import wy.xydframe.system.dao.MenuDao;
//import wy.xydframe.system.warpper.CodeWarpper;
//
//import javax.annotation.Resource;
//import java.sql.Connection;
//import java.sql.DatabaseMetaData;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * 代码生成控制器
// *
// * @author fengshuonan
// * @Date 2017-05-23 18:52:34
// */
//@Controller
//@RequestMapping("/code")
//public class CodeController extends BaseController {
//
//	private String PREFIX = "/xydframe/code/";
//
//	@Resource
//	DruidProperties druidProperties;
//
//	@Resource
//	MenuDao menuDao;
//
//	@Resource
//	DictDao dictDao;
//
//	/**
//	 * 跳转到代码生成首页
//	 */
//	@RequestMapping("")
//	public String index() {
//		return PREFIX + "code.html";
//	}
//
//	/**
//	 * 跳转接口生成首页
//	 */
//	@RequestMapping("/wsdlindex")
//	public String wsdlindex() {
//		return PREFIX + "wsdlCode.html";
//	}
//
//	/**
//	 *
//	 * 生成table
//	 */
//	@RequestMapping("/typeList/{str}")
//	@ResponseBody
//	public Object typeList(@PathVariable String str) {
//		String[] strs = str.split("-");
//		List<Map<String, String>> list = this.getTableField(strs[1], strs[0]);
//		List<Map<String, String>> typeList = new ArrayList<Map<String, String>>();
//		for (Map<String, String> map : list) {
//			Map<String, String> m = new HashMap<String, String>();
//			if (map.get("columnType").equals("INT")) {
//				m.put("javaType", "Integer");
//				m.put("sqlType", "INT");
//				m.put("columnName", map.get("columnName"));
//				m.put("columnRemark", map.get("columnRemark"));
//				typeList.add(m);
//			} else if (map.get("columnType").equals("VARCHAR")) {
//				m.put("javaType", "String");
//				m.put("sqlType", "VARCHAR");
//				m.put("columnName", map.get("columnName"));
//				m.put("columnRemark", map.get("columnRemark"));
//				typeList.add(m);
//			} else if (map.get("columnType").equals("DECIMAL")) {
//				m.put("javaType", "Double");
//				m.put("sqlType", "DECIMAL");
//				m.put("columnName", map.get("columnName"));
//				m.put("columnRemark", map.get("columnRemark"));
//				typeList.add(m);
//			} else if (map.get("columnType").equals("DATETIME")) {
//				m.put("javaType", "Date");
//				m.put("sqlType", "DATETIME");
//				m.put("columnName", map.get("columnName"));
//				m.put("columnRemark", map.get("columnRemark"));
//				typeList.add(m);
//			} else {
//				m.put("javaType", "unknown");
//				m.put("sqlType", map.get("columnType"));
//				m.put("columnName", map.get("columnName"));
//				m.put("columnRemark", map.get("columnRemark"));
//				typeList.add(m);
//			}
//		}
//		List<Map<String, Object>> dictList = dictDao.dictList();
//		// List<Map<String,String>> dicts = new ArrayList<Map<String,String>>();
//		// for (Map<String, Object> map : dictList) {
//		// Map<String,String> dictMap = new HashMap<String,String>();
//		// dictMap.put("id", map.get("id")+"");
//		// dictMap.put("name", map.get("name")+"");
//		// dicts.add(dictMap);
//		// }
//		// typeList.addAll(dicts);
//
//		return super.warpObject(new CodeWarpper(typeList));
//	}
//
//	/**
//	 *
//	 * 生成table
//	 */
//	@RequestMapping("/typeList2/{str}")
//	@ResponseBody
//	public Object typeList2(@PathVariable String str) {
//		String[] strs = str.split("-");
//		List<Map<String, String>> list = this.getTableField(strs[1], strs[0]);
//		List<Map<String, String>> typeList = new ArrayList<Map<String, String>>();
//		for (Map<String, String> map : list) {
//			Map<String, String> m = new HashMap<String, String>();
//			if (map.get("columnType").equals("INT")) {
//				m.put("javaType", "Integer");
//				m.put("sqlType", "INT");
//				m.put("columnName", map.get("columnName"));
//				m.put("columnRemark", map.get("columnRemark"));
//				typeList.add(m);
//			} else if (map.get("columnType").equals("VARCHAR")) {
//				m.put("javaType", "String");
//				m.put("sqlType", "VARCHAR");
//				m.put("columnName", map.get("columnName"));
//				m.put("columnRemark", map.get("columnRemark"));
//				typeList.add(m);
//			} else if (map.get("columnType").equals("DECIMAL")) {
//				m.put("javaType", "Double");
//				m.put("sqlType", "DECIMAL");
//				m.put("columnName", map.get("columnName"));
//				m.put("columnRemark", map.get("columnRemark"));
//				typeList.add(m);
//			} else if (map.get("columnType").equals("DATETIME")) {
//				m.put("javaType", "Date");
//				m.put("sqlType", "DATETIME");
//				m.put("columnName", map.get("columnName"));
//				m.put("columnRemark", map.get("columnRemark"));
//				typeList.add(m);
//			} else {
//				m.put("javaType", "unknown");
//				m.put("sqlType", map.get("columnType"));
//				m.put("columnName", map.get("columnName"));
//				m.put("columnRemark", map.get("columnRemark"));
//				typeList.add(m);
//			}
//		}
//		List<Map<String, Object>> dictList = dictDao.dictList();
//
//		return super.warpObject(new CodeWarpper(typeList));
//	}
//
//	/**
//	 * 代码生成
//	 */
//	@ApiOperation("生成代码")
//	@ApiImplicitParams({ @ApiImplicitParam(name = "moduleName", value = "模块名称", required = true, dataType = "String"),
//			@ApiImplicitParam(name = "bizChName", value = "业务名称", required = true, dataType = "String"),
//			@ApiImplicitParam(name = "bizEnName", value = "业务英文名称", required = true, dataType = "String"),
//			@ApiImplicitParam(name = "path", value = "项目生成类路径", required = true, dataType = "String"),
//			@ApiImplicitParam(name = "pcodeName", value = "父级菜单名", required = true, dataType = "String"),
//			@ApiImplicitParam(name = "pcode", value = "父级菜单ID", required = true, dataType = "String"),
//			@ApiImplicitParam(name = "add", value = "是否添加添加功能", required = true, dataType = "String"),
//			@ApiImplicitParam(name = "update", value = "是否添加修改功能", required = true, dataType = "String"),
//			@ApiImplicitParam(name = "delete", value = "是否添加删除功能", required = true, dataType = "String"),
//			@ApiImplicitParam(name = "detail", value = "是否添加详情功能", required = true, dataType = "String"),
//			@ApiImplicitParam(name = "table", value = "全部表字段", required = true, dataType = "String"),
//			@ApiImplicitParam(name = "table2", value = "副表字段", required = true, dataType = "String"),
//			@ApiImplicitParam(name = "bizEnName2", value = "副表名称", required = true, dataType = "String"),
//			@ApiImplicitParam(name = "bizEnName3", value = "参数表名称", required = true, dataType = "String"),
//			@ApiImplicitParam(name = "tableName", value = "表名称", required = true, dataType = "String") })
//	@RequestMapping(value = "/generate", method = RequestMethod.POST)
//	@ResponseBody
//	@Permission(Const.ADMIN_NAME)
//	public Object add(String pcodeName, String pcode, String add, String detail, String update, String export,
//			String delete, String moduleName, String bizChName, String bizEnName, String path, String tableName,
//			String table, String bizEnName2, String table2, String bizEnName3) {
//		if (ToolUtil.isOneEmpty(bizChName, bizEnName, tableName, table)) {
//			throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
//		}
//		List<Map<String, String>> li = (List<Map<String, String>>) JSON.parse(table);
//
//		ContextConfig contextConfig = new ContextConfig();
//		contextConfig.setBizChName(bizChName);
//		contextConfig.setBizEnName(bizEnName);
//		contextConfig.setModuleName(moduleName);
//		contextConfig.setUrl(druidProperties.getUrl());
//		contextConfig.setUsername(druidProperties.getUsername());
//		contextConfig.setPassword(druidProperties.getPassword());
//
//		String[] strs = tableName.split("\\.");
//		String[] strs3 = bizEnName3.split("\\.");
//		contextConfig.setDatabaseName(strs[0]);
//		contextConfig.setTableName(strs[1]);
//		if (ToolUtil.isNotEmpty(path)) {
//			contextConfig.setProjectPath(path);
//		}
//		List<Map<String, String>> allRemovePKs = new ArrayList<Map<String, String>>();
//		List<Map<String, String>> PKs = new ArrayList<Map<String, String>>();
//		for (int i = 0; i < li.size(); i++) {
//			li.get(i).put("bColumnName", ToolUtil.firstLetterToUpper(li.get(i).get("columnName")));
//		}
//		contextConfig.setAll(li);
//		if (table2.equals("") || bizEnName2.equals("")) {
//			contextConfig.setAll2(null);
//			contextConfig.setAllRemovePKs2(null);
//			contextConfig.setField02(null);
//			contextConfig.setField12(null);
//			contextConfig.setPKs2(null);
//			contextConfig.setSelectList2(null);
//			contextConfig.setI(0);
//			contextConfig.setAll3(null);
//			contextConfig.setParamTable(null);
//		} else {
//			// 参数表
//			List<Map<String, String>> tableField3 = getTableField(strs3[1], strs3[0]);
//			contextConfig.setAll3(tableField3);
//			contextConfig.setParamTable(strs3[1]);
//			String[] strs2 = bizEnName2.split("\\.");
//			contextConfig.setTable2(strs2[1]);
//			List<Map<String, String>> li2 = (List<Map<String, String>>) JSON.parse(table2);
//			for (int i = 0; i < li2.size(); i++) {
//				li2.get(i).put("bColumnName", ToolUtil.firstLetterToUpper(li2.get(i).get("columnName")));
//			}
//			contextConfig.setAll2(li2);
//			// select集合
//			List<Map<String, String>> selectList = new ArrayList<Map<String, String>>();
//			for (Map<String, String> map : li2) {
//				Map<String, String> select = new HashMap<String, String>();
//				if (map.get("formType").equals("select")) {
//					select.put("columnName", map.get("columnName"));
//					select.put("dictId", map.get("dictId"));
//					selectList.add(select);
//				}
//			}
//			contextConfig.setSelectList2(selectList);
//			//
//			List<Map<String, String>> allRemovePKs2 = new ArrayList<Map<String, String>>();
//			List<Map<String, String>> PKs2 = new ArrayList<Map<String, String>>();
//			for (Map<String, String> map : li2) {
//				for (String pk : this.getPKs(strs2[1], strs2[0])) {
//					if (!pk.equals(map.get("columnName"))) {
//						allRemovePKs2.add(map);
//					} else {
//						PKs2.add(map);
//					}
//				}
//			}
//			ArrayList<Map<String, String>> fields12 = new ArrayList<Map<String, String>>();
//			ArrayList<Map<String, String>> fields02 = new ArrayList<Map<String, String>>();
//			int i = 0;
//			for (Map<String, String> map : allRemovePKs2) {
//				if (i % 2 == 0) {
//					fields12.add(map);
//				} else {
//					fields02.add(map);
//				}
//				i++;
//			}
//			contextConfig.setPKs2(PKs2);
//			contextConfig.setAllRemovePKs2(allRemovePKs2);
//			contextConfig.setField02(fields02);
//			contextConfig.setField12(fields12);
//			contextConfig.setI(1);
//		}
//
//		// select集合
//		List<Map<String, String>> selectList = new ArrayList<Map<String, String>>();
//		for (Map<String, String> map : li) {
//			Map<String, String> select = new HashMap<String, String>();
//			if (map.get("formType").equals("select")) {
//				select.put("columnName", map.get("columnName"));
//				select.put("dictId", map.get("dictId"));
//				selectList.add(select);
//			}
//		}
//		contextConfig.setSelectList(selectList);
//
//		for (Map<String, String> map : li) {
//			for (String pk : this.getPKs(strs[1], strs[0])) {
//				if (!pk.equals(map.get("columnName"))) {
//					allRemovePKs.add(map);
//				} else {
//					PKs.add(map);
//				}
//			}
//		}
//		ArrayList<Map<String, String>> fields1 = new ArrayList<Map<String, String>>();
//		ArrayList<Map<String, String>> fields0 = new ArrayList<Map<String, String>>();
//		int i = 0;
//		for (Map<String, String> map : allRemovePKs) {
//			if (i % 2 == 0) {
//				fields1.add(map);
//			} else {
//				fields0.add(map);
//			}
//			i++;
//		}
//		contextConfig.setPKs(PKs);
//		contextConfig.setAllRemovePKs(allRemovePKs);
//		contextConfig.setColumnNum(allRemovePKs.size());
//		contextConfig.setField0(fields0);
//		contextConfig.setField1(fields1);
//		Map<String, Object> pMap = new HashMap<String, Object>();
//		pMap.put("code", bizEnName);
//		Map<String, Object> pcodeEn = null;
//		if (pcode.equals("0")) {
//			pcodeEn = menuDao.selectMenuById(105);
//			pMap.put("pcode", 0);
//			pMap.put("pcodes", "[0],");
//			pMap.put("name", bizChName + "管理");
//			pMap.put("url", "/" + bizEnName);
//			pMap.put("levels", (int) pcodeEn.get("levels"));
//			pMap.put("isMenu", 1);
//			pMap.put("status", 1);
//			menuDao.addMenu(pMap);
//			if (add.equals("true")) {
//				Map<String, Object> addMap = new HashMap<String, Object>();
//				addMap.put("code", bizEnName + "_add");
//				addMap.put("pcode", bizEnName);
//				addMap.put("pcodes",
//						pcodeEn.get("pcodes")/* +"["+pcodeEn.get("code")+"]," */ + "[" + bizEnName + "],");
//				addMap.put("name", "添加" + bizChName);
//				addMap.put("url", "/" + bizEnName + "/add");
//				addMap.put("levels", (int) pcodeEn.get("levels") + 1);
//				addMap.put("isMenu", 0);
//				addMap.put("status", 1);
//				menuDao.addMenu(addMap);
//			}
//			if (update.equals("true")) {
//				Map<String, Object> updateMap = new HashMap<String, Object>();
//				updateMap.put("code", bizEnName + "_update");
//				updateMap.put("pcode", bizEnName);
//				updateMap.put("pcodes",
//						pcodeEn.get("pcodes")/* +"["+pcodeEn.get("code")+"]," */ + "[" + bizEnName + "],");
//				updateMap.put("name", "修改" + bizChName);
//				updateMap.put("url", "/" + bizEnName + "/update");
//				updateMap.put("levels", (int) pcodeEn.get("levels") + 1);
//				updateMap.put("isMenu", 0);
//				updateMap.put("status", 1);
//				menuDao.addMenu(updateMap);
//			}
//			if (delete.equals("true")) {
//				Map<String, Object> deleteMap = new HashMap<String, Object>();
//				deleteMap.put("code", bizEnName + "_delete");
//				deleteMap.put("pcode", bizEnName);
//				deleteMap.put("pcodes",
//						pcodeEn.get("pcodes")/* +"["+pcodeEn.get("code")+"]," */ + "[" + bizEnName + "],");
//				deleteMap.put("name", "删除" + bizChName);
//				deleteMap.put("url", "/" + bizEnName + "/delete");
//				deleteMap.put("levels", (int) pcodeEn.get("levels") + 1);
//				deleteMap.put("isMenu", 0);
//				deleteMap.put("status", 1);
//				menuDao.addMenu(deleteMap);
//			}
//			if (export.equals("true")) {
//				Map<String, Object> exportMap = new HashMap<String, Object>();
//				exportMap.put("code", bizEnName + "_export");
//				exportMap.put("pcode", bizEnName);
//				exportMap.put("pcodes",
//						pcodeEn.get("pcodes")/* +"["+pcodeEn.get("code")+"]," */ + "[" + bizEnName + "],");
//				exportMap.put("name", "导出" + bizChName);
//				exportMap.put("url", "/" + bizEnName + "/export");
//				exportMap.put("levels", (int) pcodeEn.get("levels") + 1);
//				exportMap.put("isMenu", 0);
//				exportMap.put("status", 1);
//				menuDao.addMenu(exportMap);
//			}
//			if (detail.equals("true")) {
//				Map<String, Object> detailMap = new HashMap<String, Object>();
//				detailMap.put("code", bizEnName + "_detail");
//				detailMap.put("pcode", bizEnName);
//				detailMap.put("pcodes",
//						pcodeEn.get("pcodes")/* +"["+pcodeEn.get("code")+"]," */ + "[" + bizEnName + "],");
//				detailMap.put("name", "详情" + bizChName);
//				detailMap.put("url", "/" + bizEnName + "/detail");
//				detailMap.put("levels", (int) pcodeEn.get("levels") + 1);
//				detailMap.put("isMenu", 0);
//				detailMap.put("status", 1);
//				menuDao.addMenu(detailMap);
//			}
//		} else {
//			pcodeEn = menuDao.selectMenuById(Integer.parseInt(pcode));
//			pMap.put("pcode", pcodeEn.get("code"));
//			pMap.put("pcodes", pcodeEn.get("pcodes") + "[" + pcodeEn.get("code") + "],");
//			pMap.put("name", bizChName + "管理");
//			pMap.put("url", "/" + bizEnName);
//			pMap.put("levels", 1 + (int) pcodeEn.get("levels"));
//			pMap.put("isMenu", 1);
//			pMap.put("status", 1);
//			menuDao.addMenu(pMap);
//			if (add.equals("true")) {
//				Map<String, Object> addMap = new HashMap<String, Object>();
//				addMap.put("code", bizEnName + "_add");
//				addMap.put("pcode", bizEnName);
//				addMap.put("pcodes", pcodeEn.get("pcodes") + "[" + pcodeEn.get("code") + "]," + "[" + bizEnName + "],");
//				addMap.put("name", "添加" + bizChName);
//				addMap.put("url", "/" + bizEnName + "/add");
//				addMap.put("levels", (int) pcodeEn.get("levels") + 2);
//				addMap.put("isMenu", 0);
//				addMap.put("status", 1);
//				menuDao.addMenu(addMap);
//			}
//			if (update.equals("true")) {
//				Map<String, Object> updateMap = new HashMap<String, Object>();
//				updateMap.put("code", bizEnName + "_update");
//				updateMap.put("pcode", bizEnName);
//				updateMap.put("pcodes",
//						pcodeEn.get("pcodes") + "[" + pcodeEn.get("code") + "]," + "[" + bizEnName + "],");
//				updateMap.put("name", "修改" + bizChName);
//				updateMap.put("url", "/" + bizEnName + "/update");
//				updateMap.put("levels", (int) pcodeEn.get("levels") + 2);
//				updateMap.put("isMenu", 0);
//				updateMap.put("status", 1);
//				menuDao.addMenu(updateMap);
//			}
//			if (delete.equals("true")) {
//				Map<String, Object> deleteMap = new HashMap<String, Object>();
//				deleteMap.put("code", bizEnName + "_delete");
//				deleteMap.put("pcode", bizEnName);
//				deleteMap.put("pcodes",
//						pcodeEn.get("pcodes") + "[" + pcodeEn.get("code") + "]," + "[" + bizEnName + "],");
//				deleteMap.put("name", "删除" + bizChName);
//				deleteMap.put("url", "/" + bizEnName + "/delete");
//				deleteMap.put("levels", (int) pcodeEn.get("levels") + 2);
//				deleteMap.put("isMenu", 0);
//				deleteMap.put("status", 1);
//				menuDao.addMenu(deleteMap);
//			}
//			if (export.equals("true")) {
//				Map<String, Object> exportMap = new HashMap<String, Object>();
//				exportMap.put("code", bizEnName + "_export");
//				exportMap.put("pcode", bizEnName);
//				exportMap.put("pcodes",
//						pcodeEn.get("pcodes") + "[" + pcodeEn.get("code") + "]," + "[" + bizEnName + "],");
//				exportMap.put("name", "导出" + bizChName);
//				exportMap.put("url", "/" + bizEnName + "/export");
//				exportMap.put("levels", (int) pcodeEn.get("levels") + 2);
//				exportMap.put("isMenu", 0);
//				exportMap.put("status", 1);
//				menuDao.addMenu(exportMap);
//			}
//			if (detail.equals("true")) {
//				Map<String, Object> detailMap = new HashMap<String, Object>();
//				detailMap.put("code", bizEnName + "_detail");
//				detailMap.put("pcode", bizEnName);
//				detailMap.put("pcodes",
//						pcodeEn.get("pcodes") + "[" + pcodeEn.get("code") + "]," + "[" + bizEnName + "],");
//				detailMap.put("name", "详情" + bizChName);
//				detailMap.put("url", "/" + bizEnName + "/detail");
//				detailMap.put("levels", (int) pcodeEn.get("levels") + 2);
//				detailMap.put("isMenu", 0);
//				detailMap.put("status", 1);
//				menuDao.addMenu(detailMap);
//			}
//		}
//		contextConfig.setWsdlSwitch(false);
//		if (bizEnName2.equals("")) {
//			contextConfig.setParamPageSwitch(false);
//		}
//		XydTemplateEngine xydTemplateEngine = new SimpleTemplateEngine();
//		xydTemplateEngine.setContextConfig(contextConfig);
//		xydTemplateEngine.start();
//		return super.SUCCESS_TIP;
//	}
//
//	@RequestMapping(value = "/wsdlGenerate", method = RequestMethod.POST)
//	@ResponseBody
//	@Permission(Const.ADMIN_NAME)
//	public Object wsdlGenerate(String moduleName, String tableName, String path, String table, String add,
//			String update, String delete, String detail, String list) {
//		ContextConfig contextConfig = new ContextConfig();
//		List<Map<String, String>> lis = (List<Map<String, String>>) JSON.parse(table);
//		String[] strs = tableName.split("\\.");
//		List<Map<String, String>> removepk = new ArrayList<Map<String, String>>();
//		for (Map<String, String> li : lis) {
//			li.put("bColumName", ToolUtil.firstLetterToUpper(li.get("columnName")));
//			Map<String, String> map = new HashMap<String, String>();
//			map.putAll(li);
//			removepk.add(map);
//		}
//		contextConfig.setAdd(add);
//		contextConfig.setUpdate(update);
//		contextConfig.setDelete(delete);
//		contextConfig.setDetail(detail);
//		contextConfig.setList(list);
//		contextConfig.setProjectPath(path);
//		contextConfig.setiTableData(lis);
//		removepk.remove(0); // 去掉主键
//		contextConfig.setiTableDataRemovePK(removepk);
//		contextConfig.setiTableName(strs[1]);
//		contextConfig.setiBigTableName(ToolUtil.firstLetterToUpper(strs[1]));
//		contextConfig.setServiceSwitch(false);
//		contextConfig.setControllerSwitch(false);
//		contextConfig.setIndexPageSwitch(false);
//		contextConfig.setAddPageSwitch(false);
//		contextConfig.setEditPageSwitch(false);
//		contextConfig.setJsSwitch(false);
//		contextConfig.setInfoJsSwitch(false);
//		contextConfig.setDaoSwitch(false);
//		contextConfig.setModelSwitch(false);
//		contextConfig.setMapperSwitch(false);
//		contextConfig.setWarpperSwitch(false);
//		contextConfig.setDetailPageSwitch(false);
//		contextConfig.setParamPageSwitch(false);
//		contextConfig.setModuleName(moduleName);
//		XydTemplateEngine xydTemplateEngine = new SimpleTemplateEngine();
//		xydTemplateEngine.setContextConfig(contextConfig);
//		xydTemplateEngine.start();
//		return super.SUCCESS_TIP;
//	}
//
//	public List<Map<String, String>> getTableField(String tableName, String databaseName) {
//		String url = druidProperties.getUrl();
//		String username = druidProperties.getUsername();
//		String password = druidProperties.getPassword();
//
//		try {
//			Class.forName("com.mysql.jdbc.Driver").newInstance();
//			Connection conn = DriverManager.getConnection(url + "&user=" + username + "&password=" + password);
//			DatabaseMetaData m_DBMetaData = conn.getMetaData();
//			ResultSet colRet = m_DBMetaData.getColumns(null, "%", tableName, "%");
//			List<Map<String, String>> list = new ArrayList<Map<String, String>>();
//			while (colRet.next()) {
//				String columnName = colRet.getString("COLUMN_NAME");
//				String columnType = colRet.getString("TYPE_NAME");
//				String columnRemark = colRet.getString("REMARKS");
//				Map<String, String> map = new HashMap<String, String>();
//				map.put("columnName", columnName);
//				map.put("columnType", columnType);
//				map.put("columnRemark", columnRemark);
//				list.add(map);
//			}
//			return list;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//
//	}
//
//	public List<String> getPKs(String tableName, String databaseName) {
//		String url = druidProperties.getUrl();
//		String username = druidProperties.getUsername();
//		String password = druidProperties.getPassword();
//		try {
//			Class.forName("com.mysql.jdbc.Driver").newInstance();
//			Connection conn = DriverManager.getConnection(url + "&user=" + username + "&password=" + password);
//			DatabaseMetaData m_DBMetaData = conn.getMetaData();
//			ResultSet primaryKeys = m_DBMetaData.getPrimaryKeys(databaseName, null, tableName);
//			List<String> list = new ArrayList<String>();
//			while (primaryKeys.next()) {
//				list.add(primaryKeys.getString("COLUMN_NAME"));
//			}
//			return list;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return null;
//	}
//}
