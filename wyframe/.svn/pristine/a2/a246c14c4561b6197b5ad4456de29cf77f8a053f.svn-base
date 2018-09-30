package wy.addons.zcgl.xydwx.controller;

import wy.addons.zcgl.auto_reply.dao.Wx_auto_replyDao;
import wy.addons.zcgl.xydwx.constant.MessageCons;
import wy.addons.zcgl.xydwx.entity.TextMessage;
import wy.addons.zcgl.xydwx.util.CheckUtil;
import wy.addons.zcgl.xydwx.util.MessageUtil;
import wy.core.base.controller.BaseController;
import org.dom4j.DocumentException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class WxController extends BaseController{
	@Resource
	Wx_auto_replyDao wx_auto_replyDao;
	
	@RequestMapping(value="/wechat",method= RequestMethod.GET)
	public void check(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// TODO Auto-generated method stub
				// 验证服务器的有效性
						PrintWriter out = response.getWriter();
						String signature = request.getParameter("signature");
						String timestamp = request.getParameter("timestamp");
						String nonce = request.getParameter("nonce");
						String echostr = request.getParameter("echostr");
						if (CheckUtil.checkSignature(signature, timestamp, nonce)) {
							out.print(echostr);
						}
	}
	@RequestMapping(value="/wechat",method= RequestMethod.POST)
	public void reply(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		try {
			Map<String,String> map = MessageUtil.xmlToMap(request);
			String fromUserName = map.get("FromUserName");
			String toUserName = map.get("ToUserName");
			String msgType = map.get("MsgType");
			String content = map.get("Content");
			String message = null;
			List<Map<String, Object>> list = wx_auto_replyDao.list(null);
			if(MessageCons.MESSAGE_TEXT.equals(msgType)){
//				if("1".equals(content)){
//					message = MessageUtil.initText(toUserName, fromUserName, "这是1.公众号介绍！");
//				}else if("2".equals(content)){
//					message = MessageUtil.initText(toUserName, fromUserName, "这是2.联系方式！");
//				}else if("?".equals(content)||"？".equals(content)){
//					message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.menuText());
//				}else if("news".equals(content)){
//					message = MessageUtil.initNewsMessage(toUserName, fromUserName);
//				}else if("pic".equals(content)){
//					message = MessageUtil.initImageMessage(toUserName, fromUserName);
//				}else if("music".equals(content)){
//					message = MessageUtil.initMusicMessage(toUserName, fromUserName);
//				}
				for (Map<String, Object> map2 : list) {
						  if(map2.get("key").equals(content)){
							  message = MessageUtil.initText(toUserName, fromUserName, map2.get("reply").toString());
						  }
				}
				TextMessage text = new TextMessage();
				text.setFromUserName(toUserName);
				text.setToUserName(fromUserName);
				text.setMsgType("text");
				text.setCreateTime(new Date().getTime());
				text.setContent("您发送的消息是:"+content);
				if(message==null){
					message  = MessageUtil.textMessageToXml(text);
				}
			}else if(MessageCons.MESSAGE_EVENT.equals(msgType)){
				//获取事件类型
				String eventType = map.get("Event");
				if(MessageCons.MESSAGE_SUBSCRIBE.equals(eventType)){
					message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.menuText());
				}
			}
			out.print(message);
		} catch (DocumentException e) {
			e.printStackTrace();
		}finally{
			if(out!=null){
				out.close();
			}
		}
		
	}	 

}
