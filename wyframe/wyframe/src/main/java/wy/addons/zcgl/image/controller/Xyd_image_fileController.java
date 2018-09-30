package wy.addons.zcgl.image.controller;

import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import wy.addons.zcgl.image.dao.Xyd_image_fileDao;
import wy.addons.zcgl.image.dao.Xyd_image_fileMapper;
import wy.addons.zcgl.image.model.Xyd_image_file;
import wy.common.exception.BizExceptionEnum;
import wy.common.exception.BussinessException;
import wy.config.properties.QiniuProperties;
import wy.config.properties.XydProperties;
import wy.core.base.controller.BaseController;
import wy.core.log.LogObjectHolder;
import wy.addons.zcgl.image.warpper.Xyd_image_fileWarpper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;



/**
 * 图片控制器
 *
 * @author wyframe
 * @Date 2017-11-09 16:30:08
 */
@Controller
@RequestMapping("/xyd_image_file")
public class Xyd_image_fileController extends BaseController {
	private String PREFIX = "/addons/zcgl/image/";
	@Resource
    Xyd_image_fileDao xyd_image_fileDao;

	@Resource
    Xyd_image_fileMapper xyd_image_fileMapper;

	@Resource
	private XydProperties xydProperties;

    @Resource
    private QiniuProperties  qiNiuProperties;

	public static List<Map<String, Object>> paramList = null;

	/**
	 * 跳转到图片首页
	 */
	@RequestMapping("")
	public String index() {
		return PREFIX + "xyd_image_file.html";
	}

	/**
	 * 跳转到添加图片
	 */
	@RequestMapping("/xyd_image_file_add")
	public String xyd_image_fileAdd() {
		return PREFIX + "xyd_image_file_add.html";
	}

	/**
	 * 跳转到添加参数
	 */
	@RequestMapping("/xyd_image_file_add_param")
	public String xyd_image_file_add_param() {
		return PREFIX + "xyd_image_file_add_param.html";
	}

	/**
	 * 跳转到修改图片
	 */
	@RequestMapping("/xyd_image_file_update/{xyd_image_fileId}")
	public String xyd_image_fileUpdate(@PathVariable Integer xyd_image_fileId, Model model) {
		Xyd_image_file xyd_image_file = this.xyd_image_fileDao.queryById(xyd_image_fileId);
		model.addAttribute(xyd_image_file);
		LogObjectHolder.me().set(xyd_image_file);
		return PREFIX + "xyd_image_file_edit.html";
	}

	/**
	 * 跳转到详情图片
	 */
	@RequestMapping("/xyd_image_file_detail/{xyd_image_fileId}")
	public String xyd_image_fileDetail(@PathVariable Integer xyd_image_fileId, Model model) {
		Xyd_image_file xyd_image_file = this.xyd_image_fileDao.queryById(xyd_image_fileId);
		model.addAttribute(xyd_image_file);
		LogObjectHolder.me().set(xyd_image_file);
		return PREFIX + "xyd_image_file_detail.html";

	}

	/**
	 * 获取图片列表
	 */
	@RequestMapping(value = "/list")
	@ResponseBody
	public Object list(String condition) {
		paramList = null;
		List<Map<String, Object>> list = this.xyd_image_fileDao.list(condition);
		return super.warpObject(new Xyd_image_fileWarpper(list));
	}

	/**
	 * 新增图片
	 */
	@RequestMapping(value = "/add")
	@ResponseBody
	public Object add(Xyd_image_file xyd_image_file) {
		return this.xyd_image_fileMapper.insert(xyd_image_file);
	}

	/**
	 * 删除图片
	 */
	@RequestMapping(value = "/delete")
	@ResponseBody
	public Object delete(@RequestParam Integer xyd_image_fileId) {
		this.xyd_image_fileMapper.deleteById(xyd_image_fileId);
		return SUCCESS_TIP;
	}

	/**
	 * 修改图片
	 */
	@RequestMapping(value = "/update")
	@ResponseBody
	public Object update(Xyd_image_file xyd_image_file) {
		this.xyd_image_fileMapper.updateById(xyd_image_file);
		paramList = null;
		return super.SUCCESS_TIP;
	}

	/**
	 * 上传图片(上传到项目的webapp/static/img)
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/upload")
	@ResponseBody
	public String upload(@RequestPart("file") MultipartFile file) {
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        //文件后缀名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        String key ="";
        String fileName = UUID.randomUUID().toString() + "."+"jpg";
		String pictureName = UUID.randomUUID().toString() + ".jpg";
		try {
			String fileSavePath = xydProperties.getFileUploadPath();
            String accessKey = qiNiuProperties.getAccessKey();
            String secretKey = qiNiuProperties.getSecretKey();
            String bucket = qiNiuProperties.getBucket();
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
            System.err.println(putRet.key);
            System.err.println(putRet.hash);
            key=putRet.key;
        } catch (Exception e) {
			throw new BussinessException(BizExceptionEnum.UPLOAD_ERROR);
		}
		return key;
	}


}
