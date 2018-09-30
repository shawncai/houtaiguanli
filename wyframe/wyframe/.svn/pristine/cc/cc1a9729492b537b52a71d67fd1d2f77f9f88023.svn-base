package wy.xydframe.system.controller;

import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import wy.common.annotion.BussinessLog;
import wy.common.annotion.Permission;
import wy.common.constant.Const;
import wy.common.constant.Dict;
import wy.common.constant.factory.ConstantFactory;
import wy.common.constant.state.ManagerStatus;
import wy.common.exception.BizExceptionEnum;
import wy.common.exception.BussinessException;
import wy.common.persistence.dao.UserMapper;
import wy.common.persistence.model.Bs_area_limit;
import wy.common.persistence.model.User;
import wy.config.properties.QiniuProperties;
import wy.config.properties.XydProperties;
import wy.core.base.controller.BaseController;
import wy.core.base.tips.Tip;
import wy.core.db.Db;
import wy.core.log.LogObjectHolder;
import wy.core.node.ZTreeNode;
import wy.core.shiro.ShiroKit;
import wy.core.shiro.ShiroUser;
import wy.core.util.Convert;
import wy.core.util.ToolUtil;
import wy.xydframe.system.dao.RoleDao;
import wy.xydframe.system.dao.UserMgrDao;
import wy.xydframe.system.factory.UserFactory;
import wy.xydframe.system.transfer.UserDto;
import wy.xydframe.system.warpper.UserWarpper;

import javax.annotation.Resource;
import javax.naming.NoPermissionException;
import javax.validation.Valid;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.*;

/**
 * 系统管理员控制器
 *
 * @author fengshuonan
 * @Date 2017年1月11日 下午1:08:17
 */
@Controller
@RequestMapping("/mgr")
public class UserMgrController extends BaseController {

    private static String PREFIX = "/xydframe/user/";

    @Resource
    private XydProperties xydProperties;
    @Resource
    private QiniuProperties qiNiuProperties;
    @Resource
    private UserMgrDao managerDao;

    @Resource
    private UserMapper userMapper;

    @Resource
    RoleDao roleDao;




    /**
     * 跳转到查看管理员列表的页面
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "user.html";
    }

    /**
     * 跳转到查看管理员列表的页面
     */
    @RequestMapping("/user_add/{userDeptId}")
    public String addView(@PathVariable("userDeptId") Integer userDeptId, Model model) {
    	
    	String userDeptName = managerDao.selectUserDeptName(userDeptId);
    	//判断选中的部门是最高级(父级ID=0)还是中间级别（有子部门），还是最低级（没有子部门）
        model.addAttribute("userDeptId", userDeptId);
        model.addAttribute("userDeptName",userDeptName);
        return PREFIX + "user_add.html";
    }

    /**
     * 跳转到角色分配页面
     */
    @RequestMapping("/role_assign/{userId}")
    public String roleAssign(@PathVariable Integer userId, Model model) {
        if (ToolUtil.isEmpty(userId)) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        User user = (User) Db.create(UserMapper.class).selectOneByCon("id", userId);
        model.addAttribute("userId", userId);
        model.addAttribute("userAccount", user.getAccount());
        return PREFIX + "user_roleassign.html";
    }
    
    /**
   	 * 点击跳转用户区域分配管理
   	 */
   	@RequestMapping(value = "/area_assign/{userId}")
   	public String areaAssign(@PathVariable Integer userId, Model model) {
   		model.addAttribute("userId", userId);
   		return PREFIX + "user_areaassign.html";
   	}
 
    /**
     * 跳转到编辑管理员页面
     */
    @Permission
    @RequestMapping("/user_edit/{userId}")
    public String userEdit(@PathVariable Integer userId, Model model) {
        if (ToolUtil.isEmpty(userId)) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        User user = this.userMapper.selectById(userId);
        model.addAttribute(user);
        model.addAttribute("roleName", ConstantFactory.me().getRoleName(user.getRoleid()));
        model.addAttribute("deptName", ConstantFactory.me().getDeptName(user.getDeptid()));
        LogObjectHolder.me().set(user);
        return PREFIX + "user_edit.html";
    }

    /**
     * 跳转到查看用户详情页面
     */
    @RequestMapping("/user_info")
    public String userInfo(Model model) {    	
        Integer userId = ShiroKit.getUser().getId();
        if (ToolUtil.isEmpty(userId)) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        User user = this.userMapper.selectById(userId);
        model.addAttribute(user);
        model.addAttribute("roleName", ConstantFactory.me().getRoleName(user.getRoleid()));
        model.addAttribute("deptName", ConstantFactory.me().getDeptName(user.getDeptid()));
        LogObjectHolder.me().set(user);
        return PREFIX + "user_view.html";
    }

