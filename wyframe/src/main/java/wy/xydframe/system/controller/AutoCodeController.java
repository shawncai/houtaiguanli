package wy.xydframe.system.controller;

import com.alibaba.fastjson.JSON;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import wy.common.annotion.Permission;
import wy.common.constant.Const;
import wy.config.properties.DruidProperties;
import wy.core.base.controller.BaseController;
import wy.core.template.config.ContextConfig;
import wy.core.template.engine.SimpleTemplateEngine;
import wy.core.template.engine.base.XydTemplateEngine;
import wy.core.util.ToolUtil;
import wy.xydframe.system.dao.MenuDao;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

/**
 * Created by Administrator on 2018/7/5 0005.
 */
@Controller
@RequestMapping("/autoCode")
public class AutoCodeController extends BaseController {
    private String PREFIX = "/xydframe/autoCode/";

    @Resource
    DruidProperties druidProperties;

    @Resource
    DataSource dataSource;

    @Resource
    MenuDao menuDao;

    /**
     * 1.跳转到代码生成首页
     * 2.初始化数据源下拉列表
     */
    @RequestMapping("")
    public String index(Model model, HttpServletRequest request) throws SQLException {
        model.addAttribute("dataBase", getDataBases());
        List<Map<String, Object>> tables = getTables();
        model.addAttribute("tables", tables);
        // 获得项目的路径
        ServletContext sc = request.getSession().getServletContext();

        model.addAttribute("path", sc.getRealPath("/").split("\\\\src\\\\")[0]);
        System.err.println(sc.getRealPath("/").split("\\\\src\\\\")[0]);
        return PREFIX + "autoCode.html";
    }

