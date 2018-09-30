package wy.addons.zcgl.xydwx.util;

import com.thoughtworks.xstream.XStream;
import wy.addons.zcgl.xydwx.constant.MessageCons;
import wy.addons.zcgl.xydwx.entity.*;
import wy.addons.zcgl.xydwx.menu.Button;
import wy.addons.zcgl.xydwx.menu.ClickButton;
import wy.addons.zcgl.xydwx.menu.Menu;
import wy.addons.zcgl.xydwx.menu.ViewButton;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class MessageUtil {

	// xml转map
	public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException {
		Map<String, String> map = new HashMap<String, String>();
		SAXReader reader = new SAXReader();

		InputStream ins = request.getInputStream();

		Document doc = reader.read(ins);
		Element root = doc.getRootElement();
		List<Element> list = root.elements();
		for (Element e : list) {
			map.put(e.getName(), e.getText());
		}
		ins.close();
		return map;
	}

	/**
	 * 文本消息转Xml
	 * 
	 * @param textMessage
	 * @return
	 */
	public static String textMessageToXml(TextMessage textMessage) {
		XStream xstream = new XStream();
		// 替换<xml></xml>
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);

	}

	/**
	 * 组装文本消息
	 * 
	 * @param toUserName
	 * @param fromUserName
	 * @param content
	 * @return
	 */
	public static String initText(String toUserName, String fromUserName, String content) {
		TextMessage text = new TextMessage();
		text.setFromUserName(toUserName);
		text.setToUserName(fromUserName);
		text.setMsgType(MessageCons.MESSAGE_TEXT);
		text.setCreateTime(new Date().getTime());
		text.setContent(content);
		return textMessageToXml(text);
	}

	/**
	 * 主菜单组装
	 * 
	 * @return
	 */
	public static String menuText() {
		StringBuffer sb = new StringBuffer();
		sb.append("欢迎您的关注，请按照菜单提示进行操作:\n\n");
		sb.append("1.公众号介绍\n");
		sb.append("2.联系方式\n\n");
		sb.append("回复?调出此菜单。");
		return sb.toString();
	}

	/**
	 * 图文消息转为XML
	 * 
	 * @param newsMessage
	 * @return
	 */
	public static String newsMessageToXml(NewsMessage newsMessage) {
		XStream xstream = new XStream();
		xstream.alias("xml", newsMessage.getClass());
		xstream.alias("item", new News().getClass());
		return xstream.toXML(newsMessage);
	}

	/**
	 * 单条图文消息组装
	 * 
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public static String initNewsMessage(String toUserName, String fromUserName) {
		String message = null;
		List<News> newList = new ArrayList<News>();
		NewsMessage newsMessage = new NewsMessage();

		News news = new News();
		news.setTitle("公众号介绍");
		news.setDescription("公众号介绍描述");
		news.setPicUrl("http://jmh5.xiaogt.cn/Uploads/pic/8/201709/59ba40b5927a7.jpg");
		news.setUrl("www.baidu.com");
		newList.add(news);

		newsMessage.setToUserName(fromUserName);
		newsMessage.setFromUserName(toUserName);
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(MessageCons.MESSAGE_NEWS);
		newsMessage.setArticles(newList);
		newsMessage.setArticleCount(newList.size());

		message = newsMessageToXml(newsMessage);
		return message;
	}

	/**
	 * 组装图片消息
	 * 
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public static String initImageMessage(String toUserName, String fromUserName) {
		String message = null;
		Image image = new Image();
		image.setMediaId("oRMw0EV8ZxPYGLKbfkkItUMbRAIQvDl02nY0aCSk_vWVyxv-Z4k-rmKUdgtjPX9t");
		ImageMessage imageMessage = new ImageMessage();
		imageMessage.setFromUserName(toUserName);
		imageMessage.setToUserName(fromUserName);
		imageMessage.setMsgType(MessageCons.MESSAGE_IMAGE);
		imageMessage.setCreateTime(new Date().getTime());
		imageMessage.setImage(image);
		message = imageMessageToXml(imageMessage);
		return message;
	}

	/**
	 * 图片消息转为XML
	 * 
	 * @param
	 * @return
	 */
	public static String imageMessageToXml(ImageMessage imageMessage) {
		XStream xstream = new XStream();
		xstream.alias("xml", imageMessage.getClass());
		return xstream.toXML(imageMessage);
	}

	/**
	 * 音乐消息转为XML
	 * 
	 * @param
	 * @return
	 */
	public static String musicMessageToXml(MusicMessage musicMessage) {
		XStream xstream = new XStream();
		xstream.alias("xml", musicMessage.getClass());
		return xstream.toXML(musicMessage);
	}

	/**
	 * 音乐消息组装
	 * 
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public static String initMusicMessage(String toUserName, String fromUserName) {
		String message = null;
		Music music = new Music();
		music.setThumMediaId("kr-MMwMOVFMwubpaC_4dBvQcLM8r1lZ9m29aFJO7L5zPflcT1BklNLaH3iHxCqDD");// TODO
		music.setTitle("相思");
		music.setDescription("这首歌的描述");
		music.setMusicUrl("http://sc1.111ttt.com/2014/1/09/07/2072324498.mp3");// TODO
		music.setHQMusicUrl("http://sc1.111ttt.com/2014/1/09/07/2072324498.mp3");// TODO

		MusicMessage musicMessage = new MusicMessage();
		musicMessage.setFromUserName(toUserName);
		musicMessage.setToUserName(fromUserName);
		musicMessage.setMsgType("music");
		musicMessage.setCreateTime(new Date().getTime());
		musicMessage.setMusic(music);
		message = musicMessageToXml(musicMessage);
		return message;
	}
	/**
	 * 组装自定义菜单
	 * @return
	 */
	public static Menu initMenu(){
		Menu menu = new Menu();
		ClickButton button11 = new ClickButton();
		button11.setName("click菜单");
		button11.setType("click");
		button11.setKey("11");
		
		
		ViewButton button21 = new ViewButton();
		button21.setName("view菜单");
		button21.setType("view");
		button21.setUrl("www.baidu.com");
		
		ClickButton button31 = new ClickButton();
		button31.setName("扫码事件");
		button31.setType("scancode_push");
		button31.setKey("31");
		
		ClickButton button32 = new ClickButton();
		button32.setName("地理位置");
		button32.setType("location_select");
		button32.setKey("32");
		
		Button button = new Button();
		button.setName("菜单");
		button.setSub_button(new Button[]{button31,button32});
		
		menu.setButton(new Button[]{button11,button21,button});
		
		//String menu = JSONObject.toJSONString(menu.toString());
		return menu;
	}
}
