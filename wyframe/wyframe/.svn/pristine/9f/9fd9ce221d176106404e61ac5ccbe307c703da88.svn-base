package wy.addons.fxb.xgt_sub_exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import wy.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.OutputStream;
import java.io.File;
import java.util.Arrays;
import com.alibaba.fastjson.JSON;
import wy.core.util.DateUtil;
import java.io.FileInputStream;
import wy.core.shiro.ShiroKit;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Date;
import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;
import javax.annotation.Resource;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import wy.core.log.LogObjectHolder;
import wy.core.util.DateUtil;
import wy.common.constant.factory.ConstantFactory;
import wy.config.properties.XydProperties;
import com.alibaba.fastjson.JSON;
import net.sf.json.JSONObject;
import wy.common.annotion.Permission;
import wy.common.annotion.BussinessLog;
import wy.common.persistence.model.Page;;
import wy.common.persistence.model.ResultMap;
import wy.core.node.Node;
import wy.core.util.TreeBuilder;
import javax.servlet.http.HttpServletRequest;
import wy.addons.fxb.xgt_sub_exam.model.Xgt_sub_exam;
import org.springframework.web.bind.annotation.PathVariable;
import wy.addons.fxb.xgt_sub_exam.dao.Xgt_sub_examDao;
import wy.addons.fxb.xgt_sub_exam.dao.Xgt_sub_examMapper;
import wy.addons.fxb.xgt_sub_exam.warpper.Xgt_sub_examWarpper;

/**
 * 试卷控制器
 *
 * @author wyFrame
 * @Date 2018-09-04 11:49:19
 */
@Controller
@RequestMapping("/xgt_sub_exam")
public class Xgt_sub_examController extends BaseController {

    private String PREFIX = "/addons/fxb/xgt_sub_exam/";
	@Autowired
	Xgt_sub_examDao xgt_sub_examDao;
	
	@Autowired
	Xgt_sub_examMapper xgt_sub_examMapper;

	@Resource
    XydProperties xydProperties;
	
    /**
     * 跳转到试卷首页
     */
    @RequestMapping("")
    public String index(Model model) {
                 List<Map<String, Object>> list13 = ConstantFactory.me().getDictByName("状态");
                 model.addAttribute("map13",list13);
        return PREFIX + "xgt_sub_exam.html";
    }

    /**
     * 跳转到添加试卷
     */
    @RequestMapping("/xgt_sub_exam_add/{xgt_sub_examId}")
    public String xgt_sub_examAdd(@PathVariable Integer xgt_sub_examId,Model model) {
    Xgt_sub_exam xgt_sub_exam = this.xgt_sub_examDao.queryById(xgt_sub_examId);
        	model.addAttribute(xgt_sub_exam);

                   List<Map<String, Object>> list2 = xgt_sub_examDao.getMap2();
                   model.addAttribute("map2",list2);
                   List<Map<String, Object>> list3 = xgt_sub_examDao.getMap3();
                   model.addAttribute("map3",list3);
                   List<Map<String, Object>> list4 = xgt_sub_examDao.getMap4();
                   model.addAttribute("map4",list4);
             List<Map<String, Object>> list13 = ConstantFactory.me().getDictByName("状态");
             model.addAttribute("map13",list13);
        return PREFIX + "xgt_sub_exam_add.html";
    }

    /**
     * 跳转到修改试卷
     */
    @RequestMapping("/xgt_sub_exam_update/{xgt_sub_examId}")
    public String xgt_sub_examUpdate(@PathVariable Integer xgt_sub_examId, Model model) {
    	Xgt_sub_exam xgt_sub_exam = this.xgt_sub_examDao.queryById(xgt_sub_examId);
    	model.addAttribute(xgt_sub_exam);
		LogObjectHolder.me().set(xgt_sub_exam);
                                 List<Map<String, Object>> list2 = xgt_sub_examDao.getMap2();
                                 model.addAttribute("map2",list2);
                                 List<Map<String, Object>> list3 = xgt_sub_examDao.getMap3();
                                 model.addAttribute("map3",list3);
                                 List<Map<String, Object>> list4 = xgt_sub_examDao.getMap4();
                                 model.addAttribute("map4",list4);
                     List<Map<String, Object>> list13 = ConstantFactory.me().getDictByName("状态");
                     model.addAttribute("map13",list13);
        return PREFIX + "xgt_sub_exam_edit.html";
    }

    /**
     * 获取试卷列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition ,Integer st_id) {
        List<Map<String, Object>> list = this.xgt_sub_examDao.list(condition,st_id);
        return super.warpObject(new Xgt_sub_examWarpper(list));
    }

    /**
     * 获取试卷列表
     */
    @RequestMapping(value = "/editList")
    @ResponseBody
    public Object editList(String condition,Integer st_id) {
        List<Map<String, Object>> list = this.xgt_sub_examDao.list(condition,st_id);
        Map<String,Object> map = new HashMap();
        map.put("code",0);
        map.put("msg","");
        map.put("count",list.size());
        map.put("data",super.warpObject(new Xgt_sub_examWarpper(list)));
        return map;
    }

