package com.wy.xyd.jwt;

import com.alibaba.fastjson.JSON;
import wy.core.util.MD5Util;
import wy.rest.addons.zcgl.xgt_vendor.model.Xgt_goods_prd_vendor;
import wy.rest.modular.auth.converter.BaseTransferEntity;
import wy.rest.modular.auth.security.impl.Base64SecurityAction;

/**
 * jwt测试
 *
 * @author fengshuonan
 * @date 2017-08-21 16:34
 */
public class DecryptTest {

    public static void main(String[] args) {

        String salt = "2lrzr7";

//        SimpleObject simpleObject = new SimpleObject();
//        simpleObject.setUser("wy");
//        simpleObject.setAge(12);
//        simpleObject.setName("ffff");
//        simpleObject.setTips("code");
//        Bs_sale_channel bs_sale_channel = new Bs_sale_channel();
//        bs_sale_channel.setChnl_nm("测试");
//        bs_sale_channel.setChnl_phone("110");


        Xgt_goods_prd_vendor xgt_goods_prd_vendor = new Xgt_goods_prd_vendor();
        xgt_goods_prd_vendor.setPrd_vendor_nm("111");
//        xgt_goods_prd_vendor.setPrd_vendor_alias("2222");

        String jsonString = JSON.toJSONString(xgt_goods_prd_vendor);
        System.err.println("jsonString："+jsonString);
        String encode = new Base64SecurityAction().doAction(jsonString);
        System.err.println("encode:"+encode);
        String md5 = MD5Util.encrypt(encode + salt);
        System.err.println("md5:"+md5);
        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
        baseTransferEntity.setObject(encode);
        baseTransferEntity.setSign(md5);
        System.out.println(JSON.toJSONString(baseTransferEntity));
    }
}
