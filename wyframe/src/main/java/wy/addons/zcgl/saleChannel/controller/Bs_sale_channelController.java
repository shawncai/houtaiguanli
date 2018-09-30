package wy.addons.zcgl.saleChannel.controller;

import wy.addons.zcgl.saleChannel.dao.Bs_sale_channelDao;
import wy.addons.zcgl.saleChannel.dao.Bs_sale_channelMapper;
import wy.addons.zcgl.saleChannel.model.Bs_sale_channel;
import wy.addons.zcgl.saleChannel.warpper.Bs_sale_channelWarpper;
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
 * 销售渠道控制器
 *
 * @author wyframe
 * @Date 2017-07-17 16:53:19
 */
@Controller
@RequestMapping("/bs_sale_channel")
public class Bs_sale_channelController extends BaseController {
    private String PREFIX = "/addons/zcgl/saleChannel/";
	@Resource
    Bs_sale_channelDao bs_sale_channelDao;
	
	@Resource
    Bs_sale_channelMapper bs_sale_channelMapper;
    /**
     * 跳转到销售渠道首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "bs_sale_channel.html";
    }

    /**
     * 跳转到添加销售渠道
     */
    @RequestMapping("/bs_sale_channel_add")
    public String bs_sale_channelAdd() {
        return PREFIX + "bs_sale_channel_add.html";
    }

    /**
     * 跳转到修改销售渠道
     */
    @RequestMapping("/bs_sale_channel_update/{bs_sale_channelId}")
    public String bs_sale_channelUpdate(@PathVariable Integer bs_sale_channelId, Model model) {
    
    	Bs_sale_channel bs_sale_channel = this.bs_sale_channelDao.queryById(bs_sale_channelId);
    	model.addAttribute(bs_sale_channel);
		LogObjectHolder.me().set(bs_sale_channel);
        return PREFIX + "bs_sale_channel_edit.html";
    }

    /**
     * 获取销售渠道列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
    List<Map<String, Object>> list = this.bs_sale_channelDao.list(condition);
        return super.warpObject(new Bs_sale_channelWarpper(list));
    }

    /**
     * 新增销售渠道
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Bs_sale_channel bs_sale_channel) {
    
        return this.bs_sale_channelMapper.insert(bs_sale_channel);
    }

    /**
     * 删除销售渠道
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer bs_sale_channelId) {
    	this.bs_sale_channelMapper.deleteById(bs_sale_channelId);
        return SUCCESS_TIP;
    }


    /**
     * 修改销售渠道
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Bs_sale_channel bs_sale_channel) {
    	this.bs_sale_channelMapper.updateById(bs_sale_channel);
        return super.SUCCESS_TIP;
    }

    /**
     * 销售渠道详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
