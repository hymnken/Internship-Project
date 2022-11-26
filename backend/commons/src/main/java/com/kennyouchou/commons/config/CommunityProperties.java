package com.kennyouchou.commons.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 社区配置类
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-28 14:23:05
 */
@Component
@ConfigurationProperties(
        prefix = "kennyouchou.community"
)
@Data
public class CommunityProperties {

    /**
     * 异常体温
     */
    private String abnormalBodyTemperature = "37.5";

    /**
     * 连续健康天数节点(超过此节点，则认为是健康)
     */
    private Integer consecutiveDays = 7;



}
