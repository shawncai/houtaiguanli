package wy.addons.zcgl.auto_reply.controller;

import wy.addons.zcgl.auto_reply.dao.Wx_auto_replyDao;
import wy.addons.zcgl.auto_reply.dao.Wx_auto_replyMapper;
import wy.addons.zcgl.auto_reply.model.Wx_auto_reply;
import wy.addons.zcgl.auto_reply.warpper.Wx_auto_replyWarpper;
import wy.core.base.controller.BaseController;
import wy.core.util.DateUtil;
import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wy.core.log.LogObjectHolder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 自动回复控制器
 *
 * @author wyframe
 * @Date 2017-10-23 17:20:43
 */
@Controller
@RequestMapping("/wx_auto_reply")
public class Wx_auto_replyController extends BaseController {
	private String PREFIX = "/addons/zcgl/auto_reply/";
	@Resource
	Wx_auto_replyDao wx_auto_replyDao;
	
	@Resource
	Wx_auto_replyMapper wx_auto_replyMapper;
	
	public static List<Map<String, Object>> paramList = null;
    /**
     * 跳转到自动回复首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "wx_auto_reply.html";
    }

    /**
     * 跳转到添加自动回复
     */
    @RequestMapping("/wx_auto_reply_add")
    public String wx_auto_replyAdd() {
        return PREFIX + "wx_auto_reply_add.html";
    }
    
    /**
	 * 跳转到添加参数
	 */
	@RequestMapping("/wx_auto_reply_add_param")
	public String wx_auto_reply_add_param() {
		return PREFIX + "wx_auto_reply_add_param.html";
	}

    /**
     * 跳转到修改自动回复
     */
    @RequestMapping("/wx_auto_reply_update/{wx_auto_replyId}")
    public String wx_auto_replyUpdate(@PathVariable Integer wx_auto_replyId, Model model) {
    	Wx_auto_reply wx_auto_reply = this.wx_auto_replyDao.queryById(wx_auto_replyId);
    	model.addAttribute(wx_auto_reply);
		LogObjectHolder.me().set(wx_auto_reply);
        return PREFIX + "wx_auto_reply_edit.html";
    }

	/**
     * 跳转到详情自动回复
     */
    @RequestMapping("/wx_auto_reply_detail/{wx_auto_replyId}")
    public String wx_auto_replyDetail(@PathVariable Integer wx_auto_replyId, Model model) {
    	Wx_auto_reply wx_auto_reply = this.wx_auto_replyDao.queryById(wx_auto_replyId);
    	model.addAttribute(wx_auto_reply);
		LogObjectHolder.me().set(wx_auto_reply);
        return PREFIX + "wx_auto_reply_detail.html";
    
    }

    /**
     * 获取自动回复列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
    paramList = null;
    List<Map<String, Object>> list = this.wx_auto_replyDao.list(condition);
        return super.warpObject(new Wx_auto_replyWarpper(list));
    }


    /**
     * 新增自动回复
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Wx_auto_reply wx_auto_reply) {
        return this.wx_auto_replyMapper.insert(wx_auto_reply);
    }

    /**
     * 删除自动回复
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer wx_auto_replyId) {
    	this.wx_auto_replyMapper.deleteById(wx_auto_replyId);
        return SUCCESS_TIP;
    }

    /**
     * 修改自动回复
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Wx_auto_reply wx_auto_reply) {
    	this.wx_auto_replyMapper.updateById(wx_auto_reply);
    	paramList=null;
        return super.SUCCESS_TIP;
    }
    
     /**
     * 导出自动回复
     */
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void export(HttpServletResponse res)  throws ParsePropertyException, InvalidFormatException, IOException {
    	String resourcePath = "src/main/resources/excelTemplate/wx_auto_reply.xls";
    	String tarPath = "src/main/resources/excel/wx_auto_reply.xls";
    	String condition = null;
    	 List<Map<String, Object>> list = this.wx_auto_replyDao.list(condition);
    	 Map<String, List<Map<String,Object>>> beanParams = new HashMap<String, List<Map<String,Object>>>();  
	     beanParams.put("list", list);  
	     XLSTransformer former = new XLSTransformer();  
	     former.transformXLS(resourcePath, beanParams, tarPath); 
	     
	     //下载
		String fileName = "wx_auto_reply"+DateUtil.getAllTime()+".xls";
		res.setHeader("content-type", "application/octet-stream");
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		try {
			os = res.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(new File("src/main/resources/excel/wx_auto_reply.xls")));
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
