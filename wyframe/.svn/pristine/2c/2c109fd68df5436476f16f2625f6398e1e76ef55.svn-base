package wy.addons.zcgl.xgt_vendor.controller;

import wy.addons.zcgl.cpn_branch.dao.Xyd_cpn_branchDao;
import wy.addons.zcgl.xgt_vendor.dao.Xgt_goods_prd_vendorDao;
import wy.addons.zcgl.xgt_vendor.dao.Xgt_goods_prd_vendorMapper;
import wy.addons.zcgl.xgt_vendor.model.Xgt_goods_prd_vendor;
import wy.addons.zcgl.xgt_vendor.warpper.Xgt_goods_prd_vendorWarpper;
import wy.addons.zcgl.xydcpn.dao.Xyd_cpnDao;
import com.alibaba.fastjson.JSON;
import wy.core.base.controller.BaseController;
import wy.core.node.ZTreeNode;
import wy.core.util.DateUtil;
import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wy.core.log.LogObjectHolder;
import wy.core.shiro.ShiroKit;
import wy.xydframe.system.dao.DictDao;
import wy.xydframe.system.dao.UserMgrDao;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 合作伙伴控制器
 *
 * @author wyframe
 * @Date 2017-11-27 14:46:23
 */
@Controller
@RequestMapping("/xgt_goods_prd_vendor")
public class Xgt_goods_prd_vendorController extends BaseController {
	private String PREFIX = "/addons/zcgl/xgt_vendor/";


	@Resource
	Xgt_goods_prd_vendorDao xgt_goods_prd_vendorDao;
	
	@Resource
	Xgt_goods_prd_vendorMapper xgt_goods_prd_vendorMapper;
	
    @Resource
    DictDao dictDao;
    
	@Resource
	Xyd_cpnDao xyd_cpnDao;
    
    @Resource
    private UserMgrDao managerDao;
    
	@Resource
	Xyd_cpn_branchDao xyd_cpn_branchDao;
	
	public static List<Map<String, Object>> paramList = null;
	
    /**
     * 跳转到合作伙伴首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "xgt_goods_prd_vendor.html";
    }

    /**
     * 跳转到添加合作伙伴
     */
    @RequestMapping("/xgt_goods_prd_vendor_add/{vendorId}")
    public String xgt_goods_prd_vendorAdd(@PathVariable("vendorId") Integer vendorId,Model model) {
//    	Integer userId = ShiroKit.getUser().getId();  	
//    	String userName = ShiroKit.getUser().getName();  	
//    	Integer cpnId = managerDao.queryCpnId(userId);  	
//    	Integer cpnBranchId = managerDao.queryCpnBrandId(userId);   	
//    	String cpnName = xyd_cpnDao.queryCpnName(cpnId);   	
//    	String cpnBranchName = xyd_cpn_branchDao.queryCpnBranchName(cpnBranchId);   
//    	List<Map<String, Object>> vendorStList = dictDao.vendorStList();
    	List<Map<String, Object>> vendorFlgList = dictDao.vendorFlgList();
    	String vendorNm=xgt_goods_prd_vendorDao.selectVendorNm(vendorId);
    	model.addAttribute("vendorFlgList", vendorFlgList);
		model.addAttribute("vendorId", vendorId);
		model.addAttribute("vendorNm", vendorNm);
//    	model.addAttribute("cpnId", cpnId);
//    	model.addAttribute("cpnName", cpnName);
//    	model.addAttribute("cpnBranchId", cpnBranchId);
//    	model.addAttribute("cpnBranchName", cpnBranchName);
//    	model.addAttribute("vendorStList", vendorStList);
//        return PREFIX + "xgt_goods_prd_vendor_add.html";
    	return PREFIX + "prd_vendor_add.html";
    }
    
    /**
	 * 跳转到添加参数
	 */
	@RequestMapping("/xgt_goods_prd_vendor_add_param")
	public String xgt_goods_prd_vendor_add_param() {
		return PREFIX + "xgt_goods_prd_vendor_add_param.html";
	}