    /**
     * 跳转到修改密码界面
     */
    @RequestMapping("/user_chpwd")
    public String chPwd() {
        return PREFIX + "user_chpwd.html";
    }

    /**
     * 修改当前用户的密码
     */
    @RequestMapping("/changePwd")
    @ResponseBody
    public Object changePwd(@RequestParam String oldPwd, @RequestParam String newPwd, @RequestParam String rePwd) {
        if (!newPwd.equals(rePwd)) {
            throw new BussinessException(BizExceptionEnum.TWO_PWD_NOT_MATCH);
        }
        
        Integer userId = ShiroKit.getUser().getId();
        System.err.println(userId);
        
        User user = userMapper.selectById(userId);
        System.err.println(user.toString());
        
        String oldMd5 = ShiroKit.md5(oldPwd, user.getSalt());
        System.err.println(oldMd5.toString());
        
        if (user.getPassword().equals(oldMd5)) {
            String newMd5 = ShiroKit.md5(newPwd, user.getSalt());
            System.err.println(newMd5.toString());
            
            user.setPassword(newMd5);
            user.updateById();
            return SUCCESS_TIP;
        } else {
            throw new BussinessException(BizExceptionEnum.OLD_PWD_NOT_RIGHT);
        }
    }

    /**
     * 查询管理员列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object list(@RequestParam(required = false) String name, @RequestParam(required = false) String beginTime, @RequestParam(required = false) String endTime, @RequestParam(required = false) Integer deptid) {
        
    	Integer userId = ShiroKit.getUser().getId();
//    	System.err.println("当前用户ID:" + userId);
        
//        User userinfo = userMapper.selectById(userId);
//        System.err.println("当前用户信息:" + userinfo.toString());

//        String roles = managerDao.getRoles(userId);
//        System.err.println("当前用户角色ID:" + roles);
        
//        String[] arrayRoles = roles.split(",");
        
//        String roleIds = arrayRoles[1];
//        System.err.println("获取当前用户角色ID:" + roleIds);
        
//        Integer roleId = Integer.parseInt(roles);
//        System.err.println("转换之后角色ID:" + roleId);
        Integer cpnId = managerDao.queryCpnId(userId);
        
        //如果是超级管理员
        if (userId.equals(Const.ADMIN_ID)) {
            if (null==deptid){
                deptid=0;
            }
            List<Map<String, Object>> users = managerDao.selectUsers(name, beginTime, endTime, deptid);
            return new UserWarpper(users).warp();
        }else{
            if (null==deptid){
                deptid=0;
            }
            List<Map<String, Object>> users = managerDao.selectSomeUsers(cpnId, name, beginTime, endTime, deptid);
            return new UserWarpper(users).warp();
        }       
    }

    /**
     * 按名称或编号查询员工
     */
    @RequestMapping(value = "/findByNameOrNo")
    @ResponseBody
    public Object findByNameOrNo(String condition){
        List<Map<String, Object>> byNameOrNo = managerDao.findByNameOrNo(condition);
        return  byNameOrNo;
    }

    /**
     * 添加管理员
     */
    @RequestMapping("/add")
    @BussinessLog(value = "添加管理员", key = "account", dict = Dict.UserDict)
    @ResponseBody
    public Tip add(@Valid UserDto user, BindingResult result) {
        if (result.hasErrors()) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        
        Integer userId = ShiroKit.getUser().getId();

        // 判断账号是否重复
        User theUser = managerDao.getByAccount(user.getAccount());
        if (theUser != null) {
            throw new BussinessException(BizExceptionEnum.USER_ALREADY_REG);
        }

        // 完善账号信息
        user.setParentid(userId);
        user.setSalt(ShiroKit.getRandomSalt(5));
        user.setPassword(ShiroKit.md5(user.getPassword(), user.getSalt()));
        user.setStatus(ManagerStatus.OK.getCode());
        user.setCreatetime(new Date());
        System.err.println(user);
        Integer deptId=user.getPar_cpn_dept_id();
        Integer cpnId =managerDao.selectCpnId(deptId);
        Integer cpnBrandId =managerDao.selectCpnBrandId(deptId);
        user.setCpn_id(cpnId);
        user.setCpn_branch_id(cpnBrandId);
        user.setCpn_dept_id(deptId);
        this.userMapper.insert(UserFactory.createUser(user));
        return SUCCESS_TIP;
    }

