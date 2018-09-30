package wy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import wy.config.properties.XydProperties;

/**
 * SpringBoot方式启动类
 *
 * @author wyframe
 * @Date 2017/5/21 12:06
 */
@SpringBootApplication
public class XydApplication extends WebMvcConfigurerAdapter {

	protected final static Logger logger = LoggerFactory.getLogger(XydApplication.class);

	@Autowired
	XydProperties xydProperties;

	/**
	 * 增加swagger的支持
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		if (xydProperties.getSwaggerOpen()) {
			registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
			registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(XydApplication.class, args);
		logger.info("XydApplication is success!");
	}
}