    /**
     * 新增试卷
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Xgt_sub_exam xgt_sub_exam) {
        Integer userId = ShiroKit.getUser().getId();
        Integer cpnId=xgt_sub_examDao.queryCpnId(userId);
        xgt_sub_exam.setId(ShiroKit.getUser().getId());
        xgt_sub_exam.setCre_dt(new Date());
        xgt_sub_exam.setSt_id(1);
        xgt_sub_exam.setCpn_id(cpnId);
        return this.xgt_sub_examMapper.insert(xgt_sub_exam);
    }

    /**
     * 删除试卷
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String xgt_sub_examIds) {
        //物理删除
    	//this.xgt_sub_examMapper.deleteById(xgt_sub_examId);
    	//逻辑删除
    	  String[] split =xgt_sub_examIds.split(",");
          Integer[] iarray = new Integer[split.length];
          for(int i=0;i<split.length;i++){
              iarray[i]=Integer.parseInt(split[i]);
           }
          List<Integer> list = Arrays.asList(iarray);
    	this.xgt_sub_examDao.deleteByIds(list);
        return SUCCESS_TIP;
    }

     /**
     * 修改试卷
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Xgt_sub_exam xgt_sub_exam) {
    	this.xgt_sub_examMapper.updateById(xgt_sub_exam);
        return super.SUCCESS_TIP;
    }

     @RequestMapping("/bulidJsonTree")
        @ResponseBody
        public String buildJsonTree(HttpServletRequest request) {
            List<Node> nodes = xgt_sub_examDao.tree1();
            String json = new TreeBuilder().buildTree(nodes);
            return json;
        }

        @RequestMapping("/bulidJson")
        @ResponseBody
        public JSONObject buildJson(HttpServletResponse response, @RequestParam(required = false) String condition, @RequestParam(required = false) Integer id) {
            if (null==id){
                id=0;
            }
            List list=xgt_sub_examDao.list4(condition,id);
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("data",list);
            String json= JSON.toJSONString(map);
            System.out.println(json);
            JSONObject jsStr = JSONObject.fromObject(json);
            System.err.println(jsStr);
            return jsStr;
        }

         @RequestMapping(value = "/shangji")
            @ResponseBody
            public JSONObject shangji(){
                List list=xgt_sub_examDao.getMapByPar();
                Map<String,Object> map = new HashMap<String,Object>();
                map.put("data",list);
                String json= JSON.toJSONString(map);
                System.out.println(json);
                JSONObject shangji = JSONObject.fromObject(json);
                System.err.println(shangji);
                return shangji;
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
            List<Map>contentList=xgt_sub_examDao.selectPageList(page,start,rows,id,condition);
            int totals=xgt_sub_examDao.selectPageCount(page,id);
            page.setTotalRecord(totals);
            return new ResultMap<List<Map>>("",contentList,0,totals);
        }



	/**
     * 跳转到详情试卷
     */
    @RequestMapping("/xgt_sub_exam_detail/{xgt_sub_examId}")
    public String xgt_sub_examDetail(@PathVariable Integer xgt_sub_examId, Model model) {
    	Xgt_sub_exam xgt_sub_exam = this.xgt_sub_examDao.queryById(xgt_sub_examId);
    	model.addAttribute(xgt_sub_exam);
                                 List<Map<String, Object>> list2 = xgt_sub_examDao.getMap2();
                                 model.addAttribute("map2",list2);
                                 List<Map<String, Object>> list3 = xgt_sub_examDao.getMap3();
                                 model.addAttribute("map3",list3);
                                 List<Map<String, Object>> list4 = xgt_sub_examDao.getMap4();
                                 model.addAttribute("map4",list4);
                     List<Map<String, Object>> list13 = ConstantFactory.me().getDictByName("状态");
                     model.addAttribute("map13",list13);

		LogObjectHolder.me().set(xgt_sub_exam);
        return PREFIX + "xgt_sub_exam_detail.html";
    }

     /**
     * 导出试卷
     */
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void export(HttpServletResponse res)  throws ParsePropertyException, InvalidFormatException, IOException {
    	String resourcePath = "src/main/resources/excelTemplate/xgt_sub_exam.xls";
    	String tarPath = "src/main/resources/excel/xgt_sub_exam.xls";
    	String condition = null;
    	// List<Map<String, Object>> list = this.xgt_sub_examDao.list(condition);
    	 Map<String, List<Map<String,Object>>> beanParams = new HashMap<String, List<Map<String,Object>>>();  
	    // beanParams.put("list", list);
	     XLSTransformer former = new XLSTransformer();  
	     former.transformXLS(resourcePath, beanParams, tarPath); 
	     
	     //下载
		String fileName = "xgt_sub_exam"+DateUtil.getAllTime()+".xls";
		res.setHeader("content-type", "application/octet-stream");
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		try {
			os = res.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(new File("src/main/resources/excel/xgt_sub_exam.xls")));
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
