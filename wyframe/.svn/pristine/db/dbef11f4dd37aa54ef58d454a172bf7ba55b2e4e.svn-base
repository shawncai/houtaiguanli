package wy.core.beetl;

import org.beetl.ext.spring.BeetlGroupUtilConfiguration;

import wy.core.util.KaptchaUtil;
import wy.core.util.ToolUtil;

public class BeetlConfiguration extends BeetlGroupUtilConfiguration {

    @Override
    public void initOther() {

        groupTemplate.registerFunctionPackage("shiro", new ShiroExt());
        groupTemplate.registerFunctionPackage("tool", new ToolUtil());
        groupTemplate.registerFunctionPackage("kaptcha", new KaptchaUtil());

    }

}
