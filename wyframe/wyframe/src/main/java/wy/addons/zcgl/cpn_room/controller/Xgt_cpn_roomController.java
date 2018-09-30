package wy.addons.zcgl.cpn_room.controller;

import wy.addons.zcgl.cpn_room.dao.Xgt_cpn_roomDao;
import wy.addons.zcgl.cpn_room.dao.Xgt_cpn_roomMapper;
import wy.addons.zcgl.cpn_room.model.Xgt_cpn_room;
import wy.addons.zcgl.cpn_room.warpper.Xgt_cpn_roomWarpper;
import com.alibaba.fastjson.JSON;
import wy.core.base.controller.BaseController;
import wy.core.util.DateUtil;
import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wy.core.log.LogObjectHolder;
import wy.core.shiro.ShiroKit;
import wy.xydframe.system.dao.UserMgrDao;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 房间控制器
 *
 * @author wyframe
 * @Date 2018-01-03 15:02:19
 */
@Controller
@RequestMapping("/xgt_cpn_room")
public class Xgt_cpn_roomController extends BaseController {
	private String PREFIX = "/addons/zcgl/cpn_room/";
	@Resource
    Xgt_cpn_roomDao xgt_cpn_roomDao;
	
	@Resource
    Xgt_cpn_roomMapper xgt_cpn_roomMapper;

	@Resource
	private UserMgrDao managerDao;

	public static List<Map<String, Object>> paramList = null;
    /**
     * 跳转到房间首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "xgt_cpn_room.html";
    }

    /**
     * 跳转到添加房间
     */
    @RequestMapping("/xgt_cpn_room_add")
    public String xgt_cpn_roomAdd() {
        return PREFIX + "xgt_cpn_room_add.html";
    }
    
    /**
	 * 跳转到添加参数
	 */
	@RequestMapping("/xgt_cpn_room_add_param")
	public String xgt_cpn_room_add_param() {
		return PREFIX + "xgt_cpn_room_add_param.html";
	}

    /**
     * 跳转到修改房间
     */
    @RequestMapping("/xgt_cpn_room_update/{xgt_cpn_roomId}")
    public String xgt_cpn_roomUpdate(@PathVariable Integer xgt_cpn_roomId, Model model) {
    	Xgt_cpn_room xgt_cpn_room = this.xgt_cpn_roomDao.queryById(xgt_cpn_roomId);
    	model.addAttribute(xgt_cpn_room);
		LogObjectHolder.me().set(xgt_cpn_room);
        return PREFIX + "xgt_cpn_room_edit.html";
    }

	/**
     * 跳转到详情房间
     */
    @RequestMapping("/xgt_cpn_room_detail/{xgt_cpn_roomId}")
    public String xgt_cpn_roomDetail(@PathVariable Integer xgt_cpn_roomId, Model model) {
    	Xgt_cpn_room xgt_cpn_room = this.xgt_cpn_roomDao.queryById(xgt_cpn_roomId);
    	model.addAttribute(xgt_cpn_room);
		LogObjectHolder.me().set(xgt_cpn_room);
        return PREFIX + "xgt_cpn_room_detail.html";
    
    }

    /**
     * 获取房间列表
     */
    @RequestMapping(value = "/list2")
    @ResponseBody
    public Object list2(@RequestParam(required = false)String condition) {
    paramList = null;
		Integer userId = ShiroKit.getUser().getId();
		Integer cpnId = managerDao.queryCpnId(userId);
    List<Map<String, Object>> list = this.xgt_cpn_roomDao.list2(condition);
		System.err.println(list);
		return super.warpObject(new Xgt_cpn_roomWarpper(list));
    }


    /**
     * 新增房间
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(@RequestParam("xgt_cpn_room") String str) {
    	Map map = (Map) JSON.parse(str);
    	Xgt_cpn_room xgt_cpn_room = new Xgt_cpn_room();
    	xgt_cpn_room.setRoom_nm(map.get("room_nm")+"");
    	xgt_cpn_room.setCre_dt(new Date());
    	xgt_cpn_room.setOper_user(ShiroKit.getUser().getName());
    	xgt_cpn_room.setCpn_branch_id(ShiroKit.getUser().getCpn_branch_id());
    	xgt_cpn_room.setRoom_yt(map.get("room_yt")+"");
    	xgt_cpn_room.setRomm_photo_url(map.get("romm_photo_url")+"");
    	xgt_cpn_room.setRomm_photo_url2(map.get("romm_photo_url2")+"");
    	xgt_cpn_room.setRomm_photo_url3(map.get("romm_photo_url3")+"");
    	xgt_cpn_room.setRomm_photo_url4(map.get("romm_photo_url4")+"");
    	xgt_cpn_room.setRomm_photo_url5(map.get("romm_photo_url5")+"");
    	xgt_cpn_room.setRomm_photo_url6(map.get("romm_photo_url6")+"");
    	xgt_cpn_room.setRoom_adrs(map.get("room_adrs")+"");
    	xgt_cpn_room.setRoom_adrs_x(Double.parseDouble((String) map.get("room_adrs_x")));
    	xgt_cpn_room.setRoom_adrs_y(Double.parseDouble((String) map.get("room_adrs_y")));
    	xgt_cpn_room.setSt_id(Integer.parseInt((String) map.get("st_id")));
        return this.xgt_cpn_roomMapper.insert(xgt_cpn_room);
    }

    /**
     * 删除房间
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer xgt_cpn_roomId) {
    	this.xgt_cpn_roomMapper.deleteById(xgt_cpn_roomId);
        return SUCCESS_TIP;
    }

    /**
     * 修改房间
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Xgt_cpn_room xgt_cpn_room) {
    	this.xgt_cpn_roomMapper.updateById(xgt_cpn_room);
    	paramList=null;
        return super.SUCCESS_TIP;
    }
    
     /**
     * 导出房间
     */
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void export(HttpServletResponse res)  throws ParsePropertyException, InvalidFormatException, IOException {
    	String resourcePath = "src/main/resources/excelTemplate/xgt_cpn_room.xls";
    	String tarPath = "src/main/resources/excel/xgt_cpn_room.xls";
    	String condition = null;
    	 List<Map<String, Object>> list = this.xgt_cpn_roomDao.list(condition);
    	 Map<String, List<Map<String,Object>>> beanParams = new HashMap<String, List<Map<String,Object>>>();  
	     beanParams.put("list", list);  
	     XLSTransformer former = new XLSTransformer();  
	     former.transformXLS(resourcePath, beanParams, tarPath); 
	     
	     //下载
		String fileName = "xgt_cpn_room"+DateUtil.getAllTime()+".xls";
		res.setHeader("content-type", "application/octet-stream");
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		try {
			os = res.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(new File("src/main/resources/excel/xgt_cpn_room.xls")));
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
