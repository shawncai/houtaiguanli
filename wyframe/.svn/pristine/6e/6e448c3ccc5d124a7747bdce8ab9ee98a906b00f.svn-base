package wy.addons.zcgl.xydwx.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import wy.addons.zcgl.xydwx.constant.MessageCons;
import wy.addons.zcgl.xydwx.entity.TextMessage;
import wy.addons.zcgl.xydwx.util.CheckUtil;
import wy.addons.zcgl.xydwx.util.MessageUtil;
@WebServlet("/wx")
public class WxServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			if(MessageCons.MESSAGE_TEXT.equals(msgType)){
				if("1".equals(content)){
					message = MessageUtil.initText(toUserName, fromUserName, "这是1.公众号介绍！");
				}else if("2".equals(content)){
					message = MessageUtil.initText(toUserName, fromUserName, "这是2.联系方式！");
				}else if("?".equals(content)||"？".equals(content)){
					message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.menuText());
				}else if("news".equals(content)){
					message = MessageUtil.initNewsMessage(toUserName, fromUserName);
				}else if("pic".equals(content)){
					message = MessageUtil.initImageMessage(toUserName, fromUserName);
				}else if("music".equals(content)){
					message = MessageUtil.initMusicMessage(toUserName, fromUserName);
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
