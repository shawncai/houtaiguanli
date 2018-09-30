package wy.rest.addons.zsh.bs_sale_channel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wy.core.base.controller.BaseController;
import wy.core.util.DateUtil;
import wy.rest.addons.zsh.bs_sale_channel.dao.Bs_sale_channelDao;
import wy.rest.addons.zsh.bs_sale_channel.dao.Bs_sale_channelMapper;
import wy.rest.addons.zsh.bs_sale_channel.model.Bs_sale_channel;
import wy.rest.addons.zsh.bs_sale_channel.warpper.Bs_sale_channelWarpper;

import javax.annotation.Resource;
import java.util.*;

/**
 * 销售渠道控制器
 *
 * @author wyFrame
 * @Date 2018-07-25 14:10:16
 */
@Controller
@RequestMapping("/bs_sale_channel")
public class Bs_sale_channelController extends BaseController {

    private String PREFIX = "/addons/zsh/bs_sale_channel/";
    @Resource
    Bs_sale_channelDao bs_sale_channelDao;

    @Resource
    Bs_sale_channelMapper bs_sale_channelMapper;

    /**
     * 跳转到销售渠道首页
     */
    @RequestMapping("")
    public String index(Model model) {
//        List<Map<String, Object>> list6 = ConstantFactory.me().getDictByName("删除状态");
//        model.addAttribute("map6", list6);
        return PREFIX + "bs_sale_channel.html";
    }

    /**
     * 跳转到添加销售渠道
     */
    @RequestMapping("/bs_sale_channel_add")
    public String bs_sale_channelAdd(Model model) {
//        List<Map<String, Object>> list6 = ConstantFactory.me().getDictByName("删除状态");
//        model.addAttribute("map6", list6);
        List<Map<String, Object>> list9 = bs_sale_channelDao.getMap9();
        model.addAttribute("map9", list9);
        return PREFIX + "bs_sale_channel_add.html";
    }

    /**
     * 跳转到修改销售渠道
     */
    @RequestMapping("/bs_sale_channel_update/{bs_sale_channelId}")
    public String bs_sale_channelUpdate(@PathVariable Integer bs_sale_channelId, Model model) {
        Bs_sale_channel bs_sale_channel = this.bs_sale_channelDao.queryById(bs_sale_channelId);
        model.addAttribute(bs_sale_channel);
//        List<Map<String, Object>> list6 = ConstantFactory.me().getDictByName("删除状态");
//        model.addAttribute("map6", list6);
        List<Map<String, Object>> list9 = bs_sale_channelDao.getMap9();
        model.addAttribute("map9", list9);
        return PREFIX + "bs_sale_channel_edit.html";
    }

    /**
     * 获取销售渠道列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition, Integer xyd_st_id) {
        if (null == xyd_st_id) {
            xyd_st_id = 1;
        }
        List<Map<String, Object>> list = this.bs_sale_channelDao.list(condition, xyd_st_id);
        return super.warpObject(new Bs_sale_channelWarpper(list));
    }

    /**
     * 获取销售渠道列表
     */
    @RequestMapping(value = "/editList")
    @ResponseBody
    public Object editList(String condition, Integer xyd_st_id) {
        if (null == xyd_st_id) {
            xyd_st_id = 1;
        }
        List<Map<String, Object>> list = this.bs_sale_channelDao.list(condition, xyd_st_id);
        Map<String, Object> map = new HashMap();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", list.size());
        map.put("data", super.warpObject(new Bs_sale_channelWarpper(list)));
        return map;
    }

    /**
     * 新增销售渠道
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(@RequestBody Bs_sale_channel bs_sale_channel) {
        bs_sale_channel.setXyd_st_id(1);
        bs_sale_channel.setXyd_cre_dt(DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        bs_sale_channel.setXyd_up_dt(DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        return this.bs_sale_channelMapper.insert(bs_sale_channel);
    }

    /**
     * 删除销售渠道
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String bs_sale_channelIds) {
        //物理删除
        //this.bs_sale_channelMapper.deleteById(bs_sale_channelId);
        //逻辑删除
        String[] split = bs_sale_channelIds.split(",");
        Integer[] iarray = new Integer[split.length];
        for (int i = 0; i < split.length; i++) {
            iarray[i] = Integer.parseInt(split[i]);
        }
        List<Integer> list = Arrays.asList(iarray);
        this.bs_sale_channelDao.deleteByIds(list);
        return SUCCESS_TIP;
    }

    /**
     * 修改销售渠道
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Bs_sale_channel bs_sale_channel) {
        bs_sale_channel.setXyd_up_dt(DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        this.bs_sale_channelMapper.updateById(bs_sale_channel);
        return super.SUCCESS_TIP;
    }


    /**
     * 跳转到详情销售渠道
     */
    @RequestMapping("/bs_sale_channel_detail/{bs_sale_channelId}")
    public String bs_sale_channelDetail(@PathVariable Integer bs_sale_channelId, Model model) {
        Bs_sale_channel bs_sale_channel = this.bs_sale_channelDao.queryById(bs_sale_channelId);
        model.addAttribute(bs_sale_channel);
//        List<Map<String, Object>> list6 = ConstantFactory.me().getDictByName("删除状态");
//        model.addAttribute("map6", list6);
        List<Map<String, Object>> list9 = bs_sale_channelDao.getMap9();
        model.addAttribute("map9", list9);

        return PREFIX + "bs_sale_channel_detail.html";
    }


}