    /**
     * 跳转到修改合作伙伴
     */
    @RequestMapping("/xgt_goods_prd_vendor_update/{xgt_goods_prd_vendorId}")
    public String xgt_goods_prd_vendorUpdate(@PathVariable Integer xgt_goods_prd_vendorId, Model model) {
    	Xgt_goods_prd_vendor xgt_goods_prd_vendor = this.xgt_goods_prd_vendorDao.queryById(xgt_goods_prd_vendorId);
//    	Integer userId = ShiroKit.getUser().getId();   	
//    	String userName = ShiroKit.getUser().getName();   	
//    	Integer cpnId = managerDao.queryCpnId(userId);   	
//    	Integer cpnBranchId = managerDao.queryCpnBrandId(userId);   	
//    	String cpnName = xyd_cpnDao.queryCpnName(cpnId);  	
//    	String cpnBranchName = xyd_cpn_branchDao.queryCpnBranchName(cpnBranchId);    	   	
//    	List<Map<String, Object>> vendorStList = dictDao.vendorStList();
        Integer vendorFlg = xgt_goods_prd_vendor.getVendor_flg();
        List<Map<String, Object>> vendorFlgList = dictDao.vendorFlgList();
        for(Map venderFlgMap : vendorFlgList) {
            if(venderFlgMap.get("num").equals(vendorFlg)) {
                model.addAttribute("vendor_flg", venderFlgMap.get("name"));
            }
        }
    	model.addAttribute("vendorFlgList", vendorFlgList);
    	Integer  parPrdVendorid=xgt_goods_prd_vendor.getPar_prd_vendor_id();
    	String pvendorNm=xgt_goods_prd_vendorDao.queryVendorNm(parPrdVendorid);
//    	model.addAttribute("cpnId", cpnId);
//    	model.addAttribute("cpnName", cpnName);
//    	model.addAttribute("cpnBranchId", cpnBranchId);
//    	model.addAttribute("cpnBranchName", cpnBranchName);
//    	model.addAttribute("vendorStList", vendorStList);
				model.addAttribute("pvendorNm", pvendorNm);
		model.addAttribute("vendorId",xgt_goods_prd_vendorId);
    	model.addAttribute(xgt_goods_prd_vendor);
		LogObjectHolder.me().set(xgt_goods_prd_vendor);
//        return PREFIX + "xgt_goods_prd_vendor_edit.html";
		return PREFIX + "prd_vendor_edit.html";
    }

	/**
     * 跳转到详情合作伙伴
     */
    @RequestMapping("/xgt_goods_prd_vendor_detail/{xgt_goods_prd_vendorId}")
    public String xgt_goods_prd_vendorDetail(@PathVariable Integer xgt_goods_prd_vendorId, Model model) {
    	Xgt_goods_prd_vendor xgt_goods_prd_vendor = this.xgt_goods_prd_vendorDao.queryById(xgt_goods_prd_vendorId);  	
//    	List<Map<String, Object>> vendorStList = dictDao.vendorStList();
//    	Integer venderStId = xgt_goods_prd_vendor.getSt_id();
//		for(Map venderStMap : vendorStList) {
//			if(venderStMap.get("num").equals(venderStId)) {
//				model.addAttribute("st_id", venderStMap.get("name"));
//			}
//		}  	
//		Integer userId = ShiroKit.getUser().getId();   	
//    	String userName = ShiroKit.getUser().getName();   	
//    	Integer cpnId = managerDao.queryCpnId(userId);    	
//    	Integer cpnBranchId = managerDao.queryCpnBrandId(userId);   	
//    	String cpnName = xyd_cpnDao.queryCpnName(cpnId);    	
//    	String cpnBranchName = xyd_cpn_branchDao.queryCpnBranchName(cpnBranchId); 
    	Integer vendorFlg = xgt_goods_prd_vendor.getVendor_flg();
    	List<Map<String, Object>> vendorFlgList = dictDao.vendorFlgList();
		for(Map venderFlgMap : vendorFlgList) {
		if(venderFlgMap.get("num").equals(vendorFlg)) {
			model.addAttribute("vendor_flg", venderFlgMap.get("name"));
			}
		}
		Integer  parPrdVendorid=xgt_goods_prd_vendor.getPar_prd_vendor_id();
		String pvendorNm=xgt_goods_prd_vendorDao.queryVendorNm(parPrdVendorid);
		model.addAttribute("pvendorNm", pvendorNm);
		model.addAttribute("vendorId",xgt_goods_prd_vendorId);
//    	model.addAttribute("cpnId", cpnId);
//    	model.addAttribute("cpnName", cpnName);
//    	model.addAttribute("cpnBranchId", cpnBranchId);
//    	model.addAttribute("cpnBranchName", cpnBranchName);
    	model.addAttribute(xgt_goods_prd_vendor);
		LogObjectHolder.me().set(xgt_goods_prd_vendor);
//        return PREFIX + "xgt_goods_prd_vendor_detail.html";
		return PREFIX + "prd_vendor_detail.html";
    
    }

