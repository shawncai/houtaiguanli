package wy.rest.modular.auth.controller;

import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import wy.core.base.controller.BaseController;
import wy.rest.config.properties.XydProperties;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.UUID;

/**
 * 系统管理员控制器
 *
 * @author fengshuonan
 * @Date 2017年1月11日 下午1:08:17
 */
@Controller
@RequestMapping("/mgr")
public class UserMgrController extends BaseController {

    private static String PREFIX = "/xydframe/user/";

    @Resource
    private XydProperties xydProperties;
	/**
	 * 上传图片(上传到项目的webapp/static/img)
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/upload")
	@ResponseBody
	public String upload(@RequestPart("file") MultipartFile file) {
        System.err.println(file.getName());
        System.err.println(file.getSize());
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        //文件后缀名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        String key ="";
        String fileName = UUID.randomUUID().toString() +".jpg";
        String pictureName = UUID.randomUUID().toString() + ".jpg";
        try {
//            String fileSavePath = xydProperties.getFileUploadPath();
            String accessKey = xydProperties.getAccessKey();
            System.err.println("accessKey："+accessKey);
            String secretKey = xydProperties.getSecretKey();
            String bucket = xydProperties.getBucket();
//			file.transferTo(new File(fileSavePath + pictureName));
            InputStream is = file.getInputStream();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int len = -1;
            while ((len = is.read(b)) != -1) {
                bos.write(b, 0, len);
            }
            byte[] uploadBytes = bos.toByteArray();
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);
            Response response = uploadManager.put(uploadBytes, fileName, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            key=putRet.key;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return key;
	}
}