    /**
     * 自动代码生成
     */
    @ApiOperation("生成代码")
    @ApiImplicitParams({@ApiImplicitParam(name = "moduleName", value = "模块名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "bizChName", value = "业务名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "bizEnName", value = "业务英文名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "path", value = "项目生成类路径", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pcodeName", value = "父级菜单名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pcode", value = "父级菜单ID", required = true, dataType = "String"),
            @ApiImplicitParam(name = "add", value = "是否添加添加功能", required = true, dataType = "String"),
            @ApiImplicitParam(name = "update", value = "是否添加修改功能", required = true, dataType = "String"),
            @ApiImplicitParam(name = "delete", value = "是否添加删除功能", required = true, dataType = "String"),
            @ApiImplicitParam(name = "detail", value = "是否添加详情功能", required = true, dataType = "String"),
            @ApiImplicitParam(name = "export", value = "是否添加导出功能", required = true, dataType = "String"),
            @ApiImplicitParam(name = "print", value = "是否添加打印功能", required = true, dataType = "String"),
            @ApiImplicitParam(name = "layout", value = "表单分列", required = true, dataType = "String"),
            @ApiImplicitParam(name = "project", value = "工程名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "table", value = "全部表字段", required = true, dataType = "String")})
    @RequestMapping(value = "/generate", method = RequestMethod.POST)
    @ResponseBody
    @Permission(Const.ADMIN_NAME)
    public Object add(String pcodeName, String pcode, String add, String detail, String update, String export,
                      String delete, String moduleName, String bizChName, String bizEnName, String path,
                      String table, String layout, String print,String project) {
//        if (ToolUtil.isOneEmpty(bizChName, bizEnName, table,moduleName,path)) {
//            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
//        }
        List<Map<String, Object>> list = (List<Map<String, Object>>) JSON.parse(table.replaceAll("\\[],","").replaceAll(",\\[]",""));
        System.err.println("list:"+list);
        Collections.sort(list, new Comparator<Map<String, Object>>() {
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                Integer name1 = Integer.valueOf(o1.get("order").toString()) ;//name1是从你list里面拿出来的一个
                Integer name2 = Integer.valueOf(o2.get("order").toString()) ; //name1是从你list里面拿出来的第二个name
                return name1.compareTo(name2);
            }
        });
//        //添加字段，页面表单
        int i = 0;
        //下面代码在list中添加有用字段
        for (Map<String, Object> map : list) {
            //添加字段，大写字母开头
            map.put("bColumnName", ToolUtil.firstLetterToUpper(map.get("columnName").toString()));
            //添加字段listColumn，列表ID字段变成名称
            if ("2".equals(map.get("fieldChange").toString())) {
                map.put("listColumn", map.get("toField"));
            } else {
                map.put("listColumn", map.get("columnName"));
            }
            //表单元素写进list
            //input
            if ("0".equals(map.get("formType").toString())) {
                if ("1".equals(map.get("addPage").toString())){
                    map.put("addForm", "<#inputCol" + layout + " id='" + map.get("columnName") + "' name='" + map.get("columnRemark") + "' />");
                }
                if ("1".equals(map.get("editPage").toString())) {
                    map.put("editForm", "<#inputCol" + layout + " id='" + map.get("columnName") + "' name='" + map.get("columnRemark") + "' value='${" + bizEnName + "." + map.get("columnName") + "}' />");
                }    if ("1".equals(map.get("detailPage").toString())) {
                    map.put("detailForm", "<#inputCol" + layout + " id='" + map.get("columnName") + "' name='" + map.get("columnRemark") + "' value='${" + bizEnName + "." + map.get("columnName") + "}' readonly='readonly'/>");
                }
                //select
            } else if ("1".equals(map.get("formType").toString())) {
                if ("1".equals(map.get("addPage").toString())){
                    map.put("addForm", "<#selectCol" + layout + " id='" + map.get("columnName") + "' name='" + map.get("columnRemark") + "' map='${map" + i + "}' />");
                }
                if ("1".equals(map.get("editPage").toString())) {
                    map.put("editForm","<#selectCol" + layout + " id='" + map.get("columnName") + "' name='" + map.get("columnRemark") + "' map='${map" + i + "}'  value='${"+bizEnName+"."+map.get("columnName")+"}' />");
                }
                if ("1".equals(map.get("detailPage").toString())) {
                    map.put("detailForm","<#selectCol" + layout + " id='" + map.get("columnName") + "' name='" + map.get("columnRemark") + "' map='${map" + i + "}' value='${"+bizEnName+"."+map.get("columnName")+"}' />");
                }
            //2.tree
            }else if("2".equals(map.get("formType").toString())){
                if ("1".equals(map.get("addPage").toString())){
                    map.put("addForm","<#treeCol"+layout+" id'="+map.get("columnName")+"Nm' hidden="+map.get("columnName")+"' name='"+map.get("columnRemark")+"' " +
                            "clickFun='"+ToolUtil.firstLetterToUpper(bizEnName)+"InfoDlg.show"+map.get("columnName")+"SelectTree(); return false;'" +
                            "style='background-color: #ffffff !important;' selectFlag='true'" +
                            "selectId='"+map.get("columnName")+"TreeDiv' selectTreeId='"+map.get("columnName")+"Tree'" +
                            "selectStyle='width:213px !important;margin-left: 239px' />");
                }
                if ("1".equals(map.get("editPage").toString())) {
                    map.put("editForm","<#treeCol"+layout+" id'="+map.get("columnName")+"Nm' hidden="+map.get("columnName")+"' hiddenValue='${"+bizEnName+"."+map.get("columnName")+"}' value='${"+map.get("columnName")+"Nm}' name='"+map.get("columnRemark")+"' " +
                            "clickFun='"+ToolUtil.firstLetterToUpper(bizEnName)+"InfoDlg.show"+map.get("columnName")+"SelectTree(); return false;'" +
                            "style='background-color: #ffffff !important;' selectFlag='true'" +
                            "selectId='"+map.get("columnName")+"TreeDiv' selectTreeId='"+map.get("columnName")+"Tree'" +
                            "selectStyle='width:213px !important;margin-left: 239px' />");
                }
                if ("1".equals(map.get("detailPage").toString())) {
                    map.put("detailForm","<#treeCol"+layout+" id'="+map.get("columnName")+"Nm' hidden="+map.get("columnName")+"' hiddenValue='${"+bizEnName+"."+map.get("columnName")+"}' value='${"+map.get("columnName")+"Nm}' name='"+map.get("columnRemark")+"'  " +
                            "clickFun='"+ToolUtil.firstLetterToUpper(bizEnName)+"InfoDlg.show"+map.get("columnName")+"SelectTree(); return false;'" +
                            "style='background-color: #ffffff !important;' selectFlag='true'" +
                            "selectId='"+map.get("columnName")+"TreeDiv' selectTreeId='"+map.get("columnName")+"Tree'" +
                            "selectStyle='width:213px !important;margin-left: 239px'  readonly='readonly' />");
                }
                //3.checkbox
            }else if ("3".equals((map.get("formType").toString()))){
                if ("1".equals(map.get("addPage").toString())){
                    map.put("addForm","<#checkboxcol"+layout+" id='" + map.get("columnName") + "' name='" + map.get("columnRemark") + "' />");
                }
                if ("1".equals(map.get("editPage").toString())) {
                    map.put("editForm","<#checkboxcol" + layout + " id='" + map.get("columnName") + "' name='" + map.get("columnRemark") + "' value='${"+bizEnName+"."+map.get("columnName")+"}' />");
                }
                if ("1".equals(map.get("detailPage").toString())) {
                    map.put("detailForm","<#checkboxcol" + layout + " id='" + map.get("columnName") + "' name='" + map.get("columnRemark") + "' value='${"+bizEnName+"."+map.get("columnName")+"}' readonly='readonly'/>");
                }

                //4.日期选择器
            }else if("4".equals((map.get("formType").toString()))){
                if ("1".equals(map.get("addPage").toString())){
                    map.put("addForm","<#timeinputcol"+layout+" id='" + map.get("columnName") + "' name='" + map.get("columnRemark") + "' />");
                }
                if ("1".equals(map.get("editPage").toString())) {
                    map.put("editForm","<#timeinputcol" + layout + " id='" + map.get("columnName") + "' name='" + map.get("columnRemark") + "' value='${"+bizEnName+"."+map.get("columnName")+"}' />");
                }
                if ("1".equals(map.get("detailPage").toString())) {
                    map.put("detailForm","<#timeinputcol" + layout + " id='" + map.get("columnName") + "' name='" + map.get("columnRemark") + "' value='${"+bizEnName+"."+map.get("columnName")+"}' readonly='readonly'/>");
                }
            //5.文本域
            }else if("5".equals((map.get("formType").toString()))){
                if ("1".equals(map.get("addPage").toString())){
                    map.put("addForm","<#textareacol"+layout+" id='" + map.get("columnName") + "' name='" + map.get("columnRemark") + "' />");
                }
                if ("1".equals(map.get("editPage").toString())) {
                    map.put("editForm","<#textareacol" + layout + " id='" + map.get("columnName") + "' name='" + map.get("columnRemark") + "' value='${"+bizEnName+"."+map.get("columnName")+"}' />");
                }
                if ("1".equals(map.get("detailPage").toString())) {
                    map.put("detailForm","<#textareacol" + layout + " id='" + map.get("columnName") + "' name='" + map.get("columnRemark") + "' value='${"+bizEnName+"."+map.get("columnName")+"}' readonly='readonly'/>");
                }
            }else if("6".equals((map.get("formType").toString()))){
                if ("1".equals(map.get("addPage").toString())){
                    map.put("addForm","<#photo id='" + map.get("columnName") + "' name='" + map.get("columnRemark") + "' />");
                }
                if ("1".equals(map.get("editPage").toString())) {
                    map.put("editForm","<#photo id='" + map.get("columnName") + "' name='" + map.get("columnRemark") + "' value='${"+bizEnName+"."+map.get("columnName")+"}' />");
                }
                if ("1".equals(map.get("detailPage").toString())) {
                    map.put("detailForm","<#photo id='" + map.get("columnName") + "' name='" + map.get("columnRemark") + "' value='${"+bizEnName+"."+map.get("columnName")+"}' readonly='readonly'/>");
                }
            }
            i++;
        }
        //模板总配置
        ContextConfig contextConfig = new ContextConfig();
        // 业务名称
        contextConfig.setBizChName(bizChName);
        // 业务英文名称
        contextConfig.setBizEnName(bizEnName);
        // 模块名称
        contextConfig.setModuleName(moduleName);
        //业务英文名称（大写),类名
        contextConfig.setBizEnBigName(ToolUtil.firstLetterToUpper(bizEnName));
        //表名
        contextConfig.setTableName(bizEnName);
        //路径
//        contextConfig.setProjectPath("C:\\workspace\\wyframe");
        contextConfig.setProjectPath(path);
        //包路径
        contextConfig.setPackageName("wy.addons."+project+".");
        //后台文件存放路径
        contextConfig.setPathTemplate("\\src\\main\\java\\wy\\addons\\"+project+"\\");
        //页面存放路径
        contextConfig.setPageTemplate("\\src\\main\\webapp\\WEB-INF\\view\\addons\\"+project+"\\");
        //js文件存放路径
        contextConfig.setJsTemplate("\\src\\main\\webapp\\static\\addons\\"+project+"\\");
        //js路径
        contextConfig.setScriptPath("addons/"+project);
        //模板路徑
        contextConfig.setTemplatePath("zcgl");
        //内容
        contextConfig.setList(list);
        contextConfig.setLayout(Integer.parseInt(layout));
        XydTemplateEngine xydTemplateEngine = new SimpleTemplateEngine();
        xydTemplateEngine.setContextConfig(contextConfig);
        xydTemplateEngine.start();
        addMenu(bizEnName, bizChName, pcode, add, delete, update, export, detail, print);
        return super.SUCCESS_TIP;
    }

    /**
     * columnName
     * columnType
     * columnRemark
     * javaType
     * formType
     * isSearch
     * checkType
     * isQuery
     * fixed
     * selectParam
     * treeParam
     * isLeftTree
     * leftTreeParam
     * isOrder
     * fieldChange
     * fieldTable
     * toField
     * order
     *
     * @param tableName
     * @return
     * @throws SQLException
     */
    @RequestMapping("/initTable/{tableName}")
    @ResponseBody
    public List<Map<String, Object>> initTable(@PathVariable String tableName) throws Exception {
        List<Map<String, Object>> tableFields = getTableFields(tableName);
        //java类型
        Map<String, Object> javaType = getJavaType();
        for (Map<String,Object> map : tableFields) {
            map.put("formType", 0);  //表单类型  0.input 1.select    2.tree  3.checkBox 4.time  5.textArea  6.img
            map.put("isSearch", 0);     // 是否增加为搜索条件(表单自带搜索) 0.不增加    1.增加
            map.put("checkType", 0); //检验规则  0.非空    1.手机    2.邮箱    3.中文    4.英文    5.数字    6.自定义
            map.put("isQuery", 0);   //是否增加为查询条件(新增的查询功能) 0.不增加    1.增加
            map.put("queryDict", "");   //查询字段从字典取
            map.put("fixed", ""); //0.不固定 1.左边固定 2.右边固定
            map.put("selectParam", "");
            map.put("treeParam", "");
            map.put("isOrder", true);   //0.无字段排序功能  1.有字段排序功能
            map.put("fieldChange", 0); //0.不改变 1.字典  2.表字段
            map.put("toField", "");  //需要变成的字段名
            map.put("fieldTable", "");//如果fieldChange选择为表字段，请指定表名，如果是字典，请定字典名
            map.put("order", 1);    //表格内容调整顺序专用
            map.put("width", "120");
            map.put("tablePage",1);
            map.put("addPage",1);
            map.put("editPage",1);
            map.put("detailPage",1);
            map.put("excelPage",1);
            map.put("printPage",1);
            //mysql Type--->java Type
            if (null != javaType.get(map.get("columnType"))) {
                map.put("javaType", javaType.get(map.get("columnType")));
            } else {
                map.put("javaType", "unknown");
            }
        }
        return tableFields;
    }

    /**
     * 获取表字段
     *
     * @param tableName
     * @return
     */
    public List<Map<String, Object>> getTableFields(String tableName)  throws Exception{
        Connection conn = null;
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            conn = dataSource.getConnection();
            //获取表字段
            ResultSet columns1 = this.getDatabaseMetaData().getColumns(null, "%", tableName, "%");
            int i=0;
            while (columns1.next()) {
                if (columns1.getString("COLUMN_NAME").equals("xyd_st_id")){
                   i=1;
                }
            }
            if(i==0){
                PreparedStatement ps = conn.prepareStatement("ALTER TABLE "+tableName+" ADD COLUMN xyd_st_id  INT(4) DEFAULT NULL COMMENT '删除状态';");
            ps.executeUpdate();
            PreparedStatement ps1 = conn.prepareStatement( "ALTER TABLE "+tableName+" ADD COLUMN xyd_cre_dt  datetime DEFAULT NULL COMMENT '创建日期';");
            ps1.executeUpdate();
            PreparedStatement ps2 = conn.prepareStatement("ALTER TABLE "+tableName+" ADD COLUMN xyd_up_dt  datetime DEFAULT NULL COMMENT '修改日期';" );
            ps2.executeUpdate();
            PreparedStatement ps3 = conn.prepareStatement("ALTER TABLE "+tableName+" ADD COLUMN id  INT(11) DEFAULT NULL COMMENT '操作用户';");
            ps3.executeUpdate();
            }
            ResultSet columns = this.getDatabaseMetaData().getColumns(null, "%", tableName, "%");
            while (columns.next()) {
                Map<String, Object> map = new HashMap<>();
                //字段名称
                map.put("columnName", columns.getString("COLUMN_NAME"));
                //字段类型
                map.put("columnType", columns.getString("TYPE_NAME"));
                //字段备注
                map.put("columnRemark", columns.getString("REMARKS"));
                list.add(map);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
}

    /**
     * 获取数据库表名
     *
     * @return
     * @throws SQLException
     */
    public List<Map<String, Object>> getTables() throws SQLException {
        //获取全部表名
        ResultSet tables = this.getDatabaseMetaData().getTables(null, null, null, new String[]{"TABLE"});
        List<Map<String, Object>> list = new ArrayList<>();
        while (tables.next()) {
            Map<String, Object> map = new HashMap<>();
            //表名称
            map.put("num", tables.getString("TABLE_NAME"));
            //表类型
            map.put("tableType", tables.getString("TABLE_TYPE"));
            //表所属数据库
            map.put("tableCat", tables.getString("TABLE_CAT"));
            //表所属用户名
            map.put("tableSchem", tables.getString("TABLE_SCHEM"));
            //表备注
            map.put("name", tables.getString("TABLE_NAME"));
//            map.put("name", tables.getString("REMARKS"));
            list.add(map);
        }
        return list;
    }

    /**
     * 获取数据库名称
     * 需要多数据源可重写此方法获取数据库名称
     */
    public String getDataBases() {
        String url = druidProperties.getUrl();
        String[] split = url.split("\\?");
        String dataBase = StringUtils.substringAfterLast(split[0], "/");
        return dataBase;
    }

    /**
     * 获取DatabaseMetaData元数据
     * 需要修改元数据获取方式请修改此方法
     */
    public DatabaseMetaData getDatabaseMetaData() throws SQLException {
        Connection conn = dataSource.getConnection();
        DatabaseMetaData dbMetaData = conn.getMetaData();
        return dbMetaData;
    }

    /**
     * 获取表主键
     *
     * @param tableName
     * @return
     */
    public List<Map<String, Object>> getPrimaryKeys(String tableName) throws SQLException {
        ResultSet primaryKeys = getDatabaseMetaData().getPrimaryKeys(null, null, tableName);
        List<Map<String, Object>> list = new ArrayList<>();
        while (primaryKeys.next()) {
            Map<String, Object> map = new HashMap<>();
            //主键名称
            map.put("columnName", primaryKeys.getString("COLUMN_NAME"));
            //主键类型
            map.put("typeName", primaryKeys.getString("TYPE_NAME"));
            //主键备注
            map.put("columnRemark", primaryKeys.getString("REMARKS"));
            list.add(map);
        }
        return list;
    }

    /**
     * mysql Type-->java Type
     * 配置java类型，需要增加或修改请修改此方法
     *
     * @return
     */
    public Map<String, Object> getJavaType() {
        Map<String, Object> map = new HashMap<>();
        map.put("VARCHAR", "String");
        map.put("INT", "Integer");
        map.put("DECIMAL", "Double");
        map.put("FLOAT", "Float");
        map.put("DATE", "String");
        map.put("TIME", "String");
        map.put("TEXT", "String");
        map.put("DATETIME", "String");
        map.put("TIMESTAMP", "String");
        /* */
        return map;
    }

    /**
     * 页面元素写在list中，需要添加类型修改此方法
     * 表单类型  1.input 2.select    3.tree  4.checkBox 5.time  6.textArea
     *
     * @return
     */
    public Map<String, String> getPageForm() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "input");
        map.put("2", "select");
        map.put("3", "tree");
        map.put("4", "checkBox");
        map.put("5", "time");
        map.put("6", "textArea");
        return map;
    }

    /**
     * 添加菜单
     * @param bizEnName
     * @param bizChName
     * @param pcode
     * @param add
     * @param delete
     * @param update
     * @param export
     * @param detail
     * @param print
     * @return
     */
    public boolean addMenu(String bizEnName, String bizChName, String pcode, String add, String delete, String update, String export, String detail, String print) {
        Map<String, Object> pMap = new HashMap<String, Object>();
        pMap.put("code", bizEnName);
        Map<String, Object> pcodeEn = null;
        if (pcode.equals("0")) {
            pcodeEn = menuDao.selectMenuById(105);
            pMap.put("pcode", 0);
            pMap.put("pcodes", "[0],");
            pMap.put("name", bizChName + "管理");
            pMap.put("url", "/" + bizEnName);
            pMap.put("levels", (int) pcodeEn.get("levels"));
            pMap.put("isMenu", 1);
            pMap.put("status", 1);
            menuDao.addMenu(pMap);
            if (add.equals("true")) {
                Map<String, Object> addMap = new HashMap<String, Object>();
                addMap.put("code", bizEnName + "_add");
                addMap.put("pcode", bizEnName);
                addMap.put("pcodes",
                        pcodeEn.get("pcodes")/* +"["+pcodeEn.get("code")+"]," */ + "[" + bizEnName + "],");
                addMap.put("name", "添加" + bizChName);
                addMap.put("url", "/" + bizEnName + "/add");
                addMap.put("levels", (int) pcodeEn.get("levels") + 1);
                addMap.put("isMenu", 0);
                addMap.put("status", 1);
                menuDao.addMenu(addMap);
            }
            if (update.equals("true")) {
                Map<String, Object> updateMap = new HashMap<String, Object>();
                updateMap.put("code", bizEnName + "_update");
                updateMap.put("pcode", bizEnName);
                updateMap.put("pcodes",
                        pcodeEn.get("pcodes")/* +"["+pcodeEn.get("code")+"]," */ + "[" + bizEnName + "],");
                updateMap.put("name", "修改" + bizChName);
                updateMap.put("url", "/" + bizEnName + "/update");
                updateMap.put("levels", (int) pcodeEn.get("levels") + 1);
                updateMap.put("isMenu", 0);
                updateMap.put("status", 1);
                menuDao.addMenu(updateMap);
            }
            if (delete.equals("true")) {
                Map<String, Object> deleteMap = new HashMap<String, Object>();
                deleteMap.put("code", bizEnName + "_delete");
                deleteMap.put("pcode", bizEnName);
                deleteMap.put("pcodes",
                        pcodeEn.get("pcodes")/* +"["+pcodeEn.get("code")+"]," */ + "[" + bizEnName + "],");
                deleteMap.put("name", "删除" + bizChName);
                deleteMap.put("url", "/" + bizEnName + "/delete");
                deleteMap.put("levels", (int) pcodeEn.get("levels") + 1);
                deleteMap.put("isMenu", 0);
                deleteMap.put("status", 1);
                menuDao.addMenu(deleteMap);
            }
            if (export.equals("true")) {
                Map<String, Object> exportMap = new HashMap<String, Object>();
                exportMap.put("code", bizEnName + "_export");
                exportMap.put("pcode", bizEnName);
                exportMap.put("pcodes",
                        pcodeEn.get("pcodes")/* +"["+pcodeEn.get("code")+"]," */ + "[" + bizEnName + "],");
                exportMap.put("name", "导出" + bizChName);
                exportMap.put("url", "/" + bizEnName + "/export");
                exportMap.put("levels", (int) pcodeEn.get("levels") + 1);
                exportMap.put("isMenu", 0);
                exportMap.put("status", 1);
                menuDao.addMenu(exportMap);
            }
            if (detail.equals("true")) {
                Map<String, Object> detailMap = new HashMap<String, Object>();
                detailMap.put("code", bizEnName + "_detail");
                detailMap.put("pcode", bizEnName);
                detailMap.put("pcodes",
                        pcodeEn.get("pcodes")/* +"["+pcodeEn.get("code")+"]," */ + "[" + bizEnName + "],");
                detailMap.put("name", "详情" + bizChName);
                detailMap.put("url", "/" + bizEnName + "/detail");
                detailMap.put("levels", (int) pcodeEn.get("levels") + 1);
                detailMap.put("isMenu", 0);
                detailMap.put("status", 1);
                menuDao.addMenu(detailMap);
            }
        } else {
            pcodeEn = menuDao.selectMenuById(Integer.parseInt(pcode));
            pMap.put("pcode", pcodeEn.get("code"));
            pMap.put("pcodes", pcodeEn.get("pcodes") + "[" + pcodeEn.get("code") + "],");
            pMap.put("name", bizChName + "管理");
            pMap.put("url", "/" + bizEnName);
            pMap.put("levels", 1 + (int) pcodeEn.get("levels"));
            pMap.put("isMenu", 1);
            pMap.put("status", 1);
            menuDao.addMenu(pMap);
            if (add.equals("true")) {
                Map<String, Object> addMap = new HashMap<String, Object>();
                addMap.put("code", bizEnName + "_add");
                addMap.put("pcode", bizEnName);
                addMap.put("pcodes", pcodeEn.get("pcodes") + "[" + pcodeEn.get("code") + "]," + "[" + bizEnName + "],");
                addMap.put("name", "添加" + bizChName);
                addMap.put("url", "/" + bizEnName + "/add");
                addMap.put("levels", (int) pcodeEn.get("levels") + 2);
                addMap.put("isMenu", 0);
                addMap.put("status", 1);
                menuDao.addMenu(addMap);
            }
            if (update.equals("true")) {
                Map<String, Object> updateMap = new HashMap<String, Object>();
                updateMap.put("code", bizEnName + "_update");
                updateMap.put("pcode", bizEnName);
                updateMap.put("pcodes",
                        pcodeEn.get("pcodes") + "[" + pcodeEn.get("code") + "]," + "[" + bizEnName + "],");
                updateMap.put("name", "修改" + bizChName);
                updateMap.put("url", "/" + bizEnName + "/update");
                updateMap.put("levels", (int) pcodeEn.get("levels") + 2);
                updateMap.put("isMenu", 0);
                updateMap.put("status", 1);
                menuDao.addMenu(updateMap);
            }
            if (delete.equals("true")) {
                Map<String, Object> deleteMap = new HashMap<String, Object>();
                deleteMap.put("code", bizEnName + "_delete");
                deleteMap.put("pcode", bizEnName);
                deleteMap.put("pcodes",
                        pcodeEn.get("pcodes") + "[" + pcodeEn.get("code") + "]," + "[" + bizEnName + "],");
                deleteMap.put("name", "删除" + bizChName);
                deleteMap.put("url", "/" + bizEnName + "/delete");
                deleteMap.put("levels", (int) pcodeEn.get("levels") + 2);
                deleteMap.put("isMenu", 0);
                deleteMap.put("status", 1);
                menuDao.addMenu(deleteMap);
            }
            if (export.equals("true")) {
                Map<String, Object> exportMap = new HashMap<String, Object>();
                exportMap.put("code", bizEnName + "_export");
                exportMap.put("pcode", bizEnName);
                exportMap.put("pcodes",
                        pcodeEn.get("pcodes") + "[" + pcodeEn.get("code") + "]," + "[" + bizEnName + "],");
                exportMap.put("name", "导出" + bizChName);
                exportMap.put("url", "/" + bizEnName + "/export");
                exportMap.put("levels", (int) pcodeEn.get("levels") + 2);
                exportMap.put("isMenu", 0);
                exportMap.put("status", 1);
                menuDao.addMenu(exportMap);
            }
            if (detail.equals("true")) {
                Map<String, Object> detailMap = new HashMap<String, Object>();
                detailMap.put("code", bizEnName + "_detail");
                detailMap.put("pcode", bizEnName);
                detailMap.put("pcodes",
                        pcodeEn.get("pcodes") + "[" + pcodeEn.get("code") + "]," + "[" + bizEnName + "],");
                detailMap.put("name", "详情" + bizChName);
                detailMap.put("url", "/" + bizEnName + "/detail");
                detailMap.put("levels", (int) pcodeEn.get("levels") + 2);
                detailMap.put("isMenu", 0);
                detailMap.put("status", 1);
                menuDao.addMenu(detailMap);
            }
        }
        return true;
    }
}