	/**
	 * 获取合作伙伴的tree列表
	 */
	@RequestMapping(value = "/tree")
	@ResponseBody
	public List<ZTreeNode> tree() {
		Integer userId = ShiroKit.getUser().getId();
		Integer cpnId = managerDao.queryCpnId(userId);
		if(ShiroKit.isAdmin()){
			List<ZTreeNode> tree=this.xgt_goods_prd_vendorDao.tree1();
			tree.add(ZTreeNode.createParent());
			return tree;
		}
		else {
			List<ZTreeNode> tree=this.xgt_goods_prd_vendorDao.tree(cpnId);
			tree.add(ZTreeNode.createParent());
			return tree;
		}
	}

    /**
     * 获取合作伙伴列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(@RequestParam(required = false) String condition,@RequestParam(required = false) Integer prd_vendor_id) {
//       paramList = null;
		Integer userId = ShiroKit.getUser().getId();
		System.err.println(prd_vendor_id);
		Integer cpnId = managerDao.queryCpnId(userId);
		if(ShiroKit.isAdmin()){
			if (null==prd_vendor_id){
				prd_vendor_id=0;
			}
				List<Map<String, Object>> list=this.xgt_goods_prd_vendorDao.list(condition,prd_vendor_id);
				System.err.println("list："+list);
				return super.warpObject(new Xgt_goods_prd_vendorWarpper(list));
			}
        else {
			if (null==prd_vendor_id) {
				prd_vendor_id = 0;
			}
				List<Map<String, Object>> list=this.xgt_goods_prd_vendorDao.list2(condition,cpnId,prd_vendor_id);
				System.err.println("list："+list);
				return super.warpObject(new Xgt_goods_prd_vendorWarpper(list));
			}
		}
	/**
	 * 获取合作伙伴列表
	 */
	/*@RequestMapping(value = "/list2")
	@ResponseBody
	public Object list2(@RequestParam(required = false) String condition) {
        Integer userId = ShiroKit.getUser().getId();
        Integer cpnId = managerDao.queryCpnId(userId);
//        List<Map<String, Object>> list = this.xgt_goods_prd_vendorDao.list(cpnId);
		List<Map<String, Object>> list = this.xgt_goods_prd_vendorDao.list2(condition,cpnId);
		return list;
	}*/

    /**
     * 获取合作伙伴列表
     */
    @RequestMapping(value = "/vendorList")
	@ResponseBody
    public List<Map<String, Object>> vendorList(@RequestParam(required = false) Integer prd_vendor_id) {

    	if (ShiroKit.getUser().getAccount()=="admin"){
        List<Map<String, Object>> vendorList = this.xgt_goods_prd_vendorDao.vendorList();
			return vendorList;
		}else{
			Integer userId = ShiroKit.getUser().getId();
			Integer cpnId = managerDao.queryCpnId(userId);
			List<Map<String, Object>> list = this.xgt_goods_prd_vendorDao.list2(null,cpnId,prd_vendor_id);
			return list;
		}

    }