    /**
     * 修改管理员
     *
     * @throws NoPermissionException
     */
    @RequestMapping("/edit")
    @BussinessLog(value = "修改管理员", key = "account", dict = Dict.UserDict)
    @ResponseBody
    public Tip edit(@Valid UserDto user, BindingResult result) throws NoPermissionException {
        if (result.hasErrors()) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        if (ShiroKit.hasRole(Const.ADMIN_NAME)) {
            this.userMapper.updateById(UserFactory.createUser(user));
            return SUCCESS_TIP;
        } else {
            ShiroUser shiroUser = ShiroKit.getUser();
            if (shiroUser.getId().equals(user.getId())) {
                this.userMapper.updateById(UserFactory.createUser(user));
                return SUCCESS_TIP;
            } else {
                throw new BussinessException(BizExceptionEnum.NO_PERMITION);
            }
        }
    }

    /**
     * 删除管理员（逻辑删除）
     */
    @RequestMapping("/delete")
    @BussinessLog(value = "删除管理员", key = "userId", dict = Dict.UserDict)
    @ResponseBody
    public Tip delete(@RequestParam Integer userId) {
        if (ToolUtil.isEmpty(userId)) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        
        //不能删除超级管理员
        if (userId.equals(Const.ADMIN_ID)) {
            throw new BussinessException(BizExceptionEnum.CANT_DELETE_ADMIN);
        }
        
//        this.managerDao.setStatus(userId, ManagerStatus.DELETED.getCode());
        this.managerDao.deleteUser(userId);
        return SUCCESS_TIP;
    }

    /**
     * 查看管理员详情
     */
    @RequestMapping("/view/{userId}")
    @ResponseBody
    public User view(@PathVariable Integer userId) {
        if (ToolUtil.isEmpty(userId)) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        return this.userMapper.selectById(userId);
    }

    /**
     * 重置管理员的密码
     */
    @RequestMapping("/reset")
    @BussinessLog(value = "重置管理员密码", key = "userId", dict = Dict.UserDict)
    @Permission(Const.ADMIN_NAME)
    @ResponseBody
    public Tip reset(@RequestParam Integer userId) {
        if (ToolUtil.isEmpty(userId)) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        User user = this.userMapper.selectById(userId);
        user.setSalt(ShiroKit.getRandomSalt(5));
        user.setPassword(ShiroKit.md5(Const.DEFAULT_PWD, user.getSalt()));
        this.userMapper.updateById(user);
        return SUCCESS_TIP;
    }

    /**
     * 冻结用户
     */
    @RequestMapping("/freeze")
    @BussinessLog(value = "冻结用户", key = "userId", dict = Dict.UserDict)
    @Permission(Const.ADMIN_NAME)
    @ResponseBody
    public Tip freeze(@RequestParam Integer userId) {
        if (ToolUtil.isEmpty(userId)) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        //不能冻结超级管理员
        if (userId.equals(Const.ADMIN_ID)) {
            throw new BussinessException(BizExceptionEnum.CANT_FREEZE_ADMIN);
        }
        this.managerDao.setStatus(userId, ManagerStatus.FREEZED.getCode());
        return SUCCESS_TIP;
    }

    /**
     * 解除冻结用户
     */
    @RequestMapping("/unfreeze")
    @BussinessLog(value = "解除冻结用户", key = "userId", dict = Dict.UserDict)
    @Permission(Const.ADMIN_NAME)
    @ResponseBody
    public Tip unfreeze(@RequestParam Integer userId) {
        if (ToolUtil.isEmpty(userId)) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        this.managerDao.setStatus(userId, ManagerStatus.OK.getCode());
        return SUCCESS_TIP;
    }

    /**
     * 分配角色
     */
    @RequestMapping("/setRole")
    @BussinessLog(value = "分配角色", key = "userId,roleIds", dict = Dict.UserDict)
//    @Permission(Const.ADMIN_NAME)
    @ResponseBody
    public Tip setRole(@RequestParam("userId") Integer userId, @RequestParam("roleIds") String roleIds) {
        if (ToolUtil.isOneEmpty(userId, roleIds)) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        //不能修改超级管理员
        if (userId.equals(Const.ADMIN_ID)) {
            throw new BussinessException(BizExceptionEnum.CANT_CHANGE_ADMIN);
        }
        this.managerDao.setRoles(userId, roleIds);
        return SUCCESS_TIP;
    }
    	
