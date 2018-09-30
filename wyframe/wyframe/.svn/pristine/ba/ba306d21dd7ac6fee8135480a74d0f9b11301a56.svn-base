package wy.xydframe.system.controller;

import com.alibaba.fastjson.JSON;
import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;
import net.sf.json.JSONObject;
import wy.common.annotion.Permission;
import wy.common.annotion.BussinessLog;
import wy.common.constant.Const;
import wy.common.constant.Dict;
import wy.common.constant.factory.ConstantFactory;
import wy.common.constant.state.MenuStatus;
import wy.common.persistence.model.Page;
import wy.common.persistence.model.ResultMap;
import wy.core.base.tips.Tip;
import wy.core.base.controller.BaseController;
import wy.common.exception.BizExceptionEnum;
import wy.common.exception.BussinessException;
import wy.core.node.Node;
import wy.core.node.ZTreeNode;
import wy.common.persistence.dao.MenuMapper;
import wy.common.persistence.model.Menu;
import wy.core.log.LogObjectHolder;
import wy.core.shiro.ShiroKit;
import wy.core.support.BeanKit;
import wy.core.util.ToolUtil;
import wy.core.util.TreeBuilder;
import wy.xydframe.system.dao.MenuDao;
import wy.xydframe.system.dao.RoleDao;
import wy.xydframe.system.dao.UserMgrDao;
import wy.xydframe.system.service.IMenuService;
import wy.xydframe.system.warpper.MenuWarpper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 菜单控制器
 *
 * @author fengshuonan
 * @Date 2017年2月12日21:59:14
 */
