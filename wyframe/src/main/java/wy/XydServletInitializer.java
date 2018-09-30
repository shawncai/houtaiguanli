package wy;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * wyframe Web程序启动类
 *
 * @author wyframe
 * @date 2017-05-21 9:43
 */
public class XydServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(XydApplication.class);
    }

}
