package wy.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import wy.rest.modular.auth.filter.AuthFilter;

/**
 * web配置
 *
 * @author fengshuonan
 * @date 2017-08-23 15:48
 */
@Configuration
public class WebConfig {

    @Bean
    public AuthFilter jwtAuthenticationTokenFilter() {
        return new AuthFilter();
    }
}