@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController {

    private static String PREFIX = "/xydframe/menu/";

    @Resource
    MenuMapper menuMapper;

    @Resource
    MenuDao menuDao;
    
    @Resource
    UserMgrDao managerDao;
    
    @Resource
    RoleDao roleDao;

    @Resource
    IMenuService menuService;

    /**
     * 跳转到菜单列表列表页面
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "menu.html";
    }

    /**
     * 跳转到菜单列表列表页面
     */
    @RequestMapping(value = "/menu_add")
    public String menuAdd() {
        return PREFIX + "menu_add.html";
    }

    /**
     * 跳转到菜单详情列表页面
     */
    @Permission(Const.ADMIN_NAME)
    @RequestMapping(value = "/menu_edit/{menuId}")
    public String menuEdit(@PathVariable Integer menuId, Model model) {
        if (ToolUtil.isEmpty(menuId)) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        Menu menu = this.menuMapper.selectById(menuId);

        //获取父级菜单的id
        Menu temp = new Menu();
        temp.setCode(menu.getPcode());
        Menu pMenu = this.menuMapper.selectOne(temp);

        //如果父级是顶级菜单
        if (pMenu == null) {
            menu.setPcode("0");
        } else {
            //设置父级菜单的code为父级菜单的id
            menu.setPcode(String.valueOf(pMenu.getId()));
        }

        Map<String, Object> menuMap = BeanKit.beanToMap(menu);
        menuMap.put("pcodeName", ConstantFactory.me().getMenuNameByCode(temp.getCode()));
        model.addAttribute("menu", menuMap);
        LogObjectHolder.me().set(menu);
        return PREFIX + "menu_edit.html";
    }

    /**
     * 修该菜单
     */
    @Permission(Const.ADMIN_NAME)
    @RequestMapping(value = "/edit")
    @BussinessLog(value = "修改菜单", key = "name", dict = Dict.MenuDict)
    @ResponseBody
    public Tip edit(@Valid Menu menu, BindingResult result) {
        if (result.hasErrors()) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        //设置父级菜单编号
        menuSetPcode(menu);

        this.menuMapper.updateById(menu);
        return SUCCESS_TIP;
    }

    /**
     * 获取菜单列表
     */
    @Permission(Const.ADMIN_NAME)
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(@RequestParam(required = false) String menuName, @RequestParam(required = false) String level) {
        System.err.println("menuName:"+menuName);
        System.err.println("level:"+level);
        List<Map<String, Object>> menus = this.menuDao.selectMenus(menuName, level);
        return super.warpObject(new MenuWarpper(menus));
    }

    /**
     * 新增菜单
     */
    @Permission(Const.ADMIN_NAME)
    @RequestMapping(value = "/add")
    @BussinessLog(value = "菜单新增", key = "name", dict = Dict.MenuDict)
    @ResponseBody
    public Tip add(@Valid Menu menu, BindingResult result) {
        if (result.hasErrors()) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        //设置父级菜单编号
        menuSetPcode(menu);
        if(menu.getPid()==null){
            menu.setPid(0);
        }
        menu.setStatus(MenuStatus.ENABLE.getCode());
        this.menuMapper.insert(menu);
        return SUCCESS_TIP;
    }

    /**
     * 删除菜单
     */
    @Permission(Const.ADMIN_NAME)
    @RequestMapping(value = "/remove")
    @BussinessLog(value = "删除菜单", key = "menuId", dict = Dict.DeleteDict)
    @ResponseBody
    public Tip remove(@RequestParam Integer menuId) {
        if (ToolUtil.isEmpty(menuId)) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }

        //缓存菜单的名称
        LogObjectHolder.me().set(ConstantFactory.me().getMenuName(menuId));

        this.menuService.delMenuContainSubMenus(menuId);
        return SUCCESS_TIP;
    }

    /**
     * 查看菜单
     */
    @RequestMapping(value = "/view/{menuId}")
    @ResponseBody
    public Tip view(@PathVariable Integer menuId) {
        if (ToolUtil.isEmpty(menuId)) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        this.menuMapper.selectById(menuId);
        return SUCCESS_TIP;
    }

    /**
     * 获取菜单列表(首页用)
     */
    @RequestMapping(value = "/menuTreeList")
    @ResponseBody
    public List<ZTreeNode> menuTreeList() {
        List<ZTreeNode> roleTreeList = this.menuDao.menuTreeList();
        return roleTreeList;
    }

    /**
     * 获取菜单列表(选择父级菜单用)
     */
    @RequestMapping(value = "/selectMenuTreeList")
    @ResponseBody
    public List<ZTreeNode> selectMenuTreeList() {
        List<ZTreeNode> roleTreeList = this.menuDao.menuTreeList();
        roleTreeList.add(ZTreeNode.createParent());
        return roleTreeList;
    }

    /**
     * 获取角色列表
     */
    @RequestMapping(value = "/menuTreeListByRoleId/{roleId}")
    @ResponseBody
    public List<ZTreeNode> menuTreeListByRoleId(@PathVariable Integer roleId) {    	
    	//获取当前登录人的ID
  		Integer userNowId = ShiroKit.getUser().getId();
  		
  		//获取当前登录人角色ID		
  		String userRoles = managerDao.getRoles(userNowId);
  		Integer userRoleId = Integer.parseInt(userRoles);
    	 
  		//获取当前点击角色的Pid
  		Integer clickPid = roleDao.getRolesPid(roleId);
  				
  		//获取当前登录用户所分配的菜单
  		List<Integer> nowMenuIds = this.menuDao.getMenuIdsByNowRoleId(userRoleId);
  		
  		//获取当前点击角色ID所选中的菜单
        List<Integer> menuIds = this.menuDao.getMenuIdsByRoleId(roleId);
        
        if (userRoleId.equals(Const.ADMIN_ROLE_ID)) {
        	if (ToolUtil.isEmpty(menuIds)) {
                List<ZTreeNode> roleTreeList = this.menuDao.menuTreeList();
                return roleTreeList;
            } else {
                List<ZTreeNode> roleTreeListByUserId = this.menuDao.menuTreeListByMenuIds(menuIds);
                return roleTreeListByUserId;
            }
        } else {       	
        	if (ToolUtil.isEmpty(menuIds)) {
                List<ZTreeNode> roleTreeList = this.menuDao.menuSomeTreeList(nowMenuIds);
                return roleTreeList;
            } else {           	
            	if((roleId.equals(userRoleId)) || (clickPid.equals(userRoleId))){            		
            		List<ZTreeNode> roleTreeListByUserId = this.menuDao.menuSomeTreeListByMenuIds(menuIds);
                    return roleTreeListByUserId;
            	} else {            		            		
            		List<ZTreeNode> roleTreeListByUserId = this.menuDao.menuOtherTreeListByMenuIds(menuIds);
                    return roleTreeListByUserId;
            	}               
            }
        }
    }

    /**
     * 根据请求的父级菜单编号设置pcode和层级
     */
    private void menuSetPcode(@Valid Menu menu) {
        if (ToolUtil.isEmpty(menu.getPcode()) || menu.getPcode().equals("0")) {
            menu.setPcode("0");
            menu.setLevels(1);
        } else {
            int code = Integer.parseInt(menu.getPcode());
            Menu pMenu = menuMapper.selectById(code);
            Integer pLevels = pMenu.getLevels();
            menu.setPcode(pMenu.getCode());
            menu.setLevels(pLevels + 1);
            menu.setPcodes(pMenu.getPcodes() + "[" + pMenu.getCode() + "],");
        }
    }

    @RequestMapping("/bulidJsonTree")
    @ResponseBody
    public String buildJsonTree(HttpServletRequest request) {
        List<Node> nodes = menuDao.tree1();
        String json = new TreeBuilder().buildTree(nodes);
        return json;
    }

    @RequestMapping("/bulidJson")
    @ResponseBody
    public JSONObject buildJson(HttpServletResponse response, @RequestParam(required = false) String condition, @RequestParam(required = false) Integer id) {
        if (null==id){
            id=0;
        }
        List list=menuDao.list4(condition,id);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("data",list);
        String json= JSON.toJSONString(map);
        System.out.println(json);
        JSONObject jsStr = JSONObject.fromObject(json);
        System.err.println(jsStr);
        return jsStr;
    }

    /**
     * layui-content后台代码
     * @return
     */
    @RequestMapping("/backContent")
    @ResponseBody
    public ResultMap<List<Map>> backContent(Page page, @RequestParam("limit") int limit, @RequestParam(required = false) Integer id, @RequestParam(required = false) String condition){
        System.out.println("backContent========================"+limit);
        page.setRows(limit);
        System.out.println("page:"+page.toString());
        Integer start=page.getStart();
        Integer rows=page.getRows();
        if (null==id){
            id=0;
        }
        List<Map>contentList=menuDao.selectPageList(page,start,rows,id,condition);
        int totals=menuDao.selectPageCount(page,id);
        page.setTotalRecord(totals);
        return new ResultMap<List<Map>>("",contentList,0,totals);
    }
}
