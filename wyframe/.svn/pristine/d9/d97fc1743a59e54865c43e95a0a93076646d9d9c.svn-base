package wy.addons.zcgl.sendChannel.controller;

import wy.addons.zcgl.sendChannel.dao.Bs_send_channelDao;
import wy.addons.zcgl.sendChannel.dao.Bs_send_channelMapper;
import wy.addons.zcgl.sendChannel.model.Bs_send_channel;
import wy.addons.zcgl.sendChannel.warpper.Bs_send_channelWarpper;
import wy.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import wy.core.log.LogObjectHolder;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 配送商控制器
 *
 * @author wyframe
 * @Date 2017-07-17 16:44:18
 */
@Controller
@RequestMapping("/bs_send_channel")
public class Bs_send_channelController extends BaseController {
    private String PREFIX = "/addons/zcgl/sendChannel/";
	@Resource
    Bs_send_channelDao bs_send_channelDao;
	
	@Resource
	Bs_send_channelMapper bs_send_channelMapper;
    /**
     * 跳转到配送商首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "bs_send_channel.html";
    }

    /**
     * 跳转到添加配送商
     */
    @RequestMapping("/bs_send_channel_add")
    public String bs_send_channelAdd() {
        return PREFIX + "bs_send_channel_add.html";
    }

    /**
     * 跳转到修改配送商
     */
    @RequestMapping("/bs_send_channel_update/{bs_send_channelId}")
    public String bs_send_channelUpdate(@PathVariable Integer bs_send_channelId, Model model) {
    
    	Bs_send_channel bs_send_channel = this.bs_send_channelDao.queryById(bs_send_channelId);
    	model.addAttribute(bs_send_channel);
		LogObjectHolder.me().set(bs_send_channel);
        return PREFIX + "bs_send_channel_edit.html";
    }

    /**
     * 获取配送商列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
    List<Map<String, Object>> list = this.bs_send_channelDao.list(condition);
        return super.warpObject(new Bs_send_channelWarpper(list));
    }

    /**
     * 新增配送商
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Bs_send_channel bs_send_channel) {
    
        return this.bs_send_channelMapper.insert(bs_send_channel);
    }

    /**
     * 删除配送商
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer bs_send_channelId) {
    	this.bs_send_channelMapper.deleteById(bs_send_channelId);
        return SUCCESS_TIP;
    }


    /**
     * 修改配送商
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Bs_send_channel bs_send_channel) {
    	this.bs_send_channelMapper.updateById(bs_send_channel);
        return super.SUCCESS_TIP;
    }

    /**
     * 配送商详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
