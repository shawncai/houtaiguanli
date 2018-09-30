package wy.rest.addons.zsh.bs_bill.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import wy.core.base.controller.BaseController;
import wy.core.util.DateUtil;
import wy.rest.addons.zsh.bs_bill.dao.Bs_billDao;
import wy.rest.addons.zsh.bs_bill.dao.Bs_billMapper;
import wy.rest.addons.zsh.bs_bill.model.Bs_bill;
import wy.rest.addons.zsh.bs_bill.warpper.Bs_billWarpper;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 订单控制器
 *
 * @author wyFrame
 * @Date 2018-07-25 15:15:59
 */
@Controller
@RequestMapping("/bs_bill")
public class Bs_billController extends BaseController {

    private String PREFIX = "/addons/zsh/bs_bill/";
    @Resource
    Bs_billDao bs_billDao;

    @Resource
    Bs_billMapper bs_billMapper;


    public List<String> distinct;

    /**
     * 跳转到订单首页
     */
    @RequestMapping("")
    public String index(Model model) {
        return PREFIX + "bs_bill.html";
    }

    /**
     * 跳转到添加订单
     */
    @RequestMapping("/bs_bill_add")
    public String bs_billAdd(Model model) {
        List<Map<String, Object>> list8 = bs_billDao.getMap8();
        model.addAttribute("map8", list8);
        List<Map<String, Object>> list9 = bs_billDao.getMap9();
        model.addAttribute("map9", list9);
        List<Map<String, Object>> list10 = bs_billDao.getMap10();
        model.addAttribute("map10", list10);
        List<Map<String, Object>> list13 = bs_billDao.getMap13();
        model.addAttribute("map13", list13);
        List<Map<String, Object>> list15 = bs_billDao.getMap15();
        model.addAttribute("map15", list15);
        List<Map<String, Object>> list19 = bs_billDao.getMap19();
        model.addAttribute("map19", list19);
        return PREFIX + "bs_bill_add.html";
    }

    /**
     * 跳转到添加参数表订单
     */
    @RequestMapping("/bs_bill_addParam/{strs}")
    public String bs_bill_addParam(@PathVariable String strs) {
        String[] split = strs.split(",");
        distinct = Arrays.asList(split);
        return PREFIX + "bs_bill_addParam.html";
    }

    /**
     * 跳转到修改订单
     */
    @RequestMapping("/bs_bill_update/{bs_billId}")
    public String bs_billUpdate(@PathVariable Integer bs_billId, Model model) {
        Bs_bill bs_bill = this.bs_billDao.queryById(bs_billId);
        model.addAttribute(bs_bill);
        List<Map<String, Object>> list8 = bs_billDao.getMap8();
        model.addAttribute("map8", list8);
        List<Map<String, Object>> list9 = bs_billDao.getMap9();
        model.addAttribute("map9", list9);
        List<Map<String, Object>> list10 = bs_billDao.getMap10();
        model.addAttribute("map10", list10);
        List<Map<String, Object>> list13 = bs_billDao.getMap13();
        model.addAttribute("map13", list13);
        List<Map<String, Object>> list15 = bs_billDao.getMap15();
        model.addAttribute("map15", list15);
        List<Map<String, Object>> list19 = bs_billDao.getMap19();
        model.addAttribute("map19", list19);
        return PREFIX + "bs_bill_edit.html";
    }

    /**
     * 获取订单列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition, Integer bill_st_id, Integer send_st, Integer xyd_st_id) {
        if (null == xyd_st_id) {
            xyd_st_id = 1;
        }
        List<Map<String, Object>> list = this.bs_billDao.list(condition, bill_st_id, send_st, xyd_st_id);
        return super.warpObject(new Bs_billWarpper(list));
    }

    /**
     * 获取订单副列表
     */
    @RequestMapping(value = "/fuList")
    @ResponseBody
    public Object fuList() {
        List<Map<String, Object>> list = this.bs_billDao.fuList();
        return super.warpObject(new Bs_billWarpper(list));
    }

    /**
     * 获取订单参数列表
     */
    @RequestMapping(value = "/paramList")
    @ResponseBody
    public Object paramList() {
        List<Map<String, Object>> list = this.bs_billDao.paramList();
        List<Map<String, Object>> list1 = new ArrayList<>();
        for (String s : distinct) {
            for (Map<String, Object> map : list) {
                if ((Integer) map.get("shop_id") == Integer.parseInt(s)) {
                    list1.add(map);
                }
                map.put("num", 0);
            }
        }
        list.removeAll(list1);
        return super.warpObject(new Bs_billWarpper(list));
    }

    /**
     * 获取订单修改参数列表
     */
    @RequestMapping(value = "/initParam/{moren}")
    @ResponseBody
    public Object initParam(@PathVariable Integer moren) {
        List<Map<String, Object>> list = this.bs_billDao.initParam(moren);
        return super.warpObject(new Bs_billWarpper(list));
    }

