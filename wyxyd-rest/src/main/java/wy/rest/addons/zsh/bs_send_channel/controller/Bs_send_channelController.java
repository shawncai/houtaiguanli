package wy.rest.addons.zsh.bs_send_channel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import wy.core.base.controller.BaseController;
import wy.core.base.tips.Tip;
import wy.core.node.ZTreeNode;
import wy.core.util.Convert;
import wy.core.util.DateUtil;
import wy.rest.addons.zsh.bs_send_channel.dao.Bs_send_channelDao;
import wy.rest.addons.zsh.bs_send_channel.dao.Bs_send_channelMapper;
import wy.rest.addons.zsh.bs_send_channel.model.Bs_send_channel;
import wy.rest.addons.zsh.bs_send_channel.warpper.Bs_send_channelWarpper;

import javax.annotation.Resource;
import java.util.*;

/**
 * 配送商控制器
 *
 * @author wyFrame
 * @Date 2018-07-25 14:28:36
 */
@Controller
@RequestMapping("/bs_send_channel")
public class Bs_send_channelController extends BaseController {

    private String PREFIX = "/addons/zsh/bs_send_channel/";
    @Resource
    Bs_send_channelDao bs_send_channelDao;

    @Resource
    Bs_send_channelMapper bs_send_channelMapper;

    /**
     * 跳转到配送商首页
     */
    @RequestMapping("")
    public String index(Model model) {
        return PREFIX + "bs_send_channel.html";
    }

    /**
     * 跳转到添加配送商
     */
    @RequestMapping("/bs_send_channel_add")
    public String bs_send_channelAdd(Model model) {
        List<Map<String, Object>> list10 = bs_send_channelDao.getMap10();
        model.addAttribute("map10", list10);
        return PREFIX + "bs_send_channel_add.html";
    }

    /**
     * 跳转到修改配送商
     */
    @RequestMapping("/bs_send_channel_update/{bs_send_channelId}")
    public String bs_send_channelUpdate(@PathVariable Integer bs_send_channelId, Model model) {
        Bs_send_channel bs_send_channel = this.bs_send_channelDao.queryById(bs_send_channelId);
        model.addAttribute(bs_send_channel);
        List<Map<String, Object>> list10 = bs_send_channelDao.getMap10();
        model.addAttribute("map10", list10);
        return PREFIX + "bs_send_channel_edit.html";
    }

    /**
     * 点击跳转用户区域分配管理
     */
    @RequestMapping(value = "/area_assign/{channelId}")
    public String areaAssign(@PathVariable Integer channelId, Model model) {
        model.addAttribute("channelId", channelId);
        return PREFIX + "channel_areaassign.html";
    }

    /**
     * 获取配送商列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition, Integer xyd_st_id) {
        if (null == xyd_st_id) {
            xyd_st_id = 1;
        }
        List<Map<String, Object>> list = this.bs_send_channelDao.list(condition, xyd_st_id);
        return super.warpObject(new Bs_send_channelWarpper(list));
    }

    /**
     * 获取配送商列表
     */
    @RequestMapping(value = "/editList")
    @ResponseBody
    public Object editList(String condition, Integer xyd_st_id) {
        if (null == xyd_st_id) {
            xyd_st_id = 1;
        }
        List<Map<String, Object>> list = this.bs_send_channelDao.list(condition, xyd_st_id);
        Map<String, Object> map = new HashMap();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", list.size());
        map.put("data", super.warpObject(new Bs_send_channelWarpper(list)));
        return map;
    }

    /**
     * 新增配送商
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Bs_send_channel bs_send_channel) {
        bs_send_channel.setXyd_st_id(1);
        bs_send_channel.setXyd_cre_dt(DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        bs_send_channel.setXyd_up_dt(DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        return this.bs_send_channelMapper.insert(bs_send_channel);
    }

    /**
     * 删除配送商
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String bs_send_channelIds) {
        //物理删除
        //this.bs_send_channelMapper.deleteById(bs_send_channelId);
        //逻辑删除
        String[] split = bs_send_channelIds.split(",");
        Integer[] iarray = new Integer[split.length];
        for (int i = 0; i < split.length; i++) {
            iarray[i] = Integer.parseInt(split[i]);
        }
        List<Integer> list = Arrays.asList(iarray);
        this.bs_send_channelDao.deleteByIds(list);
        return SUCCESS_TIP;
    }

    /**
     * 修改配送商
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Bs_send_channel bs_send_channel) {
        bs_send_channel.setXyd_up_dt(DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        this.bs_send_channelMapper.updateById(bs_send_channel);
        return super.SUCCESS_TIP;
    }


    /**
     * 跳转到详情配送商
     */
    @RequestMapping("/bs_send_channel_detail/{bs_send_channelId}")
    public String bs_send_channelDetail(@PathVariable Integer bs_send_channelId, Model model) {
        Bs_send_channel bs_send_channel = this.bs_send_channelDao.queryById(bs_send_channelId);
        model.addAttribute(bs_send_channel);
        List<Map<String, Object>> list10 = bs_send_channelDao.getMap10();
        model.addAttribute("map10", list10);

        return PREFIX + "bs_send_channel_detail.html";
    }

    /**
     * 用户区域分配
     */
    @RequestMapping("/setAreas")
    @ResponseBody
    public Tip setAreas(@RequestParam("channelId") Integer channelId, @RequestParam("ids") String ids) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        String[] strs = ids.split(",");
        for (String string : strs) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("channelId", channelId);
            map.put("area_id", Integer.parseInt(string));
            list.add(map);
        }
        bs_send_channelDao.deleteAreaSC(channelId);
        bs_send_channelDao.insertAreaIdSC(list);
        return SUCCESS_TIP;
    }

    /**
     * 获取地区列表
     */
    @RequestMapping(value = "/channelTreeListById/{channelId}")
    @ResponseBody
    public List<ZTreeNode> userTreeListByUserId(@PathVariable Integer channelId) {

        List<Integer> list = bs_send_channelDao.selectAreaIdById(channelId);
        String areaid = "";
        for (Integer integer : list) {
            areaid = areaid + "," + integer;
        }
        String[] strArray = Convert.toStrArray(",", areaid);
        List<ZTreeNode> channelTreeList = this.bs_send_channelDao.areaTreeListById(strArray, channelId);
        return channelTreeList;
    }

}
