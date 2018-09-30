package wy.rest.addons.zsh.bs_shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wy.core.base.controller.BaseController;
import wy.core.util.DateUtil;
import wy.rest.addons.zsh.bs_shop.dao.Bs_shopDao;
import wy.rest.addons.zsh.bs_shop.dao.Bs_shopMapper;
import wy.rest.addons.zsh.bs_shop.model.Bs_shop;
import wy.rest.addons.zsh.bs_shop.warpper.Bs_shopWarpper;

import javax.annotation.Resource;
import java.util.*;

/**
 * 商品控制器
 *
 * @author wyFrame
 * @Date 2018-07-25 14:33:23
 */
@Controller
@RequestMapping("/bs_shop")
public class Bs_shopController extends BaseController {

    private String PREFIX = "/addons/zsh/bs_shop/";
    @Resource
    Bs_shopDao bs_shopDao;

    @Resource
    Bs_shopMapper bs_shopMapper;


    /**
     * 跳转到商品首页
     */
    @RequestMapping("")
    public String index(Model model) {
        return PREFIX + "bs_shop.html";
    }

    /**
     * 跳转到添加商品
     */
    @RequestMapping("/bs_shop_add")
    public String bs_shopAdd(Model model) {
        List<Map<String, Object>> list10 = bs_shopDao.getMap10();
        model.addAttribute("map10", list10);
        return PREFIX + "bs_shop_add.html";
    }

    /**
     * 跳转到修改商品
     */
    @RequestMapping("/bs_shop_update/{bs_shopId}")
    public String bs_shopUpdate(@PathVariable Integer bs_shopId, Model model) {
        Bs_shop bs_shop = this.bs_shopDao.queryById(bs_shopId);
        model.addAttribute(bs_shop);
        List<Map<String, Object>> list10 = bs_shopDao.getMap10();
        model.addAttribute("map10", list10);
        return PREFIX + "bs_shop_edit.html";
    }

    /**
     * 获取商品列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition, Integer xyd_st_id) {
        if (null == xyd_st_id) {
            xyd_st_id = 1;
        }
        List<Map<String, Object>> list = this.bs_shopDao.list(condition, xyd_st_id);
        return super.warpObject(new Bs_shopWarpper(list));
    }

    /**
     * 获取商品列表
     */
    @RequestMapping(value = "/editList")
    @ResponseBody
    public Object editList(String condition, Integer xyd_st_id) {
        if (null == xyd_st_id) {
            xyd_st_id = 1;
        }
        List<Map<String, Object>> list = this.bs_shopDao.list(condition, xyd_st_id);
        Map<String, Object> map = new HashMap();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", list.size());
        map.put("data", super.warpObject(new Bs_shopWarpper(list)));
        return map;
    }

    /**
     * 新增商品
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(@RequestBody Bs_shop bs_shop) {
        bs_shop.setXyd_st_id(1);
        bs_shop.setXyd_cre_dt(DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        bs_shop.setXyd_up_dt(DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        return this.bs_shopMapper.insert(bs_shop);
    }

    /**
     * 删除商品
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String bs_shopIds) {
        //物理删除
        //this.bs_shopMapper.deleteById(bs_shopId);
        //逻辑删除
        String[] split = bs_shopIds.split(",");
        Integer[] iarray = new Integer[split.length];
        for (int i = 0; i < split.length; i++) {
            iarray[i] = Integer.parseInt(split[i]);
        }
        List<Integer> list = Arrays.asList(iarray);
        this.bs_shopDao.deleteByIds(list);
        return SUCCESS_TIP;
    }

    /**
     * 修改商品
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Bs_shop bs_shop) {
        bs_shop.setXyd_up_dt(DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        this.bs_shopMapper.updateById(bs_shop);
        return super.SUCCESS_TIP;
    }


    /**
     * 跳转到详情商品
     */
    @RequestMapping("/bs_shop_detail/{bs_shopId}")
    public String bs_shopDetail(@PathVariable Integer bs_shopId, Model model) {
        Bs_shop bs_shop = this.bs_shopDao.queryById(bs_shopId);
        model.addAttribute(bs_shop);
        List<Map<String, Object>> list10 = bs_shopDao.getMap10();
        model.addAttribute("map10", list10);
        return PREFIX + "bs_shop_detail.html";
    }


}