    /**
     * 获取订单列表
     */
    @RequestMapping(value = "/editList")
    @ResponseBody
    public Object editList(String condition, Integer bill_st_id, Integer send_st, Integer xyd_st_id) {
        if (null == xyd_st_id) {
            xyd_st_id = 1;
        }
        List<Map<String, Object>> list = this.bs_billDao.list(condition, bill_st_id, send_st, xyd_st_id);
        Map<String, Object> map = new HashMap();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", list.size());
        map.put("data", super.warpObject(new Bs_billWarpper(list)));
        return map;
    }

    /**
     * 新增订单
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(@RequestParam String idata, @RequestParam String tdata) {
        System.err.println(idata);
        Map<String, Object> map = (Map<String, Object>) JSON.parse(idata);
        List<Map<String, Object>> list = (List<Map<String, Object>>) JSON.parse(tdata.replaceAll("\\[],", "").replaceAll(",\\[]", ""));
        map.put("xyd_st_id", 1);
        map.put("xyd_cre_dt", DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        map.put("xyd_up_dt", DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        map.put("buy_dt", DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        map.put("pay_dt", DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        map.put("bill_st_id", 2);
        map.put("send_st", 1);
        map.put("crt_dt", DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        map.put("bill_no", new SimpleDateFormat("yyyyMMDDHHmmss").format(new Date()) );
        //按地区查省和城市，拼接完整地址
        Map<String, String> areaMap = this.bs_billDao.selectArea(Integer.parseInt(map.get("area_id").toString()));
        map.put("new_area_desc", areaMap.get("prov_nm") + areaMap.get("city_nm") + areaMap.get("region_nm") + map.get("access_addr_desc"));
        Integer area_id = Integer.parseInt(map.get("area_id").toString());
        int num = 0;
        for (Map<String, Object> m : list) {
            num += Integer.parseInt(m.get("num").toString());
        }
        map.put("total_num", num);
        List<Map<String, Object>> selectSendChannel = this.bs_billDao.selectSendChannel(area_id);
        for (Map<String, Object> mapChannel : selectSendChannel) {
            if ((Integer) mapChannel.get("send_chnl_flg") == 1 && num > (Integer) mapChannel.get("send_chnl_num")) {
                map.put("send_chnl_id", mapChannel.get("send_chnl_id"));
            } else if ((Integer) mapChannel.get("send_chnl_flg") == 2 && num >= (Integer) mapChannel.get("send_chnl_num")) {
                map.put("send_chnl_id", mapChannel.get("send_chnl_id"));
            } else if ((Integer) mapChannel.get("send_chnl_flg") == 3 && num < (Integer) mapChannel.get("send_chnl_num")) {
                map.put("send_chnl_id", mapChannel.get("send_chnl_id"));
            } else if ((Integer) mapChannel.get("send_chnl_flg") == 4 && num <= (Integer) mapChannel.get("send_chnl_num")) {
                map.put("send_chnl_id", mapChannel.get("send_chnl_id"));
            }
        }
        this.bs_billDao.insertTotal(map);
        for (Map<String, Object> m : list) {
            m.put("bill_id", map.get("bill_id"));
        }
        this.bs_billDao.insertDetail(list);
        return SUCCESS_TIP;
    }

    /**
     * 保存订单
     */
    @RequestMapping(value = "/save")
    @ResponseBody
    public Object save(@RequestParam String idata, @RequestParam String tdata) {
        Map<String, Object> map = (Map<String, Object>) JSON.parse(idata);
        List<Map<String, Object>> list = (List<Map<String, Object>>) JSON.parse(tdata.replaceAll("\\[],", "").replaceAll(",\\[]", ""));
        map.put("xyd_st_id", 1);
        map.put("xyd_cre_dt", DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        map.put("xyd_up_dt", DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        map.put("buy_dt", DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        map.put("pay_dt", DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        map.put("bill_st_id", 1);
        map.put("send_st", 1);
        map.put("crt_dt", DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        map.put("bill_no", new SimpleDateFormat("yyyyMMDDHHmmss").format(new Date()) );
        //按地区查省和城市，拼接完整地址
        Map<String, String> areaMap = this.bs_billDao.selectArea(Integer.parseInt(map.get("area_id").toString()));
        map.put("new_area_desc", areaMap.get("prov_nm") + areaMap.get("city_nm") + areaMap.get("region_nm") + map.get("access_addr_desc"));
        Integer area_id = Integer.parseInt(map.get("area_id").toString());
        int num = 0;
        for (Map<String, Object> m : list) {
            num += Integer.parseInt(m.get("num").toString());
        }
        map.put("total_num", num);

        this.bs_billDao.insertTotal(map);
        for (Map<String, Object> m : list) {
            m.put("bill_id", map.get("bill_id"));
        }
        this.bs_billDao.insertDetail(list);
        return SUCCESS_TIP;
    }

    /**
     * 删除订单
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String bs_billIds) {
        //物理删除
        //this.bs_billMapper.deleteById(bs_billId);
        //逻辑删除
        String[] split = bs_billIds.split(",");
        Integer[] iarray = new Integer[split.length];
        for (int i = 0; i < split.length; i++) {
            iarray[i] = Integer.parseInt(split[i]);
        }
        List<Integer> list = Arrays.asList(iarray);
        this.bs_billDao.deleteByIds(list);
        return SUCCESS_TIP;
    }


    /**
     * 跳转到配送更新
     */
    @RequestMapping("/bs_bill_sendUpdate/{bs_billId}")
    public String bs_bill_sendUpdate(@PathVariable Integer bs_billId, Model model) {
        model.addAttribute("bs_billId",bs_billId);
        Bs_bill bs_bill = this.bs_billDao.queryById(bs_billId);
        model.addAttribute("send_remark",bs_bill.getSend_remark());
        return PREFIX + "bs_bill_sendUpdate.html";

    }

    /**
     * 改变配送状态
     */
    @RequestMapping("/bs_bill_sendUpdateIng/{bs_billId}")
    @ResponseBody
    public Object bs_bill_sendUpdateIng(@PathVariable Integer bs_billId,@RequestParam Integer send_st,@RequestParam String sendTime,@RequestParam String send_remark){
        System.err.println(bs_billId+","+send_st+","+sendTime+","+send_remark);
        this.bs_billDao.changeSendToIng(bs_billId,send_st,sendTime,send_remark,null);
        return SUCCESS_TIP;
    }
    /**
     * 修改订单
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Bs_bill bs_bill, @RequestParam String tdata) {
        bs_bill.setXyd_up_dt(DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        List<Map<String, Object>> list = (List<Map<String, Object>>) JSON.parse(tdata.replaceAll("\\[],", "").replaceAll(",\\[]", ""));
        int num = 0;
        for (Map<String, Object> m : list) {
            num += Integer.parseInt(m.get("num").toString());
        }
        bs_bill.setTotal_num(num);
        Map<String, String> areaMap = this.bs_billDao.selectArea(bs_bill.getArea_id());
        bs_bill.setAccess_addr_desc(areaMap.get("prov_nm") + areaMap.get("city_nm") + areaMap.get("region_nm") + bs_bill.getAccess_addr_desc());
        Integer area_id = bs_bill.getArea_id();
        List<Map<String, Object>> selectSendChannel = this.bs_billDao.selectSendChannel(area_id);
        for (Map<String, Object> mapChannel : selectSendChannel) {
            if ((Integer) mapChannel.get("send_chnl_flg") == 1 && num > (Integer) mapChannel.get("send_chnl_num")) {
                bs_bill.setSend_chnl_id(Integer.parseInt(mapChannel.get("send_chnl_id") + ""));
            } else if ((Integer) mapChannel.get("send_chnl_flg") == 2 && num >= (Integer) mapChannel.get("send_chnl_num")) {
                bs_bill.setSend_chnl_id(Integer.parseInt(mapChannel.get("send_chnl_id") + ""));
            } else if ((Integer) mapChannel.get("send_chnl_flg") == 3 && num < (Integer) mapChannel.get("send_chnl_num")) {
                bs_bill.setSend_chnl_id(Integer.parseInt(mapChannel.get("send_chnl_id") + ""));
            } else if ((Integer) mapChannel.get("send_chnl_flg") == 4 && num <= (Integer) mapChannel.get("send_chnl_num")) {
                bs_bill.setSend_chnl_id(Integer.parseInt(mapChannel.get("send_chnl_id") + ""));
            }
        }
        this.bs_billMapper.updateById(bs_bill);
        for (Map<String, Object> m : list) {
            m.put("bill_id", bs_bill.getBill_id());
        }
        this.bs_billDao.deleteDetail(bs_bill.getBill_id());
        this.bs_billDao.insertDetail(list);
        return super.SUCCESS_TIP;
    }


    /**
     * 跳转到详情订单
     */
    @RequestMapping("/bs_bill_detail/{bs_billId}")
    public String bs_billDetail(@PathVariable Integer bs_billId, Model model) {
        Bs_bill bs_bill = this.bs_billDao.queryById(bs_billId);
        model.addAttribute(bs_bill);
        List<Map<String, Object>> list8 = bs_billDao.getMap8();
        model.addAttribute("map8", list8);
        List<Map<String, Object>> list9 = bs_billDao.getMap9();
        model.addAttribute("map9", list9);
        List<Map<String, Object>> list10 = bs_billDao.getMap10();
        model.addAttribute("map10", list10);
        List<Map<String, Object>> list13 = bs_billDao.getMap13();
        model.addAttribute("map13", list13);
        List<Map<String, Object>> list15 = bs_billDao.getMap15();
        model.addAttribute("map15", list15);
        List<Map<String, Object>> list19 = bs_billDao.getMap19();
        model.addAttribute("map19", list19);
        return PREFIX + "bs_bill_detail.html";
    }

    /**
     * 跳转到打印订单
     */
    @RequestMapping("/bs_bill_print/{bs_billId}")
    public String print(@PathVariable Integer bs_billId, Model model) {
        Bs_bill bs_bill = this.bs_billDao.queryById(bs_billId);
        model.addAttribute(bs_bill);
        return PREFIX + "bs_bill_print.html";

    }
}