	/**
	 * 用户区域分配
	 */
	@RequestMapping("/setAreas")
	@ResponseBody
	public Tip setAreas(@RequestParam("userId") Integer userId, @RequestParam("ids") String ids) {
		List<Bs_area_limit> list = new ArrayList<Bs_area_limit>();
		String[] strs = ids.split(",");
		for (String string : strs) {
			Bs_area_limit bsal = new Bs_area_limit();
			bsal.setUser_id(userId);
			bsal.setArea_id(Integer.parseInt(string));
			list.add(bsal);
		}
		managerDao.deleteArea(userId);
		managerDao.insertAreaId(list);
		return SUCCESS_TIP;
	}
	
	/**
	 * 获取地区列表
	 */
	@RequestMapping(value = "/userTreeListById/{userId}")
	@ResponseBody
	public List<ZTreeNode> userTreeListByUserId(@PathVariable Integer userId) {
		
		List<Integer> list = managerDao.selectAreaIdById(userId);
		String areaid = "";
		for (Integer integer : list) {
			areaid = areaid + "," + integer;
		}
		
		//获取当前登录人的ID
		Integer userNowId = ShiroKit.getUser().getId();
		//获取当前登录人角色ID		
		String userRoles = managerDao.getRoles(userNowId);
		Integer userRoleId = Integer.parseInt(userRoles);
//		System.err.println("当前登录用户角色ID:" + userRoleId);
		
//		String userRoleName = managerDao.getRoleName(userId);
		
		if (userRoleId.equals(Const.ADMIN_ROLE_ID)) {
			if (ToolUtil.isEmpty(areaid)) {
				List<ZTreeNode> userTreeList = this.managerDao.areaTreeList();
				return userTreeList;
			} else {
				String[] strArray = Convert.toStrArray(",", areaid);
				List<ZTreeNode> userTreeListByUserId = this.managerDao.areaTreeListById(strArray, userId);
				return userTreeListByUserId;
			}
		} else {
//			System.err.println("区域管理员进入此方法ID:" + userNowId);
			
			if (ToolUtil.isEmpty(areaid)) {
				List<ZTreeNode> userTreeList = this.managerDao.areaSomeTreeList(userNowId);
				return userTreeList;
			} else {
				String[] strArray = Convert.toStrArray(",", areaid);
				List<ZTreeNode> userTreeListByUserId = this.managerDao.areaSomeTreeListById(strArray, userNowId ,userId);
				return userTreeListByUserId;
			}
		}
	}

//    /**
//     * 上传图片(上传到项目的webapp/static/img)  
//     */
//    @RequestMapping(method = RequestMethod.POST, path = "/upload")
//    @ResponseBody
//    public String upload(@RequestPart("file") MultipartFile picture) {
//        String pictureName = UUID.randomUUID().toString() + ".jpg";
//        Map<String,String> map = new HashMap<String,String>();
//        Xyd_image_file xyd_image_file = new Xyd_image_file();
//        try {
//            String fileSavePath = xydProperties.getFileUploadPath();
//            picture.transferTo(new File(fileSavePath + pictureName));
//            xyd_image_file.setCre_dt(new Date());
//            xyd_image_file.setImage_file_nm(pictureName);
//            xyd_image_file.setSt_id(1);
//            xyd_image_file.setImage_file_src_url(fileSavePath+pictureName);
//            xyd_image_file.setImage_file_url(fileSavePath+pictureName);
//            if(picture.getContentType().startsWith("image")){
//            	xyd_image_file.setImg_file_cls(1);
//            }else{
//            	xyd_image_file.setImg_file_cls(2);
//            }
//            this.xyd_image_fileMapper.insert(xyd_image_file);
////            map.put("pictureName", pictureName);
//        } catch (Exception e) {
//            throw new BussinessException(BizExceptionEnum.UPLOAD_ERROR);
//        }
//        return xyd_image_file.getImage_file_id()+"";
//    }
	/**
	 * 上传图片(上传到项目的webapp/static/img)
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/upload")
	@ResponseBody
	public String upload(@RequestPart("file") MultipartFile file) {
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        //文件后缀名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        String key ="";
        String fileName = UUID.randomUUID().toString() +".jpg";
        String pictureName = UUID.randomUUID().toString() + ".jpg";
        try {
//            String fileSavePath = xydProperties.getFileUploadPath();
            String accessKey = xydProperties.getAccessKey();
            String secretKey = xydProperties.getSecretKey();
            String bucket = xydProperties.getBucket();
//			file.transferTo(new File(fileSavePath + pictureName));
            InputStream is = file.getInputStream();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int len = -1;
            while ((len = is.read(b)) != -1) {
                bos.write(b, 0, len);
            }
            byte[] uploadBytes = bos.toByteArray();
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);
            Response response = uploadManager.put(uploadBytes, fileName, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            key=putRet.key;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return key;
	}
}
