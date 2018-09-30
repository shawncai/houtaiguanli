package wy.rest.modular.auth.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;
import wy.core.support.HttpKit;
import wy.core.util.MD5Util;
import wy.rest.common.exception.BizExceptionEnum;
import wy.rest.common.exception.BussinessException;
import wy.rest.config.properties.JwtProperties;
import wy.rest.modular.auth.security.DataSecurityAction;
import wy.rest.modular.auth.util.JwtTokenUtil;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

/**
 * 带签名的http信息转化器
 *
 * @author fengshuonan
 * @date 2017-08-25 15:42
 */
public class WithSignMessageConverter extends FastJsonHttpMessageConverter4 {

    @Autowired
    JwtProperties jwtProperties;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Resource(name="base64SecurityAction")
    DataSecurityAction dataSecurityAction;

    @Override
    public Object read(Type type, Class<?> contextClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        System.err.println("WithSignMessageConverter");
        InputStream in = inputMessage.getBody();
        Object o = JSON.parseObject(in, super.getFastJsonConfig().getCharset(), BaseTransferEntity.class, super.getFastJsonConfig().getFeatures());

        //先转化成原始的对象
        BaseTransferEntity baseTransferEntity = (BaseTransferEntity) o;

        //校验签名
        String token = HttpKit.getRequest().getHeader(jwtProperties.getHeader()).substring(7);
        String md5KeyFromToken = jwtTokenUtil.getMd5KeyFromToken(token);

        String object = baseTransferEntity.getObject().toString();
        String json = dataSecurityAction.unlock(object);
        String encrypt = MD5Util.encrypt(object + md5KeyFromToken);
        if (encrypt.equals(baseTransferEntity.getSign())) {
            System.out.println("签名校验成功!");
        } else {
            System.out.println("签名校验失败,数据被改动过!");
            throw new BussinessException(BizExceptionEnum.SIGN_ERROR);
        }

        //校验签名后再转化成应该的对象
        return JSON.parseObject(json, type);
    }
}