	/**
	 * 获取全部合作伙伴列表
	 */
	public List<Map<String, Object>>VenDorList(){
		List<Map<String, Object>>VenDorList=xgt_goods_prd_vendorDao.venDorList();
		return VenDorList();
	}
    /**
     * 新增合作伙伴
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Xgt_goods_prd_vendor xgt_goods_prd_vendor) {
    	Integer userId = ShiroKit.getUser().getId();  
    	String userName = ShiroKit.getUser().getName();  
    	Integer cpnId = managerDao.queryCpnId(userId);
    	Integer cpnBranchId = managerDao.queryCpnBrandId(userId);
    	xgt_goods_prd_vendor.setCpn_id(cpnId);
    	xgt_goods_prd_vendor.setCpn_branch_id(cpnBranchId);
    	xgt_goods_prd_vendor.setOper_user(userName);
    	xgt_goods_prd_vendor.setSt_id(1);
    	xgt_goods_prd_vendor.setCre_dt(new Date());
        return this.xgt_goods_prd_vendorMapper.insert(xgt_goods_prd_vendor);
    }
	/**
	 * 入库单页面  合作伙伴新增
	 */
	@RequestMapping(value = "/add_in")
	@ResponseBody
	public Object add_in(@RequestParam String data){
		System.out.println(JSON.parse(data));
        Map<String,Object> map = (Map<String, Object>)JSON.parse(data);
        Integer userId = ShiroKit.getUser().getId();
        String userName = ShiroKit.getUser().getName();
        Integer cpnId = managerDao.queryCpnId(userId);
        Integer cpnBranchId = managerDao.queryCpnBrandId(userId);
        map.put("cpn_id",cpnId);
        map.put("cpn_branch_id",cpnBranchId);
        map.put("oper_user",userName);
        map.put("st_id",1);
        map.put("cre_dt",DateUtil.format(new Date()));
        this.xgt_goods_prd_vendorDao.addVendor(map);
        return SUCCESS_TIP;
	}

	/**
     * 删除合作伙伴
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer xgt_goods_prd_vendorId) {
    	this.xgt_goods_prd_vendorDao.updateVendorById(xgt_goods_prd_vendorId);
//    	this.xgt_goods_prd_vendorMapper.deleteById(xgt_goods_prd_vendorId);
        return SUCCESS_TIP;
    }

    /**
     * 修改合作伙伴
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Xgt_goods_prd_vendor xgt_goods_prd_vendor) {
    	this.xgt_goods_prd_vendorMapper.updateById(xgt_goods_prd_vendor);
        return super.SUCCESS_TIP;
    }

	/**
	 * 按照名称或编号模糊查询
	 */
	@RequestMapping(value = "/findByNameOrNo")
	@ResponseBody
	public Object findByNameOrNo(@RequestParam String prd_vendor_nm){
		Integer userId = ShiroKit.getUser().getId();
		Integer cpnId = managerDao.queryCpnId(userId);
		List<Map<String, Object>> list = this.xgt_goods_prd_vendorDao.findByNameOrNo(prd_vendor_nm,cpnId);
		return super.warpObject(new Xgt_goods_prd_vendorWarpper(list));
	}

    /**
     * 查询供货商详情
     */
        public Object queryById(String id){
            int i = Integer.parseInt(id);
            Xgt_goods_prd_vendor xgt_goods_prd_vendor = this.xgt_goods_prd_vendorDao.queryById(i);
            return xgt_goods_prd_vendor;
        }
	/**
     * 导出合作伙伴
     */
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void export(HttpServletResponse res)  throws ParsePropertyException, InvalidFormatException, IOException {
    	String resourcePath = "src/main/resources/excelTemplate/xgt_goods_prd_vendor.xls";
    	String tarPath = "src/main/resources/excel/xgt_goods_prd_vendor.xls";
    	String condition = null;
//    	 List<Map<String, Object>> list = this.xgt_goods_prd_vendorDao.list(condition);
    	 Map<String, List<Map<String,Object>>> beanParams = new HashMap<String, List<Map<String,Object>>>();  
//	     beanParams.put("list", list);  
	     XLSTransformer former = new XLSTransformer();  
	     former.transformXLS(resourcePath, beanParams, tarPath); 
	     
	     //下载
		String fileName = "xgt_goods_prd_vendor"+DateUtil.getAllTime()+".xls";
		res.setHeader("content-type", "application/octet-stream");
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		try {
			os = res.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(new File("src/main/resources/excel/xgt_goods_prd_vendor.xls")));
			int i = bis.read(buff);
			while (i != -1) {
				os.write(buff, 0, buff.length);
				os.flush();
				i = bis.read(buff);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
    }
}
