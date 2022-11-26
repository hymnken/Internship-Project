package com.kennyouchou.author.shiro.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>
 * jwt令牌配置
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-14 09:25:25
 */
@Data
@Component
@ConfigurationProperties(prefix = "kennyouchou.shiro.jwt")
public class JWTProperties {

    /**
     * 签名密码
     * @since 2022/10/14 9:26
     **/
    private String hexEncodedSecretKey = "helloworld-community-system";

    /**
     * 是否仅仅使用jwt令牌一种方式登录
     * @since 2022/10/14 16:55
     **/
    private boolean isOnlyJwt = true;
}
