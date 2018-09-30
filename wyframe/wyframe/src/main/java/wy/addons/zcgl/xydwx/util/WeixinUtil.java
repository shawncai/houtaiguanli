/*
package wy.addons.zcgl.xydwx.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;
import wy.addons.zcgl.xydwx.entity.AccessToken;

public class WeixinUtil {
	//销广通
//	private static final String APPID = "wx83439490d2a7066a";
//	private static final String APPSECRET = "59498b2fa59d3e7bc12542d5f02f95d9";
//	private static final String APPID = "wx9dd8b6b7c6578561";
//	private static final String APPSECRET = "c02d2c24e3dbdadc15417b52509f311a";
//	//
//	private static final String APPID = "wx02c3c4592d6b1e99";
//	private static final String APPSECRET = "ffe5086d96fb08391fee949f98edd720";
//	public static final String TOKEN="wyxyd";
//	public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	private static final String UPLOAD_URL = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
	private static final String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	private static final String QUERY_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	private static final String DELETE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

	*/
/**
	 * Get请求
	 * 
	 * @param url
	 * @return
	 *//*

	public static JSONObject doGetStr(String url) {

		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		JSONObject jsonObject = null;
		try {
			HttpResponse response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String result = EntityUtils.toString(entity, "UTF-8");
				jsonObject = JSONObject.parseObject(result);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	*/
/**
	 * Post请求
	 * 
	 * @param url
	 * @param outStr
	 * @return
	 *//*

	public static JSONObject doPostStr(String url, String outStr) {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		JSONObject jsonObject = null;
		try {
			httpPost.setEntity(new StringEntity(outStr, "UTF-8"));
			HttpResponse response = httpClient.execute(httpPost);
			String result = EntityUtils.toString(response.getEntity(), "UTF-8");
			jsonObject = JSONObject.parseObject(result);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	*/
/**
	 * 获取Access_Token
	 * 
	 * @return
	 *//*

	public static AccessToken getAccessToken(String URL, String APPID, String APPSECRET) {
		AccessToken token = new AccessToken();
		String url = URL.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
		JSONObject jsonObject = doGetStr(url);
		System.err.println(jsonObject.toJSONString());
		if (jsonObject != null) {
			token.setAccess_token(jsonObject.getString("access_token"));
			token.setExpires_in(jsonObject.getInteger("expires_in"));
		}
		return token;
	}

	public static String upload(String filePath, String accessToken, String type) throws IOException {
		File file = new File(filePath);
		if (!file.exists() || !file.isFile()) {
			throw new IOException("文件不存在");
		}

		String url = UPLOAD_URL.replace("ACCESS_TOKEN", accessToken).replace("TYPE", type);
		URL urlObj = new URL(url);
		// 链接
		HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
		con.setRequestMethod("POST");
		con.setDoInput(true);
		con.setDoOutput(true);
		con.setUseCaches(false);

		// 设置请求头信息
		con.setRequestProperty("Connection", "Keep-Alive");
		con.setRequestProperty("Charset", "UTF-8");

		// 设置边界
		String BOUNDARY = "---------" + System.currentTimeMillis();
		con.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + BOUNDARY);

		StringBuilder sb = new StringBuilder();
		sb.append("--");
		sb.append(BOUNDARY);
		sb.append("\r\n");
		sb.append("Cotent-Disposition:form-data;name=\"file\";filename=\"" + file.getName() + "\"\r\n");
		sb.append("Content-Type:application/octet-stream\r\n\r\n");

		byte[] head = sb.toString().getBytes("utf-8");

		// 获得输出流
		OutputStream out = new DataOutputStream(con.getOutputStream());
		// 输出表头
		out.write(head);

		// 文件正文部分
		// 把文件以流的方式推入到url中
		DataInputStream in = new DataInputStream(new FileInputStream(file));
		int bytes = 0;
		byte[] bufferOut = new byte[1024];
		while ((bytes = in.read(bufferOut)) != -1) {
			out.write(bufferOut, 0, bytes);
		}
		in.close();

		// 结尾部分
		byte[] foot = ("\r\n--" + BOUNDARY + "\r\n").getBytes("utf-8");// 定义最后数据分割线

		out.write(foot);
		out.flush();
		out.close();

		StringBuffer buffer = new StringBuffer();
		BufferedReader reader = null;
		String result = null;
		try {
			// 定义BufferedReader输入流来读取URL的响应
			reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			if (result == null) {
				result = buffer.toString();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
		}

		JSONObject jsonObj = JSONObject.parseObject(result);
		System.out.println(jsonObj);
		String typeName = "media_id";
		if (!"image".equals(type)) {
			typeName = type + "_media_id";
		}
		String mediaId = jsonObj.getString(typeName);
		return mediaId;
	}

	*/
/**
	 * 创建菜单
	 * 
	 * @param access_token
	 * @param menu
	 * @return
	 *//*

	public static int createMenu(String access_token, String menu) {
		int result = 0;
		String url = CREATE_MENU_URL.replace("ACCESS_TOKEN", access_token);
		JSONObject jsonObject = doPostStr(url, menu);
		if (jsonObject != null) {
			result = jsonObject.getIntValue("errcode");
		}
		return result;
	}

	*/
/**
	 * 查询菜单
	 * 
	 * @param access_token
	 * @return
	 *//*

	public static JSONObject queryMenu(String access_token) {
		String url = QUERY_MENU_URL.replace("ACCESS_TOKEN", access_token);
		JSONObject jsonObject = doGetStr(url);
		return jsonObject;
	}

	*/
/**
	 * 删除菜单
	 * 
	 * @param access_token
	 * @return
	 *//*

	public static int deleteMenu(String access_token) {
		String url = DELETE_MENU_URL.replace("ACCESS_TOKEN", access_token);
		JSONObject jsonObject = doGetStr(url);
		int result = 0;
		if (jsonObject != null) {
			result = jsonObject.getIntValue("errcode");
		}
		return result;
	}
}
*/
